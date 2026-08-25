package com.transsion.shorttv.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.NpaLinearLayoutManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qr.l0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class l {
    private static final List a = CollectionsKt.q(new ShortTvVideoCtrBean[]{new ShortTvVideoCtrBean(0.5f, "0.5x"), new ShortTvVideoCtrBean(0.75f, "0.75x"), new ShortTvVideoCtrBean(1.0f, "1x"), new ShortTvVideoCtrBean(1.25f, "1.25x"), new ShortTvVideoCtrBean(1.5f, "1.5x"), new ShortTvVideoCtrBean(1.75f, "1.75x"), new ShortTvVideoCtrBean(2.0f, "2x")});

    public static final List b() {
        return a;
    }

    public static final void c(View view, List dataList, final Function1 itemClickCallback) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(itemClickCallback, "itemClickCallback");
        Context context = view.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.short_tv_layout_video_pop, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        l0 a2 = l0.a(inflate);
        Intrinsics.g(a2, "bind(...)");
        a2.b.setLayoutManager(new NpaLinearLayoutManager(context, 1, false));
        RecyclerView recyclerView = a2.b;
        j jVar = new j(dataList);
        jVar.w1(new r6.d() { // from class: com.transsion.shorttv.utils.k
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                l.d(popupWindow, itemClickCallback, baseQuickAdapter, view2, i);
            }
        });
        recyclerView.setAdapter(jVar);
        popupWindow.setOutsideTouchable(true);
        int a3 = (cr.a.a(38) * dataList.size()) + cr.a.a(4);
        popupWindow.showAsDropDown(view, (view.getWidth() - cr.a.a(80)) / 2, (-view.getHeight()) - a3, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopupWindow popupWindow, Function1 function1, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (hr.d.a.a(view.getId(), 1000L)) {
            return;
        }
        Object item = adapter.getItem(i);
        ShortTvVideoCtrBean shortTvVideoCtrBean = item instanceof ShortTvVideoCtrBean ? (ShortTvVideoCtrBean) item : null;
        if (shortTvVideoCtrBean != null) {
            function1.invoke(shortTvVideoCtrBean);
        }
        popupWindow.dismiss();
    }
}
