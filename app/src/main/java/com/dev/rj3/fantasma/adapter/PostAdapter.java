package com.dev.rj3.fantasma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.emoji.widget.EmojiTextView;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.posts.Post;


public class PostAdapter extends PagedListAdapter<Post, PostAdapter.PostViewHolder> {
    private Context context;


    public PostAdapter(Context context) {
        super(Post.CALLBACK);
        //  mPosts = postArrayList;

        this.context = context;


    }

    @Override
    public void submitList(PagedList<Post> pagedList) {
        super.submitList(pagedList);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(v);
        return postViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = getItem(position);
        String url = post.getThumbnail_url();
        ImageView imageView = holder.mImageView;
        holder.mTitle.setText(post.getTitle());
        holder.mSubreddit.setText(post.getSubreddit());

        if (url.equals("self") || url.equals("default") || url.equals("")) {
            imageView.setVisibility(View.GONE);

        } else {

//            if (post.getThumbnail_url().equals("nsfw")) {
////TODO add NSFW Image here for now imageview is gone
//                imageView.setVisibility(View.GONE);
//
//            } else {
                imageView.setVisibility(View.VISIBLE);
                Glide.with(context).load(url).centerInside().into(imageView);
           // }
        }


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
