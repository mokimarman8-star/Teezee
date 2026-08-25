package androidx.coroutines.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class RunBlockingUninterruptible_androidKt {
    public static final Object a(Function2 function2) {
        Intrinsics.h(function2, "block");
        Thread.interrupted();
        return i.f((CoroutineContext) null, new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(function2, null), 1, (Object) null);
    }
}
