package androidx.coroutines;

import androidx.coroutines.impl.utils.futures.a;
import com.google.common.util.concurrent.r;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class JobListenableFuture implements r {

    /* renamed from: a, reason: collision with root package name */
    private final t1 f13849a;

    /* renamed from: b, reason: collision with root package name */
    private final a f13850b;

    public JobListenableFuture(t1 t1Var, a aVar) {
        Intrinsics.h(t1Var, "job");
        Intrinsics.h(aVar, "underlying");
        this.f13849a = t1Var;
        this.f13850b = aVar;
        t1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.work.JobListenableFuture.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    if (!JobListenableFuture.this.f13850b.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else {
                    if (th instanceof CancellationException) {
                        JobListenableFuture.this.f13850b.cancel(true);
                        return;
                    }
                    a aVar2 = JobListenableFuture.this.f13850b;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    aVar2.u(th);
                }
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ JobListenableFuture(t1 t1Var, a aVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(t1Var, aVar);
        if ((i5 & 2) != 0) {
            aVar = a.x();
            Intrinsics.g(aVar, "create()");
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.f13850b.addListener(runnable, executor);
    }

    public final void c(Object obj) {
        this.f13850b.t(obj);
    }

    public boolean cancel(boolean z5) {
        return this.f13850b.cancel(z5);
    }

    public Object get() {
        return this.f13850b.get();
    }

    public Object get(long j5, TimeUnit timeUnit) {
        return this.f13850b.get(j5, timeUnit);
    }

    public boolean isCancelled() {
        return this.f13850b.isCancelled();
    }

    public boolean isDone() {
        return this.f13850b.isDone();
    }
}
