package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class n1 implements n0 {
    public static final n1 a = new n1();

    private n1() {
    }

    @Override // kotlinx.coroutines.n0
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
