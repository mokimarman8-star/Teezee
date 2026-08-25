package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class a extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f13420a;

    /* renamed from: b, reason: collision with root package name */
    private int f13421b;

    /* renamed from: c, reason: collision with root package name */
    private int f13422c;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    private static class C0104a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        private Paint f13423a = new Paint();

        /* renamed from: b, reason: collision with root package name */
        private int f13424b;

        /* renamed from: c, reason: collision with root package name */
        private a f13425c;

        C0104a(a aVar, int i5) {
            this.f13425c = aVar;
            this.f13424b = i5;
            a((int) rect().width());
        }

        private void a(int i5) {
            float f5 = i5 / 2;
            this.f13423a.setShader(new RadialGradient(f5, f5, this.f13424b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.f13425c.getWidth() / 2;
            float height = this.f13425c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f13423a);
            canvas.drawCircle(width, height, r0 - this.f13424b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f5, float f6) {
            super.onResize(f5, f6);
            a((int) f5);
        }
    }

    a(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f5 = getContext().getResources().getDisplayMetrics().density;
        int i5 = (int) (1.75f * f5);
        int i6 = (int) (0.0f * f5);
        this.f13421b = (int) (3.5f * f5);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f13422c = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f5 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0104a(this, this.f13421b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f13421b, i6, i5, 503316480);
            int i7 = this.f13421b;
            setPadding(i7, i7, i7, i7);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f13422c);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f13420a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f13420a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f13420a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f13421b * 2), getMeasuredHeight() + (this.f13421b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i5);
            this.f13422c = i5;
        }
    }
}
