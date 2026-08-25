package androidx.media3.container;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f9349a;

    /* renamed from: b, reason: collision with root package name */
    private int f9350b;

    /* renamed from: c, reason: collision with root package name */
    private int f9351c;

    /* renamed from: d, reason: collision with root package name */
    private int f9352d;

    public h(byte[] bArr, int i5, int i6) {
        j(bArr, i5, i6);
    }

    private void a() {
        int i5;
        int i6 = this.f9351c;
        androidx.media3.common.util.a.g(i6 >= 0 && (i6 < (i5 = this.f9350b) || (i6 == i5 && this.f9352d == 0)));
    }

    private int g() {
        int i5 = 0;
        while (!e()) {
            i5++;
        }
        return ((1 << i5) - 1) + (i5 > 0 ? f(i5) : 0);
    }

    private boolean k(int i5) {
        if (2 <= i5 && i5 < this.f9350b) {
            byte[] bArr = this.f9349a;
            if (bArr[i5] == 3 && bArr[i5 - 2] == 0 && bArr[i5 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        int i5 = this.f9352d;
        if (i5 > 0) {
            m(8 - i5);
        }
    }

    public boolean c(int i5) {
        int i6 = this.f9351c;
        int i7 = i5 / 8;
        int i8 = i6 + i7;
        int i9 = (this.f9352d + i5) - (i7 * 8);
        if (i9 > 7) {
            i8++;
            i9 -= 8;
        }
        while (true) {
            i6++;
            if (i6 > i8 || i8 >= this.f9350b) {
                break;
            }
            if (k(i6)) {
                i8++;
                i6 += 2;
            }
        }
        int i10 = this.f9350b;
        if (i8 >= i10) {
            return i8 == i10 && i9 == 0;
        }
        return true;
    }

    public boolean d() {
        int i5 = this.f9351c;
        int i6 = this.f9352d;
        int i7 = 0;
        while (this.f9351c < this.f9350b && !e()) {
            i7++;
        }
        boolean z5 = this.f9351c == this.f9350b;
        this.f9351c = i5;
        this.f9352d = i6;
        return !z5 && c((i7 * 2) + 1);
    }

    public boolean e() {
        boolean z5 = (this.f9349a[this.f9351c] & (128 >> this.f9352d)) != 0;
        l();
        return z5;
    }

    public int f(int i5) {
        int i6;
        this.f9352d += i5;
        int i7 = 0;
        while (true) {
            i6 = this.f9352d;
            if (i6 <= 8) {
                break;
            }
            int i8 = i6 - 8;
            this.f9352d = i8;
            byte[] bArr = this.f9349a;
            int i9 = this.f9351c;
            i7 |= (bArr[i9] & 255) << i8;
            if (!k(i9 + 1)) {
                r3 = 1;
            }
            this.f9351c = i9 + r3;
        }
        byte[] bArr2 = this.f9349a;
        int i10 = this.f9351c;
        int i11 = ((-1) >>> (32 - i5)) & (i7 | ((bArr2[i10] & 255) >> (8 - i6)));
        if (i6 == 8) {
            this.f9352d = 0;
            this.f9351c = i10 + (k(i10 + 1) ? 2 : 1);
        }
        a();
        return i11;
    }

    public int h() {
        int g5 = g();
        return (g5 % 2 == 0 ? -1 : 1) * ((g5 + 1) / 2);
    }

    public int i() {
        return g();
    }

    public void j(byte[] bArr, int i5, int i6) {
        this.f9349a = bArr;
        this.f9351c = i5;
        this.f9350b = i6;
        this.f9352d = 0;
        a();
    }

    public void l() {
        int i5 = this.f9352d + 1;
        this.f9352d = i5;
        if (i5 == 8) {
            this.f9352d = 0;
            int i6 = this.f9351c;
            this.f9351c = i6 + (k(i6 + 1) ? 2 : 1);
        }
        a();
    }

    public void m(int i5) {
        int i6 = this.f9351c;
        int i7 = i5 / 8;
        int i8 = i6 + i7;
        this.f9351c = i8;
        int i9 = this.f9352d + (i5 - (i7 * 8));
        this.f9352d = i9;
        if (i9 > 7) {
            this.f9351c = i8 + 1;
            this.f9352d = i9 - 8;
        }
        while (true) {
            i6++;
            if (i6 > this.f9351c) {
                a();
                return;
            } else if (k(i6)) {
                this.f9351c++;
                i6 += 2;
            }
        }
    }
}
