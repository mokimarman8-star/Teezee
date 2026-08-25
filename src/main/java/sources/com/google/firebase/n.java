package com.google.firebase;

import android.os.SystemClock;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class n {
    public static n a(long j, long j2, long j3) {
        return new a(j, j2, j3);
    }

    public static n e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
