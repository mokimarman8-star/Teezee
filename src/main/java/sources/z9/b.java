package z9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    public final String a;
    public final String b;
    public final int c;
    public final int d;

    public b(String str, String str2, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.c == bVar.c && this.d == bVar.d && com.google.common.base.j.a(this.a, bVar.a) && com.google.common.base.j.a(this.b, bVar.b);
    }

    public int hashCode() {
        return com.google.common.base.j.b(new Object[]{this.a, this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }
}
