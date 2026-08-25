package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.a;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b implements a.b {

    /* renamed from: m, reason: collision with root package name */
    public static final p f7820m = new f("translationX");

    /* renamed from: n, reason: collision with root package name */
    public static final p f7821n = new g("translationY");

    /* renamed from: o, reason: collision with root package name */
    public static final p f7822o = new h("translationZ");

    /* renamed from: p, reason: collision with root package name */
    public static final p f7823p = new i("scaleX");

    /* renamed from: q, reason: collision with root package name */
    public static final p f7824q = new j("scaleY");

    /* renamed from: r, reason: collision with root package name */
    public static final p f7825r = new k("rotation");

    /* renamed from: s, reason: collision with root package name */
    public static final p f7826s = new l("rotationX");

    /* renamed from: t, reason: collision with root package name */
    public static final p f7827t = new m("rotationY");

    /* renamed from: u, reason: collision with root package name */
    public static final p f7828u = new n("x");

    /* renamed from: v, reason: collision with root package name */
    public static final p f7829v = new a("y");

    /* renamed from: w, reason: collision with root package name */
    public static final p f7830w = new C0060b("z");

    /* renamed from: x, reason: collision with root package name */
    public static final p f7831x = new c("alpha");

    /* renamed from: y, reason: collision with root package name */
    public static final p f7832y = new d("scrollX");

    /* renamed from: z, reason: collision with root package name */
    public static final p f7833z = new e("scrollY");

    /* renamed from: d, reason: collision with root package name */
    final Object f7837d;

    /* renamed from: e, reason: collision with root package name */
    final androidx.dynamicanimation.animation.c f7838e;

    /* renamed from: j, reason: collision with root package name */
    private float f7843j;

    /* renamed from: a, reason: collision with root package name */
    float f7834a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    float f7835b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    boolean f7836c = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f7839f = false;

    /* renamed from: g, reason: collision with root package name */
    float f7840g = Float.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    float f7841h = -Float.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private long f7842i = 0;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f7844k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList f7845l = new ArrayList();

    static class a extends p {
        a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setY(f5);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    static class C0060b extends p {
        C0060b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            ViewCompat.setZ(view, f5);
        }
    }

    static class c extends p {
        c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setAlpha(f5);
        }
    }

    static class d extends p {
        d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScrollX((int) f5);
        }
    }

    static class e extends p {
        e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScrollY((int) f5);
        }
    }

    static class f extends p {
        f(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setTranslationX(f5);
        }
    }

    static class g extends p {
        g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setTranslationY(f5);
        }
    }

    static class h extends p {
        h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            ViewCompat.setTranslationZ(view, f5);
        }
    }

    static class i extends p {
        i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScaleX(f5);
        }
    }

    static class j extends p {
        j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScaleY(f5);
        }
    }

    static class k extends p {
        k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotation(f5);
        }
    }

    static class l extends p {
        l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotationX(f5);
        }
    }

    static class m extends p {
        m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotationY(f5);
        }
    }

    static class n extends p {
        n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setX(f5);
        }
    }

    static class o {

        /* renamed from: a, reason: collision with root package name */
        float f7846a;

        /* renamed from: b, reason: collision with root package name */
        float f7847b;

        o() {
        }
    }

    public static abstract class p extends androidx.dynamicanimation.animation.c {
        private p(String str) {
            super(str);
        }

        /* synthetic */ p(String str, f fVar) {
            this(str);
        }
    }

    b(Object obj, androidx.dynamicanimation.animation.c cVar) {
        this.f7837d = obj;
        this.f7838e = cVar;
        if (cVar == f7825r || cVar == f7826s || cVar == f7827t) {
            this.f7843j = 0.1f;
            return;
        }
        if (cVar == f7831x) {
            this.f7843j = 0.00390625f;
        } else if (cVar == f7823p || cVar == f7824q) {
            this.f7843j = 0.00390625f;
        } else {
            this.f7843j = 1.0f;
        }
    }

    private void b(boolean z5) {
        this.f7839f = false;
        androidx.dynamicanimation.animation.a.d().g(this);
        this.f7842i = 0L;
        this.f7836c = false;
        for (int i5 = 0; i5 < this.f7844k.size(); i5++) {
            if (this.f7844k.get(i5) != null) {
                android.support.v4.media.session.c.a(this.f7844k.get(i5));
                throw null;
            }
        }
        f(this.f7844k);
    }

    private float c() {
        return this.f7838e.a(this.f7837d);
    }

    private static void f(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (this.f7839f) {
            return;
        }
        this.f7839f = true;
        if (!this.f7836c) {
            this.f7835b = c();
        }
        float f5 = this.f7835b;
        if (f5 > this.f7840g || f5 < this.f7841h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        androidx.dynamicanimation.animation.a.d().a(this, 0L);
    }

    @Override // androidx.dynamicanimation.animation.a.b
    public boolean a(long j5) {
        long j6 = this.f7842i;
        if (j6 == 0) {
            this.f7842i = j5;
            g(this.f7835b);
            return false;
        }
        this.f7842i = j5;
        boolean k5 = k(j5 - j6);
        float min = Math.min(this.f7835b, this.f7840g);
        this.f7835b = min;
        float max = Math.max(min, this.f7841h);
        this.f7835b = max;
        g(max);
        if (k5) {
            b(false);
        }
        return k5;
    }

    float d() {
        return this.f7843j * 0.75f;
    }

    public boolean e() {
        return this.f7839f;
    }

    void g(float f5) {
        this.f7838e.b(this.f7837d, f5);
        for (int i5 = 0; i5 < this.f7845l.size(); i5++) {
            if (this.f7845l.get(i5) != null) {
                android.support.v4.media.session.c.a(this.f7845l.get(i5));
                throw null;
            }
        }
        f(this.f7845l);
    }

    public b h(float f5) {
        this.f7835b = f5;
        this.f7836c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f7839f) {
            return;
        }
        j();
    }

    abstract boolean k(long j5);
}
