package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class b extends a {
    private final x c;
    private final boolean d;
    private final d e;
    private final int f;
    private int g;
    private final b h;
    private b i;

    b(x xVar, d dVar, b bVar) {
        this(xVar, true, dVar, bVar);
    }

    b(x xVar, boolean z, d dVar, b bVar) {
        super(458752);
        this.c = xVar;
        this.d = z;
        this.e = dVar;
        int i = dVar.b;
        this.f = i == 0 ? -1 : i - 2;
        this.h = bVar;
        if (bVar != null) {
            bVar.i = this;
        }
    }

    static int g(String str, b[] bVarArr, int i) {
        int i2 = (i * 2) + 7;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += bVarArr[i3] == null ? 0 : r3.f(str) - 8;
        }
        return i2;
    }

    static void i(int i, b[] bVarArr, int i2, d dVar) {
        int i3 = (i2 * 2) + 1;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += bVarArr[i4] == null ? 0 : r4.f(null) - 8;
        }
        dVar.k(i);
        dVar.i(i3);
        dVar.g(i2);
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = 0;
            b bVar = null;
            for (b bVar2 = bVarArr[i6]; bVar2 != null; bVar2 = bVar2.h) {
                bVar2.d();
                i7++;
                bVar = bVar2;
            }
            dVar.k(i7);
            while (bVar != null) {
                d dVar2 = bVar.e;
                dVar.h(dVar2.a, 0, dVar2.b);
                bVar = bVar.i;
            }
        }
    }

    @Override // vz.a
    public void a(String str, Object obj) {
        this.g++;
        if (this.d) {
            this.e.k(this.c.D(str));
        }
        if (obj instanceof String) {
            this.e.e(115, this.c.D((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.e.e(66, this.c.l(((Byte) obj).byteValue()).a);
            return;
        }
        if (obj instanceof Boolean) {
            this.e.e(90, this.c.l(((Boolean) obj).booleanValue() ? 1 : 0).a);
            return;
        }
        if (obj instanceof Character) {
            this.e.e(67, this.c.l(((Character) obj).charValue()).a);
            return;
        }
        if (obj instanceof Short) {
            this.e.e(83, this.c.l(((Short) obj).shortValue()).a);
            return;
        }
        if (obj instanceof y) {
            this.e.e(99, this.c.D(((y) obj).e()));
            return;
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.e.e(91, bArr.length);
            int length = bArr.length;
            while (i < length) {
                this.e.e(66, this.c.l(bArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.e.e(91, zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                this.e.e(90, this.c.l(zArr[i] ? 1 : 0).a);
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.e.e(91, sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                this.e.e(83, this.c.l(sArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.e.e(91, cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                this.e.e(67, this.c.l(cArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.e.e(91, iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                this.e.e(73, this.c.l(iArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.e.e(91, jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                this.e.e(74, this.c.p(jArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.e.e(91, fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                this.e.e(70, this.c.k(fArr[i]).a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            w d = this.c.d(obj);
            this.e.e(".s.IFJDCS".charAt(d.b), d.a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.e.e(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            this.e.e(68, this.c.f(dArr[i]).a);
            i++;
        }
    }

    @Override // vz.a
    public a b(String str, String str2) {
        this.g++;
        if (this.d) {
            this.e.k(this.c.D(str));
        }
        this.e.e(64, this.c.D(str2)).k(0);
        return new b(this.c, this.e, null);
    }

    @Override // vz.a
    public a c(String str) {
        this.g++;
        if (this.d) {
            this.e.k(this.c.D(str));
        }
        this.e.e(91, 0);
        return new b(this.c, false, this.e, null);
    }

    @Override // vz.a
    public void d() {
        int i = this.f;
        if (i != -1) {
            byte[] bArr = this.e.a;
            int i2 = this.g;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }

    @Override // vz.a
    public void e(String str, String str2, String str3) {
        this.g++;
        if (this.d) {
            this.e.k(this.c.D(str));
        }
        this.e.e(101, this.c.D(str2)).k(this.c.D(str3));
    }

    int f(String str) {
        if (str != null) {
            this.c.D(str);
        }
        int i = 8;
        for (b bVar = this; bVar != null; bVar = bVar.h) {
            i += bVar.e.b;
        }
        return i;
    }

    void h(int i, d dVar) {
        int i2 = 2;
        int i3 = 0;
        b bVar = null;
        for (b bVar2 = this; bVar2 != null; bVar2 = bVar2.h) {
            bVar2.d();
            i2 += bVar2.e.b;
            i3++;
            bVar = bVar2;
        }
        dVar.k(i);
        dVar.i(i2);
        dVar.k(i3);
        while (bVar != null) {
            d dVar2 = bVar.e;
            dVar.h(dVar2.a, 0, dVar2.b);
            bVar = bVar.i;
        }
    }
}
