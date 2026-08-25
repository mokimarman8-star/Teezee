package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;
import xy.c;
import yy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class TestPagerIndicator extends View implements c {
    private Paint a;
    private int b;
    private int c;
    private RectF d;
    private RectF e;
    private List f;

    public TestPagerIndicator(Context context) {
        super(context);
        this.d = new RectF();
        this.e = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b = -65536;
        this.c = -16711936;
    }

    public int getInnerRectColor() {
        return this.c;
    }

    public int getOutRectColor() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.setColor(this.b);
        canvas.drawRect(this.d, this.a);
        this.a.setColor(this.c);
        canvas.drawRect(this.e, this.a);
    }

    @Override // xy.c
    public void onPageScrollStateChanged(int i) {
    }

    @Override // xy.c
    public void onPageScrolled(int i, float f, int i2) {
        List list = this.f;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f2 = uy.a.f(this.f, i);
        a f3 = uy.a.f(this.f, i + 1);
        RectF rectF = this.d;
        rectF.left = f2.a + ((f3.a - r1) * f);
        rectF.top = f2.b + ((f3.b - r1) * f);
        rectF.right = f2.c + ((f3.c - r1) * f);
        rectF.bottom = f2.d + ((f3.d - r1) * f);
        RectF rectF2 = this.e;
        rectF2.left = f2.e + ((f3.e - r1) * f);
        rectF2.top = f2.f + ((f3.f - r1) * f);
        rectF2.right = f2.g + ((f3.g - r1) * f);
        rectF2.bottom = f2.h + ((f3.h - r7) * f);
        invalidate();
    }

    @Override // xy.c
    public void onPageSelected(int i) {
    }

    @Override // xy.c
    public void onPositionDataProvide(List<a> list) {
        this.f = list;
    }

    public void setInnerRectColor(int i) {
        this.c = i;
    }

    public void setOutRectColor(int i) {
        this.b = i;
    }
}
