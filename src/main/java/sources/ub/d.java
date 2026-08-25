package ub;

import ub.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class d extends e.c {
    private final String a;
    private final String b;
    private final boolean c;

    d(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.b = str2;
        this.c = z;
    }

    @Override // ub.e.c
    public boolean b() {
        return this.c;
    }

    @Override // ub.e.c
    public String c() {
        return this.b;
    }

    @Override // ub.e.c
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.c)) {
            return false;
        }
        e.c cVar = (e.c) obj;
        return this.a.equals(cVar.d()) && this.b.equals(cVar.c()) && this.c == cVar.b();
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ (this.c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.a + ", osCodeName=" + this.b + ", isRooted=" + this.c + "}";
    }
}
