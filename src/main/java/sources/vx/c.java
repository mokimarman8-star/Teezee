package vx;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;

    public c(int i, String str, String codecName, String str2, int i2) {
        Intrinsics.h(codecName, "codecName");
        this.a = i;
        this.b = str;
        this.c = codecName;
        this.d = str2;
        this.e = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Intrinsics.c(this.b, cVar.b) && Intrinsics.c(this.c, cVar.c) && Intrinsics.c(this.d, cVar.d) && this.e == cVar.e;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
        String str2 = this.d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e;
    }

    public String toString() {
        return "SubtitleStream(index=" + this.a + ", title=" + this.b + ", codecName=" + this.c + ", language=" + this.d + ", disposition=" + this.e + ")";
    }
}
