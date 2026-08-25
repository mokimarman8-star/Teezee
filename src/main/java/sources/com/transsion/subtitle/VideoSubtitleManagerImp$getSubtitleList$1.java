package com.transsion.subtitle;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleManagerImp", f = "VideoSubtitleManagerImp.kt", l = {353}, m = "getSubtitleList")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class VideoSubtitleManagerImp$getSubtitleList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoSubtitleManagerImp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoSubtitleManagerImp$getSubtitleList$1(VideoSubtitleManagerImp videoSubtitleManagerImp, Continuation<? super VideoSubtitleManagerImp$getSubtitleList$1> continuation) {
        super(continuation);
        this.this$0 = videoSubtitleManagerImp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((String) null, this);
    }
}
