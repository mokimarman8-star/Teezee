package kotlinx.coroutines;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a0 {
    public final Object a;
    public final m b;
    public final Function3 c;
    public final Object d;
    public final Throwable e;

    public a0(Object obj, m mVar, Function3 function3, Object obj2, Throwable th) {
        this.a = obj;
        this.b = mVar;
        this.c = function3;
        this.d = obj2;
        this.e = th;
    }

    public /* synthetic */ a0(Object obj, m mVar, Function3 function3, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : mVar, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    public static /* synthetic */ a0 b(a0 a0Var, Object obj, m mVar, Function3 function3, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = a0Var.a;
        }
        if ((i & 2) != 0) {
            mVar = a0Var.b;
        }
        m mVar2 = mVar;
        if ((i & 4) != 0) {
            function3 = a0Var.c;
        }
        Function3 function32 = function3;
        if ((i & 8) != 0) {
            obj2 = a0Var.d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = a0Var.e;
        }
        return a0Var.a(obj, mVar2, function32, obj4, th);
    }

    public final a0 a(Object obj, m mVar, Function3 function3, Object obj2, Throwable th) {
        return new a0(obj, mVar, function3, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(CancellableContinuationImpl cancellableContinuationImpl, Throwable th) {
        m mVar = this.b;
        if (mVar != null) {
            cancellableContinuationImpl.callCancelHandler(mVar, th);
        }
        Function3 function3 = this.c;
        if (function3 != null) {
            cancellableContinuationImpl.callOnCancellation(function3, th, this.a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.c(this.a, a0Var.a) && Intrinsics.c(this.b, a0Var.b) && Intrinsics.c(this.c, a0Var.c) && Intrinsics.c(this.d, a0Var.d) && Intrinsics.c(this.e, a0Var.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.b;
        int hashCode2 = (hashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        Function3 function3 = this.c;
        int hashCode3 = (hashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }
}
