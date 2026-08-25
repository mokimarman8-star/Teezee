package com.transsion.usercenter.message.adapter;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.UserMessageType;
import com.transsion.usercenter.message.bean.MessageEntity;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fv.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import okhttp3.HttpUrl;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/transsion/usercenter/message/adapter/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/usercenter/message/bean/MessageEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", HttpUrl.FRAGMENT_ENCODE_SET, "layoutResId", "<init>", "(I)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/usercenter/message/bean/MessageEntity;)V", HttpUrl.FRAGMENT_ENCODE_SET, "type", "D1", "(Ljava/lang/String;)Ljava/lang/String;", "C1", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends BaseQuickAdapter implements i {
    public b() {
        this(0, 1, null);
    }

    public b(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ b(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.item_room_message : i);
    }

    private final void B1(BaseViewHolder holder, MessageEntity item) {
        String url;
        ShapeableImageView view = holder.getView(R$id.iv_avatar);
        Intrinsics.f(view, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
        holder.setText(R$id.tv_avatar, item.getNickname());
        int i = R$id.tv_date;
        b.a aVar = fv.b.a;
        holder.setText(i, aVar.b(Long.parseLong(item.getCreatedAt())));
        f.a aVar2 = f.a;
        aVar2.m(getContext()).g(item.getAvator()).d(view);
        AppCompatTextView view2 = holder.getView(R$id.tv_content);
        String content = item.getContent();
        if (content == null || content.length() == 0) {
            view2.setVisibility(8);
        } else {
            view2.setText(item.getContent());
            view2.setVisibility(0);
        }
        ShapeableImageView view3 = holder.getView(R$id.comment_cover);
        List<Image> commentImages = item.getCommentImages();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (commentImages == null || !(!commentImages.isEmpty())) {
            view3.setVisibility(8);
        } else {
            view3.setVisibility(0);
            Context context = view3.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar2.m(context);
            List<Image> commentImages2 = item.getCommentImages();
            Intrinsics.e(commentImages2);
            String url2 = commentImages2.get(0).getUrl();
            if (url2 == null) {
                url2 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            m.g(url2).d(view3);
        }
        holder.setText(R$id.tv_date, D1(item.getType()) + " " + aVar.b(Long.parseLong(item.getCreatedAt())));
        ShapeableImageView view4 = holder.getView(R$id.iv_comment);
        Cover image = item.getImage();
        String url3 = image != null ? image.getUrl() : null;
        if (url3 == null || url3.length() == 0) {
            view4.setVisibility(8);
        } else {
            f.b m2 = aVar2.m(getContext());
            Cover image2 = item.getImage();
            if (image2 != null && (url = image2.getUrl()) != null) {
                str = url;
            }
            m2.g(str).d(view4);
            view4.setVisibility(0);
        }
        holder.setVisible(R$id.view_red_blank, Intrinsics.c(item.getStatus(), "UNREAD"));
        if (Intrinsics.c(item.getStatus(), "UNREAD")) {
            ((RecyclerView.a0) holder).itemView.setBackgroundColor(androidx.core.content.b.getColor(getContext(), R.color.white_10));
        } else {
            ((RecyclerView.a0) holder).itemView.setBackgroundColor(0);
        }
    }

    private final String D1(String type) {
        if (Intrinsics.c(type, UserMessageType.LIKE.getValue())) {
            String string = getContext().getString(R$string.message_like_type);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (Intrinsics.c(type, UserMessageType.LIKE_COMMENT.getValue())) {
            String string2 = getContext().getString(R$string.message_like_comment_type);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (Intrinsics.c(type, UserMessageType.COMMENT.getValue())) {
            String string3 = getContext().getString(R$string.message_comment_type);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        if (!Intrinsics.c(type, UserMessageType.REPLY_COMMENT.getValue())) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String string4 = getContext().getString(R$string.message_reply_comment_type);
        Intrinsics.g(string4, "getString(...)");
        return string4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, MessageEntity item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        B1(holder, item);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
