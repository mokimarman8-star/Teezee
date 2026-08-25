package z1;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f18799a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18800b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18801c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18802d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18803e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f18799a = str;
        this.f18800b = str2;
        this.f18801c = str3;
        this.f18802d = str4;
        this.f18803e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Objects.equals(this.f18799a, hVar.f18799a) && Objects.equals(this.f18800b, hVar.f18800b) && Objects.equals(this.f18801c, hVar.f18801c) && Objects.equals(this.f18802d, hVar.f18802d) && Objects.equals(this.f18803e, hVar.f18803e);
    }

    public int hashCode() {
        String str = this.f18799a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18800b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18801c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f18802d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f18803e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
