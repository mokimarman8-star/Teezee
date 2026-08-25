package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ'\u0010\u0011\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0012JW\u0010\u001a\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostDetailOperationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onCLickLike", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "postSubjectItem", "x", "(Lkotlin/jvm/functions/Function0;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "onCLickComment", "p", "onCLickShare", "z", "(Lkotlin/jvm/functions/Function0;)V", "onCLickDownload", "v", "showData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "commentCount", "updateCommentNum", "(J)V", "Lwn/n0;", "a", "Lwn/n0;", "mViewBinding", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostDetailOperationView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private wn.n0 mViewBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailOperationView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailOperationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PostDetailOperationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.mViewBinding = wn.n0.c(LayoutInflater.from(context));
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, -2);
        wn.n0 n0Var = this.mViewBinding;
        addView(n0Var != null ? n0Var.getRoot() : null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function0 function0, View view) {
        function0.invoke();
    }

    private final void p(final Function0 onCLickComment, PostSubjectItem postSubjectItem) {
        AppCompatTextView appCompatTextView;
        Stat stat;
        Long commentCount;
        View view;
        wn.n0 n0Var = this.mViewBinding;
        if (n0Var != null && (view = n0Var.h) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.g1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.q(onCLickComment, view2);
                }
            });
        }
        String a = com.transsion.baseui.util.j.a((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
        wn.n0 n0Var2 = this.mViewBinding;
        if (n0Var2 == null || (appCompatTextView = n0Var2.f) == null) {
            return;
        }
        appCompatTextView.setText(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.a;
    }

    public static /* synthetic */ void showData$default(PostDetailOperationView postDetailOperationView, PostSubjectItem postSubjectItem, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.transsion.postdetail.ui.view.a1
                public final Object invoke() {
                    Unit r;
                    r = PostDetailOperationView.r();
                    return r;
                }
            };
        }
        Function0 function05 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: com.transsion.postdetail.ui.view.b1
                public final Object invoke() {
                    Unit s;
                    s = PostDetailOperationView.s();
                    return s;
                }
            };
        }
        Function0 function06 = function02;
        if ((i & 8) != 0) {
            function03 = new Function0() { // from class: com.transsion.postdetail.ui.view.c1
                public final Object invoke() {
                    Unit t;
                    t = PostDetailOperationView.t();
                    return t;
                }
            };
        }
        Function0 function07 = function03;
        if ((i & 16) != 0) {
            function04 = new Function0() { // from class: com.transsion.postdetail.ui.view.d1
                public final Object invoke() {
                    Unit u;
                    u = PostDetailOperationView.u();
                    return u;
                }
            };
        }
        postDetailOperationView.showData(postSubjectItem, function05, function06, function07, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.a;
    }

    private final void v(final Function0 onCLickDownload, PostSubjectItem postSubjectItem) {
        View view;
        Media media;
        if (TextUtils.equals(MediaType.AUDIO.getValue(), (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType())) {
            wn.n0 n0Var = this.mViewBinding;
            if (n0Var == null || (view = n0Var.i) == null) {
                return;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.w(onCLickDownload, view2);
                }
            });
            return;
        }
        wn.n0 n0Var2 = this.mViewBinding;
        if (n0Var2 != null) {
            n0Var2.i.setVisibility(8);
            n0Var2.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function0 function0, View view) {
        function0.invoke();
    }

    private final void x(final Function0 onCLickLike, PostSubjectItem postSubjectItem) {
        Stat stat;
        Long likeCount;
        View view;
        wn.n0 n0Var = this.mViewBinding;
        if (n0Var != null && (view = n0Var.j) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.y(onCLickLike, view2);
                }
            });
        }
        int i = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? R.mipmap.movie_detail_icon_liked : com.tn.lib.widget.R.drawable.ic_movie_like;
        String a = com.transsion.baseui.util.j.a((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (likeCount = stat.getLikeCount()) == null) ? 0L : likeCount.longValue());
        if (TextUtils.equals("0", a)) {
            a = BuildConfig.FLAVOR;
        }
        wn.n0 n0Var2 = this.mViewBinding;
        if (n0Var2 != null) {
            n0Var2.d.setImageResource(i);
            n0Var2.g.setText(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function0 function0, View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        function0.invoke();
    }

    private final void z(final Function0 onCLickShare) {
        View view;
        wn.n0 n0Var = this.mViewBinding;
        if (n0Var == null || (view = n0Var.k) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostDetailOperationView.A(onCLickShare, view2);
            }
        });
    }

    public final void showData(PostSubjectItem postSubjectItem, Function0<Unit> onCLickLike, Function0<Unit> onCLickComment, Function0<Unit> onCLickShare, Function0<Unit> onCLickDownload) {
        Intrinsics.h(onCLickLike, "onCLickLike");
        Intrinsics.h(onCLickComment, "onCLickComment");
        Intrinsics.h(onCLickShare, "onCLickShare");
        Intrinsics.h(onCLickDownload, "onCLickDownload");
        x(onCLickLike, postSubjectItem);
        p(onCLickComment, postSubjectItem);
        z(onCLickShare);
        v(onCLickDownload, postSubjectItem);
    }

    public final void updateCommentNum(long commentCount) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        if (commentCount <= 0) {
            wn.n0 n0Var = this.mViewBinding;
            if (n0Var == null || (appCompatTextView = n0Var.f) == null) {
                return;
            }
            appCompatTextView.setVisibility(8);
            return;
        }
        wn.n0 n0Var2 = this.mViewBinding;
        if (n0Var2 != null && (appCompatTextView3 = n0Var2.f) != null) {
            appCompatTextView3.setText(com.transsion.baseui.util.j.a(commentCount));
        }
        wn.n0 n0Var3 = this.mViewBinding;
        if (n0Var3 == null || (appCompatTextView2 = n0Var3.f) == null) {
            return;
        }
        appCompatTextView2.setVisibility(0);
    }
}
