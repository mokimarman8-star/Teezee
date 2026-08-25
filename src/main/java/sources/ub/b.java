package ub;

import qb.f;
import ub.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends e.a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final f f;

    b(String str, String str2, String str3, String str4, int i, f fVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.d = str4;
        this.e = i;
        if (fVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f = fVar;
    }

    @Override // ub.e.a
    public String a() {
        return this.a;
    }

    @Override // ub.e.a
    public int c() {
        return this.e;
    }

    @Override // ub.e.a
    public f d() {
        return this.f;
    }

    @Override // ub.e.a
    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.a)) {
            return false;
        }
        e.a aVar = (e.a) obj;
        return this.a.equals(aVar.a()) && this.b.equals(aVar.f()) && this.c.equals(aVar.g()) && this.d.equals(aVar.e()) && this.e == aVar.c() && this.f.equals(aVar.d());
    }

    @Override // ub.e.a
    public String f() {
        return this.b;
    }

    @Override // ub.e.a
    public String g() {
        return this.c;
    }

    public int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.a + ", versionCode=" + this.b + ", versionName=" + this.c + ", installUuid=" + this.d + ", deliveryMechanism=" + this.e + ", developmentPlatformProvider=" + this.f + "}";
    }
}
