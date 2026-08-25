package com.transsion.player.longvideo.helper;

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
public final class i implements Animator.AnimatorListener {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.h
        public final Object invoke() {
            MMKV c2;
            c2 = i.c();
            return c2;
        }
    });
    private final mn.c a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i(mn.c cVar) {
        Intrinsics.h(cVar, "bind");
        this.a = cVar;
        cVar.b.addAnimatorListener(this);
        cVar.c.addAnimatorListener(this);
    }

    private final void b() {
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
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_video_double");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final void d(boolean z) {
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
