package com.transsnet.downloader.util;

import android.content.Context;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadUtil", f = "DownloadUtil.kt", l = {782, 788, 819, 825}, m = "transferFile")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadUtil$transferFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadUtil this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadUtil$transferFile$1(DownloadUtil downloadUtil, Continuation<? super DownloadUtil$transferFile$1> continuation) {
        super(continuation);
        this.this$0 = downloadUtil;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.J((Context) null, false, (DownloadBean) null, (String) null, 0, (String) null, 0, (Function2) null, (Function1) null, false, this);
    }
}
