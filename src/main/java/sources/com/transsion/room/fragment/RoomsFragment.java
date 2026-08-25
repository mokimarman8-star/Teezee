package com.transsion.room.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.room.R$string;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import qx.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001>B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eR\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001d\u0010<\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/transsion/room/fragment/RoomsFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lqx/b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", BuildConfig.FLAVOR, "s0", "()Ljava/lang/String;", "getPageStateLayoutTitle", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "initViewData", "initViewModel", "x0", "G0", "loadMore", "lazyLoadData", "loadDefaultData", "retryLoadData", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsnet/loginapi/bean/UserInfo;", "user", "onLogin", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "getEmptyDescText", "Lcom/transsion/room/viewmodel/RoomViewModel;", "b", "Lcom/transsion/room/viewmodel/RoomViewModel;", "mRoomViewModel", "c", "Ljava/lang/String;", "mPageNum", BuildConfig.FLAVOR, "d", "I", "mPerPage", "e", "mUserId", "f", "Z", "isSelf", "Lqx/a;", "g", "Lkotlin/Lazy;", "getMLoginApi", "()Lqx/a;", "mLoginApi", "h", "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomsFragment extends BaseListFragment<RoomItem> implements qx.b {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private RoomViewModel mRoomViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean isSelf;

    /* renamed from: c, reason: from kotlin metadata */
    private String mPageNum = BuildConfig.FLAVOR;

    /* renamed from: d, reason: from kotlin metadata */
    private int mPerPage = 10;

    /* renamed from: e, reason: from kotlin metadata */
    private String mUserId = BuildConfig.FLAVOR;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.a2
        public final Object invoke() {
            qx.a mLoginApi_delegate$lambda$0;
            mLoginApi_delegate$lambda$0 = RoomsFragment.mLoginApi_delegate$lambda$0();
            return mLoginApi_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.room.fragment.RoomsFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomsFragment a(String str, boolean z) {
            RoomsFragment roomsFragment = new RoomsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("m_User_Id", str);
            bundle.putBoolean("is_Self", z);
            roomsFragment.setArguments(bundle);
            return roomsFragment;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(com.transsion.room.adapter.a aVar, RoomsFragment roomsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        Navigator.x(TheRouter.c("/room/detail").I("item", (Parcelable) aVar.getItem(i)), roomsFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(RoomsFragment roomsFragment, RoomBean roomBean) {
        List<RoomItem> items;
        Pager pager;
        if (roomBean != null && (pager = roomBean.getPager()) != null) {
            if (Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                String nextPage = pager.getNextPage();
                if (nextPage == null) {
                    nextPage = BuildConfig.FLAVOR;
                }
                roomsFragment.mPageNum = nextPage;
                Integer perPage = pager.getPerPage();
                roomsFragment.mPerPage = perPage != null ? perPage.intValue() : 10;
                roomsFragment.B0();
            } else {
                BaseListFragment.D0(roomsFragment, false, 1, null);
            }
        }
        if (roomBean == null || (items = roomBean.getItems()) == null) {
            roomsFragment.N0();
        } else if (roomsFragment.A0()) {
            roomsFragment.I0(false);
            BaseQuickAdapter mBaseAdapter = roomsFragment.getMBaseAdapter();
            if (mBaseAdapter != null) {
                mBaseAdapter.n1(items);
            }
            if (items.isEmpty()) {
                BaseListFragment.K0(roomsFragment, null, 1, null);
            }
        } else {
            BaseQuickAdapter mBaseAdapter2 = roomsFragment.getMBaseAdapter();
            if (mBaseAdapter2 != null) {
                mBaseAdapter2.q(items);
            }
        }
        return Unit.a;
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
        this.mPageNum = BuildConfig.FLAVOR;
        I0(true);
        loadDefaultData();
    }

    public String getEmptyDescText() {
        String string = getString(R$string.not_in_any_rooms);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        I0(true);
    }

    public void initViewModel() {
        RoomViewModel a = new androidx.lifecycle.v0(this).a(RoomViewModel.class);
        a.C().j(this, new b(new Function1() { // from class: com.transsion.room.fragment.c2
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = RoomsFragment.S0(RoomsFragment.this, (RoomBean) obj);
                return S0;
            }
        }));
        this.mRoomViewModel = a;
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    public void loadDefaultData() {
        RoomViewModel roomViewModel = this.mRoomViewModel;
        if (roomViewModel != null) {
            roomViewModel.B(this.mPageNum, this.mPerPage, this.mUserId);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        if (TextUtils.isEmpty(this.mPageNum) || TextUtils.equals("0", this.mPageNum)) {
            BaseListFragment.D0(this, false, 1, null);
        } else {
            loadDefaultData();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        return null;
    }

    public qi.b newLogViewConfig() {
        return new qi.b("myrooms", false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        UserInfo i;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUserId = arguments.getString("m_User_Id");
            this.isSelf = arguments.getBoolean("is_Self", false);
            if (TextUtils.isEmpty(this.mUserId)) {
                qx.a mLoginApi = getMLoginApi();
                this.mUserId = (mLoginApi == null || (i = mLoginApi.i()) == null) ? null : i.getUserId();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        qx.a mLoginApi = getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.j(this);
        }
    }

    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        b.a.a(this, user);
        this.mUserId = user.getUserId();
        G0();
    }

    public void onLogout() {
        b.a.b(this);
    }

    public void onUpdateUserInfo(UserInfo userInfo) {
        b.a.c(this, userInfo);
    }

    public void retryLoadData() {
        F0();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        String string = getString(R$string.str_room_title);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void x0() {
        RecyclerView recyclerView;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3, 1, false));
        int a = com.blankj.utilcode.util.a0.a(8.0f);
        int i = a / 2;
        recyclerView.addItemDecoration(new gp.a(a, i, i));
        final com.transsion.room.adapter.a aVar = new com.transsion.room.adapter.a(new ArrayList());
        aVar.w1(new r6.d() { // from class: com.transsion.room.fragment.b2
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                RoomsFragment.R0(com.transsion.room.adapter.a.this, this, baseQuickAdapter, view, i2);
            }
        });
        H0(aVar);
        recyclerView.setAdapter(getMBaseAdapter());
        if (y0()) {
            BaseQuickAdapter mBaseAdapter = getMBaseAdapter();
            recyclerView.addOnScrollListener(new nj.a(mBaseAdapter != null ? mBaseAdapter.h0() : null));
        }
    }
}
