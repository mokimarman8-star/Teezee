package androidx.coroutines;

import com.google.common.util.concurrent.r;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.n;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ n $cancellableContinuation;
    final /* synthetic */ r $this_await;

    public ListenableFutureKt$await$2$1(n nVar, r rVar) {
        this.$cancellableContinuation = nVar;
        this.$this_await = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            n nVar = this.$cancellableContinuation;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.constructor-impl(this.$this_await.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
                return;
            }
            n nVar2 = this.$cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            nVar2.resumeWith(Result.constructor-impl(ResultKt.a(cause)));
        }
    }
}
