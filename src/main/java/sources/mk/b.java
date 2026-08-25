package mk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.UGCFilterVideoItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import ij.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import uf.c;
import zk.k;
import zk.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    public static final a k = new a(null);
    public static final int l = 8;
    private final rk.b e;
    private LayoutStyle f;
    private final int g;
    private boolean h;
    private final int i = 1;
    private final int j = R.layout.ugc_item_filter_source;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(rk.b bVar, LayoutStyle layoutStyle, int i, boolean z) {
        this.e = bVar;
        this.f = layoutStyle;
        this.g = i;
        this.h = z;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public void v(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.h(baseViewHolder, "viewHolder");
        super.v(baseViewHolder, i);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, UGCFilterVideoItem uGCFilterVideoItem) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(uGCFilterVideoItem, "item");
        ((FrameLayout) baseViewHolder.getView(R.id.nativeView)).setVisibility(8);
        baseViewHolder.getView(R.id.group).setVisibility(0);
        UGCVideo video = uGCFilterVideoItem.getContent().getVideo();
        if (video == null) {
            return;
        }
        String category = video.getCategory();
        ShapeableImageView view = baseViewHolder.getView(R.id.iv_cover);
        View view2 = baseViewHolder.getView(R.id.cover_container);
        k a2 = l.a.a(this.g, this.f, category);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = a2.a();
        view2.setLayoutParams(bVar);
        f.a aVar = f.a;
        f.b m = aVar.m(k());
        Cover cover = video.getCover();
        String str5 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b c = m.g(str).i(com.tn.lib.widget.R.color.cl37).m(a2.b()).c(a2.a());
        Cover cover2 = video.getCover();
        if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        c.l(str2).d(view);
        int i = R.id.tv_title;
        String title = video.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        baseViewHolder.setText(i, title);
        baseViewHolder.setText(R.id.tv_views, j.c(video.getWatchNum(), k()));
        boolean z = true;
        if (!this.h || o.a.i()) {
            Long publishTime = video.getPublishTime();
            long longValue = publishTime != null ? publishTime.longValue() : 0L;
            String j = longValue > 0 ? TimeUtilKt.j(longValue) : BuildConfig.FLAVOR;
            if (j.length() == 0) {
                baseViewHolder.setVisible(R.id.separator, false);
                baseViewHolder.setText(R.id.tv_type, BuildConfig.FLAVOR);
            } else {
                baseViewHolder.setVisible(R.id.separator, true);
                baseViewHolder.setText(R.id.tv_type, j);
            }
            c.k(baseViewHolder.getView(R.id.iv_res_post_type));
            UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R.id.iv_res_post_type), video, (Integer) null, 4, (Object) null);
            baseViewHolder.setGone(R.id.iv_upload_user_icon, true);
        } else {
            baseViewHolder.setGone(R.id.iv_res_post_type, true);
            baseViewHolder.setVisible(R.id.iv_upload_user_icon, true);
            f.b m2 = aVar.m(k());
            UGCVideoCreator creator = video.getCreator();
            if (creator == null || (str3 = creator.getAvatar()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            m2.g(str3).i(R$drawable.icon_ugc_user_upload).d((ImageView) baseViewHolder.getView(R.id.iv_upload_user_icon));
            int i2 = R.id.tv_type;
            UGCVideoCreator creator2 = video.getCreator();
            if (creator2 == null || (str4 = creator2.getNickname()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            baseViewHolder.setText(i2, str4);
            baseViewHolder.setVisible(R.id.separator, true);
        }
        baseViewHolder.setText(R.id.tv_duration, video.getTimeOrCount(k()));
        String corner = video.getCorner();
        View view3 = baseViewHolder.getView(R.id.tag_audio);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audio_tag);
        if (corner != null && !StringsKt.q0(corner)) {
            z = false;
        }
        view3.setVisibility(z ? 8 : 0);
        String corner2 = video.getCorner();
        if (corner2 != null) {
            str5 = corner2;
        }
        textView.setText(str5);
    }

    public final void z(boolean z) {
        this.h = z;
    }
}
