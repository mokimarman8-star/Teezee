package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.R;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewCompat$h {

    class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        WindowInsetsCompat f7159a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7160b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OnApplyWindowInsetsListener f7161c;

        a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.f7160b = view;
            this.f7161c = onApplyWindowInsetsListener;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 < 30) {
                ViewCompat$h.a(windowInsets, this.f7160b);
                if (windowInsetsCompat.equals(this.f7159a)) {
                    return this.f7161c.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                }
            }
            this.f7159a = windowInsetsCompat;
            WindowInsetsCompat onApplyWindowInsets = this.f7161c.onApplyWindowInsets(view, windowInsetsCompat);
            if (i5 >= 30) {
                return onApplyWindowInsets.toWindowInsets();
            }
            ViewCompat.requestApplyInsets(view);
            return onApplyWindowInsets.toWindowInsets();
        }
    }

    static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    static boolean c(View view, float f5, float f6, boolean z5) {
        return view.dispatchNestedFling(f5, f6, z5);
    }

    static boolean d(View view, float f5, float f6) {
        return view.dispatchNestedPreFling(f5, f6);
    }

    static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
    }

    static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
    }

    static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    static float i(View view) {
        return view.getElevation();
    }

    static String j(View view) {
        return view.getTransitionName();
    }

    static float k(View view) {
        return view.getTranslationZ();
    }

    static float l(View view) {
        return view.getZ();
    }

    static boolean m(View view) {
        return view.hasNestedScrollingParent();
    }

    static boolean n(View view) {
        return view.isImportantForAccessibility();
    }

    static boolean o(View view) {
        return view.isNestedScrollingEnabled();
    }

    static void p(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void q(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    static void r(View view, float f5) {
        view.setElevation(f5);
    }

    static void s(View view, boolean z5) {
        view.setNestedScrollingEnabled(z5);
    }

    static void t(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        a aVar = onApplyWindowInsetsListener != null ? new a(view, onApplyWindowInsetsListener) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, aVar);
        }
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (aVar != null) {
            view.setOnApplyWindowInsetsListener(aVar);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }

    static void u(View view, String str) {
        view.setTransitionName(str);
    }

    static void v(View view, float f5) {
        view.setTranslationZ(f5);
    }

    static void w(View view, float f5) {
        view.setZ(f5);
    }

    static boolean x(View view, int i5) {
        return view.startNestedScroll(i5);
    }

    static void y(View view) {
        view.stopNestedScroll();
    }
}
