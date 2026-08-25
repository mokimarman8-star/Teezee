package com.transsion.moviedetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.R;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.fragment.ResourceDetectorDialogFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/transsion/moviedetail/fragment/ResourceDetectorEmptyFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/k;", "<init>", "()V", BuildConfig.FLAVOR, "v0", "receiveArguments", BuildConfig.FLAVOR, "isMonitorNetworkState", "()Z", "isAudioShowNoNetworkLayout", "Landroid/view/LayoutInflater;", "inflater", "p0", "(Landroid/view/LayoutInflater;)Llm/k;", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lcom/transsion/moviedetailapi/bean/Subject;", "a", "Lcom/transsion/moviedetailapi/bean/Subject;", "mMovieDetailBean", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "b", "Lkotlin/Lazy;", "o0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", BuildConfig.FLAVOR, "c", "Ljava/lang/Integer;", "count", "d", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResourceDetectorEmptyFragment extends PageStatusFragment<lm.k> {

    /* renamed from: a, reason: from kotlin metadata */
    private Subject mMovieDetailBean;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final androidx.lifecycle.x0 m43invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m44invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    private Integer count;

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

    private final MovieDetailViewModel o0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(ResourceDetectorEmptyFragment resourceDetectorEmptyFragment, View view) {
        List resourceDetectors;
        String str;
        Subject subject = resourceDetectorEmptyFragment.mMovieDetailBean;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || resourceDetectors.isEmpty()) {
            return;
        }
        ResourceDetectors resourceDetectors2 = (ResourceDetectors) resourceDetectors.get(0);
        ResourceDetectorDialogFragment.Companion companion = ResourceDetectorDialogFragment.INSTANCE;
        Subject subject2 = resourceDetectorEmptyFragment.mMovieDetailBean;
        if (subject2 == null || (str = subject2.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        ResourceDetectorDialogFragment a = companion.a(str, resourceDetectors2);
        FragmentManager childFragmentManager = resourceDetectorEmptyFragment.getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        a.show(childFragmentManager, "ResourceDetectorEmptyFragment --> ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(ResourceDetectorEmptyFragment resourceDetectorEmptyFragment, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = resourceDetectorEmptyFragment.mMovieDetailBean;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), resourceDetectorEmptyFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ResourceDetectorEmptyFragment resourceDetectorEmptyFragment, View view) {
        vo.e.a.e(resourceDetectorEmptyFragment, NoticePermissionFrom.DETAIL_NO_RES);
        resourceDetectorEmptyFragment.v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ResourceDetectorEmptyFragment resourceDetectorEmptyFragment, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = resourceDetectorEmptyFragment.mMovieDetailBean;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), resourceDetectorEmptyFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ResourceDetectorEmptyFragment resourceDetectorEmptyFragment, PostEntity postEntity) {
        int i;
        ResourcesRequestView resourcesRequestView;
        if (postEntity == null || !postEntity.getSuccess()) {
            a.a.g(wf.a.a, "Submission fail", false, 2, (Object) null);
        } else {
            a.a.g(wf.a.a, "Post request succeed " + postEntity, false, 2, (Object) null);
            if (resourceDetectorEmptyFragment.count == null) {
                if (postEntity == null || (i = postEntity.getCount()) == null) {
                    i = 0;
                }
                resourceDetectorEmptyFragment.count = i;
                lm.k kVar = (lm.k) resourceDetectorEmptyFragment.getMViewBinding();
                if (kVar != null && (resourcesRequestView = kVar.e) != null) {
                    Integer num = resourceDetectorEmptyFragment.count;
                    resourcesRequestView.setCount(num != null ? num.intValue() : 0, false);
                }
            }
        }
        return Unit.a;
    }

    private final void v0() {
        ResourcesRequestView resourcesRequestView;
        if (!yg.l.a.e()) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.a;
            hVar.f(16, 0, -com.blankj.utilcode.util.a0.a(20.0f));
            hVar.l(getString(R.string.base_network_fail));
            return;
        }
        if (com.transsion.baseui.util.c.a.a(R$id.id_request_request, 500L)) {
            return;
        }
        MovieDetailViewModel o0 = o0();
        Subject subject = this.mMovieDetailBean;
        MovieDetailViewModel.W(o0, subject != null ? subject.getSubjectId() : null, false, 2, null);
        Integer num = this.count;
        if (num != null) {
            Intrinsics.e(num);
            this.count = Integer.valueOf(num.intValue() + 1);
            lm.k kVar = (lm.k) getMViewBinding();
            if (kVar == null || (resourcesRequestView = kVar.e) == null) {
                return;
            }
            Integer num2 = this.count;
            Intrinsics.e(num2);
            ResourcesRequestView.setCount$default(resourcesRequestView, num2.intValue(), false, 2, null);
        }
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        AppCompatImageView appCompatImageView;
        ResourcesRequestView resourcesRequestView;
        AppCompatTextView ivCenterView;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView;
        lm.k kVar = (lm.k) getMViewBinding();
        if (kVar != null && (appCompatTextView = kVar.c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.q0(ResourceDetectorEmptyFragment.this, view);
                }
            });
        }
        lm.k kVar2 = (lm.k) getMViewBinding();
        if (kVar2 != null && (appCompatImageView2 = kVar2.b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.r0(ResourceDetectorEmptyFragment.this, view);
                }
            });
        }
        lm.k kVar3 = (lm.k) getMViewBinding();
        if (kVar3 != null && (resourcesRequestView = kVar3.e) != null && (ivCenterView = resourcesRequestView.getIvCenterView()) != null) {
            ivCenterView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.s0(ResourceDetectorEmptyFragment.this, view);
                }
            });
        }
        lm.k kVar4 = (lm.k) getMViewBinding();
        if (kVar4 == null || (appCompatImageView = kVar4.b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorEmptyFragment.t0(ResourceDetectorEmptyFragment.this, view);
            }
        });
    }

    public void initViewData() {
        ResourcesRequestView resourcesRequestView;
        List resourceDetectors;
        AppCompatTextView appCompatTextView;
        Subject subject = this.mMovieDetailBean;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && !resourceDetectors.isEmpty()) {
            String string = getString(R$string.movie_detail_source, new Object[]{((ResourceDetectors) resourceDetectors.get(0)).getSource()});
            Intrinsics.g(string, "getString(...)");
            lm.k kVar = (lm.k) getMViewBinding();
            if (kVar != null && (appCompatTextView = kVar.c) != null) {
                appCompatTextView.setText(string);
            }
        }
        lm.k kVar2 = (lm.k) getMViewBinding();
        if (kVar2 != null && (resourcesRequestView = kVar2.e) != null) {
            String string2 = getString(R$string.movie_detail_coming_soon);
            Intrinsics.g(string2, "getString(...)");
            resourcesRequestView.set(string2);
        }
        MovieDetailViewModel o0 = o0();
        Subject subject2 = this.mMovieDetailBean;
        o0.V(subject2 != null ? subject2.getSubjectId() : null, true);
    }

    public void initViewModel() {
        o0().H().j(this, new b(new Function1() { // from class: com.transsion.moviedetail.fragment.e0
            public final Object invoke(Object obj) {
                Unit u0;
                u0 = ResourceDetectorEmptyFragment.u0(ResourceDetectorEmptyFragment.this, (PostEntity) obj);
                return u0;
            }
        }));
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return false;
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public lm.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.k c = lm.k.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void receiveArguments() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.mMovieDetailBean = serializable instanceof Subject ? (Subject) serializable : null;
    }

    public void retryLoadData() {
    }
}
