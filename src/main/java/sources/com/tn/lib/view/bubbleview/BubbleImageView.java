package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleImageView extends ImageView {
    private BubbleDrawable a;
    private Drawable b;
    private float c;
    private float d;
    private float e;
    private float f;
    private Bitmap g;
    private BubbleDrawable.ArrowLocation h;
    private boolean i;

    public BubbleImageView(Context context) {
        super(context);
        c(null);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
    }

    private Bitmap a(Drawable drawable) {
        return getBitmapFromDrawable(getContext(), drawable, getWidth(), getWidth(), 25);
    }

    private Drawable b(int i) {
        if (i != 0) {
            return getContext().getResources().getDrawable(i);
        }
        throw new IllegalArgumentException("getDrawable res can not be zero");
    }

    private void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.c = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.b.u);
            this.e = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.b.v);
            this.d = obtainStyledAttributes.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.b.w);
            this.f = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.b.x);
            this.h = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.i = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void d() {
        Drawable drawable;
        Drawable drawable2;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height <= 0 && (drawable2 = this.b) != null && drawable2.getIntrinsicWidth() >= 0) {
            height = (width / this.b.getIntrinsicWidth()) * this.b.getIntrinsicHeight();
        }
        if (height > 0 && width <= 0 && (drawable = this.b) != null && drawable.getIntrinsicHeight() >= 0) {
            width = (height / this.b.getIntrinsicHeight()) * this.b.getIntrinsicWidth();
        }
        e(width, height);
    }

    public static int dp2px(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    private void e(int i, int i2) {
        f(getPaddingLeft(), i - getPaddingRight(), getPaddingTop(), i2 - getPaddingBottom());
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 <= i || i4 <= i3) {
            return;
        }
        RectF rectF = new RectF(i, i3, i2, i4);
        Drawable drawable = this.b;
        if (drawable != null) {
            this.g = a(drawable);
        }
        this.a = new BubbleDrawable.b().B(rectF).t(this.h).q(this.d).s(this.e).v(this.c).z(BubbleDrawable.BubbleType.BITMAP).u(this.f).w(this.g).r(this.i).A();
    }

    public static Bitmap getBitmapFromDrawable(Context context, Drawable drawable, int i, int i2, int i3) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = (i <= 0 || i2 <= 0) ? Bitmap.createBitmap(dp2px(context, i3), dp2px(context, i3), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        BubbleDrawable bubbleDrawable = this.a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 && measuredHeight > 0) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        }
        if (measuredHeight > 0 || measuredWidth <= 0) {
            return;
        }
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        e(i, i2);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.g = bitmap;
        this.b = new BitmapDrawable(getResources(), bitmap);
        d();
        super.setImageDrawable(this.a);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.b = drawable;
        d();
        super.setImageDrawable(this.a);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(b(i));
    }
}
