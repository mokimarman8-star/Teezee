package com.transsion.ad.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.transsion.ad.R;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u001bR*\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010\u001bR*\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010\u001bR*\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010\u001bR\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00107¨\u00069"}, d2 = {"Lcom/transsion/ad/view/CustomRoundCornerLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "a", "()V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", BuildConfig.FLAVOR, "value", "F", "setAllCornerRadius", "(F)V", "allCornerRadius", "b", "getTopLeftRadius", "()F", "setTopLeftRadius", "topLeftRadius", "c", "getTopRightRadius", "setTopRightRadius", "topRightRadius", "d", "getBottomLeftRadius", "setBottomLeftRadius", "bottomLeftRadius", "e", "getBottomRightRadius", "setBottomRightRadius", "bottomRightRadius", "Landroid/graphics/Path;", "f", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "g", "Landroid/graphics/RectF;", "rect", BuildConfig.FLAVOR, "[F", "radii", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CustomRoundCornerLayout extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private float allCornerRadius;

    /* renamed from: b, reason: from kotlin metadata */
    private float topLeftRadius;

    /* renamed from: c, reason: from kotlin metadata */
    private float topRightRadius;

    /* renamed from: d, reason: from kotlin metadata */
    private float bottomLeftRadius;

    /* renamed from: e, reason: from kotlin metadata */
    private float bottomRightRadius;

    /* renamed from: f, reason: from kotlin metadata */
    private final Path path;

    /* renamed from: g, reason: from kotlin metadata */
    private final RectF rect;

    /* renamed from: h, reason: from kotlin metadata */
    private final float[] radii;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomRoundCornerLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomRoundCornerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomRoundCornerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.path = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        int[] iArr = R.styleable.CustomRoundCornerLayout;
        Intrinsics.g(iArr, "CustomRoundCornerLayout");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        setAllCornerRadius(obtainStyledAttributes.getDimension(R.styleable.CustomRoundCornerLayout_allCornerRadius, 0.0f));
        setTopLeftRadius(obtainStyledAttributes.getDimension(R.styleable.CustomRoundCornerLayout_topLeftRadius, this.allCornerRadius));
        setTopRightRadius(obtainStyledAttributes.getDimension(R.styleable.CustomRoundCornerLayout_topRightRadius, this.allCornerRadius));
        setBottomLeftRadius(obtainStyledAttributes.getDimension(R.styleable.CustomRoundCornerLayout_bottomLeftRadius, this.allCornerRadius));
        setBottomRightRadius(obtainStyledAttributes.getDimension(R.styleable.CustomRoundCornerLayout_bottomRightRadius, this.allCornerRadius));
        obtainStyledAttributes.recycle();
        a();
        setWillNotDraw(false);
    }

    public /* synthetic */ CustomRoundCornerLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        float[] fArr = this.radii;
        float f = this.topLeftRadius;
        if (f <= 0.0f) {
            f = this.allCornerRadius;
        }
        fArr[0] = f;
        fArr[1] = f;
        float f2 = this.topRightRadius;
        if (f2 <= 0.0f) {
            f2 = this.allCornerRadius;
        }
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = this.bottomRightRadius;
        if (f3 <= 0.0f) {
            f3 = this.allCornerRadius;
        }
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = this.bottomLeftRadius;
        if (f4 <= 0.0f) {
            f4 = this.allCornerRadius;
        }
        fArr[6] = f4;
        fArr[7] = f4;
    }

    private final void setAllCornerRadius(float f) {
        this.allCornerRadius = f;
        a();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public final float getBottomLeftRadius() {
        return this.bottomLeftRadius;
    }

    public final float getBottomRightRadius() {
        return this.bottomRightRadius;
    }

    public final float getTopLeftRadius() {
        return this.topLeftRadius;
    }

    public final float getTopRightRadius() {
        return this.topRightRadius;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.rect.set(0.0f, 0.0f, w, h);
        this.path.reset();
        this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
        this.path.close();
    }

    public final void setBottomLeftRadius(float f) {
        this.bottomLeftRadius = f;
        a();
        invalidate();
    }

    public final void setBottomRightRadius(float f) {
        this.bottomRightRadius = f;
        a();
        invalidate();
    }

    public final void setTopLeftRadius(float f) {
        this.topLeftRadius = f;
        a();
        invalidate();
    }

    public final void setTopRightRadius(float f) {
        this.topRightRadius = f;
        a();
        invalidate();
    }
}
