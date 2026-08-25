package com.transsnet.downloader.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ForegroundService extends Service {
    private static final String a = "ForegroundService";
    static boolean b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.e(a, "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.e(a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.e(a, "onDestroy");
        b = false;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.e(a, "onStartCommand");
        b = true;
        try {
            Toast.makeText(this, intent.getStringExtra("Foreground"), 0).show();
        } catch (Throwable unused) {
        }
        return super.onStartCommand(intent, i, i2);
    }
}
