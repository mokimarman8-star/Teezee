package androidx.coroutines;

import android.content.Context;
import androidx.work.impl.utils.futures.a;
import com.google.common.util.concurrent.r;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y0;
import kotlinx.coroutines.z;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\u00020 8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/i;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/r;", "Landroidx/work/i$a;", "n", "()Lcom/google/common/util/concurrent/r;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/e;", "t", "d", "", "l", "()V", "Lkotlinx/coroutines/z;", "e", "Lkotlinx/coroutines/z;", "getJob$work_runtime_ktx_release", "()Lkotlinx/coroutines/z;", "job", "Landroidx/work/impl/utils/futures/a;", "f", "Landroidx/work/impl/utils/futures/a;", "v", "()Landroidx/work/impl/utils/futures/a;", "future", "Lkotlinx/coroutines/i0;", "g", "Lkotlinx/coroutines/i0;", "s", "()Lkotlinx/coroutines/i0;", "getCoroutineContext$annotations", "coroutineContext", "work-runtime-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CoroutineWorker extends i {

    /* renamed from: e, reason: from kotlin metadata */
    private final z job;

    /* renamed from: f, reason: from kotlin metadata */
    private final a future;

    /* renamed from: g, reason: from kotlin metadata */
    private final i0 coroutineContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.h(context, "appContext");
        Intrinsics.h(workerParameters, "params");
        this.job = v1.b((t1) null, 1, (Object) null);
        a x = a.x();
        Intrinsics.g(x, "create()");
        this.future = x;
        x.addListener(new Runnable() { // from class: androidx.work.c
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineWorker.q(CoroutineWorker.this);
            }
        }, h().b());
        this.coroutineContext = y0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(CoroutineWorker coroutineWorker) {
        Intrinsics.h(coroutineWorker, "this$0");
        if (coroutineWorker.future.isCancelled()) {
            t1.a.b(coroutineWorker.job, (CancellationException) null, 1, (Object) null);
        }
    }

    static /* synthetic */ Object u(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public final r d() {
        z b = v1.b((t1) null, 1, (Object) null);
        n0 a = o0.a(getCoroutineContext().plus(b));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(b, (a) null, 2, (DefaultConstructorMarker) null);
        i.d(a, (CoroutineContext) null, (CoroutineStart) null, new getForegroundInfoAsync.1(jobListenableFuture, this, (Continuation) null), 3, (Object) null);
        return jobListenableFuture;
    }

    public final void l() {
        super.l();
        this.future.cancel(false);
    }

    public final r n() {
        i.d(o0.a(getCoroutineContext().plus(this.job)), (CoroutineContext) null, (CoroutineStart) null, new n0(this, null), 3, (Object) null);
        return this.future;
    }

    public abstract Object r(Continuation continuation);

    /* renamed from: s, reason: from getter */
    public i0 getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object t(Continuation continuation) {
        return u(this, continuation);
    }

    /* renamed from: v, reason: from getter */
    public final a getFuture() {
        return this.future;
    }
}
