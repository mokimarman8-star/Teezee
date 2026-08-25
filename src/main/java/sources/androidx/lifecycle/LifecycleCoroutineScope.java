package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class LifecycleCoroutineScope implements n0 {
    public abstract Lifecycle a();

    public final t1 b(Function2 function2) {
        Intrinsics.h(function2, "block");
        return i.d(this, (CoroutineContext) null, (CoroutineStart) null, new launchWhenResumed.1(this, function2, (Continuation) null), 3, (Object) null);
    }
}
