package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.transsion.baseui.R$styleable;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PileLayout extends ViewGroup {
    protected float a;
    protected float b;

    public PileLayout(Context context) {
        this(context, null, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PileLayout);
        this.a = obtainStyledAttributes.getDimension(R$styleable.PileLayout_PileLayout_vertivalSpace, dp2px(4.0f));
        this.b = obtainStyledAttributes.getDimension(R$styleable.PileLayout_PileLayout_pileWidth, dp2px(10.0f));
        obtainStyledAttributes.recycle();
    }

    public float dp2px(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
                if (paddingLeft + measuredWidth + getPaddingRight() > i5) {
                    paddingLeft = getPaddingLeft();
                    paddingTop = (int) (paddingTop + i6 + this.a);
                    i6 = 0;
                    i7 = 0;
                }
                int i9 = marginLayoutParams.leftMargin;
                childAt.layout(paddingLeft + i9, marginLayoutParams.topMargin + paddingTop, i9 + paddingLeft + childAt.getMeasuredWidth(), marginLayoutParams.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth;
                int measuredHeight = marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
                if (i7 != childCount - 1) {
                    paddingLeft = (int) (paddingLeft - this.b);
                }
                i6 = Math.max(i6, measuredHeight);
                i7++;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                if (i6 == childCount - 1) {
                    i5 += i4;
                    i7 = Math.max(i7, i8);
                }
                i3 = size2;
            } else {
                int i10 = i4;
                i3 = size2;
                int i11 = i5;
                measureChildWithMargins(childAt, i, 0, i2, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i12 = i8 + measuredWidth;
                float f = i12;
                if (f - (i9 > 0 ? this.b : 0.0f) > (size - getPaddingLeft()) - getPaddingRight()) {
                    i7 = Math.max(i7, i8);
                    i5 = (int) (i11 + i10 + this.a);
                    i8 = measuredWidth;
                    i4 = measuredHeight;
                    i9 = 0;
                } else {
                    if (i9 > 0) {
                        i12 = (int) (f - this.b);
                    }
                    i8 = i12;
                    i4 = Math.max(i10, measuredHeight);
                    i5 = i11;
                }
                if (i6 == childCount - 1) {
                    i5 += i4;
                    i7 = Math.max(i8, i7);
                }
                i9++;
            }
            i6++;
            size2 = i3;
        }
        int i13 = size2;
        int i14 = i5;
        if (mode != 1073741824) {
            size = i7 + getPaddingLeft() + getPaddingRight();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i13 : i14 + getPaddingTop() + getPaddingBottom());
    }
}
