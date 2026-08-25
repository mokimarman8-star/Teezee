package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1612a = new b();

    private b() {
    }

    public final EdgeEffect a(Context context, AttributeSet attributeSet) {
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    public final float b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public final float c(EdgeEffect edgeEffect, float f5, float f6) {
        try {
            return edgeEffect.onPullDistance(f5, f6);
        } catch (Throwable unused) {
            edgeEffect.onPull(f5, f6);
            return 0.0f;
        }
    }
}
