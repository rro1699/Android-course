package com.example.helloworld;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                int lengthLong;
                String text;
                if(state == 0 ){
                    lengthLong = Toast.LENGTH_SHORT;
                    text = "LENGTH_SHORT";
                    state = 1;
                }else{
                    lengthLong = Toast.LENGTH_LONG;
                    text = "LENGTH_LONG";
                    state = 0;
                }
                Toast toast =
                        Toast.makeText(context,text, lengthLong);
                toast.show();
            }
        });
    }




}