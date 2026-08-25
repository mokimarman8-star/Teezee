package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import wy.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
    public void onDeselected(int i, int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
    public void onEnter(int i, int i2, float f, boolean z) {
        setTextColor(a.a(f, this.b, this.a));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
    public void onLeave(int i, int i2, float f, boolean z) {
        setTextColor(a.a(f, this.a, this.b));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
    public void onSelected(int i, int i2) {
    }
}
