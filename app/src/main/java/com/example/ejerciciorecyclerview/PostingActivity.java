package com.example.ejerciciorecyclerview;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class PostingActivity extends AppCompatActivity {

    private EditText nameET, contentET;
    private Button publishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);


        nameET = findViewById(R.id.nameET);
        contentET = findViewById(R.id.contentET);
        publishBtn = findViewById(R.id.publishBtn);

        publishBtn.setOnClickListener(v->{

            //Accion
            String name = nameET.getText().toString();
            String content = contentET.getText().toString();
            String date = Calendar.getInstance().getTime().toString();



            Intent intent = new Intent();
            intent.putExtra("name",name);
            intent.putExtra("content", content);
            intent.putExtra("date",date);
            setResult(RESULT_OK,intent);
            finish();
        });
    }
}