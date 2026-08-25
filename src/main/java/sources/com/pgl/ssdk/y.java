package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class y {
    private static volatile DisplayManager.DisplayListener a;
    private static volatile boolean b;
    private static String c;
    private static String d;
    private static String e;
    private static DisplayManager f;

    static class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            y.b(i, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            y.b(i, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            y.b(i, 2);
        }
    }

    private static String a(int i) {
        Display display = f.getDisplay(i);
        return display != null ? a(display) : "pd";
    }

    public static String a(Context context) {
        Display[] displays;
        if (f == null) {
            f = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = f;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < displays.length; i++) {
            Display display = displays[i];
            if (display != null && display.getDisplayId() != 0) {
                stringBuffer.append(a(displays[i]));
                if (i != displays.length - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String a(Display display) {
        String name = display.getName();
        Object a2 = s0.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object a3 = s0.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object a4 = s0.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        return String.format("%s#%s#%b", a3, name, Boolean.valueOf((a2 == null || a4 == null || ((Integer) a2).intValue() != ((Integer) a4).intValue()) ? false : true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            String a2 = a(i);
            if (i2 == 1) {
                if (a2.equals(c)) {
                    return;
                }
                c = a2;
            } else if (i2 == 2) {
                if (a2.equals(d)) {
                    return;
                }
                d = a2;
            } else {
                if (i2 != 3 || a2.equals(e)) {
                    return;
                }
                e = a2;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context) {
        if (c == null && d == null && e == null) {
            return (context == null || TextUtils.isEmpty(a(context))) ? false : true;
        }
        return true;
    }

    public static void c(Context context) {
        Handler b2;
        if (b) {
            return;
        }
        b = true;
        if (a == null) {
            a = new a();
        }
        if (f == null) {
            f = (DisplayManager) context.getSystemService("display");
        }
        if (f == null || (b2 = o0.b()) == null) {
            return;
        }
        try {
            f.registerDisplayListener(a, b2);
        } catch (Exception unused) {
        }
    }
}
