package na;

import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.q3;
import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c0 {
    public final int a;
    public final b3[] b;
    public final s[] c;
    public final q3 d;
    public final Object e;

    public c0(b3[] b3VarArr, s[] sVarArr, q3 q3Var, Object obj) {
        this.b = b3VarArr;
        this.c = (s[]) sVarArr.clone();
        this.d = q3Var;
        this.e = obj;
        this.a = b3VarArr.length;
    }

    public boolean a(c0 c0Var) {
        if (c0Var == null || c0Var.c.length != this.c.length) {
            return false;
        }
        for (int i = 0; i < this.c.length; i++) {
            if (!b(c0Var, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(c0 c0Var, int i) {
        return c0Var != null && p0.c(this.b[i], c0Var.b[i]) && p0.c(this.c[i], c0Var.c[i]);
    }

    public boolean c(int i) {
        return this.b[i] != null;
    }
}
