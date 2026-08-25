package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$d extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13413a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f13414b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13415c;

    SwipeRefreshLayout$d(SwipeRefreshLayout swipeRefreshLayout, int i5, int i6) {
        this.f13415c = swipeRefreshLayout;
        this.f13413a = i5;
        this.f13414b = i6;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f5, Transformation transformation) {
        this.f13415c.C.setAlpha((int) (this.f13413a + ((this.f13414b - r0) * f5)));
    }
}
