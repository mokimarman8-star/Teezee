package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.integration.utils.ext.CommonExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class MiniappLaunchLoadingView extends ConstraintLayout {
    public TranslateAnimation OooO;
    public AppCompatImageView OooO00o;
    public LinearLayoutCompat OooO0O0;
    public Integer OooO0OO;
    public final String OooO0Oo;
    public boolean OooO0o;
    public int OooO0o0;
    public boolean OooO0oO;
    public AnimationSet OooO0oo;
    public final Runnable OooOO0;

    public static final class OooO00o implements Animation.AnimationListener {
        public OooO00o() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MiniappLaunchLoadingView.this.getRepeatCount() >= 4) {
                MiniappLaunchLoadingView.this.setRepeatCount(1);
            } else {
                MiniappLaunchLoadingView miniappLaunchLoadingView = MiniappLaunchLoadingView.this;
                miniappLaunchLoadingView.setRepeatCount(miniappLaunchLoadingView.getRepeatCount() + 1);
            }
            if (MiniappLaunchLoadingView.this.getRepeatAnimation()) {
                ExecutorUtils.runOnMain(MiniappLaunchLoadingView.this.getAnimationRunnable(), 300L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (MiniappLaunchLoadingView.this.getRepeatCount() != 0) {
                float f = ViewUtils.isLayoutRtl() ? -90.0f : 90.0f;
                View view = MiniappLaunchLoadingView.this.OooO00o;
                if (view == null) {
                    Intrinsics.y("mLoadingImg");
                    view = null;
                }
                view.setRotation(MiniappLaunchLoadingView.this.getRepeatCount() * f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.OooO0OO = 1;
        this.OooO0Oo = "MiniappLaunchLoadingView";
        this.OooO0oO = true;
        this.OooOO0 = new Runnable() { // from class: com.cloud.tmc.miniapp.widget.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniappLaunchLoadingView.OooO00o(MiniappLaunchLoadingView.this);
            }
        };
    }

    public /* synthetic */ MiniappLaunchLoadingView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void OooO00o(MiniappLaunchLoadingView miniappLaunchLoadingView) {
        Intrinsics.h(miniappLaunchLoadingView, "this$0");
        miniappLaunchLoadingView.OooO00o();
    }

    public static final void OooO0O0(MiniappLaunchLoadingView miniappLaunchLoadingView) {
        float f;
        Intrinsics.h(miniappLaunchLoadingView, "this$0");
        View view = null;
        if (miniappLaunchLoadingView.OooO0o0 == 0) {
            View view2 = miniappLaunchLoadingView.OooO00o;
            if (view2 == null) {
                Intrinsics.y("mLoadingImg");
                view2 = null;
            }
            view2.setRotation(0.0f);
            miniappLaunchLoadingView.OooO0oO = true;
        }
        miniappLaunchLoadingView.OooO0o = true;
        if (miniappLaunchLoadingView.OooO0oo == null) {
            miniappLaunchLoadingView.OooO0oo = new AnimationSet(false);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, ViewUtils.isLayoutRtl() ? -90.0f : 90.0f, 1, ViewUtils.isLayoutRtl() ? 0.0f : 1.0f, 1, 1.0f);
            View view3 = miniappLaunchLoadingView.OooO00o;
            if (view3 == null) {
                Intrinsics.y("mLoadingImg");
                view3 = null;
            }
            float width = view3.getWidth();
            if (width == 0.0f) {
                try {
                    f = SizeUtils.dp2px(72.0f);
                } catch (Throwable unused) {
                    f = 0.0f;
                }
            } else {
                f = width;
            }
            TmcLogger.d(miniappLaunchLoadingView.OooO0Oo, "img width " + width + " is " + f);
            if (!ViewUtils.isLayoutRtl()) {
                f = -f;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, f, 0.0f, 0.0f);
            AnimationSet animationSet = miniappLaunchLoadingView.OooO0oo;
            if (animationSet != null) {
                animationSet.setFillAfter(true);
            }
            AnimationSet animationSet2 = miniappLaunchLoadingView.OooO0oo;
            if (animationSet2 != null) {
                animationSet2.setDuration(500L);
            }
            AnimationSet animationSet3 = miniappLaunchLoadingView.OooO0oo;
            if (animationSet3 != null) {
                animationSet3.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            AnimationSet animationSet4 = miniappLaunchLoadingView.OooO0oo;
            if (animationSet4 != null) {
                animationSet4.addAnimation(rotateAnimation);
            }
            AnimationSet animationSet5 = miniappLaunchLoadingView.OooO0oo;
            if (animationSet5 != null) {
                animationSet5.addAnimation(translateAnimation);
            }
            AnimationSet animationSet6 = miniappLaunchLoadingView.OooO0oo;
            if (animationSet6 != null) {
                animationSet6.setAnimationListener(miniappLaunchLoadingView.new OooO00o());
            }
        }
        View view4 = miniappLaunchLoadingView.OooO00o;
        if (view4 == null) {
            Intrinsics.y("mLoadingImg");
            view4 = null;
        }
        view4.startAnimation(miniappLaunchLoadingView.OooO0oo);
        float dp2px = CommonExtKt.getDp2px(68.0f);
        if (miniappLaunchLoadingView.OooO == null) {
            if (!ViewUtils.isLayoutRtl()) {
                dp2px = -dp2px;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, dp2px, 0.0f, 0.0f);
            miniappLaunchLoadingView.OooO = translateAnimation2;
            translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
            TranslateAnimation translateAnimation3 = miniappLaunchLoadingView.OooO;
            if (translateAnimation3 != null) {
                translateAnimation3.setDuration(500L);
            }
            TranslateAnimation translateAnimation4 = miniappLaunchLoadingView.OooO;
            if (translateAnimation4 != null) {
                translateAnimation4.setFillAfter(true);
            }
        }
        TranslateAnimation translateAnimation5 = miniappLaunchLoadingView.OooO;
        if (translateAnimation5 != null) {
            translateAnimation5.start();
        }
        View view5 = miniappLaunchLoadingView.OooO0O0;
        if (view5 == null) {
            Intrinsics.y("llBottom");
        } else {
            view = view5;
        }
        view.startAnimation(miniappLaunchLoadingView.OooO);
    }

    public final void OooO00o() {
        try {
            View view = this.OooO00o;
            if (view == null) {
                Intrinsics.y("mLoadingImg");
                view = null;
            }
            view.post(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniappLaunchLoadingView.OooO0O0(MiniappLaunchLoadingView.this);
                }
            });
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0Oo, th);
        }
    }

    public final Runnable getAnimationRunnable() {
        return this.OooOO0;
    }

    public final boolean getAnimationRunning() {
        return this.OooO0o;
    }

    public final AnimationSet getAnimationSet() {
        return this.OooO0oo;
    }

    public final boolean getRepeatAnimation() {
        return this.OooO0oO;
    }

    public final int getRepeatCount() {
        return this.OooO0o0;
    }

    public final TranslateAnimation getSquareTranslate() {
        return this.OooO;
    }

    public final void setAnimationRunning(boolean z) {
        this.OooO0o = z;
    }

    public final void setAnimationSet(AnimationSet animationSet) {
        this.OooO0oo = animationSet;
    }

    public final void setRepeatAnimation(boolean z) {
        this.OooO0oO = z;
    }

    public final void setRepeatCount(int i) {
        this.OooO0o0 = i;
    }

    public final void setSquareTranslate(TranslateAnimation translateAnimation) {
        this.OooO = translateAnimation;
    }
}
