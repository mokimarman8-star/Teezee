package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$styleable;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/transsion/baseui/widget/GradientBorderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", BuildConfig.FLAVOR, "dispatchDraw", "(Landroid/graphics/Canvas;)V", "a", "I", "startColor", "b", "endColor", BuildConfig.FLAVOR, "c", "[F", "cornerRadii", BuildConfig.FLAVOR, "d", "F", "borderWidth", "e", "gradientOrientation", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GradientBorderView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private int startColor;

    /* renamed from: b, reason: from kotlin metadata */
    private int endColor;

    /* renamed from: c, reason: from kotlin metadata */
    private float[] cornerRadii;

    /* renamed from: d, reason: from kotlin metadata */
    private float borderWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private int gradientOrientation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBorderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GradientBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.startColor = -16777216;
        this.endColor = -16777216;
        this.cornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientBorderView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.startColor = obtainStyledAttributes.getColor(R$styleable.GradientBorderView_borderViewStartColor, -16777216);
        this.endColor = obtainStyledAttributes.getColor(R$styleable.GradientBorderView_borderViewEndColor, -16777216);
        this.borderWidth = obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_borderWidth, 0.0f);
        this.gradientOrientation = obtainStyledAttributes.getInt(R$styleable.GradientBorderView_gradientOrientation, 0);
        this.cornerRadii = new float[]{obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topLeftCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topLeftCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topRightCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_topRightCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomRightCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomRightCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomLeftCornerRadius, 0.0f), obtainStyledAttributes.getDimension(R$styleable.GradientBorderView_bottomLeftCornerRadius, 0.0f)};
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public /* synthetic */ GradientBorderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        if (getWidth() <= 0 || getHeight() <= 0 || this.borderWidth <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.borderWidth);
        paint.setShader(this.gradientOrientation == 1 ? new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.startColor, this.endColor, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, this.startColor, this.endColor, Shader.TileMode.CLAMP));
        float f = this.borderWidth;
        float f2 = 2;
        RectF rectF = new RectF(f / f2, f / f2, getWidth() - (this.borderWidth / f2), getHeight() - (this.borderWidth / f2));
        Path path = new Path();
        path.addRoundRect(rectF, this.cornerRadii, Path.Direction.CW);
        canvas.drawPath(path, paint);
        try {
            super.dispatchDraw(canvas);
        } catch (IllegalArgumentException unused) {
        }
    }
}
