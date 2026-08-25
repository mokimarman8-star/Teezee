package kj;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();
    private static final Set b = new LinkedHashSet();

    private g() {
    }

    public final void a(String str) {
        if (str != null) {
            b.remove(str);
        }
    }

    public final void b(String str) {
        if (str != null) {
            b.add(str);
        }
    }
}
