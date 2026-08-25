package com.transsion.room.sub.fragment.subscription;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.sub.adapter.subscription.s;
import com.transsion.room.sub.bean.subscription.SubscriptionFollowingsData;
import com.transsion.room.sub.bean.subscription.UserInfoFollowings;
import com.transsion.room.sub.fragment.subscription.SubscriptionListFragment;
import com.transsion.room.sub.viewmodel.subscription.SubFollowingsViewModel;
import fp.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import mf.c;
import qi.h;
import r6.f;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010?\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b>\u0010/¨\u0006A"}, d2 = {"Lcom/transsion/room/sub/fragment/subscription/SubscriptionListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfp/u;", "Lcom/transsion/room/sub/adapter/subscription/b;", "<init>", "()V", BuildConfig.FLAVOR, "Lcom/transsion/room/sub/bean/subscription/UserInfoFollowings;", "userItem", BuildConfig.FLAVOR, "z0", "(Ljava/util/List;)V", "x0", "Lcom/transsion/room/sub/adapter/subscription/s;", "q0", "()Lcom/transsion/room/sub/adapter/subscription/s;", "t0", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Lfp/u;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "loadDefaultData", "userId", "b", "(Ljava/lang/String;)V", "onDestroy", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", BuildConfig.FLAVOR, "a", "Z", "isLoadingFollowings", "Lcom/transsion/room/sub/viewmodel/subscription/SubFollowingsViewModel;", "Lcom/transsion/room/sub/viewmodel/subscription/SubFollowingsViewModel;", "followingsViewModel", "c", "Ljava/lang/Boolean;", "hasMoreFollowings", "d", "Ljava/lang/String;", "cursorFollowings", "e", "Lcom/transsion/room/sub/adapter/subscription/s;", "sFollowingsAdapter", "Lbj/b;", "f", "Lbj/b;", "mExposureHelper", BuildConfig.FLAVOR, "g", "J", "firstLoadStartTimeMillis", "h", "durationMySubscriptionList", "i", "PAGE_NAME", "j", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubscriptionListFragment extends PageStatusFragment<u> implements com.transsion.room.sub.adapter.subscription.b {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean isLoadingFollowings;

    /* renamed from: b, reason: from kotlin metadata */
    private SubFollowingsViewModel followingsViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    private String cursorFollowings;

    /* renamed from: e, reason: from kotlin metadata */
    private s sFollowingsAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: g, reason: from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: h, reason: from kotlin metadata */
    private long durationMySubscriptionList;

    /* renamed from: c, reason: from kotlin metadata */
    private Boolean hasMoreFollowings = Boolean.FALSE;

    /* renamed from: i, reason: from kotlin metadata */
    private final String PAGE_NAME = "/subscription/my_subscription";

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
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

    private final s q0() {
        s sVar = new s(new ArrayList(), this.mExposureHelper, false);
        sVar.h0().z(true);
        sVar.h0().y(true);
        sVar.h0().E(2);
        sVar.h0().D(new f() { // from class: mp.q
            public final void a() {
                SubscriptionListFragment.r0(SubscriptionListFragment.this);
            }
        });
        this.sFollowingsAdapter = sVar;
        Intrinsics.e(sVar);
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(final SubscriptionListFragment subscriptionListFragment) {
        RecyclerView recyclerView;
        if (l.a.e() && subscriptionListFragment.hasMoreFollowings != null) {
            a.a.f(a.a, "SubscriptionListFragment", "initSubscriptionListAdapter: trigger load more", false, 4, (Object) null);
            SubFollowingsViewModel subFollowingsViewModel = subscriptionListFragment.followingsViewModel;
            if (subFollowingsViewModel != null) {
                subFollowingsViewModel.h(subscriptionListFragment.cursorFollowings);
                return;
            }
            return;
        }
        a.a.x(a.a, "SubscriptionListFragment", "initSubscriptionListAdapter: no network, load more failed", false, 4, (Object) null);
        u uVar = (u) subscriptionListFragment.getMViewBinding();
        if (uVar == null || (recyclerView = uVar.c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: mp.r
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionListFragment.s0(SubscriptionListFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SubscriptionListFragment subscriptionListFragment) {
        t6.f h0;
        s sVar = subscriptionListFragment.sFollowingsAdapter;
        if (sVar == null || (h0 = sVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void t0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        SwipeRefreshLayout swipeRefreshLayout;
        u uVar = (u) getMViewBinding();
        if (uVar != null && (swipeRefreshLayout = uVar.f) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: mp.p
                public final void a() {
                    SubscriptionListFragment.u0(SubscriptionListFragment.this);
                }
            });
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        linearLayoutManager.setItemPrefetchEnabled(false);
        u uVar2 = (u) getMViewBinding();
        if (uVar2 != null && (recyclerView3 = uVar2.c) != null) {
            recyclerView3.setLayoutManager(linearLayoutManager);
        }
        u uVar3 = (u) getMViewBinding();
        if (uVar3 != null && (recyclerView2 = uVar3.c) != null) {
            recyclerView2.setHasFixedSize(true);
        }
        s q0 = q0();
        this.sFollowingsAdapter = q0;
        if (q0 != null) {
            q0.Q1(this);
        }
        u uVar4 = (u) getMViewBinding();
        if (uVar4 == null || (recyclerView = uVar4.c) == null) {
            return;
        }
        recyclerView.setAdapter(this.sFollowingsAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SubscriptionListFragment subscriptionListFragment) {
        a.a.f(a.a, "SubscriptionListFragment", "initRecyclerView: user pull to refresh", false, 4, (Object) null);
        SubFollowingsViewModel subFollowingsViewModel = subscriptionListFragment.followingsViewModel;
        if (subFollowingsViewModel != null) {
            subFollowingsViewModel.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SubscriptionListFragment subscriptionListFragment, View view) {
        FragmentActivity activity = subscriptionListFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SubscriptionListFragment subscriptionListFragment, SubscriptionFollowingsData subscriptionFollowingsData) {
        SwipeRefreshLayout swipeRefreshLayout;
        t6.f h0;
        t6.f h02;
        t6.f h03;
        s sVar;
        List data;
        t6.f h04;
        t6.f h05;
        subscriptionListFragment.hasMoreFollowings = subscriptionFollowingsData != null ? Boolean.valueOf(subscriptionFollowingsData.getHasMore()) : null;
        subscriptionListFragment.cursorFollowings = subscriptionFollowingsData != null ? subscriptionFollowingsData.getNextCursor() : null;
        SubFollowingsViewModel subFollowingsViewModel = subscriptionListFragment.followingsViewModel;
        Boolean valueOf = subFollowingsViewModel != null ? Boolean.valueOf(subFollowingsViewModel.g()) : null;
        a.a aVar = a.a;
        a.a.f(aVar, "SubscriptionListFragment", "Followings observe start", false, 4, (Object) null);
        subscriptionListFragment.showContentView();
        s sVar2 = subscriptionListFragment.sFollowingsAdapter;
        if (sVar2 != null && (h04 = sVar2.h0()) != null && h04.r()) {
            s sVar3 = subscriptionListFragment.sFollowingsAdapter;
            if (sVar3 != null && (h05 = sVar3.h0()) != null) {
                h05.s();
            }
            a.a.f(aVar, "SubscriptionListFragment", "Followings observe loadMoreComplete", false, 4, (Object) null);
        }
        if ((subscriptionFollowingsData != null ? subscriptionFollowingsData.getUsers() : null) != null) {
            List<UserInfoFollowings> users = subscriptionFollowingsData.getUsers();
            Integer valueOf2 = users != null ? Integer.valueOf(users.size()) : null;
            a.a.f(aVar, "SubscriptionListFragment", "subscriptionFollowingsBean: received " + valueOf2 + " items, currentListSize=" + subscriptionListFragment.sFollowingsAdapter + "?.data?.size}, hasMore=" + subscriptionFollowingsData.getHasMore(), false, 4, (Object) null);
            Boolean bool = subscriptionListFragment.hasMoreFollowings;
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.c(bool, bool2) || subscriptionListFragment.hasMoreFollowings == null) {
                a.a.f(aVar, "SubscriptionListFragment", "ugcVideoFavoriteBean: no more data, load more end", false, 4, (Object) null);
                s sVar4 = subscriptionListFragment.sFollowingsAdapter;
                if (sVar4 != null && (h03 = sVar4.h0()) != null) {
                    t6.f.u(h03, false, 1, (Object) null);
                }
                s sVar5 = subscriptionListFragment.sFollowingsAdapter;
                if (sVar5 != null && (h02 = sVar5.h0()) != null) {
                    h02.z(false);
                }
                s sVar6 = subscriptionListFragment.sFollowingsAdapter;
                if (sVar6 != null && (h0 = sVar6.h0()) != null) {
                    h0.y(false);
                }
                a.a.f(aVar, "SubscriptionListFragment", "Followings observe loadMoreEnd", false, 4, (Object) null);
            }
            s sVar7 = subscriptionListFragment.sFollowingsAdapter;
            if (sVar7 == null || (data = sVar7.getData()) == null || !data.isEmpty() || valueOf2 == null || valueOf2.intValue() != 0) {
                List<UserInfoFollowings> users2 = subscriptionFollowingsData.getUsers();
                Intrinsics.e(users2);
                subscriptionListFragment.z0(users2);
                if (valueOf2 != null && valueOf2.intValue() == 0 && Intrinsics.c(valueOf, bool2) && (sVar = subscriptionListFragment.sFollowingsAdapter) != null) {
                    sVar.Y0(subscriptionListFragment.getEmptyView(false));
                }
                a.a.f(aVar, "SubscriptionListFragment", "Followings observe updateFollowingsData", false, 4, (Object) null);
            } else {
                a.a.f(aVar, "SubscriptionListFragment", "subscriptionFollowingsBean: empty data", false, 4, (Object) null);
                a.a.f(aVar, "SubscriptionListFragment", "Followings observe setEmptyView", false, 4, (Object) null);
                s sVar8 = subscriptionListFragment.sFollowingsAdapter;
                if (sVar8 != null) {
                    sVar8.Y0(subscriptionListFragment.getEmptyView(false));
                }
            }
            qi.b logViewConfig = subscriptionListFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
        }
        u uVar = (u) subscriptionListFragment.getMViewBinding();
        if (uVar != null && (swipeRefreshLayout = uVar.f) != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        return Unit.a;
    }

    private final void x0() {
        ConstraintLayout root;
        showLoadingView();
        if (this.isLoadingFollowings) {
            return;
        }
        this.isLoadingFollowings = true;
        SubFollowingsViewModel subFollowingsViewModel = this.followingsViewModel;
        if (subFollowingsViewModel != null) {
            subFollowingsViewModel.f(BuildConfig.FLAVOR);
        }
        u uVar = (u) getMViewBinding();
        if (uVar == null || (root = uVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: mp.o
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionListFragment.y0(SubscriptionListFragment.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(SubscriptionListFragment subscriptionListFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        u uVar = (u) subscriptionListFragment.getMViewBinding();
        if (uVar == null || (swipeRefreshLayout = uVar.f) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void z0(List userItem) {
        List data;
        List data2;
        s sVar = this.sFollowingsAdapter;
        int i = 0;
        int size = (sVar == null || (data2 = sVar.getData()) == null) ? 0 : data2.size();
        SubFollowingsViewModel subFollowingsViewModel = this.followingsViewModel;
        Boolean valueOf = subFollowingsViewModel != null ? Boolean.valueOf(subFollowingsViewModel.g()) : null;
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.c(valueOf, bool) || size == 0) {
            s sVar2 = this.sFollowingsAdapter;
            if (sVar2 != null) {
                sVar2.n1(userItem);
            }
            a.a.f(a.a, "SubscriptionListFragment", "updateData: refresh or first load, replace data. size: " + size + " -> " + userItem.size(), false, 4, (Object) null);
        } else {
            s sVar3 = this.sFollowingsAdapter;
            if (sVar3 != null) {
                sVar3.q(userItem);
            }
            s sVar4 = this.sFollowingsAdapter;
            if (sVar4 != null && (data = sVar4.getData()) != null) {
                i = data.size();
            }
            a.a.f(a.a, "SubscriptionListFragment", "updateData: load more, add " + userItem.size() + " items, list size: " + size + " -> " + i, false, 4, (Object) null);
        }
        if ((Intrinsics.c(valueOf, bool) || size == 0) && !userItem.isEmpty()) {
        }
    }

    @Override // com.transsion.room.sub.adapter.subscription.b
    public void b(String userId) {
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userId), getContext(), (c) null, 2, (Object) null);
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        ImageView imageView;
        this.firstLoadStartTimeMillis = SystemClock.elapsedRealtime();
        t0();
        u uVar = (u) getMViewBinding();
        if (uVar == null || (imageView = uVar.d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: mp.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubscriptionListFragment.v0(SubscriptionListFragment.this, view);
            }
        });
    }

    public void initViewModel() {
        b0 e;
        SubFollowingsViewModel subFollowingsViewModel = this.followingsViewModel;
        if (subFollowingsViewModel == null || (e = subFollowingsViewModel.e()) == null) {
            return;
        }
        e.j(this, new b(new Function1() { // from class: mp.m
            public final Object invoke(Object obj) {
                Unit w0;
                w0 = SubscriptionListFragment.w0(SubscriptionListFragment.this, (SubscriptionFollowingsData) obj);
                return w0;
            }
        }));
    }

    public void loadDefaultData() {
        x0();
    }

    public qi.b newLogViewConfig() {
        return new qi.b(this.PAGE_NAME, false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.firstLoadStartTimeMillis;
        this.durationMySubscriptionList = elapsedRealtime;
        StringBuilder sb = new StringBuilder();
        sb.append("页面停留时长为: ");
        sb.append(elapsedRealtime);
        sb.append(" ");
        com.transsion.baselib.helper.a.a.k(this.PAGE_NAME, h.a.h(), String.valueOf(this.durationMySubscriptionList));
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public u getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.followingsViewModel = new v0(activity).a(SubFollowingsViewModel.class);
        }
        u c = u.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void retryLoadData() {
        x0();
    }
}
