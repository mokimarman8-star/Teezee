package z9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return p0.c(this.a, hVar.a) && p0.c(this.b, hVar.b) && p0.c(this.c, hVar.c) && p0.c(this.d, hVar.d) && p0.c(this.e, hVar.e);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
