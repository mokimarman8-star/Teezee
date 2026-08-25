package ln;

import com.transsion.player.p003enum.PlayMimeType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final PlayMimeType a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private String h;
    private String i;

    public c(PlayMimeType playMimeType, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.h(playMimeType, "format");
        Intrinsics.h(str, "id");
        Intrinsics.h(str2, "url");
        Intrinsics.h(str3, "resolutions");
        Intrinsics.h(str4, "size");
        Intrinsics.h(str5, "duration");
        Intrinsics.h(str6, "signCookie");
        this.a = playMimeType;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    public /* synthetic */ c(PlayMimeType playMimeType, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(playMimeType, str, str2, str3, str4, str5, str6, (i & 128) != 0 ? null : str7);
    }

    public final String a() {
        return this.f;
    }

    public final PlayMimeType b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.i;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Intrinsics.c(this.b, cVar.b) && Intrinsics.c(this.c, cVar.c) && Intrinsics.c(this.d, cVar.d) && Intrinsics.c(this.e, cVar.e) && Intrinsics.c(this.f, cVar.f) && Intrinsics.c(this.g, cVar.g) && Intrinsics.c(this.h, cVar.h);
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String str = this.h;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean i() {
        return StringsKt.c0(this.c, ".mp3", false, 2, (Object) null);
    }

    public final boolean j() {
        return StringsKt.W(this.c, "http", false, 2, (Object) null);
    }

    public final boolean k() {
        PlayMimeType playMimeType = this.a;
        return playMimeType == PlayMimeType.DASH || playMimeType == PlayMimeType.HLS;
    }

    public final void l(String str) {
        this.i = str;
    }

    public final void m(String str) {
        this.h = str;
    }

    public String toString() {
        return "LongVdPlayerStreamBean(format=" + this.a + ", id=" + this.b + ", url=" + this.c + ", resolutions=" + this.d + ", size=" + this.e + ", duration=" + this.f + ", signCookie=" + this.g + ", originalResolutions=" + this.h + ")";
    }
}
