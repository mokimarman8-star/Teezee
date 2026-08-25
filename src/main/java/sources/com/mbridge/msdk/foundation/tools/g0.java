package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g0 {
    public static int a(Context context, String str, String str2) {
        String str3 = TtmlNode.ANONYMOUS_REGION_ID;
        try {
            try {
                str3 = com.mbridge.msdk.foundation.controller.c.m().h();
            } catch (Exception unused) {
                o0.b("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + str);
            }
            if (y0.a(str3) && context != null) {
                str3 = context.getPackageName();
            }
            if (y0.a(str3) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, str3);
        } catch (Exception unused2) {
            o0.b("ResourceUtil", "Resource not found resName:" + str);
            return -1;
        }
    }

    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e) {
                o0.b("ResourceUtil", "Resource error:" + e.getMessage());
            }
        }
        return null;
    }

    public static boolean a(int i) {
        return (i == -1 || ((-16777216) & i) == 0 || (i & 16711680) == 0) ? false : true;
    }
}
