package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class t0 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f1492a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f1493b;

    public t0(Function1 function1, Function1 function12) {
        this.f1492a = function1;
        this.f1493b = function12;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1 a() {
        return this.f1492a;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1 b() {
        return this.f1493b;
    }
}
