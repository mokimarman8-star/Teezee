package androidx.compose.runtime;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class r0 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f2874a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f2875b;

    /* renamed from: c, reason: collision with root package name */
    private kotlinx.coroutines.t1 f2876c;

    public r0(CoroutineContext coroutineContext, Function2 function2) {
        this.f2874a = function2;
        this.f2875b = kotlinx.coroutines.o0.a(coroutineContext);
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.t1 t1Var = this.f2876c;
        if (t1Var != null) {
            t1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f2876c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.t1 t1Var = this.f2876c;
        if (t1Var != null) {
            t1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f2876c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        kotlinx.coroutines.t1 t1Var = this.f2876c;
        if (t1Var != null) {
            kotlinx.coroutines.v1.f(t1Var, "Old job was still running!", (Throwable) null, 2, (Object) null);
        }
        this.f2876c = kotlinx.coroutines.i.d(this.f2875b, (CoroutineContext) null, (CoroutineStart) null, this.f2874a, 3, (Object) null);
    }
}
