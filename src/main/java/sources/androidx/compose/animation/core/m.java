package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m extends o {

    /* renamed from: a, reason: collision with root package name */
    private float f1458a;

    /* renamed from: b, reason: collision with root package name */
    private float f1459b;

    /* renamed from: c, reason: collision with root package name */
    private float f1460c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1461d;

    public m(float f5, float f6, float f7) {
        super(null);
        this.f1458a = f5;
        this.f1459b = f6;
        this.f1460c = f7;
        this.f1461d = 3;
    }

    @Override // androidx.compose.animation.core.o
    public float a(int i5) {
        if (i5 == 0) {
            return this.f1458a;
        }
        if (i5 == 1) {
            return this.f1459b;
        }
        if (i5 != 2) {
            return 0.0f;
        }
        return this.f1460c;
    }

    @Override // androidx.compose.animation.core.o
    public int b() {
        return this.f1461d;
    }

    @Override // androidx.compose.animation.core.o
    public void d() {
        this.f1458a = 0.0f;
        this.f1459b = 0.0f;
        this.f1460c = 0.0f;
    }

    @Override // androidx.compose.animation.core.o
    public void e(int i5, float f5) {
        if (i5 == 0) {
            this.f1458a = f5;
        } else if (i5 == 1) {
            this.f1459b = f5;
        } else {
            if (i5 != 2) {
                return;
            }
            this.f1460c = f5;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.f1458a == this.f1458a && mVar.f1459b == this.f1459b && mVar.f1460c == this.f1460c) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public m c() {
        return new m(0.0f, 0.0f, 0.0f);
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f1458a) * 31) + Float.floatToIntBits(this.f1459b)) * 31) + Float.floatToIntBits(this.f1460c);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.f1458a + ", v2 = " + this.f1459b + ", v3 = " + this.f1460c;
    }
}
