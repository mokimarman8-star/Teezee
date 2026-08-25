package com.transsion.usercenter.setting.labelsfeedback;

import com.transsion.upload.bean.LoggerBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", HttpUrl.FRAGMENT_ENCODE_SET}, k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.UploadInit$init$1$reportUploadLogsResult$2", f = "UploadInit.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class UploadInit$init$1$reportUploadLogsResult$2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<LoggerBean, Unit> $callback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UploadInit$init$1$reportUploadLogsResult$2(Function1<? super LoggerBean, Unit> function1, Continuation<? super UploadInit$init$1$reportUploadLogsResult$2> continuation) {
        super(2, continuation);
        this.$callback = function1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.usercenter.setting.labelsfeedback.UploadInit$init$1$reportUploadLogsResult$2, kotlin.coroutines.Continuation<kotlin.Unit>] */
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ?? uploadInit$init$1$reportUploadLogsResult$2 = new UploadInit$init$1$reportUploadLogsResult$2(this.$callback, continuation);
        uploadInit$init$1$reportUploadLogsResult$2.L$0 = obj;
        return uploadInit$init$1$reportUploadLogsResult$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Throwable th, Continuation<? super Unit> continuation) {
        return ((UploadInit$init$1$reportUploadLogsResult$2) create(th, continuation)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        a.a.f(wf.a.a, "UploadLoggerManager", ((Throwable) this.L$0).toString(), false, 4, (Object) null);
        this.$callback.invoke(null);
        return Unit.a;
    }
}
