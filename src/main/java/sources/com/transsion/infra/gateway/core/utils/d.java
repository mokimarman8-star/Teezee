package com.transsion.infra.gateway.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d {
    private static d c;
    private SharedPreferences a;
    private Context b;

    private d(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                if (c == null) {
                    c = new d(context);
                }
                dVar = c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    private SharedPreferences c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gateway_core", 0);
                this.a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception unused) {
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.a = context.getSharedPreferences("gateway_core", 0);
        } catch (Exception unused2) {
        }
        return this.a;
    }

    public long b(String str) {
        Context context = this.b;
        if (context == null) {
            return -1L;
        }
        if (this.a == null) {
            this.a = c(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(str, 0L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void d(String str, long j) {
        Context context = this.b;
        if (context == null) {
            return;
        }
        if (this.a == null) {
            this.a = c(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putLong(str, j).apply();
        } catch (Exception unused) {
        }
    }
}
