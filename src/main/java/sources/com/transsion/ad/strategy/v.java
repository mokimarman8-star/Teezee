package com.transsion.ad.strategy;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v {
    public static final v a = new v();
    private static Boolean b;

    private v() {
    }

    public final boolean a() {
        if (b == null) {
            b = Boolean.valueOf(e.a.c().getBoolean("mmkv_key_teen_mode", false));
        }
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void b(boolean z) {
        e.a.c().putBoolean("mmkv_key_teen_mode", z);
        b = Boolean.valueOf(z);
    }
}
