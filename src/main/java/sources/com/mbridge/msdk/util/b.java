package com.mbridge.msdk.util;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private static volatile Boolean a;
    private static volatile Boolean b;

    public static boolean a() {
        if (a == null) {
            try {
                boolean z = Integer.parseInt(String.valueOf("MAL_16.9.71".charAt(10))) == 2;
                a = Boolean.valueOf(z);
                return z;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonUtils", "isChina", e);
                }
            }
        }
        return a != null && a.booleanValue();
    }

    public static boolean b() {
        if (b == null) {
            try {
                boolean z = Integer.parseInt(String.valueOf("MAL_16.9.71".charAt(10))) == 1;
                b = Boolean.valueOf(z);
                return z;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonUtils", "isOversea", e);
                }
            }
        }
        return b != null && b.booleanValue();
    }
}
