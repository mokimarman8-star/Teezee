package androidx.media3.exoplayer.video.spherical;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f11931a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11932b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11933c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11934d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b[] f11935a;

        public a(b... bVarArr) {
            this.f11935a = bVarArr;
        }

        public b a(int i5) {
            return this.f11935a[i5];
        }

        public int b() {
            return this.f11935a.length;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f11936a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11937b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f11938c;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f11939d;

        public b(int i5, float[] fArr, float[] fArr2, int i6) {
            this.f11936a = i5;
            androidx.media3.common.util.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f11938c = fArr;
            this.f11939d = fArr2;
            this.f11937b = i6;
        }

        public int a() {
            return this.f11938c.length / 3;
        }
    }

    public c(a aVar, int i5) {
        this(aVar, aVar, i5);
    }

    public c(a aVar, a aVar2, int i5) {
        this.f11931a = aVar;
        this.f11932b = aVar2;
        this.f11933c = i5;
        this.f11934d = aVar == aVar2;
    }

    public static c a(float f5, int i5, int i6, float f6, float f7, int i7) {
        float f8;
        float f9;
        int i8;
        int i9;
        float[] fArr;
        int i10 = i5;
        int i11 = 1;
        androidx.media3.common.util.a.a(f5 > 0.0f);
        androidx.media3.common.util.a.a(i10 >= 1);
        androidx.media3.common.util.a.a(i6 >= 1);
        androidx.media3.common.util.a.a(f6 > 0.0f && f6 <= 180.0f);
        androidx.media3.common.util.a.a(f7 > 0.0f && f7 <= 360.0f);
        float radians = (float) Math.toRadians(f6);
        float radians2 = (float) Math.toRadians(f7);
        float f10 = radians / i10;
        float f11 = radians2 / i6;
        int i12 = i6 + 1;
        int i13 = ((i12 * 2) + 2) * i10;
        float[] fArr2 = new float[i13 * 3];
        float[] fArr3 = new float[i13 * 2];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < i10) {
            float f12 = radians / 2.0f;
            float f13 = (i14 * f10) - f12;
            int i17 = i14 + 1;
            float f14 = (i17 * f10) - f12;
            int i18 = 0;
            while (i18 < i12) {
                int i19 = i17;
                float f15 = f13;
                int i20 = i16;
                int i21 = 0;
                int i22 = 2;
                while (i21 < i22) {
                    if (i21 == 0) {
                        f8 = f15;
                        f9 = f14;
                    } else {
                        f8 = f14;
                        f9 = f8;
                    }
                    float f16 = i18 * f11;
                    float f17 = f11;
                    float f18 = radians;
                    double d5 = f5;
                    int i23 = i18;
                    float f19 = f10;
                    double d6 = (f16 + 3.1415927f) - (radians2 / 2.0f);
                    double d7 = f8;
                    int i24 = i12;
                    float[] fArr4 = fArr3;
                    fArr2[i15] = -((float) (Math.sin(d6) * d5 * Math.cos(d7)));
                    float f20 = radians2;
                    int i25 = i21;
                    fArr2[i15 + 1] = (float) (d5 * Math.sin(d7));
                    int i26 = i15 + 3;
                    fArr2[i15 + 2] = (float) (d5 * Math.cos(d6) * Math.cos(d7));
                    fArr4[i20] = f16 / f20;
                    int i27 = i20 + 2;
                    fArr4[i20 + 1] = ((i14 + i25) * f19) / f18;
                    if (i23 == 0 && i25 == 0) {
                        i9 = i25;
                        i8 = i23;
                    } else {
                        i8 = i23;
                        i9 = i25;
                        if (i8 != i6 || i9 != 1) {
                            fArr = fArr4;
                            i22 = 2;
                            i15 = i26;
                            i20 = i27;
                            i21 = i9 + 1;
                            fArr3 = fArr;
                            radians2 = f20;
                            f14 = f9;
                            f11 = f17;
                            f10 = f19;
                            i12 = i24;
                            i18 = i8;
                            radians = f18;
                        }
                    }
                    System.arraycopy(fArr2, i15, fArr2, i26, 3);
                    i15 += 6;
                    fArr = fArr4;
                    i22 = 2;
                    System.arraycopy(fArr, i20, fArr, i27, 2);
                    i20 += 4;
                    i21 = i9 + 1;
                    fArr3 = fArr;
                    radians2 = f20;
                    f14 = f9;
                    f11 = f17;
                    f10 = f19;
                    i12 = i24;
                    i18 = i8;
                    radians = f18;
                }
                i18++;
                i17 = i19;
                f13 = f15;
                i16 = i20;
                radians2 = radians2;
                f11 = f11;
                radians = radians;
                i12 = i12;
            }
            i10 = i5;
            i14 = i17;
            i11 = 1;
        }
        int i28 = i11;
        b[] bVarArr = new b[i28];
        bVarArr[0] = new b(0, fArr2, fArr3, i28);
        return new c(new a(bVarArr), i7);
    }

    public static c b(int i5) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i5);
    }
}
