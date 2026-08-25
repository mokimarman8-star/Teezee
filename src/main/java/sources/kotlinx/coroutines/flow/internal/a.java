package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.h1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    private c[] a;
    private int b;
    private int c;
    private t d;

    public final h1 c() {
        t tVar;
        synchronized (this) {
            tVar = this.d;
            if (tVar == null) {
                tVar = new t(this.b);
                this.d = tVar;
            }
        }
        return tVar;
    }

    protected final c i() {
        c cVar;
        t tVar;
        synchronized (this) {
            try {
                c[] cVarArr = this.a;
                if (cVarArr == null) {
                    cVarArr = k(2);
                    this.a = cVarArr;
                } else if (this.b >= cVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(cVarArr, cVarArr.length * 2);
                    Intrinsics.g(copyOf, "copyOf(...)");
                    this.a = (c[]) copyOf;
                    cVarArr = (c[]) copyOf;
                }
                int i = this.c;
                do {
                    cVar = cVarArr[i];
                    if (cVar == null) {
                        cVar = j();
                        cVarArr[i] = cVar;
                    }
                    i++;
                    if (i >= cVarArr.length) {
                        i = 0;
                    }
                    Intrinsics.f(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!cVar.a(this));
                this.c = i;
                this.b++;
                tVar = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tVar != null) {
            tVar.a0(1);
        }
        return cVar;
    }

    protected abstract c j();

    protected abstract c[] k(int i);

    protected final void l(c cVar) {
        t tVar;
        int i;
        Continuation[] b;
        synchronized (this) {
            try {
                int i2 = this.b - 1;
                this.b = i2;
                tVar = this.d;
                if (i2 == 0) {
                    this.c = 0;
                }
                Intrinsics.f(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b = cVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : b) {
            if (continuation != null) {
                Result$Companion result$Companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(Unit.a));
            }
        }
        if (tVar != null) {
            tVar.a0(-1);
        }
    }

    protected final int m() {
        return this.b;
    }

    protected final c[] n() {
        return this.a;
    }
}
