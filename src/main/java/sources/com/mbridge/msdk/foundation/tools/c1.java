package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c1 {
    private static final AtomicInteger a = new AtomicInteger(1);

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void a(Window window) {
        if (window != null) {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (i >= 30) {
                        com.cloud.hisavana.sdk.common.activity.d.a(attributes, 3);
                    } else {
                        com.cloud.hisavana.sdk.common.activity.d.a(attributes, 1);
                    }
                    window.setAttributes(attributes);
                }
            } catch (Throwable th) {
                o0.b("ViewUtil", th.getMessage());
            }
        }
    }
}
