package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.tn.lib.widget.R;
import com.transsion.publish.R$color;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ClipView extends View {
    public static final int BORDERDISTANCE = 0;
    public static final int CIRCLE_ZOOM = 3;
    public static final int CIRCULAR = 0;
    public static final int RECTANGULAR = 1;
    public static int TYPE_START = 0;
    public static int mHorizontalPadding = 16;
    private Paint a;
    private Context b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    public int innerCircle;
    private boolean j;
    private boolean k;

    public ClipView(Context context) {
        this(context, null);
        this.b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.b = context;
    }

    public ClipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.innerCircle = getWidth() / 3;
        this.i = true;
        this.j = true;
        this.k = true;
        this.a = new Paint();
        this.b = context;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int cropHeight() {
        return this.d;
    }

    public int cropWidth() {
        return this.c;
    }

    public int getInnerCircle() {
        return this.innerCircle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i2 = this.c;
        if (i2 <= 0 || (i = this.d) <= 0 || width <= 0 || height <= 0) {
            if (TYPE_START == 0) {
                this.innerCircle = width / 3;
                this.a.setColor(0);
                this.a.setDither(true);
                this.a.setAntiAlias(true);
                this.a.setStyle(Paint.Style.STROKE);
                float f = width / 2;
                float f2 = height / 2;
                canvas.drawCircle(f, f2, r6 - mHorizontalPadding, this.a);
                this.a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
                this.a.setStrokeWidth(height);
                canvas.drawCircle(f, f2, (r6 - mHorizontalPadding) + r1, this.a);
                return;
            }
            this.a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
            float f3 = width;
            float f4 = (height - width) / 2;
            canvas.drawRect(0.0f, 0.0f, f3, f4, this.a);
            float f5 = (height + width) / 2;
            canvas.drawRect(0.0f, f5, f3, height, this.a);
            canvas.drawRect(0.0f, f4, 0.0f, f5, this.a);
            canvas.drawRect(width, f4, f3, f5, this.a);
            this.a.setColor(-1);
            this.a.setStrokeWidth(2.0f);
            float f6 = width;
            canvas.drawLine(0.0f, f4, f6, f4, this.a);
            canvas.drawLine(0.0f, f5, f6, f5, this.a);
            canvas.drawLine(0.0f, f4, 0.0f, f5, this.a);
            canvas.drawLine(f6, f4, f6, f5, this.a);
            return;
        }
        if (this.i) {
            int[] a = this.k ? qo.b.a(this.b, i2, i, width, height) : qo.b.b(this.b, i2, i, width, height, 1.0f);
            this.c = a[0];
            this.d = a[1];
        }
        int i3 = (width - this.c) / 2;
        int i4 = (height - this.d) / 2;
        this.a.setColor(b.getColor(getContext(), R$color.cl31_50_p));
        float f7 = width;
        float f8 = i4;
        canvas.drawRect(0.0f, 0.0f, f7, f8, this.a);
        canvas.drawRect(0.0f, this.d + i4, f7, height, this.a);
        canvas.drawRect(0.0f, f8, i3, this.d + i4, this.a);
        canvas.drawRect(this.c + i3, f8, f7, this.d + i4, this.a);
        this.a.setColor(b.getColor(getContext(), R.color.white));
        this.a.setStrokeWidth(1);
        this.e = i3;
        this.f = i4;
        int i5 = this.c + i3;
        this.g = i5;
        if (this.k) {
            this.h = this.d + i4;
        } else {
            this.h = this.d - (i4 != 0 ? i4 : 1);
        }
        if (this.j) {
            canvas.drawLine(i3, i4, i5, i4, this.a);
            float f9 = this.e;
            int i6 = this.h;
            canvas.drawLine(f9, i6, this.g, i6, this.a);
            int i7 = this.e;
            canvas.drawLine(i7, this.f, i7, this.h, this.a);
            int i8 = this.g;
            canvas.drawLine(i8, this.f, i8, this.h, this.a);
        }
    }

    public Rect rect() {
        return new Rect(this.e, this.f, this.g, this.h);
    }

    public void setFullScreen(boolean z) {
        this.k = z;
    }

    public void setNeedDivider(boolean z) {
        this.j = z;
    }

    public void setSizeNeedChange(boolean z) {
        this.i = z;
        invalidate();
    }

    public void setStart(int i) {
        TYPE_START = i;
    }

    public void setStartWH(int i, int i2) {
        this.c = i;
        this.d = i2;
    }
}
