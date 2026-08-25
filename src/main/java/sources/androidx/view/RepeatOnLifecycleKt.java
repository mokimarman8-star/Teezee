package androidx.view;

import androidx.lifecycle.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        Object e5;
        if (state != Lifecycle.State.INITIALIZED) {
            return (lifecycle.b() != Lifecycle.State.DESTROYED && (e5 = o0.e(new C0191RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, function2, null), continuation)) == IntrinsicsKt.f()) ? e5 : Unit.a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final Object b(u uVar, Lifecycle.State state, Function2 function2, Continuation continuation) {
        Object a5 = a(uVar.getLifecycle(), state, function2, continuation);
        return a5 == IntrinsicsKt.f() ? a5 : Unit.a;
    }
}
