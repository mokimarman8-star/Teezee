package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c0 {
    public static final Object a(Object obj, Continuation continuation) {
        if (!(obj instanceof b0)) {
            return Result.constructor-impl(obj);
        }
        Result$Companion result$Companion = Result.Companion;
        return Result.constructor-impl(ResultKt.a(((b0) obj).a));
    }

    public static final Object b(Object obj) {
        Throwable th = Result.exceptionOrNull-impl(obj);
        return th == null ? obj : new b0(th, false, 2, null);
    }

    public static final Object c(Object obj, n nVar) {
        Throwable th = Result.exceptionOrNull-impl(obj);
        return th == null ? obj : new b0(th, false, 2, null);
    }
}
