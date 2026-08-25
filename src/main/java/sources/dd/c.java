package dd;

import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c extends e {
    private final Set a;

    c(Set set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.a = set;
    }

    @Override // dd.e
    public Set b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.a.equals(((e) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.a + "}";
    }
}
