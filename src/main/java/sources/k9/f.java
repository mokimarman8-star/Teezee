package k9;

import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class f implements a {
    public final ImmutableList a;
    private final int b;

    private f(int i, ImmutableList immutableList) {
        this.b = i;
        this.a = immutableList;
    }

    private static a a(int i, int i2, d0 d0Var) {
        switch (i) {
            case 1718776947:
                return g.d(i2, d0Var);
            case 1751742049:
                return c.b(d0Var);
            case 1752331379:
                return d.c(d0Var);
            case 1852994675:
                return h.a(d0Var);
            default:
                return null;
        }
    }

    public static f c(int i, d0 d0Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int f = d0Var.f();
        int i2 = -2;
        while (d0Var.a() > 8) {
            int q = d0Var.q();
            int e = d0Var.e() + d0Var.q();
            d0Var.O(e);
            a c = q == 1414744396 ? c(d0Var.q(), d0Var) : a(q, i2, d0Var);
            if (c != null) {
                if (c.getType() == 1752331379) {
                    i2 = ((d) c).b();
                }
                aVar.j(c);
            }
            d0Var.P(e);
            d0Var.O(f);
        }
        return new f(i, aVar.n());
    }

    public a b(Class cls) {
        r4 it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    @Override // k9.a
    public int getType() {
        return this.b;
    }
}
