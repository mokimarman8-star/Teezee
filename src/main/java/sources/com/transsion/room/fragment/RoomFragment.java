package com.transsion.room.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.room.R$string;
import com.transsion.room.activity.RoomDetailActivity;
import com.transsion.room.viewmodel.RoomViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import wf.a;
import yg.m;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J!\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010+R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/transsion/room/fragment/RoomFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfp/m;", "<init>", "()V", BuildConfig.FLAVOR, "m0", BuildConfig.FLAVOR, "item", BuildConfig.FLAVOR, "position", "p0", "(Ljava/lang/Object;I)V", "i0", "initViewModel", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "roomBean", "u0", "(Lcom/transsion/moviedetailapi/bean/RoomBean;)V", "loadMore", "loadData", "t0", "s0", "q0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "r0", "startLoading", "Landroid/view/LayoutInflater;", "inflater", "h0", "(Landroid/view/LayoutInflater;)Lfp/m;", "onResume", "onDestroyView", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "I", "requestCode", BuildConfig.FLAVOR, "b", "Z", "isRefresh", "Lcom/transsion/room/adapter/d;", "c", "Lcom/transsion/room/adapter/d;", "mHotAdapter", "Lcom/transsion/room/viewmodel/RoomViewModel;", "d", "Lcom/transsion/room/viewmodel/RoomViewModel;", "mRoomViewModel", BuildConfig.FLAVOR, "e", "Ljava/lang/String;", "mPersonalRoomPage", "f", "mHotRoomPage", "g", "mPerPage", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "h", "Landroidx/activity/result/b;", "requestRoomDetailLaunch", "i", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomFragment extends BaseFragment<fp.m> {

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.room.adapter.d mHotAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private RoomViewModel mRoomViewModel;

    /* renamed from: h, reason: from kotlin metadata */
    private androidx.activity.result.b requestRoomDetailLaunch;

    /* renamed from: a, reason: from kotlin metadata */
    private final int requestCode = 100;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isRefresh = true;

    /* renamed from: e, reason: from kotlin metadata */
    private String mPersonalRoomPage = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private String mHotRoomPage = BuildConfig.FLAVOR;

    /* renamed from: g, reason: from kotlin metadata */
    private int mPerPage = 20;

    public static final class b extends DiffUtil.e {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(RoomItem roomItem, RoomItem roomItem2) {
            Intrinsics.h(roomItem, "oldItem");
            Intrinsics.h(roomItem2, "newItem");
            return Intrinsics.c(roomItem.getCreatorId(), roomItem2.getCreatorId()) && Intrinsics.c(roomItem.getName(), roomItem2.getName());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(RoomItem roomItem, RoomItem roomItem2) {
            Intrinsics.h(roomItem, "oldItem");
            Intrinsics.h(roomItem2, "newItem");
            return Intrinsics.c(roomItem.getGroupId(), roomItem2.getGroupId());
        }
    }

    public static final class c implements AdvRecyclerView.a {
        c() {
        }

        public void a() {
            RoomFragment.this.loadData();
        }

        public void b() {
            RoomFragment.this.loadData();
        }
    }

    public static final class d extends RecyclerView.r {
        private int[] a;
        private int b;

        d() {
        }

        private final void d(RecyclerView recyclerView) {
            StaggeredGridLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                if (this.a == null) {
                    this.a = new int[layoutManager.Q()];
                }
                layoutManager.E(this.a);
                this.b = e(this.a);
                return;
            }
            if (layoutManager instanceof GridLayoutManager) {
                this.b = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else {
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    throw new RuntimeException("Unsupported layoutManager.");
                }
                this.b = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
        }

        private final int e(int[] iArr) {
            if (iArr == null) {
                return 0;
            }
            int i = 0;
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            com.transsion.room.adapter.d dVar;
            t6.f h0;
            t6.f h02;
            Intrinsics.h(recyclerView, "recyclerView");
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i != 0 || childCount <= 0 || this.b < itemCount - 1) {
                return;
            }
            com.transsion.room.adapter.d dVar2 = RoomFragment.this.mHotAdapter;
            if (((dVar2 == null || (h02 = dVar2.h0()) == null) ? null : h02.i()) != LoadMoreStatus.Fail || (dVar = RoomFragment.this.mHotAdapter) == null || (h0 = dVar.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            d(recyclerView);
        }
    }

    public static final class e implements yg.m {
        e() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            List data;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            com.transsion.room.adapter.d dVar = RoomFragment.this.mHotAdapter;
            if (dVar != null && (data = dVar.getData()) != null && data.isEmpty()) {
                RoomFragment.this.loadData();
                return;
            }
            com.transsion.room.adapter.d dVar2 = RoomFragment.this.mHotAdapter;
            if (dVar2 == null || (h0 = dVar2.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onDisconnected() {
        }
    }

    static final class f implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
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

    private final void i0() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        SwipeRefreshLayout swipeRefreshLayout;
        AdvRecyclerView advRecyclerView3;
        AdvRecyclerView advRecyclerView4;
        fp.m mVar = (fp.m) getMViewBinding();
        RecyclerView recyclerView = (mVar == null || (advRecyclerView4 = mVar.b) == null) ? null : advRecyclerView4.getRecyclerView();
        fp.m mVar2 = (fp.m) getMViewBinding();
        if (mVar2 != null && (advRecyclerView3 = mVar2.b) != null) {
            advRecyclerView3.setPageName("rooms");
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        com.transsion.room.adapter.d dVar = new com.transsion.room.adapter.d(new ArrayList());
        dVar.h0().z(true);
        dVar.h0().y(true);
        dVar.h0().E(4);
        dVar.h0().D(new r6.f() { // from class: com.transsion.room.fragment.k0
            public final void a() {
                RoomFragment.j0(RoomFragment.this);
            }
        });
        dVar.R0(new b());
        dVar.w1(new r6.d() { // from class: com.transsion.room.fragment.l0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomFragment.k0(RoomFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mHotAdapter = dVar;
        if (recyclerView != null) {
            recyclerView.setAdapter(dVar);
        }
        fp.m mVar3 = (fp.m) getMViewBinding();
        if (mVar3 != null && (swipeRefreshLayout = mVar3.c) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.m0
                public final void a() {
                    RoomFragment.l0(RoomFragment.this);
                }
            });
        }
        fp.m mVar4 = (fp.m) getMViewBinding();
        if (mVar4 != null && (advRecyclerView2 = mVar4.b) != null) {
            advRecyclerView2.setOnStateClickListener(new c());
        }
        fp.m mVar5 = (fp.m) getMViewBinding();
        if (mVar5 == null || (advRecyclerView = mVar5.b) == null) {
            return;
        }
        advRecyclerView.addOnScrollListener(new d());
    }

    private final void initViewModel() {
        RoomViewModel a = new androidx.lifecycle.v0(this).a(RoomViewModel.class);
        a.x().j(this, new f(new Function1() { // from class: com.transsion.room.fragment.n0
            public final Object invoke(Object obj) {
                Unit o0;
                o0 = RoomFragment.o0(RoomFragment.this, (RoomBean) obj);
                return o0;
            }
        }));
        this.mRoomViewModel = a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(RoomFragment roomFragment) {
        roomFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(RoomFragment roomFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        roomFragment.p0(baseQuickAdapter.getItem(i), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(RoomFragment roomFragment) {
        roomFragment.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        List data;
        SwipeRefreshLayout swipeRefreshLayout;
        fp.m mVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        this.isRefresh = true;
        this.mHotRoomPage = BuildConfig.FLAVOR;
        this.mPersonalRoomPage = BuildConfig.FLAVOR;
        if (yg.l.a.e()) {
            RoomViewModel roomViewModel = this.mRoomViewModel;
            if (roomViewModel != null) {
                roomViewModel.w(this.mHotRoomPage, this.mPerPage);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_tips);
        fp.m mVar2 = (fp.m) getMViewBinding();
        if (mVar2 != null && (swipeRefreshLayout = mVar2.c) != null && swipeRefreshLayout.isRefreshing() && (mVar = (fp.m) getMViewBinding()) != null && (swipeRefreshLayout2 = mVar.c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        com.transsion.room.adapter.d dVar = this.mHotAdapter;
        if (dVar == null || (data = dVar.getData()) == null || !data.isEmpty()) {
            return;
        }
        s0();
    }

    private final void loadMore() {
        t6.f h0;
        if (yg.l.a.e()) {
            RoomViewModel roomViewModel = this.mRoomViewModel;
            if (roomViewModel != null) {
                roomViewModel.w(this.mHotRoomPage, this.mPerPage);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_tips);
        com.transsion.room.adapter.d dVar = this.mHotAdapter;
        if (dVar == null || (h0 = dVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final void m0() {
        TitleLayout titleLayout;
        fp.m mVar = (fp.m) getMViewBinding();
        if (mVar == null || (titleLayout = mVar.d) == null) {
            return;
        }
        titleLayout.setTitleText(R$string.str_hot_room);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        activityResult.getResultCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(RoomFragment roomFragment, RoomBean roomBean) {
        t6.f h0;
        roomFragment.hideLoading();
        if (roomBean == null) {
            com.transsion.room.adapter.d dVar = roomFragment.mHotAdapter;
            if (dVar != null && (h0 = dVar.h0()) != null) {
                h0.v();
            }
        } else {
            roomFragment.u0(roomBean);
        }
        return Unit.a;
    }

    private final void p0(Object item, int position) {
        if (item instanceof RoomItem) {
            Intent intent = new Intent((Context) requireActivity(), (Class<?>) RoomDetailActivity.class);
            intent.putExtra("item", (Parcelable) item);
            androidx.activity.result.b bVar = this.requestRoomDetailLaunch;
            if (bVar != null) {
                bVar.a(intent);
            }
            HashMap hashMap = new HashMap();
            String groupId = ((RoomItem) item).getGroupId();
            if (groupId == null) {
                groupId = BuildConfig.FLAVOR;
            }
            hashMap.put("group_id", groupId);
            hashMap.put("sequence", String.valueOf(position));
            com.transsion.baselib.helper.a.a.b("rooms", hashMap);
        }
    }

    private final void q0() {
        kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), (CoroutineContext) null, (CoroutineStart) null, new RoomFragment$observerPublishEvent$1(this, null), 3, (Object) null);
    }

    private final void s0() {
        AdvRecyclerView advRecyclerView;
        fp.m mVar = (fp.m) getMViewBinding();
        if (mVar == null || (advRecyclerView = mVar.b) == null) {
            return;
        }
        advRecyclerView.showError();
    }

    private final void t0() {
        AdvRecyclerView advRecyclerView;
        fp.m mVar = (fp.m) getMViewBinding();
        if (mVar == null || (advRecyclerView = mVar.b) == null) {
            return;
        }
        advRecyclerView.showEmpty();
    }

    private final void u0(RoomBean roomBean) {
        String str;
        com.transsion.room.adapter.d dVar;
        t6.f h0;
        t6.f h02;
        com.transsion.room.adapter.d dVar2;
        t6.f h03;
        com.transsion.room.adapter.d dVar3;
        SwipeRefreshLayout swipeRefreshLayout;
        fp.m mVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        Pager pager = roomBean.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = BuildConfig.FLAVOR;
        }
        this.mHotRoomPage = str;
        r0();
        if (this.isRefresh) {
            this.isRefresh = false;
            fp.m mVar2 = (fp.m) getMViewBinding();
            if (mVar2 != null && (swipeRefreshLayout = mVar2.c) != null && swipeRefreshLayout.isRefreshing() && (mVar = (fp.m) getMViewBinding()) != null && (swipeRefreshLayout2 = mVar.c) != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
            List<RoomItem> items = roomBean.getItems();
            if (items != null && (dVar3 = this.mHotAdapter) != null) {
                dVar3.n1(items);
            }
            List<RoomItem> items2 = roomBean.getItems();
            if (items2 == null || !items2.isEmpty()) {
                return;
            }
            t0();
            return;
        }
        List<RoomItem> items3 = roomBean.getItems();
        if (items3 != null) {
            com.transsion.room.adapter.d dVar4 = this.mHotAdapter;
            List data = dVar4 != null ? dVar4.getData() : null;
            ArrayList arrayList = new ArrayList();
            if (data == null || !(!data.isEmpty())) {
                arrayList.addAll(items3);
            } else {
                for (RoomItem roomItem : items3) {
                    if (data.contains(roomItem)) {
                        a.a.f(wf.a.a, "room", "find same item name..." + roomItem.getName(), false, 4, (Object) null);
                    } else {
                        arrayList.add(roomItem);
                    }
                }
            }
            com.transsion.room.adapter.d dVar5 = this.mHotAdapter;
            if (dVar5 != null) {
                dVar5.q(arrayList);
            }
        }
        com.transsion.room.adapter.d dVar6 = this.mHotAdapter;
        if (dVar6 != null && (h02 = dVar6.h0()) != null && h02.r() && (dVar2 = this.mHotAdapter) != null && (h03 = dVar2.h0()) != null) {
            h03.s();
        }
        Pager pager2 = roomBean.getPager();
        if (!(pager2 != null ? Intrinsics.c(pager2.getHasMore(), Boolean.FALSE) : false) || (dVar = this.mHotAdapter) == null || (h0 = dVar.h0()) == null) {
            return;
        }
        t6.f.u(h0, false, 1, (Object) null);
    }

    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public fp.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.m c2 = fp.m.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        uf.c.e(view);
        m0();
        i0();
        initViewModel();
        setNetListener(new e());
        this.requestRoomDetailLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.j0
            public final void a(Object obj) {
                RoomFragment.n0((ActivityResult) obj);
            }
        });
        q0();
    }

    public void lazyLoadData() {
        startLoading();
        loadData();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("rooms", false, 2, null);
    }

    public void onDestroyView() {
        super.onDestroyView();
        androidx.activity.result.b bVar = this.requestRoomDetailLaunch;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final void r0() {
        AdvRecyclerView advRecyclerView;
        fp.m mVar = (fp.m) getMViewBinding();
        if (mVar != null && (advRecyclerView = mVar.b) != null) {
            advRecyclerView.showData();
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    public void startLoading() {
        AdvRecyclerView advRecyclerView;
        fp.m mVar = (fp.m) getMViewBinding();
        if (mVar == null || (advRecyclerView = mVar.b) == null) {
            return;
        }
        advRecyclerView.showProgress();
    }
}
