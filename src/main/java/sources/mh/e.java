package mh;

import androidx.collection.s;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e {
    public static final a J = new a(null);
    private int A;
    private String B;
    private String C;
    private String D;
    private String E;
    private int F;
    private String G;
    private String H;
    private int I;
    private int a;
    private String b;
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(int i, String str) {
            e eVar = new e(0, null, 0, 0, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, 0, -1, 7, null);
            eVar.l0(i);
            eVar.N(str);
            return eVar;
        }
    }

    public e() {
        this(0, null, 0, 0, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, 0, -1, 7, null);
    }

    public e(int i, String str, int i2, int i3, String str2, String str3, String str4, String str5, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j10, long j11, long j12, long j13, long j14, String str6, String str7, String str8, String str9, String str10, String str11, int i4, String str12, String str13, String str14, String str15, int i5, String str16, String str17, int i6) {
        Intrinsics.h(str, "callId");
        Intrinsics.h(str2, "errorMsg");
        Intrinsics.h(str3, "serverApi");
        Intrinsics.h(str5, "ipAddr");
        Intrinsics.h(str6, "cdnSpeed");
        Intrinsics.h(str7, "cdnIp");
        Intrinsics.h(str8, "cdnProvider");
        Intrinsics.h(str9, "country");
        Intrinsics.h(str10, TmcConstants.EXTRA_PATH);
        Intrinsics.h(str11, "host");
        Intrinsics.h(str13, "sdkVersion");
        Intrinsics.h(str14, "protocol");
        Intrinsics.h(str15, "compareTag");
        Intrinsics.h(str16, "contentEncoding");
        Intrinsics.h(str17, "tlsVersion");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = j;
        this.j = j2;
        this.k = j3;
        this.l = j4;
        this.m = j5;
        this.n = j6;
        this.o = j7;
        this.p = j10;
        this.q = j11;
        this.r = j12;
        this.s = j13;
        this.t = j14;
        this.u = str6;
        this.v = str7;
        this.w = str8;
        this.x = str9;
        this.y = str10;
        this.z = str11;
        this.A = i4;
        this.B = str12;
        this.C = str13;
        this.D = str14;
        this.E = str15;
        this.F = i5;
        this.G = str16;
        this.H = str17;
        this.I = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ e(int i, String str, int i2, int i3, String str2, String str3, String str4, String str5, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j10, long j11, long j12, long j13, long j14, String str6, String str7, String str8, String str9, String str10, String str11, int i4, String str12, String str13, String str14, String str15, int i5, String str16, String str17, int i6, int i7, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, r6, r7, r8, r9, r10, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r12, r11, r36, r37, r2, (16777216 & i7) != 0 ? r48 : str10, (i7 & 33554432) != 0 ? r48 : str11, (i7 & 67108864) != 0 ? 0 : i4, (i7 & 134217728) != 0 ? "All" : str12, (i7 & 268435456) != 0 ? "1.0.17.1" : str13, (i7 & 536870912) != 0 ? r48 : str14, (i7 & MemoryConstants.GB) != 0 ? r48 : str15, (i7 & Integer.MIN_VALUE) != 0 ? 1 : i5, (i10 & 1) != 0 ? r48 : str16, (i10 & 2) != 0 ? r48 : str17, (i10 & 4) != 0 ? 0 : i6);
        String str18;
        String str19;
        String str20;
        int i11 = (i7 & 1) != 0 ? 0 : i;
        if ((i7 & 2) != 0) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "randomUUID().toString()");
            str18 = new Regex("-").replace(uuid, "");
        } else {
            str18 = str;
        }
        int i12 = (i7 & 4) != 0 ? 0 : i2;
        int i13 = (i7 & 8) != 0 ? 0 : i3;
        String str21 = (i7 & 16) != 0 ? "" : str2;
        String str22 = (i7 & 32) != 0 ? "" : str3;
        String str23 = (i7 & 64) != 0 ? null : str4;
        String str24 = (i7 & 128) != 0 ? "" : str5;
        long j15 = (i7 & 256) != 0 ? 0L : j;
        long j16 = (i7 & 512) != 0 ? 0L : j2;
        long j17 = (i7 & MemoryConstants.KB) != 0 ? 0L : j3;
        long j18 = (i7 & 2048) != 0 ? 0L : j4;
        long j19 = (i7 & 4096) != 0 ? 0L : j5;
        long j20 = (i7 & 8192) != 0 ? 0L : j6;
        long j21 = (i7 & 16384) != 0 ? 0L : j7;
        long j22 = (32768 & i7) != 0 ? 0L : j10;
        long j23 = (65536 & i7) != 0 ? 0L : j11;
        long j24 = (131072 & i7) != 0 ? 0L : j12;
        long j25 = (262144 & i7) != 0 ? 0L : j13;
        long j26 = (524288 & i7) == 0 ? j14 : 0L;
        String str25 = (1048576 & i7) != 0 ? "" : str6;
        String str26 = (i7 & 2097152) != 0 ? "" : str7;
        String str27 = (i7 & 4194304) != 0 ? "" : str8;
        if ((i7 & 8388608) != 0) {
            str20 = o.a();
            str19 = "";
            Intrinsics.g(str20, "getCountry()");
        } else {
            str19 = "";
            str20 = str9;
        }
    }

    public final long A() {
        return this.l;
    }

    public final String B() {
        return this.f;
    }

    public final long C() {
        return this.r;
    }

    public final long D() {
        return this.k;
    }

    public final long E() {
        return this.j;
    }

    public final String F() {
        return this.H;
    }

    public final int G() {
        return this.a;
    }

    public final long H() {
        return this.m;
    }

    public final void I(int i) {
        this.c = i;
    }

    public final void J(long j) {
        this.t = j;
    }

    public final void K(String str) {
        Intrinsics.h(str, "<set-?>");
        this.w = str;
    }

    public final void L(long j) {
        this.s = j;
    }

    public final void M(String str) {
        Intrinsics.h(str, "<set-?>");
        this.u = str;
    }

    public final void N(String str) {
        this.B = str;
    }

    public final void O(String str) {
        Intrinsics.h(str, "<set-?>");
        this.E = str;
    }

    public final void P(String str) {
        this.g = str;
    }

    public final void Q(String str) {
        Intrinsics.h(str, "<set-?>");
        this.G = str;
    }

    public final void R(long j) {
        this.i = j;
    }

    public final void S(int i) {
        this.d = i;
    }

    public final void T(String str) {
        Intrinsics.h(str, "<set-?>");
        this.e = str;
    }

    public final void U(String str) {
        Intrinsics.h(str, "<set-?>");
        this.z = str;
    }

    public final void V(int i) {
        this.F = i;
    }

    public final void W(String str) {
        Intrinsics.h(str, "<set-?>");
        this.h = str;
    }

    public final void X(int i) {
        this.A = i;
    }

    public final void Y(String str) {
        Intrinsics.h(str, "<set-?>");
        this.y = str;
    }

    public final void Z(String str) {
        Intrinsics.h(str, "<set-?>");
        this.D = str;
    }

    public final String a() {
        return this.b;
    }

    public final void a0(long j) {
        this.n = j;
    }

    public final int b() {
        return this.c;
    }

    public final void b0(long j) {
        this.p = j;
    }

    public final long c() {
        return this.t;
    }

    public final void c0(long j) {
        this.o = j;
    }

    public final String d() {
        return this.w;
    }

    public final void d0(int i) {
        this.I = i;
    }

    public final long e() {
        return this.s;
    }

    public final void e0(long j) {
        this.q = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && Intrinsics.c(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d && Intrinsics.c(this.e, eVar.e) && Intrinsics.c(this.f, eVar.f) && Intrinsics.c(this.g, eVar.g) && Intrinsics.c(this.h, eVar.h) && this.i == eVar.i && this.j == eVar.j && this.k == eVar.k && this.l == eVar.l && this.m == eVar.m && this.n == eVar.n && this.o == eVar.o && this.p == eVar.p && this.q == eVar.q && this.r == eVar.r && this.s == eVar.s && this.t == eVar.t && Intrinsics.c(this.u, eVar.u) && Intrinsics.c(this.v, eVar.v) && Intrinsics.c(this.w, eVar.w) && Intrinsics.c(this.x, eVar.x) && Intrinsics.c(this.y, eVar.y) && Intrinsics.c(this.z, eVar.z) && this.A == eVar.A && Intrinsics.c(this.B, eVar.B) && Intrinsics.c(this.C, eVar.C) && Intrinsics.c(this.D, eVar.D) && Intrinsics.c(this.E, eVar.E) && this.F == eVar.F && Intrinsics.c(this.G, eVar.G) && Intrinsics.c(this.H, eVar.H) && this.I == eVar.I;
    }

    public final String f() {
        return this.u;
    }

    public final void f0(long j) {
        this.l = j;
    }

    public final String g() {
        return this.B;
    }

    public final void g0(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f = str;
    }

    public final String h() {
        return this.E;
    }

    public final void h0(long j) {
        this.r = j;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.h.hashCode()) * 31) + s.a(this.i)) * 31) + s.a(this.j)) * 31) + s.a(this.k)) * 31) + s.a(this.l)) * 31) + s.a(this.m)) * 31) + s.a(this.n)) * 31) + s.a(this.o)) * 31) + s.a(this.p)) * 31) + s.a(this.q)) * 31) + s.a(this.r)) * 31) + s.a(this.s)) * 31) + s.a(this.t)) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31) + this.A) * 31;
        String str2 = this.B;
        return ((((((((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31) + this.E.hashCode()) * 31) + this.F) * 31) + this.G.hashCode()) * 31) + this.H.hashCode()) * 31) + this.I;
    }

    public final String i() {
        return this.g;
    }

    public final void i0(long j) {
        this.k = j;
    }

    public final String j() {
        return this.G;
    }

    public final void j0(long j) {
        this.j = j;
    }

    public final String k() {
        return this.x;
    }

    public final void k0(String str) {
        Intrinsics.h(str, "<set-?>");
        this.H = str;
    }

    public final long l() {
        return this.i;
    }

    public final void l0(int i) {
        this.a = i;
    }

    public final int m() {
        return this.d;
    }

    public final void m0(long j) {
        this.m = j;
    }

    public final String n() {
        return this.e;
    }

    public final String o() {
        return this.z;
    }

    public final int p() {
        return this.F;
    }

    public final String q() {
        return this.h;
    }

    public final int r() {
        return this.A;
    }

    public final String s() {
        return this.y;
    }

    public final String t() {
        return this.D;
    }

    public String toString() {
        return "{\n                    usage            : " + this.a + "\n                    call_id          : " + this.b + "\n                    call_result_code : " + this.c + "\n                    server_api       : " + this.f + "\n                    complete_api     : " + this.g + "\n                    ip_address       : " + this.h + "\n                    error_code       : " + this.d + "\n                    error_msg        : " + this.e + "\n                    req_time         : " + this.o + "ms\n                    dns_time         : " + this.i + "ms\n                    tcp_time         : " + this.j + "ms\n                    ssl_time         : " + this.k + "ms\n                    send_time        : " + this.l + "ms\n                    wait_time        : " + this.m + "ms\n                    rec_time         : " + this.n + "ms\n                    req_body_size    : " + this.p + "b\n                    res_body_size    : " + this.q + "b\n                    server_time      : " + this.r + "ms\n                    cdn_req_time     : " + this.s + "ms\n                    cdn_down_time    : " + this.t + "ms\n                    cdn_speed        : " + this.u + "kb/s\n                    cdn_provider     : " + this.w + "\n                    country          : " + this.x + "\n                    path             : " + this.y + "\n                    host             : " + this.z + "\n                    channel          : " + this.B + "\n                    sdk_version      : " + this.C + "\n                    protocol         : " + this.D + "\n                    compare_tag      : " + this.E + "\n                    http_type        : " + this.F + "\n                    content_encoding : " + this.G + "\n                    tls_version      : " + this.H + "\n                    request_downgrade : " + this.I + "\n                  }";
    }

    public final long u() {
        return this.n;
    }

    public final long v() {
        return this.p;
    }

    public final long w() {
        return this.o;
    }

    public final int x() {
        return this.I;
    }

    public final long y() {
        return this.q;
    }

    public final String z() {
        return this.C;
    }
}
