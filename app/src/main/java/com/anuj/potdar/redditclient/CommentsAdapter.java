package com.anuj.potdar.redditclient;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.anuj.potdar.redditclient.databinding.ItemCommentBinding;

import java.util.ArrayList;

/**
 * Created by potda on 6/24/2018.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    ArrayList<Comment> comments;
    Context context;
    LayoutInflater layoutInflater;

    public CommentsAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public CommentsAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCommentBinding commentItemBinding = ItemCommentBinding.inflate(layoutInflater,parent,false);
        return new CommentViewHolder(commentItemBinding);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.CommentViewHolder holder, int position) {
        holder.bindItem(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        ItemCommentBinding binding;

        public CommentViewHolder(ItemCommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindItem(final Comment comment){
            binding.executePendingBindings();

            binding.authorTextView.setText(comment.author);
            binding.commentTextView.setText(comment.htmlText);
            binding.scoreTextView.setText(comment.points + " points");





            if (comment.visible == true){
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                binding.mainCard.setCardBackgroundColor(context.getResources().getColor(R.color.cardBackground));
                params.setMargins(convertdpToPx(comment.level*20) + convertdpToPx(3), convertdpToPx(3), convertdpToPx(3), convertdpToPx(3));

                binding.mainCard.setLayoutParams(params);
            }else {
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        convertdpToPx(1)
                );
                binding.mainCard.setCardBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                binding.mainCard.setLayoutParams(params);
            }

        }


        private int convertdpToPx(int dp){
            Resources r = context.getResources();
            int px = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp,
                    r.getDisplayMetrics()
            );
            return  px;
        }
    }
}
