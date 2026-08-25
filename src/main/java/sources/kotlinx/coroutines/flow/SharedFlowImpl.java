package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.a;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.internal.j;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SharedFlowImpl extends a implements w0, a, j {
    private final int e;
    private final int f;
    private final BufferOverflow g;
    private Object[] h;
    private long i;
    private long j;
    private int k;
    private int l;

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.e = i;
        this.f = i2;
        this.g = bufferOverflow;
    }

    private final void A() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            Intrinsics.e(objArr);
            while (this.l > 0 && c1.c(objArr, (L() + Q()) - 1) == c1.a) {
                this.l--;
                c1.d(objArr, L() + Q(), (Object) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:14:0x003b, B:18:0x0092, B:20:0x009a, B:28:0x00ad, B:29:0x00b0, B:36:0x005d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00be -> B:15:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object B(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.b r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void C(long j) {
        d1[] h;
        if (a.g(this) != 0 && (h = a.h(this)) != null) {
            for (d1 d1Var : h) {
                if (d1Var != null) {
                    d1 d1Var2 = d1Var;
                    long j2 = d1Var2.a;
                    if (j2 >= 0 && j2 < j) {
                        d1Var2.a = j;
                    }
                }
            }
        }
        this.j = j;
    }

    private final void F() {
        Object[] objArr = this.h;
        Intrinsics.e(objArr);
        c1.d(objArr, L(), (Object) null);
        this.k--;
        long L = L() + 1;
        if (this.i < L) {
            this.i = L;
        }
        if (this.j < L) {
            C(L);
        }
    }

    static /* synthetic */ Object G(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        Object H;
        return (!sharedFlowImpl.b(obj) && (H = sharedFlowImpl.H(obj, continuation)) == IntrinsicsKt.f()) ? H : Unit.a;
    }

    private final Object H(Object obj, Continuation continuation) {
        Continuation[] continuationArr;
        a1 a1Var;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation[] continuationArr2 = b.a;
        synchronized (this) {
            try {
                if (S(obj)) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m34constructorimpl(Unit.a));
                    continuationArr = J(continuationArr2);
                    a1Var = null;
                } else {
                    a1 aVar = new a(this, Q() + L(), obj, cancellableContinuationImpl);
                    I(aVar);
                    this.l++;
                    if (this.f == 0) {
                        continuationArr2 = J(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    a1Var = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (a1Var != null) {
            q.a(cancellableContinuationImpl, a1Var);
        }
        for (Continuation continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m34constructorimpl(Unit.a));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(Object obj) {
        int Q = Q();
        Object[] objArr = this.h;
        if (objArr == null) {
            objArr = R(null, 0, 2);
        } else if (Q >= objArr.length) {
            objArr = R(objArr, Q, objArr.length * 2);
        }
        c1.d(objArr, L() + Q, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation[] J(Continuation[] continuationArr) {
        c[] h;
        d1 d1Var;
        Continuation continuation;
        int length = continuationArr.length;
        if (a.g(this) != 0 && (h = a.h(this)) != null) {
            int length2 = h.length;
            int i = 0;
            continuationArr = continuationArr;
            while (i < length2) {
                c cVar = h[i];
                if (cVar != null && (continuation = (d1Var = (d1) cVar).b) != null && U(d1Var) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.g((Object) copyOf, "copyOf(...)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    d1Var.b = null;
                    length++;
                }
                i++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    private final long K() {
        return L() + this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long L() {
        return Math.min(this.j, this.i);
    }

    private final Object N(long j) {
        Object[] objArr = this.h;
        Intrinsics.e(objArr);
        Object c = c1.c(objArr, j);
        return c instanceof a ? ((a) c).c : c;
    }

    private final long O() {
        return L() + this.k + this.l;
    }

    private final int P() {
        return (int) ((L() + this.k) - this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q() {
        return this.k + this.l;
    }

    private final Object[] R(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i2];
        this.h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long L = L();
        for (int i3 = 0; i3 < i; i3++) {
            long j = i3 + L;
            c1.d(objArr2, j, c1.c(objArr, j));
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S(Object obj) {
        if (m() == 0) {
            return T(obj);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i = b.a[this.g.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        I(obj);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.f) {
            F();
        }
        if (P() > this.e) {
            W(this.i + 1, this.j, K(), O());
        }
        return true;
    }

    private final boolean T(Object obj) {
        if (this.e == 0) {
            return true;
        }
        I(obj);
        int i = this.k + 1;
        this.k = i;
        if (i > this.e) {
            F();
        }
        this.j = L() + this.k;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long U(d1 d1Var) {
        long j = d1Var.a;
        if (j < K()) {
            return j;
        }
        if (this.f <= 0 && j <= L() && this.l != 0) {
            return j;
        }
        return -1L;
    }

    private final Object V(d1 d1Var) {
        Object obj;
        Continuation[] continuationArr = b.a;
        synchronized (this) {
            try {
                long U = U(d1Var);
                if (U < 0) {
                    obj = c1.a;
                } else {
                    long j = d1Var.a;
                    Object N = N(U);
                    d1Var.a = U + 1;
                    continuationArr = X(j);
                    obj = N;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m34constructorimpl(Unit.a));
            }
        }
        return obj;
    }

    private final void W(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long L = L(); L < min; L++) {
            Object[] objArr = this.h;
            Intrinsics.e(objArr);
            c1.d(objArr, L, (Object) null);
        }
        this.i = j;
        this.j = j2;
        this.k = (int) (j3 - min);
        this.l = (int) (j4 - j3);
    }

    private final Object y(d1 d1Var, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (U(d1Var) < 0) {
                    d1Var.b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m34constructorimpl(Unit.a));
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(a aVar) {
        synchronized (this) {
            if (aVar.b < L()) {
                return;
            }
            Object[] objArr = this.h;
            Intrinsics.e(objArr);
            if (c1.c(objArr, aVar.b) != aVar) {
                return;
            }
            c1.d(objArr, aVar.b, c1.a);
            A();
            Unit unit = Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public d1 j() {
        return new d1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public d1[] k(int i) {
        return new d1[i];
    }

    protected final Object M() {
        Object[] objArr = this.h;
        Intrinsics.e(objArr);
        return c1.c(objArr, (this.i + P()) - 1);
    }

    public final Continuation[] X(long j) {
        long j2;
        long j3;
        long j4;
        d1[] h;
        if (j > this.j) {
            return b.a;
        }
        long L = L();
        long j5 = this.k + L;
        if (this.f == 0 && this.l > 0) {
            j5++;
        }
        if (a.g(this) != 0 && (h = a.h(this)) != null) {
            for (d1 d1Var : h) {
                if (d1Var != null) {
                    long j6 = d1Var.a;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (j5 <= this.j) {
            return b.a;
        }
        long K = K();
        int min = m() > 0 ? Math.min(this.l, this.f - ((int) (K - j5))) : this.l;
        Continuation[] continuationArr = b.a;
        long j7 = this.l + K;
        if (min > 0) {
            continuationArr = new Continuation[min];
            Object[] objArr = this.h;
            Intrinsics.e(objArr);
            long j8 = K;
            int i = 0;
            while (true) {
                if (K >= j7) {
                    j2 = j5;
                    j3 = j7;
                    break;
                }
                Object c = c1.c(objArr, K);
                j2 = j5;
                z zVar = c1.a;
                if (c != zVar) {
                    Intrinsics.f(c, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) c;
                    int i2 = i + 1;
                    j3 = j7;
                    continuationArr[i] = aVar.d;
                    c1.d(objArr, K, zVar);
                    c1.d(objArr, j8, aVar.c);
                    j4 = 1;
                    j8++;
                    if (i2 >= min) {
                        break;
                    }
                    i = i2;
                } else {
                    j3 = j7;
                    j4 = 1;
                }
                K += j4;
                j5 = j2;
                j7 = j3;
            }
            K = j8;
        } else {
            j2 = j5;
            j3 = j7;
        }
        int i3 = (int) (K - L);
        long j9 = m() == 0 ? K : j2;
        long max = Math.max(this.i, K - Math.min(this.e, i3));
        if (this.f == 0 && max < j3) {
            Object[] objArr2 = this.h;
            Intrinsics.e(objArr2);
            if (Intrinsics.c(c1.c(objArr2, max), c1.a)) {
                K++;
                max++;
            }
        }
        W(max, j9, K, j3);
        A();
        return !(continuationArr.length == 0) ? J(continuationArr) : continuationArr;
    }

    public final long Y() {
        long j = this.i;
        if (j < this.j) {
            this.j = j;
        }
        return j;
    }

    public Object a(b bVar, Continuation continuation) {
        return B(this, bVar, continuation);
    }

    public boolean b(Object obj) {
        int i;
        boolean z;
        Continuation[] continuationArr = b.a;
        synchronized (this) {
            if (S(obj)) {
                continuationArr = J(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m34constructorimpl(Unit.a));
            }
        }
        return z;
    }

    public a d(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return c1.e(this, coroutineContext, i, bufferOverflow);
    }

    public Object emit(Object obj, Continuation continuation) {
        return G(this, obj, continuation);
    }

    public void f() {
        synchronized (this) {
            W(K(), this.j, K(), O());
            Unit unit = Unit.a;
        }
    }
}
