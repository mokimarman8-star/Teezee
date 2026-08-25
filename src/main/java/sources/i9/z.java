package i9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class z implements b0 {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final boolean d;

    public z(long[] jArr, long[] jArr2, long j) {
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.c;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        if (!this.d) {
            return new b0.a(c0.c);
        }
        int i = p0.i(this.b, j, true, true);
        c0 c0Var = new c0(this.b[i], this.a[i]);
        if (c0Var.a == j || i == this.b.length - 1) {
            return new b0.a(c0Var);
        }
        int i2 = i + 1;
        return new b0.a(c0Var, new c0(this.b[i2], this.a[i2]));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return this.d;
    }
}
