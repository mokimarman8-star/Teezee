package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    long f7329a;

    /* renamed from: b, reason: collision with root package name */
    boolean f7330b;

    /* renamed from: c, reason: collision with root package name */
    boolean f7331c;

    /* renamed from: d, reason: collision with root package name */
    boolean f7332d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f7333e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f7334f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7329a = -1L;
        this.f7330b = false;
        this.f7331c = false;
        this.f7332d = false;
        this.f7333e = new Runnable() { // from class: androidx.core.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.f();
            }
        };
        this.f7334f = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.g();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f7332d = true;
        removeCallbacks(this.f7334f);
        this.f7331c = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j5 = this.f7329a;
        long j6 = currentTimeMillis - j5;
        if (j6 >= 500 || j5 == -1) {
            setVisibility(8);
        } else {
            if (this.f7330b) {
                return;
            }
            postDelayed(this.f7333e, 500 - j6);
            this.f7330b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f7330b = false;
        this.f7329a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f7331c = false;
        if (this.f7332d) {
            return;
        }
        this.f7329a = System.currentTimeMillis();
        setVisibility(0);
    }

    private void h() {
        removeCallbacks(this.f7333e);
        removeCallbacks(this.f7334f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f7329a = -1L;
        this.f7332d = false;
        removeCallbacks(this.f7333e);
        this.f7330b = false;
        if (this.f7331c) {
            return;
        }
        postDelayed(this.f7334f, 500L);
        this.f7331c = true;
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.e();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.i();
            }
        });
    }
}
