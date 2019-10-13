package com.dev.rj3.fantasma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji.widget.EmojiTextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.model.children.Entry;


public class PostAdapter extends PagedListAdapter<Entry, PostAdapter.PostViewHolder> {
    private Context context;


    public PostAdapter(Context context) {
        super(DIFF_CALLBACK);

        this.context = context;


    }

    private static final DiffUtil.ItemCallback<Entry> DIFF_CALLBACK = new DiffUtil.ItemCallback<Entry>() {
        @Override
        public boolean areItemsTheSame(@NonNull Entry oldItem, @NonNull Entry newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Entry oldItem, @NonNull Entry newItem) {
            return (oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getAuthor().equals(newItem.getAuthor()) && oldItem.getSubreddit_name_prefixed().equals(newItem.getSubreddit_name_prefixed()));
        }
    };

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        PostViewHolder postViewHolder;
        postViewHolder = new PostViewHolder(v);
        return postViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {


        Entry post = getItem(position);
       String url = post.getThumbnail();
        ImageView imageView = holder.mImageView;
        holder.mTitle.setText(post.getTitle());
        holder.mSubreddit.setText(post.getSubreddit_name_prefixed());
        holder.mAuthor.setText(post.getAuthor());
        if (url.equals("self") || url.equals("default") || url.equals("") || url.equals("nsfw") || url.equals("spoiler")) {
            imageView.setVisibility(View.GONE);

        } else {
//TODO add NSFW Image here for now imageview is gone
            if (url.equals("image")) {

            } else {


                imageView.setVisibility(View.VISIBLE);
                Glide.with(context).load(url).fitCenter().centerInside().into(imageView);
            }
        }


    }


    protected static class PostViewHolder extends RecyclerView.ViewHolder {
        private EmojiTextView mTitle;
        private EmojiTextView mSubreddit;
        private ImageView mImageView;
        private EmojiTextView mAuthor;

        private PostViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.postTitle);
            mSubreddit = itemView.findViewById(R.id.subRedditName);
            mImageView = itemView.findViewById(R.id.imageView);
            mAuthor = itemView.findViewById(R.id.author);

        }
    }


}
