package androidx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
/* renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class C0207CoroutineWorker$getForegroundInfoAsync$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JobListenableFuture $jobFuture;
    Object L$0;
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0207CoroutineWorker$getForegroundInfoAsync$1(JobListenableFuture jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super C0207CoroutineWorker$getForegroundInfoAsync$1> continuation) {
        super(2, continuation);
        this.$jobFuture = jobListenableFuture;
        this.this$0 = coroutineWorker;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0207CoroutineWorker$getForegroundInfoAsync$1(this.$jobFuture, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        JobListenableFuture jobListenableFuture;
        Object f5 = IntrinsicsKt.f();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.b(obj);
            JobListenableFuture jobListenableFuture2 = this.$jobFuture;
            CoroutineWorker coroutineWorker = this.this$0;
            this.L$0 = jobListenableFuture2;
            this.label = 1;
            Object t5 = coroutineWorker.t(this);
            if (t5 == f5) {
                return f5;
            }
            jobListenableFuture = jobListenableFuture2;
            obj = t5;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jobListenableFuture = (JobListenableFuture) this.L$0;
            ResultKt.b(obj);
        }
        jobListenableFuture.c(obj);
        return Unit.a;
    }
}
