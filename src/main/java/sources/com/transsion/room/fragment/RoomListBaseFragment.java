package com.transsion.room.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomNet;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.publish.api.GroupBean;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J!\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0011H\u0016¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0011H\u0016¢\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u0019\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0011H&¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u001dH&¢\u0006\u0004\b5\u0010\u001fR$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR$\u0010X\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bT\u0010R\u001a\u0004\bU\u0010\u001f\"\u0004\bV\u0010WR\"\u0010_\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u001d\u0010o\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\"\u0010u\u001a\u0010\u0012\f\u0012\n r*\u0004\u0018\u00010q0q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006v"}, d2 = {"Lcom/transsion/room/fragment/RoomListBaseFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lfp/r;", "<init>", "()V", BuildConfig.FLAVOR, "initExposureHelper", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "item", BuildConfig.FLAVOR, "position", "I0", "(Lcom/transsion/moviedetailapi/bean/RoomItem;I)V", "s0", "D0", "H0", "(Lcom/transsion/moviedetailapi/bean/RoomItem;)V", BuildConfig.FLAVOR, "checkLogin", "()Z", "Landroid/view/LayoutInflater;", "inflater", "x0", "(Landroid/view/LayoutInflater;)Lfp/r;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "lazyLoadData", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "isShowPageStateLayoutTitle", "isAudioShowNoNetworkLayout", "getEmptyDescText", "initViewData", "initViewModel", "retryLoadData", "t0", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "bean", "J0", "(Lcom/transsion/moviedetailapi/bean/RoomBean;)V", "checkToShowEmptyView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "Lcom/transsion/room/adapter/RoomListFrom;", "w0", "()Lcom/transsion/room/adapter/RoomListFrom;", "isRefresh", "E0", "(Z)V", "pageName", "Lcom/transsion/room/adapter/RoomListAdapter;", "a", "Lcom/transsion/room/adapter/RoomListAdapter;", "u0", "()Lcom/transsion/room/adapter/RoomListAdapter;", "setMAdapter", "(Lcom/transsion/room/adapter/RoomListAdapter;)V", "mAdapter", "Lbj/b;", "b", "Lbj/b;", "mExposureHelper", "Lcom/transsion/room/viewmodel/RoomViewModel;", "c", "Lcom/transsion/room/viewmodel/RoomViewModel;", "v0", "()Lcom/transsion/room/viewmodel/RoomViewModel;", "setMViewModel", "(Lcom/transsion/room/viewmodel/RoomViewModel;)V", "mViewModel", "Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "d", "Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "mDetailViewModel", "e", "Z", "isSelectRoom", "f", "Ljava/lang/String;", "mPageFrom", "g", "getMPage", "setMPage", "(Ljava/lang/String;)V", "mPage", "h", "I", "getMPerPage", "()I", "setMPerPage", "(I)V", "mPerPage", "i", "Ljava/lang/Integer;", "mCurJoinPosition", "Lcom/tn/lib/view/RoomJoinAnimationView;", "j", "Lcom/tn/lib/view/RoomJoinAnimationView;", "mCurJoinView", "k", "Landroid/view/View;", "mLoadingView", "Lqx/a;", "l", "Lkotlin/Lazy;", "getMLoginApi", "()Lqx/a;", "mLoginApi", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "m", "Landroidx/activity/result/b;", "mLoginLaunch", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class RoomListBaseFragment extends LazyFragment<fp.r> {

    /* renamed from: a, reason: from kotlin metadata */
    private RoomListAdapter mAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private bj.b mExposureHelper;

    /* renamed from: c, reason: from kotlin metadata */
    private RoomViewModel mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    private RoomDetailViewModel mDetailViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isSelectRoom;

    /* renamed from: f, reason: from kotlin metadata */
    private String mPageFrom;

    /* renamed from: g, reason: from kotlin metadata */
    private String mPage;

    /* renamed from: i, reason: from kotlin metadata */
    private Integer mCurJoinPosition;

    /* renamed from: j, reason: from kotlin metadata */
    private RoomJoinAnimationView mCurJoinView;

    /* renamed from: k, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: m, reason: from kotlin metadata */
    private final androidx.activity.result.b mLoginLaunch;

    /* renamed from: h, reason: from kotlin metadata */
    private int mPerPage = 12;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.h1
        public final Object invoke() {
            qx.a mLoginApi_delegate$lambda$0;
            mLoginApi_delegate$lambda$0 = RoomListBaseFragment.mLoginApi_delegate$lambda$0();
            return mLoginApi_delegate$lambda$0;
        }
    });

    public static final class a implements bj.a {
        a() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            RoomItem roomItem;
            RoomListBaseFragment roomListBaseFragment = RoomListBaseFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                RoomListAdapter mAdapter = roomListBaseFragment.getMAdapter();
                if (mAdapter != null && (roomItem = (RoomItem) mAdapter.getItem(i)) != null) {
                    com.transsion.room.helper.l.a.i(roomListBaseFragment.mPageFrom, roomListBaseFragment.pageName(), i, j, roomItem);
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class b extends DiffUtil.e {
        b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(RoomItem roomItem, RoomItem roomItem2) {
            Intrinsics.h(roomItem, "oldItem");
            Intrinsics.h(roomItem2, "newItem");
            return Intrinsics.c(roomItem.getGroupId(), roomItem2.getGroupId());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(RoomItem roomItem, RoomItem roomItem2) {
            Intrinsics.h(roomItem, "oldItem");
            Intrinsics.h(roomItem2, "newItem");
            return Intrinsics.c(roomItem.getGroupId(), roomItem2.getGroupId());
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    public RoomListBaseFragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.i1
            public final void a(Object obj) {
                RoomListBaseFragment.G0(RoomListBaseFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.mLoginLaunch = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(RoomListBaseFragment roomListBaseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        if (Intrinsics.c(roomItem.getHasJoin(), Boolean.TRUE)) {
            roomListBaseFragment.I0(roomItem, i);
            return;
        }
        roomListBaseFragment.mCurJoinPosition = Integer.valueOf(i);
        roomListBaseFragment.mCurJoinView = (RoomJoinAnimationView) view;
        roomListBaseFragment.D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(RoomListBaseFragment roomListBaseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        if (roomListBaseFragment.isSelectRoom) {
            roomListBaseFragment.H0(roomItem);
        } else {
            roomListBaseFragment.I0(roomItem, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(RoomListBaseFragment roomListBaseFragment, RoomNet roomNet) {
        if (roomNet == null) {
            RoomJoinAnimationView roomJoinAnimationView = roomListBaseFragment.mCurJoinView;
            if (roomJoinAnimationView != null) {
                roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
            }
        } else {
            RoomJoinAnimationView roomJoinAnimationView2 = roomListBaseFragment.mCurJoinView;
            if (roomJoinAnimationView2 != null) {
                roomJoinAnimationView2.setStatus(RoomJoinStatus.JOINED);
            }
        }
        roomListBaseFragment.mCurJoinView = null;
        roomListBaseFragment.mCurJoinPosition = null;
        return Unit.a;
    }

    private final void D0() {
        Integer num;
        RoomItem roomItem;
        String groupId;
        RoomJoinAnimationView roomJoinAnimationView = this.mCurJoinView;
        if ((roomJoinAnimationView == null || !roomJoinAnimationView.isLoading()) && checkLogin() && (num = this.mCurJoinPosition) != null) {
            Intrinsics.e(num);
            if (num.intValue() < 0) {
                return;
            }
            RoomListAdapter roomListAdapter = this.mAdapter;
            if (roomListAdapter != null) {
                Integer num2 = this.mCurJoinPosition;
                Intrinsics.e(num2);
                roomItem = (RoomItem) roomListAdapter.getItem(num2.intValue());
            } else {
                roomItem = null;
            }
            if (com.transsion.baseui.util.c.a.a(1001, 2000L)) {
                return;
            }
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            if (roomItem == null || (groupId = roomItem.getGroupId()) == null) {
                return;
            }
            RoomJoinAnimationView roomJoinAnimationView2 = this.mCurJoinView;
            if (roomJoinAnimationView2 != null) {
                roomJoinAnimationView2.setStatus(RoomJoinStatus.LOADING);
            }
            RoomDetailViewModel roomDetailViewModel = this.mDetailViewModel;
            if (roomDetailViewModel != null) {
                roomDetailViewModel.w(groupId);
            }
            com.transsion.baselib.helper.a.a.h(pageName(), "join", (r16 & 4) != 0 ? BuildConfig.FLAVOR : groupId, (r16 & 8) != 0 ? BuildConfig.FLAVOR : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : null);
        }
    }

    public static /* synthetic */ void F0(RoomListBaseFragment roomListBaseFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        roomListBaseFragment.E0(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(RoomListBaseFragment roomListBaseFragment, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        if (activityResult.getResultCode() == -1) {
            roomListBaseFragment.D0();
            return;
        }
        RoomJoinAnimationView roomJoinAnimationView = roomListBaseFragment.mCurJoinView;
        if (roomJoinAnimationView != null) {
            roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
        }
        roomListBaseFragment.mCurJoinView = null;
        roomListBaseFragment.mCurJoinPosition = null;
    }

    private final void H0(RoomItem item) {
        a.a.f(wf.a.a, "RoomList", "onSelectRoom, name:" + item.getName() + ",id:" + item.getGroupId(), false, 4, (Object) null);
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupId(item.getGroupId());
        groupBean.setName(item.getName());
        groupBean.setDes(item.getDescription());
        groupBean.setDescription(item.getDescription());
        groupBean.setPostCount(String.valueOf(item.getPostCount()));
        groupBean.setAvatar(item.getAvatar());
        groupBean.setNewPostCount(String.valueOf(item.getNewPostCount()));
        groupBean.setOps(item.getOps());
        jo.b bVar = new jo.b();
        bVar.o(6);
        bVar.n(1);
        bVar.m(groupBean);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void I0(RoomItem item, int position) {
        if (item != null) {
            com.transsion.room.helper.l.a.j(this.mPageFrom, pageName(), position, item);
        }
        Navigator.x(TheRouter.c("/room/detail").I("item", item).K("id", item != null ? item.getGroupId() : null), requireContext(), (mf.c) null, 2, (Object) null);
        s0(item, position);
    }

    private final boolean checkLogin() {
        qx.a mLoginApi;
        qx.a mLoginApi2 = getMLoginApi();
        if (mLoginApi2 != null && mLoginApi2.a()) {
            return true;
        }
        androidx.activity.result.b bVar = this.mLoginLaunch;
        Context context = getContext();
        Intent intent = null;
        if (context != null && (mLoginApi = getMLoginApi()) != null) {
            intent = mLoginApi.p(context);
        }
        bVar.a(intent);
        return false;
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    private final void initExposureHelper() {
        RecyclerView recyclerView;
        bj.b bVar = new bj.b(0.6f, new a(), false, 4, null);
        bVar.n(2);
        fp.r rVar = (fp.r) getMViewBinding();
        if (rVar != null && (recyclerView = rVar.b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void s0(RoomItem item, int position) {
        if (item != null) {
            item.setNewPostCount(0L);
        }
        RoomListAdapter roomListAdapter = this.mAdapter;
        if (roomListAdapter != null) {
            roomListAdapter.notifyItemChanged(position, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(RoomListBaseFragment roomListBaseFragment) {
        roomListBaseFragment.t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(RoomListBaseFragment roomListBaseFragment) {
        roomListBaseFragment.E0(false);
    }

    public abstract void E0(boolean isRefresh);

    public void J0(RoomBean bean) {
        List arrayList;
        t6.f h0;
        t6.f h02;
        Pager pager;
        t6.f h03;
        List<RoomItem> items;
        t6.f h04;
        RoomListAdapter roomListAdapter;
        t6.f h05;
        t6.f h06;
        RoomListAdapter roomListAdapter2;
        t6.f h07;
        SwipeRefreshLayout swipeRefreshLayout;
        fp.r rVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        fp.r rVar2 = (fp.r) getMViewBinding();
        if (rVar2 != null && (swipeRefreshLayout = rVar2.c) != null && swipeRefreshLayout.isRefreshing() && (rVar = (fp.r) getMViewBinding()) != null && (swipeRefreshLayout2 = rVar.c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        showContentView();
        RoomListAdapter roomListAdapter3 = this.mAdapter;
        if (roomListAdapter3 == null || (arrayList = roomListAdapter3.getData()) == null) {
            arrayList = new ArrayList();
        }
        if (bean == null || (items = bean.getItems()) == null || items.isEmpty()) {
            if (arrayList.isEmpty()) {
                checkToShowEmptyView();
                return;
            }
            RoomListAdapter roomListAdapter4 = this.mAdapter;
            if ((roomListAdapter4 == null || (h03 = roomListAdapter4.h0()) == null || !h03.r()) ? false : true) {
                if ((bean == null || (pager = bean.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                    RoomListAdapter roomListAdapter5 = this.mAdapter;
                    if (roomListAdapter5 == null || (h0 = roomListAdapter5.h0()) == null) {
                        return;
                    }
                    h0.v();
                    return;
                }
                RoomListAdapter roomListAdapter6 = this.mAdapter;
                if (roomListAdapter6 == null || (h02 = roomListAdapter6.h0()) == null) {
                    return;
                }
                t6.f.u(h02, false, 1, (Object) null);
                return;
            }
            return;
        }
        Pager pager2 = bean.getPager();
        this.mPage = pager2 != null ? pager2.getNextPage() : null;
        if (bean.getIsRefresh()) {
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            RoomListAdapter roomListAdapter7 = this.mAdapter;
            if (roomListAdapter7 != null) {
                roomListAdapter7.n1(bean.getItems());
            }
        } else {
            List<RoomItem> items2 = bean.getItems();
            if (items2 != null) {
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.isEmpty()) {
                    arrayList2.addAll(items2);
                } else {
                    for (RoomItem roomItem : items2) {
                        if (!arrayList.contains(roomItem)) {
                            arrayList2.add(roomItem);
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    RoomListAdapter roomListAdapter8 = this.mAdapter;
                    if (roomListAdapter8 != null && (h04 = roomListAdapter8.h0()) != null) {
                        t6.f.u(h04, false, 1, (Object) null);
                    }
                    if (arrayList.isEmpty()) {
                        checkToShowEmptyView();
                    }
                } else {
                    RoomListAdapter roomListAdapter9 = this.mAdapter;
                    if (roomListAdapter9 != null) {
                        roomListAdapter9.q(arrayList2);
                    }
                }
            }
        }
        RoomListAdapter roomListAdapter10 = this.mAdapter;
        if (roomListAdapter10 != null && (h06 = roomListAdapter10.h0()) != null && h06.r() && (roomListAdapter2 = this.mAdapter) != null && (h07 = roomListAdapter2.h0()) != null) {
            h07.s();
        }
        Pager pager3 = bean.getPager();
        if ((pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false) || (roomListAdapter = this.mAdapter) == null || (h05 = roomListAdapter.h0()) == null) {
            return;
        }
        t6.f.u(h05, false, 1, (Object) null);
    }

    public void checkToShowEmptyView() {
        if (yg.l.a.e()) {
            RoomListAdapter roomListAdapter = this.mAdapter;
            if (roomListAdapter != null) {
                roomListAdapter.Y0(getEmptyView(false));
                return;
            }
            return;
        }
        RoomListAdapter roomListAdapter2 = this.mAdapter;
        if (roomListAdapter2 != null) {
            roomListAdapter2.Y0(getLocalNoNetworkView(false));
        }
    }

    public String getEmptyDescText() {
        String string = getString(com.transsion.usercenter.R.string.profile_not_content);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public View getLoadingView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = LayoutInflater.from(requireContext()).inflate(R$layout.layout_room_list_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.mLoadingView;
    }

    protected final String getMPage() {
        return this.mPage;
    }

    protected final int getMPerPage() {
        return this.mPerPage;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initViewData() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        initExposureHelper();
        fp.r rVar = (fp.r) getMViewBinding();
        if (rVar != null && (swipeRefreshLayout = rVar.c) != null) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.bg_01));
            swipeRefreshLayout.setColorSchemeColors(new int[]{androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R.color.main_gradient_start)});
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.j1
                public final void a() {
                    RoomListBaseFragment.y0(RoomListBaseFragment.this);
                }
            });
        }
        RoomListAdapter roomListAdapter = new RoomListAdapter(w0(), this.isSelectRoom);
        roomListAdapter.h0().z(true);
        roomListAdapter.h0().y(true);
        roomListAdapter.h0().E(3);
        roomListAdapter.h0().D(new r6.f() { // from class: com.transsion.room.fragment.k1
            public final void a() {
                RoomListBaseFragment.z0(RoomListBaseFragment.this);
            }
        });
        roomListAdapter.R0(new b());
        roomListAdapter.l(new int[]{R$id.v_join});
        roomListAdapter.s1(new r6.b() { // from class: com.transsion.room.fragment.l1
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomListBaseFragment.A0(RoomListBaseFragment.this, baseQuickAdapter, view, i);
            }
        });
        roomListAdapter.w1(new r6.d() { // from class: com.transsion.room.fragment.m1
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomListBaseFragment.B0(RoomListBaseFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = roomListAdapter;
        fp.r rVar2 = (fp.r) getMViewBinding();
        if (rVar2 == null || (recyclerView = rVar2.b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    public void initViewModel() {
        RoomListAdapter roomListAdapter;
        LiveData s;
        RoomDetailViewModel roomDetailViewModel = this.mDetailViewModel;
        if (roomDetailViewModel != null && (s = roomDetailViewModel.s()) != null) {
            s.j(this, new c(new Function1() { // from class: com.transsion.room.fragment.g1
                public final Object invoke(Object obj) {
                    Unit C0;
                    C0 = RoomListBaseFragment.C0(RoomListBaseFragment.this, (RoomNet) obj);
                    return C0;
                }
            }));
        }
        if (yg.l.a.e() || (roomListAdapter = this.mAdapter) == null) {
            return;
        }
        roomListAdapter.Y0(getLocalNoNetworkView(false));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        showLoadingView();
        F0(this, false, 1, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.isSelectRoom = arguments != null ? arguments.getBoolean("is_select_room") : false;
        this.mViewModel = new androidx.lifecycle.v0(this).a(RoomViewModel.class);
        this.mDetailViewModel = (RoomDetailViewModel) new androidx.lifecycle.v0(this).a(RoomDetailViewModel.class);
        this.mPageFrom = qi.h.a.h();
    }

    public abstract String pageName();

    public void retryLoadData() {
        showLoadingView();
        F0(this, false, 1, null);
    }

    public void t0() {
        this.mPage = null;
        F0(this, false, 1, null);
    }

    /* renamed from: u0, reason: from getter */
    protected final RoomListAdapter getMAdapter() {
        return this.mAdapter;
    }

    /* renamed from: v0, reason: from getter */
    protected final RoomViewModel getMViewModel() {
        return this.mViewModel;
    }

    public abstract RoomListFrom w0();

    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public fp.r getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.r c2 = fp.r.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
