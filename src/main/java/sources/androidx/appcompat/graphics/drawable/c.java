package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    private static final float f395m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    private final Paint f396a;

    /* renamed from: b, reason: collision with root package name */
    private float f397b;

    /* renamed from: c, reason: collision with root package name */
    private float f398c;

    /* renamed from: d, reason: collision with root package name */
    private float f399d;

    /* renamed from: e, reason: collision with root package name */
    private float f400e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f401f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f402g;

    /* renamed from: h, reason: collision with root package name */
    private final int f403h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f404i;

    /* renamed from: j, reason: collision with root package name */
    private float f405j;

    /* renamed from: k, reason: collision with root package name */
    private float f406k;

    /* renamed from: l, reason: collision with root package name */
    private int f407l;

    public c(Context context) {
        Paint paint = new Paint();
        this.f396a = paint;
        this.f402g = new Path();
        this.f404i = false;
        this.f407l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        b(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        e(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f403h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f398c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f397b = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f399d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    public void b(float f5) {
        if (this.f396a.getStrokeWidth() != f5) {
            this.f396a.setStrokeWidth(f5);
            this.f406k = (float) ((f5 / 2.0f) * Math.cos(f395m));
            invalidateSelf();
        }
    }

    public void c(int i5) {
        if (i5 != this.f396a.getColor()) {
            this.f396a.setColor(i5);
            invalidateSelf();
        }
    }

    public void d(float f5) {
        if (f5 != this.f400e) {
            this.f400e = f5;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i5 = this.f407l;
        boolean z5 = false;
        if (i5 != 0 && (i5 == 1 || (i5 == 3 ? a1.a.f(this) == 0 : a1.a.f(this) == 1))) {
            z5 = true;
        }
        float f5 = this.f397b;
        float a5 = a(this.f398c, (float) Math.sqrt(f5 * f5 * 2.0f), this.f405j);
        float a6 = a(this.f398c, this.f399d, this.f405j);
        float round = Math.round(a(0.0f, this.f406k, this.f405j));
        float a7 = a(0.0f, f395m, this.f405j);
        float a8 = a(z5 ? 0.0f : -180.0f, z5 ? 180.0f : 0.0f, this.f405j);
        double d5 = a5;
        double d6 = a7;
        boolean z6 = z5;
        float round2 = Math.round(Math.cos(d6) * d5);
        float round3 = Math.round(d5 * Math.sin(d6));
        this.f402g.rewind();
        float a9 = a(this.f400e + this.f396a.getStrokeWidth(), -this.f406k, this.f405j);
        float f6 = (-a6) / 2.0f;
        this.f402g.moveTo(f6 + round, 0.0f);
        this.f402g.rLineTo(a6 - (round * 2.0f), 0.0f);
        this.f402g.moveTo(f6, a9);
        this.f402g.rLineTo(round2, round3);
        this.f402g.moveTo(f6, -a9);
        this.f402g.rLineTo(round2, -round3);
        this.f402g.close();
        canvas.save();
        float strokeWidth = this.f396a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f400e);
        if (this.f401f) {
            canvas.rotate(a8 * (this.f404i ^ z6 ? -1 : 1));
        } else if (z6) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f402g, this.f396a);
        canvas.restore();
    }

    public void e(boolean z5) {
        if (this.f401f != z5) {
            this.f401f = z5;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f403h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f403h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        if (i5 != this.f396a.getAlpha()) {
            this.f396a.setAlpha(i5);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f396a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f5) {
        if (this.f405j != f5) {
            this.f405j = f5;
            invalidateSelf();
        }
    }
}
