package androidx.view;

import androidx.compose.animation.core.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class s {
    public static final LifecycleCoroutineScope a(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        Intrinsics.h(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.c().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, l2.b((t1) null, 1, (Object) null).plus(y0.c().p()));
        } while (!j0.a(lifecycle.c(), null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.c();
        return lifecycleCoroutineScopeImpl;
    }
}
