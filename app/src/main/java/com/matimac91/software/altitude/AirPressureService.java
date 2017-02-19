package com.matimac91.software.altitude;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AirPressureService extends Service {
    public AirPressureService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
