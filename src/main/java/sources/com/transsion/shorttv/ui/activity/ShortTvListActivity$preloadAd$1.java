package com.transsion.shorttv.ui.activity;

import com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider;
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
@DebugMetadata(c = "com.transsion.shorttv.ui.activity.ShortTvListActivity$preloadAd$1", f = "ShortTvListActivity.kt", l = {147}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ShortTvListActivity$preloadAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $overlaySceneId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvListActivity$preloadAd$1(String str, Continuation<? super ShortTvListActivity$preloadAd$1> continuation) {
        super(2, continuation);
        this.$overlaySceneId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvListActivity$preloadAd$1(this.$overlaySceneId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvListActivity$preloadAd$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            BiddingHiSavanaNativeProvider b = BiddingHiSavanaNativeProvider.j.b(this.$overlaySceneId);
            if (b != null) {
                String str = this.$overlaySceneId;
                this.label = 1;
                if (BiddingHiSavanaNativeProvider.t(b, str, (Map) null, this, 2, (Object) null) == f) {
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
