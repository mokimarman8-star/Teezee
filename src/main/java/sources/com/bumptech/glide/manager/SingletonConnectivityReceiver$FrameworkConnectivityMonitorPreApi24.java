package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 implements SingletonConnectivityReceiver$FrameworkConnectivityMonitor {
    static final Executor EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
    private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
    final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
        }
    };
    final Context context;
    volatile boolean isConnected;
    volatile boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24(Context context, GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.connectivityManager = glideSupplier;
        this.listener = connectivityListener;
    }

    @SuppressLint({"MissingPermission"})
    boolean isConnected() {
        try {
            NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    void notifyChangeOnUiThread(final boolean z) {
        Util.postOnUiThread(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.5
            @Override // java.lang.Runnable
            public void run() {
                SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(z);
            }
        });
    }

    void onConnectivityChange() {
        EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isConnected;
                SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this;
                singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.isConnected = singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.isConnected();
                if (z != SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("connectivity changed, isConnected: ");
                        sb.append(SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isConnected);
                    }
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242 = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this;
                    singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242.notifyChangeOnUiThread(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242.isConnected);
                }
            }
        });
    }

    @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
    public boolean register() {
        EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.2
            @Override // java.lang.Runnable
            public void run() {
                SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this;
                singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.isConnected = singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.isConnected();
                try {
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242 = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this;
                    singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242.context.registerReceiver(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi242.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                } catch (SecurityException e) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e);
                    }
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                }
            }
        });
        return true;
    }

    @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
    public void unregister() {
        EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24 = SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.this;
                    singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.context.unregisterReceiver(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24.connectivityReceiver);
                }
            }
        });
    }
}
