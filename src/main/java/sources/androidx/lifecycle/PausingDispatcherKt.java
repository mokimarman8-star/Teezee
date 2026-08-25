package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class PausingDispatcherKt {
    public static final Object a(Lifecycle lifecycle, Function2 function2, Continuation continuation) {
        return b(lifecycle, Lifecycle.State.RESUMED, function2, continuation);
    }

    public static final Object b(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        return i.g(y0.c().p(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, function2, null), continuation);
    }
}
