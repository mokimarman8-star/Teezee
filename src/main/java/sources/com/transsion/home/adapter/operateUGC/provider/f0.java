package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.adapter.UGCOptFeedsListAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 extends BaseItemProvider {
    private final int e;

    public f0(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(f0 f0Var, OperateItem operateItem, View view) {
        f0Var.D(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(f0 f0Var, OperateItem operateItem, View view) {
        f0Var.D(operateItem);
    }

    private final void D(OperateItem operateItem) {
        List data;
        String deepLink = operateItem.getDeepLink();
        Integer num = null;
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
        BaseProviderMultiAdapter g = g();
        if (g != null && (data = g.getData()) != null) {
            num = Integer.valueOf(data.indexOf(operateItem));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "all");
        hashMap.put("position", String.valueOf(num));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("title", title);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        qi.h.a.o(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        List data;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.provider_ugc_common_title);
        textView.setText(operateItem.getTitle());
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.provider_ugc_common_more_text);
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            uf.c.h(textView2);
        } else {
            uf.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f0.B(f0.this, operateItem, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f0.C(f0.this, operateItem, view);
                }
            });
        }
        RecyclerView view = baseViewHolder.getView(R.id.provider_ugc_common_recycler);
        UGCOptFeedsListAdapter uGCOptFeedsListAdapter = new UGCOptFeedsListAdapter(operateItem, this.e);
        view.setAdapter(uGCOptFeedsListAdapter);
        view.setLayoutManager(new LinearLayoutManager(k(), 1, false));
        view.setNestedScrollingEnabled(false);
        uGCOptFeedsListAdapter.n1(operateItem.getContentList());
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "all");
        BaseProviderMultiAdapter g = g();
        hashMap.put("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("title", title);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        qi.h.a.z(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    public int l() {
        return PostItemType.UGC_VERTICAL_OPT_LIST.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_op_common;
    }
}
