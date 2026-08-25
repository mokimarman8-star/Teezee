package com.transsion.shorttv.base.fragment;

import com.transsion.gslb.BuildConfig;
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
@DebugMetadata(c = "com.transsion.shorttv.base.fragment.PageStatusFragment$onConnected$1", f = "PageStatusFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PageStatusFragment$onConnected$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PageStatusFragment<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageStatusFragment$onConnected$1(PageStatusFragment<T> pageStatusFragment, Continuation<? super PageStatusFragment$onConnected$1> continuation) {
        super(2, continuation);
        this.this$0 = pageStatusFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageStatusFragment$onConnected$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.showContentView();
        PageStatusFragment<T> pageStatusFragment = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            pageStatusFragment.retryLoadData();
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }
}
