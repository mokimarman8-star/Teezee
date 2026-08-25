package v9;

import android.net.Uri;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.w1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class u extends l3 {
    private static final Object p = new Object();
    private static final w1 q = new w1.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final Object m;
    private final w1 n;
    private final w1.g o;

    public u(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, w1 w1Var, w1.g gVar) {
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = j7;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = obj;
        this.n = (w1) com.google.android.exoplayer2.util.a.e(w1Var);
        this.o = gVar;
    }

    public u(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, w1 w1Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, w1Var, z3 ? w1Var.d : null);
    }

    public u(long j, boolean z, boolean z2, boolean z3, Object obj, w1 w1Var) {
        this(j, j, 0L, 0L, z, z2, z3, obj, w1Var);
    }

    public int f(Object obj) {
        return p.equals(obj) ? 0 : -1;
    }

    public l3.b k(int i, l3.b bVar, boolean z) {
        com.google.android.exoplayer2.util.a.c(i, 0, 1);
        return bVar.v((Object) null, z ? p : null, 0, this.f, -this.h);
    }

    public int m() {
        return 1;
    }

    public Object q(int i) {
        com.google.android.exoplayer2.util.a.c(i, 0, 1);
        return p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l3.d s(int i, l3.d dVar, long j) {
        long j2;
        com.google.android.exoplayer2.util.a.c(i, 0, 1);
        long j3 = this.i;
        boolean z = this.k;
        if (z && !this.l && j != 0) {
            long j4 = this.g;
            if (j4 != -9223372036854775807L) {
                j3 += j;
            }
            j2 = -9223372036854775807L;
            return dVar.k(l3.d.r, this.n, this.m, this.c, this.d, this.e, this.j, z, this.o, j2, this.g, 0, 0, this.h);
        }
        j2 = j3;
        return dVar.k(l3.d.r, this.n, this.m, this.c, this.d, this.e, this.j, z, this.o, j2, this.g, 0, 0, this.h);
    }

    public int t() {
        return 1;
    }
}
