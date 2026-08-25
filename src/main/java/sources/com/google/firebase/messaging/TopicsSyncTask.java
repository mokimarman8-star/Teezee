package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class TopicsSyncTask implements Runnable {
    private static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    private static Boolean hasAccessNetworkStatePermission;
    private static Boolean hasWakeLockPermission;
    private final Context context;
    private final j0 metadata;
    private final long nextDelaySeconds;
    private final PowerManager.WakeLock syncWakeLock;
    private final c1 topicsSubscriber;

    class a extends BroadcastReceiver {
        private TopicsSyncTask a;

        public a(TopicsSyncTask topicsSyncTask) {
            this.a = topicsSyncTask;
        }

        public void a() {
            TopicsSyncTask.isLoggable();
            TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.a;
            if (topicsSyncTask == null) {
                return;
            }
            if (topicsSyncTask.isDeviceConnected()) {
                TopicsSyncTask.isLoggable();
                this.a.topicsSubscriber.m(this.a, 0L);
                context.unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    TopicsSyncTask(c1 c1Var, Context context, j0 j0Var, long j) {
        this.topicsSubscriber = c1Var;
        this.context = context;
        this.nextDelaySeconds = j;
        this.metadata = j0Var;
        this.syncWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String createPermissionMissingLog(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean hasAccessNetworkStatePermission(Context context) {
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            try {
                Boolean bool = hasAccessNetworkStatePermission;
                Boolean valueOf = Boolean.valueOf(bool == null ? hasPermission(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                hasAccessNetworkStatePermission = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static boolean hasPermission(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            createPermissionMissingLog(str);
        }
        return z;
    }

    private static boolean hasWakeLockPermission(Context context) {
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            try {
                Boolean bool = hasWakeLockPermission;
                Boolean valueOf = Boolean.valueOf(bool == null ? hasPermission(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                hasWakeLockPermission = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isDeviceConnected() {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isConnected();
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLoggable() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (hasWakeLockPermission(this.context)) {
            this.syncWakeLock.acquire(e.a);
        }
        try {
            try {
                this.topicsSubscriber.o(true);
            } catch (Throwable th) {
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e.getMessage());
            this.topicsSubscriber.o(false);
            if (!hasWakeLockPermission(this.context)) {
                return;
            }
        }
        if (!this.metadata.g()) {
            this.topicsSubscriber.o(false);
            if (hasWakeLockPermission(this.context)) {
                try {
                    this.syncWakeLock.release();
                    return;
                } catch (RuntimeException unused2) {
                    return;
                }
            }
            return;
        }
        if (hasAccessNetworkStatePermission(this.context) && !isDeviceConnected()) {
            new a(this).a();
            if (hasWakeLockPermission(this.context)) {
                try {
                    this.syncWakeLock.release();
                    return;
                } catch (RuntimeException unused3) {
                    return;
                }
            }
            return;
        }
        if (this.topicsSubscriber.s()) {
            this.topicsSubscriber.o(false);
        } else {
            this.topicsSubscriber.t(this.nextDelaySeconds);
        }
        if (!hasWakeLockPermission(this.context)) {
            return;
        }
        try {
            this.syncWakeLock.release();
        } catch (RuntimeException unused4) {
        }
    }
}
