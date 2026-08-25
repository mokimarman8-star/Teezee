package com.transsion.payment.lib.strategy;

import com.android.billingclient.api.Purchase;
import com.transsion.gslb.BuildConfig;
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
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$purchasesUpdatedListener$1$1", f = "GoogleStrategy.kt", l = {260, 263}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$purchasesUpdatedListener$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Purchase> $purchases;
    Object L$0;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$purchasesUpdatedListener$1$1(List<Purchase> list, GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$purchasesUpdatedListener$1$1> continuation) {
        super(2, continuation);
        this.$purchases = list;
        this.this$0 = googleStrategy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$purchasesUpdatedListener$1$1(this.$purchases, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Iterator<Purchase> it;
        Object B;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (u0.a(1000L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.b(obj);
                while (it.hasNext()) {
                    Purchase next = it.next();
                    GoogleStrategy googleStrategy = this.this$0;
                    this.L$0 = it;
                    this.label = 2;
                    B = googleStrategy.B(next, this);
                    if (B == f) {
                        return f;
                    }
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        it = this.$purchases.iterator();
        while (it.hasNext()) {
        }
        return Unit.a;
    }
}
