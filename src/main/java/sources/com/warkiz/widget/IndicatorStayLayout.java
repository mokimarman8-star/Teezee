package com.warkiz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class IndicatorStayLayout extends LinearLayout {
    public IndicatorStayLayout(Context context) {
        this(context, null);
    }

    public IndicatorStayLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorStayLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
    }

    private void a(View view, int i) {
        if (view instanceof IndicatorSeekBar) {
            IndicatorSeekBar indicatorSeekBar = (IndicatorSeekBar) view;
            indicatorSeekBar.setIndicatorStayAlways(true);
            View indicatorContentView = indicatorSeekBar.getIndicatorContentView();
            if (indicatorContentView == null) {
                throw new IllegalStateException("Can not find any indicator in the IndicatorSeekBar, please make sure you have called the attr: SHOW_INDICATOR_TYPE for IndicatorSeekBar and the value is not IndicatorType.NONE.");
            }
            if (indicatorContentView instanceof IndicatorSeekBar) {
                throw new IllegalStateException("IndicatorSeekBar can not be a contentView for Indicator in case this inflating loop.");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, g.a(indicatorSeekBar.getContext(), 2.0f) - indicatorSeekBar.getPaddingTop());
            addView(indicatorContentView, i, marginLayoutParams);
            indicatorSeekBar.Y();
        }
    }

    public void attachTo(IndicatorSeekBar indicatorSeekBar) {
        attachTo(indicatorSeekBar, -2);
    }

    public void attachTo(IndicatorSeekBar indicatorSeekBar, int i) {
        if (indicatorSeekBar == null) {
            throw new NullPointerException("the seek bar wanna attach to IndicatorStayLayout can not be null value.");
        }
        a(indicatorSeekBar, i);
        addView(indicatorSeekBar, i + 1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount), childCount);
        }
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("IndicatorStayLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }
}
