package com.transsion.postdetail.util;

import android.app.Activity;
import android.view.Window;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s {
    public static final s a = new s();

    private s() {
    }

    public final String a(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (1 > intValue || intValue >= 10) {
            return String.valueOf(intValue);
        }
        return "0" + intValue;
    }

    public final void b(Activity activity, boolean z) {
        Window window = activity != null ? activity.getWindow() : null;
        if (z) {
            if (window != null) {
                window.addFlags(128);
            }
        } else if (window != null) {
            window.clearFlags(128);
        }
    }
}
