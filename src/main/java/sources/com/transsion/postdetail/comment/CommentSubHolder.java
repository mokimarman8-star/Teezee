package com.transsion.postdetail.comment;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R$id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import ni.f;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010 \u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010$R\u0018\u0010.\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010'R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010'R\u0018\u00106\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010'R\u0018\u00108\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010-R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010:¨\u0006<"}, d2 = {"Lcom/transsion/postdetail/comment/CommentSubHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsion/postdetail/comment/h0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "text", "target", "Landroid/text/SpannableString;", "k", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "Landroid/widget/TextView;", "textView", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "r", "(Landroid/widget/TextView;I)V", "Landroid/content/Context;", "context", "position", BuildConfig.FLAVOR, "Lcom/transsion/moviedetailapi/bean/Image;", "imageList", "q", "(Landroid/content/Context;ILjava/util/List;)V", "Lp6/a;", "info", "Lcom/transsion/postdetail/comment/g0;", "clickListener", "d", "(ILp6/a;Lcom/transsion/postdetail/comment/g0;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "mAvatarView", "b", "Landroid/widget/TextView;", "mUserNameTV", "c", "mCommentContentTV", "mLikeView", "e", "Landroid/view/View;", "mLikeClickView", "f", "mReplyArrowIv", "g", "mReplyUserNameTv", "h", "mLikeCountTV", "i", "mCommentDataTV", "j", "mReplyView", "Lcom/google/android/material/imageview/ShapeableImageView;", "Lcom/google/android/material/imageview/ShapeableImageView;", "mSubCommentCover", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CommentSubHolder extends BaseViewHolder implements h0 {

    /* renamed from: a, reason: from kotlin metadata */
    private ImageView mAvatarView;

    /* renamed from: b, reason: from kotlin metadata */
    private TextView mUserNameTV;

    /* renamed from: c, reason: from kotlin metadata */
    private TextView mCommentContentTV;

    /* renamed from: d, reason: from kotlin metadata */
    private ImageView mLikeView;

    /* renamed from: e, reason: from kotlin metadata */
    private View mLikeClickView;

    /* renamed from: f, reason: from kotlin metadata */
    private View mReplyArrowIv;

    /* renamed from: g, reason: from kotlin metadata */
    private TextView mReplyUserNameTv;

    /* renamed from: h, reason: from kotlin metadata */
    private TextView mLikeCountTV;

    /* renamed from: i, reason: from kotlin metadata */
    private TextView mCommentDataTV;

    /* renamed from: j, reason: from kotlin metadata */
    private View mReplyView;

    /* renamed from: k, reason: from kotlin metadata */
    private ShapeableImageView mSubCommentCover;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentSubHolder(View view) {
        super(view);
        Intrinsics.h(view, "view");
        this.mAvatarView = (ImageView) view.findViewById(R$id.item_comment_sub_user_avatar);
        this.mUserNameTV = (TextView) view.findViewById(R$id.item_comment_sub_user_name);
        this.mCommentContentTV = (TextView) view.findViewById(R$id.item_comment_sub_content);
        this.mLikeView = (ImageView) view.findViewById(R$id.item_comment_sub_like_icon);
        this.mLikeCountTV = (TextView) view.findViewById(R$id.item_comment_sub_like_count);
        this.mCommentDataTV = (TextView) view.findViewById(R$id.item_comment_sub_data);
        this.mReplyView = view.findViewById(R$id.item_comment_sub_reply);
        this.mReplyArrowIv = view.findViewById(R$id.iv_comment_reply);
        this.mReplyUserNameTv = (TextView) view.findViewById(R$id.tv_comment_sub_reply_user_name);
        this.mLikeClickView = view.findViewById(R$id.item_comment_sub_like_click_bg);
        this.mSubCommentCover = view.findViewById(R$id.sub_comment_cover);
        ImageView imageView = this.mAvatarView;
        if (imageView != null) {
            imageView.setClipToOutline(true);
            imageView.setOutlineProvider(new com.transsion.baseui.widget.i(com.blankj.utilcode.util.a0.a(10.0f)));
        }
    }

    private final SpannableString k(String text, String target) {
        int o0 = StringsKt.o0(text, target, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(text);
        if (o0 >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.white_60)), o0, target.length() + o0, 33);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(p6.a aVar, CommentSubHolder commentSubHolder, View view) {
        ArrayList arrayList = new ArrayList();
        List<Cover> imageList = ((CommentBean) aVar).getImageList();
        if (imageList != null) {
            for (Cover cover : imageList) {
                Image image = new Image((Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (GifBean) null, (String) null, (String) null, 0.0f, 0.0f, 0, 0, 0, 16383, (DefaultConstructorMarker) null);
                image.setUrl(cover != null ? cover.getUrl() : null);
                arrayList.add(image);
            }
        }
        Context context = ((RecyclerView.a0) commentSubHolder).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        commentSubHolder.q(context, 1, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(g0 g0Var, p6.a aVar, View view) {
        if (g0Var != null) {
            g0Var.R((CommentBean) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CommentSubHolder commentSubHolder, g0 g0Var, p6.a aVar, View view) {
        if (!yg.l.a.e()) {
            fh.b.a.d(com.transsion.postdetail.R.string.base_net_err);
            return;
        }
        ImageView imageView = commentSubHolder.mLikeView;
        if (imageView != null) {
            if (imageView.isEnabled()) {
                imageView.setEnabled(false);
                TextView textView = commentSubHolder.mLikeCountTV;
                if (textView != null) {
                    textView.setEnabled(false);
                }
                CommentBean commentBean = (CommentBean) aVar;
                commentBean.setLikeStatu(Boolean.FALSE);
                if (commentBean.getLikeCnt() > 0) {
                    commentBean.setLikeCnt(commentBean.getLikeCnt() - 1);
                }
            } else {
                imageView.setEnabled(true);
                CommentBean commentBean2 = (CommentBean) aVar;
                commentBean2.setLikeStatu(Boolean.TRUE);
                commentBean2.setLikeCnt(commentBean2.getLikeCnt() + 1);
                TextView textView2 = commentSubHolder.mLikeCountTV;
                if (textView2 != null) {
                    textView2.setEnabled(true);
                }
            }
            commentSubHolder.r(commentSubHolder.mLikeCountTV, ((CommentBean) aVar).getLikeCnt());
        }
        if (g0Var != null) {
            g0Var.A((CommentBean) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g0 g0Var, p6.a aVar, View view) {
        if (g0Var != null) {
            g0Var.H((CommentBean) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(g0 g0Var, p6.a aVar, View view) {
        if (g0Var == null) {
            return true;
        }
        g0Var.Q((CommentBean) aVar);
        return true;
    }

    private final void q(Context context, int position, List imageList) {
        Intent intent = new Intent(context, (Class<?>) GifImagePreviewActivity.class);
        Intrinsics.f(imageList, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) imageList);
        intent.putExtra("CURRENT_ITEM", position);
        context.startActivity(intent);
    }

    private final void r(TextView textView, int count) {
        if (textView != null) {
            textView.setText(count > 0 ? t.a.a(count) : BuildConfig.FLAVOR);
        }
    }

    @Override // com.transsion.postdetail.comment.h0
    public void d(int position, final p6.a info, final g0 clickListener) {
        String replyedNickName;
        String str;
        if (info instanceof CommentBean) {
            CommentBean commentBean = (CommentBean) info;
            ImageView imageView = this.mAvatarView;
            String str2 = BuildConfig.FLAVOR;
            if (imageView != null) {
                f.a aVar = ni.f.a;
                Context context = imageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                String avatarUrl = commentBean.getAvatarUrl();
                if (avatarUrl == null) {
                    avatarUrl = BuildConfig.FLAVOR;
                }
                m.g(avatarUrl).d(imageView);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentSubHolder.m(g0.this, info, view);
                    }
                });
            }
            if (commentBean.getImageList() == null || !(!r0.isEmpty())) {
                ShapeableImageView shapeableImageView = this.mSubCommentCover;
                if (shapeableImageView != null) {
                    shapeableImageView.setVisibility(8);
                }
            } else {
                ImageView imageView2 = this.mSubCommentCover;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    f.a aVar2 = ni.f.a;
                    Context context2 = imageView2.getContext();
                    Intrinsics.g(context2, "getContext(...)");
                    f.b m2 = aVar2.m(context2);
                    List<Cover> imageList = commentBean.getImageList();
                    Intrinsics.e(imageList);
                    Cover cover = imageList.get(0);
                    if (cover == null || (str = cover.getUrl()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    m2.g(str).d(imageView2);
                }
            }
            TextView textView = this.mUserNameTV;
            if (textView != null) {
                String nickName = commentBean.getNickName();
                if (nickName == null) {
                    nickName = BuildConfig.FLAVOR;
                }
                textView.setText(nickName);
            }
            TextView textView2 = this.mCommentContentTV;
            if (textView2 != null) {
                com.transsion.baseui.util.l.e(textView2, commentBean.getContent(), null);
                if (commentBean.getRootCommentId() == null || Intrinsics.c(commentBean.getRootCommentId(), commentBean.getReplyedCommentId()) || (replyedNickName = commentBean.getReplyedNickName()) == null || replyedNickName.length() == 0 || Intrinsics.c(commentBean.getReplyedCommentId(), "0")) {
                    textView2.setText(commentBean.getContent());
                } else {
                    String str3 = textView2.getContext().getString(com.transsion.postdetail.R.string.comment_reply) + " " + commentBean.getReplyedNickName() + " " + commentBean.getContent();
                    String replyedNickName2 = commentBean.getReplyedNickName();
                    if (replyedNickName2 != null) {
                        str2 = replyedNickName2;
                    }
                    textView2.setText(k(str3, str2));
                }
            }
            r(this.mLikeCountTV, commentBean.getLikeCnt());
            ImageView imageView3 = this.mLikeView;
            if (imageView3 != null) {
                Boolean likeStatu = commentBean.getLikeStatu();
                imageView3.setEnabled(likeStatu != null ? likeStatu.booleanValue() : false);
            }
            TextView textView3 = this.mCommentDataTV;
            if (textView3 != null) {
                t tVar = t.a;
                Context context3 = ((RecyclerView.a0) this).itemView.getContext();
                Intrinsics.g(context3, "getContext(...)");
                Long createdAt = commentBean.getCreatedAt();
                textView3.setText(tVar.c(context3, createdAt != null ? createdAt.longValue() : 0L));
            }
            View view = this.mLikeClickView;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommentSubHolder.n(CommentSubHolder.this, clickListener, info, view2);
                    }
                });
            }
            ((RecyclerView.a0) this).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentSubHolder.o(g0.this, info, view2);
                }
            });
            ((RecyclerView.a0) this).itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsion.postdetail.comment.y
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean p;
                    p = CommentSubHolder.p(g0.this, info, view2);
                    return p;
                }
            });
            ShapeableImageView shapeableImageView2 = this.mSubCommentCover;
            if (shapeableImageView2 != null) {
                shapeableImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommentSubHolder.l(info, this, view2);
                    }
                });
            }
        }
    }
}
