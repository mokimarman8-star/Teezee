package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f1453a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1454b;

    public k(float f5) {
        super(null);
        this.f1453a = f5;
        this.f1454b = 1;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i5) {
        if (i5 == 0) {
            return this.f1453a;
        }
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f1454b;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f1453a = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i5, float f5) {
        if (i5 == 0) {
            this.f1453a = f5;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && ((k) obj).f1453a == this.f1453a;
    }

    public final float f() {
        return this.f1453a;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public k c() {
        return new k(0.0f);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1453a);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.f1453a;
    }
}
