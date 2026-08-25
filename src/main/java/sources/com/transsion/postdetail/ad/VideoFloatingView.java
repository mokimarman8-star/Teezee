package com.transsion.postdetail.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.blankj.utilcode.util.a0;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TIconView;
import com.hisavana.mediation.ad.TMediaView;
import com.transsion.ad.R;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001=\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ/\u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/transsion/postdetail/ad/VideoFloatingView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "d", "()V", "j", "k", "f", "h", "g", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "Lkotlin/Function0;", "callback", PushConstants.PUSH_SERVICE_TYPE_SHOW, "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroidx/constraintlayout/widget/ConstraintLayout;Lkotlin/jvm/functions/Function0;)V", "hide", BuildConfig.FLAVOR, "a", "Ljava/lang/String;", "sceneId", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "closeImg", "Lkotlin/jvm/functions/Function0;", "showCallback", "e", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/t1;", "Lkotlinx/coroutines/t1;", "delayJob", BuildConfig.FLAVOR, "Lkotlin/Lazy;", "getDisplayDuration", "()J", "displayDuration", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Lcom/transsion/ad/bidding/base/r;", "i", "Lcom/transsion/ad/bidding/base/r;", "nativeViewBinder", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "mMaxEcpmObject", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "adManager", "com/transsion/postdetail/ad/VideoFloatingView$a", "l", "Lcom/transsion/postdetail/ad/VideoFloatingView$a;", "adListener", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoFloatingView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String sceneId;

    /* renamed from: b, reason: from kotlin metadata */
    private WeakReference parentView;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView closeImg;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 showCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private LifecycleCoroutineScope lifecycleScope;

    /* renamed from: f, reason: from kotlin metadata */
    private t1 delayJob;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy displayDuration;

    /* renamed from: h, reason: from kotlin metadata */
    private final NativeWrapperAdView nativeWrapperAdView;

    /* renamed from: i, reason: from kotlin metadata */
    private com.transsion.ad.bidding.base.r nativeViewBinder;

    /* renamed from: j, reason: from kotlin metadata */
    private BiddingIntermediateMaterialBean mMaxEcpmObject;

    /* renamed from: k, reason: from kotlin metadata */
    private BiddingNativeManager adManager;

    /* renamed from: l, reason: from kotlin metadata */
    private final a adListener;

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            VideoFloatingView.this.g();
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            VideoFloatingView.this.mMaxEcpmObject = biddingIntermediateMaterialBean;
            VideoFloatingView.this.k();
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            VideoFloatingView.this.g();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoFloatingView(Context context) {
        this(context, r0, 2, r0);
        Intrinsics.h(context, "context");
        AttributeSet attributeSet = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.sceneId = "VideoFloatingNativeScene";
        this.closeImg = new ImageView(context);
        this.displayDuration = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.w
            public final Object invoke() {
                long i;
                i = VideoFloatingView.i(VideoFloatingView.this);
                return Long.valueOf(i);
            }
        });
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        this.nativeWrapperAdView = nativeWrapperAdView;
        this.adListener = new a();
        addView(nativeWrapperAdView, new FrameLayout.LayoutParams(-1, -1));
        d();
    }

    public /* synthetic */ VideoFloatingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void d() {
        this.closeImg.setImageResource(R.mipmap.ad_irregular_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.gravity = 8388661;
        this.closeImg.setVisibility(8);
        this.closeImg.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatingView.e(VideoFloatingView.this, view);
            }
        });
        ci.q.a.a(this.closeImg);
        addView(this.closeImg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(VideoFloatingView videoFloatingView, View view) {
        videoFloatingView.g();
    }

    private final void f() {
        ConstraintLayout constraintLayout;
        try {
            Result.Companion companion = Result.Companion;
            ci.q.a.a(this);
            int a2 = a0.a(80.0f);
            ConstraintLayout.b bVar = new ConstraintLayout.b(a2, a2);
            bVar.v = 0;
            bVar.l = 0;
            bVar.setMarginEnd(a0.a(20.0f));
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = a2;
            setLayoutParams(bVar);
            WeakReference weakReference = this.parentView;
            if (weakReference != null && (constraintLayout = (ConstraintLayout) weakReference.get()) != null) {
                constraintLayout.addView(this);
            }
            Function0 function0 = this.showCallback;
            if (function0 != null) {
                function0.invoke();
            }
            t1 t1Var = this.delayJob;
            if (t1Var != null) {
                t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
            }
            LifecycleCoroutineScope lifecycleCoroutineScope = this.lifecycleScope;
            this.delayJob = lifecycleCoroutineScope != null ? kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoFloatingView$addToParent$1$1(this, null), 3, (Object) null) : null;
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        t1 t1Var = this.delayJob;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.parentView = null;
        h();
        uf.c.g(this.closeImg);
        uf.c.g(this);
        this.mMaxEcpmObject = null;
        removeAllViews();
        ci.q.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getDisplayDuration() {
        return ((Number) this.displayDuration.getValue()).longValue();
    }

    private final void h() {
        BiddingNativeManager biddingNativeManager = this.adManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        this.adManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(VideoFloatingView videoFloatingView) {
        return RangesKt.e(com.transsion.ad.scene.a.a.j(videoFloatingView.sceneId), 30) * 1000;
    }

    private final void j() {
        h();
        BiddingNativeManager biddingNativeManager = new BiddingNativeManager();
        this.adManager = biddingNativeManager;
        biddingNativeManager.L0(this.sceneId);
        BiddingNativeManager biddingNativeManager2 = this.adManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.K0(this.adListener);
        }
        LifecycleCoroutineScope lifecycleCoroutineScope = this.lifecycleScope;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, y0.b(), (CoroutineStart) null, new VideoFloatingView$loadAd$1(this, null), 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        TAdNativeInfo nativeInfo;
        TAdNativeInfo.Image icon;
        TAdNativeInfo nativeInfo2;
        BiddingNativeManager biddingNativeManager = this.adManager;
        boolean R0 = biddingNativeManager != null ? biddingNativeManager.R0() : false;
        if (R0) {
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = this.mMaxEcpmObject;
            String str = null;
            if (((biddingIntermediateMaterialBean == null || (nativeInfo2 = biddingIntermediateMaterialBean.getNativeInfo()) == null) ? null : nativeInfo2.getIcon()) != null) {
                BiddingIntermediateMaterialBean biddingIntermediateMaterialBean2 = this.mMaxEcpmObject;
                if (biddingIntermediateMaterialBean2 != null && (nativeInfo = biddingIntermediateMaterialBean2.getNativeInfo()) != null && (icon = nativeInfo.getIcon()) != null) {
                    str = icon.getUrl();
                }
            }
            g();
            return;
        }
        if (this.nativeViewBinder == null) {
            ow.b bVar = ow.b.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            this.nativeViewBinder = bVar.a(context, this.sceneId);
        }
        this.nativeWrapperAdView.bindNativeView(this.adManager, this.nativeViewBinder, this.mMaxEcpmObject);
        if (R0) {
            TMediaView findViewById = this.nativeWrapperAdView.findViewById(com.transsion.wrapperad.R.id.ad_media);
            if (findViewById != null) {
                uf.c.g(findViewById);
            }
        } else {
            TIconView findViewById2 = this.nativeWrapperAdView.findViewById(com.transsion.wrapperad.R.id.ad_icon);
            if (findViewById2 != null) {
                uf.c.g(findViewById2);
            }
        }
        this.closeImg.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ad.x
            @Override // java.lang.Runnable
            public final void run() {
                VideoFloatingView.l(VideoFloatingView.this);
            }
        }, com.transsion.ad.scene.a.a.e(this.sceneId) * 1000);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(VideoFloatingView videoFloatingView) {
        videoFloatingView.closeImg.setVisibility(0);
    }

    public final void hide() {
        g();
    }

    public final void show(LifecycleCoroutineScope lifecycleScope, ConstraintLayout parentView, Function0<Unit> callback) {
        Intrinsics.h(parentView, "parentView");
        this.lifecycleScope = lifecycleScope;
        this.parentView = new WeakReference(parentView);
        this.showCallback = callback;
        if (this.mMaxEcpmObject != null) {
            k();
        } else {
            j();
        }
    }
}
