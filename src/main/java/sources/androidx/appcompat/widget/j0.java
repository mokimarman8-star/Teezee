package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1051a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f1052b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f1053c;

    private j0(Context context, TypedArray typedArray) {
        this.f1051a = context;
        this.f1052b = typedArray;
    }

    public static j0 t(Context context, int i5, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(i5, iArr));
    }

    public static j0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static j0 v(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new j0(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public boolean a(int i5, boolean z5) {
        return this.f1052b.getBoolean(i5, z5);
    }

    public int b(int i5, int i6) {
        return this.f1052b.getColor(i5, i6);
    }

    public ColorStateList c(int i5) {
        int resourceId;
        ColorStateList a5;
        return (!this.f1052b.hasValue(i5) || (resourceId = this.f1052b.getResourceId(i5, 0)) == 0 || (a5 = g.a.a(this.f1051a, resourceId)) == null) ? this.f1052b.getColorStateList(i5) : a5;
    }

    public float d(int i5, float f5) {
        return this.f1052b.getDimension(i5, f5);
    }

    public int e(int i5, int i6) {
        return this.f1052b.getDimensionPixelOffset(i5, i6);
    }

    public int f(int i5, int i6) {
        return this.f1052b.getDimensionPixelSize(i5, i6);
    }

    public Drawable g(int i5) {
        int resourceId;
        return (!this.f1052b.hasValue(i5) || (resourceId = this.f1052b.getResourceId(i5, 0)) == 0) ? this.f1052b.getDrawable(i5) : g.a.b(this.f1051a, resourceId);
    }

    public Drawable h(int i5) {
        int resourceId;
        if (!this.f1052b.hasValue(i5) || (resourceId = this.f1052b.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return f.b().d(this.f1051a, resourceId, true);
    }

    public float i(int i5, float f5) {
        return this.f1052b.getFloat(i5, f5);
    }

    public Typeface j(int i5, int i6, h.e eVar) {
        int resourceId = this.f1052b.getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1053c == null) {
            this.f1053c = new TypedValue();
        }
        return y0.h.h(this.f1051a, resourceId, this.f1053c, i6, eVar);
    }

    public int k(int i5, int i6) {
        return this.f1052b.getInt(i5, i6);
    }

    public int l(int i5, int i6) {
        return this.f1052b.getInteger(i5, i6);
    }

    public int m(int i5, int i6) {
        return this.f1052b.getLayoutDimension(i5, i6);
    }

    public int n(int i5, int i6) {
        return this.f1052b.getResourceId(i5, i6);
    }

    public String o(int i5) {
        return this.f1052b.getString(i5);
    }

    public CharSequence p(int i5) {
        return this.f1052b.getText(i5);
    }

    public CharSequence[] q(int i5) {
        return this.f1052b.getTextArray(i5);
    }

    public TypedArray r() {
        return this.f1052b;
    }

    public boolean s(int i5) {
        return this.f1052b.hasValue(i5);
    }

    public TypedValue w(int i5) {
        return this.f1052b.peekValue(i5);
    }

    public void x() {
        this.f1052b.recycle();
    }
}
