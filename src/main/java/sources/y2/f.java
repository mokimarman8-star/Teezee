package y2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f18636b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18637c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18638d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f18639e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f18636b = str;
        this.f18637c = str2;
        this.f18638d = str3;
        this.f18639e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.f18636b, fVar.f18636b) && Objects.equals(this.f18637c, fVar.f18637c) && Objects.equals(this.f18638d, fVar.f18638d) && Arrays.equals(this.f18639e, fVar.f18639e);
    }

    public int hashCode() {
        String str = this.f18636b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f18637c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18638d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f18639e);
    }

    @Override // y2.i
    public String toString() {
        return this.f18645a + ": mimeType=" + this.f18636b + ", filename=" + this.f18637c + ", description=" + this.f18638d;
    }
}
