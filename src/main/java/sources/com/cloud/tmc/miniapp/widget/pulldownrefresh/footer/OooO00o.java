package com.cloud.tmc.miniapp.widget.pulldownrefresh.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO;
import z0.b;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o extends com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0 implements OooO {
    public float OooO;
    public boolean OooO0Oo;
    public Paint OooO0o;
    public boolean OooO0o0;
    public int OooO0oO;
    public int OooO0oo;
    public long OooOO0;
    public boolean OooOO0O;
    public TimeInterpolator OooOO0o;

    public OooO00o(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, 0);
        this.OooO0oO = -1118482;
        this.OooO0oo = -1615546;
        this.OooOO0 = 0L;
        this.OooOO0O = false;
        this.OooOO0o = new AccelerateDecelerateInterpolator();
        setMinimumHeight(com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MiniBallPulseFooter);
        Paint paint = new Paint();
        this.OooO0o = paint;
        paint.setColor(-1);
        this.OooO0o.setStyle(Paint.Style.FILL);
        this.OooO0o.setAntiAlias(true);
        this.OooO0O0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo;
        this.OooO0O0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0oo[obtainStyledAttributes.getInt(R.styleable.MiniBallPulseFooter_srlClassicsSpinnerStyle, 0)];
        if (obtainStyledAttributes.hasValue(R.styleable.MiniBallPulseFooter_srlNormalColor)) {
            OooO0O0(obtainStyledAttributes.getColor(R.styleable.MiniBallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.MiniBallPulseFooter_srlAnimatingColor)) {
            OooO00o(obtainStyledAttributes.getColor(R.styleable.MiniBallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.OooO = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(4.0f);
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public int OooO00o(@NonNull OooOOO oooOOO, boolean z) {
        this.OooOO0O = false;
        this.OooOO0 = 0L;
        this.OooO0o.setColor(this.OooO0oO);
        return 0;
    }

    public OooO00o OooO00o(int i) {
        this.OooO0oo = i;
        this.OooO0o0 = true;
        if (this.OooOO0O) {
            this.OooO0o.setColor(i);
        }
        return this;
    }

    public OooO00o OooO0O0(int i) {
        this.OooO0oO = i;
        this.OooO0Oo = true;
        if (!this.OooOO0O) {
            this.OooO0o.setColor(i);
        }
        return this;
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO0O0(@NonNull OooOOO oooOOO, int i, int i2) {
        if (this.OooOO0O) {
            return;
        }
        invalidate();
        this.OooOO0O = true;
        this.OooOO0 = System.currentTimeMillis();
        this.OooO0o.setColor(this.OooO0oo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float min = Math.min(width, height);
        float f = this.OooO;
        float f2 = (min - (f * 2.0f)) / 6.0f;
        float f3 = f2 * 2.0f;
        float f4 = (width / 2.0f) - (f + f3);
        float f5 = height / 2.0f;
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            float interpolation = this.OooOO0o.getInterpolation((currentTimeMillis - this.OooOO0) - (i2 * 120) > 0 ? (r10 % 750) / 750.0f : 0.0f);
            canvas.save();
            float f6 = i;
            canvas.translate((this.OooO * f6) + (f3 * f6) + f4, f5);
            if (interpolation < 0.5d) {
                float f7 = 1.0f - ((interpolation * 2.0f) * 0.7f);
                canvas.scale(f7, f7);
            } else {
                float f10 = ((interpolation * 2.0f) * 0.7f) - 0.4f;
                canvas.scale(f10, f10);
            }
            canvas.drawCircle(0.0f, 0.0f, f2, this.OooO0o);
            canvas.restore();
            i = i2;
        }
        super.dispatchDraw(canvas);
        if (this.OooOO0O) {
            invalidate();
        }
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.OooO0o0 && iArr.length > 1) {
            int i = iArr[0];
            this.OooO0oo = i;
            this.OooO0o0 = true;
            if (this.OooOO0O) {
                this.OooO0o.setColor(i);
            }
            this.OooO0o0 = false;
        }
        if (this.OooO0Oo) {
            return;
        }
        if (iArr.length > 1) {
            OooO0O0(iArr[1]);
        } else if (iArr.length > 0) {
            OooO0O0(b.k(-1711276033, iArr[0]));
        }
        this.OooO0Oo = false;
    }
}
