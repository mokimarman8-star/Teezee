package com.transsion.postdetail.util;

import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.ShortTVFloatManager$saveHistoryInner$1", f = "ShortTVFloatManager.kt", l = {62, 63}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ dw.a $floatBean;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTVFloatManager$saveHistoryInner$1(dw.a aVar, Function0<Unit> function0, Continuation<? super ShortTVFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function0<Unit> function0;
        ShortTVPlayDao l;
        a2 c;
        ShortTVFloatManager$saveHistoryInner$1$1$1 shortTVFloatManager$saveHistoryInner$1$1$1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            dw.a aVar = this.$floatBean;
            if (aVar != null) {
                function0 = this.$callback;
                a.a.f(wf.a.a, "VideoFloat", "shorttv-----saveHistory, ep:" + aVar.c() + ", progress:" + aVar.n(), false, 4, (Object) null);
                l = ShortTVFloatManager.b.l();
                String r = aVar.r();
                int c2 = aVar.c();
                long n = aVar.n();
                this.L$0 = function0;
                this.label = 1;
                if (l.h(r, c2, n, this) == f) {
                    return f;
                }
                c = y0.c();
                shortTVFloatManager$saveHistoryInner$1$1$1 = new ShortTVFloatManager$saveHistoryInner$1$1$1(function0, null);
                this.L$0 = null;
                this.label = 2;
                if (kotlinx.coroutines.i.g(c, shortTVFloatManager$saveHistoryInner$1$1$1, this) == f) {
                }
            }
        } else if (i == 1) {
            function0 = (Function0) this.L$0;
            ResultKt.b(obj);
            c = y0.c();
            shortTVFloatManager$saveHistoryInner$1$1$1 = new ShortTVFloatManager$saveHistoryInner$1$1$1(function0, null);
            this.L$0 = null;
            this.label = 2;
            if (kotlinx.coroutines.i.g(c, shortTVFloatManager$saveHistoryInner$1$1$1, this) == f) {
                return f;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
