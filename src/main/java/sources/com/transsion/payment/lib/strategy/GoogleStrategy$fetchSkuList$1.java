package com.transsion.payment.lib.strategy;

import androidx.lifecycle.b0;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.SkuBean;
import com.transsion.payment.lib.bean.SkuData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$fetchSkuList$1", f = "GoogleStrategy.kt", l = {59}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$fetchSkuList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$fetchSkuList$1(GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$fetchSkuList$1> continuation) {
        super(2, continuation);
        this.this$0 = googleStrategy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$fetchSkuList$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentService z;
        b0 b0Var;
        b0 b0Var2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            z = this.this$0.z();
            this.label = 1;
            obj = z.d(this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BaseDto baseDto = (BaseDto) obj;
        if (baseDto == null || !Intrinsics.c(baseDto.getCode(), "0")) {
            ArrayList arrayList = (ArrayList) o.e(com.transsion.baselib.report.launch.b.a.b().getString(com.transsion.payment.lib.c.a.a(), "[\n{\n\"coin\": \"10\",\n\"formatPrice\": \"US$0.49\",\n\"priceCurrencyCode\": \"USD\",\n\"skuId\": \"reelshort_coin_20240313\"\n},\n{\n\"coin\": \"30\",\n\"formatPrice\": \"US$0.99\",\n\"priceCurrencyCode\": \"USD\",\n\"skuId\": \"reelshort_coin_20240222\"\n},\n{\n\"coin\": \"54\",\n\"formatPrice\": \"US$1.49\",\n\"priceCurrencyCode\": \"USD\",\n\"skuId\": \"reelshort_coin_54_20240303\"\n},\n{\n\"coin\": \"118\",\n\"formatPrice\": \"US$4.99\",\n\"priceCurrencyCode\": \"USD\",\n\"skuId\": \"reelshort_coin_118_20240303\"\n}\n]"), new TypeToken<ArrayList<SkuBean>>() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$fetchSkuList$1$type$1
            }.getType());
            b0Var = this.this$0.a;
            b0Var.n(arrayList);
        } else {
            b0Var2 = this.this$0.a;
            SkuData skuData = (SkuData) baseDto.getData();
            b0Var2.n(skuData != null ? skuData.getSkuList() : null);
        }
        return Unit.a;
    }
}
