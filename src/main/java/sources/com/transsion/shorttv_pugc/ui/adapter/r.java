package com.transsion.shorttv_pugc.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.ShortTvGradientTextView;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/adapter/r;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lkotlin/ranges/IntRange;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "range", "<init>", "(Lkotlin/ranges/IntRange;)V", HttpUrl.FRAGMENT_ENCODE_SET, "E1", "holder", WebConstants.FIELD_ITEM, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lkotlin/ranges/IntRange;)V", "F", "Lkotlin/ranges/IntRange;", "C1", "()Lkotlin/ranges/IntRange;", "D1", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private IntRange range;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(IntRange range) {
        super(R.layout.short_tv_tab_list_item, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(range, "range");
        this.range = range;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.TextView, com.transsion.shorttv_pugc.base.widget.ShortTvGradientTextView] */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, IntRange item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ?? r0 = (ShortTvGradientTextView) holder.getView(R.id.tab_text);
        r0.setText(item.getFirst() + "-" + item.getLast());
        if (item.getFirst() == this.range.getFirst()) {
            holder.setBackgroundResource(R.id.tab_root, R.drawable.short_tv_bg_video_list_tab_seleted);
            r0.setGradientColors(androidx.core.content.b.getColor(getContext(), R.color.short_tv_main_gradient_start), androidx.core.content.b.getColor(getContext(), R.color.short_tv_main_gradient_center), androidx.core.content.b.getColor(getContext(), R.color.short_tv_main_gradient_end));
        } else {
            holder.setBackgroundResource(R.id.tab_root, R.drawable.shott_tv_bg_video_list_tab_unseleted);
            r0.setGradientColors(androidx.core.content.b.getColor(getContext(), R.color.short_tv_white_80), androidx.core.content.b.getColor(getContext(), R.color.short_tv_white_80), androidx.core.content.b.getColor(getContext(), R.color.short_tv_white_80));
        }
    }

    /* renamed from: C1, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final void D1(IntRange intRange) {
        Intrinsics.h(intRange, "<set-?>");
        this.range = intRange;
    }

    public final void E1(IntRange range) {
        Intrinsics.h(range, "range");
        this.range = range;
        notifyDataSetChanged();
    }
}
