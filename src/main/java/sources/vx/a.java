package vx;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final long f;
    private final String g;
    private final int h;
    private final int i;
    private final String j;

    public a(int i, String str, String codecName, String str2, int i2, long j, String str3, int i3, int i4, String str4) {
        Intrinsics.h(codecName, "codecName");
        this.a = i;
        this.b = str;
        this.c = codecName;
        this.d = str2;
        this.e = i2;
        this.f = j;
        this.g = str3;
        this.h = i3;
        this.i = i4;
        this.j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && this.e == aVar.e && this.f == aVar.f && Intrinsics.c(this.g, aVar.g) && this.h == aVar.h && this.i == aVar.i && Intrinsics.c(this.j, aVar.j);
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
        String str2 = this.d;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.e) * 31) + s.a(this.f)) * 31;
        String str3 = this.g;
        int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.h) * 31) + this.i) * 31;
        String str4 = this.j;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AudioStream(index=" + this.a + ", title=" + this.b + ", codecName=" + this.c + ", language=" + this.d + ", disposition=" + this.e + ", bitRate=" + this.f + ", sampleFormat=" + this.g + ", sampleRate=" + this.h + ", channels=" + this.i + ", channelLayout=" + this.j + ")";
    }
}
