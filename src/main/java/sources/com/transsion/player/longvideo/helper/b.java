package com.transsion.player.longvideo.helper;

import com.transsion.baselib.db.download.DownloadException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    public b() {
        this(null, null, null, null, null, null, null, null, 0, 0, 0, 0, 4095, null);
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, int i4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : str3, (i5 & 8) != 0 ? null : str4, (i5 & 16) != 0 ? null : str5, (i5 & 32) != 0 ? null : str6, (i5 & 64) != 0 ? null : str7, (i5 & 128) == 0 ? str8 : null, (i5 & 256) != 0 ? 3 : i, (i5 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) == 0 ? i2 : 3, (i5 & 1024) != 0 ? 24 : i3, (i5 & 2048) != 0 ? 10 : i4);
    }

    public final String a() {
        return this.f;
    }

    public final String b() {
        return this.g;
    }

    public final int c() {
        return this.k;
    }

    public final int d() {
        return this.j;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b) && Intrinsics.c(this.c, bVar.c) && Intrinsics.c(this.d, bVar.d) && Intrinsics.c(this.e, bVar.e) && Intrinsics.c(this.f, bVar.f) && Intrinsics.c(this.g, bVar.g) && Intrinsics.c(this.h, bVar.h) && this.i == bVar.i && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l;
    }

    public final String f() {
        return this.b;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.h;
        return ((((((((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l;
    }

    public final int i() {
        return this.i;
    }

    public final int j() {
        return this.l;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.d;
    }

    public String toString() {
        return "DataOperator(layoutTitle=" + this.a + ", layoutTips=" + this.b + ", layoutButton=" + this.c + ", title=" + this.d + ", tips=" + this.e + ", button=" + this.f + ", buttonIcon=" + this.g + ", link=" + this.h + ", normalDelay=" + this.i + ", fullscreenDelay=" + this.j + ", displayInterval=" + this.k + ", showDuration=" + this.l + ")";
    }
}
