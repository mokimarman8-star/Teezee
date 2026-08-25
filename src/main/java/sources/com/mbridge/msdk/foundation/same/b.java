package com.mbridge.msdk.foundation.same;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private static volatile b b;
    private Boolean a = null;

    private b() {
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public Boolean a() {
        return this.a;
    }
}
