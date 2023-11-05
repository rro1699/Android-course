package com.example.helloworld;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.DTO.CustomObject;

public class MainActivity extends BaseActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        super.soutBackStack(this.getLocalClassName());
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
        super.soutBackStack(this.toString());
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    public void onClickWithObject(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("object",
                new CustomObject("test object", 100));
        startActivity(intent);
    }

    public void onClickWithoutObject(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context,"",Toast.LENGTH_LONG);
                    if(result.getResultCode() == Activity.RESULT_OK){
                        if (result.getData() != null) {
                            String message = result.getData().getStringExtra("message");
                            toast.setText(message);
                        }
                    }else{
                        toast.setText("canceled");
                    }
                    toast.show();
                }
            });
    public void onClickWithResult(View view){
        launcher.launch(new Intent(this, ThirdActivity.class));
    }
}