package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f4001a = new k();

    private k() {
    }

    public final long a(MotionEvent motionEvent, int i5) {
        float rawX;
        float rawY;
        rawX = motionEvent.getRawX(i5);
        rawY = motionEvent.getRawY(i5);
        return y.h.a(rawX, rawY);
    }
}
