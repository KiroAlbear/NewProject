package com.example.admin.newapplication;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class TakeScreenShots extends Application {
    int milliseconds;
    String imagelocation="";
    Activity activity;
    public TakeScreenShots(int milliseconds, Activity activity) {
        this.milliseconds=milliseconds;
        this.activity=activity;

    }

    public void Capture(){
        Date Now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", Now);
       imagelocation = Environment.getExternalStorageDirectory().toString()+"/"+ Now+".jpg";
        View v1=  activity.getWindow().getDecorView().getRootView();
        Bitmap bitmap =Bitmap.createBitmap(v1.getDrawingCache());
        v1.setDrawingCacheEnabled(false);



        try {
            File imageFile = new File(imagelocation);

            FileOutputStream outputStream = null;
            outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
            Toast.makeText(getApplicationContext(),"ScreenShot !",Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    public void Capture2(){
        View view=  activity.getWindow().getDecorView().getRootView();



        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        Date Now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", Now);
        imagelocation = Environment.getExternalStorageDirectory().toString()+"/"+ Now+".jpg";
        Toast.makeText(getApplicationContext(),"Sucess ScreenShot",Toast.LENGTH_SHORT);
        try {
            FileOutputStream out= new FileOutputStream(imagelocation);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }

}
