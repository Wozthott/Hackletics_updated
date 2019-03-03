package com.example.hackletics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dailyActivityBtn = findViewById(R.id.dailyButton);
        dailyActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), DailyActivity.class);
                startActivity(startIntent);
            }
        });

        Button planActivityBtn = findViewById(R.id.planButton);
        planActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), PlanActivity.class);
                startActivity(startIntent);
            }
        });

        Button progressActivityBtn = findViewById(R.id.progressButton);
        progressActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ProgressActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
