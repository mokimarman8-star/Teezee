package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RatioFrameLayout extends FrameLayout {
    public float OooO00o;
    public float OooO0O0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RatioFrameLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RatioFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioFrameLayout);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…yleable.RatioFrameLayout)");
        String string = obtainStyledAttributes.getString(R.styleable.RatioFrameLayout_sizeRatio);
        if (!TextUtils.isEmpty(string)) {
            Intrinsics.e(string);
            String[] strArr = (String[]) StringsKt.S0(string, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
            int length = strArr.length;
            if (length == 1) {
                this.OooO00o = Float.parseFloat(strArr[0]);
                this.OooO0O0 = 1.0f;
            } else {
                if (length != 2) {
                    throw new IllegalArgumentException("are you ok?");
                }
                this.OooO00o = Float.parseFloat(strArr[0]);
                this.OooO0O0 = Float.parseFloat(strArr[1]);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ RatioFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final float getHeightRatio() {
        return this.OooO0O0;
    }

    public final float getSizeRatio() {
        return this.OooO00o / this.OooO0O0;
    }

    public final float getWidthRatio() {
        return this.OooO00o;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.OooO00o != 0.0f && this.OooO0O0 != 0.0f) {
            float sizeRatio = getSizeRatio();
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (getLayoutParams().width != -2 && getLayoutParams().height != -2 && mode == 1073741824 && mode2 == 1073741824) {
                float f = size;
                float f2 = f / sizeRatio;
                float f3 = size2;
                if (f2 <= f3) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) f2, MemoryConstants.GB);
                } else {
                    float f4 = f3 * sizeRatio;
                    if (f4 <= f) {
                        i = View.MeasureSpec.makeMeasureSpec((int) f4, MemoryConstants.GB);
                    }
                }
            } else if (getLayoutParams().width != -2 && mode == 1073741824 && mode2 != 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (size / sizeRatio), MemoryConstants.GB);
            } else if (getLayoutParams().height != -2 && mode2 == 1073741824 && mode != 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec((int) (size2 * sizeRatio), MemoryConstants.GB);
            }
        }
        super.onMeasure(i, i2);
    }
}
