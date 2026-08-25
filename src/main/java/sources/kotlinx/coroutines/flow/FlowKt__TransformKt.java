package kotlinx.coroutines.flow;

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

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract /* synthetic */ class FlowKt__TransformKt {
    public static final a a(final a aVar, final Function2 function2) {
        return new a() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements b {
                final /* synthetic */ b a;
                final /* synthetic */ Function2 b;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_LEAVE_APPLICATION_VALUE, Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER_VALUE}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b bVar, Function2 function2) {
                    this.a = bVar;
                    this.b = function2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1] */
                /* JADX WARN: Type inference failed for: r0v5 */
                /* JADX WARN: Type inference failed for: r0v6 */
                @Override // kotlinx.coroutines.flow.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    ?? r0;
                    Object f;
                    int i;
                    Object obj2;
                    b bVar;
                    if (continuation instanceof AnonymousClass1) {
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.label;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i2 - Integer.MIN_VALUE;
                            r0 = anonymousClass1;
                            Object obj3 = r0.result;
                            f = IntrinsicsKt.f();
                            i = r0.label;
                            if (i != 0) {
                                ResultKt.b(obj3);
                                b bVar2 = this.a;
                                Function2 function2 = this.b;
                                r0.L$0 = obj;
                                r0.L$1 = bVar2;
                                r0.label = 1;
                                InlineMarker.c(6);
                                Object invoke = function2.invoke(obj, r0);
                                InlineMarker.c(7);
                                if (invoke == f) {
                                    return f;
                                }
                                obj2 = obj;
                                bVar = bVar2;
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj3);
                                    return Unit.a;
                                }
                                b bVar3 = (b) r0.L$1;
                                obj2 = r0.L$0;
                                ResultKt.b(obj3);
                                bVar = bVar3;
                            }
                            r0.L$0 = null;
                            r0.L$1 = null;
                            r0.label = 2;
                            if (bVar.emit(obj2, r0) == f) {
                                return f;
                            }
                            return Unit.a;
                        }
                    }
                    r0 = new AnonymousClass1(continuation);
                    Object obj32 = r0.result;
                    f = IntrinsicsKt.f();
                    i = r0.label;
                    if (i != 0) {
                    }
                    r0.L$0 = null;
                    r0.L$1 = null;
                    r0.label = 2;
                    if (bVar.emit(obj2, r0) == f) {
                    }
                    return Unit.a;
                }
            }

            @Override // kotlinx.coroutines.flow.a
            public Object a(b bVar, Continuation continuation) {
                Object a = a.this.a(new AnonymousClass2(bVar, function2), continuation);
                return a == IntrinsicsKt.f() ? a : Unit.a;
            }
        };
    }
}
