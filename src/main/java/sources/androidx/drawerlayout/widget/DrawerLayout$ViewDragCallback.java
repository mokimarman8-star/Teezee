package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DrawerLayout$ViewDragCallback extends ViewDragHelper.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f7795a;

    /* renamed from: b, reason: collision with root package name */
    private ViewDragHelper f7796b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f7797c = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback.1
        @Override // java.lang.Runnable
        public void run() {
            DrawerLayout$ViewDragCallback.this.b();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DrawerLayout f7798d;

    DrawerLayout$ViewDragCallback(DrawerLayout drawerLayout, int i5) {
        this.f7798d = drawerLayout;
        this.f7795a = i5;
    }

    private void a() {
        View h5 = this.f7798d.h(this.f7795a == 3 ? 5 : 3);
        if (h5 != null) {
            this.f7798d.closeDrawer(h5);
        }
    }

    void b() {
        View h5;
        int width;
        int edgeSize = this.f7796b.getEdgeSize();
        boolean z5 = this.f7795a == 3;
        if (z5) {
            h5 = this.f7798d.h(3);
            width = (h5 != null ? -h5.getWidth() : 0) + edgeSize;
        } else {
            h5 = this.f7798d.h(5);
            width = this.f7798d.getWidth() - edgeSize;
        }
        if (h5 != null) {
            if (((!z5 || h5.getLeft() >= width) && (z5 || h5.getLeft() <= width)) || this.f7798d.getDrawerLockMode(h5) != 0) {
                return;
            }
            DrawerLayout$f drawerLayout$f = (DrawerLayout$f) h5.getLayoutParams();
            this.f7796b.smoothSlideViewTo(h5, width, h5.getTop());
            drawerLayout$f.f7805c = true;
            this.f7798d.invalidate();
            a();
            this.f7798d.a();
        }
    }

    public void c() {
        this.f7798d.removeCallbacks(this.f7797c);
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public int clampViewPositionHorizontal(View view, int i5, int i6) {
        if (this.f7798d.b(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i5, 0));
        }
        int width = this.f7798d.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i5, width));
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public int clampViewPositionVertical(View view, int i5, int i6) {
        return view.getTop();
    }

    public void d(ViewDragHelper viewDragHelper) {
        this.f7796b = viewDragHelper;
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public int getViewHorizontalDragRange(View view) {
        if (this.f7798d.t(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onEdgeDragStarted(int i5, int i6) {
        View h5 = (i5 & 1) == 1 ? this.f7798d.h(3) : this.f7798d.h(5);
        if (h5 == null || this.f7798d.getDrawerLockMode(h5) != 0) {
            return;
        }
        this.f7796b.captureChildView(h5, i6);
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public boolean onEdgeLock(int i5) {
        return false;
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onEdgeTouched(int i5, int i6) {
        this.f7798d.postDelayed(this.f7797c, 160L);
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onViewCaptured(View view, int i5) {
        ((DrawerLayout$f) view.getLayoutParams()).f7805c = false;
        a();
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onViewDragStateChanged(int i5) {
        this.f7798d.D(i5, this.f7796b.getCapturedView());
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onViewPositionChanged(View view, int i5, int i6, int i7, int i8) {
        float width = (this.f7798d.b(view, 3) ? i5 + r3 : this.f7798d.getWidth() - i5) / view.getWidth();
        this.f7798d.A(view, width);
        view.setVisibility(width == 0.0f ? 4 : 0);
        this.f7798d.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public void onViewReleased(View view, float f5, float f6) {
        int i5;
        float l5 = this.f7798d.l(view);
        int width = view.getWidth();
        if (this.f7798d.b(view, 3)) {
            i5 = (f5 > 0.0f || (f5 == 0.0f && l5 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = this.f7798d.getWidth();
            if (f5 < 0.0f || (f5 == 0.0f && l5 > 0.5f)) {
                width2 -= width;
            }
            i5 = width2;
        }
        this.f7796b.settleCapturedViewAt(i5, view.getTop());
        this.f7798d.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper.b
    public boolean tryCaptureView(View view, int i5) {
        return this.f7798d.t(view) && this.f7798d.b(view, this.f7795a) && this.f7798d.getDrawerLockMode(view) == 0;
    }
}
