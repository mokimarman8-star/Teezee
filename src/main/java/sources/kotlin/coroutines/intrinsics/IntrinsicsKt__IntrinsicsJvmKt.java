package kotlin.coroutines.intrinsics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class IntrinsicsKt__IntrinsicsJvmKt {
    public static Continuation a(Function2 function2, Object obj, Continuation continuation) {
        Intrinsics.h(function2, "<this>");
        Intrinsics.h(continuation, "completion");
        Continuation<?> a = DebugProbesKt.a(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(obj, a);
        }
        CoroutineContext context = a.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$.inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.3(a, function2, obj) : new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$.inlined.createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt.4(a, context, function2, obj);
    }

    private static final Continuation b(Continuation continuation) {
        CoroutineContext context = continuation.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new createSimpleCoroutineForSuspendFunction.1(continuation) : new createSimpleCoroutineForSuspendFunction.2(continuation, context);
    }

    public static Continuation c(Continuation continuation) {
        Continuation<Object> intercepted;
        Intrinsics.h(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) ? continuation : intercepted;
    }

    public static Object d(Function2 function2, Object obj, Continuation continuation) {
        Intrinsics.h(function2, "<this>");
        Intrinsics.h(continuation, "completion");
        return ((Function2) TypeIntrinsics.e(function2, 2)).invoke(obj, b(DebugProbesKt.a(continuation)));
    }

    public static Object e(Function3 function3, Object obj, Object obj2, Continuation continuation) {
        Intrinsics.h(function3, "<this>");
        Intrinsics.h(continuation, "completion");
        return ((Function3) TypeIntrinsics.e(function3, 3)).invoke(obj, obj2, b(DebugProbesKt.a(continuation)));
    }
}
