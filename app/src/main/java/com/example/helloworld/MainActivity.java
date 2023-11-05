package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int increment;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txt2 = (EditText) findViewById(R.id.txt2);
        System.out.println(txt2.getText());
        TextView textView = (TextView) findViewById(R.id.txt1);
        txt2.setText(textView.getText());
        txt2.addTextChangedListener(new TextWatcher() {
            private int ind = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println(editable);
                if (ind >= 3) {
                    ind = 0;
                }
                txt2.setTypeface(null, ind);
                ind++;
            }
        });

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            private final int[] colors = {Color.rgb(255, 0, 0),
                    Color.rgb(0, 255, 0), Color.rgb(0, 0, 255)};
            private int ind = 0;

            @Override
            public void onClick(View view) {
                if (ind > 2) {
                    ind = 0;
                }
                textView.setTextColor(colors[ind]);
                ind++;
            }
        });

    }

    public void checked(View view) {
        TextView tx = (TextView) findViewById(R.id.textRBs);
        RadioButton rb;
        rb = (RadioButton) findViewById(R.id.rb1);
        if (rb.isChecked()) {
            tx.setText(rb.getText());
            return;
        }
        rb = (RadioButton) findViewById(R.id.rb2);
        if (rb.isChecked()) {
            tx.setText(rb.getText());
            return;
        }
    }

    public void setBlackColor(View view) {
        TextView textView = (TextView) findViewById(R.id.txt1);
        textView.setTextColor(Color.rgb(0, 0, 0));
    }

    /*public void progressBar(View view){
        EditText max = (EditText) findViewById(R.id.maximum);
        int maximum = Integer.parseInt(max.getText().toString());
        EditText step = (EditText) findViewById(R.id.step);
        increment = Integer.parseInt(max.getText().toString());
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("loading...");

    }   */

}