package androidx.compose.ui.platform;

import android.view.MotionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final f1 f4776a = new f1();

    private f1() {
    }

    public final boolean a(MotionEvent motionEvent, int i5) {
        float rawX;
        float rawY;
        rawX = motionEvent.getRawX(i5);
        if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
            rawY = motionEvent.getRawY(i5);
            if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                return true;
            }
        }
        return false;
    }
}
