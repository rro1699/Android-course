package com.example.helloworld;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {
    public void soutBackStack(String className){
        String[] split = className.split("\\.");
        className = split[split.length-1];
        Context ctx = getApplication().getApplicationContext();
        ActivityManager m = (ActivityManager) ctx.getSystemService( ACTIVITY_SERVICE );
        for (ActivityManager.AppTask appTask : m.getAppTasks()) {
            Log.d(className, "numberOfActivities = " + appTask.getTaskInfo().numActivities);
            Log.d(className, "topActivity = " + appTask.getTaskInfo().topActivity.getShortClassName());
        }
    }
}
