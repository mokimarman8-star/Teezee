package ad;

import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a extends b {
    private final Set a;

    a(Set set) {
        if (set == null) {
            throw new NullPointerException("Null updatedKeys");
        }
        this.a = set;
    }

    @Override // ad.b
    public Set b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.a + "}";
    }
}
