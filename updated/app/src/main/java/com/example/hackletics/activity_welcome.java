package com.example.hackletics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_welcome extends AppCompatActivity {

    SharedPreferences mPrefs;
    int goal = 0;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefs.getInt("goal", 0);

        Boolean welcomeScreenShown =  mPrefs.getBoolean("welcomeScreenShown", false);


        if(!welcomeScreenShown)
        {
            EditText goalEntered = findViewById(R.id.setGoal);

            goalEntered.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    temp = s.toString();
                }
            });

            Button dailyActivityBtn = findViewById(R.id.welcomeDone);
            dailyActivityBtn.setOnClickListener(new View.OnClickListener() {

                SharedPreferences.Editor editor = mPrefs.edit();

                @Override
                public void onClick(View v) {
                    if(temp != "") {
                        goal = Integer.parseInt(temp.trim());
                    }
                    if(goal > 0) {
                        editor.putInt("goal", goal);
                        editor.putBoolean("welcomeScreenShown", true);
                        editor.commit();
                        Intent startIntent = new Intent(getApplicationContext(), PlanActivity.class);
                        startActivity(startIntent);
                    }
                }
            });
        } else {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startIntent);
        }
    }
}
