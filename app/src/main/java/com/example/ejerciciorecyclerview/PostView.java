package com.example.ejerciciorecyclerview;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostView extends RecyclerView.ViewHolder {

    //State
    private Post post;

    //UI
    private TextView nameRow, contentRow, likesRow, dateRow;
    private ImageView likeBtn;

    //Listeners
    private OnPostLikedListener listener;

    public PostView(@NonNull View itemView) {
        super(itemView);

        nameRow = itemView.findViewById(R.id.nameRow);
        contentRow = itemView.findViewById(R.id.contentRow);
        likesRow = itemView.findViewById(R.id.likesRow);
        dateRow = itemView.findViewById(R.id.dateRow);
        likeBtn = itemView.findViewById(R.id.likeBtn);

        likeBtn.setOnClickListener(v->{
            post.setLikes(post.getLikes()+1);
            listener.onPostLiked(post);
        });
    }

    public interface OnPostLikedListener{
        void onPostLiked(Post post);
    }

    public void setListener(OnPostLikedListener listener) {
        this.listener = listener;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public TextView getNameRow() {
        return nameRow;
    }

    public TextView getContentRow() {
        return contentRow;
    }

    public TextView getLikesRow() {
        return likesRow;
    }

    public TextView getDateRow() {
        return dateRow;
    }
}
