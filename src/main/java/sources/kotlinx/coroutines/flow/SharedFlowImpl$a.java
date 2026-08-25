package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SharedFlowImpl$a implements kotlinx.coroutines.a1 {
    public final SharedFlowImpl a;
    public long b;
    public final Object c;
    public final Continuation d;

    public SharedFlowImpl$a(SharedFlowImpl sharedFlowImpl, long j, Object obj, Continuation continuation) {
        this.a = sharedFlowImpl;
        this.b = j;
        this.c = obj;
        this.d = continuation;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
        SharedFlowImpl.o(this.a, this);
    }
}
