package md;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    public static final a h = new a(4201, 4096, 1);
    public static final a i = new a(1033, 1024, 1);
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final a o;
    private final int[] a;
    private final int[] b;
    private final b c;
    private final b d;
    private final int e;
    private final int f;
    private final int g;

    static {
        a aVar = new a(67, 64, 1);
        j = aVar;
        k = new a(19, 16, 1);
        l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        m = aVar2;
        n = aVar2;
        o = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.c = new b(this, new int[]{0});
        this.d = new b(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    b b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    int c(int i2) {
        return this.a[i2];
    }

    public int d() {
        return this.g;
    }

    b e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    b g() {
        return this.c;
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f) + ',' + this.e + ')';
    }
}
