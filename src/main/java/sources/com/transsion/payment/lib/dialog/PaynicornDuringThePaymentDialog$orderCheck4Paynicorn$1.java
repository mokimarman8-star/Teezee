package com.transsion.payment.lib.dialog;

import android.text.TextUtils;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderRes;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1", f = "PaynicornDuringThePaymentDialog.kt", l = {179}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PaynicornDuringThePaymentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, Continuation<? super PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1> continuation) {
        super(2, continuation);
        this.this$0 = paynicornDuringThePaymentDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        PaymentService E0;
        CreateOrderRes createOrderRes;
        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog;
        BaseDto baseDto;
        String code;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog2 = this.this$0;
                Result.Companion companion = Result.Companion;
                E0 = paynicornDuringThePaymentDialog2.E0();
                createOrderRes = paynicornDuringThePaymentDialog2.mCreateOrderRes;
                String tradingOrderId = createOrderRes != null ? createOrderRes.getTradingOrderId() : null;
                this.L$0 = paynicornDuringThePaymentDialog2;
                this.label = 1;
                Object e = E0.e(tradingOrderId, this);
                if (e == f) {
                    return f;
                }
                paynicornDuringThePaymentDialog = paynicornDuringThePaymentDialog2;
                obj = e;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                paynicornDuringThePaymentDialog = (PaynicornDuringThePaymentDialog) this.L$0;
                ResultKt.b(obj);
            }
            baseDto = (BaseDto) obj;
            code = baseDto != null ? baseDto.getCode() : null;
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (code != null) {
            int hashCode = code.hashCode();
            if (hashCode != 48) {
                if (hashCode != 51508) {
                    if (hashCode == 52469 && code.equals("500")) {
                        paynicornDuringThePaymentDialog.I0(1005, "orderCheck4Paynicorn() --> 500 --> 服务器内部错误");
                        obj2 = Result.constructor-impl(Unit.a);
                        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog3 = this.this$0;
                        th2 = Result.exceptionOrNull-impl(obj2);
                        if (th2 != null) {
                            PaynicornDuringThePaymentDialog.Q0(paynicornDuringThePaymentDialog3, "orderCheck4Paynicorn() --> getOrElse() --> it = " + th2, 0, 2, null);
                        }
                        return Unit.a;
                    }
                } else if (code.equals("400")) {
                    if (TextUtils.equals(baseDto.getReason(), "PAY_PROCESSING")) {
                        paynicornDuringThePaymentDialog.P0("orderCheck4Paynicorn() --> code = 400 -- 支付未完成", 1003);
                    } else if (TextUtils.equals(baseDto.getReason(), "PAY_FAILED")) {
                        paynicornDuringThePaymentDialog.I0(1004, "orderCheck4Paynicorn() --> 400 --> 支付失败: 就是付钱了，但是第三方渠道没有成功");
                    } else {
                        PaynicornDuringThePaymentDialog.Q0(paynicornDuringThePaymentDialog, "orderCheck4Paynicorn() --> code = 400 -- reason = " + baseDto.getReason(), 0, 2, null);
                    }
                    obj2 = Result.constructor-impl(Unit.a);
                    PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog32 = this.this$0;
                    th2 = Result.exceptionOrNull-impl(obj2);
                    if (th2 != null) {
                    }
                    return Unit.a;
                }
            } else if (code.equals("0")) {
                paynicornDuringThePaymentDialog.J0(baseDto);
                obj2 = Result.constructor-impl(Unit.a);
                PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog322 = this.this$0;
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                }
                return Unit.a;
            }
        }
        PaynicornDuringThePaymentDialog.Q0(paynicornDuringThePaymentDialog, "orderCheck4Paynicorn() --> code = " + (baseDto != null ? baseDto.getCode() : null) + " -- msg = " + (baseDto != null ? baseDto.getMsg() : null) + " -- reason = " + (baseDto != null ? baseDto.getReason() : null), 0, 2, null);
        obj2 = Result.constructor-impl(Unit.a);
        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog3222 = this.this$0;
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
