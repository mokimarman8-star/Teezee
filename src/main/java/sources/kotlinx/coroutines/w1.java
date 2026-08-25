package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class w1 extends LockFreeLinkedListNode implements a1, p1 {
    public JobSupport d;

    @Override // kotlinx.coroutines.p1
    public b2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
        t().removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return true;
    }

    public final JobSupport t() {
        JobSupport jobSupport = this.d;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.y("job");
        return null;
    }

    public String toString() {
        return p0.a(this) + '@' + p0.b(this) + "[job@" + p0.b(t()) + ']';
    }

    public abstract boolean u();

    public abstract void v(Throwable th);

    public final void w(JobSupport jobSupport) {
        this.d = jobSupport;
    }
}
