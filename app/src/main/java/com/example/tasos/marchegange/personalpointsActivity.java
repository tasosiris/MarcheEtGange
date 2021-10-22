package com.example.tasos.marchegange;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class personalpointsActivity extends AppCompatActivity implements SensorEventListener  {


    SensorManager sensorManager;
    boolean running = false;
    TextView tv_steps;
    TextView tv_points;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalpoints);

        tv_steps = (TextView) findViewById(R.id.tv_steps);
        tv_points = (TextView) findViewById(R.id.tv_points);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }


    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor !=null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        //if you unregister the hardware will stop detecting steps
        //sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running){
            tv_steps.setText(String.valueOf(((int)event.values[0])));
            //int num1 = Integer.parseInt(tv_steps.getText().toString());
            //int num1 = 1000;
            int result = ((int)event.values[0])/10;
            tv_points.setText(String.valueOf(result));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }





}
