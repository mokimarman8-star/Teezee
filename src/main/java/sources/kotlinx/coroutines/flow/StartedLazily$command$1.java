package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/SharingCommand;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {151}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class StartedLazily$command$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    final /* synthetic */ h1 $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    static final class AnonymousClass1 implements b {
        final /* synthetic */ Ref.BooleanRef a;
        final /* synthetic */ b b;

        AnonymousClass1(Ref.BooleanRef booleanRef, b bVar) {
            this.a = booleanRef;
            this.b = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(int i, Continuation continuation) {
            ?? r0;
            int i2;
            if (continuation instanceof StartedLazily$command$1$1$emit$1) {
                StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) continuation;
                int i3 = startedLazily$command$1$1$emit$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    startedLazily$command$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                    r0 = startedLazily$command$1$1$emit$1;
                    Object obj = r0.result;
                    Object f = IntrinsicsKt.f();
                    i2 = r0.label;
                    if (i2 != 0) {
                        ResultKt.b(obj);
                        if (i > 0) {
                            Ref.BooleanRef booleanRef = this.a;
                            if (!booleanRef.element) {
                                booleanRef.element = true;
                                b bVar = this.b;
                                SharingCommand sharingCommand = SharingCommand.START;
                                r0.label = 1;
                                if (bVar.emit(sharingCommand, r0) == f) {
                                    return f;
                                }
                            }
                        }
                        return Unit.a;
                    }
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
            }
            r0 = new StartedLazily$command$1$1$emit$1(this, continuation);
            Object obj2 = r0.result;
            Object f2 = IntrinsicsKt.f();
            i2 = r0.label;
            if (i2 != 0) {
            }
            return Unit.a;
        }

        @Override // kotlinx.coroutines.flow.b
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartedLazily$command$1(h1 h1Var, Continuation<? super StartedLazily$command$1> continuation) {
        super(2, continuation);
        this.$subscriptionCount = h1Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>, kotlinx.coroutines.flow.StartedLazily$command$1] */
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ?? startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, continuation);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((StartedLazily$command$1) create(bVar, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            b bVar = (b) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            h1 h1Var = this.$subscriptionCount;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef, bVar);
            this.label = 1;
            if (h1Var.a(anonymousClass1, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
