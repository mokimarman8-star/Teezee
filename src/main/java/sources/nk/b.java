package nk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.hashtag.a;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    private final a.InterfaceC0027a e;
    private int f;

    public b(a.InterfaceC0027a interfaceC0027a) {
        Intrinsics.h(interfaceC0027a, "callbacks");
        this.e = interfaceC0027a;
        this.f = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(b bVar, UGCVideo uGCVideo, BaseViewHolder baseViewHolder, View view) {
        bVar.e.a(uGCVideo, baseViewHolder.getBindingAdapterPosition());
    }

    public int l() {
        return HashTagItemType.HASHTAG_CARD.ordinal();
    }

    public int m() {
        return R.layout.ugc_item_hashtag_subject;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, HashTagItem hashTagItem) {
        String str;
        String str2;
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(hashTagItem, "item");
        final UGCVideo ugcVideo = hashTagItem.getUgcVideo();
        if (ugcVideo == null) {
            return;
        }
        a0.a(107.0f);
        a0.a(149.0f);
        boolean z = true;
        int a = a0.a(((this.f - 1) * 8.0f) + 24.0f);
        int e = y.e();
        int i = (e - a) / this.f;
        int a2 = a0.a(((r5 - 1) * 8.0f) + 24.0f);
        a0.a(109.0f);
        a0.a(109.0f);
        int i2 = e - a2;
        int i3 = i2 / this.f;
        int a3 = a0.a(164.0f);
        int a4 = a0.a(92.0f);
        int i4 = i2 / this.f;
        int i5 = (int) (i4 * ((a4 * 1.0f) / a3));
        ((FrameLayout) baseViewHolder.getView(R.id.nativeView)).setVisibility(8);
        baseViewHolder.getView(R.id.group).setVisibility(0);
        ShapeableImageView view = baseViewHolder.getView(R.id.iv_cover);
        View view2 = baseViewHolder.getView(R.id.cover_container);
        ugcVideo.getCategory();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = i5;
        ((ViewGroup.MarginLayoutParams) bVar).width = i4;
        view2.setLayoutParams(bVar);
        f.b m = f.a.m(k());
        Cover cover = ugcVideo.getCover();
        String str3 = BuildConfig.FLAVOR;
        if (cover == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g = m.g(str);
        Cover cover2 = ugcVideo.getCover();
        if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        g.l(str2).i(com.tn.lib.widget.R.color.cl37).m(i4).c(i5).d(view);
        int i6 = R.id.tv_title;
        String title = ugcVideo.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        baseViewHolder.setText(i6, title);
        baseViewHolder.setText(R.id.tv_views, j.c(ugcVideo.getWatchNum(), k()));
        Long publishTime = ugcVideo.getPublishTime();
        long longValue = publishTime != null ? publishTime.longValue() : 0L;
        String j = longValue > 0 ? TimeUtilKt.j(longValue) : BuildConfig.FLAVOR;
        if (j.length() == 0) {
            baseViewHolder.setText(R.id.tv_type, BuildConfig.FLAVOR);
            baseViewHolder.setVisible(R.id.separator, false);
        } else {
            baseViewHolder.setText(R.id.tv_type, j);
            baseViewHolder.setVisible(R.id.separator, true);
        }
        UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R.id.iv_res_post_type), ugcVideo, (Integer) null, 4, (Object) null);
        Long duration = ugcVideo.getDuration();
        baseViewHolder.setText(R.id.tv_duration, TimeUtilKt.r(duration != null ? duration.longValue() : 0L));
        String corner = ugcVideo.getCorner();
        View view3 = baseViewHolder.getView(R.id.tag_audio);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audio_tag);
        if (corner != null && !StringsKt.q0(corner)) {
            z = false;
        }
        view3.setVisibility(z ? 8 : 0);
        String corner2 = ugcVideo.getCorner();
        if (corner2 != null) {
            str3 = corner2;
        }
        textView.setText(str3);
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: nk.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                b.A(b.this, ugcVideo, baseViewHolder, view4);
            }
        });
    }
}
