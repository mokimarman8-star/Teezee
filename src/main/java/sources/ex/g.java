package ex;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g {
    private String a;
    private String b;
    private int c;
    private long d;
    private int e;
    private int f;

    public g(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.e;
    }

    public final long c() {
        return this.d;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final void e(int i) {
        this.e = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.c(this.a, gVar.a) && Intrinsics.c(this.b, gVar.b) && this.c == gVar.c;
    }

    public final void f(long j) {
        this.d = j;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c;
    }

    public String toString() {
        return "DownloadStat(url=" + this.a + ", taskId=" + this.b + ", status=" + this.c + ")";
    }
}
