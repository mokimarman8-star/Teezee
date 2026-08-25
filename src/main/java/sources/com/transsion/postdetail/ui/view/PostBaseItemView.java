package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.ui.adapter.RoomPostContentImageAdapter;
import com.transsion.postdetail.video.PostFeedVideoView;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.push.bean.MsgStyle;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010\u0012J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0012J\u001d\u0010$\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0002¢\u0006\u0004\b$\u0010%J'\u0010(\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\"2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b(\u0010)J'\u0010+\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\"2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b+\u0010)J'\u0010-\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\"2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b-\u0010)J'\u0010/\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\"2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b/\u0010)J\u001d\u00101\u001a\u00020\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0002¢\u0006\u0004\b1\u0010%J\u000f\u00102\u001a\u00020\fH\u0014¢\u0006\u0004\b2\u0010\u000eJ\u0011\u00104\u001a\u0004\u0018\u000103H\u0004¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\u001b2\b\u0010;\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b>\u0010\u0012J\u0015\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010I\u001a\u00020\f2\u0006\u0010G\u001a\u00020C2\u0006\u0010H\u001a\u00020CH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\bK\u0010\u0012J\u0015\u0010N\u001a\u00020\f2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u0087\u0001\u0010Q\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u0010P\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\"¢\u0006\u0004\bQ\u0010RJ'\u0010S\u001a\u00020\f2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\f0\"2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\bS\u0010)J\r\u0010T\u001a\u00020\f¢\u0006\u0004\bT\u0010\u000eJ\u0015\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020C¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\bX\u0010\u0012J\u001d\u0010Z\u001a\u00020\f2\u0006\u0010Y\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\\\u0010\u0012J\u0017\u0010]\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b]\u0010\u0012R\u001a\u0010b\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010e\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bc\u0010_\u001a\u0004\bd\u0010aR\u001a\u0010h\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bf\u0010_\u001a\u0004\bg\u0010aR\u0014\u0010j\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010_R\u0014\u0010l\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010_R\u0014\u0010n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010_R\u001a\u0010t\u001a\u00020o8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010U\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010-R%\u0010:\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010;\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u0081\u0001\u0010|\u001a\u0005\b\u0082\u0001\u0010~\"\u0006\b\u0083\u0001\u0010\u0080\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostBaseItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "D", "()V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", "setBottomDownLoadStatus", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setPostContent", "setPostContentDes", "setHotComment", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "hotComment", "C", "(Lcom/transsion/moviedetailapi/bean/CommentBean;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "E", BuildConfig.FLAVOR, "moduleName", "F", "(Ljava/lang/String;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setBottomBarContent", "setPostImage", "setPostVideo", "Lkotlin/Function0;", "onCLickHeader", "V", "(Lkotlin/jvm/functions/Function0;)V", "onCLickGroup", "postSubjectItem", "b0", "(Lkotlin/jvm/functions/Function0;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "onCLickSubject", "f0", "onCLickLike", "Z", "onCLickComment", "R", "onCLickShare", "d0", "onAttachedToWindow", "Landroidx/fragment/app/FragmentActivity;", "B", "()Landroidx/fragment/app/FragmentActivity;", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "viewModel", "setCommentViewModel", "(Lcom/transsion/postdetail/viewmodel/CommentViewModel;)V", "pageName", "pageFrom", "setPage", "(Ljava/lang/String;Ljava/lang/String;)V", "setData", "Landroidx/recyclerview/widget/RecyclerView$s;", "rvPool", "setRecycledViewPool", "(Landroidx/recyclerview/widget/RecyclerView$s;)V", BuildConfig.FLAVOR, "showDistance", "setHeaderPostData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Z)V", "isShowSubject", "isShowRoom", "setBottomSubjectAndRoomVisibility", "(ZZ)V", "setBottomSubjectModuleData", BuildConfig.FLAVOR, "count", "setCommentCount", "(J)V", "onClickDownload", "setBottomBarClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "T", "setContentMaxLine", "isDetail", "setIsDetail", "(Z)V", "setBottomRoomModuleData", "like", "refreshLike", "(ZLcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "setHeaderData", "setSubjectAndRoomContent", "a", "I", "getDp36", "()I", "dp36", "b", "getDp16", "dp16", "c", "getDp32", "dp32", "d", "rootWidth", "e", "dp78", "f", "dp280", "Lwn/s;", "g", "Lwn/s;", "getViewBinding", "()Lwn/s;", "viewBinding", "h", "Landroidx/recyclerview/widget/RecyclerView$s;", "i", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", "j", "k", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "l", "getPageFrom", "setPageFrom", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class PostBaseItemView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final int dp36;

    /* renamed from: b, reason: from kotlin metadata */
    private final int dp16;

    /* renamed from: c, reason: from kotlin metadata */
    private final int dp32;

    /* renamed from: d, reason: from kotlin metadata */
    private final int rootWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private final int dp78;

    /* renamed from: f, reason: from kotlin metadata */
    private final int dp280;

    /* renamed from: g, reason: from kotlin metadata */
    private final wn.s viewBinding;

    /* renamed from: h, reason: from kotlin metadata */
    private RecyclerView.s rvPool;

    /* renamed from: i, reason: from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean isDetail;

    /* renamed from: k, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: l, reason: from kotlin metadata */
    private String pageFrom;

    public static final class a extends DiffUtil.e {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Image image, Image image2) {
            Intrinsics.h(image, "oldItem");
            Intrinsics.h(image2, "newItem");
            return Intrinsics.c(image.getUrl(), image2.getUrl());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Image image, Image image2) {
            Intrinsics.h(image, "oldItem");
            Intrinsics.h(image2, "newItem");
            return Intrinsics.c(image.getUrl(), image2.getUrl());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PostBaseItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.dp36 = lj.a.b(36);
        this.dp16 = lj.a.b(16);
        this.dp32 = lj.a.b(32);
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        this.rootWidth = com.transsion.baseui.util.b.a(context2) ? lj.a.b(300) : com.blankj.utilcode.util.y.e() - lj.a.b(72);
        this.dp78 = lj.a.b(78);
        this.dp280 = lj.a.b(280);
        View.inflate(getContext(), R$layout.item_provider_room_post_base_layout, this);
        setPadding(0, 0, 0, lj.a.b(4));
        wn.s a2 = wn.s.a(this);
        Intrinsics.g(a2, "bind(...)");
        this.viewBinding = a2;
    }

    private final void C(CommentBean hotComment, PostSubjectItem item) {
        if (!yg.l.a.e()) {
            fh.b.a.d(R.string.base_net_err);
            return;
        }
        Boolean likeStatu = hotComment.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        boolean c = Intrinsics.c(likeStatu, bool);
        AppCompatImageView appCompatImageView = this.viewBinding.h;
        if (appCompatImageView != null) {
            if (appCompatImageView.isEnabled()) {
                appCompatImageView.setEnabled(false);
                hotComment.setLikeStatu(Boolean.FALSE);
                if (hotComment.getLikeCnt() > 0) {
                    hotComment.setLikeCnt(hotComment.getLikeCnt() - 1);
                }
            } else {
                appCompatImageView.setEnabled(true);
                hotComment.setLikeStatu(bool);
                hotComment.setLikeCnt(hotComment.getLikeCnt() + 1);
            }
        }
        AppCompatTextView appCompatTextView = this.viewBinding.s;
        if (appCompatTextView != null) {
            appCompatTextView.setText(hotComment.getLikeCnt() == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(hotComment.getLikeCnt()));
        }
        String commentId = hotComment.getCommentId();
        if (commentId != null) {
            if (this.mCommentViewModel == null) {
                D();
            }
            CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(c ? 1 : 0));
            F(c ? "dislike_hot_comment" : "like_hot_comment", item);
            rm.b bVar = new rm.b(!c, commentId, hotComment.getLikeCnt());
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = rm.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
            CommentViewModel commentViewModel = this.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.q(commentLikeBody);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if ((r0 instanceof androidx.lifecycle.y0) != false) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D() {
        if (this.mCommentViewModel != null) {
            return;
        }
        androidx.lifecycle.y0 context = getContext();
        androidx.lifecycle.y0 y0Var = null;
        androidx.lifecycle.y0 y0Var2 = context instanceof androidx.lifecycle.y0 ? context : null;
        if (y0Var2 == null) {
            y0Var2 = B();
        }
        y0Var = y0Var2;
        if (y0Var != null) {
            this.mCommentViewModel = new androidx.lifecycle.v0(y0Var).a(CommentViewModel.class);
        }
    }

    private final void E(PostSubjectItem item) {
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        Integer subjectType;
        String postId = item.getPostId();
        String str5 = BuildConfig.FLAVOR;
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("post_id", postId);
        Pair a3 = TuplesKt.a("page_from", this.pageFrom);
        Pair a4 = TuplesKt.a("module_name", "hot_comment");
        Pair a5 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
        User user = item.getUser();
        if (user == null || (str = user.getUserId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        Pair a6 = TuplesKt.a("user_id", str);
        Group group = item.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Pair a7 = TuplesKt.a("group_id", str2);
        Subject subject = item.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        Pair a8 = TuplesKt.a("subject_id", str3);
        Subject subject2 = item.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        Pair a9 = TuplesKt.a("subject_type", str4);
        Pair a10 = TuplesKt.a("builtin", item.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a11 = TuplesKt.a("post_media_type", value);
        String ops = item.getOps();
        if (ops != null) {
            str5 = ops;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, TuplesKt.a("ops", str5)});
        String str6 = this.pageName;
        if (str6 != null) {
            qi.h.a.z(str6, m);
        }
    }

    private final void F(String moduleName, PostSubjectItem item) {
        String str;
        String value;
        String groupId;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        CommentBean hotComment = item.getHotComment();
        String str2 = BuildConfig.FLAVOR;
        if (hotComment == null || (str = hotComment.getCommentId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("comment_id", str);
        String postId = item.getPostId();
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        hashMap.put("post_id", postId);
        String ops = item.getOps();
        if (ops == null) {
            ops = BuildConfig.FLAVOR;
        }
        hashMap.put("ops", ops);
        Group group = item.getGroup();
        if (group != null && (groupId = group.getGroupId()) != null) {
            str2 = groupId;
        }
        hashMap.put("group_id", str2);
        Media media = item.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        hashMap.put("post_media_type", value);
        String str3 = this.pageFrom;
        if (str3 != null && str3.length() != 0) {
            String str4 = this.pageFrom;
            Intrinsics.e(str4);
            hashMap.put("page_from", str4);
        }
        String str5 = this.pageName;
        if (str5 != null) {
            com.transsion.baselib.helper.a.a.i(str5, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(PostBaseItemView postBaseItemView, CommentBean commentBean, PostSubjectItem postSubjectItem, View view) {
        postBaseItemView.C(commentBean, postSubjectItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(CommentBean commentBean, PostBaseItemView postBaseItemView, rm.b bVar) {
        Intrinsics.h(bVar, "value");
        if (Intrinsics.c(bVar.a(), commentBean.getCommentId())) {
            a.a.r(wf.a.a, "hotCommentLikeEvent", new String[]{"commentId=" + bVar.a()}, false, 4, (Object) null);
            commentBean.setLikeStatu(Boolean.valueOf(bVar.c()));
            commentBean.setLikeCnt(bVar.b());
            AppCompatTextView appCompatTextView = postBaseItemView.viewBinding.s;
            if (appCompatTextView != null) {
                appCompatTextView.setText(bVar.b() == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(bVar.b()));
            }
            AppCompatImageView appCompatImageView = postBaseItemView.viewBinding.h;
            if (appCompatImageView != null) {
                appCompatImageView.setEnabled(bVar.c());
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(PostBaseItemView postBaseItemView, String str) {
        AppCompatTextView appCompatTextView = postBaseItemView.viewBinding.u;
        Intrinsics.e(appCompatTextView);
        com.transsion.baseui.util.l.h(appCompatTextView, str, 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Q(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, boolean z) {
        FirstFrame firstFrame;
        String url;
        String str;
        Cover cover;
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        if (postSubjectItem.getBuiltIn()) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostBaseItemView$setPostVideo$2$1$1(postBaseItemView, url, null), 3, (Object) null);
            return;
        }
        f.a aVar = ni.f.a;
        Context context = postBaseItemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context).g(url).c(z ? lj.a.b(280) : lj.a.b(162)).m(z ? lj.a.b(218) : lj.a.b(280));
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (cover = media2.getCover()) == null || (str = cover.getThumbnail()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b l = m.l(str);
        ShapeableImageView shapeableImageView = postBaseItemView.viewBinding.o.d;
        Intrinsics.g(shapeableImageView, "ivCover");
        l.d(shapeableImageView);
    }

    private final void R(final Function0 onCLickComment, PostSubjectItem postSubjectItem) {
        this.viewBinding.D.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.S(onCLickComment, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function0 function0, View view) {
        function0.invoke();
    }

    private final void V(final Function0 onCLickHeader) {
        this.viewBinding.y.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.W(onCLickHeader, view);
            }
        });
        this.viewBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.X(onCLickHeader, view);
            }
        });
        this.viewBinding.v.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.Y(onCLickHeader, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function0 function0, View view) {
        function0.invoke();
    }

    private final void Z(final Function0 onCLickLike, PostSubjectItem postSubjectItem) {
        this.viewBinding.F.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.a0(onCLickLike, view);
            }
        });
        if (postSubjectItem != null) {
            setBottomBarContent(postSubjectItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function0 function0, View view) {
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L)) {
            return;
        }
        function0.invoke();
    }

    private final void b0(final Function0 onCLickGroup, PostSubjectItem postSubjectItem) {
        this.viewBinding.n.f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.c0(onCLickGroup, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void d0(final Function0 onCLickShare) {
        View view;
        wn.s sVar = this.viewBinding;
        if (sVar == null || (view = sVar.G) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostBaseItemView.e0(onCLickShare, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function0 function0, View view) {
        function0.invoke();
    }

    private final void f0(final Function0 onCLickSubject, PostSubjectItem postSubjectItem) {
        this.viewBinding.n.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.g0(onCLickSubject, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function0 function0, View view) {
        function0.invoke();
    }

    public static /* synthetic */ void setBottomBarClick$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBottomBarClick");
        }
        postBaseItemView.setBottomBarClick(postSubjectItem, (i & 2) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.v0
            public final Object invoke() {
                Unit G;
                G = PostBaseItemView.G();
                return G;
            }
        } : function0, (i & 4) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.w0
            public final Object invoke() {
                Unit H;
                H = PostBaseItemView.H();
                return H;
            }
        } : function02, (i & 8) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.x0
            public final Object invoke() {
                Unit I;
                I = PostBaseItemView.I();
                return I;
            }
        } : function03, (i & 16) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.f0
            public final Object invoke() {
                Unit J;
                J = PostBaseItemView.J();
                return J;
            }
        } : function04, (i & 32) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.g0
            public final Object invoke() {
                Unit K;
                K = PostBaseItemView.K();
                return K;
            }
        } : function05, (i & 64) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.h0
            public final Object invoke() {
                Unit L;
                L = PostBaseItemView.L();
                return L;
            }
        } : function06, (i & 128) != 0 ? new Function0() { // from class: com.transsion.postdetail.ui.view.i0
            public final Object invoke() {
                Unit M;
                M = PostBaseItemView.M();
                return M;
            }
        } : function07);
    }

    private final void setBottomBarContent(PostSubjectItem item) {
        AppCompatTextView appCompatTextView = this.viewBinding.w;
        Stat stat = item.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        String str = BuildConfig.FLAVOR;
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (Intrinsics.c(item.getHasLike(), Boolean.TRUE)) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(com.tn.lib.widget.R.drawable.ic_post_like_select, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(com.tn.lib.widget.R.drawable.ic_post_like, 0, 0, 0);
        }
        Stat stat2 = item.getStat();
        Long commentCount = stat2 != null ? stat2.getCommentCount() : null;
        this.viewBinding.t.setText((commentCount == null || commentCount.longValue() == 0) ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(commentCount.longValue()));
        Stat stat3 = item.getStat();
        Long shareCount = stat3 != null ? stat3.getShareCount() : null;
        AppCompatTextView appCompatTextView2 = this.viewBinding.x;
        if (appCompatTextView2 != null) {
            if (shareCount != null && shareCount.longValue() != 0) {
                str = com.transsion.baseui.util.j.a(shareCount.longValue());
            }
            appCompatTextView2.setText(str);
        }
    }

    private final void setBottomDownLoadStatus(PostSubjectItem item) {
        Media media = item.getMedia();
        if (!Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            Media media2 = item.getMedia();
            if (!Intrinsics.c(media2 != null ? media2.getMediaType() : null, MediaType.IMAGE.getValue())) {
                Media media3 = item.getMedia();
                if (!Intrinsics.c(media3 != null ? media3.getMediaType() : null, MediaType.IMAGE_SINGLE.getValue())) {
                    View view = this.viewBinding.E;
                    if (view != null) {
                        uf.c.g(view);
                    }
                    AppCompatImageView appCompatImageView = this.viewBinding.j;
                    if (appCompatImageView != null) {
                        uf.c.g(appCompatImageView);
                        return;
                    }
                    return;
                }
            }
        }
        View view2 = this.viewBinding.E;
        if (view2 != null) {
            uf.c.k(view2);
        }
        AppCompatImageView appCompatImageView2 = this.viewBinding.j;
        if (appCompatImageView2 != null) {
            uf.c.k(appCompatImageView2);
        }
    }

    public static /* synthetic */ void setHeaderPostData$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderPostData");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        postBaseItemView.setHeaderPostData(postSubjectItem, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setHotComment(final PostSubjectItem item) {
        String str;
        ImageView imageView;
        final CommentBean hotComment = item.getHotComment();
        String content = hotComment != null ? hotComment.getContent() : null;
        if (content == null || content.length() == 0 || (this instanceof PostDetailItemView)) {
            BLConstraintLayout bLConstraintLayout = this.viewBinding.b;
            if (bLConstraintLayout != null) {
                uf.c.g(bLConstraintLayout);
                return;
            }
            return;
        }
        E(item);
        BLConstraintLayout bLConstraintLayout2 = this.viewBinding.b;
        if (bLConstraintLayout2 != null) {
            uf.c.k(bLConstraintLayout2);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.q;
        if (appCompatTextView != null) {
            appCompatTextView.setText(content);
        }
        String avatarUrl = hotComment.getAvatarUrl();
        String str2 = BuildConfig.FLAVOR;
        if (avatarUrl == null) {
            avatarUrl = BuildConfig.FLAVOR;
        }
        if (avatarUrl.length() > 0 && (imageView = this.viewBinding.f) != null) {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(avatarUrl).m(lj.a.b(20)).c(lj.a.b(20)).d(imageView);
        }
        List<Cover> imageList = hotComment.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            ShapeableImageView shapeableImageView = this.viewBinding.c;
            if (shapeableImageView != null) {
                uf.c.g(shapeableImageView);
            }
        } else {
            ImageView imageView2 = this.viewBinding.c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                f.a aVar2 = ni.f.a;
                Context context2 = imageView2.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m = aVar2.m(context2);
                List<Cover> imageList2 = hotComment.getImageList();
                Intrinsics.e(imageList2);
                Cover cover = imageList2.get(0);
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                m.g(str).m(lj.a.b(20)).c(lj.a.b(20)).d(imageView2);
            }
        }
        AppCompatTextView appCompatTextView2 = this.viewBinding.s;
        if (appCompatTextView2 != null) {
            if (hotComment.getLikeCnt() != 0) {
                str2 = com.transsion.baseui.util.j.a(hotComment.getLikeCnt());
            }
            appCompatTextView2.setText(str2);
        }
        AppCompatImageView appCompatImageView = this.viewBinding.h;
        if (appCompatImageView != null) {
            appCompatImageView.setEnabled(Intrinsics.c(hotComment.getLikeStatu(), Boolean.TRUE));
        }
        View view = this.viewBinding.B;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.t0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostBaseItemView.N(PostBaseItemView.this, hotComment, item, view2);
                }
            });
        }
        AppCompatActivity context3 = getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.view.u0
            public final Object invoke(Object obj) {
                Unit O;
                O = PostBaseItemView.O(CommentBean.this, this, (rm.b) obj);
                return O;
            }
        };
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = rm.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(context3, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
    }

    private final void setPostContent(PostSubjectItem item) {
        List image;
        setPostContentDes(item);
        Media media = item.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.c(mediaType, MediaType.TEXT.getValue())) {
            FrameLayout frameLayout = this.viewBinding.d;
            Intrinsics.g(frameLayout, "flContent");
            uf.c.g(frameLayout);
        } else if (Intrinsics.c(mediaType, MediaType.IMAGE.getValue())) {
            FrameLayout frameLayout2 = this.viewBinding.d;
            Intrinsics.g(frameLayout2, "flContent");
            Media media2 = item.getMedia();
            frameLayout2.setVisibility(((media2 == null || (image = media2.getImage()) == null) ? 0 : image.size()) > 0 ? 0 : 8);
            setPostImage(item);
        } else if (Intrinsics.c(mediaType, MediaType.AUDIO.getValue())) {
            FrameLayout frameLayout3 = this.viewBinding.d;
            Intrinsics.g(frameLayout3, "flContent");
            uf.c.g(frameLayout3);
        } else if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            FrameLayout frameLayout4 = this.viewBinding.d;
            Intrinsics.g(frameLayout4, "flContent");
            uf.c.k(frameLayout4);
            setPostVideo(item);
        } else {
            FrameLayout frameLayout5 = this.viewBinding.d;
            Intrinsics.g(frameLayout5, "flContent");
            uf.c.g(frameLayout5);
        }
        setHotComment(item);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        r4 = r3.viewBinding.u;
        kotlin.jvm.internal.Intrinsics.e(r4);
        com.transsion.baseui.util.l.e(r4, r1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        r3.viewBinding.u.post(new com.transsion.postdetail.ui.view.o0(r3, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if (r4 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r4 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        r4 = r3.viewBinding.u;
        kotlin.jvm.internal.Intrinsics.g(r4, "tvPostContent");
        uf.c.k(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (r3.isDetail == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setPostContentDes(PostSubjectItem item) {
        String title;
        String content = item.getContent();
        final String str = BuildConfig.FLAVOR;
        if (content == null || content.length() == 0) {
            String title2 = item.getTitle();
            if (title2 == null || title2.length() == 0) {
                AppCompatTextView appCompatTextView = this.viewBinding.u;
                Intrinsics.g(appCompatTextView, "tvPostContent");
                uf.c.g(appCompatTextView);
                return;
            }
            title = item.getTitle();
        } else {
            title = item.getContent();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setPostImage(PostSubjectItem item) {
        List image;
        List image2;
        Media media = item.getMedia();
        int size = (media == null || (image2 = media.getImage()) == null) ? 0 : image2.size();
        CardView cardView = this.viewBinding.o.c;
        Intrinsics.g(cardView, "flVideo");
        uf.c.g(cardView);
        if (size == 0) {
            NoScrollRecyclerView2 noScrollRecyclerView2 = this.viewBinding.p;
            Intrinsics.g(noScrollRecyclerView2, "recyclerViewPost");
            uf.c.g(noScrollRecyclerView2);
            return;
        }
        NoScrollRecyclerView2 noScrollRecyclerView22 = this.viewBinding.p;
        Intrinsics.g(noScrollRecyclerView22, "recyclerViewPost");
        uf.c.k(noScrollRecyclerView22);
        int i = 1;
        if (size != 1) {
            i = 2;
            if (size != 2 && size != 4) {
                i = 3;
            }
        }
        Media media2 = item.getMedia();
        if (media2 == null || (image = media2.getImage()) == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        RoomPostContentImageAdapter roomPostContentImageAdapter = new RoomPostContentImageAdapter(i, com.transsion.baseui.util.b.a(context), this.pageName, this.pageFrom, item);
        roomPostContentImageAdapter.R0(new a());
        NoScrollRecyclerView2 noScrollRecyclerView23 = this.viewBinding.p;
        RecyclerView.s sVar = this.rvPool;
        if (sVar != null) {
            noScrollRecyclerView23.setRecycledViewPool(sVar);
        }
        noScrollRecyclerView23.setLayoutManager(new NpaGridLayoutManager(noScrollRecyclerView23.getContext(), i));
        if (noScrollRecyclerView23.getItemDecorationCount() == 0) {
            noScrollRecyclerView23.addItemDecoration(new tf.a(lj.a.b(3), lj.a.b(3), 0, 0));
        }
        noScrollRecyclerView23.setAdapter(roomPostContentImageAdapter);
        roomPostContentImageAdapter.n1(image);
    }

    private final void setPostVideo(final PostSubjectItem item) {
        Video video;
        Integer duration;
        List video2;
        Video video3;
        Integer height;
        FirstFrame firstFrame;
        Integer height2;
        Cover cover;
        Integer height3;
        List video4;
        Video video5;
        Integer width;
        FirstFrame firstFrame2;
        Integer width2;
        Cover cover2;
        Integer width3;
        NoScrollRecyclerView2 noScrollRecyclerView2 = this.viewBinding.p;
        Intrinsics.g(noScrollRecyclerView2, "recyclerViewPost");
        uf.c.g(noScrollRecyclerView2);
        CardView cardView = this.viewBinding.o.c;
        Intrinsics.g(cardView, "flVideo");
        uf.c.k(cardView);
        ShapeableImageView shapeableImageView = this.viewBinding.o.d;
        Intrinsics.g(shapeableImageView, "ivCover");
        uf.c.k(shapeableImageView);
        BLTextView bLTextView = this.viewBinding.o.f;
        Intrinsics.g(bLTextView, "tvVideoDuration");
        uf.c.k(bLTextView);
        AppCompatImageView appCompatImageView = this.viewBinding.o.e;
        Intrinsics.g(appCompatImageView, "ivVideoPlay");
        uf.c.k(appCompatImageView);
        FrameLayout frameLayout = this.viewBinding.o.b;
        Intrinsics.g(frameLayout, "flPlayer");
        int i = 0;
        if (frameLayout.getChildCount() != 0) {
            View childAt = this.viewBinding.o.b.getChildAt(0);
            PostFeedVideoView postFeedVideoView = childAt instanceof PostFeedVideoView ? (PostFeedVideoView) childAt : null;
            if (postFeedVideoView != null) {
                postFeedVideoView.removePlayer();
            }
        }
        Media media = item.getMedia();
        int intValue = (media == null || (cover2 = media.getCover()) == null || (width3 = cover2.getWidth()) == null) ? 0 : width3.intValue();
        Media media2 = item.getMedia();
        int intValue2 = (media2 == null || (firstFrame2 = media2.getFirstFrame()) == null || (width2 = firstFrame2.getWidth()) == null) ? 0 : width2.intValue();
        Media media3 = item.getMedia();
        int intValue3 = (media3 == null || (video4 = media3.getVideo()) == null || (video5 = (Video) CollectionsKt.k0(video4)) == null || (width = video5.getWidth()) == null) ? 0 : width.intValue();
        int i2 = intValue > 0 ? intValue : intValue2 > 0 ? intValue2 : intValue3 > 0 ? intValue3 : 0;
        Media media4 = item.getMedia();
        int intValue4 = (media4 == null || (cover = media4.getCover()) == null || (height3 = cover.getHeight()) == null) ? 0 : height3.intValue();
        Media media5 = item.getMedia();
        int intValue5 = (media5 == null || (firstFrame = media5.getFirstFrame()) == null || (height2 = firstFrame.getHeight()) == null) ? 0 : height2.intValue();
        Media media6 = item.getMedia();
        int intValue6 = (media6 == null || (video2 = media6.getVideo()) == null || (video3 = (Video) CollectionsKt.k0(video2)) == null || (height = video3.getHeight()) == null) ? 0 : height.intValue();
        if (intValue <= 0) {
            intValue4 = intValue2 > 0 ? intValue5 : intValue3 > 0 ? intValue6 : 0;
        }
        final boolean z = intValue4 > i2;
        ViewGroup.LayoutParams layoutParams = this.viewBinding.o.c.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int b = i2 / intValue4 < 1 ? this.rootWidth - lj.a.b(38) : this.rootWidth;
        marginLayoutParams.width = b;
        int i3 = (intValue4 * b) / i2;
        if (i3 > (b * 36) / 26) {
            i3 = (b * 36) / 26;
        }
        marginLayoutParams.height = i3;
        this.viewBinding.o.c.setLayoutParams(marginLayoutParams);
        this.viewBinding.o.c.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.k0
            @Override // java.lang.Runnable
            public final void run() {
                PostBaseItemView.Q(item, this, z);
            }
        });
        BLTextView bLTextView2 = this.viewBinding.o.f;
        Media media7 = item.getMedia();
        List video6 = media7 != null ? media7.getVideo() : null;
        if ((video6 != null ? video6.size() : 0) <= 0) {
            Intrinsics.e(bLTextView2);
            uf.c.g(bLTextView2);
            return;
        }
        if (video6 != null && (video = (Video) video6.get(0)) != null && (duration = video.getDuration()) != null) {
            i = duration.intValue();
        }
        if (i <= 0) {
            Intrinsics.e(bLTextView2);
            uf.c.g(bLTextView2);
        } else {
            bLTextView2.setText(TimeUtilKt.p(i));
            Intrinsics.e(bLTextView2);
            uf.c.k(bLTextView2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final FragmentActivity B() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
        }
        return null;
    }

    protected void T(final Function0 onClickDownload, PostSubjectItem postSubjectItem) {
        Intrinsics.h(onClickDownload, "onClickDownload");
        View view = this.viewBinding.E;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostBaseItemView.U(onClickDownload, view2);
                }
            });
        }
    }

    protected final int getDp16() {
        return this.dp16;
    }

    protected final int getDp32() {
        return this.dp32;
    }

    protected final int getDp36() {
        return this.dp36;
    }

    protected final String getPageFrom() {
        return this.pageFrom;
    }

    protected final String getPageName() {
        return this.pageName;
    }

    protected final wn.s getViewBinding() {
        return this.viewBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        D();
    }

    public final void refreshLike(boolean like, PostSubjectItem item) {
        Intrinsics.h(item, "item");
        AppCompatTextView appCompatTextView = this.viewBinding.w;
        Stat stat = item.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (like) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(com.tn.lib.widget.R.drawable.ic_post_like_select, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(com.tn.lib.widget.R.drawable.ic_post_like, 0, 0, 0);
        }
    }

    public final void setBottomBarClick(PostSubjectItem postSubjectItem, Function0<Unit> onCLickLike, Function0<Unit> onCLickComment, Function0<Unit> onCLickShare, Function0<Unit> onCLickSubject, Function0<Unit> onCLickGroup, Function0<Unit> onClickDownload, Function0<Unit> onCLickHeader) {
        Intrinsics.h(onCLickLike, "onCLickLike");
        Intrinsics.h(onCLickComment, "onCLickComment");
        Intrinsics.h(onCLickShare, "onCLickShare");
        Intrinsics.h(onCLickSubject, "onCLickSubject");
        Intrinsics.h(onCLickGroup, "onCLickGroup");
        Intrinsics.h(onClickDownload, "onClickDownload");
        Intrinsics.h(onCLickHeader, "onCLickHeader");
        Z(onCLickLike, postSubjectItem);
        R(onCLickComment, postSubjectItem);
        d0(onCLickShare);
        T(onClickDownload, postSubjectItem);
        f0(onCLickSubject, postSubjectItem);
        b0(onCLickGroup, postSubjectItem);
        V(onCLickHeader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBottomRoomModuleData(PostSubjectItem item) {
        String str;
        Cover cover;
        Intrinsics.h(item, "item");
        AppCompatTextView appCompatTextView = this.viewBinding.n.g;
        Group group = item.getGroup();
        String str2 = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        if (item.getBuiltIn()) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostBaseItemView$setBottomRoomModuleData$1(item, this, null), 3, (Object) null);
            return;
        }
        f.a aVar = ni.f.a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b m = aVar.m(context);
        Group group2 = item.getGroup();
        if (group2 == null || (str = group2.getAvatar()) == null) {
            Group group3 = item.getGroup();
            if (group3 != null && (cover = group3.getCover()) != null) {
                str2 = cover.getUrl();
            }
            str = str2 == null ? BuildConfig.FLAVOR : str2;
        }
        f.b c = m.g(str).m(this.dp32).c(this.dp32);
        ShapeableImageView shapeableImageView = this.viewBinding.n.c;
        Intrinsics.g(shapeableImageView, "ivRoomCover");
        c.d(shapeableImageView);
    }

    public void setBottomSubjectAndRoomVisibility(boolean isShowSubject, boolean isShowRoom) {
        if (ij.g.a.b()) {
            BLLinearLayout root = this.viewBinding.n.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            root.setVisibility(isShowRoom ? 0 : 8);
            ConstraintLayout constraintLayout = this.viewBinding.n.b;
            Intrinsics.g(constraintLayout, "clSubjectContent");
            uf.c.g(constraintLayout);
            View view = this.viewBinding.n.m;
            Intrinsics.g(view, "vSubjectRoomLine");
            uf.c.g(view);
            LinearLayout linearLayout = this.viewBinding.n.f;
            Intrinsics.g(linearLayout, "llRoomTag");
            linearLayout.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        if (isShowSubject) {
            BLLinearLayout root2 = this.viewBinding.n.getRoot();
            Intrinsics.g(root2, "getRoot(...)");
            uf.c.k(root2);
            ConstraintLayout constraintLayout2 = this.viewBinding.n.b;
            Intrinsics.g(constraintLayout2, "clSubjectContent");
            uf.c.k(constraintLayout2);
            View view2 = this.viewBinding.n.m;
            Intrinsics.g(view2, "vSubjectRoomLine");
            view2.setVisibility(isShowRoom ? 0 : 8);
            LinearLayout linearLayout2 = this.viewBinding.n.f;
            Intrinsics.g(linearLayout2, "llRoomTag");
            linearLayout2.setVisibility(isShowRoom ? 0 : 8);
            return;
        }
        BLLinearLayout root3 = this.viewBinding.n.getRoot();
        Intrinsics.g(root3, "getRoot(...)");
        root3.setVisibility(isShowRoom ? 0 : 8);
        ConstraintLayout constraintLayout3 = this.viewBinding.n.b;
        Intrinsics.g(constraintLayout3, "clSubjectContent");
        uf.c.g(constraintLayout3);
        View view3 = this.viewBinding.n.m;
        Intrinsics.g(view3, "vSubjectRoomLine");
        uf.c.g(view3);
        LinearLayout linearLayout3 = this.viewBinding.n.f;
        Intrinsics.g(linearLayout3, "llRoomTag");
        linearLayout3.setVisibility(isShowRoom ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBottomSubjectModuleData(PostSubjectItem item) {
        String str;
        String str2;
        Cover cover;
        Cover cover2;
        String str3;
        Subject subject;
        String genre;
        List S0;
        String str4;
        Intrinsics.h(item, "item");
        boolean builtIn = item.getBuiltIn();
        String str5 = BuildConfig.FLAVOR;
        if (builtIn) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostBaseItemView$setBottomSubjectModuleData$1(item, this, null), 3, (Object) null);
        } else {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Subject subject2 = item.getSubject();
            if (subject2 == null || (cover2 = subject2.getCover()) == null || (str = cover2.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b c = m.g(str).m(this.dp32).c(this.dp32);
            Subject subject3 = item.getSubject();
            if (subject3 == null || (cover = subject3.getCover()) == null || (str2 = cover.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            f.b l = c.l(str2);
            ShapeableImageView shapeableImageView = this.viewBinding.n.d;
            Intrinsics.g(shapeableImageView, "ivSubjectCover");
            l.d(shapeableImageView);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.n.j;
        Subject subject4 = item.getSubject();
        if (subject4 == null || (str3 = subject4.getTitle()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        appCompatTextView.setText(str3);
        Subject subject5 = item.getSubject();
        this.viewBinding.n.e.setImageResource(com.transsion.flow.h.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = item.getSubject();
        Date l2 = com.blankj.utilcode.util.c0.l(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l2);
        this.viewBinding.n.h.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = item.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 != null && genre2.length() != 0 && (subject = item.getSubject()) != null && (genre = subject.getGenre()) != null && (S0 = StringsKt.S0(genre, new String[]{", "}, false, 0, 6, (Object) null)) != null && (str4 = (String) CollectionsKt.k0(S0)) != null) {
            str5 = str4;
        }
        AppCompatTextView appCompatTextView2 = this.viewBinding.n.i;
        Intrinsics.g(appCompatTextView2, "tvSubjectGenre");
        appCompatTextView2.setVisibility(str5.length() > 0 ? 0 : 8);
        AppCompatTextView appCompatTextView3 = this.viewBinding.n.i;
        Intrinsics.g(appCompatTextView3, "tvSubjectGenre");
        appCompatTextView3.setVisibility(str5.length() > 0 ? 0 : 8);
        this.viewBinding.n.i.setText(str5);
    }

    public final void setCommentCount(long count) {
        AppCompatTextView appCompatTextView;
        wn.s sVar = this.viewBinding;
        if (sVar == null || (appCompatTextView = sVar.t) == null) {
            return;
        }
        appCompatTextView.setText(count == 0 ? BuildConfig.FLAVOR : com.transsion.baseui.util.j.a(count));
    }

    public final void setCommentViewModel(CommentViewModel viewModel) {
        this.mCommentViewModel = viewModel;
    }

    public final void setContentMaxLine() {
        this.viewBinding.u.setMaxLines(Integer.MAX_VALUE);
    }

    public final void setData(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        setBottomDownLoadStatus(item);
        setHeaderData(item);
        setPostContent(item);
        setSubjectAndRoomContent(item);
        setBottomBarContent(item);
    }

    public abstract void setHeaderData(PostSubjectItem item);

    /* JADX WARN: Multi-variable type inference failed */
    public void setHeaderPostData(PostSubjectItem item, boolean showDistance) {
        String str;
        String poiName;
        Long x;
        String nickname;
        Intrinsics.h(item, "item");
        boolean builtIn = item.getBuiltIn();
        String str2 = BuildConfig.FLAVOR;
        if (builtIn) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostBaseItemView$setHeaderPostData$1(item, this, null), 3, (Object) null);
        } else {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            User user = item.getUser();
            if (user == null || (str = user.getAvatar()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b c = m.g(str).m(this.dp16).c(this.dp16);
            ShapeableImageView shapeableImageView = this.viewBinding.m;
            Intrinsics.g(shapeableImageView, "ivUserAvatar2");
            c.d(shapeableImageView);
        }
        AppCompatTextView appCompatTextView = this.viewBinding.y;
        User user2 = item.getUser();
        if (user2 != null && (nickname = user2.getNickname()) != null) {
            str2 = nickname;
        }
        appCompatTextView.setText(str2);
        AppCompatTextView appCompatTextView2 = this.viewBinding.v;
        String createdAt = item.getCreatedAt();
        appCompatTextView2.setText(com.transsion.postdetail.util.m.b((createdAt == null || (x = StringsKt.x(createdAt)) == null) ? 0L : x.longValue()));
        View view = this.viewBinding.C;
        Intrinsics.g(view, "vLocationLine");
        uf.c.g(view);
        String poiName2 = item.getPoiName();
        if (poiName2 == null || poiName2.length() == 0) {
            AppCompatImageView appCompatImageView = this.viewBinding.i;
            Intrinsics.g(appCompatImageView, "ivLocationIcon");
            uf.c.g(appCompatImageView);
            AppCompatTextView appCompatTextView3 = this.viewBinding.z;
            Intrinsics.g(appCompatTextView3, "tvUserNameOrLocation");
            uf.c.g(appCompatTextView3);
            return;
        }
        AppCompatTextView appCompatTextView4 = this.viewBinding.z;
        Intrinsics.g(appCompatTextView4, "tvUserNameOrLocation");
        uf.c.k(appCompatTextView4);
        AppCompatImageView appCompatImageView2 = this.viewBinding.i;
        Intrinsics.g(appCompatImageView2, "ivLocationIcon");
        uf.c.k(appCompatImageView2);
        String distanceStr = item.getDistanceStr();
        if (distanceStr == null || distanceStr.length() == 0 || !showDistance) {
            poiName = item.getPoiName();
        } else {
            poiName = item.getPoiName() + " " + item.getDistanceStr();
        }
        this.viewBinding.z.setText(poiName);
    }

    public final void setIsDetail(boolean isDetail) {
        this.isDetail = isDetail;
    }

    public final void setPage(String pageName, String pageFrom) {
        this.pageName = pageName;
        this.pageFrom = pageFrom;
    }

    protected final void setPageFrom(String str) {
        this.pageFrom = str;
    }

    protected final void setPageName(String str) {
        this.pageName = str;
    }

    public final void setRecycledViewPool(RecyclerView.s rvPool) {
        Intrinsics.h(rvPool, "rvPool");
        this.rvPool = rvPool;
    }

    public abstract void setSubjectAndRoomContent(PostSubjectItem item);
}
