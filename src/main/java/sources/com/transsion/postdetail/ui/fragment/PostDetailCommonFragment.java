package com.transsion.postdetail.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.bean.UserInfo;
import fh.b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 l2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001b\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u0010\u0004J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000fH&¢\u0006\u0004\b8\u0010.J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010:\u001a\u00020\u0005H&¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\u0005H&¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0005H&¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010?\u001a\u00020\u0005H\u0016¢\u0006\u0004\b?\u0010\u0004R\u0018\u0010B\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010G\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010A\u001a\u0004\bD\u0010.\"\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010P\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010 R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001d\u0010g\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010W\u001a\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostDetailCommonFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lwn/m;", "<init>", "()V", BuildConfig.FLAVOR, "C0", "L0", "Z0", "loadData", "updatePostDetail", BuildConfig.FLAVOR, "hasResource", "a1", "(Ljava/lang/Boolean;)V", BuildConfig.FLAVOR, "title", "content", "link", "V0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "subjectRate", "Y0", "(Ljava/lang/Integer;)V", "Lcom/transsion/moviedetailapi/bean/Media;", "media", "T0", "(Lcom/transsion/moviedetailapi/bean/Media;)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "setPTParams", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "initPlayer", "observeLike", "O0", "clickLike", "showCommentsDialog", "doShare", "clickDownload", "receiveArguments", "Landroid/view/LayoutInflater;", "inflater", "E0", "(Landroid/view/LayoutInflater;)Lwn/m;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewData", "initViewModel", "initListener", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "getPageName", "retryLoadData", "G0", "initAudioListener", "F0", "onResume", "onPause", "onDestroy", "a", "Ljava/lang/String;", "tranOps", "b", "getPostId", "setPostId", "(Ljava/lang/String;)V", "postId", "c", "Z", "fromComment", "d", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "getMPostDetailBean", "()Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "setMPostDetailBean", "mPostDetailBean", "Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "e", "Lcom/transsion/postdetail/ui/fragment/PostRecommendFragment;", "mPostRecommendFragment", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "f", "Lkotlin/Lazy;", "getViewModel", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "viewModel", "Lcom/transsnet/downloader/widget/DownloadView;", "g", "Lcom/transsnet/downloader/widget/DownloadView;", "getDownloadViewFloat", "()Lcom/transsnet/downloader/widget/DownloadView;", "setDownloadViewFloat", "(Lcom/transsnet/downloader/widget/DownloadView;)V", "downloadViewFloat", "Lqx/a;", "h", "getMLoginApi", "()Lqx/a;", "mLoginApi", "Lcom/transsion/ninegridview/a;", "i", "Lcom/transsion/ninegridview/a;", "mGifPlayerManager", "j", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class PostDetailCommonFragment extends PageStatusFragment<wn.m> {

    /* renamed from: a, reason: from kotlin metadata */
    private String tranOps;

    /* renamed from: b, reason: from kotlin metadata */
    private String postId;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean fromComment;

    /* renamed from: d, reason: from kotlin metadata */
    private PostSubjectItem mPostDetailBean;

    /* renamed from: e, reason: from kotlin metadata */
    private PostRecommendFragment mPostRecommendFragment;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: g, reason: from kotlin metadata */
    private DownloadView downloadViewFloat;

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: i, reason: from kotlin metadata */
    private com.transsion.ninegridview.a mGifPlayerManager;

    public static final class b implements com.transsion.share.share.a {
        b() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
            PostDetailCommonFragment.this.getViewModel().r(str);
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            new Intent().putExtra("id", str);
            Activity b = com.blankj.utilcode.util.a.b();
            if (b != null) {
                b.finish();
            }
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
        }
    }

    static final class c implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    public static final class d implements CommentFragment.b {
        d() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j) {
            Stat stat;
            Stat stat2;
            Long commentCount;
            PostSubjectItem mPostDetailBean = PostDetailCommonFragment.this.getMPostDetailBean();
            if (mPostDetailBean == null || (stat2 = mPostDetailBean.getStat()) == null || (commentCount = stat2.getCommentCount()) == null || commentCount.longValue() != j) {
                PostSubjectItem mPostDetailBean2 = PostDetailCommonFragment.this.getMPostDetailBean();
                if (mPostDetailBean2 != null && (stat = mPostDetailBean2.getStat()) != null) {
                    stat.setCommentCount(Long.valueOf(j));
                }
                PostDetailCommonFragment.this.O0();
            }
        }
    }

    public PostDetailCommonFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m107invoke() {
                return this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.x0 m108invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m109invoke() {
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
        this.mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.g2
            public final Object invoke() {
                qx.a mLoginApi_delegate$lambda$0;
                mLoginApi_delegate$lambda$0 = PostDetailCommonFragment.mLoginApi_delegate$lambda$0();
                return mLoginApi_delegate$lambda$0;
            }
        });
    }

    private final void C0() {
        Subject subject;
        ConstraintLayout root;
        Context context = getContext();
        Boolean bool = null;
        DownloadView downloadView = context != null ? new DownloadView(context) : null;
        this.downloadViewFloat = downloadView;
        if (downloadView != null) {
            downloadView.setPageFrom(getPageName());
        }
        DownloadView downloadView2 = this.downloadViewFloat;
        if (downloadView2 != null) {
            DownloadView.setAttrs$default(downloadView2, (Integer) null, Float.valueOf(com.blankj.utilcode.util.a0.d(16.0f)), (Integer) null, 5, (Object) null);
        }
        DownloadView downloadView3 = this.downloadViewFloat;
        if (downloadView3 != null) {
            Context context2 = getContext();
            downloadView3.setBackground(context2 != null ? androidx.core.content.b.getDrawable(context2, R.drawable.bg_btn_radius_20) : null);
        }
        ConstraintLayout.b bVar = new ConstraintLayout.b(com.blankj.utilcode.util.a0.a(140.0f), com.blankj.utilcode.util.a0.a(40.0f));
        int i = R$id.cl_container;
        bVar.l = i;
        bVar.t = i;
        bVar.v = i;
        bVar.setMargins(0, 0, 0, com.blankj.utilcode.util.a0.a(48.0f));
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (root = mVar.getRoot()) != null) {
            root.addView(this.downloadViewFloat, -1, bVar);
        }
        DownloadView downloadView4 = this.downloadViewFloat;
        if (downloadView4 != null) {
            downloadView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.h2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommonFragment.D0(PostDetailCommonFragment.this, view);
                }
            });
        }
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            bool = subject.getHasResource();
        }
        a1(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        String str;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        String subjectId;
        Subject subject3;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        Subject subject5;
        DownloadManagerApi.a aVar = DownloadManagerApi.j;
        DownloadManagerApi a = aVar.a();
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        String str2 = null;
        String subjectId2 = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null) ? null : subject5.getSubjectId();
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        String resourceId = (postSubjectItem2 == null || (subject4 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject4.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
        if (DownloadManagerApi.x0(a, subjectId2, resourceId, (postSubjectItem3 == null || (subject3 = postSubjectItem3.getSubject()) == null) ? false : subject3.isSeries(), false, 8, (Object) null)) {
            PostSubjectItem postSubjectItem4 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
                return;
            }
            DownloadManagerApi a2 = aVar.a();
            Context context = postDetailCommonFragment.getContext();
            Intrinsics.e(context);
            DownloadManagerApi.z0(a2, subjectId, context, postDetailCommonFragment.getPageName(), (String) null, 8, (Object) null);
            return;
        }
        DownloadManagerApi a3 = aVar.a();
        FragmentActivity context2 = postDetailCommonFragment.getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = context2;
        PostSubjectItem postSubjectItem5 = postDetailCommonFragment.mPostDetailBean;
        Subject subject6 = postSubjectItem5 != null ? postSubjectItem5.getSubject() : null;
        String pageName = postDetailCommonFragment.getPageName();
        PostSubjectItem postSubjectItem6 = postDetailCommonFragment.mPostDetailBean;
        String groupId = (postSubjectItem6 == null || (group = postSubjectItem6.getGroup()) == null) ? null : group.getGroupId();
        PostSubjectItem postSubjectItem7 = postDetailCommonFragment.mPostDetailBean;
        String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
        PostSubjectItem postSubjectItem8 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem8 == null || (subject = postSubjectItem8.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
            str = BuildConfig.FLAVOR;
        }
        String str3 = str;
        PostSubjectItem postSubjectItem9 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem9 != null && (user = postSubjectItem9.getUser()) != null) {
            str2 = user.getNickname();
        }
        DownloadManagerApi.M(a3, fragmentActivity, subject6, pageName, groupId, ops, str3, (String) null, (String) null, str2, false, 704, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        FragmentActivity activity = postDetailCommonFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(PostDetailCommonFragment postDetailCommonFragment, View view) {
        User user;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        Navigator c2 = TheRouter.c("/profile/user_profile");
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        Navigator.x(c2.K("userId", (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId()), postDetailCommonFragment.requireContext(), (mf.c) null, 2, (Object) null);
        com.transsion.postdetail.helper.a.d(com.transsion.postdetail.helper.a.a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(PostDetailCommonFragment postDetailCommonFragment, PostSubjectItem postSubjectItem) {
        if (postSubjectItem == null) {
            PageStatusFragment.showEmptyView$default(postDetailCommonFragment, false, 1, (Object) null);
            return Unit.a;
        }
        postDetailCommonFragment.showContentView();
        postDetailCommonFragment.mPostDetailBean = postSubjectItem;
        postSubjectItem.setTran_ops(postDetailCommonFragment.tranOps);
        postDetailCommonFragment.updatePostDetail();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(PostDetailCommonFragment postDetailCommonFragment, String str) {
        if (TextUtils.equals("0", str)) {
            String str2 = postDetailCommonFragment.postId;
            if (str2 != null) {
                gx.b.a.a().e(str2);
            }
            FragmentActivity activity = postDetailCommonFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            b.a aVar = fh.b.a;
            FragmentActivity activity2 = postDetailCommonFragment.getActivity();
            aVar.e(activity2 != null ? activity2.getString(com.transsion.postdetail.R.string.delete_post_failed) : null);
        }
        return Unit.a;
    }

    private final void L0() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.w1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = PostDetailCommonFragment.M0(PostDetailCommonFragment.this, (AddToDownloadEvent) obj);
                return M0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(PostDetailCommonFragment postDetailCommonFragment, AddToDownloadEvent addToDownloadEvent) {
        String subjectId;
        PostSubjectItem postSubjectItem;
        Subject subject;
        Subject subject2;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            subjectId = addToDownloadEvent.getSubjectId();
            postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!TextUtils.equals(subjectId, (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId())) {
            return Unit.a;
        }
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        postDetailCommonFragment.a1((postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) ? null : subject.getHasResource());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(PostDetailCommonFragment postDetailCommonFragment, LikeEvent likeEvent) {
        PostSubjectItem postSubjectItem;
        Long l;
        Stat stat;
        Stat stat2;
        Long likeCount;
        Stat stat3;
        Stat stat4;
        Long likeCount2;
        Intrinsics.h(likeEvent, "value");
        try {
            Result.Companion companion = Result.Companion;
            postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            l = null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        if (!TextUtils.equals(postSubjectItem != null ? postSubjectItem.getPostId() : null, likeEvent.getSubjectId())) {
            return Unit.a;
        }
        PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
        if (postSubjectItem2 != null) {
            postSubjectItem2.setHasLike(Boolean.valueOf(likeEvent.getLike()));
        }
        if (likeEvent.getLike()) {
            PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem3 != null && (stat3 = postSubjectItem3.getStat()) != null) {
                PostSubjectItem postSubjectItem4 = postDetailCommonFragment.mPostDetailBean;
                if (postSubjectItem4 != null && (stat4 = postSubjectItem4.getStat()) != null && (likeCount2 = stat4.getLikeCount()) != null) {
                    l = Long.valueOf(likeCount2.longValue() + 1);
                }
                stat3.setLikeCount(l);
            }
        } else {
            PostSubjectItem postSubjectItem5 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem5 != null && (stat = postSubjectItem5.getStat()) != null) {
                PostSubjectItem postSubjectItem6 = postDetailCommonFragment.mPostDetailBean;
                if (postSubjectItem6 != null && (stat2 = postSubjectItem6.getStat()) != null && (likeCount = stat2.getLikeCount()) != null) {
                    l = Long.valueOf(likeCount.longValue() - 1);
                }
                stat.setLikeCount(l);
            }
        }
        postDetailCommonFragment.O0();
        Result.constructor-impl(Unit.a);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        PostDetailOperationView postDetailOperationView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (postDetailOperationView = mVar.s) == null) {
            return;
        }
        postDetailOperationView.showData(this.mPostDetailBean, new Function0() { // from class: com.transsion.postdetail.ui.fragment.z1
            public final Object invoke() {
                Unit P0;
                P0 = PostDetailCommonFragment.P0(PostDetailCommonFragment.this);
                return P0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.a2
            public final Object invoke() {
                Unit Q0;
                Q0 = PostDetailCommonFragment.Q0(PostDetailCommonFragment.this);
                return Q0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.b2
            public final Object invoke() {
                Unit R0;
                R0 = PostDetailCommonFragment.R0(PostDetailCommonFragment.this);
                return R0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ui.fragment.c2
            public final Object invoke() {
                Unit S0;
                S0 = PostDetailCommonFragment.S0(PostDetailCommonFragment.this);
                return S0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.clickLike();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.showCommentsDialog();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.doShare();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.clickDownload();
        return Unit.a;
    }

    private final void T0(Media media) {
        NineGridVideoView nineGridVideoView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (nineGridVideoView = mVar.r) == null) {
            return;
        }
        if ((media != null ? media.getImage() : null) == null) {
            uf.c.g(nineGridVideoView);
        } else {
            List image = media.getImage();
            if (image != null) {
                nineGridVideoView.setAdapter(new NineGridVideoViewAdapter(image));
                nineGridVideoView.loadImage();
            }
            uf.c.k(nineGridVideoView);
        }
        if (wm.b.a(media)) {
            nineGridVideoView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.m2
                @Override // java.lang.Runnable
                public final void run() {
                    PostDetailCommonFragment.U0(PostDetailCommonFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(PostDetailCommonFragment postDetailCommonFragment) {
        postDetailCommonFragment.initPlayer();
    }

    private final void V0(String title, final String content, final String link) {
        final wn.h0 h0Var;
        wn.j0 j0Var;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (j0Var = mVar.y) != null) {
            if (TextUtils.isEmpty(title)) {
                AppCompatTextView appCompatTextView = j0Var.b;
                Intrinsics.g(appCompatTextView, "tvPostTitle");
                uf.c.g(appCompatTextView);
            } else {
                AppCompatTextView appCompatTextView2 = j0Var.b;
                Intrinsics.g(appCompatTextView2, "tvPostTitle");
                uf.c.k(appCompatTextView2);
                j0Var.b.setText(title);
            }
        }
        wn.m mVar2 = (wn.m) getMViewBinding();
        if (mVar2 == null || (h0Var = mVar2.w) == null) {
            return;
        }
        h0Var.b.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.x1
            @Override // java.lang.Runnable
            public final void run() {
                PostDetailCommonFragment.W0(content, h0Var, link, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(String str, wn.h0 h0Var, String str2, final PostDetailCommonFragment postDetailCommonFragment) {
        Subject subject;
        String subjectId;
        if (TextUtils.isEmpty(str)) {
            ExpandView expandView = h0Var.b;
            Intrinsics.g(expandView, "tvPostDesc");
            uf.c.g(expandView);
            return;
        }
        ExpandView expandView2 = h0Var.b;
        Intrinsics.e(expandView2);
        uf.c.k(expandView2);
        if (!TextUtils.isEmpty(str2)) {
            str = str + "\n" + (str2 != null ? StringsKt.Q(str2, " ", "%20", false, 4, (Object) null) : null);
        }
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        final boolean z = false;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null && subjectId.length() > 0) {
            z = true;
        }
        com.transsion.baseui.util.l.f(expandView2, str, !z, new Function2() { // from class: com.transsion.postdetail.ui.fragment.d2
            public final Object invoke(Object obj, Object obj2) {
                Unit X0;
                X0 = PostDetailCommonFragment.X0(z, postDetailCommonFragment, (View) obj, (String) obj2);
                return X0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(boolean z, PostDetailCommonFragment postDetailCommonFragment, View view, String str) {
        String str2;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        if (z) {
            DownloadManagerApi a = DownloadManagerApi.j.a();
            FragmentActivity requireActivity = postDetailCommonFragment.requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            Subject subject2 = postSubjectItem != null ? postSubjectItem.getSubject() : null;
            Intrinsics.e(str);
            String str3 = postDetailCommonFragment.tranOps;
            PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str2 = resourceDetector.getResourceLink()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            String str4 = str2;
            PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
            a.U(requireActivity, subject2, str, "postdetail", str3, str4, (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getNickname());
        }
        return Unit.a;
    }

    private final void Y0(Integer subjectRate) {
        wn.i0 i0Var;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (i0Var = mVar.i) == null) {
            return;
        }
        if ((subjectRate != null ? subjectRate.intValue() : 0) <= 0) {
            ConstraintLayout constraintLayout = i0Var.b;
            Intrinsics.g(constraintLayout, "clRating");
            uf.c.g(constraintLayout);
            return;
        }
        ConstraintLayout constraintLayout2 = i0Var.b;
        Intrinsics.g(constraintLayout2, "clRating");
        uf.c.k(constraintLayout2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getString(com.transsion.postdetail.R.string.score);
        Intrinsics.g(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{subjectRate}, 1));
        Intrinsics.g(format, "format(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        int length = String.valueOf(subjectRate).length();
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.getColor(requireActivity(), com.tn.lib.widget.R.color.color_ffaa33)), 0, length, 17);
        i0Var.d.setText(spannableStringBuilder);
    }

    private final void Z0() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.w p = childFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        PostRecommendFragment a = PostRecommendFragment.INSTANCE.a(this.postId);
        p.s(R$id.flContainer, a);
        this.mPostRecommendFragment = a;
        p.j();
    }

    private final void a1(Boolean hasResource) {
        HashMap g;
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        if (Intrinsics.c(hasResource, Boolean.TRUE)) {
            DownloadView downloadView = this.downloadViewFloat;
            if (downloadView != null) {
                downloadView.setVisibility(0);
            }
        } else {
            DownloadView downloadView2 = this.downloadViewFloat;
            if (downloadView2 != null) {
                downloadView2.setVisibility(8);
            }
        }
        DownloadView downloadView3 = this.downloadViewFloat;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem = this.mPostDetailBean;
            String subjectId = (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
            String resourceId = (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, (postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) ? null : Boolean.valueOf(subject.isSeries()), false, 0, 24, (Object) null);
        }
        DownloadView downloadView4 = this.downloadViewFloat;
        String str = (downloadView4 == null || downloadView4.getShowType() != 1) ? "download_subject" : "play_subject";
        qi.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g = logViewConfig.g()) == null) {
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(PostDetailCommonFragment postDetailCommonFragment, View view) {
        Group group;
        Navigator c2 = TheRouter.c("/room/detail");
        PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
        Navigator.x(c2.K("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()), postDetailCommonFragment.requireContext(), (mf.c) null, 2, (Object) null);
        com.transsion.postdetail.helper.a.m(com.transsion.postdetail.helper.a.a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(PostDetailCommonFragment postDetailCommonFragment) {
        Subject subject;
        String subjectId;
        Subject subject2;
        Integer subjectType;
        String c2 = sg.b.b.a().c();
        com.transsion.moviedetailapi.g gVar = (com.transsion.moviedetailapi.g) TheRouter.d(com.transsion.moviedetailapi.g.class, new Object[0]);
        if (TextUtils.equals(c2, gVar != null ? gVar.d() : null)) {
            postDetailCommonFragment.requireActivity().finish();
        } else {
            PostSubjectItem postSubjectItem = postDetailCommonFragment.mPostDetailBean;
            if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null) {
                Navigator c3 = TheRouter.c("/movie/detail");
                PostSubjectItem postSubjectItem2 = postDetailCommonFragment.mPostDetailBean;
                Navigator K = c3.F("subject_type", (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (subjectType = subject2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).K("id", subjectId);
                PostSubjectItem postSubjectItem3 = postDetailCommonFragment.mPostDetailBean;
                Navigator.x(K.K("ops", postSubjectItem3 != null ? postSubjectItem3.getOps() : null), postDetailCommonFragment.requireContext(), (mf.c) null, 2, (Object) null);
            }
            com.transsion.postdetail.helper.a.C(com.transsion.postdetail.helper.a.a, postDetailCommonFragment.mPostDetailBean, null, null, 6, null);
        }
        return Unit.a;
    }

    private final void clickDownload() {
        String url;
        String str;
        Subject subject;
        ResourceDetectors resourceDetector;
        String resourceLink;
        Subject subject2;
        Subject subject3;
        Integer size;
        String url2;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        PostSubjectItem postSubjectItem;
        Media media;
        Cover cover;
        Media media2;
        List audio;
        PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
        Audio audio2 = (postSubjectItem2 == null || (media2 = postSubjectItem2.getMedia()) == null || (audio = media2.getAudio()) == null) ? null : (Audio) audio.get(0);
        PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
        String title = postSubjectItem3 != null ? postSubjectItem3.getTitle() : null;
        if (TextUtils.isEmpty(title)) {
            PostSubjectItem postSubjectItem4 = this.mPostDetailBean;
            title = postSubjectItem4 != null ? postSubjectItem4.getContent() : null;
        }
        String str2 = title;
        PostSubjectItem postSubjectItem5 = this.mPostDetailBean;
        String coverUrl$default = postSubjectItem5 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItem5, false, 1, (Object) null) : null;
        if (TextUtils.isEmpty(coverUrl$default) && ((postSubjectItem = this.mPostDetailBean) == null || (media = postSubjectItem.getMedia()) == null || (cover = media.getCover()) == null || (coverUrl$default = cover.getUrl()) == null)) {
            coverUrl$default = BuildConfig.FLAVOR;
        }
        String str3 = coverUrl$default;
        PostSubjectItem postSubjectItem6 = this.mPostDetailBean;
        if ((postSubjectItem6 != null ? postSubjectItem6.getSubject() : null) != null) {
            PostSubjectItem postSubjectItem7 = this.mPostDetailBean;
            if (postSubjectItem7 != null && (subject4 = postSubjectItem7.getSubject()) != null && (resourceDetector2 = subject4.getResourceDetector()) != null) {
                url = resourceDetector2.getResourceId();
                str = url;
            }
            str = null;
        } else {
            if (audio2 != null) {
                url = audio2.getUrl();
                str = url;
            }
            str = null;
        }
        DownloadBean downloadBean = new DownloadBean((audio2 == null || (url2 = audio2.getUrl()) == null) ? BuildConfig.FLAVOR : url2, str, str2, str3, (audio2 == null || (size = audio2.getSize()) == null) ? null : Long.valueOf(size.intValue()), BuildConfig.FLAVOR, null, null, null, null, 0L, 0, 0, 1, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -8256, -1, 65535, null);
        PostSubjectItem postSubjectItem8 = this.mPostDetailBean;
        downloadBean.setPostId(postSubjectItem8 != null ? postSubjectItem8.getPostId() : null);
        PostSubjectItem postSubjectItem9 = this.mPostDetailBean;
        downloadBean.setSubjectId((postSubjectItem9 == null || (subject3 = postSubjectItem9.getSubject()) == null) ? null : subject3.getSubjectId());
        PostSubjectItem postSubjectItem10 = this.mPostDetailBean;
        downloadBean.setSubjectName((postSubjectItem10 == null || (subject2 = postSubjectItem10.getSubject()) == null) ? null : subject2.getTitle());
        DownloadManagerApi a = DownloadManagerApi.j.a();
        FragmentActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = context;
        PostSubjectItem postSubjectItem11 = this.mPostDetailBean;
        String ops = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
        PostSubjectItem postSubjectItem12 = this.mPostDetailBean;
        String str4 = (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? BuildConfig.FLAVOR : resourceLink;
        PostSubjectItem postSubjectItem13 = this.mPostDetailBean;
        DownloadManagerApi.P(a, fragmentActivity, downloadBean, "post_audio_detail", ops, str4, postSubjectItem13 != null ? postSubjectItem13.getSubject() : null, (String) null, 64, (Object) null);
        com.transsion.postdetail.helper.a.j(com.transsion.postdetail.helper.a.a, this.mPostDetailBean, getPageName(), null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void clickLike() {
        if (!yg.l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R.string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        int c2 = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        PostDetailViewModel viewModel = getViewModel();
        PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
        viewModel.G(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, c2);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.a;
        PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
        com.transsion.postdetail.helper.a.p(aVar, postSubjectItem3, postSubjectItem3 != null ? Intrinsics.c(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, getPageName(), null, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doShare() {
        boolean z;
        ShareDialogFragment a;
        User user;
        User user2;
        qx.a mLoginApi = getMLoginApi();
        UserInfo i = mLoginApi != null ? mLoginApi.i() : null;
        if ((i != null ? i.getUserId() : null) != null) {
            String userId = i.getUserId();
            PostSubjectItem postSubjectItem = this.mPostDetailBean;
            if (Intrinsics.c(userId, (postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId())) {
                z = true;
                boolean z2 = z;
                ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
                PostType postType = PostType.POST_TYPE;
                PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
                String postId = postSubjectItem2 == null ? postSubjectItem2.getPostId() : null;
                PostSubjectItem postSubjectItem3 = this.mPostDetailBean;
                String userId2 = (postSubjectItem3 != null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
                String value = ReportType.POST.getValue();
                PostSubjectItem postSubjectItem4 = this.mPostDetailBean;
                a = companion.a(postType, postId, userId2, value, (r29 & 16) != 0 ? BuildConfig.FLAVOR : postSubjectItem4 != null ? postSubjectItem4.getTitle() : null, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z2, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : this.tranOps, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
                a.G0(new b());
                a.show(getChildFragmentManager(), "share");
                com.transsion.postdetail.helper.a.A(com.transsion.postdetail.helper.a.a, this.mPostDetailBean, getPageName(), null, 4, null);
            }
        }
        z = false;
        boolean z22 = z;
        ShareDialogFragment.Companion companion2 = ShareDialogFragment.INSTANCE;
        PostType postType2 = PostType.POST_TYPE;
        PostSubjectItem postSubjectItem22 = this.mPostDetailBean;
        if (postSubjectItem22 == null) {
        }
        PostSubjectItem postSubjectItem32 = this.mPostDetailBean;
        if (postSubjectItem32 != null) {
        }
        String value2 = ReportType.POST.getValue();
        PostSubjectItem postSubjectItem42 = this.mPostDetailBean;
        a = companion2.a(postType2, postId, userId2, value2, (r29 & 16) != 0 ? BuildConfig.FLAVOR : postSubjectItem42 != null ? postSubjectItem42.getTitle() : null, (r29 & 32) != 0 ? BuildConfig.FLAVOR : BuildConfig.FLAVOR, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : z22, (r29 & 256) != 0 ? false : false, "postdetail", (r29 & 1024) != 0 ? BuildConfig.FLAVOR : this.tranOps, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
        a.G0(new b());
        a.show(getChildFragmentManager(), "share");
        com.transsion.postdetail.helper.a.A(com.transsion.postdetail.helper.a.a, this.mPostDetailBean, getPageName(), null, 4, null);
    }

    private final qx.a getMLoginApi() {
        return (qx.a) this.mLoginApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostDetailViewModel getViewModel() {
        return (PostDetailViewModel) this.viewModel.getValue();
    }

    private final void initPlayer() {
        com.transsion.ninegridview.a aVar = new com.transsion.ninegridview.a();
        aVar.h();
        aVar.i();
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        aVar.j(requireContext);
        wm.a g = aVar.g();
        if (g != null) {
            g.a();
        }
        wm.a g2 = aVar.g();
        if (g2 != null) {
            PostSubjectItem postSubjectItem = this.mPostDetailBean;
            wn.m mVar = (wn.m) getMViewBinding();
            g2.s(postSubjectItem, mVar != null ? mVar.r : null, 0);
        }
        wm.a g3 = aVar.g();
        if (g3 != null) {
            g3.y(true);
        }
        this.mGifPlayerManager = aVar;
    }

    private final void loadData() {
        String subjectId;
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        String str = BuildConfig.FLAVOR;
        if (postSubjectItem == null) {
            showLoadingView();
            PostDetailViewModel viewModel = getViewModel();
            String str2 = this.postId;
            if (str2 != null) {
                str = str2;
            }
            viewModel.x(str);
            return;
        }
        if (postSubjectItem != null) {
            postSubjectItem.setTran_ops(this.tranOps);
        }
        updatePostDetail();
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (subjectId = subject.getSubjectId()) == null || subjectId.length() != 0) {
            return;
        }
        PostDetailViewModel viewModel2 = getViewModel();
        String str3 = this.postId;
        if (str3 != null) {
            str = str3;
        }
        viewModel2.x(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a mLoginApi_delegate$lambda$0() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    private final void observeLike() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.y1
            public final Object invoke(Object obj) {
                Unit N0;
                N0 = PostDetailCommonFragment.N0(PostDetailCommonFragment.this, (LikeEvent) obj);
                return N0;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    private final void setPTParams(PostSubjectItem item) {
        HashMap g;
        HashMap g2;
        qi.b logViewConfig;
        HashMap g3;
        String mediaType;
        qi.b logViewConfig2;
        HashMap g4;
        qi.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null) {
            logViewConfig3.k(true);
        }
        qi.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            logViewConfig4.n(item.getRec_ops());
        }
        boolean isEmpty = TextUtils.isEmpty(item.getPostId());
        String str = BuildConfig.FLAVOR;
        if (!isEmpty && (logViewConfig2 = getLogViewConfig()) != null && (g4 = logViewConfig2.g()) != null) {
            String postId = item.getPostId();
            if (postId == null) {
                postId = BuildConfig.FLAVOR;
            }
            g4.put("post_id", postId);
        }
        Media media = item.getMedia();
        if (!TextUtils.isEmpty(media != null ? media.getMediaType() : null) && (logViewConfig = getLogViewConfig()) != null && (g3 = logViewConfig.g()) != null) {
            Media media2 = item.getMedia();
            if (media2 != null && (mediaType = media2.getMediaType()) != null) {
                str = mediaType;
            }
            g3.put("post_media_type", str);
        }
        qi.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g2 = logViewConfig5.g()) != null) {
            Subject subject = item.getSubject();
            g2.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        qi.b logViewConfig6 = getLogViewConfig();
        if (logViewConfig6 == null || (g = logViewConfig6.g()) == null) {
            return;
        }
        Subject subject2 = item.getSubject();
        g.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
    }

    private final void showCommentsDialog() {
        ImmVideoCommentDialog b2 = ImmVideoCommentDialog.Companion.b(ImmVideoCommentDialog.INSTANCE, this.mPostDetailBean, null, null, null, 14, null);
        b2.A0(new d());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        b2.show(childFragmentManager, "PostDetailCommentsFragment.TAG_POST_DETAIL_COMMENTS_FRAGMENT");
    }

    private final void updatePostDetail() {
        Subject subject;
        String str;
        PostSubjectItem postSubjectItem = this.mPostDetailBean;
        if (postSubjectItem != null) {
            wn.m mVar = (wn.m) getMViewBinding();
            Boolean bool = null;
            if (mVar != null) {
                AppCompatTextView appCompatTextView = mVar.A;
                User user = postSubjectItem.getUser();
                appCompatTextView.setText(user != null ? user.getNickname() : null);
                ImageView imageView = mVar.n;
                int a = com.blankj.utilcode.util.a0.a(28.0f);
                f.a aVar = ni.f.a;
                Context context = imageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                User user2 = postSubjectItem.getUser();
                if (user2 == null || (str = user2.getAvatar()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b c2 = m.g(str).m(a).c(a);
                Intrinsics.e(imageView);
                c2.d(imageView);
                if (postSubjectItem.getGroup() != null) {
                    AppCompatTextView appCompatTextView2 = mVar.z;
                    Group group = postSubjectItem.getGroup();
                    appCompatTextView2.setText(group != null ? group.getName() : null);
                    AppCompatTextView appCompatTextView3 = mVar.z;
                    Intrinsics.g(appCompatTextView3, "tvSubject");
                    uf.c.k(appCompatTextView3);
                    mVar.z.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.i2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PostDetailCommonFragment.b1(PostDetailCommonFragment.this, view);
                        }
                    });
                } else {
                    AppCompatTextView appCompatTextView4 = mVar.z;
                    Intrinsics.g(appCompatTextView4, "tvSubject");
                    uf.c.g(appCompatTextView4);
                }
                AppCompatTextView appCompatTextView5 = mVar.x;
                if (postSubjectItem.getCreatedAt() == null) {
                    Intrinsics.e(appCompatTextView5);
                    uf.c.g(appCompatTextView5);
                } else {
                    Intrinsics.e(appCompatTextView5);
                    uf.c.k(appCompatTextView5);
                    String createdAt = postSubjectItem.getCreatedAt();
                    appCompatTextView5.setText(com.transsion.postdetail.util.m.a(createdAt != null ? Long.parseLong(createdAt) : 0L));
                }
                mVar.t.showData(postSubjectItem, getPageName(), new Function0() { // from class: com.transsion.postdetail.ui.fragment.j2
                    public final Object invoke() {
                        Unit c1;
                        c1 = PostDetailCommonFragment.c1(PostDetailCommonFragment.this);
                        return c1;
                    }
                });
            }
            Y0(postSubjectItem.getSubjectRate());
            T0(postSubjectItem.getMedia());
            setPTParams(postSubjectItem);
            String title = postSubjectItem.getTitle();
            String content = postSubjectItem.getContent();
            Link link = postSubjectItem.getLink();
            V0(title, content, link != null ? link.getUrl() : null);
            F0();
            PostSubjectItem postSubjectItem2 = this.mPostDetailBean;
            if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
                bool = subject.getHasResource();
            }
            a1(bool);
            O0();
        }
    }

    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public wn.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        wn.m c2 = wn.m.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public abstract void F0();

    public abstract void G0();

    public final PostSubjectItem getMPostDetailBean() {
        return this.mPostDetailBean;
    }

    public abstract String getPageName();

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public abstract void initAudioListener();

    public void initListener() {
        AppCompatImageView appCompatImageView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar != null && (appCompatImageView = mVar.o) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.e2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommonFragment.H0(PostDetailCommonFragment.this, view);
                }
            });
        }
        com.transsion.baseui.util.o oVar = com.transsion.baseui.util.o.a;
        wn.m mVar2 = (wn.m) getMViewBinding();
        ShapeableImageView shapeableImageView = mVar2 != null ? mVar2.n : null;
        wn.m mVar3 = (wn.m) getMViewBinding();
        oVar.a(new View[]{shapeableImageView, mVar3 != null ? mVar3.A : null}, new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostDetailCommonFragment.I0(PostDetailCommonFragment.this, view);
            }
        });
    }

    public void initViewData() {
        Z0();
        G0();
        initAudioListener();
        loadData();
        C0();
        L0();
    }

    public void initViewModel() {
        PostDetailViewModel viewModel = getViewModel();
        viewModel.A().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.k2
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = PostDetailCommonFragment.J0(PostDetailCommonFragment.this, (PostSubjectItem) obj);
                return J0;
            }
        }));
        viewModel.t().j(this, new c(new Function1() { // from class: com.transsion.postdetail.ui.fragment.l2
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = PostDetailCommonFragment.K0(PostDetailCommonFragment.this, (String) obj);
                return K0;
            }
        }));
        observeLike();
    }

    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public boolean isMonitorNetworkState() {
        return false;
    }

    public qi.b newLogViewConfig() {
        return new qi.b(getPageName(), false, 2, null);
    }

    public void onDestroy() {
        super.onDestroy();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onPause() {
        super.onPause();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void onResume() {
        super.onResume();
        com.transsion.ninegridview.a aVar = this.mGifPlayerManager;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void receiveArguments() {
        Serializable serializable;
        super.receiveArguments();
        Bundle arguments = getArguments();
        PostSubjectItem postSubjectItem = null;
        this.postId = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.fromComment = arguments2 != null ? arguments2.getBoolean("from_comment") : false;
        Bundle arguments3 = getArguments();
        this.tranOps = arguments3 != null ? arguments3.getString("rec_ops") : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (serializable = arguments4.getSerializable("item_object")) != null) {
            postSubjectItem = (PostSubjectItem) serializable;
        }
        this.mPostDetailBean = postSubjectItem;
    }

    public void retryLoadData() {
    }
}
