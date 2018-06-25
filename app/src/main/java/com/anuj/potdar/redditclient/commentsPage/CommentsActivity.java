package com.anuj.potdar.redditclient.commentsPage;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.anuj.potdar.redditclient.APIInterface;
import com.anuj.potdar.redditclient.R;
import com.anuj.potdar.redditclient.databinding.ActivityCommentsBinding;
import com.anuj.potdar.redditclient.model.Child;
import com.anuj.potdar.redditclient.utils.ItemClickSupport;
import com.anuj.potdar.redditclient.viewImage.ContentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CommentsActivity extends AppCompatActivity {

    private Child child;
    private ActivityCommentsBinding binding;
    private Context context;
    private String commentsURL;
    public LayoutInflater mInflater;
    private String BASE_URL = "https://www.reddit.com";
    ArrayList<Comment> comments;
    CommentsActivity activity;
    CommentsAdapter adapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_comments);

        context = this;

        mInflater = getLayoutInflater();

        activity = this;

        child = (Child) getIntent().getSerializableExtra("child");

        commentsURL = child.getData().getPermalink();

        setupSwipeToRefresh();

        setupFeedInfo();

        setupRecyclerView();

        binding.progressBar.setVisibility(View.VISIBLE);
        getComments();

        setupRetryButton();

        setContentView(binding.getRoot());
    }

    private void setupRetryButton() {
        binding.retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getComments();
                binding.errorView.setVisibility(View.GONE);
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setupSwipeToRefresh() {

        binding.swipeToRefresh.setColorSchemeResources(R.color.colorPrimary);

        binding.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getComments();
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setupRecyclerView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);

        binding.recyclerView.setLayoutManager(layoutManager);

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int visibility = (layoutManager.findFirstCompletelyVisibleItemPosition() > 12) ? View.VISIBLE : View.GONE;
                binding.scrollToTop.setVisibility(visibility);
            }
        });

        binding.scrollToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.recyclerView.smoothScrollToPosition(0);
            }
        });

        ItemClickSupport.addTo(binding.recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                if(comments.get(position).contract){
                    contract(position,false);
                    comments.get(position).contract = !comments.get(position).contract;
                }else{
                    contract(position,true);
                    comments.get(position).contract = !comments.get(position).contract;
                }
            }
        });
    }

    private void contract(int position,Boolean expand){
        for (int i=position+1;i<comments.size();i++){
            if (comments.get(i).level>comments.get(position).level){
                comments.get(i).visible = expand;
                adapter.notifyItemChanged(i);
            }else {
//                adapter.notifyDataSetChanged();
                return;
            }
        }
//        adapter.notifyDataSetChanged();
    }

    private void setupFeedInfo() {
        binding.feedTitle.setText(child.getData().getTitle());
        binding.comment.setText(String.valueOf(child.getData().getNumComments()));
        binding.author.setText(child.getData().getAuthor());
        binding.subReditPefix.setText(child.getData().getSubredditNamePrefixed());
        binding.score.setText(String.valueOf(child.getData().getScore()));
        setupThumbnail();
    }

    private void setupThumbnail() {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .dontTransform()
                .placeholder(R.drawable.imageloading)
                .error(R.drawable.imageloading);

        Glide.with(this).load(child.getData().getThumbnail()).transition(withCrossFade()).apply(options).into(binding.postPic);

        if(child.getData().getPostHint()!=null){
            if(child.getData().getPostHint().equalsIgnoreCase("image")) {
                binding.postPic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(context, ContentActivity.class).putExtra("type", "image");
                        myIntent.putExtra("child",child);
                        context.startActivity(myIntent);
                    }
                });
            }else if(child.getData().getIsSelf()){
                setupSelfText();
            }else if(child.getData().getPostHint().equalsIgnoreCase("rich:video")){
                binding.postPic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(context, ContentActivity.class).putExtra("type", "video");
                        myIntent.putExtra("child",child);
                        context.startActivity(myIntent);
                    }
                });
            }
        }else{
            if(child.getData().getIsSelf()!=null){
                setupSelfText();
            }
        }
        
        
    }

    private void setupSelfText() {
        binding.postPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, ContentActivity.class).putExtra("type", "selftext");
                myIntent.putExtra("child",child);
                context.startActivity(myIntent);
            }
        });
    }

    private Comment loadComment(JSONObject data, int level){
        Comment comment=new Comment();
        try{
            comment.htmlText = data.getString("body");
            comment.author = data.getString("author");
            comment.points = (data.getInt("ups")
                    - data.getInt("downs"))
                    + "";
            comment.postedOn = new Date((long)data
                    .getDouble("created_utc"))
                    .toString();
            comment.level=level;
        }catch(Exception e){
            Log.d("ERROR","Unable to parse comment : "+e);
        }
        return comment;
    }

    private void process(ArrayList<Comment> comments
            , JSONArray c, int level)
            throws Exception {
        for(int i=0;i<c.length();i++){
            if(c.getJSONObject(i).optString("kind")==null)
                continue;
            if(c.getJSONObject(i).optString("kind").equals("t1")==false)
                continue;
            JSONObject data=c.getJSONObject(i).getJSONObject("data");
            Comment comment=loadComment(data,level);
            if(comment.author!=null) {
                comments.add(comment);
                addReplies(comments,data,level+1);
            }
        }
    }

    private void addReplies(ArrayList<Comment> comments,
                            JSONObject parent, int level){
        try{
            if(parent.get("replies").equals("")){
                return;
            }
            JSONArray r=parent.getJSONObject("replies")
                    .getJSONObject("data")
                    .getJSONArray("children");
            process(comments, r, level);
        }catch(Exception e){
            Log.d("ERROR","addReplies : "+e);
        }
    }


    private void getComments(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        final Call<ResponseBody> commentsCall = apiInterface.getCommentsFeed(commentsURL.substring(1));

        commentsCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response!=null){
                    if(response.body()!=null){
                        binding.progressBar.setVisibility(View.GONE);
                        binding.swipeToRefresh.setRefreshing(false);
                        binding.errorView.setVisibility(View.GONE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        comments = handleComments(response);
                        adapter = new CommentsAdapter(comments,context);
                        binding.recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                        binding.swipeToRefresh.setRefreshing(false);
                        binding.errorView.setVisibility(View.VISIBLE);
                        binding.recyclerView.setVisibility(View.GONE);
            }
        });
    }

    private ArrayList<Comment> handleComments(Response<ResponseBody> response){
        final ArrayList<Comment> comments=new ArrayList<Comment>();

        try {
            String jsonString = response.body().string();
            JSONArray r=new JSONArray(jsonString)
                    .getJSONObject(1)
                    .getJSONObject("data")
                    .getJSONArray("children");

            process(comments, r, 0);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comments;
    }


}
