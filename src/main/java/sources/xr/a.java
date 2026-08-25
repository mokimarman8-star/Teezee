package xr;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private final String h;

    public a(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6) {
        Intrinsics.h(str2, "subtitleResId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        this.g = i2;
        this.h = str6;
    }

    public final int a() {
        return this.f;
    }

    public final String b() {
        return this.h;
    }

    public final int c() {
        return this.g;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && Intrinsics.c(this.e, aVar.e) && this.f == aVar.f && this.g == aVar.g && Intrinsics.c(this.h, aVar.h);
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.b;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int hashCode4 = (((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f) * 31) + this.g) * 31;
        String str5 = this.h;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ShortTvSubDownloadBean(subjectId=" + this.a + ", subtitleResId=" + this.b + ", subjectName=" + this.c + ", titleName=" + this.d + ", shorTvId=" + this.e + ", ep=" + this.f + ", se=" + this.g + ", ops=" + this.h + ")";
    }
}
