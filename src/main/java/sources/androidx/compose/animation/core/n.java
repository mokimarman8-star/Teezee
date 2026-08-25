package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f1469a;

    /* renamed from: b, reason: collision with root package name */
    private float f1470b;

    /* renamed from: c, reason: collision with root package name */
    private float f1471c;

    /* renamed from: d, reason: collision with root package name */
    private float f1472d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1473e;

    public n(float f5, float f6, float f7, float f8) {
        super(null);
        this.f1469a = f5;
        this.f1470b = f6;
        this.f1471c = f7;
        this.f1472d = f8;
        this.f1473e = 4;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i5) {
        if (i5 == 0) {
            return this.f1469a;
        }
        if (i5 == 1) {
            return this.f1470b;
        }
        if (i5 == 2) {
            return this.f1471c;
        }
        if (i5 != 3) {
            return 0.0f;
        }
        return this.f1472d;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f1473e;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f1469a = 0.0f;
        this.f1470b = 0.0f;
        this.f1471c = 0.0f;
        this.f1472d = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i5, float f5) {
        if (i5 == 0) {
            this.f1469a = f5;
            return;
        }
        if (i5 == 1) {
            this.f1470b = f5;
        } else if (i5 == 2) {
            this.f1471c = f5;
        } else {
            if (i5 != 3) {
                return;
            }
            this.f1472d = f5;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (nVar.f1469a == this.f1469a && nVar.f1470b == this.f1470b && nVar.f1471c == this.f1471c && nVar.f1472d == this.f1472d) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f1469a;
    }

    public final float g() {
        return this.f1470b;
    }

    public final float h() {
        return this.f1471c;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f1469a) * 31) + Float.floatToIntBits(this.f1470b)) * 31) + Float.floatToIntBits(this.f1471c)) * 31) + Float.floatToIntBits(this.f1472d);
    }

    public final float i() {
        return this.f1472d;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public n c() {
        return new n(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.f1469a + ", v2 = " + this.f1470b + ", v3 = " + this.f1471c + ", v4 = " + this.f1472d;
    }
}
