package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements r {
    private final Lifecycle a;
    private final CoroutineContext b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.h(lifecycle, "lifecycle");
        Intrinsics.h(coroutineContext, "coroutineContext");
        this.a = lifecycle;
        this.b = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            v1.e(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle a() {
        return this.a;
    }

    public final void c() {
        i.d(this, y0.c().p(), (CoroutineStart) null, new n0(this, null), 2, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    public void onStateChanged(u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "source");
        Intrinsics.h(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            v1.e(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }
}
