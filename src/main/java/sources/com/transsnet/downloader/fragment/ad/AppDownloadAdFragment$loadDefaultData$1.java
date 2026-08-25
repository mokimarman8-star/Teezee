package com.transsnet.downloader.fragment.ad;

import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.ad.AppDownloadAdFragment$loadDefaultData$1", f = "AppDownloadAdFragment.kt", l = {Sdk$SDKError.Reason.INVALID_ASSET_URL_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class AppDownloadAdFragment$loadDefaultData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppDownloadAdFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppDownloadAdFragment$loadDefaultData$1(AppDownloadAdFragment appDownloadAdFragment, Continuation<? super AppDownloadAdFragment$loadDefaultData$1> continuation) {
        super(2, continuation);
        this.this$0 = appDownloadAdFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppDownloadAdFragment$loadDefaultData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AppDownloadAdFragment$loadDefaultData$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        BiddingIconAdManager biddingIconAdManager;
        oh.a aVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            biddingIconAdManager = this.this$0.adManager;
            int q = com.transsion.ad.scene.a.q(com.transsion.ad.scene.a.a, "DownloadCenterAppDistributionScene", 0, 2, (Object) null);
            aVar = this.this$0.listener;
            this.label = 1;
            if (BiddingIconAdManager.S(biddingIconAdManager, "DownloadCenterAppDistributionScene", true, q, aVar, (Map) null, this, 16, (Object) null) == f) {
                return f;
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
