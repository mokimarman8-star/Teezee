package c3;

import k2.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class g {

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f14294d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f14295a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private int f14296b;

    /* renamed from: c, reason: collision with root package name */
    private int f14297c;

    public static long a(byte[] bArr, int i5, boolean z5) {
        long j5 = bArr[0] & 255;
        if (z5) {
            j5 &= ~f14294d[i5 - 1];
        }
        for (int i6 = 1; i6 < i5; i6++) {
            j5 = (j5 << 8) | (bArr[i6] & 255);
        }
        return j5;
    }

    public static int c(int i5) {
        int i6 = 0;
        while (true) {
            long[] jArr = f14294d;
            if (i6 >= jArr.length) {
                return -1;
            }
            if ((jArr[i6] & i5) != 0) {
                return i6 + 1;
            }
            i6++;
        }
    }

    public int b() {
        return this.f14297c;
    }

    public long d(s sVar, boolean z5, boolean z6, int i5) {
        if (this.f14296b == 0) {
            if (!sVar.readFully(this.f14295a, 0, 1, z5)) {
                return -1L;
            }
            int c5 = c(this.f14295a[0] & 255);
            this.f14297c = c5;
            if (c5 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f14296b = 1;
        }
        int i6 = this.f14297c;
        if (i6 > i5) {
            this.f14296b = 0;
            return -2L;
        }
        if (i6 != 1) {
            sVar.readFully(this.f14295a, 1, i6 - 1);
        }
        this.f14296b = 0;
        return a(this.f14295a, this.f14297c, z6);
    }

    public void e() {
        this.f14296b = 0;
        this.f14297c = 0;
    }
}
