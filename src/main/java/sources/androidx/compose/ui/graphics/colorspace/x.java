package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final double f3415a;

    /* renamed from: b, reason: collision with root package name */
    private final double f3416b;

    /* renamed from: c, reason: collision with root package name */
    private final double f3417c;

    /* renamed from: d, reason: collision with root package name */
    private final double f3418d;

    /* renamed from: e, reason: collision with root package name */
    private final double f3419e;

    /* renamed from: f, reason: collision with root package name */
    private final double f3420f;

    /* renamed from: g, reason: collision with root package name */
    private final double f3421g;

    public x(double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        this.f3415a = d5;
        this.f3416b = d6;
        this.f3417c = d7;
        this.f3418d = d8;
        this.f3419e = d9;
        this.f3420f = d10;
        this.f3421g = d11;
        if (Double.isNaN(d6) || Double.isNaN(d7) || Double.isNaN(d8) || Double.isNaN(d9) || Double.isNaN(d10) || Double.isNaN(d11) || Double.isNaN(d5)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (d9 < 0.0d || d9 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d9);
        }
        if (d9 == 0.0d && (d6 == 0.0d || d5 == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d9 >= 1.0d && d8 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d6 == 0.0d || d5 == 0.0d) && d8 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d8 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d6 < 0.0d || d5 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    public /* synthetic */ x(double d5, double d6, double d7, double d8, double d9, double d10, double d11, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(d5, d6, d7, d8, d9, (i5 & 32) != 0 ? 0.0d : d10, (i5 & 64) != 0 ? 0.0d : d11);
    }

    public final double a() {
        return this.f3416b;
    }

    public final double b() {
        return this.f3417c;
    }

    public final double c() {
        return this.f3418d;
    }

    public final double d() {
        return this.f3419e;
    }

    public final double e() {
        return this.f3420f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Double.compare(this.f3415a, xVar.f3415a) == 0 && Double.compare(this.f3416b, xVar.f3416b) == 0 && Double.compare(this.f3417c, xVar.f3417c) == 0 && Double.compare(this.f3418d, xVar.f3418d) == 0 && Double.compare(this.f3419e, xVar.f3419e) == 0 && Double.compare(this.f3420f, xVar.f3420f) == 0 && Double.compare(this.f3421g, xVar.f3421g) == 0;
    }

    public final double f() {
        return this.f3421g;
    }

    public final double g() {
        return this.f3415a;
    }

    public int hashCode() {
        return (((((((((((androidx.compose.animation.core.r.a(this.f3415a) * 31) + androidx.compose.animation.core.r.a(this.f3416b)) * 31) + androidx.compose.animation.core.r.a(this.f3417c)) * 31) + androidx.compose.animation.core.r.a(this.f3418d)) * 31) + androidx.compose.animation.core.r.a(this.f3419e)) * 31) + androidx.compose.animation.core.r.a(this.f3420f)) * 31) + androidx.compose.animation.core.r.a(this.f3421g);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.f3415a + ", a=" + this.f3416b + ", b=" + this.f3417c + ", c=" + this.f3418d + ", d=" + this.f3419e + ", e=" + this.f3420f + ", f=" + this.f3421g + ')';
    }
}
