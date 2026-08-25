package androidx.coroutines;

import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1", f = "MultiInstanceInvalidationClient.android.kt", l = {87}, m = "invokeSuspend")
/* renamed from: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class C0197x5cbf7351 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String[] $tables;
    Object L$0;
    int label;
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0197x5cbf7351(String[] strArr, MultiInstanceInvalidationClient multiInstanceInvalidationClient, Continuation<? super C0197x5cbf7351> continuation) {
        super(2, continuation);
        this.$tables = strArr;
        this.this$0 = multiInstanceInvalidationClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0197x5cbf7351(this.$tables, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        w0 w0Var;
        Set set;
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            String[] strArr = this.$tables;
            Set j5 = SetsKt.j(Arrays.copyOf(strArr, strArr.length));
            w0Var = this.this$0.f13025h;
            this.L$0 = j5;
            this.label = 1;
            if (w0Var.emit(j5, this) == f5) {
                return f5;
            }
            set = j5;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            set = (Set) this.L$0;
            ResultKt.b(obj);
        }
        this.this$0.h().s(set);
        return Unit.a;
    }
}
