package androidx.appcompat.app;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class b0 {

    /* renamed from: d, reason: collision with root package name */
    private static b0 f265d;

    /* renamed from: a, reason: collision with root package name */
    public long f266a;

    /* renamed from: b, reason: collision with root package name */
    public long f267b;

    /* renamed from: c, reason: collision with root package name */
    public int f268c;

    b0() {
    }

    static b0 b() {
        if (f265d == null) {
            f265d = new b0();
        }
        return f265d;
    }

    public void a(long j5, double d5, double d6) {
        double d7 = (0.01720197f * ((j5 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d7) * 0.03341960161924362d) + d7 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = Math.round((r3 - 9.0E-4f) - r7) + 9.0E-4f + ((-d6) / 360.0d) + (Math.sin(d7) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d8 = 0.01745329238474369d * d5;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d8) * Math.sin(asin))) / (Math.cos(d8) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f268c = 1;
            this.f266a = -1L;
            this.f267b = -1L;
        } else {
            if (sin2 <= -1.0d) {
                this.f268c = 0;
                this.f266a = -1L;
                this.f267b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f266a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f267b = round2;
            if (round2 >= j5 || this.f266a <= j5) {
                this.f268c = 1;
            } else {
                this.f268c = 0;
            }
        }
    }
}
