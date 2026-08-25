package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.timer.InertiaTimerTask;
import com.contrarywind.timer.SmoothScrollTimerTask;
import com.tn.lib.view.FlowLayout;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import o7.a;
import p7.b;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class WheelView extends View {
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private float N;
    private long O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private float T;
    private final float U;
    private final List V;
    private DividerType a;
    private Context b;
    private Handler c;
    private GestureDetector d;
    private b e;
    private boolean f;
    private boolean g;
    private ScheduledExecutorService h;
    private ScheduledFuture i;
    private Paint j;
    private Paint k;
    private Paint l;
    private a m;
    private String n;
    private Boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private float t;
    private Typeface u;
    private int v;
    private int w;
    private int x;
    private float y;
    private boolean z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = true;
        this.h = Executors.newSingleThreadScheduledExecutor();
        this.o = Boolean.FALSE;
        this.u = Typeface.MONOSPACE;
        this.y = 4.0f;
        this.I = 5;
        this.M = 0;
        this.N = 0.0f;
        this.O = 0L;
        this.Q = 17;
        this.R = 0;
        this.S = 0;
        this.U = 0.5f;
        this.V = Arrays.asList(new DateFormatSymbols(Locale.getDefault()).getShortMonths());
        this.p = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.T = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.T = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.T = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.T = 6.0f;
        } else if (f >= 3.0f) {
            this.T = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.Q = obtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.v = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, FlowLayout.SPACING_AUTO);
            this.w = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -16711936);
            this.x = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, 855638016);
            this.p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.p);
            this.y = obtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.y);
            obtainStyledAttributes.recycle();
        }
        h();
        f(context);
    }

    private String b(int i) {
        try {
            return (String) this.V.get(i - 1);
        } catch (Exception unused) {
            return String.valueOf(i);
        }
    }

    private String c(Object obj) {
        return obj == null ? "" : obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", (Integer) obj) : obj.toString();
    }

    private int d(int i) {
        return i < 0 ? d(i + this.m.a()) : i > this.m.a() + (-1) ? d(i - this.m.a()) : i;
    }

    private String e(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt > 12 ? str : b(parseInt);
        } catch (Exception unused) {
            return str;
        }
    }

    private void f(Context context) {
        this.b = context;
        this.c = new q7.a(this);
        GestureDetector gestureDetector = new GestureDetector(context, new p7.a(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.z = true;
        this.D = 0.0f;
        this.E = -1;
        g();
    }

    private void g() {
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(this.v);
        this.j.setAntiAlias(true);
        this.j.setTypeface(this.u);
        this.j.setTextSize(this.p);
        Paint paint2 = new Paint();
        this.k = paint2;
        paint2.setColor(this.w);
        this.k.setAntiAlias(true);
        this.k.setTextScaleX(1.1f);
        this.k.setTypeface(this.u);
        this.k.setTextSize(this.p);
        Paint paint3 = new Paint();
        this.l = paint3;
        paint3.setColor(this.x);
        this.l.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void h() {
        float f = this.y;
        if (f < 1.0f) {
            this.y = 1.0f;
        } else if (f > 4.0f) {
            this.y = 4.0f;
        }
    }

    private void i() {
        Rect rect = new Rect();
        for (int i = 0; i < this.m.a(); i++) {
            String c = c(this.m.getItem(i));
            this.k.getTextBounds(c, 0, c.length(), rect);
            int width = rect.width();
            if (width > this.q) {
                this.q = width;
            }
            this.k.getTextBounds("星期", 0, 2, rect);
            this.r = rect.height() + 2;
        }
        this.t = this.r * 3;
    }

    private void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.k.getTextBounds(str, 0, str.length(), rect);
        int i = this.Q;
        if (i == 3) {
            this.R = 0;
            return;
        }
        if (i == 5) {
            this.R = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f || (str2 = this.n) == null || str2.equals("") || !this.g) {
            this.R = (int) ((this.K - rect.width()) * 0.5d);
        } else {
            this.R = (int) ((this.K - rect.width()) * 0.25d);
        }
    }

    private void k(String str) {
        String str2;
        Rect rect = new Rect();
        this.j.getTextBounds(str, 0, str.length(), rect);
        int i = this.Q;
        if (i == 3) {
            this.S = 0;
            return;
        }
        if (i == 5) {
            this.S = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.f || (str2 = this.n) == null || str2.equals("") || !this.g) {
            this.S = (int) ((this.K - rect.width()) * 0.5d);
        } else {
            this.S = (int) ((this.K - rect.width()) * 0.25d);
        }
    }

    private void l(String str) {
        Rect rect = new Rect();
        this.k.getTextBounds(str, 0, str.length(), rect);
        int i = this.p;
        for (int width = rect.width(); width > this.K; width = rect.width()) {
            i--;
            this.k.setTextSize(i);
            this.k.getTextBounds(str, 0, str.length(), rect);
        }
        this.j.setTextSize(i);
    }

    private void m() {
        if (this.m == null) {
            return;
        }
        i();
        int i = (int) (this.t * (this.I - 1));
        this.J = (int) ((i * 2) / 3.141592653589793d);
        this.L = (int) (i / 3.141592653589793d);
        this.K = View.MeasureSpec.getSize(this.P);
        int i2 = this.J;
        float f = this.t;
        this.A = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.B = f2;
        this.C = (f2 - ((f - this.r) / 2.0f)) - this.T;
        if (this.E == -1) {
            if (this.z) {
                this.E = (this.m.a() + 1) / 2;
            } else {
                this.E = 0;
            }
        }
        this.G = this.E;
    }

    public void cancelFuture() {
        ScheduledFuture scheduledFuture = this.i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.i.cancel(true);
        this.i = null;
    }

    public final a getAdapter() {
        return this.m;
    }

    public final int getCurrentItem() {
        int i;
        a aVar = this.m;
        if (aVar == null) {
            return 0;
        }
        return (!this.z || ((i = this.F) >= 0 && i < aVar.a())) ? Math.max(0, Math.min(this.F, this.m.a() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.m.a()), this.m.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.c;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.t;
    }

    public int getItemsCount() {
        a aVar = this.m;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(r2[i2]);
        }
        return i;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    public void isCenterLabel(boolean z) {
        this.g = z;
    }

    public boolean isLoop() {
        return this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0303  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        float f;
        boolean z;
        String c;
        int i;
        if (this.m == null) {
            return;
        }
        boolean z2 = false;
        int min = Math.min(Math.max(0, this.E), this.m.a() - 1);
        this.E = min;
        Object[] objArr = new Object[this.I];
        int i2 = (int) (this.D / this.t);
        this.H = i2;
        try {
            this.G = min + (i2 % this.m.a());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.z) {
            if (this.G < 0) {
                this.G = this.m.a() + this.G;
            }
            if (this.G > this.m.a() - 1) {
                this.G -= this.m.a();
            }
        } else {
            if (this.G < 0) {
                this.G = 0;
            }
            if (this.G > this.m.a() - 1) {
                this.G = this.m.a() - 1;
            }
        }
        float f2 = this.D % this.t;
        int i3 = 0;
        while (true) {
            int i4 = this.I;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.G - ((i4 / 2) - i3);
            if (this.z) {
                objArr[i3] = this.m.getItem(d(i5));
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.m.a() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.m.getItem(i5);
            }
            i3++;
        }
        float f3 = 0.0f;
        if (this.a == DividerType.WRAP) {
            float f4 = (TextUtils.isEmpty(this.n) ? (this.K - this.q) / 2 : (this.K - this.q) / 4) - 12;
            if (f4 <= 0.0f) {
                f4 = 10.0f;
            }
            float f5 = f4;
            float f6 = this.K - f5;
            float f7 = this.A;
            canvas.drawLine(f5, f7, f6, f7, this.l);
            float f10 = this.B;
            canvas.drawLine(f5, f10, f6, f10, this.l);
        } else {
            float f11 = this.A;
            canvas.drawLine(0.0f, f11, this.K, f11, this.l);
            float f12 = this.B;
            canvas.drawLine(0.0f, f12, this.K, f12, this.l);
        }
        if (!TextUtils.isEmpty(this.n) && this.g) {
            canvas.drawText(this.n, (this.K - getTextWidth(this.k, this.n)) - this.T, this.C, this.k);
        }
        int i6 = 0;
        while (i6 < this.I) {
            canvas.save();
            double d = ((this.t * i6) - f2) / this.L;
            float f13 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f13 >= 90.0f || f13 <= -90.0f) {
                f = f3;
                z = z2;
                canvas.restore();
            } else {
                float pow = (float) Math.pow(Math.abs(f13) / 90.0f, 2.2d);
                if (this.g || TextUtils.isEmpty(this.n) || TextUtils.isEmpty(c(objArr[i6]))) {
                    c = c(objArr[i6]);
                } else {
                    c = c(objArr[i6]) + this.n;
                }
                if (this.o.booleanValue()) {
                    c = e(c);
                }
                l(c);
                j(c);
                k(c);
                float cos = (float) ((this.L - (Math.cos(d) * this.L)) - ((Math.sin(d) * this.r) / 2.0d));
                canvas.translate(0.0f, cos);
                float f14 = this.A;
                if (cos > f14 || this.r + cos < f14) {
                    float f15 = this.B;
                    if (cos > f15 || this.r + cos < f15) {
                        if (cos >= f14) {
                            int i7 = this.r;
                            if (i7 + cos <= f15) {
                                canvas.drawText(c, this.R, i7 - this.T, this.k);
                                this.F = this.G - ((this.I / 2) - i6);
                            }
                        }
                        canvas.save();
                        z = false;
                        canvas.clipRect(0, 0, this.K, (int) this.t);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        Paint paint = this.j;
                        int i10 = this.s;
                        if (i10 == 0) {
                            i = 0;
                        } else if (i10 > 0) {
                            f = 0.0f;
                            i = 1;
                            paint.setTextSkewX(i * (f13 <= f ? 1 : -1) * 0.5f * pow);
                            this.j.setAlpha((int) ((1.0f - pow) * 255.0f));
                            canvas.drawText(c, this.S + (this.s * pow), this.r, this.j);
                            canvas.restore();
                            canvas.restore();
                            this.k.setTextSize(this.p);
                        } else {
                            i = -1;
                        }
                        f = 0.0f;
                        paint.setTextSkewX(i * (f13 <= f ? 1 : -1) * 0.5f * pow);
                        this.j.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(c, this.S + (this.s * pow), this.r, this.j);
                        canvas.restore();
                        canvas.restore();
                        this.k.setTextSize(this.p);
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.K, this.B - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(c, this.R, this.r - this.T, this.k);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.B - cos, this.K, (int) this.t);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(c, this.S, this.r, this.j);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.K, this.A - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(c, this.S, this.r, this.j);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.A - cos, this.K, (int) this.t);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(c, this.R, this.r - this.T, this.k);
                    canvas.restore();
                }
                f = 0.0f;
                z = false;
                canvas.restore();
                this.k.setTextSize(this.p);
            }
            i6++;
            z2 = z;
            f3 = f;
        }
    }

    public final void onItemSelected() {
        if (this.e != null) {
            postDelayed(new Runnable() { // from class: com.contrarywind.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.e.a(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.P = i;
        m();
        setMeasuredDimension(this.K, this.J);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.d.onTouchEvent(motionEvent);
        float f = (-this.E) * this.t;
        float a = ((this.m.a() - 1) - this.E) * this.t;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O = System.currentTimeMillis();
            cancelFuture();
            this.N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.N - motionEvent.getRawY();
            this.N = motionEvent.getRawY();
            float f2 = this.D + rawY;
            this.D = f2;
            if (!this.z) {
                float f3 = this.t;
                if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > a && rawY > 0.0f)) {
                    this.D = f2 - rawY;
                    return true;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.L;
            double acos = Math.acos((i - y) / i) * this.L;
            float f4 = this.t;
            this.M = (int) (((((int) ((acos + (f4 / 2.0f)) / f4)) - (this.I / 2)) * f4) - (((this.D % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.O > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.i = this.h.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(a aVar) {
        this.m = aVar;
        m();
        invalidate();
    }

    public void setConvertMonth(boolean z) {
        this.o = Boolean.valueOf(z);
    }

    public final void setCurrentItem(int i) {
        this.F = i;
        this.E = i;
        this.D = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.z = z;
    }

    public void setDividerColor(int i) {
        this.x = i;
        this.l.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.a = dividerType;
    }

    public void setGravity(int i) {
        this.Q = i;
    }

    public void setIsOptions(boolean z) {
        this.f = z;
    }

    public void setLabel(String str) {
        this.n = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.y = f;
            h();
        }
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.e = bVar;
    }

    public void setTextColorCenter(int i) {
        this.w = i;
        this.k.setColor(i);
    }

    public void setTextColorOut(int i) {
        this.v = i;
        this.j.setColor(i);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.p = i;
            this.j.setTextSize(i);
            this.k.setTextSize(this.p);
        }
    }

    public void setTextXOffset(int i) {
        this.s = i;
        if (i != 0) {
            this.k.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.D = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.u = typeface;
        this.j.setTypeface(typeface);
        this.k.setTypeface(this.u);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.D;
            float f2 = this.t;
            int i = (int) (((f % f2) + f2) % f2);
            this.M = i;
            if (i > f2 / 2.0f) {
                this.M = (int) (f2 - i);
            } else {
                this.M = -i;
            }
        }
        this.i = this.h.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.M), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
