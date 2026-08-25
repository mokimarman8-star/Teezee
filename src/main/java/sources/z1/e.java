package z1;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f18786a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18787b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18788c;

    public e(String str, String str2, String str3) {
        this.f18786a = str;
        this.f18787b = str2;
        this.f18788c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f18786a, eVar.f18786a) && Objects.equals(this.f18787b, eVar.f18787b) && Objects.equals(this.f18788c, eVar.f18788c);
    }

    public int hashCode() {
        int hashCode = this.f18786a.hashCode() * 31;
        String str = this.f18787b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18788c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
