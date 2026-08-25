package y9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import x9.m;
import z9.i;
import z9.j;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class f {
    public static n a(j jVar, String str, i iVar, int i) {
        return new n.b().i(iVar.b(str)).h(iVar.a).g(iVar.b).f(g(jVar, iVar)).b(i).a();
    }

    public static i9.d b(k kVar, int i, j jVar) {
        return c(kVar, i, jVar, 0);
    }

    public static i9.d c(k kVar, int i, j jVar, int i2) {
        if (jVar.m() == null) {
            return null;
        }
        x9.g f = f(i, jVar.b);
        try {
            e(f, kVar, jVar, i2, true);
            f.release();
            return f.b();
        } catch (Throwable th) {
            f.release();
            throw th;
        }
    }

    private static void d(k kVar, j jVar, int i, x9.g gVar, i iVar) {
        new m(kVar, a(jVar, ((z9.b) jVar.c.get(i)).a, iVar, 0), jVar.b, 0, null, gVar).load();
    }

    private static void e(x9.g gVar, k kVar, j jVar, int i, boolean z) {
        i iVar = (i) com.google.android.exoplayer2.util.a.e(jVar.m());
        if (z) {
            i l = jVar.l();
            if (l == null) {
                return;
            }
            i a = iVar.a(l, ((z9.b) jVar.c.get(i)).a);
            if (a == null) {
                d(kVar, jVar, i, gVar, iVar);
                iVar = l;
            } else {
                iVar = a;
            }
        }
        d(kVar, jVar, i, gVar, iVar);
    }

    private static x9.g f(int i, p1 p1Var) {
        String str = p1Var.k;
        return new x9.e((str == null || !(str.startsWith("video/webm") || str.startsWith("audio/webm"))) ? new q9.g() : new o9.e(), i, p1Var);
    }

    public static String g(j jVar, i iVar) {
        String j = jVar.j();
        return j != null ? j : iVar.b(((z9.b) jVar.c.get(0)).a).toString();
    }
}
