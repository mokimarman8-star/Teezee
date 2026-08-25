package com.transsion.search_pugc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/search_pugc/widget/HistoryFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxLines", BuildConfig.FLAVOR, "setMaxLines", "(I)V", "toggleExpanded", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", BuildConfig.FLAVOR, "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "a", "I", "Z", "isExpanded", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HistoryFlowLayout extends ViewGroup {

    /* renamed from: a, reason: from kotlin metadata */
    private int maxLines;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isExpanded;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HistoryFlowLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HistoryFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HistoryFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.maxLines = 3;
    }

    public /* synthetic */ HistoryFlowLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(HistoryFlowLayout historyFlowLayout, View view) {
        historyFlowLayout.toggleExpanded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(HistoryFlowLayout historyFlowLayout, View view) {
        historyFlowLayout.toggleExpanded();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = r - l;
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i3 >= childCount) {
                i2 = i8;
                break;
            }
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i4 + measuredWidth > i) {
                i5 += i6;
                i7++;
                if (!this.isExpanded && i7 >= this.maxLines) {
                    break;
                }
                i4 = 0;
                i6 = 0;
                i8 = 0;
            }
            int i9 = i8 + measuredWidth;
            childAt.layout(i8, i5, i9, i5 + measuredHeight);
            i4 += measuredWidth;
            i6 = Math.max(i6, measuredHeight);
            i3++;
            i8 = i9;
        }
        boolean z = this.isExpanded;
        if (!z && i7 >= this.maxLines) {
            Button button = new Button(getContext());
            button.setText("展开");
            button.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryFlowLayout.c(HistoryFlowLayout.this, view);
                }
            });
            addView(button);
            button.layout(i2, i5, button.getMeasuredWidth() + i2, button.getMeasuredHeight() + i5);
            return;
        }
        if (z) {
            Button button2 = new Button(getContext());
            button2.setText("收起");
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryFlowLayout.d(HistoryFlowLayout.this, view);
                }
            });
            addView(button2);
            button2.layout(i2, i5, button2.getMeasuredWidth() + i2, button2.getMeasuredHeight() + i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i2 >= childCount) {
                i = i5;
                break;
            }
            View childAt = getChildAt(i2);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i3 + measuredWidth > size) {
                i4 += i5;
                i6++;
                if (!this.isExpanded && i6 >= this.maxLines) {
                    break;
                }
                i3 = 0;
                i5 = 0;
            }
            i3 += measuredWidth;
            i5 = Math.max(i5, measuredHeight);
            i2++;
        }
        setMeasuredDimension(size, i4 + i);
    }

    public final void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
        requestLayout();
    }

    public final void toggleExpanded() {
        this.isExpanded = !this.isExpanded;
        requestLayout();
    }
}
