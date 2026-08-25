package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class h extends i0 {
    public static final h a = new h();

    private h() {
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.g.r(runnable, true, false);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.g.r(runnable, true, true);
    }

    public i0 limitedParallelism(int i, String str) {
        kotlinx.coroutines.internal.i.a(i);
        return i >= g.d ? kotlinx.coroutines.internal.i.b(this, str) : super.limitedParallelism(i, str);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
