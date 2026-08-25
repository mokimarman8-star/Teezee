package com.bytedance.sdk.component.adexpress.vS;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Fmk extends ImageView {
    private float Dq;
    private AnimatedImageDrawable EjP;
    private boolean Fmk;
    private boolean HiB;
    private float Jcg;
    private Movie Sj;
    private int TEQ;
    private int TKC;
    private int Ym;
    private volatile boolean aa;
    private long sP;
    private boolean sef;
    private float uA;
    private boolean vS;

    public Fmk(Context context) {
        super(context);
        this.HiB = Build.VERSION.SDK_INT >= 28;
        this.vS = false;
        this.Fmk = true;
        this.sef = true;
        Sj();
    }

    private void Sj(Canvas canvas) {
        Movie movie = this.Sj;
        if (movie == null) {
            return;
        }
        movie.setTime(this.TKC);
        float f = this.uA;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.Sj.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.Sj;
            float f2 = this.Jcg;
            float f3 = this.uA;
            movie2.draw(canvas, f2 / f3, this.Dq / f3);
        }
        canvas.restore();
    }

    private void TKC() {
        if (this.Sj == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.sP == 0) {
            this.sP = uptimeMillis;
        }
        int duration = this.Sj.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (this.sef || Math.abs(duration - this.TKC) >= 60) {
            this.TKC = (int) ((uptimeMillis - this.sP) % duration);
        } else {
            this.TKC = duration;
            this.aa = true;
        }
    }

    private void sP() {
        if (this.Sj == null || this.HiB || !this.Fmk) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
            AnimatedImageDrawable a = c.a(drawable);
            this.EjP = a;
            if (!this.aa) {
                a.start();
            }
            if (!this.sef) {
                a.setRepeatCount(0);
            }
        }
        sP();
    }

    void Sj() {
        if (this.HiB) {
            return;
        }
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Sj == null || this.HiB) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.aa) {
                Sj(canvas);
                return;
            }
            TKC();
            Sj(canvas);
            sP();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.Sj != null && !this.HiB) {
            this.Jcg = (getWidth() - this.TEQ) / 2.0f;
            this.Dq = (getHeight() - this.Ym) / 2.0f;
        }
        this.Fmk = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.HiB || (movie = this.Sj) == null) {
            return;
        }
        int width = movie.width();
        int height = this.Sj.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || width <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i2) == 0 || height <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : height / size);
        this.uA = max;
        int i3 = (int) (width * max);
        this.TEQ = i3;
        int i4 = (int) (height * max);
        this.Ym = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.Sj != null) {
            this.Fmk = i == 1;
            sP();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.Sj != null) {
            this.Fmk = i == 0;
            sP();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Sj != null) {
            this.Fmk = i == 0;
            sP();
        }
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.sef = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.EjP) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception unused) {
        }
    }
}
