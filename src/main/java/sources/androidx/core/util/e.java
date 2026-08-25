package androidx.core.util;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7124a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7125b;

    public e(Object obj, Object obj2) {
        this.f7124a = obj;
        this.f7125b = obj2;
    }

    public static e a(Object obj, Object obj2) {
        return new e(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d.a(eVar.f7124a, this.f7124a) && d.a(eVar.f7125b, this.f7125b);
    }

    public int hashCode() {
        Object obj = this.f7124a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f7125b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f7124a + " " + this.f7125b + "}";
    }
}
