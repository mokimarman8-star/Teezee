package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a2 extends i0 {
    public i0 limitedParallelism(int i, String str) {
        kotlinx.coroutines.internal.i.a(i);
        return kotlinx.coroutines.internal.i.b(this, str);
    }

    public abstract a2 p();

    protected final String q() {
        a2 a2Var;
        a2 c = y0.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        try {
            a2Var = c.p();
        } catch (UnsupportedOperationException unused) {
            a2Var = null;
        }
        if (this == a2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String q = q();
        if (q != null) {
            return q;
        }
        return p0.a(this) + '@' + p0.b(this);
    }
}
