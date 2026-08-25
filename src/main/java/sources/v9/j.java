package v9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class j {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public j(Object obj) {
        this(obj, -1L);
    }

    public j(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private j(Object obj, int i, int i2, long j, int i3) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }

    public j(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public j(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }

    protected j(j jVar) {
        this.a = jVar.a;
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = jVar.d;
        this.e = jVar.e;
    }

    public j a(Object obj) {
        return this.a.equals(obj) ? this : new j(obj, this.b, this.c, this.d, this.e);
    }

    public boolean b() {
        return this.b != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && this.b == jVar.b && this.c == jVar.c && this.d == jVar.d && this.e == jVar.e;
    }

    public int hashCode() {
        return ((((((((527 + this.a.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }
}
