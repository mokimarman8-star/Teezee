package com.transsion.baseui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.StateView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nj.a;
import yg.l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010\u0013J\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\n¢\u0006\u0004\b#\u0010\u0005J\r\u0010$\u001a\u00020\u0011¢\u0006\u0004\b$\u0010\u0013J\r\u0010%\u001a\u00020\n¢\u0006\u0004\b%\u0010\u0005J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\u0005J\u0017\u0010(\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\u0011¢\u0006\u0004\b(\u0010\"J\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010\u0005J\r\u0010*\u001a\u00020\u0011¢\u0006\u0004\b*\u0010\u0013J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020/\u0018\u00010.H&¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\nH&¢\u0006\u0004\b2\u0010\u0005J\u000f\u00103\u001a\u00020\nH&¢\u0006\u0004\b3\u0010\u0005R0\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00101\"\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/transsion/baseui/fragment/BaseListFragment;", "T", "Lcom/transsion/baseui/fragment/LazyFragment;", "Ljj/b;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "t0", "(Landroid/view/LayoutInflater;)Ljj/b;", BuildConfig.FLAVOR, "initViewData", "initListener", "Landroidx/recyclerview/widget/RecyclerView$m;", "o0", "()Landroidx/recyclerview/widget/RecyclerView$m;", "x0", BuildConfig.FLAVOR, "y0", "()Z", "Landroid/view/View;", "q0", "()Landroid/view/View;", "r0", "N0", "u0", "emptyView", "J0", "(Landroid/view/View;)V", "loadingView", "L0", "A0", "isRefresh", "I0", "(Z)V", "n0", "z0", "E0", "B0", "gone", "C0", "F0", "isEmpty", BuildConfig.FLAVOR, "s0", "()Ljava/lang/String;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "G0", "loadMore", "a", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "p0", "H0", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "mBaseAdapter", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseListFragment<T> extends LazyFragment<jj.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private BaseQuickAdapter mBaseAdapter;

    public static /* synthetic */ void D0(BaseListFragment baseListFragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        baseListFragment.C0(z);
    }

    public static /* synthetic */ void K0(BaseListFragment baseListFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRvEmptyLayout");
        }
        if ((i & 1) != 0) {
            view = baseListFragment.q0();
        }
        baseListFragment.J0(view);
    }

    public static /* synthetic */ void M0(BaseListFragment baseListFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRvLoadingLayout");
        }
        if ((i & 1) != 0) {
            view = baseListFragment.r0();
        }
        baseListFragment.L0(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(BaseListFragment baseListFragment) {
        if (!baseListFragment.z0()) {
            baseListFragment.G0();
        } else {
            baseListFragment.I0(false);
            fh.b.a.e("loading, please try again later ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(BaseListFragment baseListFragment) {
        if (!baseListFragment.A0()) {
            baseListFragment.loadMore();
        } else {
            fh.b.a.e("being refreshed, please try again later ...");
            baseListFragment.E0();
        }
    }

    public final boolean A0() {
        SwipeRefreshLayout swipeRefreshLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (swipeRefreshLayout = bVar.c) == null) {
            return false;
        }
        return swipeRefreshLayout.isRefreshing();
    }

    public final void B0() {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h0.s();
    }

    public final void C0(boolean gone) {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h0.t(gone);
    }

    public final void E0() {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h0.v();
    }

    public final void F0() {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h0.w();
    }

    public abstract void G0();

    public final void H0(BaseQuickAdapter baseQuickAdapter) {
        this.mBaseAdapter = baseQuickAdapter;
    }

    public final void I0(boolean isRefresh) {
        SwipeRefreshLayout swipeRefreshLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (swipeRefreshLayout = bVar.c) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(isRefresh);
    }

    public final void J0(View emptyView) {
        Intrinsics.h(emptyView, "emptyView");
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.Y0(emptyView);
        }
    }

    public final void L0(View loadingView) {
        Intrinsics.h(loadingView, "loadingView");
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.Y0(loadingView);
        }
    }

    public void N0() {
        I0(false);
        E0();
        if (isEmpty()) {
            K0(this, null, 1, null);
        }
        if (l.a.e()) {
            return;
        }
        fh.b.a.e(getString(R.string.no_network_toast));
    }

    public void initListener() {
        SwipeRefreshLayout swipeRefreshLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar != null && (swipeRefreshLayout = bVar.c) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.baseui.fragment.b
                public final void a() {
                    BaseListFragment.v0(BaseListFragment.this);
                }
            });
        }
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.h0().D(new r6.f() { // from class: com.transsion.baseui.fragment.c
                public final void a() {
                    BaseListFragment.w0(BaseListFragment.this);
                }
            });
        }
    }

    public void initViewData() {
        TitleLayout titleLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar != null && (titleLayout = bVar.e) != null) {
            titleLayout.setTitleText(s0());
        }
        x0();
    }

    public final boolean isEmpty() {
        List data;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        return (baseQuickAdapter == null || (data = baseQuickAdapter.getData()) == null || !data.isEmpty()) ? false : true;
    }

    public abstract void loadMore();

    public abstract BaseQuickAdapter m0();

    public final void n0() {
        SwipeRefreshLayout swipeRefreshLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (swipeRefreshLayout = bVar.c) == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

    public RecyclerView.m o0() {
        return new LinearLayoutManager(requireContext());
    }

    /* renamed from: p0, reason: from getter */
    public final BaseQuickAdapter getMBaseAdapter() {
        return this.mBaseAdapter;
    }

    public View q0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(2, 1, false, BuildConfig.FLAVOR, getEmptyDescText());
        return stateView;
    }

    public View r0() {
        View inflate = LayoutInflater.from(requireContext()).inflate(com.transsion.baseui.R.layout.default_rv_loading_layout, (ViewGroup) null);
        Intrinsics.g(inflate, "inflate(...)");
        return inflate;
    }

    public abstract String s0();

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public jj.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        jj.b c = jj.b.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public final void u0() {
        TitleLayout titleLayout;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (titleLayout = bVar.e) == null) {
            return;
        }
        titleLayout.setVisibility(8);
    }

    public void x0() {
        RecyclerView recyclerView;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.setLayoutManager(o0());
        BaseQuickAdapter m0 = m0();
        this.mBaseAdapter = m0;
        recyclerView.setAdapter(m0);
        if (y0()) {
            BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
            recyclerView.addOnScrollListener(new a(baseQuickAdapter != null ? baseQuickAdapter.h0() : null));
        }
    }

    public boolean y0() {
        return true;
    }

    public final boolean z0() {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mBaseAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return false;
        }
        return h0.r();
    }
}
