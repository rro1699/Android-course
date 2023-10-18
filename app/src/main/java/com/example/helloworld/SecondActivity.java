package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.DTO.CustomObject;


import java.util.Optional;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String text = "SecondActivity";
        Optional<CustomObject> object;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            object = Optional.ofNullable(getIntent().getSerializableExtra("object", CustomObject.class));
            if(object.isPresent()){
                text = object.get().toString();
            }
        }
        TextView textView = findViewById(R.id.txtL);
        textView.setText(text);
        textView.setTextSize(20);
    }

    public void onClickBack(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}