package com.transsion.baseui.util;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private static long b;
    private static int c;
    public static final c a = new c();
    public static final int d = 8;

    private c() {
    }

    public final boolean a(int i, long j) {
        if (c != i) {
            c = i;
            b = System.nanoTime();
            return false;
        }
        if (System.nanoTime() - b <= j) {
            return true;
        }
        c = i;
        b = System.nanoTime();
        return false;
    }
}
