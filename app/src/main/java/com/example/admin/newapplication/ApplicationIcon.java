package com.example.admin.newapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

public class ApplicationIcon {
    private Context context;

    public ApplicationIcon(Context context){

        this.context=context;
    }

    public void ShowIcon(){
        PackageManager p = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, MainActivity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    public void HideIcon(){
        PackageManager p = context.getPackageManager();

        ComponentName componentName = new ComponentName(context, MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
        p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
