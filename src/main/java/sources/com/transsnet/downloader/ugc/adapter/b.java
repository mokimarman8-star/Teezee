package com.transsnet.downloader.ugc.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/transsnet/downloader/ugc/adapter/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "data", "<init>", "(Ljava/util/List;)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "value", "F", "I", "C1", "()I", "D1", "(I)V", "selectedIndex", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private int selectedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<String> data) {
        super(R.layout.ugc_item_download_tab, data);
        Intrinsics.h(data, "data");
    }

    public /* synthetic */ b(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, String item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int adapterPosition = holder.getAdapterPosition();
        ((TextView) holder.getView(R.id.tvLabel)).setText(item);
        ((TextView) holder.getView(R.id.tvLabelSelected)).setText(item);
        boolean z = adapterPosition == this.selectedIndex;
        ((RecyclerView.a0) holder).itemView.setSelected(z);
        ((TextView) holder.getView(R.id.tvLabel)).setVisibility(z ? 8 : 0);
        ((TextView) holder.getView(R.id.tvLabelSelected)).setVisibility(z ? 0 : 8);
    }

    /* renamed from: C1, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void D1(int i) {
        int i2 = this.selectedIndex;
        if (i2 == i) {
            return;
        }
        this.selectedIndex = i;
        if (i2 >= 0 && i2 < getItemCount()) {
            notifyItemChanged(i2);
        }
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        notifyItemChanged(i);
    }
}
