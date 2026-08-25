package r4;

import android.graphics.PointF;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f17607a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f17608b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f17609c;

    public a() {
        this.f17607a = new PointF();
        this.f17608b = new PointF();
        this.f17609c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f17607a = pointF;
        this.f17608b = pointF2;
        this.f17609c = pointF3;
    }

    public PointF a() {
        return this.f17607a;
    }

    public PointF b() {
        return this.f17608b;
    }

    public PointF c() {
        return this.f17609c;
    }

    public void d(float f5, float f6) {
        this.f17607a.set(f5, f6);
    }

    public void e(float f5, float f6) {
        this.f17608b.set(f5, f6);
    }

    public void f(float f5, float f6) {
        this.f17609c.set(f5, f6);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f17609c.x), Float.valueOf(this.f17609c.y), Float.valueOf(this.f17607a.x), Float.valueOf(this.f17607a.y), Float.valueOf(this.f17608b.x), Float.valueOf(this.f17608b.y));
    }
}
