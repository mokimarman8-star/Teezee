package com.transsnet.downloader.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/transsnet/downloader/adapter/x0;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/baselib/db/download/DownloadBean;", "Lt6/i;", HttpUrl.FRAGMENT_ENCODE_SET, "dataList", "<init>", "(Ljava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, "data", HttpUrl.FRAGMENT_ENCODE_SET, "position", "N1", "(Ljava/util/List;I)I", HttpUrl.FRAGMENT_ENCODE_SET, "G", "Z", "isSmallScreen", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class x0 extends BaseProviderMultiAdapter<DownloadBean> implements t6.i {

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isSmallScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(List<DownloadBean> dataList) {
        super(CollectionsKt.U0(dataList));
        Intrinsics.h(dataList, "dataList");
        boolean z = ((double) (((float) com.blankj.utilcode.util.a0.a(120.0f)) / ((float) com.blankj.utilcode.util.y.e()))) >= 0.35d;
        this.isSmallScreen = z;
        F1(new xw.g(z ? 11.0f : 12.0f));
    }

    protected int N1(List<? extends DownloadBean> data, int position) {
        Intrinsics.h(data, "data");
        return 0;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
