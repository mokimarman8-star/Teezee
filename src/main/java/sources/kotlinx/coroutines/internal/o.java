package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.a2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o {
    public static final o a;
    public static final a2 b;

    static {
        o oVar = new o();
        a = oVar;
        a0.f("kotlinx.coroutines.fast.service.loader", true);
        b = oVar.a();
    }

    private o() {
    }

    private final a2 a() {
        Object next;
        a2 e;
        try {
            List C = SequencesKt.C(SequencesKt.e(ServiceLoader.load(n.class, n.class.getClassLoader()).iterator()));
            Iterator it = C.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c = ((n) next).c();
                    do {
                        Object next2 = it.next();
                        int c2 = ((n) next2).c();
                        if (c < c2) {
                            next = next2;
                            c = c2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            n nVar = (n) next;
            if (nVar != null && (e = p.e(nVar, C)) != null) {
                return e;
            }
            p.b(null, null, 3, null);
            return null;
        } catch (Throwable th) {
            p.b(th, null, 2, null);
            return null;
        }
    }
}
