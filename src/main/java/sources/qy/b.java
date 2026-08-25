package qy;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.n;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {

    static final class a implements OnCompleteListener {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        public final void onComplete(Task task) {
            Exception exception = task.getException();
            if (exception != null) {
                n nVar = this.a;
                Result$Companion result$Companion = Result.Companion;
                nVar.resumeWith(Result.constructor-impl(ResultKt.a(exception)));
            } else {
                if (task.isCanceled()) {
                    n.a.a(this.a, null, 1, null);
                    return;
                }
                n nVar2 = this.a;
                Result$Companion result$Companion2 = Result.Companion;
                nVar2.resumeWith(Result.constructor-impl(task.getResult()));
            }
        }
    }

    /* renamed from: qy.b$b, reason: collision with other inner class name */
    static final class C0097b implements Function1 {
        final /* synthetic */ CancellationTokenSource a;

        C0097b(CancellationTokenSource cancellationTokenSource) {
            this.a = cancellationTokenSource;
        }

        public final void a(Throwable th) {
            this.a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.a;
        }
    }

    public static final Object a(Task task, Continuation continuation) {
        return b(task, null, continuation);
    }

    private static final Object b(Task task, CancellationTokenSource cancellationTokenSource, Continuation continuation) {
        if (!task.isComplete()) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            task.addOnCompleteListener(qy.a.a, new a(cancellableContinuationImpl));
            if (cancellationTokenSource != null) {
                cancellableContinuationImpl.invokeOnCancellation(new C0097b(cancellationTokenSource));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
