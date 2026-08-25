package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.cloud.hisavana.sdk.b4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002\u0018\u001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0019¨\u0006!"}, d2 = {"Lcom/cloud/hisavana/sdk/common/widget/InteractiveFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "", "scale", "", "setScale", "(Ljava/lang/String;)V", "Lcom/cloud/hisavana/sdk/common/widget/InteractiveFrameLayout$a;", "globalLayoutListener", "registerGlobalLayoutListener", "(Lcom/cloud/hisavana/sdk/common/widget/InteractiveFrameLayout$a;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "a", "Ljava/lang/String;", "TAG", "b", "I", "widthScale", "c", "heightScale", "d", "api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class InteractiveFrameLayout extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private int widthScale;

    /* renamed from: c, reason: from kotlin metadata */
    private int heightScale;

    /* renamed from: d, reason: from kotlin metadata */
    private String scale;

    public interface a {
        void a(int i, int i2);
    }

    public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private final a a;

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = InteractiveFrameLayout.this.getWidth();
            int height = InteractiveFrameLayout.this.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            ViewTreeObserver viewTreeObserver = InteractiveFrameLayout.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(width, height);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InteractiveFrameLayout(Context context) {
        this(context, null, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractiveFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.TAG = "InteractiveFrameLayout";
    }

    public /* synthetic */ InteractiveFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.widthScale <= 0 || this.heightScale <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        b4.b().d(this.TAG, "widthSpecMode is " + mode + ", heightSpecMode is heightSpecMode");
        if (mode == 1073741824 && mode2 == 1073741824) {
            int i = this.widthScale;
            int i2 = i * size2;
            int i3 = this.heightScale;
            int i4 = size * i3;
            if (i2 < i4) {
                size = i2 / i3;
            } else if (i2 > i4) {
                size2 = i4 / i;
            }
            b4.b().w(this.TAG, "width 1 is " + size + ", height is " + size2);
        } else if (mode2 == 1073741824) {
            int i8 = this.widthScale;
            int i9 = this.heightScale;
            int i10 = (size2 * i8) / i9;
            if (mode != Integer.MIN_VALUE || i10 <= size) {
                size = i10;
            } else {
                size2 = (i9 * size) / i8;
            }
            b4.b().w(this.TAG, "width 3 is " + size + ", height is " + size2);
        } else if (mode == 1073741824) {
            int i11 = this.heightScale;
            int i12 = this.widthScale;
            int i13 = (size * i11) / i12;
            if (mode2 != Integer.MIN_VALUE || i13 <= size2) {
                size2 = i13;
            } else {
                size = (i12 * size2) / i11;
            }
            b4.b().w(this.TAG, "width 2 is " + size + ", height is " + size2);
        } else {
            if (size > 0 || size2 > 0) {
                int i14 = this.widthScale;
                int i15 = size / i14;
                int i16 = this.heightScale;
                if (i15 >= size2 / i16) {
                    size = (i14 * size2) / i16;
                } else {
                    size2 = (i16 * size) / i14;
                }
            }
            b4.b().w(this.TAG, "width 4 is " + size + ", height is " + size2);
        }
        setMeasuredDimension(size, size2);
    }

    public final void registerGlobalLayoutListener(a globalLayoutListener) {
        getViewTreeObserver().addOnGlobalLayoutListener(new b(globalLayoutListener));
    }

    public final void setScale(String scale) {
        if (TextUtils.equals(this.scale, scale)) {
            return;
        }
        if (scale != null) {
            try {
                if (!new Regex("^[1-9]\\d*:[1-9]\\d*$").matches(scale)) {
                    return;
                }
                List S0 = StringsKt.S0(scale, new String[]{":"}, false, 0, 6, (Object) null);
                if (S0.size() < 2) {
                    return;
                }
                this.widthScale = Integer.parseInt((String) S0.get(0));
                this.heightScale = Integer.parseInt((String) S0.get(1));
                requestLayout();
            } catch (Exception e) {
                b4.b().w(this.TAG, "scale is " + scale + ", error meg is " + e.getMessage());
                return;
            }
        }
        b4.b().w(this.TAG, "width is " + this.widthScale + ", height is " + this.heightScale);
    }
}
