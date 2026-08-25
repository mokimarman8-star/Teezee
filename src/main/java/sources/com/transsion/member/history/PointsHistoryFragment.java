package com.transsion.member.history;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$string;
import com.transsion.member.bean.Pager;
import com.transsion.member.bean.PointsHistoryData;
import com.transsion.member.bean.PointsHistoryItem;
import com.transsion.member.view.HistoryStateView;
import com.transsion.push.bean.MsgStyle;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/transsion/member/history/PointsHistoryFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/member/bean/PointsHistoryItem;", "<init>", "()V", BuildConfig.FLAVOR, "s0", "()Ljava/lang/String;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", BuildConfig.FLAVOR, "initViewData", "G0", "loadMore", "lazyLoadData", "getPageStateLayoutTitle", "initViewModel", "retryLoadData", "Landroid/view/View;", "q0", "()Landroid/view/View;", "Lcom/transsion/member/history/PointsHistoryViewModel;", "b", "Lkotlin/Lazy;", "Q0", "()Lcom/transsion/member/history/PointsHistoryViewModel;", "mViewModel", "c", "Ljava/lang/String;", "mPageNum", BuildConfig.FLAVOR, "d", "Z", "hasMoreData", "e", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PointsHistoryFragment extends BaseListFragment<PointsHistoryItem> {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f = 8;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PointsHistoryViewModel.class), new Function0<x0>() { // from class: com.transsion.member.history.PointsHistoryFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final x0 m35invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.member.history.PointsHistoryFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m36invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private String mPageNum = MsgStyle.CUSTOM_LEFT_PIC;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean hasMoreData = true;

    /* renamed from: com.transsion.member.history.PointsHistoryFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PointsHistoryFragment a() {
            return new PointsHistoryFragment();
        }
    }

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

    private final PointsHistoryViewModel Q0() {
        return (PointsHistoryViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(PointsHistoryFragment pointsHistoryFragment) {
        Navigator.x(TheRouter.c("/rewards/center"), pointsHistoryFragment.requireContext(), (mf.c) null, 2, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(PointsHistoryFragment pointsHistoryFragment, PointsHistoryData pointsHistoryData) {
        Pager page;
        List<PointsHistoryItem> list;
        if (pointsHistoryData == null || (list = pointsHistoryData.getList()) == null) {
            pointsHistoryFragment.N0();
        } else if (pointsHistoryFragment.A0() || Intrinsics.c(pointsHistoryFragment.mPageNum, MsgStyle.CUSTOM_LEFT_PIC)) {
            pointsHistoryFragment.I0(false);
            if (list.isEmpty()) {
                BaseListFragment.K0(pointsHistoryFragment, null, 1, null);
            } else {
                BaseQuickAdapter mBaseAdapter = pointsHistoryFragment.getMBaseAdapter();
                if (mBaseAdapter != null) {
                    mBaseAdapter.n1(list);
                }
            }
        } else {
            BaseQuickAdapter mBaseAdapter2 = pointsHistoryFragment.getMBaseAdapter();
            if (mBaseAdapter2 != null) {
                mBaseAdapter2.q(list);
            }
        }
        if (pointsHistoryData != null && (page = pointsHistoryData.getPage()) != null) {
            if (!page.getHasMore() || Intrinsics.c(pointsHistoryFragment.mPageNum, page.getNextPage())) {
                pointsHistoryFragment.hasMoreData = false;
                BaseListFragment.D0(pointsHistoryFragment, false, 1, null);
            } else {
                pointsHistoryFragment.hasMoreData = true;
                pointsHistoryFragment.mPageNum = page.getNextPage();
                pointsHistoryFragment.B0();
            }
        }
        return Unit.a;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
        I0(true);
        this.mPageNum = MsgStyle.CUSTOM_LEFT_PIC;
        this.hasMoreData = true;
        lazyLoadData();
    }

    public String getPageStateLayoutTitle() {
        String string = getString(R$string.points_history_title);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        I0(true);
    }

    public void initViewModel() {
        u0();
        Q0().e().j(this, new b(new Function1() { // from class: com.transsion.member.history.d
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = PointsHistoryFragment.S0(PointsHistoryFragment.this, (PointsHistoryData) obj);
                return S0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (this.hasMoreData) {
            PointsHistoryViewModel Q0 = Q0();
            String str = this.mPageNum;
            if (str == null) {
                str = MsgStyle.CUSTOM_LEFT_PIC;
            }
            Q0.d(str);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        String str = this.mPageNum;
        if (str == null || str.length() == 0 || Intrinsics.c(this.mPageNum, "0")) {
            BaseListFragment.D0(this, false, 1, null);
        } else {
            lazyLoadData();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        return new com.transsion.member.adapter.b(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public View q0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView historyStateView = new HistoryStateView(requireContext);
        String string = getString(R$string.points_history_empty);
        Intrinsics.g(string, "getString(...)");
        historyStateView.showData(4, 1, false, BuildConfig.FLAVOR, string);
        String string2 = getString(R$string.points_history_earn);
        Intrinsics.g(string2, "getString(...)");
        historyStateView.setReTryTxt(string2);
        historyStateView.retry(new Function0() { // from class: com.transsion.member.history.c
            public final Object invoke() {
                Unit R0;
                R0 = PointsHistoryFragment.R0(PointsHistoryFragment.this);
                return R0;
            }
        });
        return historyStateView;
    }

    public void retryLoadData() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        String string = getString(R$string.points_history_title);
        Intrinsics.g(string, "getString(...)");
        return string;
    }
}
