package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class JobSupport$d extends w1 {
    final /* synthetic */ JobSupport e;

    public JobSupport$d(JobSupport jobSupport, kotlinx.coroutines.selects.f fVar) {
        this.e = jobSupport;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        Unit unit = Unit.a;
        throw null;
    }
}
