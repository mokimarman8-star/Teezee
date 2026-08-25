package com.transsion.ugcvideodetail.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.noober.background.drawable.DrawableCreator;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/transsion/ugcvideodetail/adapter/e;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lht/a;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "data", "<init>", "(Ljava/util/List;)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lht/a;)V", HttpUrl.FRAGMENT_ENCODE_SET, "value", "F", "I", "C1", "()I", "D1", "(I)V", "selectedIndex", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private int selectedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<ht.a> data) {
        super(R$layout.item_ugc_imm_video_setting_language, data);
        Intrinsics.h(data, "data");
        this.selectedIndex = -1;
    }

    public /* synthetic */ e(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, ht.a item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        boolean z = holder.getAdapterPosition() == this.selectedIndex;
        GradientTextView view = holder.getView(R$id.tvLanguage);
        View itemView = ((RecyclerView.a0) holder).itemView;
        Intrinsics.g(itemView, "itemView");
        view.setText(item.b().getLanName());
        Context context = view.getContext();
        if (z) {
            view.setGradientColors(androidx.core.content.b.getColor(context, R.color.brand_new_gradient_start), androidx.core.content.b.getColor(context, R.color.brand_new_gradient_center), androidx.core.content.b.getColor(context, R.color.brand_new_gradient_end));
            itemView.setBackground(new DrawableCreator.Builder().setCornersRadius(a0.a(4.0f)).setGradientAngle(0).setGradientColor(androidx.core.content.b.getColor(context, R.color.brand_new_gradient_start_20), androidx.core.content.b.getColor(context, R.color.brand_new_gradient_center_20), androidx.core.content.b.getColor(context, R.color.brand_new_gradient_end_20)).build());
        } else {
            view.setGradientColors(androidx.core.content.b.getColor(context, R.color.white_80), androidx.core.content.b.getColor(context, R.color.white_80), androidx.core.content.b.getColor(context, R.color.white_80));
            itemView.setBackground(new DrawableCreator.Builder().setCornersRadius(a0.a(4.0f)).setSolidColor(androidx.core.content.b.getColor(context, R.color.white_6)).build());
        }
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
