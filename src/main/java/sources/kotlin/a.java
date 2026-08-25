package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a extends DeepRecursiveScope implements Continuation {
    private Function3 a;
    private Object b;
    private Continuation c;
    private Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function3 block, Object obj) {
        super(null);
        Object obj2;
        Intrinsics.h(block, "block");
        this.a = block;
        this.b = obj;
        Intrinsics.f(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = this;
        obj2 = DeepRecursiveKt.a;
        this.d = obj2;
    }

    @Override // kotlin.DeepRecursiveScope
    public Object a(Object obj, Continuation continuation) {
        Intrinsics.f(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = continuation;
        this.b = obj;
        Object f = IntrinsicsKt.f();
        if (f == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f;
    }

    public final Object e() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = this.d;
            Continuation continuation = this.c;
            if (continuation == null) {
                ResultKt.b(obj3);
                return obj3;
            }
            obj = DeepRecursiveKt.a;
            if (Result.equals-impl0(obj, obj3)) {
                try {
                    Function3 function3 = this.a;
                    Object obj4 = this.b;
                    Object e = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.e(function3, this, obj4, continuation) : ((Function3) TypeIntrinsics.e(function3, 3)).invoke(this, obj4, continuation);
                    if (e != IntrinsicsKt.f()) {
                        continuation.resumeWith(Result.constructor-impl(e));
                    }
                } catch (Throwable th) {
                    Result$Companion result$Companion = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl(ResultKt.a(th)));
                }
            } else {
                obj2 = DeepRecursiveKt.a;
                this.d = obj2;
                continuation.resumeWith(obj3);
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext getA() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.c = null;
        this.d = obj;
    }
}
