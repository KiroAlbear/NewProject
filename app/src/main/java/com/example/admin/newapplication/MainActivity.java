package com.example.admin.newapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button IconButton;
    boolean pressed = false;
    ApplicationIcon applicationIcon;
    BackGroundService backGroundService;
    TakeScreenShots takeScreenShots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IconButton = (Button) findViewById(R.id.IconButton);
        applicationIcon = new ApplicationIcon(this);
        backGroundService = new BackGroundService();
        takeScreenShots = new TakeScreenShots(0, this);

        IconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressed == false) {
                    startService(new Intent(MainActivity.this, BackGroundService.class));
                    IconButton.setText("Stop Service");
                    pressed = true;
                    takeScreenShots.Capture2(IconButton.getRootView());
                } else {
                    stopService(new Intent(MainActivity.this, BackGroundService.class));
                    IconButton.setText("Start Service");
                    pressed = false;
                    takeScreenShots.Capture2(IconButton.getRootView());
                }
            }
        });

    }


}
