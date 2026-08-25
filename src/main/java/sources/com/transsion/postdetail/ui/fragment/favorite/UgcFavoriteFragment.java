package com.transsion.postdetail.ui.fragment.favorite;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.bean.favorite.FeedFavorData;
import com.transsion.postdetail.bean.favorite.Pager;
import com.transsion.postdetail.ui.adapter.favorite.a;
import com.transsion.postdetail.ui.fragment.favorite.UgcFavoriteFragment;
import com.transsion.postdetail.viewmodel.ugcfavorite.UgcFavoriteViewModel;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import qi.h;
import r6.d;
import t6.f;
import wf.a;
import wn.i;
import yg.l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010)R\u0018\u0010B\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00102R\u0016\u0010D\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010F\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\bE\u0010)R\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010)¨\u0006J"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/favorite/UgcFavoriteFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lwn/i;", "Lcom/transsion/postdetail/ui/adapter/favorite/a;", "<init>", "()V", BuildConfig.FLAVOR, "t0", "Lcom/transsion/postdetail/ui/adapter/favorite/b;", "w0", "()Lcom/transsion/postdetail/ui/adapter/favorite/b;", "C0", "u0", BuildConfig.FLAVOR, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "feedItems", "E0", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "inflater", "s0", "(Landroid/view/LayoutInflater;)Lwn/i;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "loadDefaultData", "item", "a", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/postdetail/viewmodel/ugcfavorite/UgcFavoriteViewModel;", "Lcom/transsion/postdetail/viewmodel/ugcfavorite/UgcFavoriteViewModel;", "viewModel", "b", "Ljava/lang/String;", "pageNext", "c", "userId", BuildConfig.FLAVOR, "d", "Z", "isLoadingFavoriteFeed", "e", "Ljava/lang/Boolean;", "hasMoreFeedFavorite", "f", "Lcom/transsion/postdetail/ui/adapter/favorite/b;", "sFeedAdapter", "Lbj/b;", "g", "Lbj/b;", "mExposureHelper", BuildConfig.FLAVOR, "h", "J", "firstLoadStartTimeMillis", "i", "durationLoad", "j", "isFirstFeedDataRequest", "k", "loadStartTime", "l", "PAGE_NAME", "m", "pageFrom", "n", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcFavoriteFragment extends PageStatusFragment<i> implements a {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private UgcFavoriteViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private String pageNext = MsgStyle.CUSTOM_LEFT_PIC;

    /* renamed from: c, reason: from kotlin metadata */
    private String userId = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isLoadingFavoriteFeed;

    /* renamed from: e, reason: from kotlin metadata */
    private Boolean hasMoreFeedFavorite;

    /* renamed from: f, reason: from kotlin metadata */
    private com.transsion.postdetail.ui.adapter.favorite.b sFeedAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: h, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: i, reason: from kotlin metadata */
    private String durationLoad;

    /* renamed from: j, reason: from kotlin metadata */
    private Boolean isFirstFeedDataRequest;

    /* renamed from: k, reason: from kotlin metadata */
    private long loadStartTime;

    /* renamed from: l, reason: from kotlin metadata */
    private final String PAGE_NAME;

    /* renamed from: m, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: com.transsion.postdetail.ui.fragment.favorite.UgcFavoriteFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UgcFavoriteFragment a() {
            Bundle bundle = new Bundle();
            a.a.f(wf.a.a, "UgcFavoriteListFragment", "favorite newInstance", false, 4, (Object) null);
            UgcFavoriteFragment ugcFavoriteFragment = new UgcFavoriteFragment();
            ugcFavoriteFragment.setArguments(bundle);
            return ugcFavoriteFragment;
        }
    }

    public static final class b implements bj.a {
        b() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            com.transsion.postdetail.ui.adapter.favorite.b bVar = UgcFavoriteFragment.this.sFeedAdapter;
            if (bVar == null || (data = bVar.getData()) == null) {
                return;
            }
            int size = data.size();
            UgcFavoriteFragment ugcFavoriteFragment = UgcFavoriteFragment.this;
            StringBuilder sb = new StringBuilder();
            sb.append("曝光的位置position: ");
            sb.append(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("曝光的位置duration: ");
            sb2.append(j);
            if (i >= size) {
                return;
            }
            com.transsion.postdetail.ui.adapter.favorite.b bVar2 = ugcFavoriteFragment.sFeedAdapter;
            UGCVideo uGCVideo = bVar2 != null ? (UGCVideo) bVar2.getItem(i) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            hashMap.put("ops", String.valueOf(uGCVideo != null ? uGCVideo.getOps() : null));
            hashMap.put("position", String.valueOf(i));
            hashMap.put("refer_subject_id", String.valueOf(uGCVideo != null ? uGCVideo.getSubjectId() : null));
            hashMap.put("content_type", "ugc_video");
            hashMap.put("browse_duration", String.valueOf(j));
            com.transsion.baselib.helper.a.a.e(ugcFavoriteFragment.PAGE_NAME, hashMap);
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

    public UgcFavoriteFragment() {
        Boolean bool = Boolean.FALSE;
        this.hasMoreFeedFavorite = bool;
        this.durationLoad = "0";
        this.isFirstFeedDataRequest = bool;
        this.loadStartTime = -1L;
        this.PAGE_NAME = "/ugc/favorite";
        this.pageFrom = BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UgcFavoriteFragment ugcFavoriteFragment, View view) {
        FragmentActivity activity = ugcFavoriteFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(UgcFavoriteFragment ugcFavoriteFragment, FeedFavorData feedFavorData) {
        f h0;
        f h02;
        f h03;
        HashMap g;
        com.transsion.postdetail.ui.adapter.favorite.b bVar;
        List data;
        f h04;
        com.transsion.postdetail.ui.adapter.favorite.b bVar2;
        f h05;
        Pager pager;
        Pager pager2;
        List data2;
        f h06;
        com.transsion.postdetail.ui.adapter.favorite.b bVar3 = ugcFavoriteFragment.sFeedAdapter;
        if (bVar3 != null && (data2 = bVar3.getData()) != null && !data2.isEmpty() && feedFavorData == null) {
            a.a.f(wf.a.a, "UgcFavoriteListFragment", "feedFavoriteData is null,has no more data ", false, 4, (Object) null);
            com.transsion.postdetail.ui.adapter.favorite.b bVar4 = ugcFavoriteFragment.sFeedAdapter;
            if (bVar4 != null && (h06 = bVar4.h0()) != null) {
                f.u(h06, false, 1, (Object) null);
            }
            return Unit.a;
        }
        ugcFavoriteFragment.hasMoreFeedFavorite = (feedFavorData == null || (pager2 = feedFavorData.getPager()) == null) ? null : Boolean.valueOf(pager2.getHasMore());
        ugcFavoriteFragment.pageNext = (feedFavorData == null || (pager = feedFavorData.getPager()) == null) ? null : pager.getNextPage();
        com.transsion.postdetail.ui.adapter.favorite.b bVar5 = ugcFavoriteFragment.sFeedAdapter;
        if (bVar5 != null && (h04 = bVar5.h0()) != null && h04.r() && (bVar2 = ugcFavoriteFragment.sFeedAdapter) != null && (h05 = bVar2.h0()) != null) {
            h05.s();
        }
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UgcFavoriteListFragment", "favorite hasMore:" + ugcFavoriteFragment.hasMoreFeedFavorite, false, 4, (Object) null);
        a.a.f(aVar, "UgcFavoriteListFragment", "favorite pageNext:" + ugcFavoriteFragment.pageNext, false, 4, (Object) null);
        if ((feedFavorData != null ? feedFavorData.getItems() : null) != null) {
            List<UGCVideo> items = feedFavorData.getItems();
            Integer valueOf = items != null ? Integer.valueOf(items.size()) : null;
            a.a.f(aVar, "UgcFavoriteListFragment", "ugcFavoriteBean: received " + valueOf + " items, currentListSize=" + ugcFavoriteFragment.sFeedAdapter + "?.data?.size}, hasMore=" + feedFavorData.getPager().getHasMore(), false, 4, (Object) null);
            Boolean bool = ugcFavoriteFragment.hasMoreFeedFavorite;
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.c(bool, bool2) || ugcFavoriteFragment.hasMoreFeedFavorite == null) {
                a.a.f(aVar, "UgcFavoriteListFragment", "ugcVideoFavoriteBean: no more data, load more end", false, 4, (Object) null);
                com.transsion.postdetail.ui.adapter.favorite.b bVar6 = ugcFavoriteFragment.sFeedAdapter;
                if (bVar6 != null && (h03 = bVar6.h0()) != null) {
                    f.u(h03, false, 1, (Object) null);
                }
                com.transsion.postdetail.ui.adapter.favorite.b bVar7 = ugcFavoriteFragment.sFeedAdapter;
                if (bVar7 != null && (h02 = bVar7.h0()) != null) {
                    h02.z(false);
                }
                com.transsion.postdetail.ui.adapter.favorite.b bVar8 = ugcFavoriteFragment.sFeedAdapter;
                if (bVar8 != null && (h0 = bVar8.h0()) != null) {
                    h0.y(false);
                }
            }
            com.transsion.postdetail.ui.adapter.favorite.b bVar9 = ugcFavoriteFragment.sFeedAdapter;
            if (bVar9 == null || (data = bVar9.getData()) == null || !data.isEmpty() || valueOf == null || valueOf.intValue() != 0) {
                UgcFavoriteViewModel ugcFavoriteViewModel = ugcFavoriteFragment.viewModel;
                Boolean valueOf2 = ugcFavoriteViewModel != null ? Boolean.valueOf(ugcFavoriteViewModel.g()) : null;
                if (valueOf != null && valueOf.intValue() == 0 && Intrinsics.c(valueOf2, bool2) && (bVar = ugcFavoriteFragment.sFeedAdapter) != null) {
                    bVar.Y0(ugcFavoriteFragment.getEmptyView(false));
                }
                if (Intrinsics.c(ugcFavoriteFragment.isFirstFeedDataRequest, bool2)) {
                    ugcFavoriteFragment.durationLoad = ugcFavoriteFragment.loadStartTime > 0 ? String.valueOf(System.currentTimeMillis() - ugcFavoriteFragment.loadStartTime) : "0";
                    ugcFavoriteFragment.isFirstFeedDataRequest = Boolean.FALSE;
                    qi.b logViewConfig = ugcFavoriteFragment.getLogViewConfig();
                    if (logViewConfig != null && (g = logViewConfig.g()) != null) {
                    }
                }
                List<UGCVideo> items2 = feedFavorData.getItems();
                Intrinsics.e(items2);
                ugcFavoriteFragment.E0(items2);
                qi.b logViewConfig2 = ugcFavoriteFragment.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.k(true);
                }
            } else {
                a.a.f(aVar, "UgcFavoriteListFragment", "ugcFavoriteLikeBean: empty data", false, 4, (Object) null);
                com.transsion.postdetail.ui.adapter.favorite.b bVar10 = ugcFavoriteFragment.sFeedAdapter;
                if (bVar10 != null) {
                    bVar10.Y0(ugcFavoriteFragment.getEmptyView(false));
                }
            }
        }
        return Unit.a;
    }

    private final void C0() {
        ConstraintLayout root;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UgcFavoriteListFragment", "favorite loadFavoriteFeedsData", false, 4, (Object) null);
        if (this.isLoadingFavoriteFeed) {
            return;
        }
        this.isLoadingFavoriteFeed = true;
        a.a.f(aVar, "UgcFavoriteListFragment", "favorite loadFavoriteFeedsData 11", false, 4, (Object) null);
        UgcFavoriteViewModel ugcFavoriteViewModel = this.viewModel;
        if (ugcFavoriteViewModel != null) {
            ugcFavoriteViewModel.f(String.valueOf(this.pageNext), String.valueOf(this.userId));
        }
        i iVar = (i) getMViewBinding();
        if (iVar == null || (root = iVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: go.c
            @Override // java.lang.Runnable
            public final void run() {
                UgcFavoriteFragment.D0(UgcFavoriteFragment.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(UgcFavoriteFragment ugcFavoriteFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        i iVar = (i) ugcFavoriteFragment.getMViewBinding();
        if (iVar == null || (swipeRefreshLayout = iVar.e) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void E0(List feedItems) {
        List data;
        List data2;
        a.a aVar = wf.a.a;
        a.a.f(aVar, "UgcFavoriteListFragment", "favorite updateData", false, 4, (Object) null);
        com.transsion.postdetail.ui.adapter.favorite.b bVar = this.sFeedAdapter;
        int i = 0;
        int size = (bVar == null || (data2 = bVar.getData()) == null) ? 0 : data2.size();
        UgcFavoriteViewModel ugcFavoriteViewModel = this.viewModel;
        Boolean valueOf = ugcFavoriteViewModel != null ? Boolean.valueOf(ugcFavoriteViewModel.g()) : null;
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.c(valueOf, bool) || size == 0) {
            com.transsion.postdetail.ui.adapter.favorite.b bVar2 = this.sFeedAdapter;
            if (bVar2 != null) {
                bVar2.n1(feedItems);
            }
            a.a.f(aVar, "UgcFavoriteListFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + feedItems.size(), false, 4, (Object) null);
        } else {
            com.transsion.postdetail.ui.adapter.favorite.b bVar3 = this.sFeedAdapter;
            if (bVar3 != null) {
                bVar3.q(feedItems);
            }
            com.transsion.postdetail.ui.adapter.favorite.b bVar4 = this.sFeedAdapter;
            if (bVar4 != null && (data = bVar4.getData()) != null) {
                i = data.size();
            }
            a.a.f(aVar, "UgcFavoriteListFragment", "updateData: load more, add " + feedItems.size() + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
        }
        if ((Intrinsics.c(valueOf, bool) || size == 0) && !feedItems.isEmpty()) {
        }
    }

    private final void t0() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            bj.b bVar = new bj.b(0.6f, new b(), false, 4, null);
            i iVar = (i) getMViewBinding();
            if (iVar != null && (recyclerView = iVar.g) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    private final void u0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout;
        a.a.f(wf.a.a, "UgcFavoriteListFragment", "favorite initFavoriteFeedRecyclerView", false, 4, (Object) null);
        i iVar = (i) getMViewBinding();
        if (iVar != null && (swipeRefreshLayout = iVar.e) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: go.d
                public final void a() {
                    UgcFavoriteFragment.v0(UgcFavoriteFragment.this);
                }
            });
        }
        t0();
        bj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        i iVar2 = (i) getMViewBinding();
        if (iVar2 != null && (recyclerView2 = iVar2.g) != null) {
            recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        }
        com.transsion.postdetail.ui.adapter.favorite.b w0 = w0();
        this.sFeedAdapter = w0;
        if (w0 != null) {
            w0.Q1(this);
        }
        i iVar3 = (i) getMViewBinding();
        if (iVar3 == null || (recyclerView = iVar3.g) == null) {
            return;
        }
        recyclerView.setAdapter(this.sFeedAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(UgcFavoriteFragment ugcFavoriteFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        a.a.f(wf.a.a, "UgcFavoriteListFragment", "initRecyclerView: user pull to refresh", false, 4, (Object) null);
        UgcFavoriteViewModel ugcFavoriteViewModel = ugcFavoriteFragment.viewModel;
        if (ugcFavoriteViewModel != null) {
            ugcFavoriteViewModel.i();
        }
        i iVar = (i) ugcFavoriteFragment.getMViewBinding();
        if (iVar == null || (swipeRefreshLayout = iVar.e) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final com.transsion.postdetail.ui.adapter.favorite.b w0() {
        a.a.f(wf.a.a, "UgcFavoriteListFragment", "favorite initFeedAdapter", false, 4, (Object) null);
        com.transsion.postdetail.ui.adapter.favorite.b bVar = new com.transsion.postdetail.ui.adapter.favorite.b(new ArrayList(), this.mExposureHelper, false);
        bVar.h0().z(true);
        bVar.h0().y(true);
        bVar.h0().E(1);
        bVar.h0().D(new r6.f() { // from class: go.e
            public final void a() {
                UgcFavoriteFragment.x0(UgcFavoriteFragment.this);
            }
        });
        bVar.w1(new d() { // from class: go.f
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UgcFavoriteFragment.z0(baseQuickAdapter, view, i);
            }
        });
        this.sFeedAdapter = bVar;
        Intrinsics.e(bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(final UgcFavoriteFragment ugcFavoriteFragment) {
        RecyclerView recyclerView;
        if (l.a.e()) {
            a.a.f(wf.a.a, "UgcFavoriteListFragment", "initUgcFavoriteListAdapter: trigger load more", false, 4, (Object) null);
            UgcFavoriteViewModel ugcFavoriteViewModel = ugcFavoriteFragment.viewModel;
            if (ugcFavoriteViewModel != null) {
                ugcFavoriteViewModel.h(ugcFavoriteFragment.pageNext);
                return;
            }
            return;
        }
        a.a.x(wf.a.a, "UgcFavoriteListFragment", "initUgcFavoriteListAdapter: no network, load more failed", false, 4, (Object) null);
        i iVar = (i) ugcFavoriteFragment.getMViewBinding();
        if (iVar == null || (recyclerView = iVar.g) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: go.g
            @Override // java.lang.Runnable
            public final void run() {
                UgcFavoriteFragment.y0(UgcFavoriteFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(UgcFavoriteFragment ugcFavoriteFragment) {
        f h0;
        com.transsion.postdetail.ui.adapter.favorite.b bVar = ugcFavoriteFragment.sFeedAdapter;
        if (bVar == null || (h0 = bVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (baseQuickAdapter.getItem(i) instanceof UGCVideo) {
            new HashMap();
        }
    }

    @Override // com.transsion.postdetail.ui.adapter.favorite.a
    public void a(UGCVideo item) {
        Intrinsics.h(item, "item");
        a.a.f(wf.a.a, "UgcFavoriteListFragment", "favorite onClickVideoDetailItem", false, 4, (Object) null);
        hu.b.b(item, (Function1) null, 1, (Object) null);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        HashMap g;
        ImageView imageView;
        this.firstLoadStartTimeMillis = SystemClock.elapsedRealtime();
        u0();
        i iVar = (i) getMViewBinding();
        if (iVar != null && (imageView = iVar.c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: go.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UgcFavoriteFragment.A0(UgcFavoriteFragment.this, view);
                }
            });
        }
        if (this.pageFrom.length() == 0) {
            this.pageFrom = h.a.h();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    public void initViewModel() {
        b0 e;
        UgcFavoriteViewModel ugcFavoriteViewModel = this.viewModel;
        if (ugcFavoriteViewModel == null || (e = ugcFavoriteViewModel.e()) == null) {
            return;
        }
        e.j(this, new c(new Function1() { // from class: go.a
            public final Object invoke(Object obj) {
                Unit B0;
                B0 = UgcFavoriteFragment.B0(UgcFavoriteFragment.this, (FeedFavorData) obj);
                return B0;
            }
        }));
    }

    public void loadDefaultData() {
        this.isFirstFeedDataRequest = Boolean.TRUE;
        this.loadStartTime = System.currentTimeMillis();
        C0();
    }

    public qi.b newLogViewConfig() {
        return new qi.b(this.PAGE_NAME, false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void retryLoadData() {
        C0();
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = new v0(activity).a(UgcFavoriteViewModel.class);
        }
        a.a.f(wf.a.a, "UgcFavoriteListFragment", "favorite getViewBinding", false, 4, (Object) null);
        i c2 = i.c(getLayoutInflater());
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
