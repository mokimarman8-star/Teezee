package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f1224a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f1226c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f1227d;

    /* renamed from: e, reason: collision with root package name */
    private float f1228e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f1231h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f1232i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f1233j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1229f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1230g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f1234k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f1225b = new Paint(5);

    d(ColorStateList colorStateList, float f5) {
        this.f1224a = f5;
        e(colorStateList);
        this.f1226c = new RectF();
        this.f1227d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1231h = colorStateList;
        this.f1225b.setColor(colorStateList.getColorForState(getState(), this.f1231h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1226c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1227d.set(rect);
        if (this.f1229f) {
            this.f1227d.inset((int) Math.ceil(e.a(this.f1228e, this.f1224a, this.f1230g)), (int) Math.ceil(e.b(this.f1228e, this.f1224a, this.f1230g)));
            this.f1226c.set(this.f1227d);
        }
    }

    public ColorStateList b() {
        return this.f1231h;
    }

    float c() {
        return this.f1228e;
    }

    public float d() {
        return this.f1224a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z5;
        Paint paint = this.f1225b;
        if (this.f1232i == null || paint.getColorFilter() != null) {
            z5 = false;
        } else {
            paint.setColorFilter(this.f1232i);
            z5 = true;
        }
        RectF rectF = this.f1226c;
        float f5 = this.f1224a;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (z5) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f5, boolean z5, boolean z6) {
        if (f5 == this.f1228e && this.f1229f == z5 && this.f1230g == z6) {
            return;
        }
        this.f1228e = f5;
        this.f1229f = z5;
        this.f1230g = z6;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1227d, this.f1224a);
    }

    void h(float f5) {
        if (f5 == this.f1224a) {
            return;
        }
        this.f1224a = f5;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1233j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1231h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1231h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z5 = colorForState != this.f1225b.getColor();
        if (z5) {
            this.f1225b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1233j;
        if (colorStateList2 == null || (mode = this.f1234k) == null) {
            return z5;
        }
        this.f1232i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f1225b.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1225b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1233j = colorStateList;
        this.f1232i = a(colorStateList, this.f1234k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1234k = mode;
        this.f1232i = a(this.f1233j, mode);
        invalidateSelf();
    }
}
