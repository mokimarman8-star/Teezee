package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubRankListProvider extends BaseItemProvider {
    private final int e;
    private t1 f;
    private OperateItem g;
    private com.transsion.home.adapter.suboperate.adapter.r h;
    private com.transsion.home.adapter.suboperate.adapter.s i;
    private int j;

    public static final class a extends RecyclerView.r {
        final /* synthetic */ androidx.recyclerview.widget.n a;
        final /* synthetic */ SubRankListProvider b;
        final /* synthetic */ RecyclerView c;

        a(androidx.recyclerview.widget.n nVar, SubRankListProvider subRankListProvider, RecyclerView recyclerView) {
            this.a = nVar;
            this.b = subRankListProvider;
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
            com.transsion.home.adapter.suboperate.adapter.s sVar = this.b.i;
            if (sVar != null) {
                sVar.C1(position);
            }
            this.b.j = position;
            if (position != 0) {
                com.transsion.home.adapter.suboperate.adapter.s sVar2 = this.b.i;
                if (position != ((sVar2 == null || (data = sVar2.getData()) == null) ? -1 : data.size()) - 1) {
                    this.b.L(this.c, position);
                    return;
                }
            }
            this.c.scrollToPosition(position);
        }
    }

    public SubRankListProvider(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(OperateItem operateItem, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
    }

    private final void H(RecyclerView recyclerView, RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        com.transsion.home.adapter.suboperate.adapter.r rVar = new com.transsion.home.adapter.suboperate.adapter.r(0, operateItem, this.e, 1, null);
        this.h = rVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        rVar.n1(rankingListData != null ? rankingListData.getItems() : null);
        recyclerView.setAdapter(this.h);
        recyclerView.scrollToPosition(this.j);
        recyclerView.setOnFlingListener((RecyclerView.p) null);
        androidx.recyclerview.widget.n nVar = new androidx.recyclerview.widget.n();
        nVar.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a(nVar, this, recyclerView2));
    }

    private final void I(final RecyclerView recyclerView, final RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        com.transsion.home.adapter.suboperate.adapter.s sVar = new com.transsion.home.adapter.suboperate.adapter.s(0, 1, null);
        this.i = sVar;
        sVar.C1(this.j);
        com.transsion.home.adapter.suboperate.adapter.s sVar2 = this.i;
        if (sVar2 != null) {
            RankingListData rankingListData = operateItem.getRankingListData();
            sVar2.n1(rankingListData != null ? rankingListData.getItems() : null);
        }
        com.transsion.home.adapter.suboperate.adapter.s sVar3 = this.i;
        if (sVar3 != null) {
            sVar3.w1(new r6.d() { // from class: com.transsion.home.adapter.suboperate.provider.m0
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    SubRankListProvider.J(SubRankListProvider.this, recyclerView2, recyclerView, baseQuickAdapter, view, i);
                }
            });
        }
        recyclerView.setAdapter(this.i);
        recyclerView.scrollToPosition(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void J(SubRankListProvider subRankListProvider, RecyclerView recyclerView, RecyclerView recyclerView2, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        com.transsion.home.adapter.suboperate.adapter.s sVar;
        List data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        subRankListProvider.j = i;
        if (i != 0) {
            com.transsion.home.adapter.suboperate.adapter.r rVar = subRankListProvider.h;
            if (i != ((rVar == null || (data = rVar.getData()) == null) ? -1 : data.size()) - 1) {
                subRankListProvider.L(recyclerView, i);
                sVar = subRankListProvider.i;
                if (sVar != null) {
                    sVar.C1(subRankListProvider.j);
                }
                recyclerView2.scrollToPosition(i);
            }
        }
        recyclerView.scrollToPosition(i);
        sVar = subRankListProvider.i;
        if (sVar != null) {
        }
        recyclerView2.scrollToPosition(i);
    }

    private final void K() {
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.e), true)) {
            this.f = kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubRankListProvider$registerCourse$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(RecyclerView recyclerView, int i) {
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i) : null;
        if (findViewByPosition == null) {
            recyclerView.scrollToPosition(i);
        } else {
            recyclerView.scrollBy(findViewByPosition.getLeft() - ((recyclerView.getWidth() / 2) - (findViewByPosition.getWidth() / 2)), 0);
        }
    }

    private final void M() {
        t1 t1Var = this.f;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f = null;
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        this.g = operateItem;
        baseViewHolder.setText(R.id.sub_operation_ranklist_title_text, operateItem.getTitle());
        baseViewHolder.getView(R.id.sub_operation_ranklist_title_linear).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubRankListProvider.G(OperateItem.this, view);
            }
        });
        View view = baseViewHolder.getView(R.id.sub_operation_ranklist_all);
        String deepLink = operateItem.getDeepLink();
        view.setVisibility((deepLink == null || deepLink.length() == 0) ? 4 : 0);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.sub_operation_ranklist_recycler);
        RecyclerView recyclerView2 = (RecyclerView) baseViewHolder.getView(R.id.sub_operation_ranklist_title_tab_recycler);
        H(recyclerView, recyclerView2, operateItem);
        I(recyclerView2, recyclerView, operateItem);
    }

    public int l() {
        return PostItemType.RANKING_LIST.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_rank_list;
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        K();
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        M();
    }
}
