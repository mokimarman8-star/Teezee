package com.transsion.baseui.util;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i {
    private static long b;
    private static long c;
    public static final i a = new i();
    public static final int d = 8;

    private i() {
    }

    public final String a(long j) {
        long currentTimeMillis = (System.currentTimeMillis() - c) / 1000;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 1;
        }
        c = System.currentTimeMillis();
        long j2 = (j - b) / currentTimeMillis;
        b = j;
        if (j2 <= 0) {
            return "0KB/s";
        }
        return zg.b.a(j2, 1) + "/s";
    }
}
