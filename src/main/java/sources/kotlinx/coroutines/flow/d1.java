package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d1 extends kotlinx.coroutines.flow.internal.c {
    public long a = -1;
    public Continuation b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl sharedFlowImpl) {
        if (this.a >= 0) {
            return false;
        }
        this.a = sharedFlowImpl.Y();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation[] b(SharedFlowImpl sharedFlowImpl) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return sharedFlowImpl.X(j);
    }
}
