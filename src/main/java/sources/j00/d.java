package j00;

import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class d {
    private final j0 a;
    private final Throwable b;

    private d(j0 j0Var, Throwable th) {
        this.a = j0Var;
        this.b = th;
    }

    public static d a(Throwable th) {
        if (th != null) {
            return new d(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static d b(j0 j0Var) {
        if (j0Var != null) {
            return new d(j0Var, null);
        }
        throw new NullPointerException("response == null");
    }
}
