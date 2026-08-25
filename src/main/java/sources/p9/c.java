package p9;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class c implements g {
    private final long[] a;
    private final long[] b;
    private final long c;

    private c(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? p0.B0(jArr2[jArr2.length - 1]) : j;
    }

    public static c b(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3];
            j3 += mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new c(jArr, jArr2, j2);
    }

    private static Pair c(long j, long[] jArr, long[] jArr2) {
        int i = p0.i(jArr, j, true, true);
        long j2 = jArr[i];
        long j3 = jArr2[i];
        int i2 = i + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i2] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i2] - j3))) + j3));
    }

    @Override // p9.g
    public long a() {
        return -1L;
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.c;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        Pair c = c(p0.e1(p0.r(j, 0L, this.c)), this.b, this.a);
        return new b0.a(new c0(p0.B0(((Long) c.first).longValue()), ((Long) c.second).longValue()));
    }

    @Override // p9.g
    public long getTimeUs(long j) {
        return p0.B0(((Long) c(j, this.a, this.b).second).longValue());
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }
}
