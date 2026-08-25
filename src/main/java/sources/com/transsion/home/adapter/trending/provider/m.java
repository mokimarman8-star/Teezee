package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.trending.adapter.OpMovieRankAdapter;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m extends BaseItemProvider {
    public static final a i = new a(null);
    public static final int j = 8;
    private final int e;
    private final com.transsion.home.preload.b f;
    private final boolean g;
    private final boolean h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m(int i2, com.transsion.home.preload.b bVar, boolean z, boolean z2) {
        this.e = i2;
        this.f = bVar;
        this.g = z;
        this.h = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(m mVar, OperateItem operateItem, boolean z, View view) {
        mVar.F(operateItem, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(m mVar, OperateItem operateItem, boolean z, View view) {
        mVar.F(operateItem, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, OpMovieRankAdapter opMovieRankAdapter, m mVar, boolean z, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        List<AppointSubject> subjects;
        AppointSubject appointSubject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<AppointSubject> subjects2 = operateItem.getSubjects();
        if (i2 >= (subjects2 != null ? subjects2.size() : 0) || (subjects = operateItem.getSubjects()) == null || (appointSubject = subjects.get(i2)) == null) {
            return;
        }
        if (opMovieRankAdapter.getItemViewType(i2) == 100) {
            mVar.F(operateItem, z);
        } else {
            mVar.G(appointSubject, i2, operateItem, z);
        }
    }

    private final void F(OperateItem operateItem, boolean z) {
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
        if (!this.g) {
            zk.c.a.i(operateItem, num);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z ? "click_rank_horiz_more" : "click_rank_more");
        hashMap.put("sequence", String.valueOf(num));
        String deepLink2 = operateItem.getDeepLink();
        String str = BuildConfig.FLAVOR;
        if (deepLink2 == null) {
            deepLink2 = BuildConfig.FLAVOR;
        }
        hashMap.put("deepLink", deepLink2);
        String title = operateItem.getTitle();
        if (title != null) {
            str = title;
        }
        hashMap.put("title", str);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        hashMap.put("opt_type", operateItem.getType() + "_RANK_MORE");
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void G(Subject subject, int i2, OperateItem operateItem, boolean z) {
        zk.h.f(subject, "opt_movie_rank");
        if (!this.g) {
            zk.c.a.h(subject, i2, operateItem);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z ? "click_rank_horiz_item" : "click_rank_item");
        hashMap.put("sequence", String.valueOf(i2));
        hashMap.put("tabId", String.valueOf(this.e));
        if (operateItem != null) {
            sk.b.a(operateItem, hashMap);
        }
        sk.b.d(subject, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        List data;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        RankingData rankingData = operateItem.getRankingData();
        final boolean z = rankingData != null && rankingData.getRankingHorizontal();
        TextView textView = (TextView) baseViewHolder.getView(R.id.main_operation_movie_rank_title);
        textView.setText(operateItem.getTitle());
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.main_operation_movie_more_text);
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            uf.c.h(textView2);
        } else {
            uf.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.C(m.this, operateItem, z, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.D(m.this, operateItem, z, view);
                }
            });
        }
        RecyclerView view = baseViewHolder.getView(R.id.main_operation_movie_rank_recycler);
        final OpMovieRankAdapter opMovieRankAdapter = new OpMovieRankAdapter(0, operateItem, this.g, this.e, z, this.h, 1, null);
        view.setAdapter(opMovieRankAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        List<AppointSubject> subjects = operateItem.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        if (subjects.size() > 30) {
            subjects = subjects.subList(0, 31);
        }
        opMovieRankAdapter.n1(subjects);
        opMovieRankAdapter.w1(new r6.d() { // from class: com.transsion.home.adapter.trending.provider.l
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                m.E(OperateItem.this, opMovieRankAdapter, this, z, baseQuickAdapter, view2, i2);
            }
        });
        if (this.g) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", z ? "browse_rank_horiz_more" : "browse_rank_more");
            BaseProviderMultiAdapter g = g();
            hashMap.put("sequence", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
            String deepLink2 = operateItem.getDeepLink();
            String str = BuildConfig.FLAVOR;
            if (deepLink2 == null) {
                deepLink2 = BuildConfig.FLAVOR;
            }
            hashMap.put("deepLink", deepLink2);
            String title = operateItem.getTitle();
            if (title != null) {
                str = title;
            }
            hashMap.put("title", str);
            hashMap.put("tabId", String.valueOf(this.e));
            sk.b.a(operateItem, hashMap);
            hashMap.put("opt_type", operateItem.getType() + "_RANK_MORE");
            com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap);
        }
    }

    public int l() {
        return PostItemType.OP_SUBJECTS_MOVIE.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_op_movie_rank;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i2) {
        Intrinsics.h(viewGroup, "parent");
        com.transsion.home.preload.b bVar = this.f;
        if (bVar == null || bVar.a() || this.f.c() == null) {
            return super.r(viewGroup, i2);
        }
        a.a.f(wf.a.a, "MainXMLPreload", "subjectOpView", false, 4, (Object) null);
        View c = this.f.c();
        if (c == null) {
            return super.r(viewGroup, i2);
        }
        c.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new BaseViewHolder(c);
    }
}
