package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class s extends w1 {
    public final CancellableContinuationImpl e;

    public s(CancellableContinuationImpl cancellableContinuationImpl) {
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return true;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        CancellableContinuationImpl cancellableContinuationImpl = this.e;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(t()));
    }
}
