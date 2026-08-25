package com.cloud.hisavana.sdk.common.tranmeasure;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.cloud.hisavana.sdk.b4;
import com.cloud.hisavana.sdk.r4;
import com.cloud.hisavana.sdk.v4;
import com.cloud.hisavana.sdk.w4;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class h {
    protected final Rect a = new Rect();
    protected String b = "";

    protected static h b(r4 r4Var) {
        if (r4Var == null) {
            return null;
        }
        if (r4Var.a > 0.0f) {
            return new v4();
        }
        if (r4Var.b > 0) {
            return new w4();
        }
        return null;
    }

    private boolean c(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ViewParent parent = view.getParent();
                    while (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        if (viewGroup.getVisibility() != 0) {
                            return true;
                        }
                        parent = viewGroup.getParent();
                    }
                }
            } catch (Throwable th) {
                b4.b().w("ssp", Log.getStackTraceString(th));
            }
        }
        return false;
    }

    private boolean e(View view) {
        return (view == null || view.getVisibility() != 0 || view.getAlpha() == 0.0f || !view.isAttachedToWindow() || view.getRootView() == null) ? false : true;
    }

    protected int a(r4 r4Var, View view) {
        int d;
        if (!e(view) || r4Var == null || (d = d(r4Var, view)) == 0 || c(view)) {
            return 0;
        }
        return d;
    }

    protected abstract int d(r4 r4Var, View view);
}
