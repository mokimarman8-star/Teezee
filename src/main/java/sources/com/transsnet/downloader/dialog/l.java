package com.transsnet.downloader.dialog;

import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/transsnet/downloader/dialog/l;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", HttpUrl.FRAGMENT_ENCODE_SET, "dataList", "<init>", "(Ljava/util/List;)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/String;)V", "F", "Ljava/lang/String;", "deleteStr", HttpUrl.FRAGMENT_ENCODE_SET, "G", "I", "deleteRedColor", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private String deleteStr;

    /* renamed from: G, reason: from kotlin metadata */
    private int deleteRedColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(List<String> dataList) {
        super(R.layout.adapter_download_more_dialog_item, dataList);
        Intrinsics.h(dataList, "dataList");
        String string = Utils.a().getString(R.string.delete);
        Intrinsics.g(string, "getString(...)");
        this.deleteStr = string;
        this.deleteRedColor = androidx.core.content.b.getColor(Utils.a(), com.tn.lib.widget.R.color.error_50);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, String item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tv_title);
        textView.setText(item);
        if (Intrinsics.c(item, this.deleteStr)) {
            textView.setTextColor(this.deleteRedColor);
        }
    }
}
