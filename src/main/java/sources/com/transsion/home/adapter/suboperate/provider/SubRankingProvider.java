package com.transsion.home.adapter.suboperate.provider;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.view.RankingAdapter;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubRankingProvider extends BaseItemProvider {
    private final int e;
    private t1 f;
    private OperateItem g;
    private BaseQuickAdapter h;

    public static final class a extends RecyclerView.l {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            int i = this.a;
            rect.left = i;
            rect.right = i;
            rect.top = this.b;
        }
    }

    public SubRankingProvider(int i) {
        this.e = i;
    }

    private final void D() {
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.e), true)) {
            this.f = kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubRankingProvider$registerCourse$1(this, null), 3, (Object) null);
        }
    }

    private final void E(Subject subject, int i, OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_ranking");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("tabId", String.valueOf(this.e));
        if (subject != null) {
            sk.b.d(subject, hashMap);
        }
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.a(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void F(Subject subject, int i, OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_ranking");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("tabId", String.valueOf(this.e));
        if (subject != null) {
            sk.b.d(subject, hashMap);
        }
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void G(BaseQuickAdapter baseQuickAdapter, final OperateItem operateItem) {
        baseQuickAdapter.w1(new r6.d() { // from class: com.transsion.home.adapter.suboperate.provider.n0
            public final void a(BaseQuickAdapter baseQuickAdapter2, View view, int i) {
                SubRankingProvider.H(OperateItem.this, this, baseQuickAdapter2, view, i);
            }
        });
        if (baseQuickAdapter instanceof com.transsion.home.adapter.suboperate.adapter.u) {
            ((com.transsion.home.adapter.suboperate.adapter.u) baseQuickAdapter).F1(new Function2() { // from class: com.transsion.home.adapter.suboperate.provider.o0
                public final Object invoke(Object obj, Object obj2) {
                    Unit I;
                    I = SubRankingProvider.I(SubRankingProvider.this, operateItem, ((Integer) obj).intValue(), (Subject) obj2);
                    return I;
                }
            });
        }
        this.h = baseQuickAdapter;
        this.g = operateItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(OperateItem operateItem, SubRankingProvider subRankingProvider, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<Subject> rankings = operateItem.getRankings();
        Subject subject = rankings != null ? rankings.get(i) : null;
        zk.h.f(subject, "op_ranking");
        subRankingProvider.F(subject, i, operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(SubRankingProvider subRankingProvider, OperateItem operateItem, int i, Subject subject) {
        Intrinsics.h(subject, "subject");
        subRankingProvider.E(subject, i, operateItem);
        return Unit.a;
    }

    private final void J() {
        t1 t1Var = this.f;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f = null;
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        BaseQuickAdapter rankingAdapter;
        List arrayList;
        RankingData rankingData;
        Integer perRow;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        baseViewHolder.setText(R.id.sub_operation_ranking_title, operateItem.getTitle());
        RecyclerView view = baseViewHolder.getView(R.id.sub_operation_ranking_recycler);
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new a(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(12.0f)));
        }
        List<Subject> rankings = operateItem.getRankings();
        int i = 0;
        int size = rankings != null ? rankings.size() : 0;
        int i2 = 1;
        if (!HomeTabId.INSTANCE.h(Integer.valueOf(this.e), true) || (rankingData = operateItem.getRankingData()) == null || (perRow = rankingData.getPerRow()) == null || perRow.intValue() != 2) {
            view.setLayoutManager(new NpaGridLayoutManager(k(), 3));
            List<Subject> rankings2 = operateItem.getRankings();
            r3 = rankings2 != null ? rankings2.subList(0, size - (size % 3)) : null;
            if (r3 == null || (arrayList = CollectionsKt.U0(r3)) == null) {
                arrayList = new ArrayList();
            }
            rankingAdapter = new RankingAdapter(arrayList);
        } else {
            view.setLayoutManager(new NpaGridLayoutManager(k(), 2));
            rankingAdapter = new com.transsion.home.adapter.suboperate.adapter.u(i, this.e, i2, r3);
            List<Subject> rankings3 = operateItem.getRankings();
            rankingAdapter.n1(rankings3 != null ? rankings3.subList(0, size - (size % 2)) : null);
        }
        G(rankingAdapter, operateItem);
        view.setAdapter(rankingAdapter);
    }

    public int l() {
        return PostItemType.OP_RANKING.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_ranking;
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        D();
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        J();
    }
}
