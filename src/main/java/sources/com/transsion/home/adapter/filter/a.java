package com.transsion.home.adapter.filter;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.UGCFilterVideoItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rk.b;
import t6.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b#\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R*\u0010\r\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/transsion/home/adapter/filter/a;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/home/bean/UGCFilterVideoItem;", "Lt6/i;", BuildConfig.FLAVOR, "dataList", "Lrk/b;", "listExposureHelper", "Lcom/transsion/home/bean/LayoutStyle;", "style", BuildConfig.FLAVOR, "rowCount", BuildConfig.FLAVOR, "isEducationList", "<init>", "(Ljava/util/List;Lrk/b;Lcom/transsion/home/bean/LayoutStyle;IZ)V", BuildConfig.FLAVOR, "data", "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "T1", "G", "Lrk/b;", "H", "Lcom/transsion/home/bean/LayoutStyle;", "R1", "()Lcom/transsion/home/bean/LayoutStyle;", "V1", "(Lcom/transsion/home/bean/LayoutStyle;)V", "I", "Q1", "()I", "Lmk/b;", "J", "Lmk/b;", "videoProvider", "value", "K", "Z", "S1", "()Z", "U1", "(Z)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseProviderMultiAdapter<UGCFilterVideoItem> implements i {
    public static final int L = 8;

    /* renamed from: G, reason: from kotlin metadata */
    private final b listExposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private LayoutStyle style;

    /* renamed from: I, reason: from kotlin metadata */
    private final int rowCount;

    /* renamed from: J, reason: from kotlin metadata */
    private mk.b videoProvider;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isEducationList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<UGCFilterVideoItem> list, b bVar, LayoutStyle layoutStyle, int i, boolean z) {
        super(list);
        Intrinsics.h(list, "dataList");
        this.listExposureHelper = bVar;
        this.style = layoutStyle;
        this.rowCount = i;
        this.isEducationList = z;
        mk.b bVar2 = new mk.b(bVar, this.style, i, z);
        this.videoProvider = bVar2;
        F1(bVar2);
        F1(new mk.a(bVar));
    }

    public /* synthetic */ a(List list, b bVar, LayoutStyle layoutStyle, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bVar, layoutStyle, i, (i2 & 16) != 0 ? false : z);
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        b bVar = this.listExposureHelper;
        if (bVar != null) {
            GridLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            bVar.h(layoutManager, bindingAdapterPosition, true);
        }
    }

    protected int N1(List<UGCFilterVideoItem> data, int position) {
        Intrinsics.h(data, "data");
        UGCFilterVideoItem uGCFilterVideoItem = data.get(position);
        if (uGCFilterVideoItem.isAd()) {
            return 4;
        }
        Intrinsics.c(uGCFilterVideoItem.getContent().getTopicType(), "UGC_VIDEO");
        return 1;
    }

    /* renamed from: Q1, reason: from getter */
    public final int getRowCount() {
        return this.rowCount;
    }

    /* renamed from: R1, reason: from getter */
    public final LayoutStyle getStyle() {
        return this.style;
    }

    /* renamed from: S1, reason: from getter */
    public final boolean getIsEducationList() {
        return this.isEducationList;
    }

    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull == null || viewOrNull.getContext() == null) {
            return;
        }
        Context context = viewOrNull.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isDestroyed()) {
            Context context2 = viewOrNull.getContext();
            Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity2 == null || !activity2.isFinishing()) {
                Glide.with(viewOrNull.getContext()).clear(viewOrNull);
            }
        }
    }

    public final void U1(boolean z) {
        this.isEducationList = z;
        mk.b bVar = this.videoProvider;
        if (bVar != null) {
            bVar.z(z);
        }
        notifyItemRangeChanged(0, getData().size());
    }

    public final void V1(LayoutStyle layoutStyle) {
        this.style = layoutStyle;
    }

    public /* bridge */ /* synthetic */ f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
