package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {
    DataBaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        sqlHelper = new DataBaseHelper(this);
        db = sqlHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_NAME, "testValue");
        cv.put(DataBaseHelper.COLUMN_YEAR, 111);

        long id = db.insert(DataBaseHelper.TABLE, null, cv);
        if(id != -1){
            printLog();
            cv.put(DataBaseHelper.COLUMN_YEAR,222);
            db.update(DataBaseHelper.TABLE, cv, DataBaseHelper.COLUMN_ID + "=" + id, null);
            printLog();
            db.delete(DataBaseHelper.TABLE, "_id = ?", new String[]{String.valueOf(userId)});
            printLog();
            userCursor.close();
        }


    }
    private void printLog(){
        userCursor = db.rawQuery("select * from " + DataBaseHelper.TABLE + " where " +
                DataBaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(1)});
        userCursor.moveToFirst();
        Log.d("thirdActivity",userCursor.getString(1));
        Log.d("thirdActivity",String.valueOf(userCursor.getInt(2)));
    }
}