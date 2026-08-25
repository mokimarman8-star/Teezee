package androidx.compose.ui.graphics.layer;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f3600a = new v0();

    private v0() {
    }

    public final void a(View view) {
        view.resetPivot();
    }

    public final void b(View view, int i5) {
        view.setOutlineAmbientShadowColor(i5);
    }

    public final void c(View view, int i5) {
        view.setOutlineSpotShadowColor(i5);
    }
}
