package com.transsion.member.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/transsion/member/view/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", BuildConfig.FLAVOR, "onDraw", "(Landroid/graphics/Canvas;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "a", "I", "startColor", "b", "endColor", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GradientTextView extends AppCompatTextView {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private int startColor;

    /* renamed from: b, reason: from kotlin metadata */
    private int endColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.startColor = -16777216;
        this.endColor = -16777216;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientTextView);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.startColor = obtainStyledAttributes.getColor(R$styleable.GradientTextView_startColor, -16777216);
        this.endColor = obtainStyledAttributes.getColor(R$styleable.GradientTextView_endColor, -16777216);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ GradientTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        Intrinsics.h(canvas, "canvas");
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, this.startColor, this.endColor, Shader.TileMode.CLAMP));
        super/*android.widget.TextView*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super/*android.widget.TextView*/.onSizeChanged(w, h, oldw, oldh);
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, w, 0.0f, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }
}
