package com.transsion.home.adapter.operateUGC.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import ij.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import qk.f0;
import rk.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B#\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001e¨\u0006#"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/VerticalContentUGCAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCContent;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsion/home/bean/OperateItem;", "operateItem", BuildConfig.FLAVOR, "tabId", "layoutResId", "<init>", "(Lcom/transsion/home/bean/OperateItem;II)V", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "item", "pos", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "F1", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/transsion/home/adapter/operateUGC/adapter/VerticalContentUGCAdapter$VerticalContentItemVH;", "E1", "(Landroid/view/ViewGroup;I)Lcom/transsion/home/adapter/operateUGC/adapter/VerticalContentUGCAdapter$VerticalContentItemVH;", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ugcvideodetail/api/bean/UGCContent;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "imageWidth", "imageHeight", "VerticalContentItemVH", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class VerticalContentUGCAdapter extends BaseQuickAdapter {
    public static final int J = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int imageWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private final int imageHeight;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/VerticalContentUGCAdapter$VerticalContentItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lqk/f0;", "viewBinding", "<init>", "(Lqk/f0;)V", "a", "Lqk/f0;", "f", "()Lqk/f0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VerticalContentItemVH extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final f0 viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VerticalContentItemVH(f0 f0Var) {
            super(r0);
            Intrinsics.h(f0Var, "viewBinding");
            BLConstraintLayout root = f0Var.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.viewBinding = f0Var;
        }

        /* renamed from: f, reason: from getter */
        public final f0 getViewBinding() {
            return this.viewBinding;
        }
    }

    public VerticalContentUGCAdapter(OperateItem operateItem, int i, int i2) {
        super(i2, (List) null, 2, (DefaultConstructorMarker) null);
        this.operateItem = operateItem;
        this.tabId = i;
        int e = (y.e() - lj.a.b(40)) / 3;
        this.imageWidth = e;
        this.imageHeight = (e * 150) / 107;
    }

    public /* synthetic */ VerticalContentUGCAdapter(OperateItem operateItem, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(operateItem, i, (i3 & 4) != 0 ? R.layout.item_ugc_vertical_content : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(UGCVideo uGCVideo, VerticalContentUGCAdapter verticalContentUGCAdapter, int i, View view) {
        Integer valueOf = Integer.valueOf(verticalContentUGCAdapter.tabId);
        OperateItem operateItem = verticalContentUGCAdapter.operateItem;
        gu.c.h(uGCVideo, valueOf, operateItem != null ? operateItem.getOpId() : null);
        verticalContentUGCAdapter.F1(uGCVideo, i);
    }

    private final void F1(UGCVideo item, int pos) {
        d.a.g(rk.d.c, HomeTabId.UGC_Trending.getValue(), pos, this.operateItem, item, null, 16, null);
    }

    private final void G1(UGCVideo item, int pos) {
        d.a.e(rk.d.c, HomeTabId.UGC_Trending.getValue(), pos, this.operateItem, item, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, UGCContent item) {
        String url;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        VerticalContentItemVH verticalContentItemVH = (VerticalContentItemVH) holder;
        final int e = k.e(getData(), item);
        z(holder, getItemViewType(e));
        final UGCVideo video = item.getVideo();
        if (video == null) {
            return;
        }
        ImageView imageView = verticalContentItemVH.getViewBinding().b;
        if (video.getBuiltIn()) {
            i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new VerticalContentUGCAdapter$convert$1$1(video, imageView, null), 3, (Object) null);
        } else {
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover coverVertical = video.getCoverVertical();
            String str = BuildConfig.FLAVOR;
            if (coverVertical == null || (url = coverVertical.getUrl()) == null) {
                Cover cover = video.getCover();
                url = cover != null ? cover.getUrl() : null;
                if (url == null) {
                    url = BuildConfig.FLAVOR;
                }
            }
            f.b g = m.g(url);
            Cover coverVertical2 = video.getCoverVertical();
            if (coverVertical2 != null && (thumbnail = coverVertical2.getThumbnail()) != null) {
                str = thumbnail;
            }
            f.b m2 = g.l(str).i(com.transsion.wrapperad.R.color.module_01).m(this.imageWidth);
            Intrinsics.e(imageView);
            m2.d(imageView);
        }
        verticalContentItemVH.getViewBinding().d.setText(video.getTimeOrCount(getContext()));
        ImageView imageView2 = verticalContentItemVH.getViewBinding().c;
        Intrinsics.g(imageView2, "ivTypeIcon");
        UGCVideoTypeKt.i(imageView2, video, (Integer) null, 4, (Object) null);
        verticalContentItemVH.getViewBinding().e.setText(video.getTitle());
        G1(video, e);
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerticalContentUGCAdapter.D1(video, this, e, view);
            }
        });
    }

    /* renamed from: E1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public VerticalContentItemVH z0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        f0 c = f0.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        ShapeableImageView shapeableImageView = c.b;
        Intrinsics.g(shapeableImageView, "ivCover");
        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = this.imageHeight;
        shapeableImageView.setLayoutParams(layoutParams);
        return new VerticalContentItemVH(c);
    }
}
