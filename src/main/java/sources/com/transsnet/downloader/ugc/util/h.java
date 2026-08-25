package com.transsnet.downloader.ugc.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import bx.d1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsnet.downloader.R;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class h {
    public static final void b(View view, List dataList, final Function1 itemClickCallback) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(itemClickCallback, "itemClickCallback");
        Context context = view.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ugc_layout_resolution_pop, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        d1 a = d1.a(inflate);
        Intrinsics.g(a, "bind(...)");
        a.b.setLayoutManager(new NpaLinearLayoutManager(context, 1, false));
        RecyclerView recyclerView = a.b;
        f fVar = new f(dataList);
        fVar.w1(new r6.d() { // from class: com.transsnet.downloader.ugc.util.g
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                h.c(popupWindow, itemClickCallback, baseQuickAdapter, view2, i);
            }
        });
        recyclerView.setAdapter(fVar);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(view, view.getWidth() - lj.a.b(140), lj.a.b(4), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopupWindow popupWindow, Function1 function1, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
            return;
        }
        Object item = adapter.getItem(i);
        UGCDownloadResolutionBean uGCDownloadResolutionBean = item instanceof UGCDownloadResolutionBean ? (UGCDownloadResolutionBean) item : null;
        if (uGCDownloadResolutionBean != null) {
            function1.invoke(uGCDownloadResolutionBean);
        }
        popupWindow.dismiss();
    }
}
