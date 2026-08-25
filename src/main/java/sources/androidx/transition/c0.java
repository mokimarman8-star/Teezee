package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f13487a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Field f13488b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f13489c;

    static class a {
        static float a(View view) {
            float transitionAlpha;
            transitionAlpha = view.getTransitionAlpha();
            return transitionAlpha;
        }

        static void b(View view, float f5) {
            view.setTransitionAlpha(f5);
        }
    }

    c0() {
    }

    public void a(View view) {
    }

    public float b(View view) {
        if (f13487a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f13487a = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }

    public abstract void d(View view, int i5, int i6, int i7, int i8);

    public void e(View view, float f5) {
        if (f13487a) {
            try {
                a.b(view, f5);
                return;
            } catch (NoSuchMethodError unused) {
                f13487a = false;
            }
        }
        view.setAlpha(f5);
    }

    public void f(View view, int i5) {
        if (!f13489c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f13488b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f13489c = true;
        }
        Field field = f13488b;
        if (field != null) {
            try {
                f13488b.setInt(view, i5 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
