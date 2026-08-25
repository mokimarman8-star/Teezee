package com.transsion.ad.test.ad_example;

import com.transsion.ad.test.ad_example.TestAdNativeListActivity;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeListActivity$loadMore$1", f = "TestAdNativeListActivity.kt", l = {71}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdNativeListActivity$loadMore$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdNativeListActivity$loadMore$1(TestAdNativeListActivity testAdNativeListActivity, Continuation<? super TestAdNativeListActivity$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeListActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeListActivity$loadMore$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        TestAdNativeListActivity.a aVar;
        TestAdNativeListActivity.a aVar2;
        t6.f h0;
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
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add(new TestAdNativeListActivity.b(BuildConfig.FLAVOR, null));
        }
        aVar = this.this$0.mTestAdapter;
        if (aVar != null) {
            aVar.q(arrayList);
        }
        aVar2 = this.this$0.mTestAdapter;
        if (aVar2 != null && (h0 = aVar2.h0()) != null) {
            h0.s();
        }
        return Unit.a;
    }
}
