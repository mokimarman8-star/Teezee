package com.transsion.subroom.guide;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.a0;
import com.transsion.subroom.R;
import com.transsion.subroom.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/transsion/subroom/guide/Indicator;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "selectIndex", "", "d", "(I)V", "select", "a", "I", "size", "b", "c", "horizontalMargin", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class Indicator extends LinearLayoutCompat {

    /* renamed from: a, reason: from kotlin metadata */
    private int size;

    /* renamed from: b, reason: from kotlin metadata */
    private int selectIndex;

    /* renamed from: c, reason: from kotlin metadata */
    private int horizontalMargin;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Indicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Indicator);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.size = obtainStyledAttributes.getInteger(R$styleable.Indicator_CustomIndicatorSize, 0);
        this.horizontalMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Indicator_CustomHorizontalMargin, 0);
        int integer = obtainStyledAttributes.getInteger(R$styleable.Indicator_CustomSelectedIndex, 0);
        this.selectIndex = integer;
        int i2 = this.size;
        if (integer >= i2) {
            this.selectIndex = 0;
        }
        int i3 = 0;
        while (i3 < i2) {
            View view = new View(context);
            LinearLayoutCompat.a aVar = new LinearLayoutCompat.a(a0.a(6.0f), a0.a(6.0f));
            aVar.setMarginStart(i3 == 0 ? 0 : this.horizontalMargin);
            view.setLayoutParams(aVar);
            if (i3 == this.selectIndex) {
                view.setBackgroundResource(R.drawable.guide_selected_dot);
            } else {
                view.setBackgroundResource(R.drawable.guide_unselected_dot);
            }
            addView(view);
            i3++;
        }
        obtainStyledAttributes.recycle();
    }

    private final void d(int selectIndex) {
        if (selectIndex >= getChildCount()) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i == selectIndex) {
                childAt.setBackgroundResource(R.drawable.guide_selected_dot);
            } else {
                childAt.setBackgroundResource(R.drawable.guide_unselected_dot);
            }
        }
    }

    public final void select(int selectIndex) {
        d(selectIndex);
    }
}
