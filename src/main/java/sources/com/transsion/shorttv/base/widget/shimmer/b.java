package com.transsion.shorttv.base.widget.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends Drawable {
    private final ValueAnimator.AnimatorUpdateListener a = new a();
    private final Paint b;
    private final Rect c;
    private final Matrix d;
    private ValueAnimator e;
    private com.transsion.shorttv.base.widget.shimmer.a f;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    }

    public b() {
        Paint paint = new Paint();
        this.b = paint;
        this.c = new Rect();
        this.d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float c(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    private void i() {
        com.transsion.shorttv.base.widget.shimmer.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (aVar = this.f) == null) {
            return;
        }
        int d = aVar.d(width);
        int a2 = this.f.a(height);
        com.transsion.shorttv.base.widget.shimmer.a aVar2 = this.f;
        boolean z = true;
        if (aVar2.g != 1) {
            int i = aVar2.d;
            if (i != 1 && i != 3) {
                z = false;
            }
            if (z) {
                d = 0;
            }
            if (!z) {
                a2 = 0;
            }
            float f = a2;
            com.transsion.shorttv.base.widget.shimmer.a aVar3 = this.f;
            radialGradient = new LinearGradient(0.0f, 0.0f, d, f, aVar3.b, aVar3.a, Shader.TileMode.CLAMP);
        } else {
            float f2 = a2 / 2.0f;
            float max = (float) (Math.max(d, a2) / Math.sqrt(2.0d));
            com.transsion.shorttv.base.widget.shimmer.a aVar4 = this.f;
            radialGradient = new RadialGradient(d / 2.0f, f2, max, aVar4.b, aVar4.a, Shader.TileMode.CLAMP);
        }
        this.b.setShader(radialGradient);
    }

    private void j() {
        boolean z;
        if (this.f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            z = valueAnimator.isStarted();
            this.e.cancel();
            this.e.removeAllUpdateListeners();
        } else {
            z = false;
        }
        com.transsion.shorttv.base.widget.shimmer.a aVar = this.f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (aVar.u / aVar.t) + 1.0f);
        this.e = ofFloat;
        ofFloat.setRepeatMode(this.f.s);
        this.e.setRepeatCount(this.f.r);
        ValueAnimator valueAnimator2 = this.e;
        com.transsion.shorttv.base.widget.shimmer.a aVar2 = this.f;
        valueAnimator2.setDuration(aVar2.t + aVar2.u);
        this.e.addUpdateListener(this.a);
        if (z) {
            this.e.start();
        }
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    void b() {
        com.transsion.shorttv.base.widget.shimmer.a aVar;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator == null || valueAnimator.isStarted() || (aVar = this.f) == null || !aVar.p || getCallback() == null) {
            return;
        }
        this.e.start();
    }

    public void d(com.transsion.shorttv.base.widget.shimmer.a aVar) {
        this.f = aVar;
        if (aVar != null) {
            this.b.setXfermode(new PorterDuffXfermode(this.f.q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        i();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float c;
        float c2;
        if (this.f == null || this.b.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.f.n));
        float height = this.c.height() + (this.c.width() * tan);
        float width = this.c.width() + (tan * this.c.height());
        ValueAnimator valueAnimator = this.e;
        float f = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i = this.f.d;
        if (i != 1) {
            if (i == 2) {
                c2 = c(width, -width, animatedFraction);
            } else if (i != 3) {
                c2 = c(-width, width, animatedFraction);
            } else {
                c = c(height, -height, animatedFraction);
            }
            f = c2;
            c = 0.0f;
        } else {
            c = c(-height, height, animatedFraction);
        }
        this.d.reset();
        this.d.setRotate(this.f.n, this.c.width() / 2.0f, this.c.height() / 2.0f);
        this.d.postTranslate(f, c);
        this.b.getShader().setLocalMatrix(this.d);
        canvas.drawRect(this.c, this.b);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            ArrayList<Animator.AnimatorListener> listeners = valueAnimator.getListeners();
            if (listeners != null && listeners.size() > 0) {
                listeners.clear();
            }
            this.e.addListener(animatorListener);
        }
    }

    public void f() {
        if (this.e == null || a() || getCallback() == null) {
            return;
        }
        this.e.start();
    }

    public void g(int i, AnimatorListenerAdapter animatorListenerAdapter) {
        com.transsion.shorttv.base.widget.shimmer.a aVar;
        if (a() || getCallback() == null || (aVar = this.f) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            this.e = ValueAnimator.ofFloat(0.0f, (aVar.u / aVar.t) + 1.0f);
        }
        this.e.setRepeatMode(this.f.s);
        this.e.setRepeatCount(i);
        ValueAnimator valueAnimator2 = this.e;
        com.transsion.shorttv.base.widget.shimmer.a aVar2 = this.f;
        valueAnimator2.setDuration(aVar2.t + aVar2.u);
        this.e.addUpdateListener(this.a);
        if (animatorListenerAdapter != null) {
            this.e.addListener(animatorListenerAdapter);
        }
        this.e.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        com.transsion.shorttv.base.widget.shimmer.a aVar = this.f;
        return (aVar == null || !(aVar.o || aVar.q)) ? -1 : -3;
    }

    public void h() {
        if (this.e == null || !a()) {
            return;
        }
        this.e.end();
        this.e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.set(0, 0, rect.width(), rect.height());
        i();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
