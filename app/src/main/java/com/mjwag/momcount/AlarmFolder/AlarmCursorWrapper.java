package com.mjwag.momcount.AlarmFolder;

import android.database.Cursor;
import android.database.CursorWrapper;

public class AlarmCursorWrapper extends CursorWrapper {
    public AlarmCursorWrapper(Cursor c){
        super(c);
    }

    public Alarm getAlarms() {
        Alarm alarms = new Alarm(getString(getColumnIndex("name")),
                                 getInt(getColumnIndex("endTime")),
                                 getString(getColumnIndex("uuid")));
        return alarms;
    }
}
