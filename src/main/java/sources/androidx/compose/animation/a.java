package androidx.compose.animation;

import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1365a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f1366b;

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f1367c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f1368d;

    /* renamed from: androidx.compose.animation.a$a, reason: collision with other inner class name */
    public static final class C0009a {

        /* renamed from: a, reason: collision with root package name */
        private final float f1369a;

        /* renamed from: b, reason: collision with root package name */
        private final float f1370b;

        public C0009a(float f5, float f6) {
            this.f1369a = f5;
            this.f1370b = f6;
        }

        public final float a() {
            return this.f1369a;
        }

        public final float b() {
            return this.f1370b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0009a)) {
                return false;
            }
            C0009a c0009a = (C0009a) obj;
            return Float.compare(this.f1369a, c0009a.f1369a) == 0 && Float.compare(this.f1370b, c0009a.f1370b) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f1369a) * 31) + Float.floatToIntBits(this.f1370b);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.f1369a + ", velocityCoefficient=" + this.f1370b + ')';
        }
    }

    static {
        float[] fArr = new float[101];
        f1366b = fArr;
        float[] fArr2 = new float[101];
        f1367c = fArr2;
        f.b(fArr, fArr2, 100);
        f1368d = 8;
    }

    private a() {
    }

    public final double a(float f5, float f6) {
        return Math.log((Math.abs(f5) * 0.35f) / f6);
    }

    public final C0009a b(float f5) {
        float f6 = 0.0f;
        float f7 = 1.0f;
        float k5 = RangesKt.k(f5, 0.0f, 1.0f);
        float f8 = 100;
        int i5 = (int) (f8 * k5);
        if (i5 < 100) {
            float f9 = i5 / f8;
            int i6 = i5 + 1;
            float f10 = i6 / f8;
            float[] fArr = f1366b;
            float f11 = fArr[i5];
            float f12 = (fArr[i6] - f11) / (f10 - f9);
            float f13 = ((k5 - f9) * f12) + f11;
            f6 = f12;
            f7 = f13;
        }
        return new C0009a(f7, f6);
    }
}
