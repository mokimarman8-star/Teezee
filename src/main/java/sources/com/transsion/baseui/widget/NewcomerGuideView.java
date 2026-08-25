package com.transsion.baseui.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.baseui.R;
import com.transsion.baseui.R$bool;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u0010H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0010H\u0014¢\u0006\u0004\b%\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00108\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u0010:\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00103R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00103¨\u0006="}, d2 = {"Lcom/transsion/baseui/widget/NewcomerGuideView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "startWidth", "startHeight", "endWidth", "endHeight", BuildConfig.FLAVOR, "j", "(IIII)V", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "i", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "targetView", "step", "totalStep", "newBgSpace", "setTargetView", "(Landroid/view/View;III)V", "resId", "setTipsText", "(I)V", "color", "setSetBgColor", "onAttachedToWindow", "()V", "onDetachedFromWindow", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "TAG", "Ljj/d;", "b", "Ljj/d;", "viewBinding", "Landroid/animation/ValueAnimator;", "c", "Landroid/animation/ValueAnimator;", "bgAnima", "d", "I", "screenWidth", "e", "screenHeight", "f", "bgSpace", "g", "animaBgSpace", "h", "guideHeight", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NewcomerGuideView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final jj.d viewBinding;

    /* renamed from: c, reason: from kotlin metadata */
    private ValueAnimator bgAnima;

    /* renamed from: d, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private final int screenHeight;

    /* renamed from: f, reason: from kotlin metadata */
    private final int bgSpace;

    /* renamed from: g, reason: from kotlin metadata */
    private final int animaBgSpace;

    /* renamed from: h, reason: from kotlin metadata */
    private final int guideHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewcomerGuideView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewcomerGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NewcomerGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "NewcomerGuide";
        this.screenWidth = y.e();
        this.screenHeight = y.c() - com.blankj.utilcode.util.d.c();
        this.bgSpace = a0.a(16.0f);
        this.animaBgSpace = a0.a(40.0f);
        this.guideHeight = a0.a(200.0f);
        View.inflate(context, R.layout.layout_newcomer_guide, this);
        setBackgroundResource(com.tn.lib.widget.R.color.cl31_70_p);
        jj.d a = jj.d.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
    }

    private final Bitmap i(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.g(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(final int startWidth, final int startHeight, final int endWidth, final int endHeight) {
        final int color = androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.cl38_50_p);
        Drawable background = this.viewBinding.f.getBackground();
        Intrinsics.f(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        final GradientDrawable gradientDrawable = (GradientDrawable) background;
        final ViewGroup.LayoutParams layoutParams = this.viewBinding.f.getLayoutParams();
        final int i = 0;
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(color), 0);
        this.bgAnima = ofObject;
        if (ofObject != null) {
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.baseui.widget.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NewcomerGuideView.k(gradientDrawable, color, i, layoutParams, startWidth, endWidth, startHeight, endHeight, this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.bgAnima;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.bgAnima;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(2000L);
        }
        ValueAnimator valueAnimator3 = this.bgAnima;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GradientDrawable gradientDrawable, int i, int i2, ViewGroup.LayoutParams layoutParams, int i3, int i4, int i5, int i6, NewcomerGuideView newcomerGuideView, ValueAnimator valueAnimator) {
        Intrinsics.h(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        gradientDrawable.setColor(((Integer) animatedValue).intValue());
        float f = ((i - r10) * 1.0f) / (i - i2);
        layoutParams.width = i3 + ((int) ((i4 - i3) * f));
        layoutParams.height = i5 + ((int) ((i6 - i5) * f));
        newcomerGuideView.viewBinding.f.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void setTargetView$default(NewcomerGuideView newcomerGuideView, View view, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        newcomerGuideView.setTargetView(view, i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        ValueAnimator valueAnimator;
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        ValueAnimator valueAnimator2 = this.bgAnima;
        if (valueAnimator2 == null || valueAnimator2.isStarted() || (valueAnimator = this.bgAnima) == null) {
            return;
        }
        valueAnimator.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.bgAnima;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void setSetBgColor(int color) {
        Drawable background = this.viewBinding.g.getBackground();
        Intrinsics.f(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTargetView(View targetView, int step, int totalStep, int newBgSpace) {
        String str;
        Intrinsics.h(targetView, "targetView");
        int[] iArr = new int[2];
        targetView.getLocationOnScreen(iArr);
        ConstraintLayout.b layoutParams = this.viewBinding.c.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = targetView.getMeasuredHeight();
        ((ViewGroup.MarginLayoutParams) bVar).width = targetView.getMeasuredWidth();
        bVar.i = 0;
        Bitmap i = i(targetView);
        if (i != null) {
            a.a.f(wf.a.a, this.TAG, "setImageBitmap  step = " + step, false, 4, (Object) null);
            this.viewBinding.c.setImageBitmap(i);
        }
        ViewGroup.LayoutParams layoutParams2 = this.viewBinding.e.getLayoutParams();
        Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams3 = (ConstraintLayout.b) layoutParams2;
        ViewGroup.LayoutParams layoutParams4 = this.viewBinding.b.getLayoutParams();
        Intrinsics.f(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams5 = (ConstraintLayout.b) layoutParams4;
        ViewGroup.LayoutParams layoutParams6 = this.viewBinding.d.getLayoutParams();
        Intrinsics.f(layoutParams6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams7 = (ConstraintLayout.b) layoutParams6;
        boolean z = getContext().getResources().getBoolean(R$bool.is_rtl);
        boolean z2 = !z;
        char c = 1;
        boolean z3 = this.screenWidth / 2 > iArr[0] + (targetView.getMeasuredWidth() / 2);
        if (z || !z3) {
            a.a.f(wf.a.a, this.TAG, "location end", false, 4, (Object) null);
            bVar.v = 0;
            ((ConstraintLayout.b) layoutParams3).v = 0;
            bVar.setMarginEnd(!z ? (this.screenWidth - iArr[0]) - targetView.getMeasuredWidth() : iArr[0]);
            c = 1;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = iArr[1];
        } else {
            a.a.f(wf.a.a, this.TAG, "location start", false, 4, (Object) null);
            bVar.t = 0;
            ((ConstraintLayout.b) layoutParams3).t = 0;
            bVar.setMarginStart(iArr[0]);
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = iArr[1];
        }
        if (this.screenHeight - iArr[c] < this.guideHeight) {
            this.viewBinding.b.setScaleY(-1.0f);
            ((ConstraintLayout.b) layoutParams5).k = R.id.v_guide_bg;
            ((ConstraintLayout.b) layoutParams3).k = R.id.iv_guide_line;
            ((ConstraintLayout.b) layoutParams7).k = R.id.tv_guide_tips;
        } else {
            ((ConstraintLayout.b) layoutParams5).j = R.id.v_guide_bg;
            ((ConstraintLayout.b) layoutParams3).j = R.id.iv_guide_line;
            ((ConstraintLayout.b) layoutParams7).j = R.id.tv_guide_tips;
        }
        this.viewBinding.d.setLayoutParams(layoutParams7);
        this.viewBinding.b.setLayoutParams(layoutParams5);
        this.viewBinding.c.setLayoutParams(bVar);
        this.viewBinding.e.setLayoutParams(layoutParams3);
        ConstraintLayout.b layoutParams8 = this.viewBinding.g.getLayoutParams();
        Intrinsics.f(layoutParams8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = layoutParams8;
        ((ViewGroup.MarginLayoutParams) bVar2).height = targetView.getMeasuredHeight() + (newBgSpace > 0 ? newBgSpace : this.bgSpace);
        ((ViewGroup.MarginLayoutParams) bVar2).width = targetView.getMeasuredWidth() + (newBgSpace > 0 ? newBgSpace : this.bgSpace);
        this.viewBinding.g.setLayoutParams(bVar2);
        AppCompatImageView appCompatImageView = this.viewBinding.c;
        Intrinsics.g(appCompatImageView, "ivGuideTarget");
        uf.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.viewBinding.b;
        Intrinsics.g(appCompatImageView2, "ivGuideLine");
        uf.c.k(appCompatImageView2);
        AppCompatTextView appCompatTextView = this.viewBinding.e;
        Intrinsics.g(appCompatTextView, "tvGuideTips");
        uf.c.k(appCompatTextView);
        AppCompatTextView appCompatTextView2 = this.viewBinding.d;
        Intrinsics.g(appCompatTextView2, "tvGuideButton");
        uf.c.k(appCompatTextView2);
        if (step < totalStep) {
            str = "Next " + step + "/" + totalStep;
        } else if (totalStep == 1) {
            str = "Done";
        } else {
            str = "Done " + step + "/" + totalStep;
        }
        String str2 = str;
        if (totalStep > 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, StringsKt.o0(str2, "/", 0, false, 6, (Object) null), 17);
            this.viewBinding.d.setText(spannableStringBuilder);
        } else {
            this.viewBinding.d.setText(str2);
        }
        int i2 = ((ViewGroup.MarginLayoutParams) bVar2).width;
        int i3 = ((ViewGroup.MarginLayoutParams) bVar2).height;
        int i4 = this.animaBgSpace;
        j(i2, i3, i2 + i4, i4 + i3);
        a.a.f(wf.a.a, this.TAG, "screenWidth = " + this.screenWidth + ", X = " + iArr[0] + ", screenHeight = " + this.screenHeight + ", Y = " + iArr[1] + ", width = " + targetView.getWidth() + ", isLeft = " + z3 + ", ltr = " + z2, false, 4, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTipsText(int resId) {
        this.viewBinding.e.setText(getContext().getString(resId));
    }
}
