package com.transsion.shorttv.order;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.order.PayLoadingVM$checkPayOrderId$1", f = "PayLoadingVM.kt", l = {71}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PayLoadingVM$checkPayOrderId$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isDebug;
    final /* synthetic */ String $projectName;
    final /* synthetic */ String $tradingOrderId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ PayLoadingVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayLoadingVM$checkPayOrderId$1(String str, String str2, boolean z, PayLoadingVM payLoadingVM, Continuation<? super PayLoadingVM$checkPayOrderId$1> continuation) {
        super(2, continuation);
        this.$tradingOrderId = str;
        this.$projectName = str2;
        this.$isDebug = z;
        this.this$0 = payLoadingVM;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayLoadingVM$checkPayOrderId$1 payLoadingVM$checkPayOrderId$1 = new PayLoadingVM$checkPayOrderId$1(this.$tradingOrderId, this.$projectName, this.$isDebug, this.this$0, continuation);
        payLoadingVM$checkPayOrderId$1.L$0 = obj;
        return payLoadingVM$checkPayOrderId$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
    
        if (r0.intValue() != 5) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
    
        r0 = r4.f;
        r1 = (com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity) r11.getData();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        r1 = r1.getOrderStatus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
    
        if (r1 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ca, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cd, code lost:
    
        r11 = (com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity) r11.getData();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
    
        if (r11 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        r11 = r11.getDescription();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
    
        if (r11 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00dc, code lost:
    
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00df, code lost:
    
        r0.n(new com.transsion.shorttv.order.bean.HttpErrorBodyBean(r5, r6, null, 4, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
    
        r5 = com.transsion.gslb.BuildConfig.FLAVOR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cc, code lost:
    
        r6 = com.transsion.gslb.BuildConfig.FLAVOR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        if (r0.intValue() != 3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x007d, code lost:
    
        if (r0.intValue() != 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0074, code lost:
    
        if (r0.intValue() != 0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        HttpException httpException;
        HttpErrorBodyBean httpErrorBodyBean;
        b0 b0Var;
        PayLoadingVM payLoadingVM;
        boolean z;
        String str;
        String str2;
        PayLoadingVM payLoadingVM2;
        BaseDto baseDto;
        Integer v;
        String str3;
        GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity;
        String str4;
        String description;
        String orderStatus;
        b0 b0Var2;
        String orderStatus2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                String str5 = this.$tradingOrderId;
                String str6 = this.$projectName;
                boolean z2 = this.$isDebug;
                payLoadingVM = this.this$0;
                Result.Companion companion = Result.Companion;
                g gVar = g.a;
                this.L$0 = str5;
                this.L$1 = str6;
                this.L$2 = payLoadingVM;
                this.Z$0 = z2;
                this.label = 1;
                Object c = gVar.c(str5, str6, z2, this);
                if (c == f) {
                    return f;
                }
                z = z2;
                str = str6;
                str2 = str5;
                obj = c;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = this.Z$0;
                payLoadingVM = (PayLoadingVM) this.L$2;
                String str7 = (String) this.L$1;
                String str8 = (String) this.L$0;
                ResultKt.b(obj);
                z = z3;
                str = str7;
                str2 = str8;
            }
            payLoadingVM2 = payLoadingVM;
            baseDto = (BaseDto) obj;
            GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity2 = (GetPaynicornOrderStatusRespEntity) baseDto.getData();
            v = (getPaynicornOrderStatusRespEntity2 == null || (orderStatus2 = getPaynicornOrderStatusRespEntity2.getOrderStatus()) == null) ? null : StringsKt.v(orderStatus2);
            if (v != null) {
            }
            if (v != null) {
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (v != null && v.intValue() == 4) {
            GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity3 = (GetPaynicornOrderStatusRespEntity) baseDto.getData();
            if (getPaynicornOrderStatusRespEntity3 != null && (orderStatus = getPaynicornOrderStatusRespEntity3.getOrderStatus()) != null) {
                str3 = orderStatus;
                getPaynicornOrderStatusRespEntity = (GetPaynicornOrderStatusRespEntity) baseDto.getData();
                if (getPaynicornOrderStatusRespEntity != null && (description = getPaynicornOrderStatusRespEntity.getDescription()) != null) {
                    str4 = description;
                    payLoadingVM2.o(str3, str4, str2, str, z);
                    obj2 = Result.constructor-impl(Unit.a);
                    PayLoadingVM payLoadingVM3 = this.this$0;
                    httpException = Result.exceptionOrNull-impl(obj2);
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
                str4 = BuildConfig.FLAVOR;
                payLoadingVM2.o(str3, str4, str2, str, z);
                obj2 = Result.constructor-impl(Unit.a);
                PayLoadingVM payLoadingVM32 = this.this$0;
                httpException = Result.exceptionOrNull-impl(obj2);
                if (httpException != null) {
                }
                return Unit.a;
            }
            str3 = BuildConfig.FLAVOR;
            getPaynicornOrderStatusRespEntity = (GetPaynicornOrderStatusRespEntity) baseDto.getData();
            if (getPaynicornOrderStatusRespEntity != null) {
                str4 = description;
                payLoadingVM2.o(str3, str4, str2, str, z);
                obj2 = Result.constructor-impl(Unit.a);
                PayLoadingVM payLoadingVM322 = this.this$0;
                httpException = Result.exceptionOrNull-impl(obj2);
                if (httpException != null) {
                }
                return Unit.a;
            }
            str4 = BuildConfig.FLAVOR;
            payLoadingVM2.o(str3, str4, str2, str, z);
            obj2 = Result.constructor-impl(Unit.a);
            PayLoadingVM payLoadingVM3222 = this.this$0;
            httpException = Result.exceptionOrNull-impl(obj2);
            if (httpException != null) {
            }
            return Unit.a;
        }
        if (v.intValue() == 2) {
            b0Var2 = payLoadingVM2.e;
            b0Var2.n(baseDto.getData());
            obj2 = Result.constructor-impl(Unit.a);
            PayLoadingVM payLoadingVM32222 = this.this$0;
            httpException = Result.exceptionOrNull-impl(obj2);
            if (httpException != null) {
            }
            return Unit.a;
        }
        if (v != null) {
        }
        if (v != null) {
        }
        obj2 = Result.constructor-impl(Unit.a);
        PayLoadingVM payLoadingVM322222 = this.this$0;
        httpException = Result.exceptionOrNull-impl(obj2);
        if (httpException != null) {
        }
        return Unit.a;
    }
}
