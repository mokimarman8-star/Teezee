package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.k1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends k1 implements Executor {
    public static final a b = new a();
    private static final i0 c;

    static {
        int e;
        h hVar = h.a;
        e = c0.e("kotlinx.coroutines.io.parallelism", RangesKt.e(64, a0.a()), 0, 0, 12, null);
        c = i0.limitedParallelism$default(hVar, e, (String) null, 2, (Object) null);
    }

    private a() {
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        c.dispatch(coroutineContext, runnable);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        c.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    public i0 limitedParallelism(int i, String str) {
        return h.a.limitedParallelism(i, str);
    }

    public Executor p() {
        return this;
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
