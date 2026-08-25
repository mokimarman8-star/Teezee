package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    private static final z a = new z("CLOSED");

    public static final b b(b bVar) {
        while (true) {
            Object g = bVar.g();
            if (g == a) {
                return bVar;
            }
            b bVar2 = (b) g;
            if (bVar2 != null) {
                bVar = bVar2;
            } else if (bVar.m()) {
                return bVar;
            }
        }
    }

    public static final Object c(w wVar, long j, Function2 function2) {
        while (true) {
            if (wVar.c >= j && !wVar.k()) {
                return x.a(wVar);
            }
            Object g = wVar.g();
            if (g == a) {
                return x.a(a);
            }
            w wVar2 = (w) ((b) g);
            if (wVar2 == null) {
                wVar2 = (w) function2.invoke(Long.valueOf(wVar.c + 1), wVar);
                if (wVar.o(wVar2)) {
                    if (wVar.k()) {
                        wVar.n();
                    }
                }
            }
            wVar = wVar2;
        }
    }
}
