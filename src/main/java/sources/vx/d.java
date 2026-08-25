package vx;

import androidx.collection.s;
import androidx.compose.animation.core.r;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final long f;
    private final double g;
    private final int h;
    private final int i;
    private final int j;

    public d(int i, String str, String codecName, String str2, int i2, long j, double d, int i3, int i4, int i5) {
        Intrinsics.h(codecName, "codecName");
        this.a = i;
        this.b = str;
        this.c = codecName;
        this.d = str2;
        this.e = i2;
        this.f = j;
        this.g = d;
        this.h = i3;
        this.i = i4;
        this.j = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && Intrinsics.c(this.b, dVar.b) && Intrinsics.c(this.c, dVar.c) && Intrinsics.c(this.d, dVar.d) && this.e == dVar.e && this.f == dVar.f && Double.compare(this.g, dVar.g) == 0 && this.h == dVar.h && this.i == dVar.i && this.j == dVar.j;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
        String str2 = this.d;
        return ((((((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e) * 31) + s.a(this.f)) * 31) + r.a(this.g)) * 31) + this.h) * 31) + this.i) * 31) + this.j;
    }

    public String toString() {
        return "VideoStream(index=" + this.a + ", title=" + this.b + ", codecName=" + this.c + ", language=" + this.d + ", disposition=" + this.e + ", bitRate=" + this.f + ", frameRate=" + this.g + ", frameWidth=" + this.h + ", frameHeight=" + this.i + ", rotation=" + this.j + ")";
    }
}
