package com.anuj.potdar.redditclient;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anuj.potdar.redditclient.databinding.ItemFeedBinding;
import com.anuj.potdar.redditclient.model.Child;
import com.anuj.potdar.redditclient.viewImage.ContentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by potda on 6/19/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder>{

    private ArrayList<Child> children;
    private LayoutInflater inflater;
    private Context context;

    public static String SELFTEXT = "selftext";
    public static String IMAGE = "image";
    public static String VIDEO = "video";

    public FeedAdapter(ArrayList<Child> children, Context context) {
        this.children = children;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFeedBinding itemFeedBinding = ItemFeedBinding.inflate(inflater,parent,false);
        return new FeedViewHolder(itemFeedBinding);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.bindItem(children.get(position));
    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{

        private final ItemFeedBinding binding;

        public FeedViewHolder(ItemFeedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindItem(Child child) {
            binding.executePendingBindings();

            binding.feedTitle.setText(child.getData().getTitle());
            binding.author.setText(child.getData().getAuthor());
            binding.subReditPefix.setText(child.getData().getSubredditNamePrefixed());
            binding.score.setText(String.valueOf(child.getData().getScore()));

            setContent(child);

            setupComments(child);
        }

        private void setupComments(final Child child) {
            binding.comment.setText(String.valueOf(child.getData().getNumComments()));
            binding.mainRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CommentsActivity.class).putExtra("child",child);
                    context.startActivity(intent);
                }
            });
        }

        private void setContent(final Child child) {
            if(child.getData().getPostHint()!=null){
                if(child.getData().getPostHint().equalsIgnoreCase("image")) {
                    binding.webPage.setVisibility(View.GONE);
                    setupImage(child);
                }else if(child.getData().getIsSelf()){
                    binding.selfText.setVisibility(View.VISIBLE);
                    binding.selfText.setText(child.getData().getSelftext());
                    binding.contentImage.setVisibility(View.GONE);
                    binding.webPage.setVisibility(View.GONE);
                }else if(child.getData().getPostHint().equalsIgnoreCase("rich:video")){
                    binding.contentImage.setVisibility(View.GONE);
                    binding.selfText.setVisibility(View.GONE);
                    binding.webPage.setVisibility(View.VISIBLE);
                    setupWebContent(child);
                }
                else{
                    binding.contentImage.setVisibility(View.GONE);
                    binding.selfText.setVisibility(View.GONE);
                    binding.webPage.setVisibility(View.VISIBLE);
                    setupWebContent(child);
                }
            }else{
                if(child.getData().getIsSelf()!=null){
                    setupSelfText(child);
                    binding.webPage.setVisibility(View.GONE);
                }else {
                    binding.webPage.setVisibility(View.VISIBLE);
                    setupWebContent(child);
                }
            }
        }

        private void setupVideo(String url) {
//            ExtractorMediaSource mediaSource = new ExtractorMediaSource.
//            binding.video.setOnC
        }

        private void setupWebContent(final Child child){

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .dontTransform()
                    .placeholder(R.drawable.imageloading)
                    .error(R.drawable.imageloading);

            Glide.with(context).load(child.getData().getThumbnail()).transition(withCrossFade()).apply(options).into(binding.thumbnail);

            binding.webPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(child.getData().getUrl()));
                    context.startActivity(i);
                }
            });
        }

        private void setupSelfText(final Child child) {
            if(child.getData().getIsSelf()) {
                binding.selfText.setVisibility(View.VISIBLE);
                binding.selfText.setText(child.getData().getSelftext());
                binding.contentImage.setVisibility(View.GONE);

                binding.selfText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(context, ContentActivity.class).putExtra("type", SELFTEXT);
                        myIntent.putExtra("child",child);
                        context.startActivity(myIntent);
                    }
                });
            }
            binding.contentImage.setVisibility(View.GONE);
        }

        private void setupImage(final Child child) {
            binding.contentImage.setVisibility(View.VISIBLE);
            binding.selfText.setVisibility(View.GONE);

            RequestOptions options = new RequestOptions()
//                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .dontTransform()
                    .placeholder(R.drawable.imageloading)
                    .error(R.drawable.imageloading);

            Glide.with(context).load(child.getData().getUrl()).transition(withCrossFade()).apply(options).into(binding.contentImage);

            binding.contentImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, ContentActivity.class).putExtra("type", IMAGE);
                    myIntent.putExtra("child",child);
                    context.startActivity(myIntent);
                }
            });
        }
    }



}
