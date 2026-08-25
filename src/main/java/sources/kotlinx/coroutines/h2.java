package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class h2 extends w1 {
    private final Continuation e;

    public h2(Continuation continuation) {
        this.e = continuation;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        Continuation continuation = this.e;
        Result$Companion result$Companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl(Unit.a));
    }
}
