package com.transsion.search.fragment.suggest;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import vg.a;
import vp.j;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\n\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u0015\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/transsion/search/fragment/suggest/SearchSuggestFragment;", "Lcom/transsion/search/fragment/BaseSearchMainFragment;", "Lvp/j;", "<init>", "()V", BuildConfig.FLAVOR, "Lcom/transsion/search/bean/SuggestEntity;", "newList", "oldList", BuildConfig.FLAVOR, "g0", "(Ljava/util/List;Ljava/util/List;)Z", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Landroid/view/LayoutInflater;", "inflater", "i0", "(Landroid/view/LayoutInflater;)Lvp/j;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initListener", "lazyLoadData", "Lcom/transsion/search/fragment/suggest/SearchSuggestFragment$b;", "listener", "n0", "(Lcom/transsion/search/fragment/suggest/SearchSuggestFragment$b;)V", BuildConfig.FLAVOR, "keyWord", "m0", "(Ljava/lang/String;)V", "a", "Lcom/transsion/search/fragment/suggest/SearchSuggestFragment$b;", "mClickListener", "Lcom/transsion/search/viewmodel/SearchViewModel;", "b", "Lkotlin/Lazy;", "h0", "()Lcom/transsion/search/viewmodel/SearchViewModel;", "mViewModel", "Lcom/transsion/search/fragment/suggest/d;", "c", "Lcom/transsion/search/fragment/suggest/d;", "mAdapter", "d", "Ljava/lang/String;", "mKeyWord", "e", "mOps", "Lvg/a;", "f", "Lvg/a;", "exposeUtil", "g", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchSuggestFragment extends BaseSearchMainFragment<j> {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private b mClickListener;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.search.fragment.suggest.d mAdapter;

    /* renamed from: e, reason: from kotlin metadata */
    private String mOps;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy mViewModel = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.suggest.b
        public final Object invoke() {
            SearchViewModel l0;
            l0 = SearchSuggestFragment.l0();
            return l0;
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    private String mKeyWord = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private final vg.a exposeUtil = new vg.a();

    /* renamed from: com.transsion.search.fragment.suggest.SearchSuggestFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchSuggestFragment a() {
            return new SearchSuggestFragment();
        }
    }

    public interface b {
        void a(SuggestEntity suggestEntity, int i, String str, String str2);
    }

    public static final class c implements a.b {
        c() {
        }

        public int a() {
            List data;
            com.transsion.search.fragment.suggest.d dVar = SearchSuggestFragment.this.mAdapter;
            if (dVar == null || (data = dVar.getData()) == null) {
                return 0;
            }
            return data.size();
        }

        public void onItemViewVisible(boolean z, int i) {
            List data;
            com.transsion.search.fragment.suggest.d dVar = SearchSuggestFragment.this.mAdapter;
            com.transsion.search.widget.d.a.v((dVar == null || (data = dVar.getData()) == null) ? null : (SuggestEntity) CollectionsKt.l0(data, i), Integer.valueOf(i), SearchSuggestFragment.this.mKeyWord, SearchSuggestFragment.this.mOps);
        }
    }

    public static final class d extends DiffUtil.e {
        d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(SuggestEntity suggestEntity, SuggestEntity suggestEntity2) {
            Intrinsics.h(suggestEntity, "oldItem");
            Intrinsics.h(suggestEntity2, "newItem");
            return suggestEntity.hashCode() == suggestEntity2.hashCode();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(SuggestEntity suggestEntity, SuggestEntity suggestEntity2) {
            Intrinsics.h(suggestEntity, "oldItem");
            Intrinsics.h(suggestEntity2, "newItem");
            return suggestEntity.hashCode() == suggestEntity2.hashCode();
        }
    }

    static final class e implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        e(Function1 function1) {
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

    private final boolean g0(List newList, List oldList) {
        SuggestEntity suggestEntity;
        Subject subject;
        int size = oldList != null ? oldList.size() : 0;
        int size2 = newList != null ? newList.size() : 0;
        if (size2 <= 0 || size != size2) {
            return false;
        }
        if (newList != null) {
            int i = 0;
            for (Object obj : newList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                SuggestEntity suggestEntity2 = (SuggestEntity) obj;
                Integer type = suggestEntity2.getType();
                if (type != null && type.intValue() == 1) {
                    Subject subject2 = suggestEntity2.getSubject();
                    if (!Intrinsics.c(subject2 != null ? subject2.getSubjectId() : null, (oldList == null || (suggestEntity = (SuggestEntity) oldList.get(i)) == null || (subject = suggestEntity.getSubject()) == null) ? null : subject.getSubjectId())) {
                        return false;
                    }
                }
                Integer type2 = suggestEntity2.getType();
                if (type2 == null || type2.intValue() != 1) {
                    int hashCode = suggestEntity2.hashCode();
                    SuggestEntity suggestEntity3 = oldList != null ? (SuggestEntity) oldList.get(i) : null;
                    if (hashCode != (suggestEntity3 != null ? suggestEntity3.hashCode() : 0)) {
                        return false;
                    }
                }
                i = i2;
            }
        }
        return true;
    }

    private final SearchViewModel h0() {
        return (SearchViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(SearchSuggestFragment searchSuggestFragment, String str) {
        List<SuggestEntity> items;
        SearchSuggestEntity searchSuggestEntity = searchSuggestFragment.h0().s().get(str);
        if (searchSuggestEntity != null && ((items = searchSuggestEntity.getItems()) == null || !items.isEmpty())) {
            String ops = searchSuggestEntity.getOps();
            if (ops == null) {
                ops = BuildConfig.FLAVOR;
            }
            searchSuggestFragment.mOps = ops;
            com.transsion.search.fragment.suggest.d dVar = searchSuggestFragment.mAdapter;
            if (dVar != null) {
                dVar.R1(searchSuggestFragment.mKeyWord);
            }
            List<SuggestEntity> items2 = searchSuggestEntity.getItems();
            com.transsion.search.fragment.suggest.d dVar2 = searchSuggestFragment.mAdapter;
            if (searchSuggestFragment.g0(items2, dVar2 != null ? dVar2.getData() : null)) {
                com.transsion.search.fragment.suggest.d dVar3 = searchSuggestFragment.mAdapter;
                if (dVar3 != null) {
                    dVar3.notifyDataSetChanged();
                }
            } else {
                searchSuggestFragment.exposeUtil.l();
                com.transsion.search.fragment.suggest.d dVar4 = searchSuggestFragment.mAdapter;
                if (dVar4 != null) {
                    dVar4.n1(searchSuggestEntity.getItems());
                }
                searchSuggestFragment.exposeUtil.k();
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(SearchSuggestFragment searchSuggestFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.search.fragment.suggest.d dVar = searchSuggestFragment.mAdapter;
        SuggestEntity suggestEntity = (dVar == null || (data = dVar.getData()) == null) ? null : (SuggestEntity) data.get(i);
        com.transsion.search.widget.d.a.w(suggestEntity, i, searchSuggestFragment.mKeyWord, searchSuggestFragment.mOps);
        b bVar = searchSuggestFragment.mClickListener;
        if (bVar != null) {
            String str = searchSuggestFragment.mKeyWord;
            String str2 = searchSuggestFragment.mOps;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            bVar.a(suggestEntity, i, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchViewModel l0() {
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return new SearchViewModel(a);
    }

    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public j getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        j c2 = j.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void initListener() {
        vg.a aVar = this.exposeUtil;
        j jVar = (j) getMViewBinding();
        aVar.n(jVar != null ? jVar.b : null, new c());
        h0().r().j(this, new e(new Function1() { // from class: com.transsion.search.fragment.suggest.a
            public final Object invoke(Object obj) {
                Unit j0;
                j0 = SearchSuggestFragment.j0(SearchSuggestFragment.this, (String) obj);
                return j0;
            }
        }));
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.h(view, "view");
        j jVar = (j) getMViewBinding();
        if (jVar == null || (recyclerView = jVar.b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        com.transsion.search.fragment.suggest.d dVar = new com.transsion.search.fragment.suggest.d();
        dVar.R0(new d());
        this.mAdapter = dVar;
        recyclerView.setAdapter(dVar);
        com.transsion.search.fragment.suggest.d dVar2 = this.mAdapter;
        if (dVar2 != null) {
            dVar2.w1(new r6.d() { // from class: com.transsion.search.fragment.suggest.c
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SearchSuggestFragment.k0(SearchSuggestFragment.this, baseQuickAdapter, view2, i);
                }
            });
        }
    }

    public void lazyLoadData() {
    }

    public final void m0(String keyWord) {
        HashMap g;
        Intrinsics.h(keyWord, "keyWord");
        this.mKeyWord = keyWord;
        h0().n(keyWord);
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    public final void n0(b listener) {
        Intrinsics.h(listener, "listener");
        this.mClickListener = listener;
    }

    public qi.b newLogViewConfig() {
        qi.b bVar = new qi.b("search_suggest", false, 2, null);
        bVar.l(true);
        bVar.g().put("search_id", BaseSearchMainFragment.INSTANCE.a());
        return bVar;
    }
}
