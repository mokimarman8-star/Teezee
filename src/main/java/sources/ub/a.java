package ub;

import ub.e;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a extends e {
    private final e.a a;
    private final e.c b;
    private final e.b c;

    a(e.a aVar, e.c cVar, e.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.c = bVar;
    }

    @Override // ub.e
    public e.a a() {
        return this.a;
    }

    @Override // ub.e
    public e.b c() {
        return this.c;
    }

    @Override // ub.e
    public e.c d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a.equals(eVar.a()) && this.b.equals(eVar.d()) && this.c.equals(eVar.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.a + ", osData=" + this.b + ", deviceData=" + this.c + "}";
    }
}
