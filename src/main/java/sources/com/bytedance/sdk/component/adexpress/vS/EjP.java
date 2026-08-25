package com.bytedance.sdk.component.adexpress.vS;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP extends View {
    private List<Integer> Dq;
    private int EjP;
    private float Fmk;
    private float HiB;
    private boolean Jcg;
    private int Sj;
    private Paint TEQ;
    private float TKC;
    private Paint Ym;
    private float aa;
    private int sP;
    private int sef;
    private List<Integer> uA;
    private int vS;

    public EjP(Context context) {
        this(context, null);
    }

    public EjP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public EjP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Sj = -1;
        this.sP = -65536;
        this.TKC = 18.0f;
        this.EjP = 3;
        this.HiB = 50.0f;
        this.vS = 2;
        this.Jcg = false;
        this.Dq = new ArrayList();
        this.uA = new ArrayList();
        this.sef = 24;
        TKC();
    }

    private void TKC() {
        Paint paint = new Paint();
        this.TEQ = paint;
        paint.setAntiAlias(true);
        this.TEQ.setStrokeWidth(this.sef);
        this.Dq.add(255);
        this.uA.add(0);
        Paint paint2 = new Paint();
        this.Ym = paint2;
        paint2.setAntiAlias(true);
        this.Ym.setColor(Color.parseColor("#0FFFFFFF"));
        this.Ym.setStyle(Paint.Style.FILL);
    }

    public void Sj() {
        this.Jcg = true;
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.TEQ.setShader(new LinearGradient(this.aa, 0.0f, this.Fmk, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.Dq.size()) {
                break;
            }
            Integer num = this.Dq.get(i);
            this.TEQ.setAlpha(num.intValue());
            Integer num2 = this.uA.get(i);
            if (this.TKC + num2.intValue() < this.HiB) {
                canvas.drawCircle(this.aa, this.Fmk, this.TKC + num2.intValue(), this.TEQ);
            }
            if (num.intValue() > 0 && num2.intValue() < this.HiB) {
                this.Dq.set(i, Integer.valueOf(num.intValue() - this.vS > 0 ? num.intValue() - (this.vS * 3) : 1));
                this.uA.set(i, Integer.valueOf(num2.intValue() + this.vS));
            }
            i++;
        }
        List<Integer> list = this.uA;
        if (list.get(list.size() - 1).intValue() >= this.HiB / this.EjP) {
            this.Dq.add(255);
            this.uA.add(0);
        }
        if (this.uA.size() >= 3) {
            this.uA.remove(0);
            this.Dq.remove(0);
        }
        this.TEQ.setAlpha(255);
        this.TEQ.setColor(this.sP);
        canvas.drawCircle(this.aa, this.Fmk, this.TKC, this.Ym);
        if (this.Jcg) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.aa = f;
        this.Fmk = i2 / 2.0f;
        float f2 = f - (this.sef / 2.0f);
        this.HiB = f2;
        this.TKC = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void sP() {
        this.Jcg = false;
        this.uA.clear();
        this.Dq.clear();
        this.Dq.add(255);
        this.uA.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.Sj = i;
    }

    public void setCoreColor(int i) {
        this.sP = i;
    }

    public void setCoreRadius(int i) {
        this.TKC = i;
    }

    public void setDiffuseSpeed(int i) {
        this.vS = i;
    }

    public void setDiffuseWidth(int i) {
        this.EjP = i;
    }

    public void setMaxWidth(int i) {
        this.HiB = i;
    }
}
