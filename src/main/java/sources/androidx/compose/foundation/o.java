package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f2143a = new o();

    private o() {
    }

    public final EdgeEffect a(Context context) {
        return Build.VERSION.SDK_INT >= 31 ? b.f1612a.a(context, null) : new u(context);
    }

    public final float b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.f1612a.b(edgeEffect);
        }
        return 0.0f;
    }

    public final void c(EdgeEffect edgeEffect, int i5) {
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i5);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i5);
        }
    }

    public final float d(EdgeEffect edgeEffect, float f5, float f6) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.f1612a.c(edgeEffect, f5, f6);
        }
        edgeEffect.onPull(f5, f6);
        return f5;
    }

    public final void e(EdgeEffect edgeEffect, float f5) {
        if (edgeEffect instanceof u) {
            ((u) edgeEffect).a(f5);
        } else {
            edgeEffect.onRelease();
        }
    }
}
