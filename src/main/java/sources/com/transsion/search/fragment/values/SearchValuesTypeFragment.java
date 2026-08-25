package com.transsion.search.fragment.values;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.AccurateSubject;
import com.transsion.search.bean.Count;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.values.SearchValuesFragment;
import com.transsion.search.fragment.values.SearchValuesTypeFragment;
import com.transsion.search.fragment.values.adapter.a;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.AccurateSubjectView;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import ij.k;
import ij.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;
import r6.d;
import t6.f;
import vg.a;
import vp.l;
import wf.a;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J+\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\fJ\u000f\u0010'\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\tJ\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u0010\u0004J\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010<R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006c"}, d2 = {"Lcom/transsion/search/fragment/values/SearchValuesTypeFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lvp/l;", "<init>", "()V", BuildConfig.FLAVOR, "s0", BuildConfig.FLAVOR, "E0", "()Z", BuildConfig.FLAVOR, "v0", "()Ljava/lang/String;", "F0", "y0", "Lcom/transsion/search/bean/SearchSubject;", "subject", BuildConfig.FLAVOR, "position", "type", "H0", "(Lcom/transsion/search/bean/SearchSubject;II)V", "loadMore", "Lcom/transsion/moviedetailapi/bean/Subject;", "subjectEntity", "u0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "item", "x0", "Lcom/transsion/search/bean/SearchWorkEntity;", "entity", "J0", "(Lcom/transsion/search/bean/SearchWorkEntity;)V", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "w0", "(Landroid/view/LayoutInflater;)Lvp/l;", "getPageStateLayoutTitle", "getScreenType", "()I", "isShowPageStateLayoutTitle", "isShowTitleLayout", "Landroid/view/View;", "getEmptyView", "(Z)Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "initViewData", "initViewModel", "initListener", "retryLoadData", "lazyLoadData", "onResume", "onDestroy", "Lcom/transsion/search/viewmodel/SearchViewModel;", "a", "Lcom/transsion/search/viewmodel/SearchViewModel;", "mSearchViewModel", "b", "I", "page", "c", "perPage", "Lcom/transsion/search/fragment/values/adapter/a;", "d", "Lcom/transsion/search/fragment/values/adapter/a;", "mSubjectAdapter", "e", "Ljava/lang/String;", "mKeyWord", "f", "mType", "Lcom/transsion/search/bean/Count;", "g", "Lcom/transsion/search/bean/Count;", "mCount", "h", "Lcom/transsion/search/bean/SearchWorkEntity;", "mEntity", BuildConfig.FLAVOR, "i", "Ljava/util/List;", "subjectList", "Lcom/transsion/search/bean/AccurateSubject;", "j", "Lcom/transsion/search/bean/AccurateSubject;", "accurateSubject", "k", "Landroid/view/View;", "loadingView", "l", "Z", "isLoading", "Lvg/a;", "m", "Lvg/a;", "exposeUtil", "n", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchValuesTypeFragment extends LazyFragment<l> {

    /* renamed from: a, reason: from kotlin metadata */
    private SearchViewModel mSearchViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    private a mSubjectAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    private Count mCount;

    /* renamed from: h, reason: from kotlin metadata */
    private SearchWorkEntity mEntity;

    /* renamed from: j, reason: from kotlin metadata */
    private AccurateSubject accurateSubject;

    /* renamed from: k, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: b, reason: from kotlin metadata */
    private int page = 1;

    /* renamed from: c, reason: from kotlin metadata */
    private int perPage = 12;

    /* renamed from: e, reason: from kotlin metadata */
    private String mKeyWord = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private int mType = 1;

    /* renamed from: i, reason: from kotlin metadata */
    private final List subjectList = new ArrayList();

    /* renamed from: m, reason: from kotlin metadata */
    private final vg.a exposeUtil = new vg.a();

    public static final class b implements a.b {
        b() {
        }

        public int a() {
            List data;
            com.transsion.search.fragment.values.adapter.a aVar = SearchValuesTypeFragment.this.mSubjectAdapter;
            if (aVar == null || (data = aVar.getData()) == null) {
                return 0;
            }
            return data.size();
        }

        public void onItemViewVisible(boolean z, int i) {
            List data;
            if (z) {
                com.transsion.search.fragment.values.adapter.a aVar = SearchValuesTypeFragment.this.mSubjectAdapter;
                SearchSubject searchSubject = (aVar == null || (data = aVar.getData()) == null) ? null : (SearchSubject) CollectionsKt.l0(data, i);
                SearchValuesFragment.INSTANCE.d(BuildConfig.FLAVOR, searchSubject != null ? searchSubject.getSubjectId() : null, BuildConfig.FLAVOR, searchSubject != null ? searchSubject.getOps() : null, i, 3);
            }
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(SearchValuesTypeFragment searchValuesTypeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.search.fragment.values.adapter.a aVar = searchValuesTypeFragment.mSubjectAdapter;
        I0(searchValuesTypeFragment, (aVar == null || (data = aVar.getData()) == null) ? null : (SearchSubject) data.get(i), i, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SearchValuesTypeFragment searchValuesTypeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() != R$id.llDownload || com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        Object obj = baseQuickAdapter.getData().get(i);
        searchValuesTypeFragment.u0(obj instanceof Subject ? (Subject) obj : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(SearchValuesTypeFragment searchValuesTypeFragment, SearchWorkEntity searchWorkEntity) {
        f h0;
        searchValuesTypeFragment.isLoading = false;
        searchValuesTypeFragment.showContentView();
        if (searchWorkEntity == null) {
            com.transsion.search.fragment.values.adapter.a aVar = searchValuesTypeFragment.mSubjectAdapter;
            if (aVar != null && (h0 = aVar.h0()) != null) {
                h0.v();
            }
        } else {
            Integer subjectType = searchWorkEntity.getSubjectType();
            Count count = searchValuesTypeFragment.mCount;
            if (Intrinsics.c(subjectType, count != null ? count.getSubjectType() : null)) {
                searchValuesTypeFragment.J0(searchWorkEntity);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(SearchValuesTypeFragment searchValuesTypeFragment) {
        f h0;
        com.transsion.search.fragment.values.adapter.a aVar = searchValuesTypeFragment.mSubjectAdapter;
        if (aVar == null || (h0 = aVar.h0()) == null) {
            return;
        }
        h0.v();
    }

    private final boolean E0() {
        com.transsion.search.fragment.values.adapter.a aVar;
        List data;
        if (yg.l.a.e() || (aVar = this.mSubjectAdapter) == null || (data = aVar.getData()) == null || !data.isEmpty()) {
            return false;
        }
        PageStatusFragment.showNoNetworkView$default(this, false, 1, (Object) null);
        return true;
    }

    private final void F0() {
        Function1 function1 = new Function1() { // from class: bq.e
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = SearchValuesTypeFragment.G0(SearchValuesTypeFragment.this, (AddToDownloadEvent) obj);
                return G0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(SearchValuesTypeFragment searchValuesTypeFragment, AddToDownloadEvent addToDownloadEvent) {
        com.transsion.search.fragment.values.adapter.a aVar;
        List data;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            com.transsion.search.fragment.values.adapter.a aVar2 = searchValuesTypeFragment.mSubjectAdapter;
            int i = -1;
            if (aVar2 != null && (data = aVar2.getData()) != null) {
                Iterator it = data.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((SearchSubject) it.next()).getSubjectId(), addToDownloadEvent.getSubjectId())) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i >= 0 && (aVar = searchValuesTypeFragment.mSubjectAdapter) != null) {
                aVar.notifyItemChanged(i + (aVar != null ? aVar.a0() : 0));
            }
        } catch (Exception unused) {
            a.a.f(wf.a.a, "search", " callback change data fail", false, 4, (Object) null);
        }
        return Unit.a;
    }

    private final void H0(SearchSubject subject, int position, int type) {
        String deeplink;
        Uri g;
        if (subject != null) {
            if (position >= 0) {
                SearchValuesFragment.Companion companion = SearchValuesFragment.INSTANCE;
                companion.b(BuildConfig.FLAVOR, subject.getSubjectId(), BuildConfig.FLAVOR, subject.getOps(), position, type, companion.a(), (r19 & 128) != 0 ? null : null);
            }
            if (subject.getViewType() != 1) {
                if (this.mType != 3) {
                    jo.b bVar = new jo.b();
                    bVar.o(3);
                    bVar.n(1);
                    bVar.s(subject);
                    FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                    String name = jo.b.class.getName();
                    Intrinsics.g(name, "getName(...)");
                    applicationScopeViewModel.postEvent(name, bVar, 0L);
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType == null || subjectType.intValue() != value) {
                    Navigator c2 = TheRouter.c("/movie/detail");
                    Integer subjectType2 = subject.getSubjectType();
                    Navigator.x(c2.F("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("ops", subject.getOps()), requireContext(), (mf.c) null, 2, (Object) null);
                    return;
                } else {
                    DownloadManagerApi a = DownloadManagerApi.j.a();
                    FragmentActivity context = getContext();
                    Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = context;
                    qi.b logViewConfig = getLogViewConfig();
                    DownloadManagerApi.e0(a, fragmentActivity, logViewConfig != null ? logViewConfig.f() : null, BuildConfig.FLAVOR, subject.getOps(), "download_subject", false, subject, (String) null, (Boolean) null, 384, (Object) null);
                    return;
                }
            }
            VerticalRank verticalRank = subject.getVerticalRank();
            if (verticalRank != null && (deeplink = verticalRank.getDeeplink()) != null && (g = com.transsion.baselib.helper.b.a.g(Uri.parse(deeplink))) != null) {
                k.o(g);
            }
        }
    }

    static /* synthetic */ void I0(SearchValuesTypeFragment searchValuesTypeFragment, SearchSubject searchSubject, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 3;
        }
        searchValuesTypeFragment.H0(searchSubject, i, i2);
    }

    private final void J0(SearchWorkEntity entity) {
        com.transsion.search.fragment.values.adapter.a aVar;
        List data;
        f h0;
        com.transsion.search.fragment.values.adapter.a aVar2;
        f h02;
        com.transsion.search.fragment.values.adapter.a aVar3;
        f h03;
        Pager pager;
        Pager pager2;
        Pager pager3;
        f h04;
        com.transsion.search.fragment.values.adapter.a aVar4 = this.mSubjectAdapter;
        if (aVar4 != null && (h04 = aVar4.h0()) != null) {
            h04.s();
        }
        this.page = (entity == null || (pager3 = entity.getPager()) == null) ? 1 : pager3.getNextPage();
        this.perPage = (entity == null || (pager2 = entity.getPager()) == null) ? 10 : pager2.getPerPage();
        List<SearchSubject> items = entity != null ? entity.getItems() : null;
        boolean hasMore = (entity == null || (pager = entity.getPager()) == null) ? false : pager.getHasMore();
        List<SearchSubject> list = items;
        if ((list == null || list.isEmpty()) && (aVar = this.mSubjectAdapter) != null && (data = aVar.getData()) != null && data.isEmpty()) {
            PageStatusFragment.showEmptyView$default(this, false, 1, (Object) null);
        }
        if (list == null || list.isEmpty()) {
            com.transsion.search.fragment.values.adapter.a aVar5 = this.mSubjectAdapter;
            if (aVar5 != null && (h0 = aVar5.h0()) != null) {
                h0.t(false);
            }
        } else {
            com.transsion.search.fragment.values.adapter.a aVar6 = this.mSubjectAdapter;
            if (aVar6 != null) {
                aVar6.q(list);
            }
        }
        if (!hasMore && (aVar3 = this.mSubjectAdapter) != null && (h03 = aVar3.h0()) != null) {
            h03.t(false);
        }
        if (entity != null || (aVar2 = this.mSubjectAdapter) == null || (h02 = aVar2.h0()) == null) {
            return;
        }
        h02.v();
    }

    private final void loadMore() {
        RecyclerView recyclerView;
        Integer subjectType;
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.no_network_toast);
            l lVar = (l) getMViewBinding();
            if (lVar == null || (recyclerView = lVar.b) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: bq.g
                @Override // java.lang.Runnable
                public final void run() {
                    SearchValuesTypeFragment.D0(SearchValuesTypeFragment.this);
                }
            }, 300L);
            return;
        }
        SearchViewModel searchViewModel = this.mSearchViewModel;
        if (searchViewModel != null) {
            int i = this.page;
            int i2 = this.perPage;
            String v0 = v0();
            Count count = this.mCount;
            searchViewModel.x(i, i2, v0, (count == null || (subjectType = count.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.transsion.search.widget.AccurateSubjectView] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private final void s0() {
        SearchWorkEntity searchWorkEntity = this.mEntity;
        final AccurateSubject accurateSubject = searchWorkEntity != null ? searchWorkEntity.getAccurateSubject() : null;
        if (accurateSubject != null) {
            Context context = getContext();
            View accurateSubjectView = context != null ? new AccurateSubjectView(context) : 0;
            if (accurateSubjectView != 0) {
                com.transsion.search.fragment.values.adapter.a aVar = this.mSubjectAdapter;
                if (aVar != null) {
                    BaseQuickAdapter.y(aVar, accurateSubjectView, 0, 0, 6, (Object) null);
                }
                accurateSubjectView.setData(accurateSubject);
                accurateSubjectView.setOnClickListener(new View.OnClickListener() { // from class: bq.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchValuesTypeFragment.t0(SearchValuesTypeFragment.this, accurateSubject, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(SearchValuesTypeFragment searchValuesTypeFragment, AccurateSubject accurateSubject, View view) {
        searchValuesTypeFragment.H0(accurateSubject.getSubject(), 0, 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
    
        if (r6.intValue() != 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0092, code lost:
    
        if (((com.transsion.moviedetailapi.bean.ResourceDetectors) r4.get(0)).isMultiResolution() == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u0(Subject subjectEntity) {
        String str;
        boolean z;
        List resourceDetectors;
        String resourceLink;
        String subjectId;
        Context context;
        List resourceDetectors2;
        String str2;
        boolean z2;
        if (subjectEntity != null) {
            Integer subjectType = subjectEntity.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a = DownloadManagerApi.j.a();
                FragmentActivity context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context2;
                qi.b logViewConfig = getLogViewConfig();
                DownloadManagerApi.e0(a, fragmentActivity, logViewConfig != null ? logViewConfig.f() : null, BuildConfig.FLAVOR, subjectEntity.getOps(), "download_subject", true, subjectEntity, (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        if (t.a.b()) {
            x0(subjectEntity);
            return;
        }
        String str3 = BuildConfig.FLAVOR;
        if (subjectEntity == null || (resourceDetectors2 = subjectEntity.getResourceDetectors()) == null) {
            str = BuildConfig.FLAVOR;
            z = false;
        } else {
            if (resourceDetectors2.isEmpty()) {
                str2 = BuildConfig.FLAVOR;
            } else {
                str2 = ((ResourceDetectors) resourceDetectors2.get(0)).getResourceId();
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                Integer type = ((ResourceDetectors) resourceDetectors2.get(0)).getType();
                z2 = true;
                if (type != null) {
                }
            }
            z2 = false;
            str = str2;
            z = z2;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.j;
        if (DownloadManagerApi.x0(aVar.a(), subjectEntity != null ? subjectEntity.getSubjectId() : null, str, z, false, 8, (Object) null)) {
            if (subjectEntity == null || (subjectId = subjectEntity.getSubjectId()) == null || (context = getContext()) == null) {
                return;
            }
            DownloadManagerApi a2 = aVar.a();
            qi.b logViewConfig2 = getLogViewConfig();
            DownloadManagerApi.z0(a2, subjectId, context, logViewConfig2 != null ? logViewConfig2.f() : null, (String) null, 8, (Object) null);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (subjectEntity != null && (resourceDetectors = subjectEntity.getResourceDetectors()) != null && !resourceDetectors.isEmpty() && (resourceLink = ((ResourceDetectors) resourceDetectors.get(0)).getResourceLink()) != null) {
                str3 = resourceLink;
            }
            String str4 = str3;
            DownloadManagerApi a3 = aVar.a();
            FragmentActivity context3 = getContext();
            Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity2 = context3;
            qi.b logViewConfig3 = getLogViewConfig();
            DownloadManagerApi.M(a3, fragmentActivity2, subjectEntity, logViewConfig3 != null ? logViewConfig3.f() : null, BuildConfig.FLAVOR, subjectEntity != null ? subjectEntity.getOps() : null, str4, (String) null, "download_subject", (String) null, false, 832, (Object) null);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final String v0() {
        String o0;
        SearchValuesFragment parentFragment = getParentFragment();
        SearchValuesFragment searchValuesFragment = parentFragment instanceof SearchValuesFragment ? parentFragment : null;
        return (searchValuesFragment == null || (o0 = searchValuesFragment.o0()) == null) ? BuildConfig.FLAVOR : o0;
    }

    private final void x0(Subject item) {
        if (item == null) {
            return;
        }
        Navigator c2 = TheRouter.c("/playvideo/detail");
        Integer subjectType = item.getSubjectType();
        Navigator.x(c2.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", item.getSubjectId()).K("ops", item.getOps()), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final void y0() {
        RecyclerView recyclerView;
        l lVar = (l) getMViewBinding();
        if (lVar == null || (recyclerView = lVar.b) == null) {
            return;
        }
        recyclerView.setItemAnimator((RecyclerView.j) null);
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        Context context = recyclerView.getContext();
        Intrinsics.g(context, "getContext(...)");
        com.transsion.search.fragment.values.adapter.a aVar = new com.transsion.search.fragment.values.adapter.a(context);
        aVar.h0().D(new r6.f() { // from class: bq.h
            public final void a() {
                SearchValuesTypeFragment.z0(SearchValuesTypeFragment.this);
            }
        });
        aVar.w1(new d() { // from class: bq.i
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchValuesTypeFragment.A0(SearchValuesTypeFragment.this, baseQuickAdapter, view, i);
            }
        });
        aVar.l(new int[]{R$id.llDownload});
        aVar.s1(new r6.b() { // from class: bq.j
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchValuesTypeFragment.B0(SearchValuesTypeFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mSubjectAdapter = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.addItemDecoration(new tf.b(a0.a(4.0f), a0.a(4.0f), a0.a(16.0f), a0.a(16.0f)));
        this.exposeUtil.n(recyclerView, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SearchValuesTypeFragment searchValuesTypeFragment) {
        searchValuesTypeFragment.loadMore();
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(2, getScreenType(), isShowPageStateLayoutTitle(), getPageStateLayoutTitle(), getEmptyDescText());
        return stateView;
    }

    public View getLoadingView() {
        if (this.loadingView == null) {
            this.loadingView = LayoutInflater.from(requireContext()).inflate(R$layout.loading_search_values_type_fragment_layout, (ViewGroup) getFlStateView(), false);
        }
        return this.loadingView;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public int getScreenType() {
        return 3;
    }

    public void initListener() {
    }

    public void initViewData() {
        y0();
        F0();
    }

    public void initViewModel() {
        SearchViewModel a = new v0(this).a(SearchViewModel.class);
        a.p().j(getViewLifecycleOwner(), new c(new Function1() { // from class: bq.f
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = SearchValuesTypeFragment.C0(SearchValuesTypeFragment.this, (SearchWorkEntity) obj);
                return C0;
            }
        }));
        this.mSearchViewModel = a;
    }

    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        Integer subjectType;
        Integer subjectType2;
        Count count = this.mCount;
        if (count != null && (subjectType2 = count.getSubjectType()) != null && subjectType2.intValue() == 0) {
            this.page = 2;
            com.transsion.search.fragment.values.adapter.a aVar = this.mSubjectAdapter;
            if (aVar != null) {
                aVar.n1(this.subjectList);
            }
            s0();
            return;
        }
        a.a aVar2 = wf.a.a;
        int i = this.page;
        int i2 = this.perPage;
        String v0 = v0();
        Count count2 = this.mCount;
        a.a.f(aVar2, "search", "SearchValuesTypeFragment --> loadDefaultData() -->  page = " + i + " -- perPage = " + i2 + " -- mKeyWord = " + v0 + " -- mCount?.subjectType = " + (count2 != null ? count2.getSubjectType() : null), false, 4, (Object) null);
        if (E0()) {
            return;
        }
        showLoadingView();
        if (this.isLoading) {
            a.a.l(aVar2, "search", "SearchValuesTypeFragment --> loadDefaultData() --> isLoading == true", false, 4, (Object) null);
            return;
        }
        this.isLoading = true;
        SearchViewModel searchViewModel = this.mSearchViewModel;
        if (searchViewModel != null) {
            int i3 = this.page;
            int i4 = this.perPage;
            String v02 = v0();
            Count count3 = this.mCount;
            searchViewModel.x(i3, i4, v02, (count3 == null || (subjectType = count3.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.exposeUtil.d();
        com.transsion.search.fragment.values.adapter.a aVar = this.mSubjectAdapter;
        if (aVar != null) {
            aVar.n1((Collection) null);
        }
        this.isLoading = false;
        this.page = 1;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void onResume() {
        com.transsion.search.fragment.values.adapter.a aVar;
        List data;
        super.onResume();
        if (E0() || (aVar = this.mSubjectAdapter) == null || (data = aVar.getData()) == null || !data.isEmpty() || this.page != 1) {
            return;
        }
        retryLoadData();
    }

    public void receiveArguments() {
        Integer subjectType;
        super.receiveArguments();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extend_value_keyword");
            if (string == null) {
                string = BuildConfig.FLAVOR;
            }
            this.mKeyWord = string;
            Serializable serializable = arguments.getSerializable("extend_value_count");
            this.mCount = serializable instanceof Count ? (Count) serializable : null;
            this.mType = arguments.getInt("extend_value_type");
        }
        SearchWorkEntity searchWorkEntity = this.mEntity;
        if (searchWorkEntity != null) {
            Count count = this.mCount;
            if (count != null && (subjectType = count.getSubjectType()) != null && subjectType.intValue() == 0) {
                List<SearchSubject> items = searchWorkEntity.getItems();
                if (!items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (it.hasNext()) {
                        this.subjectList.add((SearchSubject) it.next());
                    }
                }
            }
            this.accurateSubject = searchWorkEntity.getAccurateSubject();
        }
    }

    public void retryLoadData() {
        List data;
        com.transsion.search.fragment.values.adapter.a aVar = this.mSubjectAdapter;
        if (aVar == null || (data = aVar.getData()) == null || !data.isEmpty()) {
            loadMore();
        } else {
            a.a.f(wf.a.a, "search", "SearchValuesTypeFragment --> retryLoadData() --> 重新连接网络的时候 加载数据", false, 4, (Object) null);
            lazyLoadData();
        }
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public l getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        l c2 = l.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }
}
