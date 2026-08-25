package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\rJ)\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/transsion/postdetail/ui/view/VideoDoubleClickBackgroundView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BuildConfig.FLAVOR, "a", "(Landroid/util/AttributeSet;II)V", BuildConfig.FLAVOR, "isLeft", "setLeftStyle", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "rectF", "c", "Z", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VideoDoubleClickBackgroundView extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private final Paint mPaint;

    /* renamed from: b, reason: from kotlin metadata */
    private RectF rectF;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean isLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.mPaint = new Paint();
        this.isLeft = true;
        a(null, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.mPaint = new Paint();
        this.isLeft = true;
        a(attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.mPaint = new Paint();
        this.isLeft = true;
        a(attributeSet, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDoubleClickBackgroundView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.mPaint = new Paint();
        this.isLeft = true;
        a(attributeSet, i, i2);
    }

    private final void a(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(androidx.core.content.b.getColor(getContext(), R$color.video_double_click_bg));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f = width / 2.0f;
        double d = 2;
        double d2 = f;
        float degrees = (float) (Math.toDegrees(Math.asin((height / d) / d2)) * d);
        if (!this.isLeft) {
            if (this.rectF == null) {
                float f2 = height / 2;
                this.rectF = new RectF(f, (-f) + f2, width + f, (f - f2) + height);
            }
            RectF rectF = this.rectF;
            Intrinsics.e(rectF);
            canvas.drawArc(rectF, 180 - (degrees / 2.0f), degrees, false, this.mPaint);
            canvas.drawRect(width - ((float) Math.sqrt((d2 * d2) - ((height * height) / 4))), 0.0f, width, height, this.mPaint);
            return;
        }
        if (this.rectF == null) {
            float f3 = -f;
            float f4 = height / 2;
            this.rectF = new RectF(f3, f3 + f4, f, (f - f4) + height);
        }
        RectF rectF2 = this.rectF;
        Intrinsics.e(rectF2);
        canvas.drawArc(rectF2, (-degrees) / 2.0f, degrees, false, this.mPaint);
        canvas.drawRect(0.0f, 0.0f, (float) Math.sqrt((d2 * d2) - ((height * height) / 4)), height, this.mPaint);
    }

    public final void setLeftStyle(boolean isLeft) {
        if (this.isLeft == isLeft) {
            return;
        }
        this.isLeft = isLeft;
        this.rectF = null;
        invalidate();
    }
}
