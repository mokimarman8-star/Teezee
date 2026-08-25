package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class LockFreeLinkedListNode {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (androidx.concurrent.futures.a.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.a, r3, r2, ((kotlinx.coroutines.internal.t) r4).a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.LockFreeLinkedListNode g() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = n()
            java.lang.Object r0 = r0.get(r7)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            return r2
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = n()
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.p()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.t
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = m()
            kotlinx.coroutines.internal.t r4 = (kotlinx.coroutines.internal.t) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.Intrinsics.f(r4, r3)
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.g():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    private final void i(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (j() != lockFreeLinkedListNode) {
                return;
            }
        } while (!a.a(b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (p()) {
            lockFreeLinkedListNode.g();
        }
    }

    private final t s() {
        t tVar = (t) c.get(this);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(this);
        c.set(this, tVar2);
        return tVar2;
    }

    public final boolean c(LockFreeLinkedListNode lockFreeLinkedListNode, int i) {
        j l;
        do {
            l = l();
            if (l instanceof j) {
                return (l.d & i) == 0 && l.c(lockFreeLinkedListNode, i);
            }
        } while (!l.d(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean d(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        b.set(lockFreeLinkedListNode, this);
        a.set(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!a.a(a, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.i(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        b.set(lockFreeLinkedListNode, this);
        a.set(lockFreeLinkedListNode, this);
        while (j() == this) {
            if (a.a(a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.i(this);
                return true;
            }
        }
        return false;
    }

    public final void f(int i) {
        c(new j(i), i);
    }

    public final Object j() {
        return a.get(this);
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object j = j();
        t tVar = j instanceof t ? (t) j : null;
        if (tVar != null && (lockFreeLinkedListNode = tVar.a) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.f(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode) j;
    }

    public final LockFreeLinkedListNode l() {
        LockFreeLinkedListNode g = g();
        return g == null ? h((LockFreeLinkedListNode) b.get(this)) : g;
    }

    public boolean p() {
        return j() instanceof t;
    }

    public boolean q() {
        return r() == null;
    }

    public final LockFreeLinkedListNode r() {
        Object j;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            j = j();
            if (j instanceof t) {
                return ((t) j).a;
            }
            if (j == this) {
                return (LockFreeLinkedListNode) j;
            }
            Intrinsics.f(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) j;
        } while (!a.a(a, this, j, lockFreeLinkedListNode.s()));
        lockFreeLinkedListNode.g();
        return null;
    }

    public String toString() {
        return new toString.1(this) + '@' + p0.b(this);
    }
}
