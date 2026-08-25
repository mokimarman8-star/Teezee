package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class CommonPagerTitleView extends FrameLayout implements xy.b {

    public interface a {
    }

    public interface b {
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    @Override // xy.b
    public int getContentBottom() {
        return getBottom();
    }

    @Override // xy.b
    public int getContentLeft() {
        return getLeft();
    }

    public a getContentPositionDataProvider() {
        return null;
    }

    @Override // xy.b
    public int getContentRight() {
        return getRight();
    }

    @Override // xy.b
    public int getContentTop() {
        return getTop();
    }

    public b getOnPagerTitleChangeListener() {
        return null;
    }

    @Override // xy.d
    public void onDeselected(int i, int i2) {
    }

    @Override // xy.d
    public void onEnter(int i, int i2, float f, boolean z) {
    }

    @Override // xy.d
    public void onLeave(int i, int i2, float f, boolean z) {
    }

    @Override // xy.d
    public void onSelected(int i, int i2) {
    }

    public void setContentPositionDataProvider(a aVar) {
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null), null);
    }

    public void setContentView(View view) {
        setContentView(view, null);
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setOnPagerTitleChangeListener(b bVar) {
    }
}
