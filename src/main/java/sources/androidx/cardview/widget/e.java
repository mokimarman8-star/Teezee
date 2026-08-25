package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f1235a = Math.cos(Math.toRadians(45.0d));

    static float a(float f5, float f6, boolean z5) {
        return z5 ? (float) (f5 + ((1.0d - f1235a) * f6)) : f5;
    }

    static float b(float f5, float f6, boolean z5) {
        return z5 ? (float) ((f5 * 1.5f) + ((1.0d - f1235a) * f6)) : f5 * 1.5f;
    }
}
