package y4;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final h f18662a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f18663b;

    /* renamed from: c, reason: collision with root package name */
    public Object f18664c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f18665d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator f18666e;

    /* renamed from: f, reason: collision with root package name */
    public final Interpolator f18667f;

    /* renamed from: g, reason: collision with root package name */
    public final float f18668g;

    /* renamed from: h, reason: collision with root package name */
    public Float f18669h;

    /* renamed from: i, reason: collision with root package name */
    private float f18670i;

    /* renamed from: j, reason: collision with root package name */
    private float f18671j;

    /* renamed from: k, reason: collision with root package name */
    private int f18672k;

    /* renamed from: l, reason: collision with root package name */
    private int f18673l;

    /* renamed from: m, reason: collision with root package name */
    private float f18674m;

    /* renamed from: n, reason: collision with root package name */
    private float f18675n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f18676o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f18677p;

    public a(h hVar, Object obj, Object obj2, Interpolator interpolator, float f5, Float f6) {
        this.f18670i = -3987645.8f;
        this.f18671j = -3987645.8f;
        this.f18672k = 784923401;
        this.f18673l = 784923401;
        this.f18674m = Float.MIN_VALUE;
        this.f18675n = Float.MIN_VALUE;
        this.f18676o = null;
        this.f18677p = null;
        this.f18662a = hVar;
        this.f18663b = obj;
        this.f18664c = obj2;
        this.f18665d = interpolator;
        this.f18666e = null;
        this.f18667f = null;
        this.f18668g = f5;
        this.f18669h = f6;
    }

    public a(h hVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f5, Float f6) {
        this.f18670i = -3987645.8f;
        this.f18671j = -3987645.8f;
        this.f18672k = 784923401;
        this.f18673l = 784923401;
        this.f18674m = Float.MIN_VALUE;
        this.f18675n = Float.MIN_VALUE;
        this.f18676o = null;
        this.f18677p = null;
        this.f18662a = hVar;
        this.f18663b = obj;
        this.f18664c = obj2;
        this.f18665d = null;
        this.f18666e = interpolator;
        this.f18667f = interpolator2;
        this.f18668g = f5;
        this.f18669h = f6;
    }

    protected a(h hVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f5, Float f6) {
        this.f18670i = -3987645.8f;
        this.f18671j = -3987645.8f;
        this.f18672k = 784923401;
        this.f18673l = 784923401;
        this.f18674m = Float.MIN_VALUE;
        this.f18675n = Float.MIN_VALUE;
        this.f18676o = null;
        this.f18677p = null;
        this.f18662a = hVar;
        this.f18663b = obj;
        this.f18664c = obj2;
        this.f18665d = interpolator;
        this.f18666e = interpolator2;
        this.f18667f = interpolator3;
        this.f18668g = f5;
        this.f18669h = f6;
    }

    public a(Object obj) {
        this.f18670i = -3987645.8f;
        this.f18671j = -3987645.8f;
        this.f18672k = 784923401;
        this.f18673l = 784923401;
        this.f18674m = Float.MIN_VALUE;
        this.f18675n = Float.MIN_VALUE;
        this.f18676o = null;
        this.f18677p = null;
        this.f18662a = null;
        this.f18663b = obj;
        this.f18664c = obj;
        this.f18665d = null;
        this.f18666e = null;
        this.f18667f = null;
        this.f18668g = Float.MIN_VALUE;
        this.f18669h = Float.valueOf(Float.MAX_VALUE);
    }

    private a(Object obj, Object obj2) {
        this.f18670i = -3987645.8f;
        this.f18671j = -3987645.8f;
        this.f18672k = 784923401;
        this.f18673l = 784923401;
        this.f18674m = Float.MIN_VALUE;
        this.f18675n = Float.MIN_VALUE;
        this.f18676o = null;
        this.f18677p = null;
        this.f18662a = null;
        this.f18663b = obj;
        this.f18664c = obj2;
        this.f18665d = null;
        this.f18666e = null;
        this.f18667f = null;
        this.f18668g = Float.MIN_VALUE;
        this.f18669h = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(float f5) {
        return f5 >= f() && f5 < c();
    }

    public a b(Object obj, Object obj2) {
        return new a(obj, obj2);
    }

    public float c() {
        if (this.f18662a == null) {
            return 1.0f;
        }
        if (this.f18675n == Float.MIN_VALUE) {
            if (this.f18669h == null) {
                this.f18675n = 1.0f;
            } else {
                this.f18675n = f() + ((this.f18669h.floatValue() - this.f18668g) / this.f18662a.e());
            }
        }
        return this.f18675n;
    }

    public float d() {
        if (this.f18671j == -3987645.8f) {
            this.f18671j = ((Float) this.f18664c).floatValue();
        }
        return this.f18671j;
    }

    public int e() {
        if (this.f18673l == 784923401) {
            this.f18673l = ((Integer) this.f18664c).intValue();
        }
        return this.f18673l;
    }

    public float f() {
        h hVar = this.f18662a;
        if (hVar == null) {
            return 0.0f;
        }
        if (this.f18674m == Float.MIN_VALUE) {
            this.f18674m = (this.f18668g - hVar.p()) / this.f18662a.e();
        }
        return this.f18674m;
    }

    public float g() {
        if (this.f18670i == -3987645.8f) {
            this.f18670i = ((Float) this.f18663b).floatValue();
        }
        return this.f18670i;
    }

    public int h() {
        if (this.f18672k == 784923401) {
            this.f18672k = ((Integer) this.f18663b).intValue();
        }
        return this.f18672k;
    }

    public boolean i() {
        return this.f18665d == null && this.f18666e == null && this.f18667f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f18663b + ", endValue=" + this.f18664c + ", startFrame=" + this.f18668g + ", endFrame=" + this.f18669h + ", interpolator=" + this.f18665d + '}';
    }
}
