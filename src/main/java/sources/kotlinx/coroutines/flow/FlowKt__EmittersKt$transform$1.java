package kotlinx.coroutines.flow;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/flow/b;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_FAIL_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $this_transform;
    final /* synthetic */ Function3<b, Object, Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements b {
        final /* synthetic */ Function3 a;
        final /* synthetic */ b b;

        public AnonymousClass1(Function3 function3, b bVar) {
            this.a = function3;
            this.b = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Object obj, Continuation continuation) {
            FlowKt__EmittersKt$transform$1$1$emit$1 flowKt__EmittersKt$transform$1$1$emit$1;
            int i;
            if (continuation instanceof FlowKt__EmittersKt$transform$1$1$emit$1) {
                flowKt__EmittersKt$transform$1$1$emit$1 = (FlowKt__EmittersKt$transform$1$1$emit$1) continuation;
                int i2 = flowKt__EmittersKt$transform$1$1$emit$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__EmittersKt$transform$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                    Object obj2 = flowKt__EmittersKt$transform$1$1$emit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = flowKt__EmittersKt$transform$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj2);
                        Function3 function3 = this.a;
                        b bVar = this.b;
                        flowKt__EmittersKt$transform$1$1$emit$1.label = 1;
                        if (function3.invoke(bVar, obj, flowKt__EmittersKt$transform$1$1$emit$1) == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj2);
                    }
                    return Unit.a;
                }
            }
            flowKt__EmittersKt$transform$1$1$emit$1 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
            Object obj22 = flowKt__EmittersKt$transform$1$1$emit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = flowKt__EmittersKt$transform$1$1$emit$1.label;
            if (i != 0) {
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(a aVar, Function3<? super b, Object, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.$this_transform = aVar;
        this.$transform = function3;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>, kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1] */
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ?? flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, continuation);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(bVar, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            b bVar = (b) this.L$0;
            a aVar = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, bVar);
            this.label = 1;
            if (aVar.a(anonymousClass1, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend$$forInline(Object obj) {
        b bVar = (b) this.L$0;
        a aVar = this.$this_transform;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, bVar);
        InlineMarker.c(0);
        aVar.a(anonymousClass1, this);
        InlineMarker.c(1);
        return Unit.a;
    }
}
