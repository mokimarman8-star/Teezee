package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$styleable;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/transsion/baseui/widget/RoundedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", BuildConfig.FLAVOR, "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "path", BuildConfig.FLAVOR, "b", "F", "radius", "c", "topLeftRadius", "d", "topRightRadius", "e", "bottomLeftRadius", "f", "bottomRightRadius", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoundedConstraintLayout extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: b, reason: from kotlin metadata */
    private float radius;

    /* renamed from: c, reason: from kotlin metadata */
    private float topLeftRadius;

    /* renamed from: d, reason: from kotlin metadata */
    private float topRightRadius;

    /* renamed from: e, reason: from kotlin metadata */
    private float bottomLeftRadius;

    /* renamed from: f, reason: from kotlin metadata */
    private float bottomRightRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.path = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.RoundedConstraintLayout, 0, 0);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.radius = obtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_cornerRadius, 0.0f);
            this.topLeftRadius = obtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_topLeftRadius, 0.0f);
            this.topRightRadius = obtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_topRightRadius, 0.0f);
            this.bottomLeftRadius = obtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_bottomLeftRadius, 0.0f);
            this.bottomRightRadius = obtainStyledAttributes.getDimension(R$styleable.RoundedConstraintLayout_bottomRightRadius, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        if (this.radius > 0.0f) {
            Path path = this.path;
            float width = getWidth();
            float height = getHeight();
            float f = this.radius;
            path.addRoundRect(0.0f, 0.0f, width, height, f, f, Path.Direction.CW);
            canvas.clipPath(this.path);
        } else {
            float f2 = this.topLeftRadius;
            float f3 = this.topRightRadius;
            float f4 = this.bottomRightRadius;
            float f5 = this.bottomLeftRadius;
            this.path.addRoundRect(0.0f, 0.0f, getWidth(), getHeight(), new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CW);
            canvas.clipPath(this.path);
        }
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
