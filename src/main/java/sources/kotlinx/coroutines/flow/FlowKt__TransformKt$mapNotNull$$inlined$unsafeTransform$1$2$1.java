package kotlinx.coroutines.flow;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_LEAVE_APPLICATION_VALUE, Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER_VALUE}, m = "emit")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ p0 this$0;

    public FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1(p0 p0Var, Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
