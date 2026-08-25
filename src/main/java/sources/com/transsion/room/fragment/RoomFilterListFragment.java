package com.transsion.room.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.flow.bean.RoomFilter;
import com.transsion.flow.bean.RoomFilterClasses;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomFilterTabListAdapter;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.usercenter.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/transsion/room/fragment/RoomFilterListFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lfp/p;", "<init>", "()V", BuildConfig.FLAVOR, "loadData", "checkToShowEmptyView", "Lcom/transsion/moviedetailapi/bean/RoomFilter;", "filter", "s0", "(Lcom/transsion/moviedetailapi/bean/RoomFilter;)V", "t0", "u0", "p0", BuildConfig.FLAVOR, "cid", "Landroidx/fragment/app/Fragment;", "m0", "(Ljava/lang/Integer;)Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "o0", "(Landroid/view/LayoutInflater;)Lfp/p;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "getEmptyDescText", BuildConfig.FLAVOR, "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "isShowPageStateLayoutTitle", "initViewData", "initViewModel", "initListener", "lazyLoadData", "retryLoadData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lcom/transsion/room/adapter/RoomFilterTabListAdapter;", "a", "Lcom/transsion/room/adapter/RoomFilterTabListAdapter;", "mAdapter", "Lcom/transsion/room/viewmodel/RoomViewModel;", "b", "Lkotlin/Lazy;", "n0", "()Lcom/transsion/room/viewmodel/RoomViewModel;", "mViewModel", "c", "Ljava/lang/Integer;", "curSelectCid", "d", "Z", "isSelectRoom", "e", "Landroid/view/View;", "loadingView", "f", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomFilterListFragment extends LazyFragment<fp.p> {

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private RoomFilterTabListAdapter mAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.room.fragment.RoomFilterListFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m155invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomFilterListFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m156invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private Integer curSelectCid;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isSelectRoom;

    /* renamed from: e, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: com.transsion.room.fragment.RoomFilterListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomFilterListFragment a(boolean z) {
            RoomFilterListFragment roomFilterListFragment = new RoomFilterListFragment();
            roomFilterListFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("is_select_room", Boolean.valueOf(z))}));
            return roomFilterListFragment;
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

    private final void checkToShowEmptyView() {
        if (yg.l.a.e()) {
            showEmptyView(false);
        } else {
            showLocalNoNetworkView(false);
        }
    }

    private final void loadData() {
        n0().E();
    }

    private final Fragment m0(Integer cid) {
        return RoomListFragment.INSTANCE.a(cid, this.isSelectRoom);
    }

    private final RoomViewModel n0() {
        return (RoomViewModel) this.mViewModel.getValue();
    }

    private final void p0() {
        List y0 = getChildFragmentManager().y0();
        Intrinsics.g(y0, "getFragments(...)");
        Iterator it = y0.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().p().p((Fragment) it.next()).l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(RoomFilterListFragment roomFilterListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.RoomFilter");
        roomFilterListFragment.s0((RoomFilter) item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(RoomFilterListFragment roomFilterListFragment, RoomFilterClasses roomFilterClasses) {
        List<RoomFilter> classes;
        RecyclerView recyclerView;
        Integer cid;
        if (roomFilterClasses == null || (classes = roomFilterClasses.getClasses()) == null || classes.isEmpty()) {
            roomFilterListFragment.checkToShowEmptyView();
        } else {
            List<RoomFilter> classes2 = roomFilterClasses.getClasses();
            Intrinsics.e(classes2);
            for (RoomFilter roomFilter : classes2) {
                Integer num = roomFilterListFragment.curSelectCid;
                if ((num != null && Intrinsics.c(num, roomFilter.getCid())) || ((roomFilterClasses.getDefCid() != null && Intrinsics.c(roomFilter.getCid(), roomFilterClasses.getDefCid())) || ((cid = roomFilter.getCid()) != null && cid.intValue() == -1))) {
                    roomFilter.setSelected(true);
                    roomFilterListFragment.curSelectCid = roomFilter.getCid();
                    roomFilterListFragment.u0(roomFilter);
                    break;
                }
            }
            roomFilterListFragment.showContentView();
            fp.p pVar = (fp.p) roomFilterListFragment.getMViewBinding();
            if (pVar != null && (recyclerView = pVar.c) != null) {
                uf.c.k(recyclerView);
            }
            RoomFilterTabListAdapter roomFilterTabListAdapter = roomFilterListFragment.mAdapter;
            if (roomFilterTabListAdapter != null) {
                roomFilterTabListAdapter.n1(roomFilterClasses.getClasses());
            }
        }
        return Unit.a;
    }

    private final void s0(RoomFilter filter) {
        if (Intrinsics.c(this.curSelectCid, filter.getCid())) {
            return;
        }
        t0(filter);
        this.curSelectCid = filter.getCid();
        u0(filter);
    }

    private final void t0(RoomFilter filter) {
        int i;
        List data;
        List data2;
        Object obj;
        List data3;
        List data4;
        RoomFilterTabListAdapter roomFilterTabListAdapter = this.mAdapter;
        int i2 = -1;
        if (roomFilterTabListAdapter != null && (data4 = roomFilterTabListAdapter.getData()) != null) {
            Iterator it = data4.iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.c(this.curSelectCid, ((RoomFilter) it.next()).getCid())) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        RoomFilterTabListAdapter roomFilterTabListAdapter2 = this.mAdapter;
        if (roomFilterTabListAdapter2 != null && (data3 = roomFilterTabListAdapter2.getData()) != null) {
            Iterator it2 = data3.iterator();
            int i3 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (Intrinsics.c(filter.getCid(), ((RoomFilter) it2.next()).getCid())) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
        }
        Object obj2 = null;
        if (i >= 0) {
            RoomFilterTabListAdapter roomFilterTabListAdapter3 = this.mAdapter;
            if (roomFilterTabListAdapter3 != null && (data2 = roomFilterTabListAdapter3.getData()) != null) {
                Iterator it3 = data2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it3.next();
                        if (Intrinsics.c(this.curSelectCid, ((RoomFilter) obj).getCid())) {
                            break;
                        }
                    }
                }
                RoomFilter roomFilter = (RoomFilter) obj;
                if (roomFilter != null) {
                    roomFilter.setSelected(false);
                }
            }
            RoomFilterTabListAdapter roomFilterTabListAdapter4 = this.mAdapter;
            if (roomFilterTabListAdapter4 != null) {
                roomFilterTabListAdapter4.notifyItemChanged(i, Boolean.FALSE);
            }
        }
        if (i2 >= 0) {
            RoomFilterTabListAdapter roomFilterTabListAdapter5 = this.mAdapter;
            if (roomFilterTabListAdapter5 != null && (data = roomFilterTabListAdapter5.getData()) != null) {
                Iterator it4 = data.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.c(filter.getCid(), ((RoomFilter) next).getCid())) {
                        obj2 = next;
                        break;
                    }
                }
                RoomFilter roomFilter2 = (RoomFilter) obj2;
                if (roomFilter2 != null) {
                    roomFilter2.setSelected(true);
                }
            }
            RoomFilterTabListAdapter roomFilterTabListAdapter6 = this.mAdapter;
            if (roomFilterTabListAdapter6 != null) {
                roomFilterTabListAdapter6.notifyItemChanged(i2, Boolean.TRUE);
            }
        }
    }

    private final void u0(RoomFilter filter) {
        String str = filter.getTitle() + filter.getCid();
        a.a.f(wf.a.a, "RoomFilter", "showFragment tag = " + str, false, 4, (Object) null);
        p0();
        Fragment k0 = getChildFragmentManager().k0(str);
        if (k0 == null) {
            k0 = m0(filter.getCid());
        }
        if (k0.isAdded()) {
            getChildFragmentManager().p().y(k0).l();
        } else {
            getChildFragmentManager().p().c(R$id.fl_container, k0, str).l();
        }
    }

    public String getEmptyDescText() {
        String string = getString(R.string.profile_not_content);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public View getLoadingView() {
        if (this.loadingView == null) {
            this.loadingView = LayoutInflater.from(requireContext()).inflate(R$layout.layout_room_list_filter_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.loadingView;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
    }

    public void initViewData() {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        this.isSelectRoom = arguments != null ? arguments.getBoolean("is_select_room") : false;
        RoomFilterTabListAdapter roomFilterTabListAdapter = new RoomFilterTabListAdapter();
        roomFilterTabListAdapter.w1(new r6.d() { // from class: com.transsion.room.fragment.h0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomFilterListFragment.q0(RoomFilterListFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = roomFilterTabListAdapter;
        fp.p pVar = (fp.p) getMViewBinding();
        if (pVar == null || (recyclerView = pVar.c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    public void initViewModel() {
        n0().I().j(this, new b(new Function1() { // from class: com.transsion.room.fragment.i0
            public final Object invoke(Object obj) {
                Unit r0;
                r0 = RoomFilterListFragment.r0(RoomFilterListFragment.this, (RoomFilterClasses) obj);
                return r0;
            }
        }));
        if (yg.l.a.e()) {
            return;
        }
        showNoNetworkView(false);
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return false;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        showLoadingView();
        loadData();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("room_list", false, 2, null);
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public fp.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fp.p c = fp.p.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void retryLoadData() {
        loadData();
    }
}
