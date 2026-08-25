package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class i2 extends a {
    public i2(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    protected boolean handleJobException(Throwable th) {
        k0.a(getA(), th);
        return true;
    }
}
