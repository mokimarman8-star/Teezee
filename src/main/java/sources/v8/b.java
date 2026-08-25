package v8;

import android.content.Context;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b extends f {
    private final Context a;
    private final e9.a b;
    private final e9.a c;
    private final String d;

    b(Context context, e9.a aVar, e9.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.d = str;
    }

    @Override // v8.f
    public Context b() {
        return this.a;
    }

    @Override // v8.f
    public String c() {
        return this.d;
    }

    @Override // v8.f
    public e9.a d() {
        return this.c;
    }

    @Override // v8.f
    public e9.a e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.b()) && this.b.equals(fVar.e()) && this.c.equals(fVar.d()) && this.d.equals(fVar.c());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.b + ", monotonicClock=" + this.c + ", backendName=" + this.d + "}";
    }
}
