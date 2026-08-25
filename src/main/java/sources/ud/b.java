package ud;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final td.b a;
    private final td.b b;
    private final td.c c;

    b(td.b bVar, td.b bVar2, td.c cVar) {
        this.a = bVar;
        this.b = bVar2;
        this.c = cVar;
    }

    td.c a() {
        return this.c;
    }

    td.b b() {
        return this.a;
    }

    td.b c() {
        return this.b;
    }

    boolean d() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.a, bVar.a) && Objects.equals(this.b, bVar.b) && Objects.equals(this.c, bVar.c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.a) ^ Objects.hashCode(this.b)) ^ Objects.hashCode(this.c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.a);
        sb2.append(" , ");
        sb2.append(this.b);
        sb2.append(" : ");
        td.c cVar = this.c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
