package com.transsion.ad.ps.attribution;

import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.attribution.AttributionProduceManager$reportUrl$1", f = "AttributionProduceManager.kt", l = {90, 99}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AttributionProduceManager$reportUrl$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendInfo $recommendInfo;
    final /* synthetic */ String $reportUrl;
    final /* synthetic */ AttributionPoint.AttributionType $type;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AttributionProduceManager$reportUrl$1(String str, RecommendInfo recommendInfo, AttributionPoint.AttributionType attributionType, Continuation<? super AttributionProduceManager$reportUrl$1> continuation) {
        super(2, continuation);
        this.$reportUrl = str;
        this.$recommendInfo = recommendInfo;
        this.$type = attributionType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AttributionProduceManager$reportUrl$1(this.$reportUrl, this.$recommendInfo, this.$type, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            AttributionConsumeManager.c.n();
            if (!StringsKt.W(this.$reportUrl, "http", false, 2, (Object) null)) {
                return Unit.a;
            }
            AttributionProduceManager attributionProduceManager = AttributionProduceManager.c;
            RecommendInfo recommendInfo = this.$recommendInfo;
            String valueOf = String.valueOf(recommendInfo != null ? Boxing.e(recommendInfo.getId()) : null);
            AttributionPoint.AttributionType attributionType = this.$type;
            String str = this.$reportUrl;
            this.label = 1;
            obj = attributionProduceManager.h(valueOf, attributionType, str, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                AttributionConsumeManager.c.n();
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return Unit.a;
        }
        AttributionProduceManager attributionProduceManager2 = AttributionProduceManager.c;
        String str2 = this.$reportUrl;
        AttributionPoint.AttributionType attributionType2 = this.$type;
        RecommendInfo recommendInfo2 = this.$recommendInfo;
        String valueOf2 = String.valueOf(recommendInfo2 != null ? Boxing.e(recommendInfo2.getId()) : null);
        this.label = 2;
        if (attributionProduceManager2.g(str2, attributionType2, valueOf2, this) == f) {
            return f;
        }
        AttributionConsumeManager.c.n();
        return Unit.a;
    }
}
