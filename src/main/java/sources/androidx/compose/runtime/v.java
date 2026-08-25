package androidx.compose.runtime;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f3050a;

    public v(kotlinx.coroutines.n0 n0Var) {
        this.f3050a = n0Var;
    }

    public final kotlinx.coroutines.n0 a() {
        return this.f3050a;
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.o0.c(this.f3050a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.o0.c(this.f3050a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
    }
}
