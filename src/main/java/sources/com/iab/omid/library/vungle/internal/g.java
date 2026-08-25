package com.iab.omid.library.vungle.internal;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    private static g b = new g();
    private Context a;

    private g() {
    }

    public static g c() {
        return b;
    }

    public Context a() {
        return this.a;
    }

    public void b(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }
}
