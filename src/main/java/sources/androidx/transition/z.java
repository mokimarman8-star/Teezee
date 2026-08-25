package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private static final c0 f13592a;

    /* renamed from: b, reason: collision with root package name */
    static final Property f13593b;

    /* renamed from: c, reason: collision with root package name */
    static final Property f13594c;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(z.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            z.e(view, f5.floatValue());
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f13592a = new k0();
        } else {
            f13592a = new j0();
        }
        f13593b = new a(Float.class, "translationAlpha");
        f13594c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f13592a.a(view);
    }

    static float b(View view) {
        return f13592a.b(view);
    }

    static void c(View view) {
        f13592a.c(view);
    }

    static void d(View view, int i5, int i6, int i7, int i8) {
        f13592a.d(view, i5, i6, i7, i8);
    }

    static void e(View view, float f5) {
        f13592a.e(view, f5);
    }

    static void f(View view, int i5) {
        f13592a.f(view, i5);
    }

    static void g(View view, Matrix matrix) {
        f13592a.g(view, matrix);
    }

    static void h(View view, Matrix matrix) {
        f13592a.h(view, matrix);
    }
}
