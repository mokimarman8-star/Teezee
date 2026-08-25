package com.transsion.home.adapter.operateUGC.provider;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FeedsBigUGCProvider extends com.transsion.home.adapter.trending.provider.b {
    private final int e;
    private final int f = com.blankj.utilcode.util.y.e() - (com.blankj.utilcode.util.a0.a(12.0f) * 2);
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.e
        public final Object invoke() {
            rk.d I;
            I = FeedsBigUGCProvider.I(FeedsBigUGCProvider.this);
            return I;
        }
    });

    public FeedsBigUGCProvider(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(OperateItem operateItem, FeedsBigUGCProvider feedsBigUGCProvider, BaseViewHolder baseViewHolder, View view) {
        UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
        if (feedsUGCVideo != null) {
            Integer valueOf = Integer.valueOf(feedsBigUGCProvider.e);
            String opId = operateItem.getOpId();
            if (opId == null) {
                OperateItem originalOperateItem = operateItem.getOriginalOperateItem();
                opId = originalOperateItem != null ? originalOperateItem.getOpId() : null;
            }
            gu.c.h(feedsUGCVideo, valueOf, opId);
        }
        rk.d.c.c(baseViewHolder.getLayoutPosition(), operateItem, feedsBigUGCProvider.e);
    }

    private final rk.d H() {
        return (rk.d) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rk.d I(FeedsBigUGCProvider feedsBigUGCProvider) {
        return new rk.d(SubTabFragment.INSTANCE.a(feedsBigUGCProvider.e));
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        String ugcVideoId;
        String j;
        List q;
        String nickname;
        String str;
        String str2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ((RecyclerView.a0) baseViewHolder).itemView.setTag("UGCFeedsBig");
        UGCVideo feedsUGCVideo = operateItem.getFeedsUGCVideo();
        if (feedsUGCVideo == null || (ugcVideoId = feedsUGCVideo.getUgcVideoId()) == null || ugcVideoId.length() == 0) {
            return;
        }
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R.id.main_op_trending_grid_image);
        String str3 = BuildConfig.FLAVOR;
        if (viewOrNull != null) {
            if (feedsUGCVideo.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new FeedsBigUGCProvider$convert$1$1(feedsUGCVideo, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = feedsUGCVideo.getCover();
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b m2 = m.g(str).m(this.f);
                Cover cover2 = feedsUGCVideo.getCover();
                if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                m2.l(str2).i(com.transsion.wrapperad.R.color.module_01).d(viewOrNull);
            }
        }
        TextView textView = (TextView) baseViewHolder.getViewOrNull(R.id.main_op_trending_grid_title);
        if (textView != null) {
            textView.setText(feedsUGCVideo.getTitle());
        }
        baseViewHolder.setText(R.id.main_op_trending_grid_corner, feedsUGCVideo.getCorner());
        ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(R.id.main_op_trending_grid_type_icon);
        if (imageView != null) {
            UGCVideoTypeKt.i(imageView, feedsUGCVideo, (Integer) null, 4, (Object) null);
        }
        baseViewHolder.setText(R.id.main_op_trending_grid_time_text, feedsUGCVideo.getTimeOrCount(k()));
        baseViewHolder.setText(R.id.main_op_trending_grid_title, feedsUGCVideo.getTitle());
        if (feedsUGCVideo.isVerticalImmStyle()) {
            q = CollectionsKt.q(new String[]{"special_#shorts_icon", Utils.a().getString(com.transsion.baseui.R.string.ugc_video_shorts), com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k())});
        } else {
            if (HomeTabId.INSTANCE.h(Integer.valueOf(this.e), false)) {
                UGCVideoCreator creator = feedsUGCVideo.getCreator();
                String nickname2 = creator != null ? creator.getNickname() : null;
                if (nickname2 != null && nickname2.length() != 0) {
                    String c = com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k());
                    UGCVideoCreator creator2 = feedsUGCVideo.getCreator();
                    if (creator2 != null && (nickname = creator2.getNickname()) != null) {
                        str3 = nickname;
                    }
                    q = CollectionsKt.q(new String[]{c, "special_#user_icon", str3});
                }
            }
            String c2 = com.transsion.baseui.util.j.c(feedsUGCVideo.getWatchNum(), k());
            if (this.e == HomeTabId.UGC_Trending.getValue()) {
                Long publishTime = feedsUGCVideo.getPublishTime();
                j = TimeUtilKt.k(publishTime != null ? publishTime.longValue() : 0L);
            } else {
                Long publishTime2 = feedsUGCVideo.getPublishTime();
                j = TimeUtilKt.j(publishTime2 != null ? publishTime2.longValue() : 0L);
            }
            q = CollectionsKt.q(new String[]{c2, j});
        }
        baseViewHolder.setText(R.id.main_op_trending_grid_subtitle, com.transsion.baseui.util.q.e(q, k()));
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsBigUGCProvider.G(OperateItem.this, this, baseViewHolder, view);
            }
        });
        if (this.e != HomeTabId.UGC_Trending.getValue()) {
            H().a(operateItem, baseViewHolder.getLayoutPosition(), 0L);
        }
    }

    public int l() {
        return PostItemType.TRENDING_FEES_BIG.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_item_big;
    }
}
