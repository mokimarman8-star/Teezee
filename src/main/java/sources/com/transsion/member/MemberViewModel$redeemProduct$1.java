package com.transsion.member;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.bean.RedeemResult;
import com.transsion.memberapi.SkuItem;
import java.util.Map;
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
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.MemberViewModel$redeemProduct$1", f = "MemberViewModel.kt", l = {298}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberViewModel$redeemProduct$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SkuItem $skuItem;
    int label;
    final /* synthetic */ MemberViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberViewModel$redeemProduct$1(MemberViewModel memberViewModel, SkuItem skuItem, Continuation<? super MemberViewModel$redeemProduct$1> continuation) {
        super(2, continuation);
        this.this$0 = memberViewModel;
        this.$skuItem = skuItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberViewModel$redeemProduct$1(this.this$0, this.$skuItem, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        androidx.lifecycle.b0 b0Var;
        Map map;
        Map map2;
        androidx.lifecycle.b0 b0Var2;
        Map map3;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            MemberViewModel memberViewModel = this.this$0;
            SkuItem skuItem = this.$skuItem;
            this.label = 1;
            obj = memberViewModel.I(skuItem, this);
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
        if (!Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0") || baseDto.getData() == null) {
            a.a aVar = wf.a.a;
            a.a.l(aVar, "MemberViewModel", "RedeemProduct fail: " + (baseDto != null ? baseDto.getReason() : null) + " " + (baseDto != null ? baseDto.getCode() : null) + " " + (baseDto != null ? baseDto.getMsg() : null), false, 4, (Object) null);
            if (Intrinsics.c(baseDto != null ? baseDto.getReason() : null, "EXCHANGE_FAIL")) {
                map = this.this$0.l;
                map.remove(this.$skuItem.getSkuId());
                a.a.f(aVar, "MemberViewModel", "Should remove the orderId for " + this.$skuItem.getSkuId(), false, 4, (Object) null);
            }
            b0Var = this.this$0.f;
            b0Var.q((Object) null);
        } else {
            Object data = baseDto.getData();
            Intrinsics.e(data);
            RedeemResult redeemResult = (RedeemResult) data;
            String orderId = redeemResult.getOrderId();
            map2 = this.this$0.l;
            if (Intrinsics.c(orderId, map2.get(this.$skuItem.getSkuId()))) {
                a.a.f(wf.a.a, "MemberViewModel", "RedeemProductSucceed: " + redeemResult.getOrderId() + "}", false, 4, (Object) null);
                map3 = this.this$0.l;
                map3.remove(this.$skuItem.getSkuId());
            } else {
                a.a.f(wf.a.a, "MemberViewModel", "RedeemProductSucceed but orderId not match: " + redeemResult.getOrderId() + "}", false, 4, (Object) null);
            }
            b0Var2 = this.this$0.f;
            b0Var2.q(redeemResult);
        }
        return Unit.a;
    }
}
