package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class v0 {
    private static v0 e;
    private String a = null;
    private Boolean b = null;
    private Boolean c = null;
    private final Queue d = new ArrayDeque();

    private v0() {
    }

    private int a(Context context, Intent intent) {
        String f = f(context, intent);
        if (f != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Restricting intent to a specific service: ");
                sb2.append(f);
            }
            intent.setClassName(context.getPackageName(), f);
        }
        try {
            if ((e(context) ? e1.h(context, intent) : context.startService(intent)) != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e2) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e2);
            return 402;
        } catch (SecurityException e3) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e3);
            return 401;
        }
    }

    static synchronized v0 b() {
        v0 v0Var;
        synchronized (v0.class) {
            try {
                if (e == null) {
                    e = new v0();
                }
                v0Var = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return v0Var;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.a = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.a = serviceInfo.name;
                    }
                    return this.a;
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    Intent c() {
        return (Intent) this.d.poll();
    }

    boolean d(Context context) {
        if (this.c == null) {
            this.c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.c.booleanValue();
    }

    boolean e(Context context) {
        if (this.b == null) {
            this.b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.b.booleanValue()) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        Log.isLoggable("FirebaseMessaging", 3);
        this.d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
