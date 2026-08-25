package q9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class r {
    public final o a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public r(o oVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.google.android.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.a = oVar;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int i = p0.i(this.f, j, true, false); i >= 0; i--) {
            if ((this.g[i] & 1) != 0) {
                return i;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int e = p0.e(this.f, j, true, false); e < this.f.length; e++) {
            if ((this.g[e] & 1) != 0) {
                return e;
            }
        }
        return -1;
    }
}
