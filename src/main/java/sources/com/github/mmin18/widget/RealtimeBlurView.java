package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.mmin18.realtimeblurview.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class RealtimeBlurView extends View {
    private static int p;
    private static int q;
    private static StopException r = new StopException(null);
    private float a;
    private int b;
    private float c;
    private final c d;
    private boolean e;
    private Bitmap f;
    private Bitmap g;
    private Canvas h;
    private boolean i;
    private Paint j;
    private final Rect k;
    private final Rect l;
    private View m;
    private boolean n;
    private final ViewTreeObserver.OnPreDrawListener o;

    private static class StopException extends RuntimeException {
        private StopException() {
        }

        /* synthetic */ StopException(a aVar) {
            this();
        }
    }

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int[] iArr = new int[2];
            Bitmap bitmap = RealtimeBlurView.this.g;
            View view = RealtimeBlurView.this.m;
            if (view != null && RealtimeBlurView.this.isShown() && RealtimeBlurView.this.l()) {
                boolean z = RealtimeBlurView.this.g != bitmap;
                view.getLocationOnScreen(iArr);
                int i = -iArr[0];
                int i2 = -iArr[1];
                RealtimeBlurView.this.getLocationOnScreen(iArr);
                int i3 = i + iArr[0];
                int i4 = i2 + iArr[1];
                RealtimeBlurView.this.f.eraseColor(RealtimeBlurView.this.b & 16777215);
                int save = RealtimeBlurView.this.h.save();
                RealtimeBlurView.this.i = true;
                RealtimeBlurView.g();
                try {
                    RealtimeBlurView.this.h.scale((RealtimeBlurView.this.f.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.f.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                    RealtimeBlurView.this.h.translate(-i3, -i4);
                    if (view.getBackground() != null) {
                        view.getBackground().draw(RealtimeBlurView.this.h);
                    }
                    view.draw(RealtimeBlurView.this.h);
                } catch (StopException unused) {
                } catch (Throwable th) {
                    RealtimeBlurView.this.i = false;
                    RealtimeBlurView.h();
                    RealtimeBlurView.this.h.restoreToCount(save);
                    throw th;
                }
                RealtimeBlurView.this.i = false;
                RealtimeBlurView.h();
                RealtimeBlurView.this.h.restoreToCount(save);
                RealtimeBlurView realtimeBlurView = RealtimeBlurView.this;
                realtimeBlurView.j(realtimeBlurView.f, RealtimeBlurView.this.g);
                if (z || RealtimeBlurView.this.n) {
                    RealtimeBlurView.this.invalidate();
                }
            }
            return true;
        }
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new Rect();
        this.l = new Rect();
        this.o = new a();
        this.d = getBlurImpl();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RealtimeBlurView);
        this.c = obtainStyledAttributes.getDimension(R$styleable.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.a = obtainStyledAttributes.getFloat(R$styleable.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.b = obtainStyledAttributes.getColor(R$styleable.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        obtainStyledAttributes.recycle();
        this.j = new Paint();
    }

    static /* synthetic */ int g() {
        int i = p;
        p = i + 1;
        return i;
    }

    static /* synthetic */ int h() {
        int i = p;
        p = i - 1;
        return i;
    }

    private void n() {
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.g = null;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.i) {
            throw r;
        }
        if (p > 0) {
            return;
        }
        super.draw(canvas);
    }

    protected View getActivityDecorView() {
        Context context = getContext();
        for (int i = 0; i < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    protected c getBlurImpl() {
        if (q == 0) {
            try {
                com.github.mmin18.widget.a aVar = new com.github.mmin18.widget.a();
                Bitmap createBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                aVar.b(getContext(), createBitmap, 4.0f);
                aVar.release();
                createBitmap.recycle();
                q = 3;
            } catch (Throwable unused) {
            }
        }
        if (q == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                b bVar = new b();
                Bitmap createBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                bVar.b(getContext(), createBitmap2, 4.0f);
                bVar.release();
                createBitmap2.recycle();
                q = 1;
            } catch (Throwable unused2) {
            }
        }
        if (q == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                e eVar = new e();
                Bitmap createBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                eVar.b(getContext(), createBitmap3, 4.0f);
                eVar.release();
                createBitmap3.recycle();
                q = 2;
            } catch (Throwable unused3) {
            }
        }
        if (q == 0) {
            q = -1;
        }
        int i = q;
        return i != 1 ? i != 2 ? i != 3 ? new d() : new com.github.mmin18.widget.a() : new e() : new b();
    }

    protected void j(Bitmap bitmap, Bitmap bitmap2) {
        this.d.a(bitmap, bitmap2);
    }

    protected void k(Canvas canvas, Bitmap bitmap, int i) {
        if (bitmap != null) {
            this.k.right = bitmap.getWidth();
            this.k.bottom = bitmap.getHeight();
            this.l.right = getWidth();
            this.l.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.k, this.l, (Paint) null);
        }
        this.j.setColor(i);
        canvas.drawRect(this.l, this.j);
    }

    protected boolean l() {
        Bitmap bitmap;
        float f = this.c;
        if (f == 0.0f) {
            m();
            return false;
        }
        float f2 = this.a;
        float f3 = f / f2;
        if (f3 > 25.0f) {
            f2 = (f2 * f3) / 25.0f;
            f3 = 25.0f;
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(1, (int) (width / f2));
        int max2 = Math.max(1, (int) (height / f2));
        boolean z = this.e;
        if (this.h == null || (bitmap = this.g) == null || bitmap.getWidth() != max || this.g.getHeight() != max2) {
            n();
            try {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, config);
                this.f = createBitmap;
                if (createBitmap == null) {
                    m();
                    return false;
                }
                this.h = new Canvas(this.f);
                Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, config);
                this.g = createBitmap2;
                if (createBitmap2 == null) {
                    m();
                    return false;
                }
                z = true;
            } catch (OutOfMemoryError unused) {
                m();
                return false;
            } catch (Throwable unused2) {
                m();
                return false;
            }
        }
        if (z) {
            if (!this.d.b(getContext(), this.f, f3)) {
                return false;
            }
            this.e = false;
        }
        return true;
    }

    protected void m() {
        n();
        this.d.release();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.m = activityDecorView;
        if (activityDecorView == null) {
            this.n = false;
            return;
        }
        activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.o);
        boolean z = this.m.getRootView() != getRootView();
        this.n = z;
        if (z) {
            this.m.postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        View view = this.m;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.o);
        }
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas, this.g, this.b);
    }

    public void setBlurRadius(float f) {
        if (this.c != f) {
            this.c = f;
            this.e = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.a != f) {
            this.a = f;
            this.e = true;
            n();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.b != i) {
            this.b = i;
            invalidate();
        }
    }
}
