package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w extends BaseItemProvider {
    private final int e;
    private OperateItem f;
    private com.transsion.home.adapter.operateUGC.adapter.d g;
    private com.transsion.home.adapter.operateUGC.adapter.e h;
    private int i;

    public static final class a extends RecyclerView.r {
        final /* synthetic */ com.transsion.home.view.d a;
        final /* synthetic */ w b;
        final /* synthetic */ RecyclerView c;

        a(com.transsion.home.view.d dVar, w wVar, RecyclerView recyclerView) {
            this.a = dVar;
            this.b = wVar;
            this.c = recyclerView;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            View findSnapView;
            List data;
            Intrinsics.h(recyclerView, "recyclerView");
            if (i != 0 || (findSnapView = this.a.findSnapView(recyclerView.getLayoutManager())) == null) {
                return;
            }
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int position = layoutManager != null ? layoutManager.getPosition(findSnapView) : 0;
            com.transsion.home.adapter.operateUGC.adapter.e eVar = this.b.h;
            if (eVar != null) {
                eVar.C1(position);
            }
            this.b.i = position;
            if (position != 0) {
                com.transsion.home.adapter.operateUGC.adapter.e eVar2 = this.b.h;
                if (position != ((eVar2 == null || (data = eVar2.getData()) == null) ? -1 : data.size()) - 1) {
                    this.b.K(this.c, position);
                    return;
                }
            }
            this.c.scrollToPosition(position);
        }
    }

    public w(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, w wVar, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
        wVar.J(operateItem);
    }

    private final void F(RecyclerView recyclerView, RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        com.transsion.home.adapter.operateUGC.adapter.d dVar = new com.transsion.home.adapter.operateUGC.adapter.d(0, operateItem, this.e, 1, null);
        this.g = dVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        dVar.n1(rankingListData != null ? rankingListData.getItems() : null);
        recyclerView.setAdapter(this.g);
        recyclerView.scrollToPosition(this.i);
        recyclerView.setOnFlingListener((RecyclerView.p) null);
        com.transsion.home.view.d dVar2 = new com.transsion.home.view.d(com.blankj.utilcode.util.a0.a(12.0f));
        dVar2.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a(dVar2, this, recyclerView2));
    }

    private final void G(final RecyclerView recyclerView, final RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        com.transsion.home.adapter.operateUGC.adapter.e eVar = new com.transsion.home.adapter.operateUGC.adapter.e(0, 1, null);
        this.h = eVar;
        eVar.C1(this.i);
        com.transsion.home.adapter.operateUGC.adapter.e eVar2 = this.h;
        if (eVar2 != null) {
            RankingListData rankingListData = operateItem.getRankingListData();
            eVar2.n1(rankingListData != null ? rankingListData.getItems() : null);
        }
        com.transsion.home.adapter.operateUGC.adapter.e eVar3 = this.h;
        if (eVar3 != null) {
            eVar3.w1(new r6.d() { // from class: com.transsion.home.adapter.operateUGC.provider.v
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    w.H(w.this, recyclerView2, recyclerView, baseQuickAdapter, view, i);
                }
            });
        }
        recyclerView.setAdapter(this.h);
        recyclerView.scrollToPosition(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void H(w wVar, RecyclerView recyclerView, RecyclerView recyclerView2, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        com.transsion.home.adapter.operateUGC.adapter.e eVar;
        List data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        wVar.i = i;
        if (i != 0) {
            com.transsion.home.adapter.operateUGC.adapter.d dVar = wVar.g;
            if (i != ((dVar == null || (data = dVar.getData()) == null) ? -1 : data.size()) - 1) {
                wVar.K(recyclerView, i);
                eVar = wVar.h;
                if (eVar != null) {
                    eVar.C1(wVar.i);
                }
                recyclerView2.scrollToPosition(i);
            }
        }
        recyclerView.scrollToPosition(i);
        eVar = wVar.h;
        if (eVar != null) {
        }
        recyclerView2.scrollToPosition(i);
    }

    private final void I(OperateItem operateItem) {
        List data;
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

    private final void J(OperateItem operateItem) {
        List data;
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
        qi.h.a.o(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(RecyclerView recyclerView, int i) {
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i) : null;
        if (findViewByPosition == null) {
            recyclerView.scrollToPosition(i);
        } else {
            recyclerView.scrollBy(findViewByPosition.getLeft() - ((recyclerView.getWidth() / 2) - (findViewByPosition.getWidth() / 2)), 0);
        }
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        this.f = operateItem;
        baseViewHolder.setText(R.id.sub_operation_ranklist_title_text, operateItem.getTitle());
        baseViewHolder.getView(R.id.sub_operation_ranklist_title_linear).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.E(OperateItem.this, this, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.sub_operation_ranklist_recycler);
        RecyclerView recyclerView2 = (RecyclerView) baseViewHolder.getView(R.id.sub_operation_ranklist_title_tab_recycler);
        F(recyclerView, recyclerView2, operateItem);
        G(recyclerView2, recyclerView, operateItem);
        I(operateItem);
    }

    public int l() {
        return PostItemType.UGC_RANKING_LIST.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_rank_list;
    }
}
