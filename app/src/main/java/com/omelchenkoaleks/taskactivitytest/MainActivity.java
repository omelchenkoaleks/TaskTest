package com.omelchenkoaleks.taskactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Base";
    private List<ActivityManager.RunningTaskInfo> mList;
    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
        mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onInfoClick(View view) {
        mList = mActivityManager.getRunningTasks(10);
        for (ActivityManager.RunningTaskInfo taskInfo : mList) {
            if (taskInfo.baseActivity.flattenToShortString().startsWith("com.omelchenkoaleks.taskactivity")) {
                Log.d(TAG, "--------------------");
                Log.d(TAG, "Count: " + taskInfo.numActivities);
                Log.d(TAG, "Root: " + taskInfo.baseActivity.flattenToShortString());
                Log.d(TAG, "Top: " + taskInfo.topActivity.flattenToShortString());
            }
        }
    }

    public void onClick(View view) {
        startActivity(new Intent("mngtask1_activity_c"));
    }
}
