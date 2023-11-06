package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private final static String FILE_NAME = "data.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*saveNewJsonInFile();
        readJsonFromFile();*/
    }

    public void click(View v) {
        Intent i=new Intent(this, TestService.class);
        if (v.getId()==R.id.start) {
            startService(i);
        }
        else {
            stopService(i);
        }
    }
    private void saveNewJsonInFile(){
        TestClass testClass = new TestClass();
        testClass.setStringF("test");
        testClass.setIntF(11);
        Gson gson = new Gson();
        String jsonString = gson.toJson(testClass);
        try(FileOutputStream fileOutputStream =
                    getApplicationContext().openFileOutput(FILE_NAME, MODE_PRIVATE)) {
            fileOutputStream.write(jsonString.getBytes());
            Log.d("Main","Файл записан");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readJsonFromFile(){
        try(FileInputStream fileInputStream = getApplicationContext().openFileInput(FILE_NAME);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream)){
            Gson gson = new Gson();
            TestClass testClass = gson.fromJson(streamReader, TestClass.class);
            Log.d("Main", testClass.toString());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}