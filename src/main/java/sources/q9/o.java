package q9;

import com.google.android.exoplayer2.p1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class o {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final p1 f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final p[] k;

    public o(int i, int i2, long j, long j2, long j3, p1 p1Var, int i3, p[] pVarArr, int i4, long[] jArr, long[] jArr2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = p1Var;
        this.g = i3;
        this.k = pVarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public p a(int i) {
        p[] pVarArr = this.k;
        if (pVarArr == null) {
            return null;
        }
        return pVarArr[i];
    }
}
