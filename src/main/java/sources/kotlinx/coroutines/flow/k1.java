package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k1 implements b {
    public final Throwable a;

    public k1(Throwable th) {
        this.a = th;
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(Object obj, Continuation continuation) {
        throw this.a;
    }
}
