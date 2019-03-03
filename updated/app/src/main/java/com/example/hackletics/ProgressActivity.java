package com.example.hackletics;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProgressActivity extends AppCompatActivity {

    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPrefs = mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        Button dailyActivityBtn = findViewById(R.id.progressDone);
        dailyActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.progressText)).setText(((TextView) findViewById(R.id.progressText)).getText() + (Integer.toString(mPrefs.getInt("goal", 0)) + " Pounds!"));
    }
}
