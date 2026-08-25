package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Dq extends View {
    private static final int[] Sj = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private int Dq;
    private final ArrayList<Sj> EjP;
    private final Paint HiB;
    private int Jcg;
    private final RectF TKC;
    private final RectF sP;
    private int uA;
    private final Paint vS;

    private static final class Sj {
        float EjP;
        public Paint Sj;
        float TKC;
        public float sP;

        public Sj(Paint paint, float f, float f2, float f3) {
            this.Sj = paint;
            this.sP = f;
            this.TKC = f2;
            this.EjP = f3;
        }
    }

    public Dq(Context context) {
        super(context);
        this.sP = new RectF();
        this.TKC = new RectF();
        this.EjP = new ArrayList<>();
        this.vS = new Paint();
        Paint paint = new Paint();
        this.HiB = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    private void Sj() {
        if (this.Jcg <= 0) {
            return;
        }
        int width = (int) (((this.Dq * 1.0f) / 100.0f) * getWidth());
        this.TKC.right = Math.max(this.uA, width);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.sP;
        int i = this.Jcg;
        canvas.drawRoundRect(rectF, i, i, this.HiB);
        RectF rectF2 = this.TKC;
        int i2 = this.Jcg;
        canvas.drawRoundRect(rectF2, i2, i2, this.vS);
        int save = canvas.save();
        canvas.translate(this.TKC.right - this.uA, 0.0f);
        Iterator<Sj> it = this.EjP.iterator();
        while (it.hasNext()) {
            Sj next = it.next();
            canvas.drawCircle(next.TKC, next.EjP, next.sP, next.Sj);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i8 = i2 / 2;
        this.Jcg = i8;
        this.uA = i8 * 5;
        float f = i;
        float f2 = i2;
        this.sP.set(0.0f, 0.0f, f, f2);
        this.TKC.set(0.0f, 0.0f, 0.0f, f2);
        this.vS.setShader(new LinearGradient(0.0f, 0.0f, f, f2, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.EjP.clear();
        float f3 = this.Jcg / 4.0f;
        for (int i9 : Sj) {
            Paint paint = new Paint();
            paint.setColor(i9);
            this.EjP.add(new Sj(paint, this.Jcg / 2.0f, f3, f2 / 2.0f));
            f3 += (this.Jcg / 2.0f) * 3.0f;
        }
        Sj();
    }

    public void setProgress(int i) {
        int i2 = this.Dq;
        if (i2 == i) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 == i) {
            return;
        }
        this.Dq = i;
        Sj();
    }
}
