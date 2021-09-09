package com.example.ejerciciorecyclerview;

import android.content.pm.LauncherActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostView> implements PostView.OnPostLikedListener{

    private ArrayList<Post> posts;

    public PostAdapter(){
        posts = new ArrayList<>();
    }

    public void addPost(Post post){
        posts.add(post);
        notifyItemInserted(posts.size()-1);
    }

    @NonNull
    @Override
    public PostView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.post_row,parent,false);
        PostView skeleton = new PostView(row);
        skeleton.setListener(this);
        return skeleton;
    }

    @Override
    public void onBindViewHolder(@NonNull PostView skeleton, int position) {
        Post post = posts.get(position);

        skeleton.setPost(post);
        skeleton.getNameRow().setText(post.getName());
        skeleton.getContentRow().setText(post.getContent());
        skeleton.getDateRow().setText(post.getDate());
        skeleton.getLikesRow().setText("A "+post.getLikes()+" les gusta esto");

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onPostLiked(Post post) {
        int index = posts.indexOf(post);
        notifyItemChanged(index);
    }
}
