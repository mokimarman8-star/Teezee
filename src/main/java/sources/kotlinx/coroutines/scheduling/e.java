package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e extends k1 {
    private final int b;
    private final int c;
    private final long d;
    private final String e;
    private CoroutineScheduler f;

    public e() {
        this(0, 0, 0L, null, 15, null);
    }

    public e(int i, int i2, long j, String str) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = str;
        this.f = q();
    }

    public /* synthetic */ e(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? g.c : i, (i3 & 2) != 0 ? g.d : i2, (i3 & 4) != 0 ? g.e : j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    private final CoroutineScheduler q() {
        return new CoroutineScheduler(this.b, this.c, this.d, this.e);
    }

    public void close() {
        this.f.close();
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.m(this.f, runnable, false, false, 6, (Object) null);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.m(this.f, runnable, false, true, 2, (Object) null);
    }

    public Executor p() {
        return this.f;
    }

    public final void r(Runnable runnable, boolean z, boolean z2) {
        this.f.l(runnable, z, z2);
    }
}
