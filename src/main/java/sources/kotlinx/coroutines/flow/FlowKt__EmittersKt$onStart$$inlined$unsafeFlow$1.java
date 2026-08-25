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
import kotlinx.coroutines.flow.internal.SafeCollector;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements a {
    final /* synthetic */ Function2 a;
    final /* synthetic */ a b;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {Sdk$SDKError.Reason.ASSET_REQUEST_ERROR_VALUE, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, a aVar) {
        this.a = function2;
        this.b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // kotlinx.coroutines.flow.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(b bVar, Continuation continuation) {
        ?? r0;
        Object f;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
        b bVar2;
        a aVar;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                r0 = anonymousClass1;
                Object obj = r0.result;
                f = IntrinsicsKt.f();
                i = r0.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    SafeCollector safeCollector2 = new SafeCollector(bVar, r0.getA());
                    try {
                        Function2 function2 = this.a;
                        r0.L$0 = this;
                        r0.L$1 = bVar;
                        r0.L$2 = safeCollector2;
                        r0.label = 1;
                        InlineMarker.c(6);
                        Object invoke = function2.invoke(safeCollector2, r0);
                        InlineMarker.c(7);
                        if (invoke == f) {
                            return f;
                        }
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = this;
                        bVar2 = bVar;
                        safeCollector = safeCollector2;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    safeCollector = (SafeCollector) r0.L$2;
                    bVar2 = (b) r0.L$1;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r0.L$0;
                    try {
                        ResultKt.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                aVar = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.b;
                r0.L$0 = null;
                r0.L$1 = null;
                r0.L$2 = null;
                r0.label = 2;
                if (aVar.a(bVar2, r0) == f) {
                    return f;
                }
                return Unit.a;
            }
        }
        r0 = new AnonymousClass1(continuation);
        Object obj2 = r0.result;
        f = IntrinsicsKt.f();
        i = r0.label;
        if (i != 0) {
        }
        safeCollector.releaseIntercepted();
        aVar = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.b;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (aVar.a(bVar2, r0) == f) {
        }
        return Unit.a;
    }
}
