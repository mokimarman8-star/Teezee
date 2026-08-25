package com.transsion.room.sub.fragment.likes;

import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.room.sub.adapter.likes.a;
import com.transsion.room.sub.bean.likes.GetUgcVideoLikesBean;
import com.transsion.room.sub.bean.likes.PagerInfoLikes;
import com.transsion.room.sub.fragment.likes.UgcLikesFragment;
import com.transsion.room.sub.viewmodel.likes.UgcLikesViewModel;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import fp.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import r6.d;
import r6.f;
import wf.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010/R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010)R\u0018\u0010D\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010/R\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010)¨\u0006H"}, d2 = {"Lcom/transsion/room/sub/fragment/likes/UgcLikesFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfp/l;", "Lcom/transsion/room/sub/adapter/likes/a;", "<init>", "()V", BuildConfig.FLAVOR, "r0", "z0", BuildConfig.FLAVOR, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "feedItems", "B0", "(Ljava/util/List;)V", "w0", "Lcom/transsion/room/sub/adapter/likes/c;", "s0", "()Lcom/transsion/room/sub/adapter/likes/c;", "Landroid/view/LayoutInflater;", "inflater", "q0", "(Landroid/view/LayoutInflater;)Lfp/l;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "loadDefaultData", "item", "a", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/room/sub/viewmodel/likes/UgcLikesViewModel;", "Lcom/transsion/room/sub/viewmodel/likes/UgcLikesViewModel;", "viewModel", "b", "Ljava/lang/String;", "pageNext", "c", "userId", BuildConfig.FLAVOR, "d", "Ljava/lang/Boolean;", "hasMoreLikes", "Lbj/b;", "e", "Lbj/b;", "mExposureHelper", "f", "Lcom/transsion/room/sub/adapter/likes/c;", "sFeedAdapter", "g", "Z", "isLoadingLikesFeed", "h", "hasMoreFeedLikes", BuildConfig.FLAVOR, "i", "J", "loadStartTime", "j", "durationLoad", "k", "isFirstFeedDataRequest", "l", "pageFrom", "m", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcLikesFragment extends PageStatusFragment<l> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private UgcLikesViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private String pageNext = BuildConfig.FLAVOR;

    /* renamed from: c, reason: from kotlin metadata */
    private String userId = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private Boolean hasMoreLikes;

    /* renamed from: e, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: f, reason: from kotlin metadata */
    private com.transsion.room.sub.adapter.likes.c sFeedAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean isLoadingLikesFeed;

    /* renamed from: h, reason: from kotlin metadata */
    private Boolean hasMoreFeedLikes;

    /* renamed from: i, reason: from kotlin metadata */
    private long loadStartTime;

    /* renamed from: j, reason: from kotlin metadata */
    private String durationLoad;

    /* renamed from: k, reason: from kotlin metadata */
    private Boolean isFirstFeedDataRequest;

    /* renamed from: l, reason: from kotlin metadata */
    private String pageFrom;

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            com.transsion.room.sub.adapter.likes.c cVar = UgcLikesFragment.this.sFeedAdapter;
            if (cVar == null || (data = cVar.getData()) == null) {
                return;
            }
            int size = data.size();
            UgcLikesFragment ugcLikesFragment = UgcLikesFragment.this;
            StringBuilder sb = new StringBuilder();
            sb.append("曝光的位置position: ");
            sb.append(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("曝光的位置duration: ");
            sb2.append(j);
            if (i >= size) {
                return;
            }
            com.transsion.room.sub.adapter.likes.c cVar2 = ugcLikesFragment.sFeedAdapter;
            UGCVideo uGCVideo = cVar2 != null ? (UGCVideo) cVar2.getItem(i) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            hashMap.put("ops", String.valueOf(uGCVideo != null ? uGCVideo.getOps() : null));
            hashMap.put("position", String.valueOf(i));
            hashMap.put("refer_subject_id", String.valueOf(uGCVideo != null ? uGCVideo.getSubjectId() : null));
            hashMap.put("content_type", "ugc_video");
            hashMap.put("browse_duration", String.valueOf(j));
            com.transsion.baselib.helper.a.a.e("/ugc/likes", hashMap);
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public UgcLikesFragment() {
        Boolean bool = Boolean.FALSE;
        this.hasMoreLikes = bool;
        this.hasMoreFeedLikes = bool;
        this.loadStartTime = -1L;
        this.durationLoad = "0";
        this.isFirstFeedDataRequest = bool;
        this.pageFrom = BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UgcLikesFragment ugcLikesFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        l lVar = (l) ugcLikesFragment.getMViewBinding();
        if (lVar == null || (swipeRefreshLayout = lVar.b) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void B0(List feedItems) {
        List data;
        List data2;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UgcLikesListFragment", "Likes updateData", false, 4, (Object) null);
        com.transsion.room.sub.adapter.likes.c cVar = this.sFeedAdapter;
        int i = 0;
        int size = (cVar == null || (data2 = cVar.getData()) == null) ? 0 : data2.size();
        UgcLikesViewModel ugcLikesViewModel = this.viewModel;
        if (Intrinsics.c(ugcLikesViewModel != null ? Boolean.valueOf(ugcLikesViewModel.h()) : null, Boolean.TRUE) || size == 0) {
            com.transsion.room.sub.adapter.likes.c cVar2 = this.sFeedAdapter;
            if (cVar2 != null) {
                cVar2.n1(feedItems);
            }
            a.a.f(aVar, "UgcLikesListFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + feedItems.size(), false, 4, (Object) null);
            return;
        }
        com.transsion.room.sub.adapter.likes.c cVar3 = this.sFeedAdapter;
        if (cVar3 != null) {
            cVar3.q(feedItems);
        }
        com.transsion.room.sub.adapter.likes.c cVar4 = this.sFeedAdapter;
        if (cVar4 != null && (data = cVar4.getData()) != null) {
            i = data.size();
        }
        a.a.f(aVar, "UgcLikesListFragment", "updateData: load more, add " + feedItems.size() + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
    }

    private final void r0() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            bj.b bVar = new bj.b(0.6f, new b(), false, 4, null);
            l lVar = (l) getMViewBinding();
            if (lVar != null && (recyclerView = lVar.c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    private final com.transsion.room.sub.adapter.likes.c s0() {
        a.a.f(wf.a.a, "UgcLikesListFragment", "Likes initFeedAdapter", false, 4, (Object) null);
        com.transsion.room.sub.adapter.likes.c cVar = new com.transsion.room.sub.adapter.likes.c(new ArrayList(), this.mExposureHelper, false);
        cVar.h0().z(true);
        cVar.h0().y(true);
        cVar.h0().D(new f() { // from class: lp.d
            public final void a() {
                UgcLikesFragment.t0(UgcLikesFragment.this);
            }
        });
        cVar.w1(new d() { // from class: lp.e
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UgcLikesFragment.v0(UgcLikesFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.sFeedAdapter = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(final UgcLikesFragment ugcLikesFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            UgcLikesViewModel ugcLikesViewModel = ugcLikesFragment.viewModel;
            if (ugcLikesViewModel != null) {
                ugcLikesViewModel.i(ugcLikesFragment.pageNext);
                return;
            }
            return;
        }
        a.a.x(wf.a.a, "UgcLikesListFragment", "initFilmListAdapter: no network, load more failed", false, 4, (Object) null);
        l lVar = (l) ugcLikesFragment.getMViewBinding();
        if (lVar == null || (recyclerView = lVar.c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: lp.f
            @Override // java.lang.Runnable
            public final void run() {
                UgcLikesFragment.u0(UgcLikesFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(UgcLikesFragment ugcLikesFragment) {
        t6.f h0;
        com.transsion.room.sub.adapter.likes.c cVar = ugcLikesFragment.sFeedAdapter;
        if (cVar == null || (h0 = cVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(UgcLikesFragment ugcLikesFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof UGCVideo) {
            UGCVideo uGCVideo = (UGCVideo) item;
            Navigator K = TheRouter.c("/ugc_video/detail").K("id", uGCVideo.getUgcVideoId());
            UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
            Navigator.x(K.K("collection_id", belongToCollection != null ? belongToCollection.getCollectionId() : null).K("ops", uGCVideo.getOps()).K("page_from", "UgcLike Page"), ugcLikesFragment.getActivity(), (mf.c) null, 2, (Object) null);
            new HashMap();
        }
    }

    private final void w0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout;
        a.a.f(wf.a.a, "UgcLikesListFragment", "Likes initLikesFeedRecyclerView", false, 4, (Object) null);
        l lVar = (l) getMViewBinding();
        if (lVar != null && (swipeRefreshLayout = lVar.b) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: lp.b
                public final void a() {
                    UgcLikesFragment.x0(UgcLikesFragment.this);
                }
            });
        }
        r0();
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        l lVar2 = (l) getMViewBinding();
        if (lVar2 != null && (recyclerView2 = lVar2.c) != null) {
            recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        }
        com.transsion.room.sub.adapter.likes.c s0 = s0();
        this.sFeedAdapter = s0;
        if (s0 != null) {
            s0.Q1(this);
        }
        l lVar3 = (l) getMViewBinding();
        if (lVar3 == null || (recyclerView = lVar3.c) == null) {
            return;
        }
        recyclerView.setAdapter(this.sFeedAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(UgcLikesFragment ugcLikesFragment) {
        a.a.f(wf.a.a, "UgcLikesListFragment", "initRecyclerView: user pull to refresh", false, 4, (Object) null);
        UgcLikesViewModel ugcLikesViewModel = ugcLikesFragment.viewModel;
        if (ugcLikesViewModel != null) {
            ugcLikesViewModel.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(UgcLikesFragment ugcLikesFragment, GetUgcVideoLikesBean getUgcVideoLikesBean) {
        com.transsion.room.sub.adapter.likes.c cVar;
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        HashMap g;
        List data2;
        t6.f h0;
        t6.f h02;
        com.transsion.room.sub.adapter.likes.c cVar2;
        t6.f h03;
        PagerInfoLikes pager;
        PagerInfoLikes pager2;
        com.transsion.room.sub.adapter.likes.c cVar3;
        List data3;
        t6.f h04;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean:: " + getUgcVideoLikesBean, false, 4, (Object) null);
        UgcLikesViewModel ugcLikesViewModel = ugcLikesFragment.viewModel;
        Boolean valueOf = ugcLikesViewModel != null ? Boolean.valueOf(ugcLikesViewModel.h()) : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.c(valueOf, bool) && (cVar3 = ugcLikesFragment.sFeedAdapter) != null && (data3 = cVar3.getData()) != null && !data3.isEmpty() && getUgcVideoLikesBean == null) {
            a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean is null,has no more data ", false, 4, (Object) null);
            com.transsion.room.sub.adapter.likes.c cVar4 = ugcLikesFragment.sFeedAdapter;
            if (cVar4 != null && (h04 = cVar4.h0()) != null) {
                t6.f.u(h04, false, 1, (Object) null);
            }
            return Unit.a;
        }
        ugcLikesFragment.hasMoreFeedLikes = (getUgcVideoLikesBean == null || (pager2 = getUgcVideoLikesBean.getPager()) == null) ? null : Boolean.valueOf(pager2.getHasMore());
        ugcLikesFragment.pageNext = (getUgcVideoLikesBean == null || (pager = getUgcVideoLikesBean.getPager()) == null) ? null : pager.getNextPage();
        a.a.f(aVar, "UgcLikesListFragment", "hasMoreFeedLikes " + ugcLikesFragment.hasMoreFeedLikes, false, 4, (Object) null);
        com.transsion.room.sub.adapter.likes.c cVar5 = ugcLikesFragment.sFeedAdapter;
        if (cVar5 != null && (h02 = cVar5.h0()) != null && h02.r() && (cVar2 = ugcLikesFragment.sFeedAdapter) != null && (h03 = cVar2.h0()) != null) {
            h03.s();
        }
        if ((getUgcVideoLikesBean != null ? getUgcVideoLikesBean.getItems() : null) != null) {
            List<UGCVideo> items = getUgcVideoLikesBean.getItems();
            Integer valueOf2 = items != null ? Integer.valueOf(items.size()) : null;
            a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean: received " + valueOf2 + " items, currentListSize=" + ugcLikesFragment.sFeedAdapter + "?.data?.size}, hasMore=" + getUgcVideoLikesBean.getPager().getHasMore(), false, 4, (Object) null);
            Boolean bool2 = ugcLikesFragment.hasMoreLikes;
            Boolean bool3 = Boolean.TRUE;
            if (!Intrinsics.c(bool2, bool3)) {
                a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean: no more data, load more end", false, 4, (Object) null);
                com.transsion.room.sub.adapter.likes.c cVar6 = ugcLikesFragment.sFeedAdapter;
                if (cVar6 != null && (h0 = cVar6.h0()) != null) {
                    t6.f.u(h0, false, 1, (Object) null);
                }
            }
            com.transsion.room.sub.adapter.likes.c cVar7 = ugcLikesFragment.sFeedAdapter;
            if (cVar7 == null || (data2 = cVar7.getData()) == null || !data2.isEmpty() || valueOf2 == null || valueOf2.intValue() != 0) {
                if (Intrinsics.c(ugcLikesFragment.isFirstFeedDataRequest, bool3)) {
                    ugcLikesFragment.durationLoad = ugcLikesFragment.loadStartTime > 0 ? String.valueOf(System.currentTimeMillis() - ugcLikesFragment.loadStartTime) : "0";
                    ugcLikesFragment.isFirstFeedDataRequest = bool;
                    qi.b logViewConfig = ugcLikesFragment.getLogViewConfig();
                    if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                    }
                }
                List<UGCVideo> items2 = getUgcVideoLikesBean.getItems();
                Intrinsics.e(items2);
                ugcLikesFragment.B0(items2);
                qi.b logViewConfig2 = ugcLikesFragment.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.k(true);
                }
            } else {
                a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean: empty data", false, 4, (Object) null);
                com.transsion.room.sub.adapter.likes.c cVar8 = ugcLikesFragment.sFeedAdapter;
                if (cVar8 != null) {
                    cVar8.Y0(ugcLikesFragment.getEmptyView(false));
                }
            }
        } else if (Intrinsics.c(valueOf, Boolean.TRUE) || ((cVar = ugcLikesFragment.sFeedAdapter) != null && (data = cVar.getData()) != null && data.isEmpty())) {
            a.a.f(aVar, "UgcLikesListFragment", "ugcVideoLikeBean: empty data", false, 4, (Object) null);
            com.transsion.room.sub.adapter.likes.c cVar9 = ugcLikesFragment.sFeedAdapter;
            if (cVar9 != null) {
                cVar9.Y0(ugcLikesFragment.getEmptyView(false));
            }
            com.transsion.room.sub.adapter.likes.c cVar10 = ugcLikesFragment.sFeedAdapter;
            if (cVar10 != null) {
                cVar10.n1((Collection) null);
            }
        }
        l lVar = (l) ugcLikesFragment.getMViewBinding();
        if (lVar != null && (swipeRefreshLayout = lVar.b) != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        return Unit.a;
    }

    private final void z0() {
        ConstraintLayout root;
        a.a.f(wf.a.a, "UgcLikesListFragment", "Likes loadLikesFeedsData", false, 4, (Object) null);
        if (this.isLoadingLikesFeed) {
            return;
        }
        this.isLoadingLikesFeed = true;
        UgcLikesViewModel ugcLikesViewModel = this.viewModel;
        if (ugcLikesViewModel != null) {
            ugcLikesViewModel.g(MsgStyle.CUSTOM_LEFT_PIC, String.valueOf(this.userId));
        }
        l lVar = (l) getMViewBinding();
        if (lVar == null || (root = lVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: lp.a
            @Override // java.lang.Runnable
            public final void run() {
                UgcLikesFragment.A0(UgcLikesFragment.this);
            }
        }, 2000L);
    }

    @Override // com.transsion.room.sub.adapter.likes.a
    public void a(UGCVideo item) {
        Intrinsics.h(item, "item");
        a.a.f(wf.a.a, "UgcLikesListFragment", " Likes lazyLoadData", false, 4, (Object) null);
        hu.b.b(item, (Function1) null, 1, (Object) null);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        HashMap g;
        w0();
        if (this.pageFrom.length() == 0) {
            this.pageFrom = h.a.h();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    public void initViewModel() {
        b0 f;
        UgcLikesViewModel ugcLikesViewModel = this.viewModel;
        if (ugcLikesViewModel == null || (f = ugcLikesViewModel.f()) == null) {
            return;
        }
        f.j(this, new c(new Function1() { // from class: lp.c
            public final Object invoke(Object obj) {
                Unit y0;
                y0 = UgcLikesFragment.y0(UgcLikesFragment.this, (GetUgcVideoLikesBean) obj);
                return y0;
            }
        }));
    }

    public void loadDefaultData() {
        this.isFirstFeedDataRequest = Boolean.TRUE;
        this.loadStartTime = System.currentTimeMillis();
        z0();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("/ugc/likes", false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public l getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        a.a.f(wf.a.a, "UgcLikesListFragment", "Likes getViewBinding", false, 4, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = new v0(activity).a(UgcLikesViewModel.class);
        }
        l c2 = l.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void retryLoadData() {
        z0();
    }
}
