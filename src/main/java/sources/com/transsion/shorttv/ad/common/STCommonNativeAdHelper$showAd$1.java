package com.transsion.shorttv.ad.common;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonNativeAdHelper$showAd$1", f = "STCommonNativeAdHelper.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class STCommonNativeAdHelper$showAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ r $layoutProvider;
    final /* synthetic */ NativeWrapperAdView $nativeAdView;
    final /* synthetic */ Function1<Boolean, Unit> $showCallback;
    int label;
    final /* synthetic */ STCommonNativeAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    STCommonNativeAdHelper$showAd$1(STCommonNativeAdHelper sTCommonNativeAdHelper, Function1<? super Boolean, Unit> function1, NativeWrapperAdView nativeWrapperAdView, r rVar, Continuation<? super STCommonNativeAdHelper$showAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonNativeAdHelper;
        this.$showCallback = function1;
        this.$nativeAdView = nativeWrapperAdView;
        this.$layoutProvider = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(NativeWrapperAdView nativeWrapperAdView) {
        Object obj;
        View view;
        Sequence children;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            ImageView imageView = (ImageView) nativeWrapperAdView.findViewById(R.id.ad_blur_view);
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor("#E6000000"));
            }
            Iterator it = ViewGroupKt.getChildren(nativeWrapperAdView).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((View) obj) instanceof TAdNativeView) {
                        break;
                    }
                }
            }
            RelativeLayout relativeLayout = obj instanceof RelativeLayout ? (RelativeLayout) obj : null;
            if (relativeLayout == null || (children = ViewGroupKt.getChildren(relativeLayout)) == null) {
                view = null;
            } else {
                Iterator it2 = children.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it2.next();
                        if (((View) obj2) instanceof TNativeView) {
                            break;
                        }
                    }
                }
                view = (View) obj2;
            }
            FrameLayout frameLayout = view instanceof FrameLayout ? (FrameLayout) view : null;
            if (relativeLayout != null && frameLayout != null) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                frameLayout.setLayoutParams(layoutParams2);
                frameLayout.requestLayout();
                Result.constructor-impl(Unit.a);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonNativeAdHelper$showAd$1(this.this$0, this.$showCallback, this.$nativeAdView, this.$layoutProvider, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        STCommonNativeAdHelper sTCommonNativeAdHelper = this.this$0;
        Function1<Boolean, Unit> function1 = this.$showCallback;
        final NativeWrapperAdView nativeWrapperAdView = this.$nativeAdView;
        r rVar = this.$layoutProvider;
        try {
            Result.Companion companion = Result.Companion;
            yq.a aVar = yq.a.a;
            String o = sTCommonNativeAdHelper.o();
            biddingNativeManager = sTCommonNativeAdHelper.c;
            aVar.b(o, "trigger show ad", biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
            sTCommonNativeAdHelper.f = function1;
            sTCommonNativeAdHelper.g = new WeakReference(nativeWrapperAdView);
            biddingNativeManager2 = sTCommonNativeAdHelper.c;
            biddingIntermediateMaterialBean = sTCommonNativeAdHelper.d;
            nativeWrapperAdView.bindNativeView(biddingNativeManager2, rVar, biddingIntermediateMaterialBean);
            obj2 = Result.constructor-impl(Boxing.a(nativeWrapperAdView.post(new Runnable() { // from class: com.transsion.shorttv.ad.common.a
                @Override // java.lang.Runnable
                public final void run() {
                    STCommonNativeAdHelper$showAd$1.d(NativeWrapperAdView.this);
                }
            })));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        Function1<Boolean, Unit> function12 = this.$showCallback;
        if (Result.exceptionOrNull-impl(obj2) != null && function12 != null) {
            function12.invoke(Boxing.a(false));
        }
        return Unit.a;
    }
}
