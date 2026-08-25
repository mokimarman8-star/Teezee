package kotlinx.coroutines;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlinx.coroutines.EventLoopImplBase;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: private */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0006j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00060\u0006j\u0002`\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "<init>", "(JLjava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class EventLoopImplBase$DelayedRunnableTask extends EventLoopImplBase.DelayedTask {
    private final Runnable block;

    public EventLoopImplBase$DelayedRunnableTask(long j, Runnable runnable) {
        super(j);
        this.block = runnable;
    }

    public void run() {
        this.block.run();
    }

    public String toString() {
        return super.toString() + this.block;
    }
}
