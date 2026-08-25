package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    float f5805a;

    /* renamed from: b, reason: collision with root package name */
    float f5806b;

    /* renamed from: c, reason: collision with root package name */
    float f5807c;

    /* renamed from: d, reason: collision with root package name */
    float f5808d;

    /* renamed from: e, reason: collision with root package name */
    float f5809e;

    /* renamed from: f, reason: collision with root package name */
    float f5810f;

    public void a(float f5, float f6, int i5, int i6, float[] fArr) {
        float f7 = fArr[0];
        float f8 = fArr[1];
        float f9 = (f6 - 0.5f) * 2.0f;
        float f10 = f7 + this.f5807c;
        float f11 = f8 + this.f5808d;
        float f12 = f10 + (this.f5805a * (f5 - 0.5f) * 2.0f);
        float f13 = f11 + (this.f5806b * f9);
        float radians = (float) Math.toRadians(this.f5810f);
        float radians2 = (float) Math.toRadians(this.f5809e);
        double d5 = radians;
        double d6 = i6 * f9;
        float sin = f12 + (((float) ((((-i5) * r7) * Math.sin(d5)) - (Math.cos(d5) * d6))) * radians2);
        float cos = f13 + (radians2 * ((float) (((i5 * r7) * Math.cos(d5)) - (d6 * Math.sin(d5)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void b() {
        this.f5809e = 0.0f;
        this.f5808d = 0.0f;
        this.f5807c = 0.0f;
        this.f5806b = 0.0f;
        this.f5805a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f5) {
        if (keyCycleOscillator != null) {
            this.f5809e = keyCycleOscillator.b(f5);
        }
    }

    public void d(i iVar, float f5) {
        if (iVar != null) {
            this.f5809e = iVar.b(f5);
            this.f5810f = iVar.a(f5);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f5) {
        if (keyCycleOscillator != null) {
            this.f5805a = keyCycleOscillator.b(f5);
        }
        if (keyCycleOscillator2 != null) {
            this.f5806b = keyCycleOscillator2.b(f5);
        }
    }

    public void f(i iVar, i iVar2, float f5) {
        if (iVar != null) {
            this.f5805a = iVar.b(f5);
        }
        if (iVar2 != null) {
            this.f5806b = iVar2.b(f5);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f5) {
        if (keyCycleOscillator != null) {
            this.f5807c = keyCycleOscillator.b(f5);
        }
        if (keyCycleOscillator2 != null) {
            this.f5808d = keyCycleOscillator2.b(f5);
        }
    }

    public void h(i iVar, i iVar2, float f5) {
        if (iVar != null) {
            this.f5807c = iVar.b(f5);
        }
        if (iVar2 != null) {
            this.f5808d = iVar2.b(f5);
        }
    }
}
