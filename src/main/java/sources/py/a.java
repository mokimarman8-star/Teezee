package py;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.g;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    private static final void a(Continuation continuation, Throwable th) {
        Result$Companion result$Companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl(ResultKt.a(th)));
        throw th;
    }

    public static final void b(Continuation continuation, Continuation continuation2) {
        try {
            Continuation c = IntrinsicsKt.c(continuation);
            Result$Companion result$Companion = Result.Companion;
            g.b(c, Result.constructor-impl(Unit.a));
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final void c(Function2 function2, Object obj, Continuation continuation) {
        try {
            Continuation c = IntrinsicsKt.c(IntrinsicsKt.a(function2, obj, continuation));
            Result$Companion result$Companion = Result.Companion;
            g.b(c, Result.constructor-impl(Unit.a));
        } catch (Throwable th) {
            a(continuation, th);
        }
    }
}
