package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.shorttv.adapter.ShortTVTrendingAdapter;
import com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel;
import com.transsion.postdetail.shorttv.widget.ShortTVDiscoverHeaderView;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0011¢\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010$\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/transsion/postdetail/shorttv/ShortTVFavoriteFragment;", "Lcom/transsion/baseui/fragment/BaseListFragment;", "Lcom/transsion/moviedetailapi/bean/Subject;", "<init>", "()V", BuildConfig.FLAVOR, "V0", "subject", BuildConfig.FLAVOR, "isDownloadView", "g1", "(Lcom/transsion/moviedetailapi/bean/Subject;Z)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "W0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "e1", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "onResume", "initViewData", "s0", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "m0", "()Lcom/chad/library/adapter/base/BaseQuickAdapter;", "G0", "loadMore", "lazyLoadData", "getPageStateLayoutTitle", "initViewModel", "a1", "retryLoadData", "Lcom/transsion/postdetail/shorttv/viewmodel/ShortTVContentViewModel;", "b", "Lkotlin/Lazy;", "c1", "()Lcom/transsion/postdetail/shorttv/viewmodel/ShortTVContentViewModel;", "mViewModel", "c", "Ljava/lang/String;", "mPageNum", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVTrendingAdapter;", "d", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVTrendingAdapter;", "b1", "()Lcom/transsion/postdetail/shorttv/adapter/ShortTVTrendingAdapter;", "setListAdapter", "(Lcom/transsion/postdetail/shorttv/adapter/ShortTVTrendingAdapter;)V", "listAdapter", "Lcom/transsion/postdetail/shorttv/j;", "e", "d1", "()Lcom/transsion/postdetail/shorttv/j;", "recReport", "Lbj/b;", "f", "Lbj/b;", "exposureHelper", "g", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVFavoriteFragment extends BaseListFragment<Subject> {

    /* renamed from: c, reason: from kotlin metadata */
    private String mPageNum;

    /* renamed from: d, reason: from kotlin metadata */
    private ShortTVTrendingAdapter listAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTVContentViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final x0 m83invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m84invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy recReport = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.d
        public final Object invoke() {
            j h1;
            h1 = ShortTVFavoriteFragment.h1();
            return h1;
        }
    });

    /* renamed from: f, reason: from kotlin metadata */
    private final bj.b exposureHelper = new bj.b(0.6f, new d(), false, 4, null);

    public static final class b extends RecyclerView.r {
        b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (i2 > 0) {
                ShortTVFavoriteFragment.this.W0(recyclerView);
            }
        }
    }

    public static final class c extends DiffUtil.e {
        c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Subject subject, Subject subject2) {
            Intrinsics.h(subject, "oldItem");
            Intrinsics.h(subject2, "newItem");
            return Intrinsics.c(subject.getSubjectId(), subject2.getSubjectId());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Subject subject, Subject subject2) {
            Intrinsics.h(subject, "oldItem");
            Intrinsics.h(subject2, "newItem");
            return subject.hashCode() == subject2.hashCode();
        }
    }

    public static final class d implements bj.a {
        d() {
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            List data;
            List data2;
            ShortTVTrendingAdapter listAdapter = ShortTVFavoriteFragment.this.getListAdapter();
            if (((listAdapter == null || (data2 = listAdapter.getData()) == null) ? 0 : data2.size()) <= i) {
                return;
            }
            ShortTVTrendingAdapter listAdapter2 = ShortTVFavoriteFragment.this.getListAdapter();
            Subject subject = (listAdapter2 == null || (data = listAdapter2.getData()) == null) ? null : (Subject) data.get(i);
            if (subject != null) {
                ShortTVFavoriteFragment.this.d1().a(ShortTVFavoriteFragment.this.getPageName(), subject, i, j, ShortTVFavoriteFragment.this.a1());
            }
        }
    }

    public static final class e extends RecyclerView.l {
        e() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            Intrinsics.h(rect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(recyclerView, "parent");
            Intrinsics.h(xVar, "state");
            super.getItemOffsets(rect, view, recyclerView, xVar);
            if (recyclerView.getAdapter() != null) {
                rect.top = a0.a(16.0f);
            }
        }
    }

    static final class f implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        f(Function1 function1) {
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

    private final void V0() {
        RecyclerView recyclerView;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(RecyclerView recyclerView) {
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        LinearLayout Z;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0 || (shortTVTrendingAdapter = this.listAdapter) == null || (Z = shortTVTrendingAdapter.Z()) == null) {
            return;
        }
        int childCount = Z.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = Z.getChildAt(i);
            if ((childAt instanceof ShortTVDiscoverHeaderView) && childAt.getVisibility() == 0) {
                ((ShortTVDiscoverHeaderView) childAt).clearExposureCache();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(ShortTVFavoriteFragment shortTVFavoriteFragment) {
        shortTVFavoriteFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(ShortTVFavoriteFragment shortTVFavoriteFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVFavoriteFragment.d1().b(shortTVFavoriteFragment.getPageName(), subject, i, shortTVFavoriteFragment.a1());
            shortTVFavoriteFragment.g1(subject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ShortTVFavoriteFragment shortTVFavoriteFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVFavoriteFragment.d1().b(shortTVFavoriteFragment.getPageName(), subject, i, shortTVFavoriteFragment.a1());
            shortTVFavoriteFragment.g1(subject, true);
        }
    }

    private final ShortTVContentViewModel c1() {
        return (ShortTVContentViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j d1() {
        return (j) this.recReport.getValue();
    }

    private final void e1() {
        RecyclerView recyclerView;
        jj.b bVar = (jj.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.listAdapter);
        recyclerView.addOnScrollListener(this.exposureHelper);
        V0();
        recyclerView.addItemDecoration(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(ShortTVFavoriteFragment shortTVFavoriteFragment, ShortTVRespData shortTVRespData) {
        Pager pager;
        List<Subject> items;
        if (shortTVRespData == null || (items = shortTVRespData.getItems()) == null) {
            shortTVFavoriteFragment.N0();
        } else if (shortTVFavoriteFragment.A0() || Intrinsics.c(shortTVFavoriteFragment.mPageNum, MsgStyle.CUSTOM_LEFT_PIC)) {
            shortTVFavoriteFragment.I0(false);
            if (items.isEmpty()) {
                BaseListFragment.K0(shortTVFavoriteFragment, null, 1, null);
            } else {
                BaseQuickAdapter mBaseAdapter = shortTVFavoriteFragment.getMBaseAdapter();
                if (mBaseAdapter != null) {
                    mBaseAdapter.n1(items);
                }
            }
        } else {
            BaseQuickAdapter mBaseAdapter2 = shortTVFavoriteFragment.getMBaseAdapter();
            if (mBaseAdapter2 != null) {
                mBaseAdapter2.q(items);
            }
        }
        if (shortTVRespData != null && (pager = shortTVRespData.getPager()) != null) {
            if (Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                shortTVFavoriteFragment.mPageNum = pager.getNextPage();
                shortTVFavoriteFragment.B0();
            } else {
                BaseListFragment.D0(shortTVFavoriteFragment, false, 1, null);
            }
        }
        return Unit.a;
    }

    private final void g1(Subject subject, boolean isDownloadView) {
        FragmentActivity context = getContext();
        if (context != null) {
            DownloadManagerApi.e0(DownloadManagerApi.j.a(), context, getPageName(), BuildConfig.FLAVOR, subject.getOps(), "download_subject", isDownloadView, subject, (String) null, (Boolean) null, 384, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j h1() {
        return new j();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void G0() {
        I0(true);
        this.mPageNum = MsgStyle.CUSTOM_LEFT_PIC;
        lazyLoadData();
    }

    public final String a1() {
        return "favorite";
    }

    /* renamed from: b1, reason: from getter */
    public final ShortTVTrendingAdapter getListAdapter() {
        return this.listAdapter;
    }

    public final String getPageName() {
        return "minitv_favorite";
    }

    public String getPageStateLayoutTitle() {
        String string;
        Context context = getContext();
        return (context == null || (string = context.getString(R.string.short_tv_my_list)) == null) ? BuildConfig.FLAVOR : string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void initViewData() {
        super.initViewData();
        e1();
        I0(true);
    }

    public void initViewModel() {
        c1().h().j(this, new f(new Function1() { // from class: com.transsion.postdetail.shorttv.e
            public final Object invoke(Object obj) {
                Unit f1;
                f1 = ShortTVFavoriteFragment.f1(ShortTVFavoriteFragment.this, (ShortTVRespData) obj);
                return f1;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        String str = this.mPageNum;
        String str2 = MsgStyle.CUSTOM_LEFT_PIC;
        boolean c2 = Intrinsics.c(str, MsgStyle.CUSTOM_LEFT_PIC);
        ShortTVContentViewModel c1 = c1();
        String str3 = this.mPageNum;
        if (str3 != null) {
            str2 = str3;
        }
        c1.l(str2, 8, c2);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void loadMore() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter m0() {
        ShortTVTrendingAdapter shortTVTrendingAdapter = new ShortTVTrendingAdapter(getPageName(), true);
        shortTVTrendingAdapter.h0().C(new BaseLoadMoreView());
        shortTVTrendingAdapter.h0().z(true);
        shortTVTrendingAdapter.h0().y(true);
        shortTVTrendingAdapter.h0().E(3);
        shortTVTrendingAdapter.h0().D(new r6.f() { // from class: com.transsion.postdetail.shorttv.f
            public final void a() {
                ShortTVFavoriteFragment.X0(ShortTVFavoriteFragment.this);
            }
        });
        shortTVTrendingAdapter.R0(new c());
        shortTVTrendingAdapter.w1(new r6.d() { // from class: com.transsion.postdetail.shorttv.g
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTVFavoriteFragment.Y0(ShortTVFavoriteFragment.this, baseQuickAdapter, view, i);
            }
        });
        shortTVTrendingAdapter.l(new int[]{R$id.btn_download});
        shortTVTrendingAdapter.s1(new r6.b() { // from class: com.transsion.postdetail.shorttv.h
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShortTVFavoriteFragment.Z0(ShortTVFavoriteFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.listAdapter = shortTVTrendingAdapter;
        return shortTVTrendingAdapter;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onResume() {
        super.onResume();
        G0();
    }

    public void retryLoadData() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String s0() {
        String string;
        Context context = getContext();
        return (context == null || (string = context.getString(R.string.short_tv_my_list)) == null) ? BuildConfig.FLAVOR : string;
    }
}
