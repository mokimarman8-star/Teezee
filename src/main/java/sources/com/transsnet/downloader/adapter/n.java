package com.transsnet.downloader.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/transsnet/downloader/adapter/n;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lyw/b;", HttpUrl.FRAGMENT_ENCODE_SET, "isSaveDialog", HttpUrl.FRAGMENT_ENCODE_SET, "data", "<init>", "(ZLjava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "position", "N1", "(Ljava/util/List;I)I", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class n extends BaseProviderMultiAdapter<yw.b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(boolean z, List<yw.b> data) {
        super(data);
        Intrinsics.h(data, "data");
        F1(new p());
        F1(new o(z));
        F1(new q());
    }

    protected int N1(List<yw.b> data, int position) {
        Intrinsics.h(data, "data");
        return data.get(position).getItemType();
    }
}
