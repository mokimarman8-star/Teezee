package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3776a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3777b;

    public static final class a extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3778c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3779d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3780e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f3781f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f3782g;

        /* renamed from: h, reason: collision with root package name */
        private final float f3783h;

        /* renamed from: i, reason: collision with root package name */
        private final float f3784i;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9) {
            super(r2, r2, 3, null);
            boolean z7 = false;
            this.f3778c = f5;
            this.f3779d = f6;
            this.f3780e = f7;
            this.f3781f = z5;
            this.f3782g = z6;
            this.f3783h = f8;
            this.f3784i = f9;
        }

        public final float c() {
            return this.f3783h;
        }

        public final float d() {
            return this.f3784i;
        }

        public final float e() {
            return this.f3778c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f3778c, aVar.f3778c) == 0 && Float.compare(this.f3779d, aVar.f3779d) == 0 && Float.compare(this.f3780e, aVar.f3780e) == 0 && this.f3781f == aVar.f3781f && this.f3782g == aVar.f3782g && Float.compare(this.f3783h, aVar.f3783h) == 0 && Float.compare(this.f3784i, aVar.f3784i) == 0;
        }

        public final float f() {
            return this.f3780e;
        }

        public final float g() {
            return this.f3779d;
        }

        public final boolean h() {
            return this.f3781f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f3778c) * 31) + Float.floatToIntBits(this.f3779d)) * 31) + Float.floatToIntBits(this.f3780e)) * 31) + androidx.compose.foundation.e.a(this.f3781f)) * 31) + androidx.compose.foundation.e.a(this.f3782g)) * 31) + Float.floatToIntBits(this.f3783h)) * 31) + Float.floatToIntBits(this.f3784i);
        }

        public final boolean i() {
            return this.f3782g;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.f3778c + ", verticalEllipseRadius=" + this.f3779d + ", theta=" + this.f3780e + ", isMoreThanHalf=" + this.f3781f + ", isPositiveArc=" + this.f3782g + ", arcStartX=" + this.f3783h + ", arcStartY=" + this.f3784i + ')';
        }
    }

    public static final class b extends e {

        /* renamed from: c, reason: collision with root package name */
        public static final b f3785c = new b();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private b() {
            super(r2, r2, 3, null);
            boolean z5 = false;
        }
    }

    public static final class c extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3786c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3787d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3788e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3789f;

        /* renamed from: g, reason: collision with root package name */
        private final float f3790g;

        /* renamed from: h, reason: collision with root package name */
        private final float f3791h;

        public c(float f5, float f6, float f7, float f8, float f9, float f10) {
            super(true, false, 2, null);
            this.f3786c = f5;
            this.f3787d = f6;
            this.f3788e = f7;
            this.f3789f = f8;
            this.f3790g = f9;
            this.f3791h = f10;
        }

        public final float c() {
            return this.f3786c;
        }

        public final float d() {
            return this.f3788e;
        }

        public final float e() {
            return this.f3790g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.f3786c, cVar.f3786c) == 0 && Float.compare(this.f3787d, cVar.f3787d) == 0 && Float.compare(this.f3788e, cVar.f3788e) == 0 && Float.compare(this.f3789f, cVar.f3789f) == 0 && Float.compare(this.f3790g, cVar.f3790g) == 0 && Float.compare(this.f3791h, cVar.f3791h) == 0;
        }

        public final float f() {
            return this.f3787d;
        }

        public final float g() {
            return this.f3789f;
        }

        public final float h() {
            return this.f3791h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f3786c) * 31) + Float.floatToIntBits(this.f3787d)) * 31) + Float.floatToIntBits(this.f3788e)) * 31) + Float.floatToIntBits(this.f3789f)) * 31) + Float.floatToIntBits(this.f3790g)) * 31) + Float.floatToIntBits(this.f3791h);
        }

        public String toString() {
            return "CurveTo(x1=" + this.f3786c + ", y1=" + this.f3787d + ", x2=" + this.f3788e + ", y2=" + this.f3789f + ", x3=" + this.f3790g + ", y3=" + this.f3791h + ')';
        }
    }

    public static final class d extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3792c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(float f5) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3792c = f5;
        }

        public final float c() {
            return this.f3792c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Float.compare(this.f3792c, ((d) obj).f3792c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3792c);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.f3792c + ')';
        }
    }

    /* renamed from: androidx.compose.ui.graphics.vector.e$e, reason: collision with other inner class name */
    public static final class C0030e extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3793c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3794d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C0030e(float f5, float f6) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3793c = f5;
            this.f3794d = f6;
        }

        public final float c() {
            return this.f3793c;
        }

        public final float d() {
            return this.f3794d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0030e)) {
                return false;
            }
            C0030e c0030e = (C0030e) obj;
            return Float.compare(this.f3793c, c0030e.f3793c) == 0 && Float.compare(this.f3794d, c0030e.f3794d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3793c) * 31) + Float.floatToIntBits(this.f3794d);
        }

        public String toString() {
            return "LineTo(x=" + this.f3793c + ", y=" + this.f3794d + ')';
        }
    }

    public static final class f extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3795c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3796d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f(float f5, float f6) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3795c = f5;
            this.f3796d = f6;
        }

        public final float c() {
            return this.f3795c;
        }

        public final float d() {
            return this.f3796d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Float.compare(this.f3795c, fVar.f3795c) == 0 && Float.compare(this.f3796d, fVar.f3796d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3795c) * 31) + Float.floatToIntBits(this.f3796d);
        }

        public String toString() {
            return "MoveTo(x=" + this.f3795c + ", y=" + this.f3796d + ')';
        }
    }

    public static final class g extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3797c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3798d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3799e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3800f;

        public g(float f5, float f6, float f7, float f8) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f3797c = f5;
            this.f3798d = f6;
            this.f3799e = f7;
            this.f3800f = f8;
        }

        public final float c() {
            return this.f3797c;
        }

        public final float d() {
            return this.f3799e;
        }

        public final float e() {
            return this.f3798d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Float.compare(this.f3797c, gVar.f3797c) == 0 && Float.compare(this.f3798d, gVar.f3798d) == 0 && Float.compare(this.f3799e, gVar.f3799e) == 0 && Float.compare(this.f3800f, gVar.f3800f) == 0;
        }

        public final float f() {
            return this.f3800f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f3797c) * 31) + Float.floatToIntBits(this.f3798d)) * 31) + Float.floatToIntBits(this.f3799e)) * 31) + Float.floatToIntBits(this.f3800f);
        }

        public String toString() {
            return "QuadTo(x1=" + this.f3797c + ", y1=" + this.f3798d + ", x2=" + this.f3799e + ", y2=" + this.f3800f + ')';
        }
    }

    public static final class h extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3801c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3802d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3803e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3804f;

        public h(float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.f3801c = f5;
            this.f3802d = f6;
            this.f3803e = f7;
            this.f3804f = f8;
        }

        public final float c() {
            return this.f3801c;
        }

        public final float d() {
            return this.f3803e;
        }

        public final float e() {
            return this.f3802d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Float.compare(this.f3801c, hVar.f3801c) == 0 && Float.compare(this.f3802d, hVar.f3802d) == 0 && Float.compare(this.f3803e, hVar.f3803e) == 0 && Float.compare(this.f3804f, hVar.f3804f) == 0;
        }

        public final float f() {
            return this.f3804f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f3801c) * 31) + Float.floatToIntBits(this.f3802d)) * 31) + Float.floatToIntBits(this.f3803e)) * 31) + Float.floatToIntBits(this.f3804f);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f3801c + ", y1=" + this.f3802d + ", x2=" + this.f3803e + ", y2=" + this.f3804f + ')';
        }
    }

    public static final class i extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3805c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3806d;

        public i(float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f3805c = f5;
            this.f3806d = f6;
        }

        public final float c() {
            return this.f3805c;
        }

        public final float d() {
            return this.f3806d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Float.compare(this.f3805c, iVar.f3805c) == 0 && Float.compare(this.f3806d, iVar.f3806d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3805c) * 31) + Float.floatToIntBits(this.f3806d);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f3805c + ", y=" + this.f3806d + ')';
        }
    }

    public static final class j extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3807c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3808d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3809e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f3810f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f3811g;

        /* renamed from: h, reason: collision with root package name */
        private final float f3812h;

        /* renamed from: i, reason: collision with root package name */
        private final float f3813i;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public j(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9) {
            super(r2, r2, 3, null);
            boolean z7 = false;
            this.f3807c = f5;
            this.f3808d = f6;
            this.f3809e = f7;
            this.f3810f = z5;
            this.f3811g = z6;
            this.f3812h = f8;
            this.f3813i = f9;
        }

        public final float c() {
            return this.f3812h;
        }

        public final float d() {
            return this.f3813i;
        }

        public final float e() {
            return this.f3807c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Float.compare(this.f3807c, jVar.f3807c) == 0 && Float.compare(this.f3808d, jVar.f3808d) == 0 && Float.compare(this.f3809e, jVar.f3809e) == 0 && this.f3810f == jVar.f3810f && this.f3811g == jVar.f3811g && Float.compare(this.f3812h, jVar.f3812h) == 0 && Float.compare(this.f3813i, jVar.f3813i) == 0;
        }

        public final float f() {
            return this.f3809e;
        }

        public final float g() {
            return this.f3808d;
        }

        public final boolean h() {
            return this.f3810f;
        }

        public int hashCode() {
            return (((((((((((Float.floatToIntBits(this.f3807c) * 31) + Float.floatToIntBits(this.f3808d)) * 31) + Float.floatToIntBits(this.f3809e)) * 31) + androidx.compose.foundation.e.a(this.f3810f)) * 31) + androidx.compose.foundation.e.a(this.f3811g)) * 31) + Float.floatToIntBits(this.f3812h)) * 31) + Float.floatToIntBits(this.f3813i);
        }

        public final boolean i() {
            return this.f3811g;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.f3807c + ", verticalEllipseRadius=" + this.f3808d + ", theta=" + this.f3809e + ", isMoreThanHalf=" + this.f3810f + ", isPositiveArc=" + this.f3811g + ", arcStartDx=" + this.f3812h + ", arcStartDy=" + this.f3813i + ')';
        }
    }

    public static final class k extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3814c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3815d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3816e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3817f;

        /* renamed from: g, reason: collision with root package name */
        private final float f3818g;

        /* renamed from: h, reason: collision with root package name */
        private final float f3819h;

        public k(float f5, float f6, float f7, float f8, float f9, float f10) {
            super(true, false, 2, null);
            this.f3814c = f5;
            this.f3815d = f6;
            this.f3816e = f7;
            this.f3817f = f8;
            this.f3818g = f9;
            this.f3819h = f10;
        }

        public final float c() {
            return this.f3814c;
        }

        public final float d() {
            return this.f3816e;
        }

        public final float e() {
            return this.f3818g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Float.compare(this.f3814c, kVar.f3814c) == 0 && Float.compare(this.f3815d, kVar.f3815d) == 0 && Float.compare(this.f3816e, kVar.f3816e) == 0 && Float.compare(this.f3817f, kVar.f3817f) == 0 && Float.compare(this.f3818g, kVar.f3818g) == 0 && Float.compare(this.f3819h, kVar.f3819h) == 0;
        }

        public final float f() {
            return this.f3815d;
        }

        public final float g() {
            return this.f3817f;
        }

        public final float h() {
            return this.f3819h;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f3814c) * 31) + Float.floatToIntBits(this.f3815d)) * 31) + Float.floatToIntBits(this.f3816e)) * 31) + Float.floatToIntBits(this.f3817f)) * 31) + Float.floatToIntBits(this.f3818g)) * 31) + Float.floatToIntBits(this.f3819h);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.f3814c + ", dy1=" + this.f3815d + ", dx2=" + this.f3816e + ", dy2=" + this.f3817f + ", dx3=" + this.f3818g + ", dy3=" + this.f3819h + ')';
        }
    }

    public static final class l extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3820c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public l(float f5) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3820c = f5;
        }

        public final float c() {
            return this.f3820c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Float.compare(this.f3820c, ((l) obj).f3820c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3820c);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f3820c + ')';
        }
    }

    public static final class m extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3821c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3822d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public m(float f5, float f6) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3821c = f5;
            this.f3822d = f6;
        }

        public final float c() {
            return this.f3821c;
        }

        public final float d() {
            return this.f3822d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return Float.compare(this.f3821c, mVar.f3821c) == 0 && Float.compare(this.f3822d, mVar.f3822d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3821c) * 31) + Float.floatToIntBits(this.f3822d);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.f3821c + ", dy=" + this.f3822d + ')';
        }
    }

    public static final class n extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3823c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3824d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public n(float f5, float f6) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3823c = f5;
            this.f3824d = f6;
        }

        public final float c() {
            return this.f3823c;
        }

        public final float d() {
            return this.f3824d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return Float.compare(this.f3823c, nVar.f3823c) == 0 && Float.compare(this.f3824d, nVar.f3824d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3823c) * 31) + Float.floatToIntBits(this.f3824d);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.f3823c + ", dy=" + this.f3824d + ')';
        }
    }

    public static final class o extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3825c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3826d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3827e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3828f;

        public o(float f5, float f6, float f7, float f8) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f3825c = f5;
            this.f3826d = f6;
            this.f3827e = f7;
            this.f3828f = f8;
        }

        public final float c() {
            return this.f3825c;
        }

        public final float d() {
            return this.f3827e;
        }

        public final float e() {
            return this.f3826d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return Float.compare(this.f3825c, oVar.f3825c) == 0 && Float.compare(this.f3826d, oVar.f3826d) == 0 && Float.compare(this.f3827e, oVar.f3827e) == 0 && Float.compare(this.f3828f, oVar.f3828f) == 0;
        }

        public final float f() {
            return this.f3828f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f3825c) * 31) + Float.floatToIntBits(this.f3826d)) * 31) + Float.floatToIntBits(this.f3827e)) * 31) + Float.floatToIntBits(this.f3828f);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.f3825c + ", dy1=" + this.f3826d + ", dx2=" + this.f3827e + ", dy2=" + this.f3828f + ')';
        }
    }

    public static final class p extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3829c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3830d;

        /* renamed from: e, reason: collision with root package name */
        private final float f3831e;

        /* renamed from: f, reason: collision with root package name */
        private final float f3832f;

        public p(float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.f3829c = f5;
            this.f3830d = f6;
            this.f3831e = f7;
            this.f3832f = f8;
        }

        public final float c() {
            return this.f3829c;
        }

        public final float d() {
            return this.f3831e;
        }

        public final float e() {
            return this.f3830d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return Float.compare(this.f3829c, pVar.f3829c) == 0 && Float.compare(this.f3830d, pVar.f3830d) == 0 && Float.compare(this.f3831e, pVar.f3831e) == 0 && Float.compare(this.f3832f, pVar.f3832f) == 0;
        }

        public final float f() {
            return this.f3832f;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f3829c) * 31) + Float.floatToIntBits(this.f3830d)) * 31) + Float.floatToIntBits(this.f3831e)) * 31) + Float.floatToIntBits(this.f3832f);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.f3829c + ", dy1=" + this.f3830d + ", dx2=" + this.f3831e + ", dy2=" + this.f3832f + ')';
        }
    }

    public static final class q extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3833c;

        /* renamed from: d, reason: collision with root package name */
        private final float f3834d;

        public q(float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f3833c = f5;
            this.f3834d = f6;
        }

        public final float c() {
            return this.f3833c;
        }

        public final float d() {
            return this.f3834d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return Float.compare(this.f3833c, qVar.f3833c) == 0 && Float.compare(this.f3834d, qVar.f3834d) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f3833c) * 31) + Float.floatToIntBits(this.f3834d);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f3833c + ", dy=" + this.f3834d + ')';
        }
    }

    public static final class r extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3835c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r(float f5) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3835c = f5;
        }

        public final float c() {
            return this.f3835c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && Float.compare(this.f3835c, ((r) obj).f3835c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3835c);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f3835c + ')';
        }
    }

    public static final class s extends e {

        /* renamed from: c, reason: collision with root package name */
        private final float f3836c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public s(float f5) {
            super(r2, r2, 3, null);
            boolean z5 = false;
            this.f3836c = f5;
        }

        public final float c() {
            return this.f3836c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && Float.compare(this.f3836c, ((s) obj).f3836c) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3836c);
        }

        public String toString() {
            return "VerticalTo(y=" + this.f3836c + ')';
        }
    }

    private e(boolean z5, boolean z6) {
        this.f3776a = z5;
        this.f3777b = z6;
    }

    public /* synthetic */ e(boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6, null);
    }

    public /* synthetic */ e(boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
        this(z5, z6);
    }

    public final boolean a() {
        return this.f3776a;
    }

    public final boolean b() {
        return this.f3777b;
    }
}
