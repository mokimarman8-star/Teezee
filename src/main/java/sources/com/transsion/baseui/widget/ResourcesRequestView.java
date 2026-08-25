package com.transsion.baseui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.R;
import com.transsion.baseui.R$anim;
import com.transsion.gslb.BuildConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/transsion/baseui/widget/ResourcesRequestView;", "Landroid/widget/FrameLayout;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "b", "()V", "d", "Landroid/view/animation/Animation;", "p0", "onAnimationEnd", "(Landroid/view/animation/Animation;)V", "onAnimationStart", "onAnimationRepeat", "count", BuildConfig.FLAVOR, "animated", "setCount", "(IZ)V", BuildConfig.FLAVOR, "title", "set", "(Ljava/lang/String;)V", "isGray", "setGray", "(Z)V", "Ljj/g;", "a", "Ljj/g;", "getMViewBinding", "()Ljj/g;", "setMViewBinding", "(Ljj/g;)V", "mViewBinding", "Landroid/view/animation/Animation;", "showTextAnim", "Landroidx/dynamicanimation/animation/d;", "c", "Landroidx/dynamicanimation/animation/d;", "springAnimation", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "numTextView", "Lcom/transsion/baseui/widget/DrawableCenterTextView;", "f", "Lcom/transsion/baseui/widget/DrawableCenterTextView;", "getIvCenterView", "()Lcom/transsion/baseui/widget/DrawableCenterTextView;", "setIvCenterView", "(Lcom/transsion/baseui/widget/DrawableCenterTextView;)V", "ivCenterView", "g", "Z", "isDirectionLtr", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResourcesRequestView extends FrameLayout implements Animation.AnimationListener {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private jj.g mViewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private Animation showTextAnim;

    /* renamed from: c, reason: from kotlin metadata */
    private androidx.dynamicanimation.animation.d springAnimation;

    /* renamed from: d, reason: from kotlin metadata */
    private final Handler handler;

    /* renamed from: e, reason: from kotlin metadata */
    private TextView numTextView;

    /* renamed from: f, reason: from kotlin metadata */
    private DrawableCenterTextView ivCenterView;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean isDirectionLtr;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            jj.g mViewBinding;
            TextView textView;
            jj.g mViewBinding2;
            TextView textView2;
            AppCompatTextView appCompatTextView;
            ViewTreeObserver viewTreeObserver;
            jj.g mViewBinding3 = ResourcesRequestView.this.getMViewBinding();
            if (mViewBinding3 != null && (appCompatTextView = mViewBinding3.e) != null && (viewTreeObserver = appCompatTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            jj.g mViewBinding4 = ResourcesRequestView.this.getMViewBinding();
            AppCompatTextView appCompatTextView2 = mViewBinding4 != null ? mViewBinding4.e : null;
            if (appCompatTextView2 == null || appCompatTextView2.getMeasuredWidth() == 0) {
                return;
            }
            TextPaint paint = appCompatTextView2.getPaint();
            Intrinsics.e(paint);
            float measureText = paint.measureText(appCompatTextView2.getText().toString());
            int compoundDrawablePadding = appCompatTextView2.getCompoundDrawablePadding();
            Drawable[] compoundDrawables = appCompatTextView2.getCompoundDrawables();
            Intrinsics.g(compoundDrawables, "getCompoundDrawables(...)");
            if (ResourcesRequestView.this.isDirectionLtr) {
                Drawable drawable = compoundDrawables[0];
                if (drawable == null || (mViewBinding2 = ResourcesRequestView.this.getMViewBinding()) == null || (textView2 = mViewBinding2.f) == null) {
                    return;
                }
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int i = (int) (compoundDrawablePadding + intrinsicWidth + measureText);
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = ((appCompatTextView2.getMeasuredWidth() / 2) + (i / 2)) - (intrinsicWidth / 3);
                textView2.setLayoutParams(bVar);
                return;
            }
            Drawable drawable2 = compoundDrawables[2];
            if (drawable2 == null || (mViewBinding = ResourcesRequestView.this.getMViewBinding()) == null || (textView = mViewBinding.f) == null) {
                return;
            }
            int intrinsicWidth2 = drawable2.getIntrinsicWidth();
            int i2 = (int) (compoundDrawablePadding + intrinsicWidth2 + measureText);
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = ((appCompatTextView2.getMeasuredWidth() / 2) + (i2 / 2)) - (intrinsicWidth2 / 3);
            textView.setLayoutParams(bVar2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        this.isDirectionLtr = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
        b();
    }

    private final void b() {
        AppCompatTextView appCompatTextView;
        ViewTreeObserver viewTreeObserver;
        Context context;
        int i;
        View.inflate(getContext(), R.layout.resources_request, this);
        jj.g a2 = jj.g.a(this);
        this.mViewBinding = a2;
        this.ivCenterView = a2 != null ? a2.e : null;
        this.numTextView = a2 != null ? a2.f : null;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.num_text_enter);
        this.showTextAnim = loadAnimation;
        if (loadAnimation == null) {
            Intrinsics.y("showTextAnim");
            loadAnimation = null;
        }
        loadAnimation.setDuration(200L);
        Animation animation = this.showTextAnim;
        if (animation == null) {
            Intrinsics.y("showTextAnim");
            animation = null;
        }
        animation.setAnimationListener(this);
        TextView textView = this.numTextView;
        if (textView != null) {
            uf.c.h(textView);
        }
        jj.g gVar = this.mViewBinding;
        androidx.dynamicanimation.animation.d dVar = new androidx.dynamicanimation.animation.d(gVar != null ? gVar.f : null, androidx.dynamicanimation.animation.b.n, 0.0f);
        dVar.n().d(0.75f);
        dVar.n().f(200.0f);
        this.springAnimation = dVar;
        TextView textView2 = this.numTextView;
        if (textView2 != null) {
            if (this.isDirectionLtr) {
                context = textView2.getContext();
                i = R.drawable.bg_num_text_6dp_bottom_right;
            } else {
                context = textView2.getContext();
                i = R.drawable.bg_num_text_6dp_bottom_left;
            }
            textView2.setBackground(g.a.b(context, i));
        }
        jj.g gVar2 = this.mViewBinding;
        if (gVar2 == null || (appCompatTextView = gVar2.e) == null || (viewTreeObserver = appCompatTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ResourcesRequestView resourcesRequestView) {
        if (resourcesRequestView.isDirectionLtr) {
            DrawableCenterTextView drawableCenterTextView = resourcesRequestView.ivCenterView;
            if (drawableCenterTextView != null) {
                drawableCenterTextView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alert, 0, 0, 0);
            }
        } else {
            DrawableCenterTextView drawableCenterTextView2 = resourcesRequestView.ivCenterView;
            if (drawableCenterTextView2 != null) {
                drawableCenterTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_alert, 0);
            }
        }
        androidx.dynamicanimation.animation.d dVar = resourcesRequestView.springAnimation;
        androidx.dynamicanimation.animation.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.y("springAnimation");
            dVar = null;
        }
        dVar.l(0.0f);
        androidx.dynamicanimation.animation.d dVar3 = resourcesRequestView.springAnimation;
        if (dVar3 == null) {
            Intrinsics.y("springAnimation");
        } else {
            dVar2 = dVar3;
        }
        dVar2.i();
    }

    private final void d() {
        BLTextView bLTextView;
        TextView textView;
        jj.g gVar = this.mViewBinding;
        if (gVar != null && (textView = gVar.b) != null) {
            uf.c.g(textView);
        }
        jj.g gVar2 = this.mViewBinding;
        if (gVar2 == null || (bLTextView = gVar2.c) == null) {
            return;
        }
        uf.c.k(bLTextView);
    }

    public static /* synthetic */ void setCount$default(ResourcesRequestView resourcesRequestView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        resourcesRequestView.setCount(i, z);
    }

    public final DrawableCenterTextView getIvCenterView() {
        return this.ivCenterView;
    }

    public final jj.g getMViewBinding() {
        return this.mViewBinding;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation p0) {
        androidx.dynamicanimation.animation.d dVar = this.springAnimation;
        androidx.dynamicanimation.animation.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.y("springAnimation");
            dVar = null;
        }
        dVar.l(1.0f);
        androidx.dynamicanimation.animation.d dVar3 = this.springAnimation;
        if (dVar3 == null) {
            Intrinsics.y("springAnimation");
        } else {
            dVar2 = dVar3;
        }
        dVar2.i();
        this.handler.postDelayed(new Runnable() { // from class: com.transsion.baseui.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                ResourcesRequestView.c(ResourcesRequestView.this);
            }
        }, 100L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation p0) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation p0) {
        TextView textView = this.numTextView;
        if (textView != null) {
            uf.c.k(textView);
        }
        f0.b(100L);
        if (this.isDirectionLtr) {
            DrawableCenterTextView drawableCenterTextView = this.ivCenterView;
            if (drawableCenterTextView != null) {
                drawableCenterTextView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alert_highlight, 0, 0, 0);
                return;
            }
            return;
        }
        DrawableCenterTextView drawableCenterTextView2 = this.ivCenterView;
        if (drawableCenterTextView2 != null) {
            drawableCenterTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_alert_highlight, 0);
        }
    }

    public final void set(String title) {
        TextView textView;
        Intrinsics.h(title, "title");
        jj.g gVar = this.mViewBinding;
        if (gVar == null || (textView = gVar.d) == null) {
            return;
        }
        textView.setText(title);
    }

    public final void setCount(int count, boolean animated) {
        TextView textView = this.numTextView;
        if (textView != null) {
            textView.setText("+" + count);
        }
        if (animated) {
            TextView textView2 = this.numTextView;
            if (textView2 != null) {
                Animation animation = this.showTextAnim;
                if (animation == null) {
                    Intrinsics.y("showTextAnim");
                    animation = null;
                }
                textView2.startAnimation(animation);
            }
            d();
            return;
        }
        if (count == 0) {
            TextView textView3 = this.numTextView;
            if (textView3 != null) {
                uf.c.h(textView3);
                return;
            }
            return;
        }
        TextView textView4 = this.numTextView;
        if (textView4 != null) {
            uf.c.k(textView4);
        }
    }

    public final void setGray(boolean isGray) {
    }

    public final void setIvCenterView(DrawableCenterTextView drawableCenterTextView) {
        this.ivCenterView = drawableCenterTextView;
    }

    public final void setMViewBinding(jj.g gVar) {
        this.mViewBinding = gVar;
    }
}
