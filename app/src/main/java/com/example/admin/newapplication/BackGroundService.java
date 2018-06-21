package com.example.admin.newapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

public class BackGroundService extends Service {


    @Override
    public void onCreate() {
        Toast.makeText(this,"Service Created",Toast.LENGTH_SHORT).show();

        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       getApplicationContext();
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_SHORT).show();
    }
}
