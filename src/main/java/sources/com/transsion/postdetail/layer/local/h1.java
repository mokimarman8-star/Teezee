package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h1 {
    private final TextView a;
    private final TextView b;
    private long c;
    private int d = 1;
    private final Runnable e = new Runnable() { // from class: com.transsion.postdetail.layer.local.f1
        @Override // java.lang.Runnable
        public final void run() {
            h1.e(h1.this);
        }
    };
    private final Runnable f = new Runnable() { // from class: com.transsion.postdetail.layer.local.g1
        @Override // java.lang.Runnable
        public final void run() {
            h1.f(h1.this);
        }
    };

    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ TextView b;
        final /* synthetic */ String c;

        a(TextView textView, String str) {
            this.b = textView;
            this.c = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.h(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.h(animator, "animation");
            h1.this.c = System.currentTimeMillis();
            TextView textView = this.b;
            if (textView != null) {
                uf.c.k(textView);
            }
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(this.c);
            }
        }
    }

    public h1(TextView textView, TextView textView2) {
        this.a = textView;
        this.b = textView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(h1 h1Var) {
        TextView textView = h1Var.a;
        if (textView != null) {
            uf.c.g(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h1 h1Var) {
        TextView textView = h1Var.b;
        if (textView != null) {
            uf.c.g(textView);
        }
    }

    private final void g(String str, long j, TextView textView, long j2, Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        if (textView != null) {
            uf.c.g(textView);
        }
        ofFloat.addListener(new a(textView, str));
        ofFloat.setStartDelay(j);
        ofFloat.start();
        if (j2 <= 0 || textView == null) {
            return;
        }
        textView.postDelayed(runnable, j2);
    }

    public static /* synthetic */ void i(h1 h1Var, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 3000;
        }
        h1Var.h(str, j);
    }

    public final void d() {
        TextView textView = this.a;
        if (textView != null) {
            uf.c.g(textView);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            uf.c.g(textView2);
        }
    }

    public final void h(String str, long j) {
        TextView textView;
        Intrinsics.h(str, "content");
        TextView textView2 = this.a;
        if (textView2 != null && uf.c.i(textView2) && (textView = this.b) != null && uf.c.i(textView)) {
            int i = this.d;
            TextView textView3 = i == 1 ? this.b : this.a;
            Runnable runnable = i == 1 ? this.f : this.e;
            textView3.removeCallbacks(runnable);
            g(str, 0L, textView3, j, runnable);
            this.d = this.d != 1 ? 1 : 2;
            return;
        }
        TextView textView4 = this.a;
        if (textView4 == null || !uf.c.i(textView4)) {
            this.d = 1;
            g(str, 0L, this.a, j, this.e);
        } else {
            long j2 = System.currentTimeMillis() - this.c < 500 ? 500L : 0L;
            this.d = 2;
            g(str, j2, this.b, j, this.f);
        }
    }
}
