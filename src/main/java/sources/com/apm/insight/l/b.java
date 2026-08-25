package com.apm.insight.l;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b {
    private static DateFormat a;

    public static DateFormat a() {
        if (a == null) {
            a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return a;
    }
}
