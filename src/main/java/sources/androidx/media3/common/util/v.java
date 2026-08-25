package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f9141a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f9142b;

    public v() {
        this(32);
    }

    public v(int i5) {
        this.f9142b = new long[i5];
    }

    public void a(long j5) {
        int i5 = this.f9141a;
        long[] jArr = this.f9142b;
        if (i5 == jArr.length) {
            this.f9142b = Arrays.copyOf(jArr, i5 * 2);
        }
        long[] jArr2 = this.f9142b;
        int i6 = this.f9141a;
        this.f9141a = i6 + 1;
        jArr2[i6] = j5;
    }

    public void b(long[] jArr) {
        int length = this.f9141a + jArr.length;
        long[] jArr2 = this.f9142b;
        if (length > jArr2.length) {
            this.f9142b = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, this.f9142b, this.f9141a, jArr.length);
        this.f9141a = length;
    }

    public long c(int i5) {
        if (i5 >= 0 && i5 < this.f9141a) {
            return this.f9142b[i5];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i5 + ", size is " + this.f9141a);
    }

    public int d() {
        return this.f9141a;
    }
}
