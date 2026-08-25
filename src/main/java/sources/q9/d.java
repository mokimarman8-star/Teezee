package q9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class d {

    public static final class b {
        public final long[] a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;

        private b(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.a = jArr;
            this.b = iArr;
            this.c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
        }
    }

    public static b a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += p0.l(i4, i2);
        }
        long[] jArr2 = new long[i3];
        int[] iArr2 = new int[i3];
        long[] jArr3 = new long[i3];
        int[] iArr3 = new int[i3];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            long j2 = jArr[i10];
            while (i11 > 0) {
                int min = Math.min(i2, i11);
                jArr2[i6] = j2;
                int i12 = i * min;
                iArr2[i6] = i12;
                i7 = Math.max(i7, i12);
                jArr3[i6] = i5 * j;
                iArr3[i6] = 1;
                j2 += iArr2[i6];
                i5 += min;
                i11 -= min;
                i6++;
            }
        }
        return new b(jArr2, iArr2, i7, jArr3, iArr3, j * i5);
    }
}
