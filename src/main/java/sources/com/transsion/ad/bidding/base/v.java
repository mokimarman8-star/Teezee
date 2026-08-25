package com.transsion.ad.bidding.base;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class v {
    public static final v a = new v();
    private static boolean b;

    private v() {
    }

    public final boolean a(int i) {
        return i == 3 || i == 4 || i == 5;
    }

    public final boolean b() {
        return b;
    }

    public final void c() {
        b = false;
    }

    public final void d() {
        b = true;
    }
}
