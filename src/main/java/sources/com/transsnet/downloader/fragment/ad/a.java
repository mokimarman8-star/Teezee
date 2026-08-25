package com.transsnet.downloader.fragment.ad;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.transsion.ad.bidding.icon.BiddingWrapperIconBean;
import com.transsion.ad.bidding.icon.BiddingWrapperIconView;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/transsnet/downloader/fragment/ad/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "adManager", "<init>", "(Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;)V", "holder", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;)V", "F", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "C1", "()Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", HttpUrl.FRAGMENT_ENCODE_SET, "G", "I", "designW", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final BiddingIconAdManager adManager;

    /* renamed from: G, reason: from kotlin metadata */
    private final int designW;

    public a(BiddingIconAdManager biddingIconAdManager) {
        super(R.layout.item_app_download_ad_ps_layout, (List) null, 2, (DefaultConstructorMarker) null);
        this.adManager = biddingIconAdManager;
        this.designW = a0.a(160.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, BiddingWrapperIconBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        BiddingWrapperIconView view = holder.getView(R.id.wrapperIconView);
        view.getLayoutParams().width = this.designW;
        view.showData(this.adManager, item, new qw.a(getContext()));
    }

    /* renamed from: C1, reason: from getter */
    public final BiddingIconAdManager getAdManager() {
        return this.adManager;
    }
}
