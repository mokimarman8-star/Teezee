package com.transsion.ad.ps.attribution;

import com.transsion.ad.db.pslink.AttributionPoint;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Z"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.attribution.BaseAttributionProvider$isAttributionPointExists$2", f = "BaseAttributionProvider.kt", l = {39}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseAttributionProvider$isAttributionPointExists$2 extends SuspendLambda implements Function2<n0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $psId;
    final /* synthetic */ String $reportUrl;
    final /* synthetic */ AttributionPoint.AttributionType $type;
    int label;
    final /* synthetic */ BaseAttributionProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseAttributionProvider$isAttributionPointExists$2(BaseAttributionProvider baseAttributionProvider, String str, AttributionPoint.AttributionType attributionType, String str2, Continuation<? super BaseAttributionProvider$isAttributionPointExists$2> continuation) {
        super(2, continuation);
        this.this$0 = baseAttributionProvider;
        this.$psId = str;
        this.$type = attributionType;
        this.$reportUrl = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseAttributionProvider$isAttributionPointExists$2(this.this$0, this.$psId, this.$type, this.$reportUrl, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Boolean> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        com.transsion.ad.db.pslink.a f;
        Object f2 = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            f = this.this$0.f();
            String str = this.$psId;
            AttributionPoint.AttributionType attributionType = this.$type;
            String str2 = this.$reportUrl;
            this.label = 1;
            obj = f.c(str, attributionType, str2, this);
            if (obj == f2) {
                return f2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
