package y2;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18633b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18634c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18635d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f18633b = str;
        this.f18634c = str2;
        this.f18635d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f18634c, eVar.f18634c) && Objects.equals(this.f18633b, eVar.f18633b) && Objects.equals(this.f18635d, eVar.f18635d);
    }

    public int hashCode() {
        String str = this.f18633b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18634c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18635d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // y2.i
    public String toString() {
        return this.f18645a + ": language=" + this.f18633b + ", description=" + this.f18634c + ", text=" + this.f18635d;
    }
}
