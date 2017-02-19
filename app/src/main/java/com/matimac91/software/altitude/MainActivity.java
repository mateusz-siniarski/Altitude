package com.matimac91.software.altitude;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    //TODO: Create a service creating an TestDataObject having the GPS altitude and current air pressure
    private SensorManager sm;
    private Sensor pressureSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        pressureSensor = sm.getDefaultSensor(Sensor.TYPE_PRESSURE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,pressureSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        TextView pressure = (TextView) findViewById(R.id.textViewAirPressure);
        String pressureValue = String.valueOf(event.values[0]);
        pressure.setText(pressureValue);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
