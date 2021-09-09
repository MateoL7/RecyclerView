package com.example.ejerciciorecyclerview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton newPostBtn;
    private RecyclerView postsRecycler;

    private LinearLayoutManager manager;
    private PostAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), this::onResult
        );

        newPostBtn = findViewById(R.id.newPostBtn);
        postsRecycler = findViewById(R.id.postsRecycler);

        // ¿Qué es lo que hago aquí?
        //Declaro que layout va a usar
        manager = new LinearLayoutManager(this);
        postsRecycler.setLayoutManager(manager);

        adapter = new PostAdapter();
        postsRecycler.setAdapter(adapter);
        postsRecycler.setHasFixedSize(true);
        //


        newPostBtn.setOnClickListener(v->{
            Intent intent = new Intent(this, PostingActivity.class);
            launcher.launch(intent);

        });

    }

    public void onResult(ActivityResult result) {
        if(result.getResultCode() == RESULT_OK) {
            String name = result.getData().getExtras().getString("name");
            String content = result.getData().getExtras().getString("content");
            String date = result.getData().getExtras().getString("date");
            Log.e(">>>",date);
            adapter.addPost(new Post(name,content,date,0));
        }else if(result.getResultCode() == RESULT_CANCELED){
           //Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
        }
    }
}