package com.transsion.infra.gateway.core.utils;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    private static Context a;

    public static Context a() {
        Context context = a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(Context context) {
        if (a != null) {
            return;
        }
        a = context.getApplicationContext();
    }
}
