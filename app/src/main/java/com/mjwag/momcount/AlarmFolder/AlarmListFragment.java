package com.mjwag.momcount.AlarmFolder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjwag.momcount.R;

import java.util.List;

public class AlarmListFragment extends Fragment {

    private RecyclerView mRecycler;
    private AlarmAdapter mAdapter;

    @Override
    public void onCreate(Bundle sis){
        super.onCreate(sis);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis){
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);
        mRecycler = (RecyclerView)v.findViewById(R.id.alarmRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    public void updateUI(){
        AlarmDB db = AlarmDB.getDB(getActivity());
        List<Alarm> alarmList = db.getAlarmList();

        mAdapter = new AlarmAdapter
    }
}
