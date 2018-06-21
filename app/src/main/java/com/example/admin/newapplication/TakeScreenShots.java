package com.example.admin.newapplication;


import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class TakeScreenShots extends Service {
    int milliseconds;
    String imagelocation="";
    Activity activity;
    ScreenshotService screenshotService;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
