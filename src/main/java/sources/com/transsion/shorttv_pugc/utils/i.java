package com.transsion.shorttv_pugc.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsion/shorttv_pugc/utils/i;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/shorttv_pugc/utils/ShortTvVideoCtrBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "dataList", "<init>", "(Ljava/util/List;)V", "holder", HttpUrl.FRAGMENT_ENCODE_SET, "isSelected", HttpUrl.FRAGMENT_ENCODE_SET, "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Z)V", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/shorttv_pugc/utils/ShortTvVideoCtrBean;)V", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i extends BaseQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List<ShortTvVideoCtrBean> dataList) {
        super(R.layout.pugc_short_tv_item_video_pop, dataList);
        Intrinsics.h(dataList, "dataList");
    }

    private final void C1(BaseViewHolder holder, boolean isSelected) {
        ((RecyclerView.a0) holder).itemView.setSelected(isSelected);
        holder.getView(R.id.tvName).setVisibility(!isSelected ? 0 : 8);
        holder.getView(R.id.tvNameSelected).setVisibility(isSelected ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, ShortTvVideoCtrBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        C1(holder, item.getIsSelect());
        int i = R.id.tvName;
        String name = item.getName();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (name == null) {
            name = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        holder.setText(i, name);
        int i2 = R.id.tvNameSelected;
        String name2 = item.getName();
        if (name2 != null) {
            str = name2;
        }
        holder.setText(i2, str);
    }
}
