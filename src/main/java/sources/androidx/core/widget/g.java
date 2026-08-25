package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class g {

    static class a {
        static void a(EdgeEffect edgeEffect, float f5, float f6) {
            edgeEffect.onPull(f5, f6);
        }
    }

    private static class b {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f5, float f6) {
            try {
                return edgeEffect.onPullDistance(f5, f6);
            } catch (Throwable unused) {
                edgeEffect.onPull(f5, f6);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(EdgeEffect edgeEffect, float f5, float f6) {
        a.a(edgeEffect, f5, f6);
    }

    public static float d(EdgeEffect edgeEffect, float f5, float f6) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, f5, f6);
        }
        c(edgeEffect, f5, f6);
        return f5;
    }
}
