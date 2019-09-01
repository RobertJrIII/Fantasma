package com.dev.rj3.fantasma.fragments.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.emoji.widget.EmojiTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.dev.rj3.fantasma.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ArrayList<Post> mPosts;
    private Context context;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(v);

        return postViewHolder;
    }

    public PostAdapter(Context context, ArrayList<Post> postArrayList) {
        mPosts = postArrayList;
        this.context = context;


    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = mPosts.get(position);
        String url = post.getThumbnail_url();
        ImageView imageView = holder.mImageView;
        holder.mTitle.setText(post.getTitle());
        holder.mSubreddit.setText(post.getSubreddit());

        if (url.equals("self") || url.equals("default")) {
            imageView.setVisibility(View.GONE);

        } else {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(context).load(url).into(imageView);
        }


    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        public EmojiTextView mTitle;
        public EmojiTextView mSubreddit;
        public ImageView mImageView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.postTitle);
            mSubreddit = itemView.findViewById(R.id.subRedditName);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }


}
