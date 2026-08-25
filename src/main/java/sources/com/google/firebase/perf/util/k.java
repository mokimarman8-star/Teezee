package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.protobuf.h1;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class k {
    private static Boolean a;

    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean b(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            a = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            uc.a.e().a("No perf logcat meta data found " + e.getMessage());
            return false;
        }
    }

    public static int c(long j) {
        if (j > 2147483647L) {
            return h1.READ_DONE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static String d(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        return parse != null ? parse.newBuilder().username(TtmlNode.ANONYMOUS_REGION_ID).password(TtmlNode.ANONYMOUS_REGION_ID).query((String) null).fragment((String) null).toString() : str;
    }

    public static String e(String str, int i) {
        HttpUrl parse;
        int lastIndexOf;
        if (str.length() <= i) {
            return str;
        }
        if (str.charAt(i) != '/' && (parse = HttpUrl.parse(str)) != null) {
            return (parse.encodedPath().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, i + (-1))) < 0) ? str.substring(0, i) : str.substring(0, lastIndexOf);
        }
        return str.substring(0, i);
    }
}
