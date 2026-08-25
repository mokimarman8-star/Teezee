package com.transsion.ugcvideodetail.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ugcvideodetail.R$styleable;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/ugcvideodetail/widget/TopCropShapeableImageView;", "Lcom/google/android/material/imageview/ShapeableImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "i", "()V", "dp", "j", "(I)I", "setMaxHeightDp", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "l", "t", "r", "b", HttpUrl.FRAGMENT_ENCODE_SET, "setFrame", "(IIII)Z", "w", "I", "maxHeightPx", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class TopCropShapeableImageView extends ShapeableImageView {

    /* renamed from: w, reason: from kotlin metadata */
    private int maxHeightPx;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCropShapeableImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCropShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public TopCropShapeableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TopCropImageView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.maxHeightPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TopCropImageView_maxHeightDp, j(Sdk$SDKError.Reason.INVALID_EVENT_ID_ERROR_VALUE));
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ TopCropShapeableImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        drawable.getIntrinsicHeight();
        float width = getWidth() / intrinsicWidth;
        Matrix matrix = new Matrix();
        matrix.postScale(width, width);
        matrix.postTranslate(0.0f, 0.0f);
        setImageMatrix(matrix);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int j(int dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getDrawable() == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        float size = View.MeasureSpec.getSize(widthMeasureSpec);
        int intrinsicHeight = (int) (r0.getIntrinsicHeight() * (size / r0.getIntrinsicWidth()));
        int i = this.maxHeightPx;
        if (intrinsicHeight > i) {
            intrinsicHeight = i;
        }
        setMeasuredDimension((int) size, intrinsicHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean setFrame(int l, int t, int r, int b) {
        i();
        return super/*android.widget.ImageView*/.setFrame(l, t, r, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaxHeightDp(int dp) {
        this.maxHeightPx = j(dp);
        requestLayout();
    }
}
