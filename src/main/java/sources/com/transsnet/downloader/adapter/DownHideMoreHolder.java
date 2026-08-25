package com.transsnet.downloader.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsnet/downloader/adapter/DownHideMoreHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsnet/downloader/adapter/u0;", "Landroid/view/View;", "view", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "<init>", "(Landroid/view/View;Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", HttpUrl.FRAGMENT_ENCODE_SET, "position", "Lp6/a;", WebConstants.FIELD_ITEM, HttpUrl.FRAGMENT_ENCODE_SET, "a", "(ILp6/a;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "b", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownHideMoreHolder extends BaseViewHolder implements u0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final View view;

    /* renamed from: b, reason: from kotlin metadata */
    private final BiddingNativeManager wrapperNativeManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownHideMoreHolder(View view, BiddingNativeManager biddingNativeManager) {
        super(view);
        Intrinsics.h(view, "view");
        this.view = view;
        this.wrapperNativeManager = biddingNativeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DownHideMoreHolder downHideMoreHolder, View view) {
        DownloadListManager.I(DownloadListManager.m.a(), !r7.a().V(), false, downHideMoreHolder.wrapperNativeManager, 2, (Object) null);
    }

    @Override // com.transsnet.downloader.adapter.u0
    public void a(int position, p6.a item) {
        if (item instanceof DownloadBean) {
            TextView textView = (TextView) getView(R.id.tv_title);
            ImageView imageView = (ImageView) getView(R.id.iv_hide_more);
            DownloadBean downloadBean = (DownloadBean) item;
            textView.setText(downloadBean.getName());
            imageView.setImageDrawable(downloadBean.isMore() ? androidx.core.content.b.getDrawable(imageView.getContext(), com.tn.lib.widget.R.mipmap.libui_ic_down_more) : androidx.core.content.b.getDrawable(imageView.getContext(), com.tn.lib.widget.R.mipmap.libui_ic_up_hide));
            this.view.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownHideMoreHolder.g(DownHideMoreHolder.this, view);
                }
            });
        }
    }

    @Override // com.transsnet.downloader.adapter.u0
    public void b(int i, p6.a aVar) {
        u0.a.a(this, i, aVar);
    }

    @Override // com.transsnet.downloader.adapter.u0
    public void c(u0.b bVar) {
        u0.a.b(this, bVar);
    }
}
