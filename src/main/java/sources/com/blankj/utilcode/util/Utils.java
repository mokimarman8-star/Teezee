package com.blankj.utilcode.util;

import android.app.Application;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class Utils {
    private static Application a;

    public static Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        b(e0.j());
        if (a == null) {
            throw new NullPointerException("reflect failed.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(e0.k());
        sb.append(" reflect app success.");
        return a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = a;
        if (application2 == null) {
            a = application;
            e0.v(application);
            e0.G();
        } else {
            if (application2.equals(application)) {
                return;
            }
            e0.L(a);
            a = application;
            e0.v(application);
        }
    }
}
