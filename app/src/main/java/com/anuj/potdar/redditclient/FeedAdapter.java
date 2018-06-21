package com.anuj.potdar.redditclient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anuj.potdar.redditclient.databinding.ItemFeedBinding;
import com.anuj.potdar.redditclient.model.Child;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by potda on 6/19/2018.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder>{

    private ArrayList<Child> children;
    private LayoutInflater inflater;
    private Context context;

    public FeedAdapter(ArrayList<Child> children, Context context) {
        this.children = children;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.item_feed, parent, false);
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
            binding.comment.setText(String.valueOf(child.getData().getNumComments()));
            binding.score.setText(String.valueOf(child.getData().getScore()));

            if(child.getData().getPostHint()!=null){
                if(child.getData().getPostHint().equalsIgnoreCase("image")) {

                    binding.contentImage.setVisibility(View.VISIBLE);
                    binding.selfText.setVisibility(View.GONE);

                    RequestOptions options = new RequestOptions()
    //                    .centerCrop()
    //                    .fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                            .dontTransform()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);

                    Glide.with(context).load(child.getData().getUrl()).apply(options).into(binding.contentImage);
                }else if(child.getData().getIsSelf()){
                    binding.selfText.setVisibility(View.VISIBLE);
                    binding.selfText.setText(child.getData().getSelftext());
                    binding.contentImage.setVisibility(View.GONE);
                }else{
                    binding.contentImage.setVisibility(View.GONE);
                    binding.selfText.setVisibility(View.GONE);
                }
            }else{
                if(child.getData().getIsSelf()) {
                    binding.selfText.setVisibility(View.VISIBLE);
                    binding.selfText.setText(child.getData().getSelftext());
                    binding.contentImage.setVisibility(View.GONE);
                }
                binding.contentImage.setVisibility(View.GONE);
            }




//            }
        }
    }

}
