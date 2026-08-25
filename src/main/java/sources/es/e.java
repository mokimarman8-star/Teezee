package es;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    public static final e a = new e();
    private static final Set b = new LinkedHashSet();

    private e() {
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
