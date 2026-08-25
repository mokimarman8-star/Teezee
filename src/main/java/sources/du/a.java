package du;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import androidx.compose.foundation.e;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.d;
import java.util.Locale;
import jg.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okio.internal.Buffer;
import org.apache.tools.zip.UnixStat;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final C0055a r = new C0055a(null);
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;

    /* renamed from: du.a$a, reason: collision with other inner class name */
    public static final class C0055a {
        private C0055a() {
        }

        public /* synthetic */ C0055a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(a aVar) {
            if (aVar.q()) {
                throw new RuntimeException("the device isn‘t sender");
            }
            if (aVar.a()) {
                String b = b();
                String upperCase = d.a.a(4).toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                return b + "-5G-" + upperCase;
            }
            String b2 = b();
            String upperCase2 = d.a.a(4).toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase2, "toUpperCase(...)");
            return b2 + "-" + upperCase2;
        }

        private final String b() {
            String upperCase = d.a.a(2).toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            return "DIRECT-" + upperCase + "-MOVIEBOX";
        }

        public final a c(boolean z) {
            String str = null;
            a aVar = new a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, str, false, 131071, null);
            aVar.y("mb_unique");
            aVar.u(Build.DEVICE);
            aVar.s(Build.BRAND);
            aVar.w(Build.PRODUCT);
            aVar.C(Build.VERSION.RELEASE);
            aVar.D(String.valueOf(Build.VERSION.SDK_INT));
            aVar.A(String.valueOf(c.f()));
            aVar.B(c.h());
            aVar.v(c.e());
            b.a aVar2 = b.a;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            aVar.t(aVar2.e(a));
            aVar.z("userId");
            aVar.r("avatarIndex");
            if (z) {
                aVar.E("5G");
            } else {
                aVar.E("2.4G");
            }
            aVar.H(a(aVar));
            com.transsion.transfer.wifi.util.b bVar = com.transsion.transfer.wifi.util.b.a;
            String p = aVar.p();
            if (p == null) {
                p = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String substring = bVar.a(p).substring(0, 8);
            Intrinsics.g(substring, "substring(...)");
            aVar.G(substring);
            aVar.x(true);
            return aVar;
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 131071, null);
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = str15;
        this.p = str16;
        this.q = z;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & Buffer.SEGMENTING_THRESHOLD) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & UnixStat.FILE_FLAG) != 0 ? null : str16, (i & 65536) != 0 ? false : z);
    }

    public final void A(String str) {
        this.g = str;
    }

    public final void B(String str) {
        this.h = str;
    }

    public final void C(String str) {
        this.e = str;
    }

    public final void D(String str) {
        this.f = str;
    }

    public final void E(String str) {
        this.o = str;
    }

    public final void F(String str) {
        this.p = str;
    }

    public final void G(String str) {
        this.n = str;
    }

    public final void H(String str) {
        this.m = str;
    }

    public final boolean a() {
        return WifiUtils.a.n() && TextUtils.equals(this.o, "5G");
    }

    public final String b() {
        return this.l;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && Intrinsics.c(this.e, aVar.e) && Intrinsics.c(this.f, aVar.f) && Intrinsics.c(this.g, aVar.g) && Intrinsics.c(this.h, aVar.h) && Intrinsics.c(this.i, aVar.i) && Intrinsics.c(this.j, aVar.j) && Intrinsics.c(this.k, aVar.k) && Intrinsics.c(this.l, aVar.l) && Intrinsics.c(this.m, aVar.m) && Intrinsics.c(this.n, aVar.n) && Intrinsics.c(this.o, aVar.o) && Intrinsics.c(this.p, aVar.p) && this.q == aVar.q;
    }

    public final String f() {
        return this.i;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.k;
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
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.i;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.j;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.k;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.l;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.m;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.n;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.o;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.p;
        return ((hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31) + e.a(this.q);
    }

    public final String i() {
        return this.g;
    }

    public final String j() {
        return this.h;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.f;
    }

    public final String m() {
        return this.o;
    }

    public final String n() {
        return this.p;
    }

    public final String o() {
        return this.n;
    }

    public final String p() {
        return this.m;
    }

    public final boolean q() {
        return this.q;
    }

    public final void r(String str) {
        this.l = str;
    }

    public final void s(String str) {
        this.c = str;
    }

    public final void t(String str) {
        this.j = str;
    }

    public String toString() {
        return "WifiInfoModel(unique=" + this.a + ", device=" + this.b + ", brand=" + this.c + ", product=" + this.d + ", versionRelease=" + this.e + ", versionSdkInt=" + this.f + ", versionCode=" + this.g + ", versionName=" + this.h + ", packageName=" + this.i + ", channel=" + this.j + ", userId=" + this.k + ", avatarIndex=" + this.l + ", wifiSsid=" + this.m + ", wifiPwd=" + this.n + ", wifiChannel=" + this.o + ", wifiIp=" + this.p + ", isSender=" + this.q + ")";
    }

    public final void u(String str) {
        this.b = str;
    }

    public final void v(String str) {
        this.i = str;
    }

    public final void w(String str) {
        this.d = str;
    }

    public final void x(boolean z) {
        this.q = z;
    }

    public final void y(String str) {
        this.a = str;
    }

    public final void z(String str) {
        this.k = str;
    }
}
