package com.mjwag.momcount.AlarmFolder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlarmDatabaseHelper extends SQLiteOpenHelper {

    public AlarmDatabaseHelper(Context context){
        super(context, "alarm.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE alarms (_id integer primary key autoincrement, uuid, name, endTime)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
