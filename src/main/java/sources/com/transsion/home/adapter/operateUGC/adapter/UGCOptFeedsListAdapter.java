package com.transsion.home.adapter.operateUGC.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$dimen;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import ij.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import rk.d;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/UGCOptFeedsListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCContent;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsion/home/bean/OperateItem;", "operateItem", BuildConfig.FLAVOR, "tabId", "<init>", "(Lcom/transsion/home/bean/OperateItem;I)V", "holder", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "ugcVideo", BuildConfig.FLAVOR, "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "item", "pos", "G1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "F1", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ugcvideodetail/api/bean/UGCContent;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCOptFeedsListAdapter extends BaseQuickAdapter {
    public static final int H = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    public UGCOptFeedsListAdapter(OperateItem operateItem, int i) {
        super(R.layout.item_ugc_feeds_list, (List) null, 2, (DefaultConstructorMarker) null);
        this.operateItem = operateItem;
        this.tabId = i;
    }

    private final void C1(BaseViewHolder holder, UGCVideo ugcVideo) {
        RecyclerView viewOrNull = holder.getViewOrNull(R.id.recyclerTag);
        if (viewOrNull == null) {
            return;
        }
        List filteredHashTags = ugcVideo.getFilteredHashTags();
        List list = filteredHashTags;
        if (list == null || list.isEmpty()) {
            viewOrNull.setAdapter((RecyclerView.Adapter) null);
            viewOrNull.setVisibility(8);
            return;
        }
        viewOrNull.setVisibility(0);
        if (viewOrNull.getLayoutManager() == null) {
            viewOrNull.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            viewOrNull.setNestedScrollingEnabled(false);
        }
        viewOrNull.setAdapter(new f(filteredHashTags));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(UGCVideo uGCVideo, UGCOptFeedsListAdapter uGCOptFeedsListAdapter, int i, View view) {
        Integer valueOf = Integer.valueOf(uGCOptFeedsListAdapter.tabId);
        OperateItem operateItem = uGCOptFeedsListAdapter.operateItem;
        gu.c.h(uGCVideo, valueOf, operateItem != null ? operateItem.getOpId() : null);
        uGCOptFeedsListAdapter.F1(uGCVideo, i);
    }

    private final void F1(UGCVideo item, int pos) {
        d.a.g(rk.d.c, this.tabId, pos, this.operateItem, item, null, 16, null);
    }

    private final void G1(UGCVideo item, int pos) {
        d.a.e(rk.d.c, this.tabId, pos, this.operateItem, item, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, UGCContent item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        final int e = k.e(getData(), item);
        ViewGroup.LayoutParams layoutParams = ((RecyclerView.a0) holder).itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = e == CollectionsKt.n(getData()) ? 0 : ((RecyclerView.a0) holder).itemView.getContext().getResources().getDimensionPixelSize(R$dimen.dp_10);
            ((RecyclerView.a0) holder).itemView.setLayoutParams(marginLayoutParams);
        }
        z(holder, getItemViewType(e));
        final UGCVideo video = item.getVideo();
        if (video == null) {
            return;
        }
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.feedsListCover);
        if (viewOrNull != null) {
            if (video.getBuiltIn()) {
                i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new UGCOptFeedsListAdapter$convert$1$1(video, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = video.getCover();
                String str2 = BuildConfig.FLAVOR;
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str);
                Cover cover2 = video.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g.l(str2).d(viewOrNull);
            }
        }
        holder.setText(R.id.feedsListCorner, video.getCorner());
        int e2 = UGCVideoTypeKt.e(video.getCategory());
        ImageView imageView = (ImageView) holder.getViewOrNull(R.id.feedsListTypeIcon);
        if (imageView != null) {
            imageView.setImageResource(e2);
        }
        holder.setText(R.id.feedsListDuration, video.getTimeOrCount(getContext()));
        holder.setText(R.id.feedsListTitle, video.getTitle());
        C1(holder, video);
        ImageView imageView2 = (ImageView) holder.getViewOrNull(R.id.feedsListStatsIcon);
        if (imageView2 != null) {
            imageView2.setImageResource(e2);
        }
        holder.setText(R.id.feedsListViews, j.c(video.getWatchNum(), getContext()));
        int i = R.id.feedsListTime;
        Long publishTime = video.getPublishTime();
        holder.setText(i, TimeUtilKt.j(publishTime != null ? publishTime.longValue() : 0L));
        G1(video, e);
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCOptFeedsListAdapter.E1(video, this, e, view);
            }
        });
    }
}
