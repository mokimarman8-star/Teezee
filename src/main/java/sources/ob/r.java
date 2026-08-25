package ob;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class r {
    private final b0 a;
    private final int b;
    private final int c;

    private r(Class cls, int i, int i2) {
        this(b0.b(cls), i, i2);
    }

    private r(b0 b0Var, int i, int i2) {
        this.a = (b0) a0.c(b0Var, "Null dependency anInterface.");
        this.b = i;
        this.c = i2;
    }

    public static r a(Class cls) {
        return new r(cls, 0, 2);
    }

    private static String b(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    public static r h(Class cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class cls) {
        return new r(cls, 0, 1);
    }

    public static r j(b0 b0Var) {
        return new r(b0Var, 0, 1);
    }

    public static r k(Class cls) {
        return new r(cls, 1, 0);
    }

    public static r l(b0 b0Var) {
        return new r(b0Var, 1, 0);
    }

    public static r m(Class cls) {
        return new r(cls, 1, 1);
    }

    public static r n(b0 b0Var) {
        return new r(b0Var, 1, 1);
    }

    public static r o(Class cls) {
        return new r(cls, 2, 0);
    }

    public b0 c() {
        return this.a;
    }

    public boolean d() {
        return this.c == 2;
    }

    public boolean e() {
        return this.c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.a.equals(rVar.a) && this.b == rVar.b && this.c == rVar.c;
    }

    public boolean f() {
        return this.b == 1;
    }

    public boolean g() {
        return this.b == 2;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.a);
        sb2.append(", type=");
        int i = this.b;
        sb2.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb2.append(", injection=");
        sb2.append(b(this.c));
        sb2.append("}");
        return sb2.toString();
    }
}
