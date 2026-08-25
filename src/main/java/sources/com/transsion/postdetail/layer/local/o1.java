package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.layer.local.o1;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o1 implements Animator.AnimatorListener {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.i1
        public final Object invoke() {
            MMKV d;
            d = o1.d();
            return d;
        }
    });
    private final mn.c a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(View view) {
            o1.b.l(view);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(View view, final Function0 function0, View view2) {
            o1.b.l(view);
            view.removeCallbacks(new Runnable() { // from class: com.transsion.postdetail.layer.local.m1
                @Override // java.lang.Runnable
                public final void run() {
                    o1.a.i(function0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function0 function0) {
            function0.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Function0 function0) {
            function0.invoke();
        }

        private final void l(final View view) {
            ViewPropertyAnimator animate = view.animate();
            animate.setDuration(300L);
            animate.alpha(0.0f);
            animate.withEndAction(new Runnable() { // from class: com.transsion.postdetail.layer.local.n1
                @Override // java.lang.Runnable
                public final void run() {
                    o1.a.m(view);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(View view) {
            uf.c.g(view);
        }

        public final void f(mn.j jVar) {
            final View inflate;
            mn.l lVar;
            ViewStub viewStub;
            if (k().getBoolean("video_show_guide", false)) {
                return;
            }
            if (((jVar == null || (lVar = jVar.p) == null || (viewStub = lVar.p) == null) ? null : viewStub.getParent()) == null || (inflate = jVar.p.p.inflate()) == null) {
                return;
            }
            o1.b.k().putBoolean("video_show_guide", true);
            final Function0 function0 = new Function0() { // from class: com.transsion.postdetail.layer.local.j1
                public final Object invoke() {
                    Unit g;
                    g = o1.a.g(inflate);
                    return g;
                }
            };
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.k1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o1.a.h(inflate, function0, view);
                }
            });
            inflate.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.l1
                @Override // java.lang.Runnable
                public final void run() {
                    o1.a.j(function0);
                }
            }, 3000L);
        }

        public final MMKV k() {
            return (MMKV) o1.c.getValue();
        }
    }

    public o1(mn.c cVar) {
        Intrinsics.h(cVar, "bind");
        this.a = cVar;
        cVar.b.addAnimatorListener(this);
        cVar.c.addAnimatorListener(this);
    }

    private final void c() {
        mn.c cVar = this.a;
        VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = cVar.f;
        Intrinsics.g(videoDoubleClickBackgroundView, "vDoubleClick");
        uf.c.g(videoDoubleClickBackgroundView);
        AppCompatTextView appCompatTextView = cVar.d;
        Intrinsics.g(appCompatTextView, "tvDoubleClickLeft");
        uf.c.g(appCompatTextView);
        AppCompatTextView appCompatTextView2 = cVar.e;
        Intrinsics.g(appCompatTextView2, "tvDoubleClickRight");
        uf.c.g(appCompatTextView2);
        LottieAnimationView lottieAnimationView = cVar.b;
        Intrinsics.g(lottieAnimationView, "lottieDoubleClickLeft");
        uf.c.g(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = cVar.c;
        Intrinsics.g(lottieAnimationView2, "lottieDoubleClickRight");
        uf.c.g(lottieAnimationView2);
        cVar.b.pauseAnimation();
        cVar.c.pauseAnimation();
        ConstraintLayout root = cVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.g(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("kv_video_double");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final void e(boolean z) {
        mn.c cVar = this.a;
        VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = cVar.f;
        Intrinsics.g(videoDoubleClickBackgroundView, "vDoubleClick");
        uf.c.k(videoDoubleClickBackgroundView);
        boolean f = uf.c.f();
        cVar.f.setLeftStyle(f ? z : !z);
        if (z) {
            if (f) {
                cVar.c.setScaleX(-1.0f);
            }
            AppCompatTextView appCompatTextView = cVar.e;
            Intrinsics.g(appCompatTextView, "tvDoubleClickRight");
            uf.c.k(appCompatTextView);
            LottieAnimationView lottieAnimationView = cVar.c;
            Intrinsics.g(lottieAnimationView, "lottieDoubleClickRight");
            uf.c.k(lottieAnimationView);
            cVar.c.playAnimation();
        } else {
            if (f) {
                cVar.b.setScaleX(-1.0f);
            }
            AppCompatTextView appCompatTextView2 = cVar.d;
            Intrinsics.g(appCompatTextView2, "tvDoubleClickLeft");
            uf.c.k(appCompatTextView2);
            LottieAnimationView lottieAnimationView2 = cVar.b;
            Intrinsics.g(lottieAnimationView2, "lottieDoubleClickLeft");
            uf.c.k(lottieAnimationView2);
            cVar.b.playAnimation();
        }
        ConstraintLayout root = cVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.k(root);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics.h(animator, "animation");
        c();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.h(animator, "animation");
        c();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics.h(animator, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.h(animator, "animation");
    }
}
