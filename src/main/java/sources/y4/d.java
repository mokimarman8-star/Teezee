package y4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private float f18688a;

    /* renamed from: b, reason: collision with root package name */
    private float f18689b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f5, float f6) {
        this.f18688a = f5;
        this.f18689b = f6;
    }

    public boolean a(float f5, float f6) {
        return this.f18688a == f5 && this.f18689b == f6;
    }

    public float b() {
        return this.f18688a;
    }

    public float c() {
        return this.f18689b;
    }

    public void d(float f5, float f6) {
        this.f18688a = f5;
        this.f18689b = f6;
    }

    public String toString() {
        return b() + "x" + c();
    }
}
