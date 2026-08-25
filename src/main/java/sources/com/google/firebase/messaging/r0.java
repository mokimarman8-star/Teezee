package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class r0 {
    private static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    static boolean d(SharedPreferences sharedPreferences, boolean z) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z;
    }

    static void f(Context context, boolean z) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_notification_initialized", z);
        edit.apply();
    }

    static void g(final Context context, e0 e0Var, final boolean z) {
        if (PlatformVersion.isAtLeastQ() && !d(b(context), z)) {
            e0Var.k(z).addOnSuccessListener(new v3.m(), new OnSuccessListener() { // from class: com.google.firebase.messaging.q0
                public final void onSuccess(Object obj) {
                    r0.h(context, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Context context, boolean z) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_retention", z);
        edit.apply();
    }
}
