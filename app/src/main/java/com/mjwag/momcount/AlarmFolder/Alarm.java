package com.mjwag.momcount.AlarmFolder;

import java.util.UUID;

public class Alarm {

    private UUID   mAlarmID; // Alarm UUID
    private String mTitle; // Alarm Title
    private int    mEndTime; // Alarm end time

    public Alarm (String name, int endTime) {
        mAlarmID = UUID.randomUUID();
        mTitle = name;
        mEndTime = endTime;
    }

    public Alarm (String name, int endTime, String uuid){
        mAlarmID = UUID.fromString(uuid);
        mTitle = name;
        mEndTime = endTime;
    }

    public UUID getmAlarmID() {
        return mAlarmID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(int mEndTime) {
        this.mEndTime = mEndTime;
    }
}
