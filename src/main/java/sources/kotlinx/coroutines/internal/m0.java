package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class m0 {
    public final CoroutineContext a;
    private final Object[] b;
    private final m2[] c;
    private int d;

    public m0(CoroutineContext coroutineContext, int i) {
        this.a = coroutineContext;
        this.b = new Object[i];
        this.c = new m2[i];
    }

    public final void a(m2 m2Var, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        m2[] m2VarArr = this.c;
        this.d = i + 1;
        Intrinsics.f(m2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        m2VarArr[i] = m2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            m2 m2Var = this.c[length];
            Intrinsics.e(m2Var);
            m2Var.k(coroutineContext, this.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
