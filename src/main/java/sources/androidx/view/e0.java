package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e0 extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final i f8294a = new i();

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.h(coroutineContext, "context");
        Intrinsics.h(runnable, "block");
        this.f8294a.c(coroutineContext, runnable);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        Intrinsics.h(coroutineContext, "context");
        if (y0.c().p().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.f8294a.b();
    }
}
