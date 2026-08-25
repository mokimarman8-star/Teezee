package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class c1 extends w1 {
    private final a1 e;

    public c1(a1 a1Var) {
        this.e = a1Var;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        this.e.dispose();
    }
}
