package io.reactivex.rxjava3.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import okio.internal.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f {
    static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", Buffer.SEGMENTING_THRESHOLD).intValue();
    private static final Object j = new Object();
    int b;
    long c;
    final int d;
    AtomicReferenceArray e;
    final int f;
    AtomicReferenceArray g;
    final AtomicLong a = new AtomicLong();
    final AtomicLong h = new AtomicLong();

    public h(int i2) {
        int a = io.reactivex.rxjava3.internal.util.g.a(Math.max(8, i2));
        int i3 = a - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(a + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        a(a);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = a - 2;
        o(0L);
    }

    private void a(int i2) {
        this.b = Math.min(i2 / 4, i);
    }

    private static int b(int i2) {
        return i2;
    }

    private static int c(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private long d() {
        return this.h.get();
    }

    private long e() {
        return this.a.get();
    }

    private long f() {
        return this.h.get();
    }

    private static Object g(AtomicReferenceArray atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int i2) {
        int b = b(i2);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b);
        m(atomicReferenceArray, b, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.a.get();
    }

    private Object j(AtomicReferenceArray atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        int c = c(j2, i2);
        Object g = g(atomicReferenceArray, c);
        if (g != null) {
            m(atomicReferenceArray, c, null);
            l(j2 + 1);
        }
        return g;
    }

    private void k(AtomicReferenceArray atomicReferenceArray, long j2, int i2, Object obj, long j3) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j3 + j2) - 1;
        m(atomicReferenceArray2, i2, obj);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i2, j);
        o(j2 + 1);
    }

    private void l(long j2) {
        this.h.lazySet(j2);
    }

    private static void m(AtomicReferenceArray atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void n(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void o(long j2) {
        this.a.lazySet(j2);
    }

    private boolean p(AtomicReferenceArray atomicReferenceArray, Object obj, long j2, int i2) {
        m(atomicReferenceArray, i2, obj);
        o(j2 + 1);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        long e = e();
        int i2 = this.d;
        int c = c(e, i2);
        if (e < this.c) {
            return p(atomicReferenceArray, obj, e, c);
        }
        long j2 = this.b + e;
        if (g(atomicReferenceArray, c(j2, i2)) == null) {
            this.c = j2 - 1;
            return p(atomicReferenceArray, obj, e, c);
        }
        if (g(atomicReferenceArray, c(1 + e, i2)) == null) {
            return p(atomicReferenceArray, obj, e, c);
        }
        k(atomicReferenceArray, e, c, obj, i2);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.f, io.reactivex.rxjava3.operators.g
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.g;
        long d = d();
        int i2 = this.f;
        int c = c(d, i2);
        Object g = g(atomicReferenceArray, c);
        boolean z = g == j;
        if (g == null || z) {
            if (z) {
                return j(h(atomicReferenceArray, i2 + 1), d, i2);
            }
            return null;
        }
        m(atomicReferenceArray, c, null);
        l(d + 1);
        return g;
    }
}
