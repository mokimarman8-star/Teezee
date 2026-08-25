package za;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import com.google.android.material.R;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final float l;
    private ColorStateList m;
    private float n;
    private final int o;
    private boolean p = false;
    private Typeface q;

    class a extends h.e {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        public void h(int i) {
            d.this.p = true;
            this.a.a(i);
        }

        public void i(Typeface typeface) {
            d dVar = d.this;
            dVar.q = Typeface.create(typeface, dVar.e);
            d.this.p = true;
            this.a.b(d.this.q, false);
        }
    }

    class b extends f {
        final /* synthetic */ Context a;
        final /* synthetic */ TextPaint b;
        final /* synthetic */ f c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.a = context;
            this.b = textPaint;
            this.c = fVar;
        }

        @Override // za.f
        public void a(int i) {
            this.c.a(i);
        }

        @Override // za.f
        public void b(Typeface typeface, boolean z) {
            d.this.p(this.a, this.b, typeface);
            this.c.b(typeface, z);
        }
    }

    public d(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        l(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        k(c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.a = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.e = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int g = c.g(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.o = obtainStyledAttributes.getResourceId(g, 0);
        this.d = obtainStyledAttributes.getString(g);
        this.g = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.c = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.h = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.i = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.j = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R.styleable.MaterialTextAppearance);
        this.k = obtainStyledAttributes2.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.l = obtainStyledAttributes2.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.q == null && (str = this.d) != null) {
            this.q = Typeface.create(str, this.e);
        }
        if (this.q == null) {
            int i = this.f;
            if (i == 1) {
                this.q = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.q = Typeface.SERIF;
            } else if (i != 3) {
                this.q = Typeface.DEFAULT;
            } else {
                this.q = Typeface.MONOSPACE;
            }
            this.q = Typeface.create(this.q, this.e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i = this.o;
        return (i != 0 ? y0.h.c(context, i) : null) != null;
    }

    public Typeface e() {
        d();
        return this.q;
    }

    public Typeface f(Context context) {
        if (this.p) {
            return this.q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface g = y0.h.g(context, this.o);
                this.q = g;
                if (g != null) {
                    this.q = Typeface.create(g, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.d);
            }
        }
        d();
        this.p = true;
        return this.q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.o;
        if (i == 0) {
            this.p = true;
        }
        if (this.p) {
            fVar.b(this.q, true);
            return;
        }
        try {
            y0.h.i(context, i, new a(fVar), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            fVar.a(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.d);
            this.p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.m;
    }

    public float j() {
        return this.n;
    }

    public void k(ColorStateList colorStateList) {
        this.m = colorStateList;
    }

    public void l(float f) {
        this.n = f;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.j;
        float f2 = this.h;
        float f3 = this.i;
        ColorStateList colorStateList2 = this.c;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface a2 = h.a(context, typeface);
        if (a2 != null) {
            typeface = a2;
        }
        textPaint.setTypeface(typeface);
        int i = this.e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.n);
        if (this.k) {
            textPaint.setLetterSpacing(this.l);
        }
    }
}
