package zc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    private static volatile d b;
    private final Set a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = b;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = b;
                    if (dVar == null) {
                        dVar = new d();
                        b = dVar;
                    }
                } finally {
                }
            }
        }
        return dVar;
    }

    Set b() {
        Set unmodifiableSet;
        synchronized (this.a) {
            unmodifiableSet = Collections.unmodifiableSet(this.a);
        }
        return unmodifiableSet;
    }
}
