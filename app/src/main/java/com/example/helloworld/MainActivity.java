package com.example.helloworld;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShort(View view){
        Toast toast = Toast.makeText(this, "short time", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickLong(View view){
        Toast toast = Toast.makeText(this, "long time", Toast.LENGTH_LONG);
        toast.show();
    }

}