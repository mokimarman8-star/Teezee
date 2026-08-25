package com.transsion.home.fragment.tab;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.viewmodel.TrendingViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2", f = "TrendingFragment.kt", l = {449}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TrendingFragment$initViewModel$2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrendingFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2$1", f = "TrendingFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ TrendingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TrendingFragment trendingFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = trendingFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            androidx.lifecycle.b0 V;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            boolean z = this.Z$0;
            TrendingViewModel X0 = TrendingFragment.X0(this.this$0);
            if (X0 != null && (V = X0.V()) != null) {
                V.n(Boxing.a(z));
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrendingFragment$initViewModel$2(TrendingFragment trendingFragment, Continuation<? super TrendingFragment$initViewModel$2> continuation) {
        super(2, continuation);
        this.this$0 = trendingFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendingFragment$initViewModel$2(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.flow.h1 a;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null && (a = bVar.a()) != null) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(a, anonymousClass1, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
