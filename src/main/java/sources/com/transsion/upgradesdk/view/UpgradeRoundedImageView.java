package com.transsion.upgradesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.upgradesdk.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/upgradesdk/view/UpgradeRoundedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", HttpUrl.FRAGMENT_ENCODE_SET, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "upgradesdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UpgradeRoundedImageView extends AppCompatImageView {
    public final float a;
    public final float b;
    public final Paint c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpgradeRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.b = 1.5f;
        Paint paint = new Paint(1);
        this.c = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UpgradeSdkRoundedImageView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.a = obtainStyledAttributes.getDimension(R$styleable.UpgradeSdkRoundedImageView_cornerRadius, 10.0f);
        obtainStyledAttributes.recycle();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(335544320);
        paint.setStrokeWidth(1.5f);
    }

    public /* synthetic */ UpgradeRoundedImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super/*android.widget.ImageView*/.onDraw(canvas);
        float f2 = this.b;
        if (f2 > 0.0f) {
            float f3 = f2 / 2.0f;
            RectF rectF2 = new RectF(f3, f3, getWidth() - f3, getHeight() - f3);
            float f4 = this.a;
            canvas.drawRoundRect(rectF2, f4, f4, this.c);
        }
    }
}
