package y2;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18647b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18648c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18649d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f18647b = str;
        this.f18648c = str2;
        this.f18649d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f18648c, kVar.f18648c) && Objects.equals(this.f18647b, kVar.f18647b) && Objects.equals(this.f18649d, kVar.f18649d);
    }

    public int hashCode() {
        String str = this.f18647b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18648c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18649d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // y2.i
    public String toString() {
        return this.f18645a + ": domain=" + this.f18647b + ", description=" + this.f18648c;
    }
}
