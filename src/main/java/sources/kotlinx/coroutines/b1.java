package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class b1 implements m {
    private final a1 a;

    public b1(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable th) {
        this.a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
