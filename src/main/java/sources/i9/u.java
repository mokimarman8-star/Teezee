package i9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.v;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class u implements b0 {
    private final v a;
    private final long b;

    public u(v vVar, long j) {
        this.a = vVar;
        this.b = j;
    }

    private c0 b(long j, long j2) {
        return new c0((j * 1000000) / this.a.e, this.b + j2);
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.a.f();
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        com.google.android.exoplayer2.util.a.i(this.a.k);
        v vVar = this.a;
        v.a aVar = vVar.k;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.b;
        int i = p0.i(jArr, vVar.i(j), true, false);
        c0 b = b(i == -1 ? 0L : jArr[i], i != -1 ? jArr2[i] : 0L);
        if (b.a == j || i == jArr.length - 1) {
            return new b0.a(b);
        }
        int i2 = i + 1;
        return new b0.a(b, b(jArr[i2], jArr2[i2]));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }
}
