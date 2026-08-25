package ob;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b0 {
    private final Class a;
    private final Class b;

    private @interface a {
    }

    public b0(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public static b0 a(Class cls, Class cls2) {
        return new b0(cls, cls2);
    }

    public static b0 b(Class cls) {
        return new b0(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.b.equals(b0Var.b)) {
            return this.a.equals(b0Var.a);
        }
        return false;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        if (this.a == a.class) {
            return this.b.getName();
        }
        return "@" + this.a.getName() + " " + this.b.getName();
    }
}
