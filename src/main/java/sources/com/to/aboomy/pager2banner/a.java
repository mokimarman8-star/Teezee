package com.to.aboomy.pager2banner;

import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface a {
    RelativeLayout.LayoutParams getParams();

    View getView();

    void initIndicatorCount(int i, int i2);

    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, int i2);

    void onPageSelected(int i);
}
