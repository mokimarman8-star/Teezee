package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleFrameLayout extends FrameLayout {
    private BubbleDrawable a;
    private float b;
    private int c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private BubbleDrawable.ArrowLocation j;
    private int k;
    private boolean l;

    public BubbleFrameLayout(Context context) {
        super(context);
        b(null);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.b = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.c = obtainStyledAttributes.getColor(R.styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.d = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.e = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.f = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.b.u);
            this.h = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.b.v);
            this.g = obtainStyledAttributes.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.b.w);
            this.i = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.b.x);
            this.k = obtainStyledAttributes.getColor(R.styleable.BubbleView_bubbleColor, BubbleDrawable.b.y);
            this.j = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.l = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2) {
        d((int) ((getPaddingLeft() + this.b) - this.d), (int) (((i - getPaddingRight()) - this.b) - this.d), (int) ((getPaddingTop() + this.b) - this.e), (int) (((i2 - getPaddingBottom()) - this.b) - this.e));
        setBackgroundDrawable(this.a);
    }

    private void d(int i, int i2, int i3, int i4) {
        if (i2 < i || i4 < i3) {
            return;
        }
        this.a = new BubbleDrawable.b().B(new RectF(i, i3, i2, i4)).t(this.j).z(BubbleDrawable.BubbleType.COLOR).q(this.g).s(this.h).v(this.f).u(this.i).x(this.k).r(this.l).F(this.b).C(this.c).D(this.d).E(this.e).A();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        c(i, i2);
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleFrameLayout bubbleFrameLayout = BubbleFrameLayout.this;
                bubbleFrameLayout.c(bubbleFrameLayout.getWidth(), BubbleFrameLayout.this.getHeight());
            }
        });
    }
}
