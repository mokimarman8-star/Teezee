package com.transsion.audio.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.audio.view.EnFloatingView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class FloatingMagnetView extends FrameLayout {
    public static final int MARGIN_EDGE = 13;
    protected MoveAnimator a;
    protected int b;
    private int c;
    private boolean d;
    private float e;
    float f;
    float g;

    protected class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private final Handler handler = new Handler(Looper.getMainLooper());
        private long startingTime;

        protected MoveAnimator() {
        }

        private void stop() {
            this.handler.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float min = Math.min(1.0f, (System.currentTimeMillis() - this.startingTime) / 400.0f);
            FloatingMagnetView.this.g((this.destinationX - FloatingMagnetView.this.getX()) * min, (this.destinationY - FloatingMagnetView.this.getY()) * min);
            if (min < 1.0f) {
                this.handler.post(this);
            }
        }

        void start(float f, float f2) {
            this.destinationX = f;
            this.destinationY = f2;
            this.startingTime = System.currentTimeMillis();
            this.handler.post(this);
        }
    }

    protected FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected FloatingMagnetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.f = 0.0f;
        this.g = 0.0f;
        d();
    }

    private void c() {
        this.e = 0.0f;
    }

    private void d() {
        this.a = new MoveAnimator();
        setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(boolean z) {
        i();
        h(this.d, z);
    }

    private void f(boolean z) {
        if (z) {
            this.e = getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f, float f2) {
        setX(getX() + f);
        setY(getY() + f2);
    }

    private void h(boolean z, boolean z2) {
        float f = z ? 13.0f : this.b - 13;
        float y = getY();
        if (!z2) {
            float f2 = this.e;
            if (f2 != 0.0f) {
                c();
                y = f2;
            }
        }
        this.a.start(f, Math.min(Math.max(0.0f, y), this.c - getHeight()));
    }

    private void i() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            this.b = viewGroup.getWidth() - getWidth();
            this.c = viewGroup.getHeight();
        }
    }

    abstract void attach(Context context);

    abstract void expanded();

    abstract boolean isPackUp();

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            final boolean z = configuration.orientation == 2;
            f(z);
            ((ViewGroup) getParent()).post(new Runnable() { // from class: com.transsion.audio.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingMagnetView.this.e(z);
                }
            });
        }
    }

    abstract void onProgress(int i);

    abstract void onSlideTheLeft();

    abstract void onStateChanged(int i);

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = motionEvent.getRawX();
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            this.g = rawX;
            float f = this.f;
            if (rawX < f && Math.abs(rawX - f) > 50.0f) {
                onSlideTheLeft();
                return true;
            }
        } else if ((action == 1 || action == 3) && Math.abs(motionEvent.getRawX() - this.f) < 10.0f) {
            onViewClick();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    abstract void onViewClick();

    abstract void packUp();

    abstract void packUpAnimation();

    abstract void prepare();

    abstract void setOnOptionListener(EnFloatingView.f fVar);
}
