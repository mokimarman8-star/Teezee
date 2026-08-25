package vz;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class h {
    private final String a;
    private final String b;
    private final o c;
    private final Object[] d;

    public h(String str, String str2, o oVar, Object... objArr) {
        this.a = str;
        this.b = str2;
        this.c = oVar;
        this.d = objArr;
    }

    public o a() {
        return this.c;
    }

    Object[] b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a) && this.b.equals(hVar.b) && this.c.equals(hVar.c) && Arrays.equals(this.d, hVar.d);
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ Integer.rotateLeft(this.b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.d), 24);
    }

    public String toString() {
        return this.a + " : " + this.b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
