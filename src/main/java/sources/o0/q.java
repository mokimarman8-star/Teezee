package o0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class q {
    public static final long a(int i5, int i6) {
        return p.c((i6 & 4294967295L) | (i5 << 32));
    }

    public static final long b(long j5, long j6) {
        return y.h.a(y.g.m(j5) - p.h(j6), y.g.n(j5) - p.i(j6));
    }

    public static final long c(long j5, long j6) {
        return y.h.a(y.g.m(j5) + p.h(j6), y.g.n(j5) + p.i(j6));
    }

    public static final long d(long j5) {
        return p.c((Math.round(y.g.n(j5)) & 4294967295L) | (Math.round(y.g.m(j5)) << 32));
    }
}
