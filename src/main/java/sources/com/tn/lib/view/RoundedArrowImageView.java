package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.widget.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001c¨\u0006$"}, d2 = {"Lcom/tn/lib/view/RoundedArrowImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "position", "", "setArrowPosition", "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", TmcConstants.EXTRA_PATH, "f", "F", "arrowHeight", "g", "cornerRadius", "h", "arrowWidth", "i", "arrowPosition", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RoundedArrowImageView extends AppCompatImageView {

    /* renamed from: d, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: e, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: f, reason: from kotlin metadata */
    private float arrowHeight;

    /* renamed from: g, reason: from kotlin metadata */
    private float cornerRadius;

    /* renamed from: h, reason: from kotlin metadata */
    private float arrowWidth;

    /* renamed from: i, reason: from kotlin metadata */
    private float arrowPosition;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedArrowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        Paint paint = new Paint(1);
        this.paint = paint;
        this.path = new Path();
        this.arrowHeight = com.blankj.utilcode.util.a0.a(8.0f);
        this.cornerRadius = com.blankj.utilcode.util.a0.a(8.0f);
        this.arrowWidth = com.blankj.utilcode.util.a0.a(16.0f);
        this.arrowPosition = com.blankj.utilcode.util.a0.a(200.0f);
        paint.setStyle(Paint.Style.FILL);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedArrowImageView, 0, 0);
            Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.arrowHeight = obtainStyledAttributes.getDimension(R.styleable.RoundedArrowImageView_arrowIVHeight, this.arrowHeight);
            this.cornerRadius = obtainStyledAttributes.getDimension(R.styleable.RoundedArrowImageView_cornerRadius, this.cornerRadius);
            this.arrowWidth = obtainStyledAttributes.getDimension(R.styleable.RoundedArrowImageView_arrowIVWidth, this.arrowWidth);
            this.arrowPosition = obtainStyledAttributes.getDimension(R.styleable.RoundedArrowImageView_arrowIVPositionOffset, this.arrowPosition);
            obtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ RoundedArrowImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        float width = getWidth();
        float height = getHeight() - this.arrowHeight;
        float f = this.arrowPosition;
        this.path.reset();
        float f2 = 2;
        this.path.moveTo(f - (this.arrowWidth / f2), this.arrowHeight);
        this.path.lineTo(f, 0.0f);
        this.path.lineTo(f + (this.arrowWidth / f2), this.arrowHeight);
        this.path.lineTo(width - this.cornerRadius, this.arrowHeight);
        Path path = this.path;
        float f3 = this.cornerRadius;
        float f4 = this.arrowHeight;
        path.arcTo(new RectF(width - (f3 * f2), f4, width, (f3 * f2) + f4), -90.0f, 90.0f);
        this.path.lineTo(width, (height - this.cornerRadius) + this.arrowHeight);
        Path path2 = this.path;
        float f5 = this.cornerRadius;
        float f6 = this.arrowHeight;
        path2.arcTo(new RectF(width - (f5 * f2), (height - (f5 * f2)) + f6, width, f6 + height), 0.0f, 90.0f);
        this.path.lineTo(this.cornerRadius, this.arrowHeight + height);
        Path path3 = this.path;
        float f7 = this.cornerRadius;
        float f10 = this.arrowHeight;
        path3.arcTo(new RectF(0.0f, (height - (f7 * f2)) + f10, f7 * f2, height + f10), 90.0f, 90.0f);
        this.path.lineTo(0.0f, this.cornerRadius + this.arrowHeight);
        Path path4 = this.path;
        float f11 = this.arrowHeight;
        float f12 = this.cornerRadius;
        path4.arcTo(new RectF(0.0f, f11, f12 * f2, (f12 * f2) + f11), 180.0f, 90.0f);
        this.path.close();
        canvas.save();
        canvas.clipPath(this.path);
        super/*android.widget.ImageView*/.onDraw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setArrowPosition(float position) {
        this.arrowPosition = RangesKt.k(position, 0.0f, getWidth());
        invalidate();
    }
}
