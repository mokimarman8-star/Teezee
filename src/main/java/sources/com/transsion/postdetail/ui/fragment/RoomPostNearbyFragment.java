package com.transsion.postdetail.ui.fragment;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u001fH\u0016¢\u0006\u0004\b&\u0010!J\u000f\u0010'\u001a\u00020\u001fH\u0016¢\u0006\u0004\b'\u0010!J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00101R\u0018\u0010:\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00101R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010F\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/RoomPostNearbyFragment;", "Lcom/transsion/postdetail/ui/fragment/RoomPostBaseFragment;", "<init>", "()V", BuildConfig.FLAVOR, "checkGPS", BuildConfig.FLAVOR, "forceRequest", "checkPermission", "(Z)V", "requestLocationPermission", "addLocationHeaderView", "getCurrentLocation", "removeLocationHeaderView", "removeEmptyView", "loadRecommendRooms", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewData", "initViewModel", "lazyLoadData", "checkToShowEmptyView", "Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "postAdapterFrom", "()Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "onItemHeaderClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", BuildConfig.FLAVOR, "onItemHeaderModuleName", "()Ljava/lang/String;", "isFirstLoad", "isRefresh", "loadData", "(ZZ)V", "pageName", "subpageName", "isSwipeRefreshEnable", "()Z", "isNeedInsertPublishPost", BuildConfig.FLAVOR, "tabIndex", "()I", "isStaggeredPost", "Landroid/view/View;", "locationPermissionHeaderView", "Landroid/view/View;", BuildConfig.FLAVOR, "lat", "Ljava/lang/Double;", "lon", "Landroid/location/Address;", "address", "Landroid/location/Address;", "mEmptyView", "mNoNetView", "isRoomListRequested", "Z", "isInsertRoom", "Lep/c;", "mGpsServiceHelper", "Lep/c;", "Lep/f;", "mRoomApi$delegate", "Lkotlin/Lazy;", "getMRoomApi", "()Lep/f;", "mRoomApi", "Companion", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomPostNearbyFragment extends RoomPostBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_PERMISSION_REQUESTED = "key_lo_per_requested";
    public static final String SUBPAGE_NAME = "room_home_nearby";
    public static final String TAG = "RoomPostNearby";
    private Address address;
    private boolean isInsertRoom;
    private boolean isRoomListRequested;
    private Double lat;
    private View locationPermissionHeaderView;
    private Double lon;
    private View mEmptyView;
    private ep.c mGpsServiceHelper;
    private View mNoNetView;

    /* renamed from: mRoomApi$delegate, reason: from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.p4
        public final Object invoke() {
            ep.f mRoomApi_delegate$lambda$0;
            mRoomApi_delegate$lambda$0 = RoomPostNearbyFragment.mRoomApi_delegate$lambda$0();
            return mRoomApi_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomPostNearbyFragment a(String str) {
            RoomPostNearbyFragment roomPostNearbyFragment = new RoomPostNearbyFragment();
            roomPostNearbyFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("parent_type", str)}));
            return roomPostNearbyFragment;
        }
    }

    static final class b implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
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

    private final void addLocationHeaderView() {
        RecyclerView recyclerView;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing() || this.locationPermissionHeaderView != null) {
            return;
        }
        final View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_location_permission_header, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.tv_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomPostNearbyFragment.this.requestLocationPermission();
            }
        });
        com.transsion.postdetail.ui.adapter.f mAdapter = getMAdapter();
        if (mAdapter != null) {
            Intrinsics.e(inflate);
            BaseQuickAdapter.y(mAdapter, inflate, 0, 0, 6, (Object) null);
        }
        wn.p pVar = (wn.p) getMViewBinding();
        if (pVar != null && (recyclerView = pVar.b) != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.o4
                @Override // java.lang.Runnable
                public final void run() {
                    RoomPostNearbyFragment.addLocationHeaderView$lambda$11$lambda$10(inflate, this);
                }
            });
        }
        this.locationPermissionHeaderView = inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLocationHeaderView$lambda$11$lambda$10(View view, RoomPostNearbyFragment roomPostNearbyFragment) {
        Unit unit;
        RecyclerView recyclerView;
        try {
            Result.Companion companion = Result.Companion;
            wn.p pVar = (wn.p) roomPostNearbyFragment.getMViewBinding();
            if (pVar == null || (recyclerView = pVar.b) == null) {
                unit = null;
            } else {
                recyclerView.scrollToPosition(0);
                unit = Unit.a;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void checkGPS() {
        FrameLayout root;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        ep.c cVar = this.mGpsServiceHelper;
        if (cVar != null && cVar.b()) {
            a.a.f(wf.a.a, "NearbyLocation", "GPS is open, checkPermission", false, 4, (Object) null);
            wn.p pVar = (wn.p) getMViewBinding();
            if (pVar == null || (root = pVar.getRoot()) == null) {
                return;
            }
            root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.k4
                @Override // java.lang.Runnable
                public final void run() {
                    RoomPostNearbyFragment.this.checkPermission(false);
                }
            });
            return;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (bVar.b().getBoolean(KEY_PERMISSION_REQUESTED, false)) {
            addLocationHeaderView();
            showLoadingView();
            RoomPostBaseFragment.loadData$default(this, true, false, 2, null);
        } else {
            bVar.b().putBoolean(KEY_PERMISSION_REQUESTED, true);
            ep.c cVar2 = this.mGpsServiceHelper;
            if (cVar2 != null) {
                cVar2.a(new Function1() { // from class: com.transsion.postdetail.ui.fragment.m4
                    public final Object invoke(Object obj) {
                        Unit checkGPS$lambda$6;
                        checkGPS$lambda$6 = RoomPostNearbyFragment.checkGPS$lambda$6(RoomPostNearbyFragment.this, ((Boolean) obj).booleanValue());
                        return checkGPS$lambda$6;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkGPS$lambda$6(final RoomPostNearbyFragment roomPostNearbyFragment, boolean z) {
        FrameLayout root;
        if (!roomPostNearbyFragment.isAdded() || roomPostNearbyFragment.isDetached() || roomPostNearbyFragment.isRemoving()) {
            return Unit.a;
        }
        a.a.f(wf.a.a, "NearbyLocation", "openGPS result:" + z, false, 4, (Object) null);
        wn.p pVar = (wn.p) roomPostNearbyFragment.getMViewBinding();
        if (pVar != null && (root = pVar.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.s4
                @Override // java.lang.Runnable
                public final void run() {
                    RoomPostNearbyFragment.this.checkPermission(true);
                }
            });
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPermission(boolean forceRequest) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (cf.c.a.f(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            getCurrentLocation();
            return;
        }
        if (forceRequest) {
            a.a.f(wf.a.a, "NearbyLocation", "checkPermission forceRequest permission", false, 4, (Object) null);
            requestLocationPermission();
        } else {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            if (bVar.b().getBoolean(KEY_PERMISSION_REQUESTED, false)) {
                a.a.f(wf.a.a, "NearbyLocation", "checkPermission other,show header", false, 4, (Object) null);
                addLocationHeaderView();
            } else {
                a.a.f(wf.a.a, "NearbyLocation", "checkPermission first", false, 4, (Object) null);
                bVar.b().putBoolean(KEY_PERMISSION_REQUESTED, true);
                requestLocationPermission();
            }
        }
        showLoadingView();
        RoomPostBaseFragment.loadData$default(this, false, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkToShowEmptyView$lambda$16(RoomPostNearbyFragment roomPostNearbyFragment, View view) {
        com.transsion.postdetail.ui.adapter.f mAdapter = roomPostNearbyFragment.getMAdapter();
        if (mAdapter != null) {
            BaseQuickAdapter.y(mAdapter, view, 1, 0, 4, (Object) null);
        }
    }

    private final void getCurrentLocation() {
        ep.f mRoomApi;
        FragmentActivity activity = getActivity();
        if (activity == null || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.b(activity, new Function1() { // from class: com.transsion.postdetail.ui.fragment.l4
            public final Object invoke(Object obj) {
                Unit currentLocation$lambda$12;
                currentLocation$lambda$12 = RoomPostNearbyFragment.getCurrentLocation$lambda$12(RoomPostNearbyFragment.this, (LocationPlace) obj);
                return currentLocation$lambda$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCurrentLocation$lambda$12(RoomPostNearbyFragment roomPostNearbyFragment, LocationPlace locationPlace) {
        if (!roomPostNearbyFragment.isAdded() || roomPostNearbyFragment.isDetached() || roomPostNearbyFragment.isRemoving()) {
            return Unit.a;
        }
        roomPostNearbyFragment.lat = locationPlace != null ? locationPlace.getLat() : null;
        roomPostNearbyFragment.lon = locationPlace != null ? locationPlace.getLon() : null;
        roomPostNearbyFragment.address = locationPlace != null ? locationPlace.getLocationAddress() : null;
        a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "get location success load data again", false, 4, (Object) null);
        roomPostNearbyFragment.loadRecommendRooms();
        roomPostNearbyFragment.showLoadingView();
        RoomPostBaseFragment.loadData$default(roomPostNearbyFragment, false, false, 3, null);
        return Unit.a;
    }

    private final ep.f getMRoomApi() {
        return (ep.f) this.mRoomApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$1(RoomPostNearbyFragment roomPostNearbyFragment, PostSubjectBean postSubjectBean) {
        List<RoomItem> list;
        androidx.lifecycle.b0 L;
        RoomBean roomBean;
        RoomPostViewModel mViewModel = roomPostNearbyFragment.getMViewModel();
        List<RoomItem> items = (mViewModel == null || (L = mViewModel.L()) == null || (roomBean = (RoomBean) L.f()) == null) ? null : roomBean.getItems();
        if (roomPostNearbyFragment.isRoomListRequested && !roomPostNearbyFragment.isInsertRoom) {
            List<PostSubjectItem> items2 = postSubjectBean != null ? postSubjectBean.getItems() : null;
            if (items2 != null && !items2.isEmpty() && (list = items) != null && !list.isEmpty()) {
                if ((items != null ? items.size() : 0) >= 3) {
                    a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "帖子列表成功，room推荐已成功，插入数据", false, 4, (Object) null);
                    PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, true, items, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -50331649, 1, (DefaultConstructorMarker) null);
                    List<PostSubjectItem> items3 = postSubjectBean.getItems();
                    if ((items3 != null ? items3.size() : 0) > 2) {
                        List<PostSubjectItem> items4 = postSubjectBean.getItems();
                        if (items4 != null) {
                            items4.add(2, postSubjectItem);
                        }
                    } else {
                        List<PostSubjectItem> items5 = postSubjectBean.getItems();
                        if (items5 != null) {
                            items5.add(postSubjectItem);
                        }
                    }
                    roomPostNearbyFragment.isInsertRoom = true;
                    roomPostNearbyFragment.removeEmptyView();
                    roomPostNearbyFragment.updateData(postSubjectBean);
                    return Unit.a;
                }
            }
        }
        a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "帖子列表成功，room推荐:" + roomPostNearbyFragment.isRoomListRequested + "，不插入数据", false, 4, (Object) null);
        roomPostNearbyFragment.removeEmptyView();
        roomPostNearbyFragment.updateData(postSubjectBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$3(RoomPostNearbyFragment roomPostNearbyFragment, RoomBean roomBean) {
        Unit unit;
        List data;
        roomPostNearbyFragment.isRoomListRequested = true;
        List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
        List<RoomItem> list = items;
        if (list == null || list.isEmpty()) {
            a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "room 推荐列表成功，属于为空，不处理", false, 4, (Object) null);
            return Unit.a;
        }
        if (items.size() < 3) {
            a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "room 推荐列表成功，少于3个，直接隐藏", false, 4, (Object) null);
            return Unit.a;
        }
        PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, true, items, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -50331649, 1, (DefaultConstructorMarker) null);
        com.transsion.postdetail.ui.adapter.f mAdapter = roomPostNearbyFragment.getMAdapter();
        int itemCount = mAdapter != null ? mAdapter.getItemCount() : 0;
        if (itemCount > 0) {
            a.a.f(wf.a.a, roomPostNearbyFragment.getTAG(), "room 推荐列表成功，帖子列表已返回，直接插入， " + items.size(), false, 4, (Object) null);
            if (itemCount > 2) {
                itemCount = 2;
            }
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.postdetail.ui.adapter.f mAdapter2 = roomPostNearbyFragment.getMAdapter();
                if (mAdapter2 != null && (data = mAdapter2.getData()) != null) {
                    data.add(itemCount, postSubjectItem);
                }
                com.transsion.postdetail.ui.adapter.f mAdapter3 = roomPostNearbyFragment.getMAdapter();
                if (mAdapter3 != null) {
                    mAdapter3.notifyItemInserted(itemCount);
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        return Unit.a;
    }

    private final void loadRecommendRooms() {
        RoomPostViewModel mViewModel;
        if (this.lat == null || this.lon == null || (mViewModel = getMViewModel()) == null) {
            return;
        }
        Double d = this.lat;
        Intrinsics.e(d);
        double doubleValue = d.doubleValue();
        Double d2 = this.lon;
        Intrinsics.e(d2);
        mViewModel.K(doubleValue, d2.doubleValue(), this.address);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.f mRoomApi_delegate$lambda$0() {
        return (ep.f) TheRouter.d(ep.f.class, new Object[0]);
    }

    private final void removeEmptyView() {
        View view = this.mNoNetView;
        if (view != null) {
            com.transsion.postdetail.ui.adapter.f mAdapter = getMAdapter();
            if (mAdapter != null) {
                mAdapter.J0(view);
            }
            this.mNoNetView = null;
        }
        View view2 = this.mEmptyView;
        if (view2 != null) {
            com.transsion.postdetail.ui.adapter.f mAdapter2 = getMAdapter();
            if (mAdapter2 != null) {
                mAdapter2.J0(view2);
            }
            this.mEmptyView = null;
        }
    }

    private final void removeLocationHeaderView() {
        View view = this.locationPermissionHeaderView;
        if (view != null) {
            com.transsion.postdetail.ui.adapter.f mAdapter = getMAdapter();
            if (mAdapter != null) {
                mAdapter.J0(view);
            }
            this.locationPermissionHeaderView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLocationPermission() {
        ep.f mRoomApi;
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving() || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.a(activity, false, new Function1() { // from class: com.transsion.postdetail.ui.fragment.r4
            public final Object invoke(Object obj) {
                Unit requestLocationPermission$lambda$7;
                requestLocationPermission$lambda$7 = RoomPostNearbyFragment.requestLocationPermission$lambda$7(RoomPostNearbyFragment.this, ((Boolean) obj).booleanValue());
                return requestLocationPermission$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestLocationPermission$lambda$7(RoomPostNearbyFragment roomPostNearbyFragment, boolean z) {
        if (z) {
            a.a.f(wf.a.a, "NearbyLocation", "checkPermission permission Granted， get location", false, 4, (Object) null);
            roomPostNearbyFragment.removeLocationHeaderView();
            roomPostNearbyFragment.getCurrentLocation();
        } else {
            a.a.f(wf.a.a, "NearbyLocation", "checkPermission permission denied, show header", false, 4, (Object) null);
            roomPostNearbyFragment.addLocationHeaderView();
        }
        return Unit.a;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void checkToShowEmptyView() {
        final View emptyView;
        FrameLayout root;
        if (this.locationPermissionHeaderView == null) {
            super.checkToShowEmptyView();
            return;
        }
        if (yg.l.a.e()) {
            emptyView = getEmptyView(false);
            this.mEmptyView = emptyView;
        } else {
            emptyView = getLocalNoNetworkView(false);
            this.mNoNetView = emptyView;
        }
        wn.p pVar = (wn.p) getMViewBinding();
        if (pVar == null || (root = pVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.q4
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostNearbyFragment.checkToShowEmptyView$lambda$16(RoomPostNearbyFragment.this, emptyView);
            }
        });
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void initViewData() {
        super.initViewData();
    }

    public void initViewModel() {
        androidx.lifecycle.b0 L;
        androidx.lifecycle.b0 A;
        RoomPostViewModel mViewModel = getMViewModel();
        if (mViewModel != null && (A = mViewModel.A()) != null) {
            A.j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.fragment.t4
                public final Object invoke(Object obj) {
                    Unit initViewModel$lambda$1;
                    initViewModel$lambda$1 = RoomPostNearbyFragment.initViewModel$lambda$1(RoomPostNearbyFragment.this, (PostSubjectBean) obj);
                    return initViewModel$lambda$1;
                }
            }));
        }
        RoomPostViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 == null || (L = mViewModel2.L()) == null) {
            return;
        }
        L.j(this, new b(new Function1() { // from class: com.transsion.postdetail.ui.fragment.u4
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$3;
                initViewModel$lambda$3 = RoomPostNearbyFragment.initViewModel$lambda$3(RoomPostNearbyFragment.this, (RoomBean) obj);
                return initViewModel$lambda$3;
            }
        }));
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isNeedInsertPublishPost() {
        return true;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isStaggeredPost() {
        return false;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean isSwipeRefreshEnable() {
        return false;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        checkGPS();
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void loadData(boolean isFirstLoad, boolean isRefresh) {
        if (isRefresh) {
            this.isInsertRoom = false;
            loadRecommendRooms();
        }
        RoomPostViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            String mPage = getMPage();
            int mPerPage = getMPerPage();
            Double d = this.lat;
            double doubleValue = d != null ? d.doubleValue() : 0.0d;
            Double d2 = this.lon;
            mViewModel.F(isRefresh, mPage, mPerPage, doubleValue, d2 != null ? d2.doubleValue() : 0.0d);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        setMParentTypeName(arguments != null ? arguments.getString("parent_type") : null);
        ep.f mRoomApi = getMRoomApi();
        this.mGpsServiceHelper = mRoomApi != null ? mRoomApi.f(this) : null;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void onItemHeaderClick(PostSubjectItem item) {
        openUserCenter(item);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String onItemHeaderModuleName() {
        return "user_center";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String pageName() {
        return "room_home";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public PostAdapterFrom postAdapterFrom() {
        return PostAdapterFrom.NEARBY;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String subpageName() {
        return SUBPAGE_NAME;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public int tabIndex() {
        return 1;
    }
}
