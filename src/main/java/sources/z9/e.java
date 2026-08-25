package z9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;

    public e(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return p0.c(this.a, eVar.a) && p0.c(this.b, eVar.b) && p0.c(this.c, eVar.c);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
