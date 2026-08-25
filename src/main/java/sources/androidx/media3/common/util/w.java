package androidx.media3.common.util;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private int f9143a;

    /* renamed from: b, reason: collision with root package name */
    private int f9144b;

    /* renamed from: c, reason: collision with root package name */
    private int f9145c;

    /* renamed from: d, reason: collision with root package name */
    private long[] f9146d;

    /* renamed from: e, reason: collision with root package name */
    private int f9147e;

    public w() {
        this(16);
    }

    public w(int i5) {
        a.a(i5 >= 0 && i5 <= 1073741824);
        i5 = i5 == 0 ? 1 : i5;
        i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
        this.f9143a = 0;
        this.f9144b = -1;
        this.f9145c = 0;
        long[] jArr = new long[i5];
        this.f9146d = jArr;
        this.f9147e = jArr.length - 1;
    }

    private void c() {
        long[] jArr = this.f9146d;
        int length = jArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        long[] jArr2 = new long[length];
        int length2 = jArr.length;
        int i5 = this.f9143a;
        int i6 = length2 - i5;
        System.arraycopy(jArr, i5, jArr2, 0, i6);
        System.arraycopy(this.f9146d, 0, jArr2, i6, i5);
        this.f9143a = 0;
        this.f9144b = this.f9145c - 1;
        this.f9146d = jArr2;
        this.f9147e = jArr2.length - 1;
    }

    public void a(long j5) {
        if (this.f9145c == this.f9146d.length) {
            c();
        }
        int i5 = (this.f9144b + 1) & this.f9147e;
        this.f9144b = i5;
        this.f9146d[i5] = j5;
        this.f9145c++;
    }

    public void b() {
        this.f9143a = 0;
        this.f9144b = -1;
        this.f9145c = 0;
    }

    public long d() {
        if (this.f9145c != 0) {
            return this.f9146d[this.f9143a];
        }
        throw new NoSuchElementException();
    }

    public boolean e() {
        return this.f9145c == 0;
    }

    public long f() {
        int i5 = this.f9145c;
        if (i5 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f9146d;
        int i6 = this.f9143a;
        long j5 = jArr[i6];
        this.f9143a = this.f9147e & (i6 + 1);
        this.f9145c = i5 - 1;
        return j5;
    }
}
