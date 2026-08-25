package y;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final a f18532e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final i f18533f = new i(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final float f18534a;

    /* renamed from: b, reason: collision with root package name */
    private final float f18535b;

    /* renamed from: c, reason: collision with root package name */
    private final float f18536c;

    /* renamed from: d, reason: collision with root package name */
    private final float f18537d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f18533f;
        }
    }

    public i(float f5, float f6, float f7, float f8) {
        this.f18534a = f5;
        this.f18535b = f6;
        this.f18536c = f7;
        this.f18537d = f8;
    }

    public final boolean b(long j5) {
        return g.m(j5) >= this.f18534a && g.m(j5) < this.f18536c && g.n(j5) >= this.f18535b && g.n(j5) < this.f18537d;
    }

    public final float c() {
        return this.f18537d;
    }

    public final long d() {
        return h.a(this.f18534a + (k() / 2.0f), this.f18535b + (e() / 2.0f));
    }

    public final float e() {
        return this.f18537d - this.f18535b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(this.f18534a, iVar.f18534a) == 0 && Float.compare(this.f18535b, iVar.f18535b) == 0 && Float.compare(this.f18536c, iVar.f18536c) == 0 && Float.compare(this.f18537d, iVar.f18537d) == 0;
    }

    public final float f() {
        return this.f18534a;
    }

    public final float g() {
        return this.f18536c;
    }

    public final long h() {
        return n.a(k(), e());
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f18534a) * 31) + Float.floatToIntBits(this.f18535b)) * 31) + Float.floatToIntBits(this.f18536c)) * 31) + Float.floatToIntBits(this.f18537d);
    }

    public final float i() {
        return this.f18535b;
    }

    public final long j() {
        return h.a(this.f18534a, this.f18535b);
    }

    public final float k() {
        return this.f18536c - this.f18534a;
    }

    public final i l(float f5, float f6, float f7, float f8) {
        return new i(Math.max(this.f18534a, f5), Math.max(this.f18535b, f6), Math.min(this.f18536c, f7), Math.min(this.f18537d, f8));
    }

    public final i m(i iVar) {
        return new i(Math.max(this.f18534a, iVar.f18534a), Math.max(this.f18535b, iVar.f18535b), Math.min(this.f18536c, iVar.f18536c), Math.min(this.f18537d, iVar.f18537d));
    }

    public final boolean n() {
        return this.f18534a >= this.f18536c || this.f18535b >= this.f18537d;
    }

    public final boolean o(i iVar) {
        return this.f18536c > iVar.f18534a && iVar.f18536c > this.f18534a && this.f18537d > iVar.f18535b && iVar.f18537d > this.f18535b;
    }

    public final i p(float f5, float f6) {
        return new i(this.f18534a + f5, this.f18535b + f6, this.f18536c + f5, this.f18537d + f6);
    }

    public final i q(long j5) {
        return new i(this.f18534a + g.m(j5), this.f18535b + g.n(j5), this.f18536c + g.m(j5), this.f18537d + g.n(j5));
    }

    public String toString() {
        return "Rect.fromLTRB(" + c.a(this.f18534a, 1) + ", " + c.a(this.f18535b, 1) + ", " + c.a(this.f18536c, 1) + ", " + c.a(this.f18537d, 1) + ')';
    }
}
