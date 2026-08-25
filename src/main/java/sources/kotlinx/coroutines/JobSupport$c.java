package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class JobSupport$c extends w1 {
    final /* synthetic */ JobSupport e;

    public JobSupport$c(JobSupport jobSupport, kotlinx.coroutines.selects.f fVar) {
        this.e = jobSupport;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        Object state$kotlinx_coroutines_core = this.e.getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof b0)) {
            x1.h(state$kotlinx_coroutines_core);
        }
        throw null;
    }
}
