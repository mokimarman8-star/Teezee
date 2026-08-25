package com.transsion.moviedetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/transsion/moviedetail/fragment/StarringFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llm/n;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "d0", "(Landroid/view/LayoutInflater;)Llm/n;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "a", "Lkotlin/Lazy;", "c0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class StarringFragment extends BaseFragment<lm.n> {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.StarringFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m49invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.StarringFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m50invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RecyclerView recyclerView;
            ViewParent parent;
            RecyclerView recyclerView2;
            ViewTreeObserver viewTreeObserver;
            lm.n nVar = (lm.n) StarringFragment.this.getMViewBinding();
            if (nVar != null && (recyclerView2 = nVar.b) != null && (viewTreeObserver = recyclerView2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            lm.n nVar2 = (lm.n) StarringFragment.this.getMViewBinding();
            if (nVar2 == null || (recyclerView = nVar2.b) == null || (parent = recyclerView.getParent()) == null) {
                return;
            }
            parent.requestLayout();
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

    private final MovieDetailViewModel c0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Fragment fragment, StarringFragment starringFragment, Pair pair) {
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        AppCompatTextView appCompatTextView;
        Subject subject;
        MovieDetailActivity.INSTANCE.a("movie_detail get movie detail data --> it = " + fragment);
        List staffList = (pair == null || (subject = (Subject) pair.getSecond()) == null) ? null : subject.getStaffList();
        List list = staffList;
        if (list == null || list.isEmpty()) {
            return Unit.a;
        }
        lm.n nVar = (lm.n) starringFragment.getMViewBinding();
        if (nVar != null && (appCompatTextView = nVar.c) != null) {
            appCompatTextView.setText("(" + staffList.size() + ")");
        }
        lm.n nVar2 = (lm.n) starringFragment.getMViewBinding();
        if (nVar2 != null && (recyclerView4 = nVar2.b) != null) {
            recyclerView4.setLayoutManager(new NpaGridLayoutManager(starringFragment.getContext(), 4));
        }
        lm.n nVar3 = (lm.n) starringFragment.getMViewBinding();
        if (nVar3 != null && (recyclerView3 = nVar3.b) != null) {
            recyclerView3.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(12.0f), com.blankj.utilcode.util.a0.a(12.0f)));
        }
        com.transsion.moviedetail.adapter.a aVar = new com.transsion.moviedetail.adapter.a(staffList);
        aVar.w1(new r6.d() { // from class: com.transsion.moviedetail.fragment.i1
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                StarringFragment.f0(baseQuickAdapter, view, i);
            }
        });
        lm.n nVar4 = (lm.n) starringFragment.getMViewBinding();
        if (nVar4 != null && (recyclerView2 = nVar4.b) != null) {
            recyclerView2.setAdapter(aVar);
        }
        lm.n nVar5 = (lm.n) starringFragment.getMViewBinding();
        if (nVar5 != null && (recyclerView = nVar5.b) != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(starringFragment.new a());
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "v");
        Navigator c = TheRouter.c("/movie/staff");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
        Navigator.x(c.J("staff", (Staff) item), view.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public lm.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.n c = lm.n.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void lazyLoadData() {
        final Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            c0().F().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.fragment.h1
                public final Object invoke(Object obj) {
                    Unit e0;
                    e0 = StarringFragment.e0(parentFragment, this, (Pair) obj);
                    return e0;
                }
            }));
        }
    }
}
