package com.transsion.ad.view.native_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import ci.g;
import ci.q;
import com.blankj.utilcode.util.a0;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.R;
import com.transsion.ad.bidding.base.AbsBiddingBuyOutView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u00013\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView;", "Lcom/transsion/ad/bidding/base/AbsBiddingBuyOutView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "l", "()V", "p", "q", "o", "Landroid/widget/FrameLayout;", "getMediaContainer", "()Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "isShowVolumeIcon", "()Z", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "onAdViewDestroy", "isCollapsed", "changeState", "(Z)V", "loadAd", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "Z", BuildConfig.FLAVOR, "r", "F", "currentTranslationX", "s", "Landroid/widget/FrameLayout;", "mediaContainer", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "closeImg", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "u", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "com/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView$a", "v", "Lcom/transsion/ad/view/native_ad/BiddingFloatingIrregularAnimationView$a;", "adListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BiddingFloatingIrregularAnimationView extends AbsBiddingBuyOutView {

    /* renamed from: p, reason: from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isCollapsed;

    /* renamed from: r, reason: from kotlin metadata */
    private float currentTranslationX;

    /* renamed from: s, reason: from kotlin metadata */
    private final FrameLayout mediaContainer;

    /* renamed from: t, reason: from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: u, reason: from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: v, reason: from kotlin metadata */
    private final a adListener;

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            BiddingFloatingIrregularAnimationView.this.setVisibility(8);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            BiddingFloatingIrregularAnimationView.this.setEcpmObject(biddingIntermediateMaterialBean);
            BiddingFloatingIrregularAnimationView.this.showMedia();
            BiddingFloatingIrregularAnimationView.this.closeImg.setVisibility(0);
            BiddingFloatingIrregularAnimationView.this.setVisibility(0);
        }
    }

    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ float b;

        b(float f) {
            this.b = f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = this.b;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class c implements Animation.AnimationListener {
        final /* synthetic */ float b;

        c(float f) {
            this.b = f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = this.b;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BiddingFloatingIrregularAnimationView.this.currentTranslationX = 0.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class e extends RecyclerView.r {
        e() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                BiddingFloatingIrregularAnimationView.this.changeState(false);
            } else {
                if (i != 1) {
                    return;
                }
                BiddingFloatingIrregularAnimationView.this.changeState(true);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BiddingFloatingIrregularAnimationView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingFloatingIrregularAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mediaContainer = new FrameLayout(context);
        this.closeImg = new ImageView(context);
        this.adListener = new a();
    }

    public /* synthetic */ BiddingFloatingIrregularAnimationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        q qVar = q.a;
        qVar.a(this.mediaContainer);
        addView(this.mediaContainer);
        this.closeImg.setImageResource(R.mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.gravity = 8388661;
        this.closeImg.setVisibility(8);
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.view.native_ad.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingFloatingIrregularAnimationView.m(BiddingFloatingIrregularAnimationView.this, view);
            }
        });
        qVar.a(this.closeImg);
        addView(this.closeImg, layoutParams);
        setOnClickListener(new g(0L, new Function1() { // from class: com.transsion.ad.view.native_ad.c
            public final Object invoke(Object obj) {
                Unit n;
                n = BiddingFloatingIrregularAnimationView.n(BiddingFloatingIrregularAnimationView.this, (View) obj);
                return n;
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, View view) {
        biddingFloatingIrregularAnimationView.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, View view) {
        Intrinsics.h(view, "it");
        if (!biddingFloatingIrregularAnimationView.isCollapsed) {
            biddingFloatingIrregularAnimationView.onAdClick();
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        float width = getWidth() + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r0.getMarginEnd() : 0);
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, width, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new b(width));
        startAnimation(translateAnimation);
        destroy();
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        this.adManager = null;
        this.mediaContainer.removeAllViews();
        this.mMaxEcpmObject = null;
        this.isCollapsed = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        float width = (getWidth() * 4) / 5.0f;
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, width, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new c(width));
        startAnimation(translateAnimation);
        this.isCollapsed = true;
        setAlpha(0.4f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.currentTranslationX, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new d());
        startAnimation(translateAnimation);
        this.isCollapsed = false;
        setAlpha(1.0f);
    }

    public final void changeState(boolean isCollapsed) {
        if (this.mMaxEcpmObject == null || isCollapsed == this.isCollapsed) {
            return;
        }
        if (isCollapsed) {
            p();
        } else {
            q();
        }
    }

    public String getLogTag() {
        return "ad_fb";
    }

    public FrameLayout getMediaContainer() {
        return this.mediaContainer;
    }

    public boolean isShowVolumeIcon() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadAd() {
        LifecycleCoroutineScope a2;
        if (this.mMaxEcpmObject != null) {
            return;
        }
        if (this.adManager == null) {
            BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
            this.adManager = biddingNativeManager;
            biddingNativeManager.L0(getSceneId());
            BiddingNativeManager biddingNativeManager2 = this.adManager;
            if (biddingNativeManager2 != null) {
                biddingNativeManager2.K0(this.adListener);
            }
            setListener(this.adManager);
        }
        l();
        q();
        AppCompatActivity context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? context : null;
        if (appCompatActivity == null || (a2 = v.a(appCompatActivity)) == null) {
            return;
        }
        i.d(a2, (CoroutineContext) null, (CoroutineStart) null, new BiddingFloatingIrregularAnimationView$loadAd$1(this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAdViewDestroy() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        removeAllViews();
        destroy();
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new e());
        }
    }
}
