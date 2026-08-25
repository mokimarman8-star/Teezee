package com.transsion.shorttv.order;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.HttpErrorBodyBean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.order.PayLoadingVM$createPayOrderId$1", f = "PayLoadingVM.kt", l = {51}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PayLoadingVM$createPayOrderId$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreatePaynicornOrderReqBean $orderReq;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PayLoadingVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayLoadingVM$createPayOrderId$1(CreatePaynicornOrderReqBean createPaynicornOrderReqBean, PayLoadingVM payLoadingVM, Continuation<? super PayLoadingVM$createPayOrderId$1> continuation) {
        super(2, continuation);
        this.$orderReq = createPaynicornOrderReqBean;
        this.this$0 = payLoadingVM;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayLoadingVM$createPayOrderId$1 payLoadingVM$createPayOrderId$1 = new PayLoadingVM$createPayOrderId$1(this.$orderReq, this.this$0, continuation);
        payLoadingVM$createPayOrderId$1.L$0 = obj;
        return payLoadingVM$createPayOrderId$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        HttpErrorBodyBean httpErrorBodyBean;
        b0 b0Var;
        PayLoadingVM payLoadingVM;
        b0 b0Var2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                CreatePaynicornOrderReqBean createPaynicornOrderReqBean = this.$orderReq;
                PayLoadingVM payLoadingVM2 = this.this$0;
                Result.Companion companion = Result.Companion;
                g gVar = g.a;
                this.L$0 = payLoadingVM2;
                this.label = 1;
                obj = gVar.b(createPaynicornOrderReqBean, this);
                if (obj == f) {
                    return f;
                }
                payLoadingVM = payLoadingVM2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                payLoadingVM = (PayLoadingVM) this.L$0;
                ResultKt.b(obj);
            }
            b0Var2 = payLoadingVM.d;
            b0Var2.n(((BaseDto) obj).getData());
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        PayLoadingVM payLoadingVM3 = this.this$0;
        HttpException httpException = Result.exceptionOrNull-impl(obj2);
        if (httpException != null) {
            if (httpException instanceof HttpException) {
                httpErrorBodyBean = HttpErrorBodyBean.INSTANCE.a(httpException);
            } else {
                String message = httpException.getMessage();
                if (message == null) {
                    message = BuildConfig.FLAVOR;
                }
                httpErrorBodyBean = new HttpErrorBodyBean(message, "-1", BuildConfig.FLAVOR);
            }
            b0Var = payLoadingVM3.f;
            b0Var.n(httpErrorBodyBean);
        }
        return Unit.a;
    }
}
