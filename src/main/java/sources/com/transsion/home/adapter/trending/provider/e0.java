package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.transsion.home.adapter.trending.provider.e0;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 extends BaseItemProvider {
    private final int e;
    private final boolean f;
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.d0
        public final Object invoke() {
            e0.b I;
            I = e0.I();
            return I;
        }
    });

    public static final class a extends DiffUtil.e {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(LiveListItem liveListItem, LiveListItem liveListItem2) {
            Intrinsics.h(liveListItem, "oldItem");
            Intrinsics.h(liveListItem2, "newItem");
            return Intrinsics.c(liveListItem.getMatchId(), liveListItem2.getMatchId()) && Intrinsics.c(liveListItem.getStatus(), liveListItem2.getStatus());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(LiveListItem liveListItem, LiveListItem liveListItem2) {
            Intrinsics.h(liveListItem, "oldItem");
            Intrinsics.h(liveListItem2, "newItem");
            return Intrinsics.c(liveListItem.getMatchId(), liveListItem2.getMatchId());
        }
    }

    public static final class b extends RecyclerView.s {
        b() {
            m(0, 8);
        }

        public void k(RecyclerView.a0 a0Var) {
            super.k(a0Var);
        }
    }

    public e0(int i, boolean z) {
        this.e = i;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(e0 e0Var, OperateItem operateItem, View view) {
        e0Var.L(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(e0 e0Var, OperateItem operateItem, View view) {
        e0Var.L(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(SportLiveAdapter sportLiveAdapter, List list) {
        sportLiveAdapter.n1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(List list, e0 e0Var, OperateItem operateItem, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        LiveListItem liveListItem;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (list == null || (liveListItem = (LiveListItem) list.get(i)) == null) {
            return;
        }
        e0Var.K(liveListItem, operateItem, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b I() {
        return new b();
    }

    private final b J() {
        return (b) this.g.getValue();
    }

    private final void K(LiveListItem liveListItem, OperateItem operateItem, int i) {
        String deepLink = liveListItem.getDeepLink();
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_sport_live_item");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        String type = operateItem.getType();
        String str = BuildConfig.FLAVOR;
        if (type == null) {
            type = BuildConfig.FLAVOR;
        }
        hashMap.put("opt_type", type);
        String matchId = liveListItem.getMatchId();
        if (matchId == null) {
            matchId = BuildConfig.FLAVOR;
        }
        hashMap.put("match_id", matchId);
        String status = liveListItem.getStatus();
        if (status == null) {
            status = BuildConfig.FLAVOR;
        }
        hashMap.put("match_status", status);
        String ops = liveListItem.getOps();
        if (ops != null) {
            str = ops;
        }
        hashMap.put("ops", str);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void L(OperateItem operateItem) {
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
        hashMap.put("event_type", "click_sport_live_more");
        hashMap.put("sequence", String.valueOf(num));
        String deepLink2 = operateItem.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = BuildConfig.FLAVOR;
        }
        hashMap.put("deepLink", deepLink2);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        hashMap.put("opt_type", operateItem.getType() + "_MORE");
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        final ArrayList arrayList;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.main_operation_sport_live_title);
        textView.setText(operateItem.getTitle());
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.main_operation_sport_more_text);
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            uf.c.h(textView2);
        } else {
            uf.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.E(e0.this, operateItem, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.F(e0.this, operateItem, view);
                }
            });
        }
        RecyclerView view = baseViewHolder.getView(R.id.main_operation_sport_live_recycler);
        final SportLiveAdapter sportLiveAdapter = new SportLiveAdapter(0, operateItem, this.e, this.f, 1, null);
        sportLiveAdapter.R0(new a());
        view.setAdapter(sportLiveAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        if (!Intrinsics.c(view.getRecycledViewPool(), J())) {
            view.setRecycledViewPool(J());
        }
        List<LiveListItem> liveList = operateItem.getLiveList();
        if (liveList != null) {
            arrayList = new ArrayList();
            for (Object obj : liveList) {
                if (!Intrinsics.c(((LiveListItem) obj).getStatus(), SportLiveAdapter.P)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        view.post(new Runnable() { // from class: com.transsion.home.adapter.trending.provider.b0
            @Override // java.lang.Runnable
            public final void run() {
                e0.G(SportLiveAdapter.this, arrayList);
            }
        });
        sportLiveAdapter.w1(new r6.d() { // from class: com.transsion.home.adapter.trending.provider.c0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                e0.H(arrayList, this, operateItem, baseQuickAdapter, view2, i);
            }
        });
    }

    public int l() {
        return PostItemType.SPORT_LIVE.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_sport_live;
    }
}
