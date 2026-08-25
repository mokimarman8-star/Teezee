package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class AppCompatTextHelper {
    private final TextView a;
    private h0 b;
    private h0 c;
    private h0 d;
    private h0 e;
    private h0 f;
    private h0 g;
    private h0 h;
    private final p i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    AppCompatTextHelper(TextView textView) {
        this.a = textView;
        this.i = new p(textView);
    }

    private void B(int i, float f) {
        this.i.t(i, f);
    }

    private void C(Context context, j0 j0Var) {
        String o;
        this.j = j0Var.k(R$styleable.TextAppearance_android_textStyle, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int k = j0Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.k = k;
            if (k != -1) {
                this.j &= 2;
            }
        }
        if (!j0Var.s(R$styleable.TextAppearance_android_fontFamily) && !j0Var.s(R$styleable.TextAppearance_fontFamily)) {
            if (j0Var.s(R$styleable.TextAppearance_android_typeface)) {
                this.m = false;
                int k2 = j0Var.k(R$styleable.TextAppearance_android_typeface, 1);
                if (k2 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (k2 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (k2 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i2 = j0Var.s(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        int i3 = this.k;
        int i4 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface j = j0Var.j(i2, this.j, new a(this, i3, i4, new WeakReference(this.a)));
                if (j != null) {
                    if (i < 28 || this.k == -1) {
                        this.l = j;
                    } else {
                        this.l = e.a(Typeface.create(j, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (o = j0Var.o(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(o, this.j);
        } else {
            this.l = e.a(Typeface.create(o, 0), this.k, (this.j & 2) != 0);
        }
    }

    private void a(Drawable drawable, h0 h0Var) {
        if (drawable == null || h0Var == null) {
            return;
        }
        f.i(drawable, h0Var, this.a.getDrawableState());
    }

    private static h0 d(Context context, f fVar, int i) {
        ColorStateList f = fVar.f(context, i);
        if (f == null) {
            return null;
        }
        h0 h0Var = new h0();
        h0Var.d = true;
        h0Var.a = f;
        return h0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView2 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        h0 h0Var = this.h;
        this.b = h0Var;
        this.c = h0Var;
        this.d = h0Var;
        this.e = h0Var;
        this.f = h0Var;
        this.g = h0Var;
    }

    void A(int i, float f) {
        if (u0.c || l()) {
            return;
        }
        B(i, f);
    }

    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    void c() {
        this.i.a();
    }

    int e() {
        return this.i.f();
    }

    int f() {
        return this.i.g();
    }

    int g() {
        return this.i.h();
    }

    int[] h() {
        return this.i.i();
    }

    int i() {
        return this.i.j();
    }

    ColorStateList j() {
        h0 h0Var = this.h;
        if (h0Var != null) {
            return h0Var.a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        h0 h0Var = this.h;
        if (h0Var != null) {
            return h0Var.b;
        }
        return null;
    }

    boolean l() {
        return this.i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m(android.util.AttributeSet r17, int r18) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new 2(this, textView, typeface, this.j));
                } else {
                    textView.setTypeface(typeface, this.j);
                }
            }
        }
    }

    void o(boolean z, int i, int i2, int i3, int i4) {
        if (u0.c) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i) {
        String o;
        j0 t = j0.t(context, i, R$styleable.TextAppearance);
        if (t.s(R$styleable.TextAppearance_textAllCaps)) {
            s(t.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (t.s(R$styleable.TextAppearance_android_textSize) && t.f(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, t);
        if (i2 >= 26 && t.s(R$styleable.TextAppearance_fontVariationSettings) && (o = t.o(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            d.d(this.a, o);
        }
        t.x();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    void s(boolean z) {
        this.a.setAllCaps(z);
    }

    void t(int i, int i2, int i3, int i4) {
        this.i.p(i, i2, i3, i4);
    }

    void u(int[] iArr, int i) {
        this.i.q(iArr, i);
    }

    void v(int i) {
        this.i.r(i);
    }

    void w(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new h0();
        }
        h0 h0Var = this.h;
        h0Var.a = colorStateList;
        h0Var.d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new h0();
        }
        h0 h0Var = this.h;
        h0Var.b = mode;
        h0Var.c = mode != null;
        z();
    }
}
