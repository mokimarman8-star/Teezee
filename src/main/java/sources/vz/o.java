package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class o {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;

    public o(int i, String str, String str2, String str3, boolean z) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a == oVar.a && this.e == oVar.e && this.b.equals(oVar.b) && this.c.equals(oVar.c) && this.d.equals(oVar.d);
    }

    public int hashCode() {
        return this.a + (this.e ? 64 : 0) + (this.b.hashCode() * this.c.hashCode() * this.d.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        sb.append(this.d);
        sb.append(" (");
        sb.append(this.a);
        sb.append(this.e ? " itf" : "");
        sb.append(')');
        return sb.toString();
    }
}
