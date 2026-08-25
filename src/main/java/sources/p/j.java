package p;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.w0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final w0 f16853a = c1.b(0, 16, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    @Override // p.i
    public boolean a(f fVar) {
        return b().b(fVar);
    }

    @Override // p.i
    public Object c(f fVar, Continuation continuation) {
        Object emit = b().emit(fVar, continuation);
        return emit == IntrinsicsKt.f() ? emit : Unit.a;
    }

    @Override // p.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public w0 b() {
        return this.f16853a;
    }
}
