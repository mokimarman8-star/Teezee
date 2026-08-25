package k9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.c0;
import i9.e0;
import i9.m;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class e {
    protected final e0 a;
    private final int b;
    private final int c;
    private final long d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long[] k;
    private int[] l;

    public e(int i, int i2, long j, int i3, e0 e0Var) {
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        com.google.android.exoplayer2.util.a.a(z);
        this.d = j;
        this.e = i3;
        this.a = e0Var;
        this.b = d(i, i2 == 2 ? 1667497984 : 1651965952);
        this.c = i2 == 2 ? d(i, 1650720768) : -1;
        this.k = new long[512];
        this.l = new int[512];
    }

    private static int d(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private long e(int i) {
        return (this.d * i) / this.e;
    }

    private c0 h(int i) {
        return new c0(this.l[i] * g(), this.k[i]);
    }

    public void a() {
        this.h++;
    }

    public void b(long j) {
        if (this.j == this.l.length) {
            long[] jArr = this.k;
            this.k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.l;
            this.l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.k;
        int i = this.j;
        jArr2[i] = j;
        this.l[i] = this.i;
        this.j = i + 1;
    }

    public void c() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }

    public long f() {
        return e(this.h);
    }

    public long g() {
        return e(1);
    }

    public b0.a i(long j) {
        int g = (int) (j / g());
        int h = p0.h(this.l, g, true, true);
        if (this.l[h] == g) {
            return new b0.a(h(h));
        }
        c0 h2 = h(h);
        int i = h + 1;
        return i < this.k.length ? new b0.a(h2, h(i)) : new b0.a(h2);
    }

    public boolean j(int i) {
        return this.b == i || this.c == i;
    }

    public void k() {
        this.i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.l, this.h) >= 0;
    }

    public boolean m(m mVar) {
        int i = this.g;
        int b = i - this.a.b(mVar, i, false);
        this.g = b;
        boolean z = b == 0;
        if (z) {
            if (this.f > 0) {
                this.a.e(f(), l() ? 1 : 0, this.f, 0, null);
            }
            a();
        }
        return z;
    }

    public void n(int i) {
        this.f = i;
        this.g = i;
    }

    public void o(long j) {
        if (this.j == 0) {
            this.h = 0;
        } else {
            this.h = this.l[p0.i(this.k, j, true, true)];
        }
    }
}
