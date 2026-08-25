package com.google.firebase.installations;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h {
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    private static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");
    private static h d;
    private final nc.a a;

    private h(nc.a aVar) {
        this.a = aVar;
    }

    public static h c() {
        return d(nc.b.a());
    }

    public static h d(nc.a aVar) {
        if (d == null) {
            d = new h(aVar);
        }
        return d;
    }

    static boolean g(String str) {
        return c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(com.google.firebase.installations.local.b bVar) {
        return TextUtils.isEmpty(bVar.b()) || bVar.h() + bVar.c() < b() + b;
    }
}
