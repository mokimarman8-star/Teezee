package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";
    private static String a = "";

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.killProcess(Process.myPid());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return null;
    }

    private static void b(String str) {
        String str2;
        Integer c;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = i0.a(str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (c = c(str2)) != null) {
            a = String.valueOf(c);
        } else {
            if (MBridgeConstans.DEBUG) {
                g();
                throw new RuntimeException("please don't update this value");
            }
            a = TtmlNode.ANONYMOUS_REGION_ID;
        }
    }

    private static Integer c(String str) {
        Throwable th;
        Integer num;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(C_START);
        int indexOf2 = str.indexOf(C_END);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
            return null;
        }
        try {
            num = Integer.valueOf(str.substring(indexOf + 11, indexOf2));
            try {
                if (num.intValue() > 0) {
                    return num;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return num;
            }
        } catch (Throwable th3) {
            th = th3;
            num = null;
        }
    }

    private static void g() {
        new Handler().postDelayed(new a(), 500L);
    }
}
