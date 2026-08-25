package y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private float f18523a;

    /* renamed from: b, reason: collision with root package name */
    private float f18524b;

    /* renamed from: c, reason: collision with root package name */
    private float f18525c;

    /* renamed from: d, reason: collision with root package name */
    private float f18526d;

    public e(float f5, float f6, float f7, float f8) {
        this.f18523a = f5;
        this.f18524b = f6;
        this.f18525c = f7;
        this.f18526d = f8;
    }

    public final float a() {
        return this.f18526d;
    }

    public final float b() {
        return this.f18523a;
    }

    public final float c() {
        return this.f18525c;
    }

    public final float d() {
        return this.f18524b;
    }

    public final void e(float f5, float f6, float f7, float f8) {
        this.f18523a = Math.max(f5, this.f18523a);
        this.f18524b = Math.max(f6, this.f18524b);
        this.f18525c = Math.min(f7, this.f18525c);
        this.f18526d = Math.min(f8, this.f18526d);
    }

    public final boolean f() {
        return this.f18523a >= this.f18525c || this.f18524b >= this.f18526d;
    }

    public final void g(float f5, float f6, float f7, float f8) {
        this.f18523a = f5;
        this.f18524b = f6;
        this.f18525c = f7;
        this.f18526d = f8;
    }

    public final void h(float f5) {
        this.f18526d = f5;
    }

    public final void i(float f5) {
        this.f18523a = f5;
    }

    public final void j(float f5) {
        this.f18525c = f5;
    }

    public final void k(float f5) {
        this.f18524b = f5;
    }

    public String toString() {
        return "MutableRect(" + c.a(this.f18523a, 1) + ", " + c.a(this.f18524b, 1) + ", " + c.a(this.f18525c, 1) + ", " + c.a(this.f18526d, 1) + ')';
    }
}
