package ud;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c {
    private final List a;
    private final int b;

    c(List list, int i) {
        this.a = new ArrayList(list);
        this.b = i;
    }

    List a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    boolean c(List list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.a.equals(((c) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
