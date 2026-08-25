package com.transsnet.downloader.util;

import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadUtil", f = "DownloadUtil.kt", l = {897}, m = "transferFileSuccessNext")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadUtil$transferFileSuccessNext$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadUtil this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadUtil$transferFileSuccessNext$1(DownloadUtil downloadUtil, Continuation<? super DownloadUtil$transferFileSuccessNext$1> continuation) {
        super(continuation);
        this.this$0 = downloadUtil;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DownloadUtil.h(this.this$0, (DownloadBean) null, (String) null, (String) null, 0, (String) null, 0, (String) null, false, this);
    }
}
