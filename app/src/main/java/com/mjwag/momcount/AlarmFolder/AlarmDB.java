package com.mjwag.momcount.AlarmFolder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlarmDB {
    private static AlarmDB alarmDB;

    private Context mContext;
    private SQLiteDatabase mDataBase;


    private static ContentValues getContentValues(Alarm alarmIn){
        ContentValues values = new ContentValues();
        values.put("uuid", alarmIn.getmAlarmID().toString());
        values.put("name", alarmIn.getmTitle());
        values.put("endTime", alarmIn.getmEndTime());
        return values;
    }

    private AlarmDB(Context context) {
        mContext = context.getApplicationContext();
        mDataBase = new AlarmDatabaseHelper(mContext).getWritableDatabase();
    }

    private AlarmCursorWrapper queryAlarms(String whereClause, String[] whereParamaters){
        Cursor cursor = mDataBase.query(
                "alarms", null, whereClause,whereParamaters, null, null, null
        );
        return new AlarmCursorWrapper(cursor);
    }

    public static AlarmDB getDB(Context c) {
        if (alarmDB == null)
            alarmDB = new AlarmDB(c);
        return alarmDB;
    }

    public List<Alarm> getAlarmList() {
        List<Alarm> alarmList = new ArrayList<>();
        AlarmCursorWrapper ac = queryAlarms(null, null);

        try{
            ac.moveToFirst();
            while(!ac.isAfterLast()) {
                alarmList.add(ac.getAlarms());
                ac.moveToNext();
            }
        }
        finally {
            ac.close();
        }
        return alarmList;
    }

    public void add(Alarm a){
        ContentValues values = getContentValues(a);
        mDataBase.insert("alarms", null, values);
    }

    public void updateAlarm(Alarm a){
        String uuid = a.getmAlarmID().toString();
        ContentValues values = getContentValues(a);

        mDataBase.update("alarms", values, "uuid = ?",
                new String[] {uuid});
    }

    public Alarm getAlarm(UUID id) {
        Alarm a = null;
        AlarmCursorWrapper ac = queryAlarms("uuid = ?", new String[] {id.toString()});

        try{
            if(ac.getCount() != 0) {
                ac.moveToFirst();
                a = ac.getAlarms();
            }
        }
        finally {
            ac.close();
        }
        return a;
    }
}
