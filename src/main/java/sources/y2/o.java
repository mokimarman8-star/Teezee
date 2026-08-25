package y2;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18660b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18661c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f18660b = str2;
        this.f18661c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f18645a.equals(oVar.f18645a) && Objects.equals(this.f18660b, oVar.f18660b) && Objects.equals(this.f18661c, oVar.f18661c);
    }

    public int hashCode() {
        int hashCode = (527 + this.f18645a.hashCode()) * 31;
        String str = this.f18660b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18661c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // y2.i
    public String toString() {
        return this.f18645a + ": url=" + this.f18661c;
    }
}
