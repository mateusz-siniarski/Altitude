package com.matimac91.software.altitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGetAirPressure = (Button) findViewById(R.id.buttonGetAirPressure);

        buttonGetAirPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressure = (TextView) findViewById(R.id.textViewAirPressure);

                AirPressureTest airp = new AirPressureTest();
                airp.startListener();

                String pressureValue = String.valueOf(airp.getCurrentAirPressure());

                pressure.setText(pressureValue);

                airp.stopListener();

            }
        });

    }
}
