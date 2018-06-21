package com.example.admin.newapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button IconButton;
    boolean pressed = false;
    ApplicationIcon applicationIcon;
    BackGroundService backGroundService;
    TakeScreenShots takeScreenShots;
    private ImageView imgScreen;
    private IScreenshotProvider aslProvider = null;
    private ServiceConnection aslServiceConn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            aslProvider = IScreenshotProvider.Stub.asInterface(service);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        IconButton = (Button) findViewById(R.id.IconButton);
        applicationIcon = new ApplicationIcon(this);
        backGroundService = new BackGroundService();
        imgScreen = (ImageView)findViewById(R.id.ImageView);

        // connect to ASL service
        //Intent intent = new Intent(ScreenshotService.class.getName());
        Intent intent = new Intent();
        intent.setClass(this, ScreenshotService.class);
        //intent.addCategory(Intent.ACTION_DEFAULT);
        bindService (intent, aslServiceConn, Context.BIND_AUTO_CREATE);

        IconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressed == false) {
                    startService(new Intent(MainActivity.this, BackGroundService.class));
                    IconButton.setText("Stop Service");
                    pressed = true;

                    try {
                        if (aslProvider == null)
                            Toast.makeText(MainActivity.this, "Message 1", Toast.LENGTH_SHORT).show();
                        else if (!aslProvider.isAvailable())
                            Toast.makeText(MainActivity.this, "Message 2", Toast.LENGTH_SHORT).show();
                        else {
                            String file = aslProvider.takeScreenshot();
                            if (file == null)
                                Toast.makeText(MainActivity.this, "Message 3", Toast.LENGTH_SHORT).show();
                            else {
                                Toast.makeText(MainActivity.this, "Message 4", Toast.LENGTH_SHORT).show();
                                Bitmap screen = BitmapFactory.decodeFile(file);
                                imgScreen.setImageBitmap(screen);

                            }
                        }
                    } catch (Resources.NotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (RemoteException e) {

                    }
                }
                else {
                    stopService(new Intent(MainActivity.this, BackGroundService.class));
                    IconButton.setText("Start Service");
                    pressed = false;

                }
            }
        });

    }


}
