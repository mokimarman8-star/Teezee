package r4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f17621c = new d("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    private final List f17622a;

    /* renamed from: b, reason: collision with root package name */
    private e f17623b;

    private d(d dVar) {
        this.f17622a = new ArrayList(dVar.f17622a);
        this.f17623b = dVar.f17623b;
    }

    public d(String... strArr) {
        this.f17622a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f17622a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public d a(String str) {
        d dVar = new d(this);
        dVar.f17622a.add(str);
        return dVar;
    }

    public boolean c(String str, int i5) {
        if (i5 >= this.f17622a.size()) {
            return false;
        }
        boolean z5 = i5 == this.f17622a.size() - 1;
        String str2 = (String) this.f17622a.get(i5);
        if (!str2.equals("**")) {
            return (z5 || (i5 == this.f17622a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z5 && ((String) this.f17622a.get(i5 + 1)).equals(str)) {
            return i5 == this.f17622a.size() + (-2) || (i5 == this.f17622a.size() + (-3) && b());
        }
        if (z5) {
            return true;
        }
        int i6 = i5 + 1;
        if (i6 < this.f17622a.size() - 1) {
            return false;
        }
        return ((String) this.f17622a.get(i6)).equals(str);
    }

    public e d() {
        return this.f17623b;
    }

    public int e(String str, int i5) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.f17622a.get(i5)).equals("**")) {
            return (i5 != this.f17622a.size() - 1 && ((String) this.f17622a.get(i5 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f17622a.equals(dVar.f17622a)) {
            return false;
        }
        e eVar = this.f17623b;
        e eVar2 = dVar.f17623b;
        return eVar != null ? eVar.equals(eVar2) : eVar2 == null;
    }

    public boolean g(String str, int i5) {
        if (f(str)) {
            return true;
        }
        if (i5 >= this.f17622a.size()) {
            return false;
        }
        return ((String) this.f17622a.get(i5)).equals(str) || ((String) this.f17622a.get(i5)).equals("**") || ((String) this.f17622a.get(i5)).equals("*");
    }

    public boolean h(String str, int i5) {
        return "__container".equals(str) || i5 < this.f17622a.size() - 1 || ((String) this.f17622a.get(i5)).equals("**");
    }

    public int hashCode() {
        int hashCode = this.f17622a.hashCode() * 31;
        e eVar = this.f17623b;
        return hashCode + (eVar != null ? eVar.hashCode() : 0);
    }

    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f17623b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f17622a);
        sb.append(",resolved=");
        sb.append(this.f17623b != null);
        sb.append('}');
        return sb.toString();
    }
}
