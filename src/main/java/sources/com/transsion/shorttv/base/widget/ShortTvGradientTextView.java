package com.transsion.shorttv.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.noober.background.BackgroundFactory;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/shorttv/base/widget/ShortTvGradientTextView;", "Lcom/transsion/shorttv/base/widget/TnTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "c", "()V", "startColor", "centerColor", "endColor", "setGradientColors", "(III)V", BuildConfig.FLAVOR, "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "b", "I", "d", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvGradientTextView extends TnTextView {

    /* renamed from: b, reason: from kotlin metadata */
    private int startColor;

    /* renamed from: c, reason: from kotlin metadata */
    private int centerColor;

    /* renamed from: d, reason: from kotlin metadata */
    private int endColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShortTvGradientTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShortTvGradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ShortTvGradientTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.startColor = -65536;
        this.endColor = -16776961;
        BackgroundFactory.setViewBackground(context, attributeSet, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShortTvGradientTextView, 0, 0);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.startColor = obtainStyledAttributes.getColor(R.styleable.ShortTvGradientTextView_gradientTvStartColor, -1);
        this.centerColor = obtainStyledAttributes.getColor(R.styleable.ShortTvGradientTextView_gradientTvCenterColor, 0);
        this.endColor = obtainStyledAttributes.getColor(R.styleable.ShortTvGradientTextView_gradientTvEndColor, -1);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ ShortTvGradientTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c() {
        int i = this.centerColor;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, i == 0 ? new int[]{this.startColor, this.endColor} : new int[]{this.startColor, i, this.endColor}, (float[]) null, Shader.TileMode.CLAMP));
        invalidate();
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            c();
        }
    }

    public final void setGradientColors(int startColor, int centerColor, int endColor) {
        this.startColor = startColor;
        this.centerColor = centerColor;
        this.endColor = endColor;
        c();
    }
}
