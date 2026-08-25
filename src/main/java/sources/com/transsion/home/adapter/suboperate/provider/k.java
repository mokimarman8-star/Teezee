package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.suboperate.adapter.SubCustomAdapter;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends BaseItemProvider {
    private final int e;
    private final boolean f;

    public k(int i, boolean z) {
        this.e = i;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(OperateItem operateItem, k kVar, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<BannerData> items;
        BannerData bannerData;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        CustomData customData = operateItem.getCustomData();
        if (customData == null || (items = customData.getItems()) == null || (bannerData = items.get(i)) == null) {
            return;
        }
        kVar.D(bannerData, operateItem.getOpId());
        kVar.C(bannerData, i, operateItem);
    }

    private final void B(OperateItem operateItem) {
        String str;
        String opId;
        String title;
        List data;
        boolean b = ij.g.a.b();
        String str2 = BuildConfig.FLAVOR;
        if (b) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "all");
            BaseProviderMultiAdapter g = g();
            hashMap.put("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(CollectionsKt.n0(data, operateItem))));
            if (operateItem != null && (title = operateItem.getTitle()) != null) {
                str2 = title;
            }
            hashMap.put("title", str2);
            hashMap.put("tabId", String.valueOf(this.e));
            if (operateItem != null) {
                sk.b.a(operateItem, hashMap);
            }
            qi.h.a.z(SubTabFragment.INSTANCE.a(this.e), hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event_type", "browse_custom");
        if (operateItem == null || (str = operateItem.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap2.put("title", str);
        if (operateItem != null && (opId = operateItem.getOpId()) != null) {
            str2 = opId;
        }
        hashMap2.put("opId", str2);
        hashMap2.put("tabId", String.valueOf(this.e));
        if (operateItem != null) {
            sk.b.a(operateItem, hashMap2);
        }
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap2);
    }

    private final void C(BannerData bannerData, int i, OperateItem operateItem) {
        if (ij.g.a.b()) {
            rk.d.c.b(this.e, i, operateItem, bannerData);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_custom_item");
        hashMap.put("sequence", String.valueOf(i));
        CustomData customData = operateItem.getCustomData();
        hashMap.put("rowCount", String.valueOf(customData != null ? Integer.valueOf(customData.getRowCount()) : null));
        hashMap.put("tabId", String.valueOf(this.e));
        if (bannerData != null) {
            sk.b.b(bannerData, hashMap);
        }
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void D(BannerData bannerData, String str) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            ij.k.g(deepLink, "&module_name=opt_custom&from_opt_id=" + str + "&ops=" + bannerData.getOps() + "&tab_id=" + this.e);
        }
    }

    public int l() {
        return PostItemType.CUSTOM_DATA.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_variable;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        List<BannerData> items;
        List<BannerData> items2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ((TextView) baseViewHolder.getView(R.id.sub_operation_variable_title)).setText(operateItem.getTitle());
        RecyclerView view = baseViewHolder.getView(R.id.sub_operation_variable_recycle);
        CustomData customData = operateItem.getCustomData();
        CustomData customData2 = operateItem.getCustomData();
        SubCustomAdapter subCustomAdapter = new SubCustomAdapter(0, operateItem, customData, (customData2 == null || (items2 = customData2.getItems()) == null) ? null : items2.get(0), this.e, this.f, 1, null);
        view.setAdapter(subCustomAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        CustomData customData3 = operateItem.getCustomData();
        subCustomAdapter.n1((customData3 == null || (items = customData3.getItems()) == null) ? new ArrayList() : items);
        subCustomAdapter.w1(new r6.d() { // from class: com.transsion.home.adapter.suboperate.provider.j
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                k.A(OperateItem.this, this, baseQuickAdapter, view2, i);
            }
        });
        B(operateItem);
    }
}
