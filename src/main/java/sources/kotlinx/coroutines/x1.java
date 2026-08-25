package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class x1 {
    private static final kotlinx.coroutines.internal.z a = new kotlinx.coroutines.internal.z("COMPLETING_ALREADY");
    public static final kotlinx.coroutines.internal.z b = new kotlinx.coroutines.internal.z("COMPLETING_WAITING_CHILDREN");
    private static final kotlinx.coroutines.internal.z c = new kotlinx.coroutines.internal.z("COMPLETING_RETRY");
    private static final kotlinx.coroutines.internal.z d = new kotlinx.coroutines.internal.z("TOO_LATE_TO_CANCEL");
    private static final kotlinx.coroutines.internal.z e = new kotlinx.coroutines.internal.z("SEALED");
    private static final d1 f = new d1(false);
    private static final d1 g = new d1(true);

    public static final Object g(Object obj) {
        return obj instanceof p1 ? new q1((p1) obj) : obj;
    }

    public static final Object h(Object obj) {
        p1 p1Var;
        q1 q1Var = obj instanceof q1 ? (q1) obj : null;
        return (q1Var == null || (p1Var = q1Var.a) == null) ? obj : p1Var;
    }
}
