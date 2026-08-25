package com.tn.tranpay.helper;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public static final a a = new a();
    private static long b;
    private static int c;

    private a() {
    }

    public final boolean a(int i, long j) {
        if (c != i) {
            c = i;
            b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - b <= j) {
            return true;
        }
        c = i;
        b = System.currentTimeMillis();
        return false;
    }
}
