package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f1023a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f1024b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f1025c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f1026d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f1027e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f1028f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f1029g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f1030h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f1031i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f1032j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i5) {
        ColorStateList e5 = e(context, i5);
        if (e5 != null && e5.isStateful()) {
            return e5.getColorForState(f1024b, e5.getDefaultColor());
        }
        TypedValue f5 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f5, true);
        return d(context, i5, f5.getFloat());
    }

    public static int c(Context context, int i5) {
        int[] iArr = f1032j;
        iArr[0] = i5;
        j0 u5 = j0.u(context, null, iArr);
        try {
            return u5.b(0, 0);
        } finally {
            u5.x();
        }
    }

    static int d(Context context, int i5, float f5) {
        return z0.b.p(c(context, i5), Math.round(Color.alpha(r0) * f5));
    }

    public static ColorStateList e(Context context, int i5) {
        int[] iArr = f1032j;
        iArr[0] = i5;
        j0 u5 = j0.u(context, null, iArr);
        try {
            return u5.c(0);
        } finally {
            u5.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f1023a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
