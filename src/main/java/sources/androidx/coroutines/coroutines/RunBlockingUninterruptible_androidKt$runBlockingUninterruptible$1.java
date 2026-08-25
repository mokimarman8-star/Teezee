package androidx.coroutines.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 extends SuspendLambda implements Function2<n0, Continuation<Object>, Object> {
    final /* synthetic */ Function2<n0, Continuation<Object>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {52}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<n0, Continuation<Object>, Object> $block;
        final /* synthetic */ w $deferred;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(w wVar, Function2<? super n0, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$deferred = wVar;
            this.$block = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$deferred, this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            w wVar;
            Object obj2;
            Object f5 = IntrinsicsKt.f();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.b(obj);
                n0 n0Var = (n0) this.L$0;
                w wVar2 = this.$deferred;
                Function2<n0, Continuation<Object>, Object> function2 = this.$block;
                try {
                    Result.Companion companion = Result.Companion;
                    this.L$0 = wVar2;
                    this.label = 1;
                    obj = function2.invoke(n0Var, this);
                    if (obj == f5) {
                        return f5;
                    }
                    wVar = wVar2;
                } catch (Throwable th) {
                    th = th;
                    wVar = wVar2;
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.a(th));
                    y.c(wVar, obj2);
                    return Unit.a;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wVar = (w) this.L$0;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.a(th));
                    y.c(wVar, obj2);
                    return Unit.a;
                }
            }
            obj2 = Result.constructor-impl(obj);
            y.c(wVar, obj2);
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<Object>, Object> {
        final /* synthetic */ w $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(w wVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$deferred = wVar;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$deferred, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = IntrinsicsKt.f();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.b(obj);
                w wVar = this.$deferred;
                this.label = 1;
                obj = wVar.f(this);
                if (obj == f5) {
                    return f5;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(Function2<? super n0, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 = new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(this.$block, continuation);
        runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1.L$0 = obj;
        return runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1;
    }

    public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineContext coroutineContext = ((n0) this.L$0).getCoroutineContext().get(ContinuationInterceptor.k1);
        Intrinsics.e(coroutineContext);
        CoroutineContext coroutineContext2 = (ContinuationInterceptor) coroutineContext;
        w b5 = y.b((t1) null, 1, (Object) null);
        i.c(n1.a, coroutineContext2, CoroutineStart.UNDISPATCHED, new AnonymousClass1(b5, this.$block, null));
        while (!b5.isCompleted()) {
            try {
                return i.e(coroutineContext2, new AnonymousClass2(b5, null));
            } catch (InterruptedException unused) {
            }
        }
        return b5.d();
    }
}
