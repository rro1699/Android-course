package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText text = findViewById(R.id.editText);
        text.setText("Input message");
    }

    public void onClickOk(View view){
        EditText text = findViewById(R.id.editText);
        Editable mes = text.getText();
        Intent data = new Intent();
        data.putExtra("message", mes.toString());
        setResult(RESULT_OK, data);
        finish();
    }
    public void onClickCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}