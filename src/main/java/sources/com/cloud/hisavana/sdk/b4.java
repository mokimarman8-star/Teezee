package com.cloud.hisavana.sdk;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b4 extends com.cloud.sdk.commonutil.util.c {
    private static b4 a;
    private static final boolean b = Log.isLoggable("ADSDK", 3);

    public static synchronized b4 b() {
        b4 b4Var;
        synchronized (b4.class) {
            try {
                if (a == null) {
                    synchronized (b4.class) {
                        try {
                            if (a == null) {
                                a = new b4();
                            }
                        } finally {
                        }
                    }
                }
                b4Var = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return b4Var;
    }

    public static boolean c() {
        return b;
    }

    @Override // com.cloud.sdk.commonutil.util.c
    public String getGlobalTag() {
        return "ADSDK_S";
    }
}
