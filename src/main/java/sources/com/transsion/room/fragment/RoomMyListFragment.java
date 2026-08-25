package com.transsion.room.fragment;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$string;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u000eR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/transsion/room/fragment/RoomMyListFragment;", "Lcom/transsion/room/fragment/RoomListBaseFragment;", "<init>", "()V", BuildConfig.FLAVOR, "N0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewModel", "initListener", BuildConfig.FLAVOR, "getEmptyDescText", "()Ljava/lang/String;", "Lcom/transsion/room/adapter/RoomListFrom;", "w0", "()Lcom/transsion/room/adapter/RoomListFrom;", BuildConfig.FLAVOR, "isRefresh", "E0", "(Z)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "pageName", "n", "Ljava/lang/String;", "userId", "o", "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomMyListFragment extends RoomListBaseFragment {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: from kotlin metadata */
    private String userId;

    /* renamed from: com.transsion.room.fragment.RoomMyListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomMyListFragment a(boolean z, String str) {
            RoomMyListFragment roomMyListFragment = new RoomMyListFragment();
            roomMyListFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("is_select_room", Boolean.valueOf(z)), TuplesKt.a("user_id", str)}));
            return roomMyListFragment;
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
    public static final Unit M0(RoomMyListFragment roomMyListFragment, RoomBean roomBean) {
        roomMyListFragment.J0(roomBean);
        return Unit.a;
    }

    private final void N0() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.y1
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = RoomMyListFragment.O0(RoomMyListFragment.this, (JoinRoomEvent) obj);
                return O0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(RoomMyListFragment roomMyListFragment, JoinRoomEvent joinRoomEvent) {
        List data;
        Intrinsics.h(joinRoomEvent, "value");
        try {
            Result.Companion companion = Result.Companion;
            if (joinRoomEvent.getJoin()) {
                roomMyListFragment.t0();
            } else {
                RoomListAdapter mAdapter = roomMyListFragment.getMAdapter();
                int i = -1;
                if (mAdapter != null && (data = mAdapter.getData()) != null) {
                    Iterator it = data.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (Intrinsics.c(((RoomItem) it.next()).getGroupId(), joinRoomEvent.getGroupId())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
                if (i < 0) {
                    return Unit.a;
                }
                RoomListAdapter mAdapter2 = roomMyListFragment.getMAdapter();
                if (mAdapter2 != null) {
                    mAdapter2.G0(i);
                }
                RoomListAdapter mAdapter3 = roomMyListFragment.getMAdapter();
                List data2 = mAdapter3 != null ? mAdapter3.getData() : null;
                if (data2 == null || data2.isEmpty()) {
                    roomMyListFragment.checkToShowEmptyView();
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void E0(boolean isRefresh) {
        RoomViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.z(isRefresh, getMPage(), getMPerPage(), this.userId);
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public String getEmptyDescText() {
        String string = getString(R$string.my_room_empty_tips);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public void initListener() {
        N0();
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void initViewModel() {
        androidx.lifecycle.b0 A;
        super.initViewModel();
        RoomViewModel mViewModel = getMViewModel();
        if (mViewModel == null || (A = mViewModel.A()) == null) {
            return;
        }
        A.j(this, new b(new Function1() { // from class: com.transsion.room.fragment.z1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = RoomMyListFragment.M0(RoomMyListFragment.this, (RoomBean) obj);
                return M0;
            }
        }));
    }

    public qi.b newLogViewConfig() {
        return new qi.b("my_room_list", false, 2, null);
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("user_id")) == null) {
            str = null;
        }
        this.userId = str;
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public String pageName() {
        return "my_room_list";
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public RoomListFrom w0() {
        return RoomListFrom.MY_ROOM;
    }
}
