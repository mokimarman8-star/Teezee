package com.transsion.usercenter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/usercenter/g;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", HttpUrl.FRAGMENT_ENCODE_SET, "followType", "<init>", "(I)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/String;)V", "F", "I", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g extends BaseQuickAdapter implements t6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int followType;

    public g(int i) {
        super(R$layout.adapter_item_follow, (List) null, 2, (DefaultConstructorMarker) null);
        this.followType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, String item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (this.followType == 1) {
            TextView textView = (TextView) holder.getView(R$id.btnFollow);
            textView.setText(((RecyclerView.a0) holder).itemView.getContext().getString(R$string.user_center_follow_following));
            textView.setTextColor(androidx.core.content.b.getColor(((RecyclerView.a0) holder).itemView.getContext(), R.color.base_color_white));
            textView.setBackgroundResource(R$drawable.btn_bg_following);
            return;
        }
        TextView textView2 = (TextView) holder.getView(R$id.btnFollow);
        textView2.setText(((RecyclerView.a0) holder).itemView.getContext().getString(R$string.user_center_follow_followers));
        textView2.setTextColor(androidx.core.content.b.getColor(((RecyclerView.a0) holder).itemView.getContext(), R.color.base_color_333333));
        textView2.setBackgroundResource(R$drawable.btn_bg_followers);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
