package com.mbridge.msdk.foundation.same.net.utils;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private static final String a = "b";

    public static void a(e eVar, String str, String str2) {
        if (eVar != null) {
            try {
                if (!y0.a(str) && !y0.a(str2)) {
                    eVar.a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith("http")) {
                str = z0.a(str);
            }
            TextUtils.isEmpty(str);
        } catch (Throwable th) {
            o0.b(a, th.getMessage());
        }
    }
}
