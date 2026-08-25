package com.transsion.moviedetail.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.p001enum.SeenStatus;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010+R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/transsion/moviedetail/view/HeaderExtensionFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llm/w;", "<init>", "()V", BuildConfig.FLAVOR, "x0", "P0", "Lcom/transsion/moviedetailapi/bean/Staff;", "staff", "M0", "(Lcom/transsion/moviedetailapi/bean/Staff;)V", "I0", BuildConfig.FLAVOR, "L0", "()Z", "T0", BuildConfig.FLAVOR, "subjectId", "N0", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "addStatus", "O0", "(Ljava/lang/Integer;)V", "seeStatus", "S0", "Landroid/view/LayoutInflater;", "inflater", "K0", "(Landroid/view/LayoutInflater;)Llm/w;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "receiveArguments", "Lcom/transsion/moviedetailapi/bean/Subject;", "a", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "b", "Ljava/lang/String;", "moduleName", "c", "I", "curSeason", "d", "ops", "e", "pageName", "Lcom/transsion/share/share/ShareDialogFragment;", "f", "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "g", "Lkotlin/Lazy;", "J0", "()Lcom/transsion/moviedetail/viewmodel/MovieDetailViewModel;", "movieDetailViewModel", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HeaderExtensionFragment extends PageStatusFragment<lm.w> {

    /* renamed from: a, reason: from kotlin metadata */
    private Subject subject;

    /* renamed from: b, reason: from kotlin metadata */
    private String moduleName;

    /* renamed from: d, reason: from kotlin metadata */
    private String ops;

    /* renamed from: f, reason: from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: c, reason: from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: e, reason: from kotlin metadata */
    private String pageName = "subjectdetail";

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy movieDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$special$$inlined$activityViewModels$default$1
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final x0 m63invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$special$$inlined$activityViewModels$default$2
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final v0.c m64invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    static final class a implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function1) {
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

    public static final class b implements com.transsion.share.share.a {
        b() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.C0056a.b(this, str);
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
            com.transsion.mbwidget.d.s(com.transsion.mbwidget.d.a, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(HeaderExtensionFragment headerExtensionFragment, BaseDto baseDto) {
        String subjectId;
        String subjectId2;
        Long wantToSeeCount;
        if (baseDto != null && Intrinsics.c(baseDto.getCode(), "0")) {
            Subject subject = headerExtensionFragment.subject;
            long longValue = (subject == null || (wantToSeeCount = subject.getWantToSeeCount()) == null) ? 0L : wantToSeeCount.longValue();
            if (headerExtensionFragment.L0()) {
                Subject subject2 = headerExtensionFragment.subject;
                if (subject2 != null) {
                    subject2.setSeenStatus(Integer.valueOf(SeenStatus.NOT_SEEN.ordinal()));
                }
                headerExtensionFragment.S0(Integer.valueOf(SeenStatus.NOT_SEEN.ordinal()));
                Subject subject3 = headerExtensionFragment.subject;
                if (subject3 != null) {
                    subject3.setWantToSeeCount(Long.valueOf(longValue - 1));
                }
                Subject subject4 = headerExtensionFragment.subject;
                if (subject4 != null && (subjectId2 = subject4.getSubjectId()) != null) {
                    gx.b.a.a().i(0, subjectId2);
                }
            } else {
                com.transsion.mbwidget.d.s(com.transsion.mbwidget.d.a, null, 1, null);
                Subject subject5 = headerExtensionFragment.subject;
                if (subject5 != null) {
                    subject5.setSeenStatus(Integer.valueOf(SeenStatus.WANT_TO_SEE.ordinal()));
                }
                headerExtensionFragment.S0(Integer.valueOf(SeenStatus.WANT_TO_SEE.ordinal()));
                Subject subject6 = headerExtensionFragment.subject;
                if (subject6 != null) {
                    subject6.setWantToSeeCount(Long.valueOf(longValue + 1));
                }
                Subject subject7 = headerExtensionFragment.subject;
                if (subject7 != null && (subjectId = subject7.getSubjectId()) != null) {
                    gx.b.a.a().i(1, subjectId);
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(final HeaderExtensionFragment headerExtensionFragment, View view) {
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.moviedetail.view.m
            public final Object invoke() {
                Unit C0;
                C0 = HeaderExtensionFragment.C0(HeaderExtensionFragment.this);
                return C0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(HeaderExtensionFragment headerExtensionFragment) {
        CourseManager.u(CourseManager.a, headerExtensionFragment.subject, null, 2, null);
        fk.a.b(headerExtensionFragment.subject, headerExtensionFragment.pageName, "opt_detail_addcourse");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(final HeaderExtensionFragment headerExtensionFragment, View view) {
        com.transsion.baseui.util.d.b(0L, new Function0() { // from class: com.transsion.moviedetail.view.l
            public final Object invoke() {
                Unit E0;
                E0 = HeaderExtensionFragment.E0(HeaderExtensionFragment.this);
                return E0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(HeaderExtensionFragment headerExtensionFragment) {
        headerExtensionFragment.T0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(HeaderExtensionFragment headerExtensionFragment, View view) {
        ResourceDetectors resourceDetector;
        List resolutionList;
        Subject subject;
        ResourceDetectors resourceDetector2;
        ResourceDetectors resourceDetector3;
        List resolutionList2;
        Subject subject2 = headerExtensionFragment.subject;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject3 = headerExtensionFragment.subject;
            Integer valueOf = (subject3 == null || (resourceDetector3 = subject3.getResourceDetector()) == null || (resolutionList2 = resourceDetector3.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.e(valueOf);
            if (valueOf.intValue() > 1 && (subject = headerExtensionFragment.subject) != null && (resourceDetector2 = subject.getResourceDetector()) != null) {
                resourceDetector2.setType(1);
            }
        }
        headerExtensionFragment.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(HeaderExtensionFragment headerExtensionFragment, View view) {
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
        String str = headerExtensionFragment.pageName;
        Subject subject = headerExtensionFragment.subject;
        aVar.h(str, "view_download", BuildConfig.FLAVOR, subject != null ? subject.getSubjectId() : null, null, headerExtensionFragment.ops);
        Navigator.x(TheRouter.c("/download/panel_activity").F("extra_page_index", 0), headerExtensionFragment.requireContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(HeaderExtensionFragment headerExtensionFragment, Integer num) {
        Intrinsics.e(num);
        headerExtensionFragment.curSeason = num.intValue();
        return Unit.a;
    }

    private final void I0() {
        String str;
        boolean z;
        List resourceDetectors;
        String str2;
        if (getContext() == null) {
            return;
        }
        Subject subject = this.subject;
        String str3 = BuildConfig.FLAVOR;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null) {
            str = BuildConfig.FLAVOR;
            z = false;
        } else {
            if (resourceDetectors.isEmpty()) {
                str2 = BuildConfig.FLAVOR;
            } else {
                str2 = ((ResourceDetectors) resourceDetectors.get(0)).getResourceLink();
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                String resourceId = ((ResourceDetectors) resourceDetectors.get(0)).getResourceId();
                if (resourceId != null) {
                    str3 = resourceId;
                }
                if (((ResourceDetectors) resourceDetectors.get(0)).isMultiResolution()) {
                    z = true;
                    str = str2;
                }
            }
            z = false;
            str = str2;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.j;
        DownloadManagerApi a2 = aVar.a();
        Subject subject2 = this.subject;
        String subjectId = subject2 != null ? subject2.getSubjectId() : null;
        Subject subject3 = this.subject;
        a2.w0(subjectId, str3, subject3 != null && subject3.isSeries(), z);
        Subject subject4 = this.subject;
        if (subject4 != null) {
            Integer subjectType = subject4.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi a3 = aVar.a();
                FragmentActivity context = getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = context;
                String str4 = this.pageName;
                Subject subject5 = this.subject;
                DownloadManagerApi.e0(a3, fragmentActivity, str4, BuildConfig.FLAVOR, subject5 != null ? subject5.getOps() : null, "download_subject", true, this.subject, (String) null, (Boolean) null, 384, (Object) null);
                return;
            }
        }
        DownloadManagerApi a4 = aVar.a();
        FragmentActivity context2 = getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.N(a4, context2, this.subject, this.pageName, BuildConfig.FLAVOR, BuildConfig.FLAVOR, str, (String) null, this.moduleName, (String) null, false, this.curSeason, false, 832, (Object) null);
    }

    private final MovieDetailViewModel J0() {
        return (MovieDetailViewModel) this.movieDetailViewModel.getValue();
    }

    private final boolean L0() {
        Subject subject = this.subject;
        if (subject == null) {
            return false;
        }
        Integer seenStatus = subject.getSeenStatus();
        return seenStatus != null && seenStatus.intValue() == SeenStatus.WANT_TO_SEE.ordinal();
    }

    private final void M0(Staff staff) {
        Navigator.x(TheRouter.c("/movie/staff").J("staff", staff), requireContext(), (mf.c) null, 2, (Object) null);
    }

    private final void N0(String subjectId) {
        ShareDialogFragment shareDialogFragment;
        ShareDialogFragment a2;
        Subject subject = this.subject;
        if (subject == null) {
            return;
        }
        com.transsion.baselib.helper.a.a.h(this.pageName, "share", (r16 & 4) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r16 & 8) != 0 ? BuildConfig.FLAVOR : subject != null ? subject.getSubjectId() : null, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : this.ops);
        if (this.mShareDialog == null) {
            ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
            PostType postType = PostType.SUBJECT_TYPE;
            String value = ReportType.SUBJECT.getValue();
            Subject subject2 = this.subject;
            String title = subject2 != null ? subject2.getTitle() : null;
            Subject subject3 = this.subject;
            a2 = companion.a(postType, subjectId, BuildConfig.FLAVOR, value, (r29 & 16) != 0 ? BuildConfig.FLAVOR : title, (r29 & 32) != 0 ? BuildConfig.FLAVOR : String.valueOf(subject3 != null ? subject3.getImdbRate() : null), (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, this.pageName, (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
            this.mShareDialog = a2;
            if (a2 != null) {
                a2.G0(new b());
            }
        }
        try {
            if (isAdded()) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                childFragmentManager.g0();
                ShareDialogFragment shareDialogFragment2 = this.mShareDialog;
                if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.mShareDialog) != null) {
                    shareDialogFragment.show(childFragmentManager, "share");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(Integer addStatus) {
        AppCompatTextView appCompatTextView;
        lm.w wVar = (lm.w) getMViewBinding();
        if (wVar == null || (appCompatTextView = wVar.c) == null) {
            return;
        }
        appCompatTextView.setSelected(addStatus != null && SeenStatus.WANT_TO_SEE.ordinal() == addStatus.intValue());
    }

    private final void P0() {
        List staffList;
        ConstraintLayout constraintLayout;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ShapeableImageView shapeableImageView;
        ImageView imageView;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        Subject subject = this.subject;
        if (subject == null || (staffList = subject.getStaffList()) == null) {
            return;
        }
        if (staffList.isEmpty()) {
            lm.w wVar = (lm.w) getMViewBinding();
            if (wVar == null || (constraintLayout = wVar.g) == null) {
                return;
            }
            uf.c.g(constraintLayout);
            return;
        }
        final Staff staff = (Staff) staffList.get(0);
        if (TextUtils.isEmpty(staff.getAvatarUrl())) {
            lm.w wVar2 = (lm.w) getMViewBinding();
            if (wVar2 == null || (constraintLayout3 = wVar2.g) == null) {
                return;
            }
            uf.c.g(constraintLayout3);
            return;
        }
        lm.w wVar3 = (lm.w) getMViewBinding();
        if (wVar3 != null && (constraintLayout2 = wVar3.g) != null) {
            uf.c.k(constraintLayout2);
        }
        lm.w wVar4 = (lm.w) getMViewBinding();
        if (wVar4 != null && (imageView = wVar4.b) != null) {
            f.a aVar = ni.f.a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            f.b m = aVar.m(requireActivity);
            String avatarUrl = staff.getAvatarUrl();
            if (avatarUrl == null) {
                avatarUrl = BuildConfig.FLAVOR;
            }
            m.g(avatarUrl).d(imageView);
        }
        lm.w wVar5 = (lm.w) getMViewBinding();
        if (wVar5 != null && (shapeableImageView = wVar5.b) != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.Q0(HeaderExtensionFragment.this, staff, view);
                }
            });
        }
        lm.w wVar6 = (lm.w) getMViewBinding();
        if (wVar6 != null && (appCompatTextView2 = wVar6.d) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.R0(HeaderExtensionFragment.this, staff, view);
                }
            });
        }
        lm.w wVar7 = (lm.w) getMViewBinding();
        if (wVar7 == null || (appCompatTextView = wVar7.d) == null) {
            return;
        }
        appCompatTextView.setText(staff.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(HeaderExtensionFragment headerExtensionFragment, Staff staff, View view) {
        headerExtensionFragment.M0(staff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(HeaderExtensionFragment headerExtensionFragment, Staff staff, View view) {
        headerExtensionFragment.M0(staff);
    }

    private final void S0(Integer seeStatus) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        int ordinal = SeenStatus.WANT_TO_SEE.ordinal();
        if (seeStatus != null && seeStatus.intValue() == ordinal) {
            lm.w wVar = (lm.w) getMViewBinding();
            if (wVar != null && (appCompatTextView4 = wVar.h) != null) {
                appCompatTextView4.setSelected(true);
            }
            lm.w wVar2 = (lm.w) getMViewBinding();
            if (wVar2 == null || (appCompatTextView3 = wVar2.h) == null) {
                return;
            }
            Context context = getContext();
            appCompatTextView3.setText(context != null ? context.getString(R$string.movie_detail_added) : null);
            return;
        }
        lm.w wVar3 = (lm.w) getMViewBinding();
        if (wVar3 != null && (appCompatTextView2 = wVar3.h) != null) {
            appCompatTextView2.setSelected(false);
        }
        lm.w wVar4 = (lm.w) getMViewBinding();
        if (wVar4 == null || (appCompatTextView = wVar4.h) == null) {
            return;
        }
        Context context2 = getContext();
        appCompatTextView.setText(context2 != null ? context2.getString(R$string.movie_detail_add_to_list) : null);
    }

    private final void T0() {
        String subjectId;
        Subject subject = this.subject;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        if (L0()) {
            J0().d0(subjectId, 0);
            fh.b.a.d(R$string.movie_detail_favorite_cancel_toast);
            com.transsion.baselib.helper.a.a.h(this.pageName, "want_to_see_cancel ", (r16 & 4) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r16 & 8) != 0 ? BuildConfig.FLAVOR : subjectId, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : this.ops);
        } else {
            J0().d0(subjectId, 1);
            fh.b.a.d(R$string.movie_detail_favorite_open_toast);
            com.transsion.baselib.helper.a.a.h(this.pageName, "want_to_see", (r16 & 4) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r16 & 8) != 0 ? BuildConfig.FLAVOR : subjectId, (r16 & 16) != 0 ? BuildConfig.FLAVOR : null, (r16 & 32) != 0 ? null : this.ops);
            vo.e.a.e(this, NoticePermissionFrom.WANT_TO_SEE);
        }
    }

    private final void x0() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        AppCompatTextView appCompatTextView9;
        AppCompatTextView appCompatTextView10;
        lm.w wVar = (lm.w) getMViewBinding();
        if (wVar != null && (appCompatTextView10 = wVar.i) != null) {
            appCompatTextView10.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.y0(HeaderExtensionFragment.this, view);
                }
            });
        }
        Subject subject = this.subject;
        if (subject == null || !subject.isEduType()) {
            Subject subject2 = this.subject;
            if (subject2 == null || !subject2.isMusicType()) {
                lm.w wVar2 = (lm.w) getMViewBinding();
                if (wVar2 != null && (appCompatTextView = wVar2.h) != null) {
                    appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HeaderExtensionFragment.D0(HeaderExtensionFragment.this, view);
                        }
                    });
                }
                Subject subject3 = this.subject;
                S0(subject3 != null ? subject3.getSeenStatus() : null);
            } else {
                lm.w wVar3 = (lm.w) getMViewBinding();
                if (wVar3 != null && (appCompatTextView3 = wVar3.c) != null) {
                    uf.c.g(appCompatTextView3);
                }
                lm.w wVar4 = (lm.w) getMViewBinding();
                if (wVar4 != null && (appCompatTextView2 = wVar4.h) != null) {
                    uf.c.g(appCompatTextView2);
                }
                P0();
            }
        } else {
            lm.w wVar5 = (lm.w) getMViewBinding();
            if (wVar5 != null && (appCompatTextView9 = wVar5.c) != null) {
                appCompatTextView9.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HeaderExtensionFragment.B0(HeaderExtensionFragment.this, view);
                    }
                });
            }
            fk.a.a(this.subject, this.pageName, "opt_detail_addcourse");
            lm.w wVar6 = (lm.w) getMViewBinding();
            if (wVar6 != null && (appCompatTextView8 = wVar6.c) != null) {
                uf.c.k(appCompatTextView8);
            }
            lm.w wVar7 = (lm.w) getMViewBinding();
            if (wVar7 != null && (appCompatTextView7 = wVar7.h) != null) {
                uf.c.g(appCompatTextView7);
            }
            Subject subject4 = this.subject;
            O0(subject4 != null ? subject4.getSeenStatus() : null);
        }
        lm.w wVar8 = (lm.w) getMViewBinding();
        if (wVar8 != null && (appCompatTextView6 = wVar8.e) != null) {
            Subject subject5 = this.subject;
            appCompatTextView6.setVisibility(subject5 != null ? Intrinsics.c(subject5.getHasResource(), Boolean.TRUE) : false ? 0 : 8);
        }
        lm.w wVar9 = (lm.w) getMViewBinding();
        if (wVar9 != null && (appCompatTextView5 = wVar9.e) != null) {
            appCompatTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.F0(HeaderExtensionFragment.this, view);
                }
            });
        }
        lm.w wVar10 = (lm.w) getMViewBinding();
        if (wVar10 != null && (appCompatTextView4 = wVar10.f) != null) {
            appCompatTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.G0(HeaderExtensionFragment.this, view);
                }
            });
        }
        J0().K().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.view.i
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = HeaderExtensionFragment.H0(HeaderExtensionFragment.this, (Integer) obj);
                return H0;
            }
        }));
        J0().F().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.view.j
            public final Object invoke(Object obj) {
                Unit z0;
                z0 = HeaderExtensionFragment.z0(HeaderExtensionFragment.this, (Pair) obj);
                return z0;
            }
        }));
        J0().Q().j(this, new a(new Function1() { // from class: com.transsion.moviedetail.view.k
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = HeaderExtensionFragment.A0(HeaderExtensionFragment.this, (BaseDto) obj);
                return A0;
            }
        }));
        Subject subject6 = this.subject;
        if (subject6 == null || !subject6.isEduType()) {
            return;
        }
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(this), (CoroutineContext) null, (CoroutineStart) null, new HeaderExtensionFragment$addListeners$9(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(HeaderExtensionFragment headerExtensionFragment, View view) {
        String subjectId;
        a.a.g(wf.a.a, "HeaderExtensionFragment click -- share", false, 2, (Object) null);
        Subject subject = headerExtensionFragment.subject;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        headerExtensionFragment.N0(subjectId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(HeaderExtensionFragment headerExtensionFragment, Pair pair) {
        HashMap g;
        HashMap g2;
        Subject subject = (Subject) pair.getSecond();
        wf.a.a.c("zxb_fragment", "get movie detail data==" + pair, true);
        if (subject != null) {
            headerExtensionFragment.subject = subject;
            qi.b logViewConfig = headerExtensionFragment.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            qi.b logViewConfig2 = headerExtensionFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.n(headerExtensionFragment.ops);
            }
            qi.b logViewConfig3 = headerExtensionFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g2 = logViewConfig3.g()) != null) {
                String subjectId = subject.getSubjectId();
                if (subjectId == null) {
                    subjectId = BuildConfig.FLAVOR;
                }
                g2.put("subject_id", subjectId);
            }
            qi.b logViewConfig4 = headerExtensionFragment.getLogViewConfig();
            if (logViewConfig4 != null && (g = logViewConfig4.g()) != null) {
                g.put("has_resource", String.valueOf(subject.getHasResource()));
            }
        }
        return Unit.a;
    }

    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public lm.w getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.w c = lm.w.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        x0();
    }

    public void initViewData() {
        Subject subject = this.subject;
        S0(subject != null ? subject.getSeenStatus() : null);
        Subject subject2 = this.subject;
        O0(subject2 != null ? subject2.getSeenStatus() : null);
    }

    public void initViewModel() {
    }

    public void receiveArguments() {
        String str;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.subject = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.moduleName = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.curSeason = arguments3 != null ? arguments3.getInt("season") : 1;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("page_from")) == null) {
            str = "subjectdetail";
        }
        this.pageName = str;
        Bundle arguments5 = getArguments();
        this.ops = arguments5 != null ? arguments5.getString("ops") : null;
        if (this.curSeason <= 0) {
            this.curSeason = 1;
        }
    }

    public void retryLoadData() {
    }
}
