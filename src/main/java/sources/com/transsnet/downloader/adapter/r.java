package com.transsnet.downloader.adapter;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsnet/downloader/adapter/r;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", "<init>", "()V", "holder", HttpUrl.FRAGMENT_ENCODE_SET, "selected", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ZLcom/transsion/moviedetailapi/bean/DownloadResolutionItem;)V", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "payloads", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;Ljava/util/List;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r extends BaseQuickAdapter implements t6.i {
    public r() {
        super(R.layout.item_download_re_resolution, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void D1(BaseViewHolder holder, boolean selected, DownloadResolutionItem item) {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        boolean z = bVar != null ? bVar.z() : false;
        ImageView imageView = (ImageView) holder.getView(R.id.iv_resolution);
        if (z && item.getRequireMemberType() == 1) {
            imageView.setImageResource(item.isSelected() ? com.transsion.baseui.R.mipmap.ic_premium_tab_selected : com.transsion.baseui.R.mipmap.ic_premium_tab);
            uf.c.k(imageView);
        } else {
            uf.c.g(imageView);
        }
        ((RecyclerView.a0) holder).itemView.setSelected(selected);
        holder.getView(R.id.tv_resolution).setVisibility(!selected ? 0 : 8);
        holder.getView(R.id.tv_resolution_selected).setVisibility(selected ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, DownloadResolutionItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        D1(holder, item.isSelected(), item);
        holder.setText(R.id.tv_resolution, item.getResolution() + "P");
        holder.setText(R.id.tv_resolution_selected, item.getResolution() + "P");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, DownloadResolutionItem item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            D1(holder, ((Boolean) obj).booleanValue(), item);
        }
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
