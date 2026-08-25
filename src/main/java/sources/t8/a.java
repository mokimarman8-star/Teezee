package t8;

import com.google.android.datatransport.Priority;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a extends d {
    private final Integer a;
    private final Object b;
    private final Priority c;
    private final f d;
    private final e e;

    a(Integer num, Object obj, Priority priority, f fVar, e eVar) {
        this.a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.c = priority;
        this.d = fVar;
        this.e = eVar;
    }

    @Override // t8.d
    public Integer a() {
        return this.a;
    }

    @Override // t8.d
    public e b() {
        return this.e;
    }

    @Override // t8.d
    public Object c() {
        return this.b;
    }

    @Override // t8.d
    public Priority d() {
        return this.c;
    }

    @Override // t8.d
    public f e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        f fVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.b.equals(dVar.c()) && this.c.equals(dVar.d()) && ((fVar = this.d) != null ? fVar.equals(dVar.e()) : dVar.e() == null)) {
                e eVar = this.e;
                if (eVar == null) {
                    if (dVar.b() == null) {
                        return true;
                    }
                } else if (eVar.equals(dVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003;
        f fVar = this.d;
        int hashCode2 = (hashCode ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        e eVar = this.e;
        return hashCode2 ^ (eVar != null ? eVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + ", productData=" + this.d + ", eventContext=" + this.e + "}";
    }
}
