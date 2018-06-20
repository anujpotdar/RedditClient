package com.anuj.potdar.redditclient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anuj.potdar.redditclient.databinding.ItemFeedBinding;
import com.anuj.potdar.redditclient.model.Child;
import com.squareup.picasso.Picasso;

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

//            if(child.getData().getPostHint().equalsIgnoreCase("image")){

                    Picasso.get()
                            .load(child.getData().getUrl())
                            .centerCrop()
                            .error(R.drawable.ic_launcher_background)
                            .fit()
                            .into(binding.contentImage);

//            }
        }
    }

}
