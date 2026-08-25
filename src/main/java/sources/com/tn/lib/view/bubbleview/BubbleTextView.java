package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleTextView extends AppCompatTextView {
    private BubbleDrawable a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private BubbleDrawable.ArrowLocation h;
    private boolean i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BubbleDrawable.ArrowLocation.values().length];
            a = iArr;
            try {
                iArr[BubbleDrawable.ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubbleDrawable.ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubbleDrawable.ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubbleDrawable.ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleTextView(Context context) {
        super(context);
        b(null);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public BubbleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.b = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.b.u);
            this.d = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.b.v);
            this.c = obtainStyledAttributes.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.b.w);
            this.e = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.b.x);
            this.f = obtainStyledAttributes.getColor(R.styleable.BubbleView_bubbleColor, BubbleDrawable.b.y);
            this.h = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.i = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            this.g = obtainStyledAttributes.getInt(R.styleable.BubbleView_bubbleAlpha, 255);
            obtainStyledAttributes.recycle();
        }
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        d(getWidth(), getHeight());
    }

    private void d(int i, int i2) {
        e(0, i, 0, i2);
    }

    private void e(int i, int i2, int i3, int i4) {
        this.a = new BubbleDrawable.b().B(new RectF(i, i3, i2, i4)).t(this.h).z(BubbleDrawable.BubbleType.COLOR).q(this.c).p(this.g).s(this.d).v(this.b).x(this.f).u(this.e).r(this.i).A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = a.a[this.h.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (paddingLeft + this.b);
        } else if (i == 2) {
            paddingRight = (int) (paddingRight + this.b);
        } else if (i == 3) {
            paddingTop = (int) (paddingTop + this.d);
        } else if (i == 4) {
            paddingBottom = (int) (paddingBottom + this.d);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void layout(int i, int i2, int i3, int i4) {
        super/*android.widget.TextView*/.layout(i, i2, i3, i4);
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        BubbleDrawable bubbleDrawable = this.a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        super/*android.widget.TextView*/.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.widget.TextView*/.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        d(i, i2);
    }

    public void setArrowPosition(float f) {
        this.e = f;
        c();
    }
}
