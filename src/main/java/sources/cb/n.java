package cb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class n {
    public static final d m = new l(0.5f);
    e a;
    e b;
    e c;
    e d;
    d e;
    d f;
    d g;
    d h;
    g i;
    g j;
    g k;
    g l;

    public static final class b {
        private e a;
        private e b;
        private e c;
        private e d;
        private d e;
        private d f;
        private d g;
        private d h;
        private g i;
        private g j;
        private g k;
        private g l;

        public b() {
            this.a = j.b();
            this.b = j.b();
            this.c = j.b();
            this.d = j.b();
            this.e = new cb.a(0.0f);
            this.f = new cb.a(0.0f);
            this.g = new cb.a(0.0f);
            this.h = new cb.a(0.0f);
            this.i = j.c();
            this.j = j.c();
            this.k = j.c();
            this.l = j.c();
        }

        public b(n nVar) {
            this.a = j.b();
            this.b = j.b();
            this.c = j.b();
            this.d = j.b();
            this.e = new cb.a(0.0f);
            this.f = new cb.a(0.0f);
            this.g = new cb.a(0.0f);
            this.h = new cb.a(0.0f);
            this.i = j.c();
            this.j = j.c();
            this.k = j.c();
            this.l = j.c();
            this.a = nVar.a;
            this.b = nVar.b;
            this.c = nVar.c;
            this.d = nVar.d;
            this.e = nVar.e;
            this.f = nVar.f;
            this.g = nVar.g;
            this.h = nVar.h;
            this.i = nVar.i;
            this.j = nVar.j;
            this.k = nVar.k;
            this.l = nVar.l;
        }

        private static float n(e eVar) {
            if (eVar instanceof m) {
                return ((m) eVar).a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).a;
            }
            return -1.0f;
        }

        public b A(e eVar) {
            this.c = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                B(n);
            }
            return this;
        }

        public b B(float f) {
            this.g = new cb.a(f);
            return this;
        }

        public b C(d dVar) {
            this.g = dVar;
            return this;
        }

        public b D(g gVar) {
            this.i = gVar;
            return this;
        }

        public b E(int i, float f) {
            return G(j.a(i)).H(f);
        }

        public b F(int i, d dVar) {
            return G(j.a(i)).I(dVar);
        }

        public b G(e eVar) {
            this.a = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                H(n);
            }
            return this;
        }

        public b H(float f) {
            this.e = new cb.a(f);
            return this;
        }

        public b I(d dVar) {
            this.e = dVar;
            return this;
        }

        public b J(int i, float f) {
            return L(j.a(i)).M(f);
        }

        public b K(int i, d dVar) {
            return L(j.a(i)).N(dVar);
        }

        public b L(e eVar) {
            this.b = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                M(n);
            }
            return this;
        }

        public b M(float f) {
            this.f = new cb.a(f);
            return this;
        }

        public b N(d dVar) {
            this.f = dVar;
            return this;
        }

        public n m() {
            return new n(this);
        }

        public b o(float f) {
            return H(f).M(f).B(f).w(f);
        }

        public b p(d dVar) {
            return I(dVar).N(dVar).C(dVar).x(dVar);
        }

        public b q(int i, float f) {
            return r(j.a(i)).o(f);
        }

        public b r(e eVar) {
            return G(eVar).L(eVar).A(eVar).v(eVar);
        }

        public b s(g gVar) {
            this.k = gVar;
            return this;
        }

        public b t(int i, float f) {
            return v(j.a(i)).w(f);
        }

        public b u(int i, d dVar) {
            return v(j.a(i)).x(dVar);
        }

        public b v(e eVar) {
            this.d = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                w(n);
            }
            return this;
        }

        public b w(float f) {
            this.h = new cb.a(f);
            return this;
        }

        public b x(d dVar) {
            this.h = dVar;
            return this;
        }

        public b y(int i, float f) {
            return A(j.a(i)).B(f);
        }

        public b z(int i, d dVar) {
            return A(j.a(i)).C(dVar);
        }
    }

    public interface c {
        d a(d dVar);
    }

    public n() {
        this.a = j.b();
        this.b = j.b();
        this.c = j.b();
        this.d = j.b();
        this.e = new cb.a(0.0f);
        this.f = new cb.a(0.0f);
        this.g = new cb.a(0.0f);
        this.h = new cb.a(0.0f);
        this.i = j.c();
        this.j = j.c();
        this.k = j.c();
        this.l = j.c();
    }

    private n(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new cb.a(i3));
    }

    private static b d(Context context, int i, int i2, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i2);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            d m2 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d m3 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, m2);
            d m4 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, m2);
            d m5 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, m2);
            return new b().F(i4, m3).K(i5, m4).z(i6, m5).u(i7, m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, m2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new cb.a(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    private static d m(TypedArray typedArray, int i, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return dVar;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new cb.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new l(peekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    public g h() {
        return this.k;
    }

    public e i() {
        return this.d;
    }

    public d j() {
        return this.h;
    }

    public e k() {
        return this.c;
    }

    public d l() {
        return this.g;
    }

    public g n() {
        return this.l;
    }

    public g o() {
        return this.j;
    }

    public g p() {
        return this.i;
    }

    public e q() {
        return this.a;
    }

    public d r() {
        return this.e;
    }

    public e s() {
        return this.b;
    }

    public d t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(g.class) && this.j.getClass().equals(g.class) && this.i.getClass().equals(g.class) && this.k.getClass().equals(g.class);
        float a2 = this.e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof m) && (this.a instanceof m) && (this.c instanceof m) && (this.d instanceof m));
    }

    public b v() {
        return new b(this);
    }

    public n w(float f) {
        return v().o(f).m();
    }

    public n x(d dVar) {
        return v().p(dVar).m();
    }

    public n y(c cVar) {
        return v().I(cVar.a(r())).N(cVar.a(t())).x(cVar.a(j())).C(cVar.a(l())).m();
    }
}
