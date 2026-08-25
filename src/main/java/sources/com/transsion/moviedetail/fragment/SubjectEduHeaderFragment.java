package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectEduInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010 R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010 R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010 R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/transsion/moviedetail/fragment/SubjectEduHeaderFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llm/q;", "<init>", "()V", "Landroid/view/View;", "view", BuildConfig.FLAVOR, "i0", "(Landroid/view/View;)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "movieDetailBean", "j0", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Landroid/view/LayoutInflater;", "inflater", "e0", "(Landroid/view/LayoutInflater;)Llm/q;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "initData", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "a", "Lkotlin/Lazy;", "d0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", BuildConfig.FLAVOR, "b", "Ljava/lang/String;", "TAG", "c", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "d", "ops", "e", "mSubjectId", "f", "pageName", BuildConfig.FLAVOR, "g", "I", "curSeason", "h", "moduleName", BuildConfig.FLAVOR, "i", "Z", "isInterceptDetail", "Lcom/transsion/moviedetail/view/HeaderExtensionFragment;", "j", "Lcom/transsion/moviedetail/view/HeaderExtensionFragment;", "headerExtensionFragment", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectEduHeaderFragment extends BaseFragment<lm.q> {

    /* renamed from: c, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: d, reason: from kotlin metadata */
    private String ops;

    /* renamed from: e, reason: from kotlin metadata */
    private String mSubjectId;

    /* renamed from: h, reason: from kotlin metadata */
    private String moduleName;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isInterceptDetail;

    /* renamed from: j, reason: from kotlin metadata */
    private HeaderExtensionFragment headerExtensionFragment;

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m51invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m52invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: b, reason: from kotlin metadata */
    private final String TAG = "SubjectEduHeaderFragment";

    /* renamed from: f, reason: from kotlin metadata */
    private String pageName = "subjectdetail";

    /* renamed from: g, reason: from kotlin metadata */
    private int curSeason = 1;

    static final class a implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function1) {
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

    private final MovieDetailViewModel d0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(SubjectEduHeaderFragment subjectEduHeaderFragment, Pair pair) {
        Subject subject = (Subject) pair.getSecond();
        wf.a.a.c(subjectEduHeaderFragment.TAG, "get movie detail data==" + pair, true);
        if (subject != null && subjectEduHeaderFragment.mMovieDetailBean == null) {
            subjectEduHeaderFragment.j0(subject);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(SubjectEduHeaderFragment subjectEduHeaderFragment, Integer num) {
        Intrinsics.e(num);
        subjectEduHeaderFragment.curSeason = num.intValue();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(SubjectEduHeaderFragment subjectEduHeaderFragment, View view) {
        Intrinsics.e(view);
        subjectEduHeaderFragment.i0(view);
    }

    private final void i0(View view) {
        if (this.isInterceptDetail || com.transsion.baseui.util.c.a.a(view.getId(), 1000L)) {
            return;
        }
        a.a.g(wf.a.a, "Open the right to view more detail", false, 2, (Object) null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            SubjectEduInfoMoreDetailDialog subjectEduInfoMoreDetailDialog = new SubjectEduInfoMoreDetailDialog();
            subjectEduInfoMoreDetailDialog.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("data_key_resource_detectors", this.mMovieDetailBean)}));
            subjectEduInfoMoreDetailDialog.n0(parentFragment, R$id.fl_bottom_dialog_container);
        }
    }

    private final void j0(Subject movieDetailBean) {
        Subject subject;
        AppCompatTextView appCompatTextView;
        FrameLayout frameLayout;
        lm.q qVar;
        CustomTextViewGroup customTextViewGroup;
        lm.q qVar2;
        CustomTextViewGroup customTextViewGroup2;
        lm.q qVar3;
        CustomTextViewGroup customTextViewGroup3;
        lm.q qVar4;
        CustomTextViewGroup customTextViewGroup4;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        HashMap g;
        HashMap g2;
        this.mMovieDetailBean = movieDetailBean;
        String ops = movieDetailBean != null ? movieDetailBean.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject = this.mMovieDetailBean) != null) {
            subject.setOps(this.ops);
        }
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        qi.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.n(this.ops);
        }
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g2 = logViewConfig3.g()) != null) {
            String subjectId = movieDetailBean.getSubjectId();
            if (subjectId == null) {
                subjectId = BuildConfig.FLAVOR;
            }
            g2.put("subject_id", subjectId);
        }
        qi.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
            g.put("has_resource", String.valueOf(movieDetailBean.getHasResource()));
        }
        lm.q qVar5 = (lm.q) getMViewBinding();
        if (qVar5 != null && (appCompatTextView4 = qVar5.j) != null) {
            appCompatTextView4.setText(movieDetailBean.getTitle());
        }
        String description = movieDetailBean.getDescription();
        if (description == null || description.length() <= 0) {
            lm.q qVar6 = (lm.q) getMViewBinding();
            if (qVar6 != null && (appCompatTextView = qVar6.f) != null) {
                uf.c.g(appCompatTextView);
            }
        } else {
            lm.q qVar7 = (lm.q) getMViewBinding();
            if (qVar7 != null && (appCompatTextView3 = qVar7.f) != null) {
                appCompatTextView3.setText(movieDetailBean.getDescription());
            }
            lm.q qVar8 = (lm.q) getMViewBinding();
            if (qVar8 != null && (appCompatTextView2 = qVar8.f) != null) {
                uf.c.k(appCompatTextView2);
            }
        }
        int a2 = com.transsion.flow.h.a(movieDetailBean.getSubjectType());
        lm.q qVar9 = (lm.q) getMViewBinding();
        if (qVar9 != null && (appCompatImageView = qVar9.c) != null) {
            appCompatImageView.setImageResource(a2);
        }
        String category = movieDetailBean.getCategory();
        if (category != null && (qVar4 = (lm.q) getMViewBinding()) != null && (customTextViewGroup4 = qVar4.e) != null) {
            customTextViewGroup4.setText(category);
        }
        String genre = movieDetailBean.getGenre();
        if (genre != null && (qVar3 = (lm.q) getMViewBinding()) != null && (customTextViewGroup3 = qVar3.h) != null) {
            customTextViewGroup3.setText(genre);
        }
        String a3 = a.a(this.mMovieDetailBean);
        if (a3 != null && (qVar2 = (lm.q) getMViewBinding()) != null && (customTextViewGroup2 = qVar2.g) != null) {
            customTextViewGroup2.setText(a3);
        }
        Context context = getContext();
        if (context != null) {
            int i = R$string.movie_detail_students;
            Long viewers = movieDetailBean.getViewers();
            String string = context.getString(i, Long.valueOf(viewers != null ? viewers.longValue() : 0L));
            if (string != null && (qVar = (lm.q) getMViewBinding()) != null && (customTextViewGroup = qVar.k) != null) {
                customTextViewGroup.setText(string);
            }
        }
        if (this.isInterceptDetail) {
            lm.q qVar10 = (lm.q) getMViewBinding();
            if (qVar10 == null || (frameLayout = qVar10.b) == null) {
                return;
            }
            uf.c.g(frameLayout);
            return;
        }
        if (this.headerExtensionFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.w p = childFragmentManager.p();
            Intrinsics.g(p, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.mMovieDetailBean);
            bundle.putString("module_name", this.moduleName);
            bundle.putInt("season", this.curSeason);
            bundle.putString("ops", this.ops);
            bundle.putString("page_from", this.pageName);
            headerExtensionFragment.setArguments(bundle);
            p.s(R$id.extension_container, headerExtensionFragment);
            this.headerExtensionFragment = headerExtensionFragment;
            p.j();
        }
    }

    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public lm.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.q c = lm.q.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initData(View view, Bundle savedInstanceState) {
        String str;
        View view2;
        lm.q qVar;
        AppCompatTextView appCompatTextView;
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.mMovieDetailBean = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.ops = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.isInterceptDetail = arguments3 != null ? arguments3.getBoolean("is_Intercept_detail") : false;
        Bundle arguments4 = getArguments();
        this.mSubjectId = arguments4 != null ? arguments4.getString("id") : null;
        Bundle arguments5 = getArguments();
        this.moduleName = arguments5 != null ? arguments5.getString("module_name") : null;
        Bundle arguments6 = getArguments();
        this.curSeason = arguments6 != null ? arguments6.getInt("season") : 1;
        Bundle arguments7 = getArguments();
        this.ops = arguments7 != null ? arguments7.getString("ops") : null;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (str = arguments8.getString("page_from")) == null) {
            str = "subjectdetail";
        }
        this.pageName = str;
        Subject subject = this.mMovieDetailBean;
        if (subject != null) {
            Intrinsics.e(subject);
            j0(subject);
        }
        if (this.isInterceptDetail && (qVar = (lm.q) getMViewBinding()) != null && (appCompatTextView = qVar.j) != null) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        MovieDetailViewModel d0 = d0();
        d0.F().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.fragment.l1
            public final Object invoke(Object obj) {
                Unit f0;
                f0 = SubjectEduHeaderFragment.f0(SubjectEduHeaderFragment.this, (Pair) obj);
                return f0;
            }
        }));
        d0.K().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.fragment.m1
            public final Object invoke(Object obj) {
                Unit g0;
                g0 = SubjectEduHeaderFragment.g0(SubjectEduHeaderFragment.this, (Integer) obj);
                return g0;
            }
        }));
        lm.q qVar2 = (lm.q) getMViewBinding();
        if (qVar2 == null || (view2 = qVar2.l) == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubjectEduHeaderFragment.h0(SubjectEduHeaderFragment.this, view3);
            }
        });
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void lazyLoadData() {
    }
}
