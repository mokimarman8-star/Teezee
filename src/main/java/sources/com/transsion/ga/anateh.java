package com.transsion.ga;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anateh extends Exception {
    public static final /* synthetic */ int a = 0;
    private final String b;
    private final Bundle c;

    public anateh(String str, Bundle bundle) {
        super(str, null);
        this.b = str;
        this.c = bundle;
    }

    public anateh(String str, Throwable th2) {
        super(str, th2);
        this.b = str;
        this.c = null;
    }

    public static void a(String str, Throwable th2) {
        i.a().c(new anateh(str, th2));
    }

    String a() {
        return this.b;
    }

    Bundle b() {
        return this.c;
    }
}
