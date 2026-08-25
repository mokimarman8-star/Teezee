package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.transsion.baseui.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ1\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00103\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostDetailSubjectView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "n", "()V", "k", "o", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "postSubjectItem", BuildConfig.FLAVOR, "pageName", "Lkotlin/Function0;", "onItemClick", "showData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "a", "Lkotlin/jvm/functions/Function0;", "mOnItemClick", "b", "Ljava/lang/String;", "c", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clSubjectRoot", "Lcom/transsnet/downloader/widget/DownloadView;", "d", "Lcom/transsnet/downloader/widget/DownloadView;", "llDownload", "Landroidx/appcompat/widget/AppCompatTextView;", "e", "Landroidx/appcompat/widget/AppCompatTextView;", "tvSubjectYear", "f", "tvSubjectTitle", "Landroidx/appcompat/widget/AppCompatImageView;", "g", "Landroidx/appcompat/widget/AppCompatImageView;", "ivCover", "h", "ivGaussianBlur", "i", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "mPostSubjectItem", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailSubjectView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private Function0 mOnItemClick;

    /* renamed from: b, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: c, reason: from kotlin metadata */
    private ConstraintLayout clSubjectRoot;

    /* renamed from: d, reason: from kotlin metadata */
    private DownloadView llDownload;

    /* renamed from: e, reason: from kotlin metadata */
    private AppCompatTextView tvSubjectYear;

    /* renamed from: f, reason: from kotlin metadata */
    private AppCompatTextView tvSubjectTitle;

    /* renamed from: g, reason: from kotlin metadata */
    private AppCompatImageView ivCover;

    /* renamed from: h, reason: from kotlin metadata */
    private AppCompatImageView ivGaussianBlur;

    /* renamed from: i, reason: from kotlin metadata */
    private PostSubjectItem mPostSubjectItem;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailSubjectView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailSubjectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PostDetailSubjectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        View.inflate(context, R$layout.view_post_detail_subject_layout, this);
        n();
        k();
    }

    private final void k() {
        DownloadView downloadView = this.llDownload;
        if (downloadView != null) {
            downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailSubjectView.l(PostDetailSubjectView.this, view);
                }
            });
        }
        ConstraintLayout constraintLayout = this.clSubjectRoot;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.j1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailSubjectView.m(PostDetailSubjectView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(PostDetailSubjectView postDetailSubjectView, View view) {
        String str;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        Group group2;
        Subject subject3;
        String subjectId;
        Subject subject4;
        Subject subject5;
        ResourceDetectors resourceDetector2;
        Subject subject6;
        if (postDetailSubjectView.getContext() instanceof FragmentActivity) {
            DownloadManagerApi.a aVar = DownloadManagerApi.j;
            DownloadManagerApi a = aVar.a();
            PostSubjectItem postSubjectItem = postDetailSubjectView.mPostSubjectItem;
            String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
            PostSubjectItem postSubjectItem2 = postDetailSubjectView.mPostSubjectItem;
            String resourceId = (postSubjectItem2 == null || (subject5 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
            PostSubjectItem postSubjectItem3 = postDetailSubjectView.mPostSubjectItem;
            if (DownloadManagerApi.x0(a, subjectId2, resourceId, (postSubjectItem3 == null || (subject4 = postSubjectItem3.getSubject()) == null) ? false : subject4.isSeries(), false, 8, (Object) null)) {
                PostSubjectItem postSubjectItem4 = postDetailSubjectView.mPostSubjectItem;
                if (postSubjectItem4 == null || (subject3 = postSubjectItem4.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null) {
                    return;
                }
                DownloadManagerApi a2 = aVar.a();
                Context context = postDetailSubjectView.getContext();
                Intrinsics.e(context);
                DownloadManagerApi.z0(a2, subjectId, context, postDetailSubjectView.pageName, (String) null, 8, (Object) null);
                return;
            }
            PostSubjectItem postSubjectItem5 = postDetailSubjectView.mPostSubjectItem;
            if (postSubjectItem5 != null && (subject2 = postSubjectItem5.getSubject()) != null) {
                Integer subjectType = subject2.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi a3 = aVar.a();
                    FragmentActivity context2 = postDetailSubjectView.getContext();
                    Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = context2;
                    String str2 = postDetailSubjectView.pageName;
                    PostSubjectItem postSubjectItem6 = postDetailSubjectView.mPostSubjectItem;
                    String groupId = (postSubjectItem6 == null || (group2 = postSubjectItem6.getGroup()) == null) ? null : group2.getGroupId();
                    PostSubjectItem postSubjectItem7 = postDetailSubjectView.mPostSubjectItem;
                    String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
                    PostSubjectItem postSubjectItem8 = postDetailSubjectView.mPostSubjectItem;
                    DownloadManagerApi.e0(a3, fragmentActivity, str2, groupId, ops, "download_subject", true, postSubjectItem8 != null ? postSubjectItem8.getSubject() : null, (String) null, (Boolean) null, 384, (Object) null);
                    return;
                }
            }
            DownloadManagerApi a4 = aVar.a();
            FragmentActivity context3 = postDetailSubjectView.getContext();
            Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity2 = context3;
            PostSubjectItem postSubjectItem9 = postDetailSubjectView.mPostSubjectItem;
            Subject subject7 = postSubjectItem9 != null ? postSubjectItem9.getSubject() : null;
            String str3 = postDetailSubjectView.pageName;
            PostSubjectItem postSubjectItem10 = postDetailSubjectView.mPostSubjectItem;
            String groupId2 = (postSubjectItem10 == null || (group = postSubjectItem10.getGroup()) == null) ? null : group.getGroupId();
            PostSubjectItem postSubjectItem11 = postDetailSubjectView.mPostSubjectItem;
            String ops2 = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
            PostSubjectItem postSubjectItem12 = postDetailSubjectView.mPostSubjectItem;
            if (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
                str = BuildConfig.FLAVOR;
            }
            String str4 = str;
            PostSubjectItem postSubjectItem13 = postDetailSubjectView.mPostSubjectItem;
            if (postSubjectItem13 != null && (user = postSubjectItem13.getUser()) != null) {
                r9 = user.getNickname();
            }
            DownloadManagerApi.M(a4, fragmentActivity2, subject7, str3, groupId2, ops2, str4, (String) null, (String) null, r9, false, 704, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PostDetailSubjectView postDetailSubjectView, View view) {
        Function0 function0;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L) || (function0 = postDetailSubjectView.mOnItemClick) == null) {
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        this.ivGaussianBlur = findViewById(R$id.ivGaussianBlur);
        this.ivCover = findViewById(R$id.ivCover);
        this.tvSubjectTitle = findViewById(R$id.tvSubjectTitle);
        this.tvSubjectYear = findViewById(R$id.tvSubjectYear);
        this.llDownload = findViewById(R$id.llDownload);
        this.clSubjectRoot = findViewById(R$id.clSubjectRoot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        AppCompatActivity context = getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.k1
            public final Object invoke(Object obj) {
                Unit p;
                p = PostDetailSubjectView.p(PostDetailSubjectView.this, (AddToDownloadEvent) obj);
                return p;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PostDetailSubjectView postDetailSubjectView, AddToDownloadEvent addToDownloadEvent) {
        String subjectId;
        PostSubjectItem postSubjectItem;
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        Subject subject4;
        Intrinsics.h(addToDownloadEvent, "value");
        try {
            subjectId = addToDownloadEvent.getSubjectId();
            postSubjectItem = postDetailSubjectView.mPostSubjectItem;
        } catch (Exception unused) {
            a.a.g(wf.a.a, " callback change data fail", false, 2, (Object) null);
        }
        if (!TextUtils.equals(subjectId, (postSubjectItem == null || (subject4 = postSubjectItem.getSubject()) == null) ? null : subject4.getSubjectId())) {
            return Unit.a;
        }
        DownloadView downloadView = postDetailSubjectView.llDownload;
        if (downloadView != null) {
            PostSubjectItem postSubjectItem2 = postDetailSubjectView.mPostSubjectItem;
            String subjectId2 = (postSubjectItem2 == null || (subject3 = postSubjectItem2.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem3 = postDetailSubjectView.mPostSubjectItem;
            String resourceId = (postSubjectItem3 == null || (subject2 = postSubjectItem3.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem4 = postDetailSubjectView.mPostSubjectItem;
            DownloadView.setShowType$default(downloadView, subjectId2, resourceId, (postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : Boolean.valueOf(subject.isSeries()), false, 0, 24, (Object) null);
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showData$default(PostDetailSubjectView postDetailSubjectView, PostSubjectItem postSubjectItem, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        postDetailSubjectView.showData(postSubjectItem, str, function0);
    }

    public final void showData(PostSubjectItem postSubjectItem, String pageName, Function0<Unit> onItemClick) {
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        Subject subject4;
        Object obj;
        String str;
        String str2;
        String str3;
        String d;
        DownloadView downloadView;
        Subject subject5;
        Subject subject6;
        Intrinsics.h(postSubjectItem, "postSubjectItem");
        Intrinsics.h(pageName, "pageName");
        this.pageName = pageName;
        this.mPostSubjectItem = postSubjectItem;
        this.mOnItemClick = onItemClick;
        Boolean bool = null;
        if (TextUtils.isEmpty((postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId())) {
            ConstraintLayout constraintLayout = this.clSubjectRoot;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        PostSubjectItem postSubjectItem2 = this.mPostSubjectItem;
        if (((postSubjectItem2 == null || (subject5 = postSubjectItem2.getSubject()) == null) ? false : Intrinsics.c(subject5.getHasResource(), Boolean.FALSE)) && (downloadView = this.llDownload) != null) {
            downloadView.setVisibility(8);
        }
        DownloadView downloadView2 = this.llDownload;
        if (downloadView2 != null) {
            downloadView2.setPageFrom(pageName);
        }
        PostSubjectItem postSubjectItem3 = this.mPostSubjectItem;
        if (postSubjectItem3 != null && (subject4 = postSubjectItem3.getSubject()) != null) {
            AppCompatImageView appCompatImageView = this.ivGaussianBlur;
            String str4 = BuildConfig.FLAVOR;
            if (appCompatImageView != null) {
                ni.g gVar = ni.g.a;
                Cover cover = subject4.getCover();
                if (cover == null || (str3 = cover.getUrl()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                d = gVar.d(str3, com.blankj.utilcode.util.a0.a(42.0f), (r21 & 4) != 0 ? true : true, (r21 & 8) != 0 ? true : true, (r21 & 16) != 0 ? 0 : 0, (r21 & 32) != 0 ? false : false, (r21 & 64) != 0 ? false : false, (r21 & 128) != 0 ? 0 : 0);
                Glide.with(appCompatImageView.getContext()).load(d).transform(new sf.a(50, 1, true)).into(appCompatImageView);
            }
            ImageView imageView = this.ivCover;
            if (imageView != null) {
                int a = com.blankj.utilcode.util.a0.a(42.0f);
                f.a aVar = ni.f.a;
                Context context = imageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover2 = subject4.getCover();
                if (cover2 == null || (str2 = cover2.getUrl()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                m.g(str2).i(R.mipmap.home_ic_default_res).m(a).c(a).d(imageView);
            }
            AppCompatTextView appCompatTextView = this.tvSubjectTitle;
            if (appCompatTextView != null) {
                appCompatTextView.setText(subject4.getTitle());
            }
            try {
                Result.Companion companion = Result.Companion;
                AppCompatTextView appCompatTextView2 = this.tvSubjectYear;
                if (appCompatTextView2 != null) {
                    String releaseDate = subject4.getReleaseDate();
                    if (releaseDate != null) {
                        str = releaseDate.substring(0, 4);
                        Intrinsics.g(str, "substring(...)");
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(subject4.getCountryName())) {
                        str4 = " · " + subject4.getCountryName();
                    }
                    appCompatTextView2.setText(str + str4);
                    Subject subject7 = postSubjectItem.getSubject();
                    appCompatTextView2.setCompoundDrawablesRelativeWithIntrinsicBounds(com.transsion.flow.h.a(subject7 != null ? subject7.getSubjectType() : null), 0, 0, 0);
                } else {
                    appCompatTextView2 = null;
                }
                obj = Result.constructor-impl(appCompatTextView2);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.box-impl(obj);
        }
        DownloadView downloadView3 = this.llDownload;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem4 = this.mPostSubjectItem;
            String subjectId = (postSubjectItem4 == null || (subject3 = postSubjectItem4.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem5 = this.mPostSubjectItem;
            String resourceId = (postSubjectItem5 == null || (subject2 = postSubjectItem5.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem6 = this.mPostSubjectItem;
            if (postSubjectItem6 != null && (subject = postSubjectItem6.getSubject()) != null) {
                bool = Boolean.valueOf(subject.isSeries());
            }
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, bool, false, 0, 24, (Object) null);
        }
        o();
    }
}
