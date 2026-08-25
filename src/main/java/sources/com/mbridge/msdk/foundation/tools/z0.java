package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.net.URL;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class z0 {
    public static String a(String str) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? TtmlNode.ANONYMOUS_REGION_ID : new URL(str).getHost();
        } catch (Exception e) {
            o0.b("UriUtil", e.getMessage());
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    public static String a(String str, String str2) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? str : Uri.parse(str).getQueryParameter(str2);
        } catch (Exception e) {
            o0.b("UriUtil", e.getMessage());
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    public static String b(String str) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? str : new URL(str).getPath();
        } catch (Exception e) {
            o0.b("UriUtil", e.getMessage());
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    public static int c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (!URLUtil.isValidUrl(str) && !e(str)) {
                return 0;
            }
            return Uri.parse(str).getQueryParameterNames().size();
        } catch (Exception e) {
            o0.b("UriUtil", e.getMessage());
            return 0;
        }
    }

    public static String d(String str) {
        try {
            Uri parse = Uri.parse(str);
            return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
        } catch (Exception e) {
            o0.b("UriUtil", e.getMessage());
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    public static boolean e(String str) {
        return str != null && str.length() > 5 && str.substring(0, 6).equalsIgnoreCase("tcp://");
    }
}
