package androidx.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
/* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<n0, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(Function2<? super n0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 c0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new C0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, continuation);
        c0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return c0192RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            Function2<n0, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (function2.invoke(n0Var, this) == f5) {
                return f5;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
