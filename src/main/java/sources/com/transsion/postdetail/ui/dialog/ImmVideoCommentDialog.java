package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetailapi.CommentTopicType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JI\u0010\u001f\u001a\u00020\u00072:\u0010\u001e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00103R$\u0010?\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R0\u0010B\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/transsion/postdetail/ui/dialog/ImmVideoCommentDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "s0", "()I", BuildConfig.FLAVOR, "w0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lqi/b;", "newLogViewConfig", "()Lqi/b;", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", "name", "commentId", BuildConfig.FLAVOR, "likeStatu", "callback", "z0", "(Lkotlin/jvm/functions/Function2;)V", "B0", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "commentBean", "y0", "(Lcom/transsion/moviedetailapi/bean/CommentBean;)V", "Lwn/e;", "c", "Lwn/e;", "viewBinding", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "d", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "data", "Lcom/transsion/postdetail/ui/fragment/CommentFragment;", "e", "Lcom/transsion/postdetail/ui/fragment/CommentFragment;", "commentFragment", "f", "Ljava/lang/String;", "g", "pageName", "h", "pageFrom", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "i", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "r0", "()Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "A0", "(Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;)V", "onCommentCountChangedListener", "j", "Lkotlin/jvm/functions/Function2;", "mCommentCallback", "k", "Z", "isOpenEdittext", "l", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "mCommentBean", "m", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ImmVideoCommentDialog extends BaseDialog {

    /* renamed from: m, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    private wn.e viewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private PostSubjectItem data;

    /* renamed from: e, reason: from kotlin metadata */
    private CommentFragment commentFragment;

    /* renamed from: f, reason: from kotlin metadata */
    private String commentId;

    /* renamed from: g, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: h, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: i, reason: from kotlin metadata */
    private CommentFragment.b onCommentCountChangedListener;

    /* renamed from: j, reason: from kotlin metadata */
    private Function2 mCommentCallback;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isOpenEdittext;

    /* renamed from: l, reason: from kotlin metadata */
    private CommentBean mCommentBean;

    /* renamed from: com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImmVideoCommentDialog b(Companion companion, PostSubjectItem postSubjectItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str = BuildConfig.FLAVOR;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.a(postSubjectItem, str, str2, str3);
        }

        public final ImmVideoCommentDialog a(PostSubjectItem postSubjectItem, String str, String str2, String str3) {
            Intrinsics.h(str, "commentId");
            ImmVideoCommentDialog immVideoCommentDialog = new ImmVideoCommentDialog();
            immVideoCommentDialog.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("POST_ITEM", postSubjectItem), TuplesKt.a("comment_id", str), TuplesKt.a("PAGE_NAME", str2), TuplesKt.a("page_from", str3)}));
            return immVideoCommentDialog;
        }
    }

    public ImmVideoCommentDialog() {
        super(R$layout.dialog_imm_video_comment);
        this.commentId = BuildConfig.FLAVOR;
        this.pageName = BuildConfig.FLAVOR;
        this.pageFrom = BuildConfig.FLAVOR;
    }

    private final int s0() {
        int i = getResources().getDisplayMetrics().heightPixels;
        return i - (i / 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ImmVideoCommentDialog immVideoCommentDialog, View view) {
        immVideoCommentDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ImmVideoCommentDialog immVideoCommentDialog, View view) {
        CommentFragment commentFragment = immVideoCommentDialog.commentFragment;
        if (commentFragment != null) {
            commentFragment.u(view);
        }
        CommentFragment commentFragment2 = immVideoCommentDialog.commentFragment;
        if (commentFragment2 != null) {
            commentFragment2.d1(null);
        }
        com.transsion.postdetail.helper.a.f(com.transsion.postdetail.helper.a.a, immVideoCommentDialog.data, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(ImmVideoCommentDialog immVideoCommentDialog, String str, Boolean bool) {
        Function2 function2 = immVideoCommentDialog.mCommentCallback;
        if (function2 != null) {
        }
        return Unit.a;
    }

    private final void w0() {
        final AppCompatTextView appCompatTextView;
        wn.e eVar = this.viewBinding;
        if (eVar == null || (appCompatTextView = eVar.e) == null) {
            return;
        }
        appCompatTextView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.dialog.d
            @Override // java.lang.Runnable
            public final void run() {
                ImmVideoCommentDialog.x0(ImmVideoCommentDialog.this, appCompatTextView);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ImmVideoCommentDialog immVideoCommentDialog, AppCompatTextView appCompatTextView) {
        CommentFragment commentFragment = immVideoCommentDialog.commentFragment;
        if (commentFragment != null) {
            commentFragment.u(appCompatTextView);
        }
        CommentFragment commentFragment2 = immVideoCommentDialog.commentFragment;
        if (commentFragment2 != null) {
            commentFragment2.d1(immVideoCommentDialog.mCommentBean);
        }
        com.transsion.postdetail.helper.a.f(com.transsion.postdetail.helper.a.a, immVideoCommentDialog.data, null, null, 6, null);
    }

    public void A0(CommentFragment.b bVar) {
        this.onCommentCountChangedListener = bVar;
    }

    public final void B0() {
        this.isOpenEdittext = true;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public qi.b newLogViewConfig() {
        return new qi.b("videocomment", false, 2, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.data = arguments.getSerializable("POST_ITEM");
            String string = arguments.getString("comment_id", BuildConfig.FLAVOR);
            Intrinsics.g(string, "getString(...)");
            this.commentId = string;
            String string2 = arguments.getString("PAGE_NAME", BuildConfig.FLAVOR);
            Intrinsics.g(string2, "getString(...)");
            this.pageName = string2;
            String string3 = arguments.getString("page_from", BuildConfig.FLAVOR);
            Intrinsics.g(string3, "getString(...)");
            this.pageFrom = string3;
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext, getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = cVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.a.b(requireContext);
            attributes.height = s0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return cVar;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        CommentFragment a;
        Stat stat;
        Long commentCount;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        FrameLayout frameLayout;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        wn.e a2 = wn.e.a(view);
        this.viewBinding = a2;
        if (a2 != null && (frameLayout = a2.c) != null && (layoutParams = frameLayout.getLayoutParams()) != null) {
            layoutParams.height = s0();
        }
        wn.e eVar = this.viewBinding;
        if (eVar != null && (imageView = eVar.d) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImmVideoCommentDialog.t0(ImmVideoCommentDialog.this, view2);
                }
            });
        }
        wn.e eVar2 = this.viewBinding;
        if (eVar2 != null && (appCompatTextView = eVar2.e) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImmVideoCommentDialog.u0(ImmVideoCommentDialog.this, view2);
                }
            });
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
        w p = childFragmentManager.p();
        Intrinsics.g(p, "beginTransaction()");
        CommentFragment.Companion companion = CommentFragment.INSTANCE;
        PostSubjectItem postSubjectItem = this.data;
        String postId = postSubjectItem != null ? postSubjectItem.getPostId() : null;
        String value = CommentTopicType.POST.getValue();
        PostSubjectItem postSubjectItem2 = this.data;
        a = companion.a(postId, value, (postSubjectItem2 == null || (stat = postSubjectItem2.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue(), (r32 & 8) != 0, (r32 & 16) != 0 ? false : false, (r32 & 32) != 0 ? BuildConfig.FLAVOR : this.commentId, this.pageFrom, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null);
        p.s(R$id.fl_comment_container, a);
        this.commentFragment = a;
        p.i();
        CommentFragment commentFragment = this.commentFragment;
        if (commentFragment != null) {
            commentFragment.b1(getOnCommentCountChangedListener());
        }
        CommentFragment commentFragment2 = this.commentFragment;
        if (commentFragment2 != null) {
            commentFragment2.Z0(new Function2() { // from class: com.transsion.postdetail.ui.dialog.c
                public final Object invoke(Object obj, Object obj2) {
                    Unit v0;
                    v0 = ImmVideoCommentDialog.v0(ImmVideoCommentDialog.this, (String) obj, (Boolean) obj2);
                    return v0;
                }
            });
        }
        if (this.isOpenEdittext) {
            w0();
        }
    }

    /* renamed from: r0, reason: from getter */
    public CommentFragment.b getOnCommentCountChangedListener() {
        return this.onCommentCountChangedListener;
    }

    public final void y0(CommentBean commentBean) {
        this.mCommentBean = commentBean;
    }

    public final void z0(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.mCommentCallback = callback;
    }
}
