package com.danikula.videocache;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class l {
    static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void b(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static Object c(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
