package com.transsion.ad;

import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.MBAd;
import com.transsion.ad.hi.HiSavanaAdManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", TtmlNode.ANONYMOUS_REGION_ID, "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.MBAd$initAd$2$1$sdkHi$1", f = "MBAd.kt", l = {LogSeverity.INFO_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class MBAd$initAd$2$1$sdkHi$1 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    final /* synthetic */ MBAd.a $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MBAd$initAd$2$1$sdkHi$1(MBAd.a aVar, Continuation<? super MBAd$initAd$2$1$sdkHi$1> continuation) {
        super(2, continuation);
        this.$params = aVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MBAd$initAd$2$1$sdkHi$1(this.$params, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return "HiSavana 广告SDK初始化完成";
        }
        ResultKt.b(obj);
        HiSavanaAdManager hiSavanaAdManager = HiSavanaAdManager.a;
        String e = this.$params.e();
        boolean b = this.$params.b();
        boolean k = this.$params.k();
        this.label = 1;
        return hiSavanaAdManager.d(e, b, k, this) == f ? f : "HiSavana 广告SDK初始化完成";
    }
}
