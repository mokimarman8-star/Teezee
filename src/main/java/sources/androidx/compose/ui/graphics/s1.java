package androidx.compose.ui.graphics;

import android.graphics.Canvas;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class s1 {

    /* renamed from: a, reason: collision with root package name */
    public static final s1 f3633a = new s1();

    private s1() {
    }

    public final void a(Canvas canvas, boolean z5) {
        if (z5) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
