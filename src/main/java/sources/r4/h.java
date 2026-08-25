package r4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    Object f17629a;

    /* renamed from: b, reason: collision with root package name */
    Object f17630b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(Object obj, Object obj2) {
        this.f17629a = obj;
        this.f17630b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof androidx.core.util.e)) {
            return false;
        }
        androidx.core.util.e eVar = (androidx.core.util.e) obj;
        return a(eVar.f7124a, this.f17629a) && a(eVar.f7125b, this.f17630b);
    }

    public int hashCode() {
        Object obj = this.f17629a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f17630b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f17629a + " " + this.f17630b + "}";
    }
}
