package com.transsion.postdetail.comment.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.util.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/transsion/postdetail/comment/ui/a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "Lt6/i;", "<init>", "()V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseProviderMultiAdapter<CommentBean> implements i {

    /* renamed from: com.transsion.postdetail.comment.ui.a$a, reason: collision with other inner class name */
    public static final class C0048a extends BaseItemProvider {
        private final int e = a0.a(32.0f);
        private final int f = a0.a(51.0f);
        private final int g = a0.a(34.0f);

        public int l() {
            return 0;
        }

        public int m() {
            return R$layout.item_my_comment_list_layout;
        }

        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, CommentBean commentBean) {
            Cover cover;
            Intrinsics.h(baseViewHolder, "helper");
            Intrinsics.h(commentBean, "item");
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.avatarIV);
            f.a aVar = f.a;
            f.b m = aVar.m(k());
            String avatarUrl = commentBean.getAvatarUrl();
            String str = BuildConfig.FLAVOR;
            if (avatarUrl == null) {
                avatarUrl = BuildConfig.FLAVOR;
            }
            m.g(avatarUrl).m(this.e).c(this.e).d(imageView);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R$id.contentIV);
            imageView2.setImageResource(0);
            List<Cover> imageList = commentBean.getImageList();
            if (imageList != null && (cover = (Cover) CollectionsKt.k0(imageList)) != null) {
                f.b m2 = aVar.m(k());
                String url = cover.getUrl();
                if (url == null) {
                    url = BuildConfig.FLAVOR;
                }
                f.b c = m2.g(url).m(this.f).c(this.g);
                String thumbnail = cover.getThumbnail();
                if (thumbnail != null) {
                    str = thumbnail;
                }
                c.l(str).d(imageView2);
            }
            baseViewHolder.setText(R$id.nameTV, commentBean.getNickName());
            baseViewHolder.setText(R$id.commentTV, commentBean.getContent());
            TextView textView = (TextView) baseViewHolder.getView(R$id.timeTV);
            Long createdAt = commentBean.getCreatedAt();
            if (createdAt != null) {
                textView.setText(k().getString(R.string.comment_post_time, m.b(createdAt.longValue())));
            }
            textView.setVisibility(createdAt != null ? 0 : 8);
        }
    }

    public a() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        F1(new C0048a());
    }

    protected int N1(List<CommentBean> data, int position) {
        Intrinsics.h(data, "data");
        return 0;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
