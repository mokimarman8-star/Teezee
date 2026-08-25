package com.mbridge.msdk.nativex.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.mbridge.msdk.nativex.view.MBNativeRollView;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class RollingAdapter extends PagerAdapter {
    private List<Frame> list;
    private List<View> listview = new ArrayList();
    private MBNativeRollView.a mvinterface;

    public RollingAdapter(List<Frame> list) {
        this.list = new ArrayList();
        this.list = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.listview.get(i));
    }

    public int getCount() {
        return this.list.size();
    }

    public MBNativeRollView.a getMvinterface() {
        return null;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return null;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setMvinterface(MBNativeRollView.a aVar) {
    }
}
