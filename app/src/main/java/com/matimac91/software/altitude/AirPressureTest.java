package com.matimac91.software.altitude;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mateusz on 19/02/2017.
 */

public class AirPressureTest extends AppCompatActivity implements SensorEventListener {
    private Float millibarsOfPressure = null;
    private SensorManager sm;
    private Sensor pressure;


    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }



    public void startListener() {
        sm.registerListener(this, pressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopListener() {
        sm.unregisterListener(this);
    }


    public float getCurrentAirPressure() {
       if (millibarsOfPressure != null) {
            return millibarsOfPressure;
        }
        else {
           throw new NullPointerException();
       }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        millibarsOfPressure = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
