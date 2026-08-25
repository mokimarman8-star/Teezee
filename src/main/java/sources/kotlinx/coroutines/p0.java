package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class p0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation continuation) {
        Object obj;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            Result$Companion result$Companion = Result.Companion;
            obj = Result.constructor-impl(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) obj;
    }
}
