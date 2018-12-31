package com.mjwag.momcount.AlarmFolder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.mjwag.momcount.R;

public class AlarmContentFragment extends DialogFragment{

    private EditText mName;
    private EditText mEndDate;
    private Alarm mAlarm;

    public static AlarmContentFragment newInstance(Alarm alarm){
        Bundle args = new Bundle();
        args.putSerializable("alarm", alarm);

        AlarmContentFragment fragment = new AlarmContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        mAlarm = (Alarm)getArguments().getSerializable("alarm");
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.alarm_content, null);

        mName = (EditText)v.findViewById(R.id.edit_alarm_name);
        mEndDate = (EditText)v.findViewById(R.id.edit_end_date);

        mName.setText(mAlarm.getmTitle());
        mEndDate.setText(mAlarm.getmEndTime());

        return  new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.edit_alarm)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_OK, mName.getText().toString(),mEndDate.getText());
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode, String fName, int fEndDate ){
    if (getTargetFragment() != null) {
        Intent i = new Intent();
        mAlarm.setmTitle(fName);
        mAlarm.setmEndTime(fEndDate);
        i.putExtra("alarm", mAlarm);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }

}
