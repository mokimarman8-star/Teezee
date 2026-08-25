package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f16296a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16297b;

    /* renamed from: c, reason: collision with root package name */
    private int f16298c;

    /* renamed from: d, reason: collision with root package name */
    private int f16299d;

    public u0(byte[] bArr) {
        this.f16296a = bArr;
        this.f16297b = bArr.length;
    }

    private void a() {
        int i5;
        int i6 = this.f16298c;
        androidx.media3.common.util.a.g(i6 >= 0 && (i6 < (i5 = this.f16297b) || (i6 == i5 && this.f16299d == 0)));
    }

    public int b() {
        return (this.f16298c * 8) + this.f16299d;
    }

    public boolean c() {
        boolean z5 = (((this.f16296a[this.f16298c] & 255) >> this.f16299d) & 1) == 1;
        e(1);
        return z5;
    }

    public int d(int i5) {
        int i6 = this.f16298c;
        int min = Math.min(i5, 8 - this.f16299d);
        int i7 = i6 + 1;
        int i8 = ((this.f16296a[i6] & 255) >> this.f16299d) & (255 >> (8 - min));
        while (min < i5) {
            i8 |= (this.f16296a[i7] & 255) << min;
            min += 8;
            i7++;
        }
        int i9 = i8 & ((-1) >>> (32 - i5));
        e(i5);
        return i9;
    }

    public void e(int i5) {
        int i6 = i5 / 8;
        int i7 = this.f16298c + i6;
        this.f16298c = i7;
        int i8 = this.f16299d + (i5 - (i6 * 8));
        this.f16299d = i8;
        if (i8 > 7) {
            this.f16298c = i7 + 1;
            this.f16299d = i8 - 8;
        }
        a();
    }
}
