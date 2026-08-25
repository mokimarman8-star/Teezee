package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TzV {
    public static boolean Dq(Context context) {
        if (context == null) {
            return false;
        }
        int TKC = TKC(context);
        return TKC == 2 || TKC == 3 || TKC == 4 || TKC == 5 || TKC == 6;
    }

    public static boolean EjP(Context context) {
        return TKC(context) == 4;
    }

    public static boolean HiB(Context context) {
        return TKC(context) == 5;
    }

    public static String Jcg(Context context) {
        int TKC = TKC(context);
        return TKC != 2 ? TKC != 3 ? TKC != 4 ? TKC != 5 ? TKC != 6 ? "mobile" : "5g" : "4g" : "wifi" : "3g" : "2g";
    }

    public static boolean Sj(Context context) {
        return TKC(context) != 0;
    }

    public static boolean Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS);
    }

    public static int TKC(Context context) {
        return wE.Sj(context, RecorderConstants.DEFAULT_RECORD_DURATION);
    }

    public static int sP(Context context) {
        int TKC = TKC(context);
        if (TKC == 1) {
            return 0;
        }
        if (TKC == 4) {
            return 1;
        }
        if (TKC == 5) {
            return 4;
        }
        if (TKC != 6) {
            return TKC;
        }
        return 6;
    }

    public static boolean vS(Context context) {
        return TKC(context) == 6;
    }
}
