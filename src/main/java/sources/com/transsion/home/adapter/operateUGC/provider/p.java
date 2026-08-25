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
import com.transsion.home.adapter.operateUGC.adapter.MovieRankUGCAdapter;
import com.transsion.home.adapter.operateUGC.provider.p;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p extends BaseItemProvider {
    private final int e;
    private final boolean f;
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.m
        public final Object invoke() {
            p.a E;
            E = p.E();
            return E;
        }
    });

    public static final class a extends RecyclerView.s {
        a() {
            m(0, 16);
        }
    }

    public p(int i, boolean z) {
        this.e = i;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(p pVar, OperateItem operateItem, View view) {
        pVar.G(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(p pVar, OperateItem operateItem, View view) {
        pVar.G(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a E() {
        return new a();
    }

    private final a F() {
        return (a) this.g.getValue();
    }

    private final void G(OperateItem operateItem) {
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

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.C(p.this, operateItem, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.D(p.this, operateItem, view);
                }
            });
        }
        RecyclerView view = baseViewHolder.getView(R.id.provider_ugc_common_recycler);
        MovieRankUGCAdapter movieRankUGCAdapter = new MovieRankUGCAdapter(0, operateItem, this.e, this.f, 1, null);
        view.setAdapter(movieRankUGCAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        Intrinsics.c(view.getRecycledViewPool(), F());
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        movieRankUGCAdapter.n1(operateItem.getContentList());
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
        return PostItemType.UGC_MOVIE_RANK.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_op_common;
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
    }
}
