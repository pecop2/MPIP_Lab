package com.example.petar.lab_intents;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.AndroidException;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class ImplicitActivity extends AppCompatActivity {


    private TextView activitiesTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        activitiesTv = (TextView) findViewById(R.id.activitiesTextView);
        activitiesTv.setMovementMethod(new ScrollingMovementMethod());

        showCompatibleActivities("android.intent.category.LAUNCHER", "android.intent.action.MAIN");
    }


    private void showCompatibleActivities(String category, String launcher)
    {
        Intent temp = new Intent();
        temp.addCategory("android.intent.category.LAUNCHER");
        //temp.setType("android.intent.category.LAUNCHER");
        temp.setAction("android.intent.action.MAIN");

        List<ResolveInfo> infos = getPackageManager().queryIntentActivities(temp, 0);

        for (int i=0;i<infos.size();i++)
        {
            String[] s=infos.get(i).activityInfo.name.split("\\.");
            int size=s.length;
            if (size>0)
            {
                if (i!=0)
                    activitiesTv.append("\n");

                activitiesTv.append(s[size-1]);
            }

        }



    }


}
