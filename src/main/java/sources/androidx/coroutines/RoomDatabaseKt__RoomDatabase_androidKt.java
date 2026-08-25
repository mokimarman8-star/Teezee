package androidx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext b(RoomDatabase roomDatabase, ContinuationInterceptor continuationInterceptor) {
        m0 m0Var = new m0(continuationInterceptor);
        return continuationInterceptor.plus(m0Var).plus(n2.a(roomDatabase.G(), Integer.valueOf(System.identityHashCode(m0Var))));
    }

    private static final Object c(final RoomDatabase roomDatabase, final CoroutineContext coroutineContext, final Function2 function2, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            roomDatabase.I().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2048}, m = "invokeSuspend")
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: from Kotlin metadata */
                static final class n0 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ n $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ Function2<kotlinx.coroutines.n0, Continuation<Object>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    n0(RoomDatabase roomDatabase, n nVar, Function2<? super kotlinx.coroutines.n0, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super n0> continuation) {
                        super(2, continuation);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = nVar;
                        this.$transactionBlock = function2;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        n0 n0Var = new n0(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, continuation);
                        n0Var.L$0 = obj;
                        return n0Var;
                    }

                    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
                        return create(n0Var, continuation).invokeSuspend(Unit.a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        CoroutineContext b5;
                        Continuation continuation;
                        Object f5 = IntrinsicsKt.f();
                        int i5 = this.label;
                        if (i5 == 0) {
                            ResultKt.b(obj);
                            ContinuationInterceptor continuationInterceptor = ((kotlinx.coroutines.n0) this.L$0).getCoroutineContext().get(ContinuationInterceptor.k1);
                            Intrinsics.e(continuationInterceptor);
                            b5 = RoomDatabaseKt__RoomDatabase_androidKt.b(this.$this_startTransactionCoroutine, continuationInterceptor);
                            Continuation continuation2 = this.$continuation;
                            Result.Companion companion = Result.Companion;
                            Function2<kotlinx.coroutines.n0, Continuation<Object>, Object> function2 = this.$transactionBlock;
                            this.L$0 = continuation2;
                            this.label = 1;
                            obj = i.g(b5, function2, this);
                            if (obj == f5) {
                                return f5;
                            }
                            continuation = continuation2;
                        } else {
                            if (i5 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            continuation = (Continuation) this.L$0;
                            ResultKt.b(obj);
                        }
                        continuation.resumeWith(Result.constructor-impl(obj));
                        return Unit.a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        i.e(coroutineContext.minusKey(ContinuationInterceptor.k1), new n0(roomDatabase, cancellableContinuationImpl, function2, null));
                    } catch (Throwable th) {
                        cancellableContinuationImpl.cancel(th);
                    }
                }
            });
        } catch (RejectedExecutionException e5) {
            cancellableContinuationImpl.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e5));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static final Object d(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(function1, null);
        m0 m0Var = (m0) continuation.getContext().get(m0.f13228c);
        ContinuationInterceptor c5 = m0Var != null ? m0Var.c() : null;
        return c5 != null ? i.g(c5, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, continuation) : c(roomDatabase, continuation.getContext(), roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, continuation);
    }
}
