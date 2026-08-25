package com.transsion.commercialization.task;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.AdInterceptDialog$loadNativeAd$1", f = "AdInterceptDialog.kt", l = {269}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdInterceptDialog$loadNativeAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdInterceptDialog this$0;

    public static final class a extends oh.a {
        final /* synthetic */ AdInterceptDialog d;

        a(AdInterceptDialog adInterceptDialog) {
            this.d = adInterceptDialog;
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            this.d.R0();
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            this.d.adObject = biddingIntermediateMaterialBean;
            this.d.R0();
            this.d.y0();
        }

        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            this.d.E0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdInterceptDialog$loadNativeAd$1(AdInterceptDialog adInterceptDialog, Continuation<? super AdInterceptDialog$loadNativeAd$1> continuation) {
        super(2, continuation);
        this.this$0 = adInterceptDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdInterceptDialog$loadNativeAd$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.this$0.nativeManager = new BiddingNativeManager();
            biddingNativeManager = this.this$0.nativeManager;
            if (biddingNativeManager != null) {
                biddingNativeManager.L0("DownloadInterceptDialogNativeScene");
            }
            biddingNativeManager2 = this.this$0.nativeManager;
            if (biddingNativeManager2 != null) {
                com.transsion.ad.strategy.c cVar = com.transsion.ad.strategy.c.a;
                str = this.this$0.mGenre;
                biddingNativeManager2.J0(cVar.a(str));
            }
            biddingNativeManager3 = this.this$0.nativeManager;
            if (biddingNativeManager3 != null) {
                biddingNativeManager3.K0(new a(this.this$0));
            }
            biddingNativeManager4 = this.this$0.nativeManager;
            if (biddingNativeManager4 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingNativeManager4, 0, false, this, 3, (Object) null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
