package com.example.tasos.marchegange;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tv_steps;
    ImageButton iconman;
    ImageButton iconp;
    ImageButton iconst;
    ImageButton iconhm;
    SensorManager sensorManager;
    boolean running = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_steps = (TextView) findViewById(R.id.tv_steps);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        iconp = (ImageButton) findViewById(R.id.p_icon);

        iconp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, personalpointsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });


        iconman = (ImageButton) findViewById(R.id.man_icon);

        iconman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, PersonalinformationActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        iconst = (ImageButton) findViewById(R.id.st_icon);

        iconst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, personalstatisticsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        iconhm = (ImageButton) findViewById(R.id.hm_icon);

        iconhm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, shopsActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}

