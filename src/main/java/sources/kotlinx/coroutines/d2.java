package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d2 implements a1, t {
    public static final d2 a = new d2();

    private d2() {
    }

    @Override // kotlinx.coroutines.t
    public boolean a(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.t
    public t1 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
