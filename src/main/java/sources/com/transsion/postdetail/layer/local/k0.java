package com.transsion.postdetail.layer.local;

import android.animation.Animator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mmkv.MMKV;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k0 implements Animator.AnimatorListener {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.j0
        public final Object invoke() {
            MMKV c2;
            c2 = k0.c();
            return c2;
        }
    });
    private final wn.v a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k0(wn.v vVar) {
        Intrinsics.h(vVar, "bind");
        this.a = vVar;
        vVar.b.addAnimatorListener(this);
        vVar.c.addAnimatorListener(this);
    }

    private final void b() {
        wn.v vVar = this.a;
        VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = vVar.f;
        Intrinsics.g(videoDoubleClickBackgroundView, "vDoubleClick");
        uf.c.g(videoDoubleClickBackgroundView);
        AppCompatTextView appCompatTextView = vVar.d;
        Intrinsics.g(appCompatTextView, "tvDoubleClickLeft");
        uf.c.g(appCompatTextView);
        AppCompatTextView appCompatTextView2 = vVar.e;
        Intrinsics.g(appCompatTextView2, "tvDoubleClickRight");
        uf.c.g(appCompatTextView2);
        LottieAnimationView lottieAnimationView = vVar.b;
        Intrinsics.g(lottieAnimationView, "lottieDoubleClickLeft");
        uf.c.g(lottieAnimationView);
        LottieAnimationView lottieAnimationView2 = vVar.c;
        Intrinsics.g(lottieAnimationView2, "lottieDoubleClickRight");
        uf.c.g(lottieAnimationView2);
        vVar.b.pauseAnimation();
        vVar.c.pauseAnimation();
        ConstraintLayout root = vVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.g(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_video_double");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final void d(boolean z) {
        wn.v vVar = this.a;
        VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = vVar.f;
        Intrinsics.g(videoDoubleClickBackgroundView, "vDoubleClick");
        uf.c.k(videoDoubleClickBackgroundView);
        vVar.f.setLeftStyle(!z);
        if (z) {
            AppCompatTextView appCompatTextView = vVar.e;
            Intrinsics.g(appCompatTextView, "tvDoubleClickRight");
            uf.c.k(appCompatTextView);
            LottieAnimationView lottieAnimationView = vVar.c;
            Intrinsics.g(lottieAnimationView, "lottieDoubleClickRight");
            uf.c.k(lottieAnimationView);
            vVar.c.playAnimation();
        } else {
            AppCompatTextView appCompatTextView2 = vVar.d;
            Intrinsics.g(appCompatTextView2, "tvDoubleClickLeft");
            uf.c.k(appCompatTextView2);
            LottieAnimationView lottieAnimationView2 = vVar.b;
            Intrinsics.g(lottieAnimationView2, "lottieDoubleClickLeft");
            uf.c.k(lottieAnimationView2);
            vVar.b.playAnimation();
        }
        ConstraintLayout root = vVar.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.k(root);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics.h(animator, "animation");
        b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.h(animator, "animation");
        b();
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
