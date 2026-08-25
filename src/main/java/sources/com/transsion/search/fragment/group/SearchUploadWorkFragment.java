package com.transsion.search.fragment.group;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.widget.R;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.PagerEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.viewmodel.SearchWorkViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import kotlin.text.StringsKt;
import yg.m;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J5\u0010\u001d\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010DR\u0016\u0010L\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/transsion/search/fragment/group/SearchUploadWorkFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lvp/e;", "<init>", "()V", BuildConfig.FLAVOR, "initHistory", "t0", BuildConfig.FLAVOR, "clear", "resetContent", "(Z)V", "I0", "searchJob", "initViewModel", "Landroid/view/View;", "emptyView", "()Landroid/view/View;", "showHistory", "L0", PushConstants.PUSH_SERVICE_TYPE_SHOW, "J0", "K0", BuildConfig.FLAVOR, "group_id", "subject_id", "opt", BuildConfig.FLAVOR, "position", "reportClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/view/LayoutInflater;", "inflater", "w0", "(Landroid/view/LayoutInflater;)Lvp/e;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "lazyLoadData", "onDestroyView", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "a", "Z", "isRefreshing", "Lcom/transsion/search/fragment/group/g0;", "b", "Lcom/transsion/search/fragment/group/g0;", "mSearchWorkAdapter", "Lcom/transsion/search/fragment/group/adapter/c;", "c", "Lcom/transsion/search/fragment/group/adapter/c;", "mHistoryAdapter", "Lcom/transsion/search/viewmodel/SearchWorkViewModel;", "d", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/search/viewmodel/SearchWorkViewModel;", "mViewModel", "Lcom/transsion/search/viewmodel/SearchViewModel;", "e", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mSearchViewModel", "f", "I", "mType", "g", "page", "h", "perPage", "i", "Ljava/lang/String;", "mKeyword", "j", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchUploadWorkFragment extends BaseFragment<vp.e> {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private boolean isRefreshing;

    /* renamed from: b, reason: from kotlin metadata */
    private g0 mSearchWorkAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.search.fragment.group.adapter.c mHistoryAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private SearchViewModel mSearchViewModel;

    /* renamed from: f, reason: from kotlin metadata */
    private int mType;

    /* renamed from: g, reason: from kotlin metadata */
    private int page;

    /* renamed from: h, reason: from kotlin metadata */
    private int perPage;

    /* renamed from: i, reason: from kotlin metadata */
    private String mKeyword;

    /* renamed from: com.transsion.search.fragment.group.SearchUploadWorkFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchUploadWorkFragment a(int i) {
            SearchUploadWorkFragment searchUploadWorkFragment = new SearchUploadWorkFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            searchUploadWorkFragment.setArguments(bundle);
            return searchUploadWorkFragment;
        }
    }

    public static final class b implements yg.m {
        b() {
        }

        public void onConnected() {
            m.a.a(this);
        }

        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            t6.f h0;
            List data;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            g0 g0Var = SearchUploadWorkFragment.this.mSearchWorkAdapter;
            if (g0Var != null && (data = g0Var.getData()) != null && data.isEmpty()) {
                SearchUploadWorkFragment.this.searchJob();
                return;
            }
            g0 g0Var2 = SearchUploadWorkFragment.this.mSearchWorkAdapter;
            if (g0Var2 == null || (h0 = g0Var2.h0()) == null) {
                return;
            }
            h0.w();
        }

        public void onDisconnected() {
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if ((editable != null ? editable.length() : 0) == 0) {
                SearchUploadWorkFragment.this.resetContent(true);
            }
            SearchUploadWorkFragment.this.mKeyword = StringsKt.n1(String.valueOf(editable)).toString();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchUploadWorkFragment.this.J0(true);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 0 && i != 3) {
                return false;
            }
            SearchUploadWorkFragment.this.mKeyword = StringsKt.n1(String.valueOf(textView != null ? textView.getText() : null)).toString();
            SearchUploadWorkFragment.this.searchJob();
            return true;
        }
    }

    public static final class e extends RecyclerView.r {
        final /* synthetic */ vp.e b;

        e(vp.e eVar) {
            this.b = eVar;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            FragmentActivity activity;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i != 1 || (activity = SearchUploadWorkFragment.this.getActivity()) == null) {
                return;
            }
            vp.e eVar = this.b;
            if (KeyboardUtils.g(activity)) {
                KeyboardUtils.e(eVar.c);
            }
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

    public SearchUploadWorkFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m166invoke() {
                return this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(SearchWorkViewModel.class), new Function0<x0>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m167invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m168invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.page = 1;
        this.perPage = 10;
        this.mKeyword = BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SearchUploadWorkFragment searchUploadWorkFragment, SearchWorkEntity searchWorkEntity) {
        ArrayList arrayList;
        Pager pager;
        HashMap g;
        List data;
        ProgressBar progressBar;
        Pager pager2;
        Pager pager3;
        Pager pager4;
        List<SearchSubject> items;
        Boolean bool = null;
        if (searchWorkEntity == null || (items = searchWorkEntity.getItems()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : items) {
                if (!((SearchSubject) obj).isJumpBrowser()) {
                    arrayList.add(obj);
                }
            }
        }
        boolean hasMore = (searchWorkEntity == null || (pager4 = searchWorkEntity.getPager()) == null) ? false : pager4.getHasMore();
        searchUploadWorkFragment.page = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
        searchUploadWorkFragment.perPage = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
        vp.e eVar = (vp.e) searchUploadWorkFragment.getMViewBinding();
        if (eVar != null && (progressBar = eVar.f) != null) {
            uf.c.g(progressBar);
        }
        g0 g0Var = searchUploadWorkFragment.mSearchWorkAdapter;
        if (g0Var != null) {
            g0Var.h0().s();
            g0 g0Var2 = searchUploadWorkFragment.mSearchWorkAdapter;
            if (g0Var2 != null && (data = g0Var2.getData()) != null) {
                bool = Boolean.valueOf(data.isEmpty());
            }
            if ((arrayList == null || arrayList.isEmpty()) && Intrinsics.c(bool, Boolean.TRUE) && (searchUploadWorkFragment.page == 1 || (searchWorkEntity != null && (pager = searchWorkEntity.getPager()) != null && pager.getPage() == 1))) {
                g0Var.q1(new ArrayList());
                g0Var.Y0(searchUploadWorkFragment.emptyView());
                searchUploadWorkFragment.L0(false);
                g0Var.z1(true);
            }
            if (arrayList == null || arrayList.isEmpty()) {
                g0Var.h0().t(false);
            } else {
                if (searchUploadWorkFragment.isRefreshing) {
                    searchUploadWorkFragment.isRefreshing = false;
                    g0 g0Var3 = searchUploadWorkFragment.mSearchWorkAdapter;
                    if (g0Var3 != null) {
                        g0Var3.n1(arrayList);
                    }
                } else {
                    g0 g0Var4 = searchUploadWorkFragment.mSearchWorkAdapter;
                    if (g0Var4 != null) {
                        g0Var4.q(arrayList);
                    }
                }
                qi.b logViewConfig = searchUploadWorkFragment.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
                qi.b logViewConfig2 = searchUploadWorkFragment.getLogViewConfig();
                if (logViewConfig2 != null && (g = logViewConfig2.g()) != null) {
                    g.put("type", String.valueOf(searchUploadWorkFragment.mType));
                }
                searchUploadWorkFragment.L0(false);
            }
            if (!hasMore) {
                g0Var.h0().t(false);
            }
            if (searchWorkEntity == null) {
                g0Var.h0().v();
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(View view, boolean z) {
        view.dispatchWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(SearchUploadWorkFragment searchUploadWorkFragment, View view) {
        searchUploadWorkFragment.searchJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SearchUploadWorkFragment searchUploadWorkFragment, View view) {
        searchUploadWorkFragment.resetContent(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(SearchUploadWorkFragment searchUploadWorkFragment, View view) {
        searchUploadWorkFragment.I0();
        FragmentActivity activity = searchUploadWorkFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(final SearchUploadWorkFragment searchUploadWorkFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            SearchViewModel searchViewModel = searchUploadWorkFragment.mSearchViewModel;
            if (searchViewModel != null) {
                searchViewModel.w(searchUploadWorkFragment.page, searchUploadWorkFragment.perPage, searchUploadWorkFragment.mKeyword);
                return;
            }
            return;
        }
        fh.b.a.d(R.string.no_network_toast);
        vp.e eVar = (vp.e) searchUploadWorkFragment.getMViewBinding();
        if (eVar == null || (recyclerView = eVar.h) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.u
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadWorkFragment.G0(SearchUploadWorkFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(SearchUploadWorkFragment searchUploadWorkFragment) {
        t6.f h0;
        g0 g0Var = searchUploadWorkFragment.mSearchWorkAdapter;
        if (g0Var == null || (h0 = g0Var.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SearchUploadWorkFragment searchUploadWorkFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        SearchSubject searchSubject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        g0 g0Var = searchUploadWorkFragment.mSearchWorkAdapter;
        if (g0Var == null || (data = g0Var.getData()) == null || (searchSubject = (SearchSubject) data.get(i)) == null) {
            return;
        }
        searchUploadWorkFragment.reportClick(BuildConfig.FLAVOR, searchSubject.getSubjectId(), searchSubject.getOps(), i);
        jo.b bVar = new jo.b();
        bVar.o(3);
        bVar.n(1);
        bVar.s(searchSubject);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        FragmentActivity activity = searchUploadWorkFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void I0() {
        tp.a aVar = new tp.a();
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = tp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, aVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(boolean show) {
        vp.e eVar = (vp.e) getMViewBinding();
        if (eVar != null) {
            if (show) {
                TextView textView = eVar.i;
                Intrinsics.g(textView, "searchTV");
                uf.c.k(textView);
                AppCompatImageView appCompatImageView = eVar.b;
                Intrinsics.g(appCompatImageView, "clearIV");
                uf.c.g(appCompatImageView);
                return;
            }
            TextView textView2 = eVar.i;
            Intrinsics.g(textView2, "searchTV");
            uf.c.g(textView2);
            AppCompatImageView appCompatImageView2 = eVar.b;
            Intrinsics.g(appCompatImageView2, "clearIV");
            uf.c.k(appCompatImageView2);
        }
    }

    private final void K0() {
        fh.b.a.d(R.string.no_network_toast);
        L0(false);
        g0 g0Var = this.mSearchWorkAdapter;
        if (g0Var != null) {
            g0Var.Y0(emptyView());
        }
        g0 g0Var2 = this.mSearchWorkAdapter;
        if (g0Var2 != null) {
            g0Var2.q1(new ArrayList());
        }
    }

    private final void L0(boolean showHistory) {
        vp.e eVar = (vp.e) getMViewBinding();
        if (eVar != null) {
            TextView textView = eVar.g;
            Intrinsics.g(textView, "recentTV");
            textView.setVisibility(showHistory ? 0 : 8);
            if (!showHistory) {
                eVar.h.setAdapter(this.mSearchWorkAdapter);
                return;
            }
            eVar.h.setAdapter(this.mHistoryAdapter);
            com.transsion.search.fragment.group.adapter.c cVar = this.mHistoryAdapter;
            if (cVar != null) {
                cVar.n1((Collection) v0().h().f());
            }
        }
    }

    private final View emptyView() {
        EditText editText;
        Editable editable = null;
        View inflate = getLayoutInflater().inflate(R$layout.view_search_manager_empty, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
        AppCompatTextView findViewById = inflate.findViewById(R$id.tv_retry);
        if (yg.l.a.e()) {
            vp.e eVar = (vp.e) getMViewBinding();
            if (eVar != null && (editText = eVar.c) != null) {
                editable = editText.getText();
            }
            String valueOf = String.valueOf(editable);
            textView.setText(getString(R$string.user_works_empty) + " \"" + valueOf + "\"");
            findViewById.setVisibility(8);
            imageView.setImageResource(R.mipmap.ic_no_content);
        } else {
            textView.setText(com.transsion.baseui.R.string.base_network_fail);
            imageView.setImageResource(R.mipmap.ic_no_network);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchUploadWorkFragment.s0(SearchUploadWorkFragment.this, view);
                }
            });
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    private final void initHistory() {
        final com.transsion.search.fragment.group.adapter.c cVar = new com.transsion.search.fragment.group.adapter.c(new ArrayList());
        cVar.h0().D(new r6.f() { // from class: com.transsion.search.fragment.group.v
            public final void a() {
                SearchUploadWorkFragment.x0(SearchUploadWorkFragment.this, cVar);
            }
        });
        cVar.w1(new r6.d() { // from class: com.transsion.search.fragment.group.w
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchUploadWorkFragment.y0(SearchUploadWorkFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mHistoryAdapter = cVar;
    }

    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        SearchViewModel a = new v0(requireActivity).a(SearchViewModel.class);
        a.m().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.group.e0
            public final Object invoke(Object obj) {
                Unit z0;
                z0 = SearchUploadWorkFragment.z0(SearchUploadWorkFragment.this, (SearchGroupEntity) obj);
                return z0;
            }
        }));
        a.o().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.group.f0
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = SearchUploadWorkFragment.A0(SearchUploadWorkFragment.this, (SearchWorkEntity) obj);
                return A0;
            }
        }));
        this.mSearchViewModel = a;
    }

    private final void reportClick(String group_id, String subject_id, String opt, int position) {
        HashMap hashMap = new HashMap();
        if (group_id == null) {
            group_id = BuildConfig.FLAVOR;
        }
        hashMap.put("group_id", group_id);
        if (subject_id == null) {
            subject_id = BuildConfig.FLAVOR;
        }
        hashMap.put("subject_id", subject_id);
        hashMap.put("sequence", String.valueOf(position));
        if (opt == null) {
            opt = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", opt);
        com.transsion.baselib.helper.a.a.f("searchresult", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetContent(boolean clear) {
        EditText editText;
        if (!clear) {
            vp.e eVar = (vp.e) getMViewBinding();
            if (eVar != null && (editText = eVar.c) != null) {
                editText.setText(BuildConfig.FLAVOR);
            }
            this.mKeyword = BuildConfig.FLAVOR;
        }
        g0 g0Var = this.mSearchWorkAdapter;
        if (g0Var != null) {
            g0Var.q1(new ArrayList());
        }
        g0 g0Var2 = this.mSearchWorkAdapter;
        if (g0Var2 != null) {
            g0Var2.H0();
        }
        vp.e eVar2 = (vp.e) getMViewBinding();
        if (eVar2 != null) {
            boolean z = true;
            L0(true);
            TextView textView = eVar2.g;
            Intrinsics.g(textView, "recentTV");
            com.transsion.search.fragment.group.adapter.c cVar = this.mHistoryAdapter;
            List data = cVar != null ? cVar.getData() : null;
            if (data != null && !data.isEmpty()) {
                z = false;
            }
            textView.setVisibility(z ? 8 : 0);
            KeyboardUtils.i(eVar2.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SearchUploadWorkFragment searchUploadWorkFragment, View view) {
        searchUploadWorkFragment.searchJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void searchJob() {
        ProgressBar progressBar;
        if (TextUtils.isEmpty(this.mKeyword)) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
            hVar.e(16);
            hVar.l(getString(R$string.tips_movie));
            return;
        }
        this.isRefreshing = true;
        SearchManager.f.a().g(this.mKeyword);
        vp.e eVar = (vp.e) getMViewBinding();
        EditText editText = eVar != null ? eVar.c : null;
        Intrinsics.e(editText);
        KeyboardUtils.e(editText);
        if (!yg.l.a.e()) {
            K0();
            return;
        }
        vp.e eVar2 = (vp.e) getMViewBinding();
        if (eVar2 != null && (progressBar = eVar2.f) != null) {
            uf.c.k(progressBar);
        }
        J0(false);
        this.page = 1;
        SearchViewModel searchViewModel = this.mSearchViewModel;
        if (searchViewModel != null) {
            searchViewModel.w(1, this.perPage, this.mKeyword);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "search");
        hashMap.put("key_word", this.mKeyword);
        hashMap.put("type", String.valueOf(this.mType));
        com.transsion.baselib.helper.a.a.f("searchpage", hashMap);
    }

    private final void t0() {
        v0().k(true);
        v0().h().j(this, new f(new Function1() { // from class: com.transsion.search.fragment.group.t
            public final Object invoke(Object obj) {
                Unit u0;
                u0 = SearchUploadWorkFragment.u0(SearchUploadWorkFragment.this, (List) obj);
                return u0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(SearchUploadWorkFragment searchUploadWorkFragment, List list) {
        vp.e eVar;
        TextView textView;
        List list2 = list;
        if ((list2 == null || list2.isEmpty()) && (eVar = (vp.e) searchUploadWorkFragment.getMViewBinding()) != null && (textView = eVar.g) != null) {
            uf.c.g(textView);
        }
        com.transsion.search.fragment.group.adapter.c cVar = searchUploadWorkFragment.mHistoryAdapter;
        if (cVar != null) {
            cVar.n1(list2);
        }
        return Unit.a;
    }

    private final SearchWorkViewModel v0() {
        return (SearchWorkViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(SearchUploadWorkFragment searchUploadWorkFragment, com.transsion.search.fragment.group.adapter.c cVar) {
        if (searchUploadWorkFragment.v0().g()) {
            SearchWorkViewModel.l(searchUploadWorkFragment.v0(), false, 1, null);
        } else {
            cVar.h0().t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(SearchUploadWorkFragment searchUploadWorkFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        VideoDetailPlayBean videoDetailPlayBean;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "view");
        com.transsion.search.fragment.group.adapter.c cVar = searchUploadWorkFragment.mHistoryAdapter;
        if (cVar == null || (data = cVar.getData()) == null || (videoDetailPlayBean = (VideoDetailPlayBean) data.get(i)) == null) {
            return;
        }
        searchUploadWorkFragment.reportClick(BuildConfig.FLAVOR, videoDetailPlayBean.getSubjectId(), BuildConfig.FLAVOR, i);
        jo.b bVar = new jo.b();
        bVar.o(3);
        bVar.n(1);
        jo.b t = bVar.t(videoDetailPlayBean.getSubjectId(), videoDetailPlayBean.getSubjectType(), videoDetailPlayBean.getTitle(), videoDetailPlayBean.getCoverUrl(), videoDetailPlayBean.getThumbnail());
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        Intrinsics.e(t);
        applicationScopeViewModel.postEvent(name, t, 0L);
        FragmentActivity activity = searchUploadWorkFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(SearchUploadWorkFragment searchUploadWorkFragment, SearchGroupEntity searchGroupEntity) {
        ProgressBar progressBar;
        PagerEntity pager;
        PagerEntity pager2;
        String nextPage;
        Integer v;
        searchUploadWorkFragment.page = (searchGroupEntity == null || (pager2 = searchGroupEntity.getPager()) == null || (nextPage = pager2.getNextPage()) == null || (v = StringsKt.v(nextPage)) == null) ? 1 : v.intValue();
        searchUploadWorkFragment.perPage = (searchGroupEntity == null || (pager = searchGroupEntity.getPager()) == null) ? 10 : pager.getPerPage();
        vp.e eVar = (vp.e) searchUploadWorkFragment.getMViewBinding();
        if (eVar != null && (progressBar = eVar.f) != null) {
            uf.c.g(progressBar);
        }
        return Unit.a;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        setNetListener(new b());
    }

    public void lazyLoadData() {
        t0();
    }

    public qi.b newLogViewConfig() {
        return new qi.b("searchpage", false, 2, null);
    }

    public void onDestroyView() {
        ProgressBar progressBar;
        vp.e eVar = (vp.e) getMViewBinding();
        if (eVar != null && (progressBar = eVar.f) != null) {
            uf.c.g(progressBar);
        }
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.mType = arguments != null ? arguments.getInt("type") : 1;
        g0 g0Var = new g0(new ArrayList());
        g0Var.h0().D(new r6.f() { // from class: com.transsion.search.fragment.group.x
            public final void a() {
                SearchUploadWorkFragment.F0(SearchUploadWorkFragment.this);
            }
        });
        g0Var.w1(new r6.d() { // from class: com.transsion.search.fragment.group.y
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SearchUploadWorkFragment.H0(SearchUploadWorkFragment.this, baseQuickAdapter, view2, i);
            }
        });
        this.mSearchWorkAdapter = g0Var;
        initHistory();
        vp.e eVar = (vp.e) getMViewBinding();
        if (eVar != null) {
            eVar.h.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            eVar.h.setAdapter(this.mHistoryAdapter);
            RecyclerView recyclerView = eVar.h;
            g0 g0Var2 = this.mSearchWorkAdapter;
            recyclerView.addOnScrollListener(new nj.a(g0Var2 != null ? g0Var2.h0() : null));
            RecyclerView recyclerView2 = eVar.h;
            com.transsion.search.fragment.group.adapter.c cVar = this.mHistoryAdapter;
            recyclerView2.addOnScrollListener(new nj.a(cVar != null ? cVar.h0() : null));
            initViewModel();
            eVar.c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.group.z
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    SearchUploadWorkFragment.B0(view2, z);
                }
            });
            eVar.i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.C0(SearchUploadWorkFragment.this, view2);
                }
            });
            eVar.c.addTextChangedListener(new c());
            eVar.c.setOnEditorActionListener(new d());
            eVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.D0(SearchUploadWorkFragment.this, view2);
                }
            });
            ProgressBar progressBar = eVar.f;
            Intrinsics.g(progressBar, "loadView");
            uf.c.g(progressBar);
            eVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.E0(SearchUploadWorkFragment.this, view2);
                }
            });
            eVar.c.requestFocus();
            KeyboardUtils.i(eVar.c);
            qi.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            eVar.h.addOnScrollListener(new e(eVar));
        }
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public vp.e getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.e c2 = vp.e.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
