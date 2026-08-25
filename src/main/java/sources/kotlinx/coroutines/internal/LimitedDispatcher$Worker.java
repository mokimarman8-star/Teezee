package kotlinx.coroutines.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0002j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00060\u0002j\u0002`\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "currentTask", "<init>", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LimitedDispatcher$Worker implements Runnable {
    private Runnable currentTask;
    final /* synthetic */ LimitedDispatcher this$0;

    public LimitedDispatcher$Worker(LimitedDispatcher limitedDispatcher, Runnable runnable) {
        this.this$0 = limitedDispatcher;
        this.currentTask = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (true) {
            try {
                this.currentTask.run();
            } catch (Throwable th) {
                kotlinx.coroutines.k0.a(EmptyCoroutineContext.INSTANCE, th);
            }
            Runnable q = LimitedDispatcher.q(this.this$0);
            if (q == null) {
                return;
            }
            this.currentTask = q;
            i++;
            if (i >= 16 && LimitedDispatcher.p(this.this$0).isDispatchNeeded(this.this$0)) {
                LimitedDispatcher.p(this.this$0).dispatch(this.this$0, this);
                return;
            }
        }
    }
}
