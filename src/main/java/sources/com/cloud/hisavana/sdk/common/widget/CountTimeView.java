package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.b4;
import g7.e;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class CountTimeView extends View implements View.OnClickListener {
    private Paint a;
    private Paint b;
    private long c;
    private long d;
    private e e;
    private int f;
    private String g;
    private b h;
    private Bitmap i;
    private int j;
    private final Rect k;

    class a extends e {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // g7.e
        public void e() {
            if (CountTimeView.this.h != null) {
                CountTimeView.this.h.onFinish();
            }
        }

        @Override // g7.e
        public void f(long j) {
            CountTimeView.this.g = "SKIP " + (j / 1000);
            CountTimeView.this.j = (int) j;
            CountTimeView.this.invalidate();
        }
    }

    public interface b {
        void onClick();

        void onFinish();

        void onStart();
    }

    public CountTimeView(Context context) {
        this(context, null);
    }

    public CountTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 6L;
        this.d = 0L;
        this.g = "5s";
        this.k = new Rect();
        setOnClickListener(this);
        try {
            this.f = context.getResources().getDimensionPixelSize(R$dimen.ad_skip_text_size);
        } catch (Throwable unused) {
            this.f = 13;
        }
        e();
    }

    private void d() {
        this.e = new a(this.c, 1000L);
    }

    private void e() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(-1);
        this.b.setTextSize(this.f);
        this.b.setStrokeWidth(8.0f);
        this.b.setTextAlign(Paint.Align.CENTER);
    }

    private Bitmap getBg() {
        try {
            Drawable drawable = getResources().getDrawable(R$drawable.ad_skip_button);
            if (drawable instanceof BitmapDrawable) {
                this.i = ((BitmapDrawable) drawable).getBitmap();
            } else {
                this.i = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.i);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
            return this.i;
        } catch (Throwable th) {
            b4.b().e(Log.getStackTraceString(th));
            return null;
        }
    }

    public void cancel() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void changeFinishMode() {
        this.g = "X";
        invalidate();
    }

    public long getRemainder() {
        return this.j;
    }

    public long getSupposeFinishTime() {
        return this.d;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e.g();
        b bVar = this.h;
        if (bVar != null) {
            bVar.onStart();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.onClick();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.e;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (TextUtils.isEmpty(this.g)) {
                return;
            }
            if (this.i == null) {
                this.i = getBg();
            }
            Rect rect = new Rect(0, 0, this.i.getWidth(), this.i.getHeight());
            canvas.drawBitmap(this.i, rect, rect, this.a);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            Rect rect2 = this.k;
            canvas.drawText(this.g, rect2.centerX(), ((int) (((rect2.bottom + rect2.top) - fontMetrics.bottom) - fontMetrics.top)) / 2, this.b);
        } catch (Throwable th) {
            b4.b().e(Log.getStackTraceString(th));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.k.set(0, 0, getWidth(), getHeight());
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setCountDownTimerListener(b bVar) {
        this.h = bVar;
    }

    public void setStartTime(int i) {
        this.c = (i * 1000) + 400;
        this.d = System.currentTimeMillis() + this.c + 1000;
        this.j = i;
        d();
    }

    public void start() {
        this.e.g();
        this.d = System.currentTimeMillis() + this.c + 1000;
        b bVar = this.h;
        if (bVar != null) {
            bVar.onStart();
        }
    }
}
