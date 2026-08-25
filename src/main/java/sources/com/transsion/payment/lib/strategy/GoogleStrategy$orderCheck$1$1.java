package com.transsion.payment.lib.strategy;

import com.android.billingclient.api.Purchase;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$orderCheck$1$1", f = "GoogleStrategy.kt", l = {190}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$orderCheck$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Purchase> $purchaseList;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$orderCheck$1$1(List<Purchase> list, GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$orderCheck$1$1> continuation) {
        super(2, continuation);
        this.$purchaseList = list;
        this.this$0 = googleStrategy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$orderCheck$1$1(this.$purchaseList, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        GoogleStrategy googleStrategy;
        Iterator it;
        PaymentService z;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            List<Purchase> list = this.$purchaseList;
            Intrinsics.e(list);
            googleStrategy = this.this$0;
            it = list.iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            googleStrategy = (GoogleStrategy) this.L$0;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.a;
            dVar.a("fetch purchase result: state " + purchase.e() + " " + purchase.g() + " result size: " + purchase.f());
            if (purchase.e() != 1) {
                dVar.c("遇到未发货订单 fetch purchase result: state " + purchase.e() + " " + purchase.g() + " result size: " + purchase.f());
                com.android.billingclient.api.a a = purchase.a();
                String a2 = a != null ? a.a() : null;
                String g = purchase.g();
                Intrinsics.g(g, "getPurchaseToken(...)");
                String b = purchase.b();
                List d = purchase.d();
                String str = d != null ? (String) d.get(0) : null;
                z = googleStrategy.z();
                this.L$0 = googleStrategy;
                this.L$1 = it;
                this.label = 1;
                if (z.g(str, g, a2, b, this) == f) {
                    return f;
                }
            }
        }
        return Unit.a;
    }
}
