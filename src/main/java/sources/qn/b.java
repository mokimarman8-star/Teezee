package qn;

import com.transsion.baselib.db.download.DownloadException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final String a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final String h;
    private final int i;
    private final int j;
    private final float k;
    private final int l;
    private final float m;

    public b() {
        this(null, null, null, 0, 0, 0, 0, null, 0, 0, 0.0f, 0, 0.0f, 8191, null);
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, int i4, String str4, int i5, int i6, float f, int i7, float f2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = str4;
        this.i = i5;
        this.j = i6;
        this.k = f;
        this.l = i7;
        this.m = f2;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i, int i2, int i3, int i4, String str4, int i5, int i6, float f, int i7, float f2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? 0 : i, (i8 & 16) != 0 ? 0 : i2, (i8 & 32) != 0 ? 0 : i3, (i8 & 64) != 0 ? 0 : i4, (i8 & 128) == 0 ? str4 : null, (i8 & 256) != 0 ? 0 : i5, (i8 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? 0 : i6, (i8 & 1024) != 0 ? 0.0f : f, (i8 & 2048) == 0 ? i7 : 0, (i8 & 4096) == 0 ? f2 : 0.0f);
    }

    public final int a() {
        return this.g;
    }

    public final String b() {
        return this.h;
    }

    public final int c() {
        return this.j;
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && Intrinsics.c(this.h, bVar.h) && this.i == bVar.i && this.j == bVar.j && Float.compare(this.k, bVar.k) == 0 && this.l == bVar.l && Float.compare(this.m, bVar.m) == 0;
    }

    public final int f() {
        return this.i;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        String str4 = this.h;
        return ((((((((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.i) * 31) + this.j) * 31) + Float.floatToIntBits(this.k)) * 31) + this.l) * 31) + Float.floatToIntBits(this.m);
    }

    public String toString() {
        return "TnFormat(id=" + this.a + ", label=" + this.b + ", language=" + this.c + ", selectionFlags=" + this.d + ", averageBitrate=" + this.e + ", peakBitrate=" + this.f + ", bitrate=" + this.g + ", codecs=" + this.h + ", width=" + this.i + ", height=" + this.j + ", frameRate=" + this.k + ", rotationDegrees=" + this.l + ", pixelWidthHeightRatio=" + this.m + ")";
    }
}
