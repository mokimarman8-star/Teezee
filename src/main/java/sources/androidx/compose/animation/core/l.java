package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f1455a;

    /* renamed from: b, reason: collision with root package name */
    private float f1456b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1457c;

    public l(float f5, float f6) {
        super(null);
        this.f1455a = f5;
        this.f1456b = f6;
        this.f1457c = 2;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i5) {
        if (i5 == 0) {
            return this.f1455a;
        }
        if (i5 != 1) {
            return 0.0f;
        }
        return this.f1456b;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f1457c;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f1455a = 0.0f;
        this.f1456b = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i5, float f5) {
        if (i5 == 0) {
            this.f1455a = f5;
        } else {
            if (i5 != 1) {
                return;
            }
            this.f1456b = f5;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.f1455a == this.f1455a && lVar.f1456b == this.f1456b) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f1455a;
    }

    public final float g() {
        return this.f1456b;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public l c() {
        return new l(0.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f1455a) * 31) + Float.floatToIntBits(this.f1456b);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.f1455a + ", v2 = " + this.f1456b;
    }
}
