package kotlinx.coroutines.flow;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 implements b {
    final /* synthetic */ Function2 a;
    final /* synthetic */ b b;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", f = "Limit.kt", l = {Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, m = "emit")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 function2, b bVar) {
        this.a = function2;
        this.b = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // kotlinx.coroutines.flow.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        ?? r0;
        int i;
        boolean z;
        Object obj2;
        Object obj3;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                r0 = anonymousClass1;
                Object obj4 = r0.result;
                Object f = IntrinsicsKt.f();
                i = r0.label;
                z = true;
                if (i != 0) {
                    ResultKt.b(obj4);
                    Function2 function2 = this.a;
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.label = 1;
                    InlineMarker.c(6);
                    Object invoke = function2.invoke(obj, r0);
                    InlineMarker.c(7);
                    if (invoke == f) {
                        return f;
                    }
                    obj2 = invoke;
                    obj3 = obj;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) r0.L$0;
                        ResultKt.b(obj4);
                        if (z) {
                            return Unit.a;
                        }
                        throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
                    }
                    Object obj5 = r0.L$1;
                    FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1) r0.L$0;
                    ResultKt.b(obj4);
                    obj3 = obj5;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12;
                    obj2 = obj4;
                }
                if (((Boolean) obj2).booleanValue()) {
                    z = false;
                } else {
                    b bVar = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.b;
                    r0.L$0 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
                    r0.L$1 = null;
                    r0.label = 2;
                    if (bVar.emit(obj3, r0) == f) {
                        return f;
                    }
                }
                if (z) {
                }
            }
        }
        r0 = new AnonymousClass1(continuation);
        Object obj42 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
        z = true;
        if (i != 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
        if (z) {
        }
    }
}
