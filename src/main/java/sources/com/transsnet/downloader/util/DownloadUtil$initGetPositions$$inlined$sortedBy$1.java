package com.transsnet.downloader.util;

import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadUtil$initGetPositions$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.d(Integer.valueOf(((ResourcesSeason) t).getSe()), Integer.valueOf(((ResourcesSeason) t2).getSe()));
    }
}
