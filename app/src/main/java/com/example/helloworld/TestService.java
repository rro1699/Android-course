package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;



public class TestService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        Log.d("Service","onCreate()");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("Service","onStartCommand()");
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        Log.d("Service","onDestroy()");
    }
}
