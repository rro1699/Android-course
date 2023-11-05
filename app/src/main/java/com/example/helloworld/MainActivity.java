package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button button = this.findViewById(R.id.button);

        // operations to be performed
        // when user tap on the button
        if (button != null) {
            button.setOnClickListener(it -> {
                String url = "https://remoteservice.onrender.com/test/";
                System.out.println("try to send request by url = "+url);
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                try (Response execute = client.newCall(request).execute()){
                    String body = execute.body() != null ? execute.body().string() : "";
                    if(execute.code() == 200) {
                        System.out.println("code = " + execute.code() + "  body = " + body);
                    }else{
                        System.out.println("code = " + execute.code());
                    }
                } catch (IOException e) {
                    System.out.println("Bad response. Some errors");
                    throw new RuntimeException(e);
                }
            });
        }
    }


}