package q1;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a implements AutoCloseable, n0 {

    /* renamed from: a, reason: collision with root package name */
    private final CoroutineContext f17000a;

    public a(CoroutineContext coroutineContext) {
        Intrinsics.h(coroutineContext, "coroutineContext");
        this.f17000a = coroutineContext;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        v1.e(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f17000a;
    }
}
