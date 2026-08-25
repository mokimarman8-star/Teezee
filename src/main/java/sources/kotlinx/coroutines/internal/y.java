package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class y {
    private static final StackTraceElement a = new b.a().a();
    private static final String b;
    private static final String c;

    static {
        Object obj;
        Object obj2;
        try {
            Result$Companion result$Companion = Result.Companion;
            obj = Result.constructor-impl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        b = (String) obj;
        try {
            obj2 = Result.constructor-impl(y.class.getCanonicalName());
        } catch (Throwable th2) {
            Result$Companion result$Companion3 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        c = (String) obj2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
