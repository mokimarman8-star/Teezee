package i9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d implements b0 {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int b(long j) {
        return p0.i(this.e, j, true, true);
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.f;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        int b = b(j);
        c0 c0Var = new c0(this.e[b], this.c[b]);
        if (c0Var.a >= j || b == this.a - 1) {
            return new b0.a(c0Var);
        }
        int i = b + 1;
        return new b0.a(c0Var, new c0(this.e[i], this.c[i]));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
