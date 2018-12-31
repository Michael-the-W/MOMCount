package com.mjwag.momcount.AlarmFolder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.mjwag.momcount.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle sis) {
        super.onCreate(sis);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new AlarmListFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

}
