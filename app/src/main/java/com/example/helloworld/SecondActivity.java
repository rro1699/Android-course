package com.example.helloworld;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.helloworld.DTO.CustomObject;


import java.util.Optional;

public class SecondActivity extends BaseActivity {

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
        super.soutBackStack(this.toString());
    }

    public void onClickBack(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
        super.soutBackStack(this.toString());
    }
}