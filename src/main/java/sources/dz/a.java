package dz;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.commons.compress.archivers.zip.r;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a implements cz.a {
    private static final a[] w = new a[0];
    private String a;
    private final boolean b;
    private int c;
    private long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private byte i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private boolean s;
    private boolean t;
    private final File u;
    private final Map v;

    private a(boolean z) {
        this.a = HttpUrl.FRAGMENT_ENCODE_SET;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.j = HttpUrl.FRAGMENT_ENCODE_SET;
        this.k = "ustar\u0000";
        this.l = "00";
        this.n = HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = 0;
        this.p = 0;
        this.v = new HashMap();
        String property = System.getProperty("user.name", HttpUrl.FRAGMENT_ENCODE_SET);
        this.m = property.length() > 31 ? property.substring(0, 31) : property;
        this.u = null;
        this.b = z;
    }

    public a(byte[] bArr, r rVar, boolean z) {
        this(false);
        q(bArr, rVar, false, z);
    }

    private int b(byte[] bArr) {
        if (ez.a.c("ustar ", bArr, 257, 6)) {
            return 2;
        }
        if (ez.a.c("ustar\u0000", bArr, 257, 6)) {
            return ez.a.c("tar\u0000", bArr, 508, 4) ? 4 : 3;
        }
        return 0;
    }

    private static String o(String str, boolean z) {
        String lowerCase;
        int indexOf;
        if (!z && (lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private long p(byte[] bArr, int i, int i2, boolean z) {
        if (!z) {
            return d.h(bArr, i, i2);
        }
        try {
            return d.h(bArr, i, i2);
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private void q(byte[] bArr, r rVar, boolean z, boolean z2) {
        this.a = z ? d.e(bArr, 0, 100) : d.f(bArr, 0, 100, rVar);
        this.c = (int) p(bArr, 100, 8, z2);
        this.d = (int) p(bArr, 108, 8, z2);
        this.e = (int) p(bArr, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, 8, z2);
        this.f = d.h(bArr, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 12);
        this.g = p(bArr, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 12, z2);
        this.h = d.i(bArr);
        this.i = bArr[156];
        this.j = z ? d.e(bArr, 157, 100) : d.f(bArr, 157, 100, rVar);
        this.k = d.e(bArr, 257, 6);
        this.l = d.e(bArr, 263, 2);
        this.m = z ? d.e(bArr, 265, 32) : d.f(bArr, 265, 32, rVar);
        this.n = z ? d.e(bArr, 297, 32) : d.f(bArr, 297, 32, rVar);
        byte b = this.i;
        if (b == 51 || b == 52) {
            this.o = (int) p(bArr, 329, 8, z2);
            this.p = (int) p(bArr, 337, 8, z2);
        }
        int b2 = b(bArr);
        if (b2 == 2) {
            this.q = d.d(bArr, 482);
            this.r = d.g(bArr, 483, 12);
            return;
        }
        if (b2 == 4) {
            String e = z ? d.e(bArr, 345, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE) : d.f(bArr, 345, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, rVar);
            if (e.length() > 0) {
                this.a = e + "/" + this.a;
                return;
            }
            return;
        }
        String e2 = z ? d.e(bArr, 345, 155) : d.f(bArr, 345, 155, rVar);
        if (h() && !this.a.endsWith("/")) {
            this.a += "/";
        }
        if (e2.length() > 0) {
            this.a = e2 + "/" + this.a;
        }
    }

    private void r(String str, String str2, Map map) {
        str.hashCode();
        switch (str) {
            case "SCHILY.devmajor":
                s(Integer.parseInt(str2));
                break;
            case "SCHILY.devminor":
                t(Integer.parseInt(str2));
                break;
            case "GNU.sparse.realsize":
                d(map);
                break;
            case "GNU.sparse.size":
                c(map);
                break;
            case "gid":
                u(Long.parseLong(str2));
                break;
            case "uid":
                A(Long.parseLong(str2));
                break;
            case "path":
                y(str2);
                break;
            case "size":
                z(Long.parseLong(str2));
                break;
            case "gname":
                v(str2);
                break;
            case "mtime":
                x((long) (Double.parseDouble(str2) * 1000.0d));
                break;
            case "uname":
                B(str2);
                break;
            case "SCHILY.filetype":
                if ("sparse".equals(str2)) {
                    e(map);
                    break;
                }
                break;
            case "linkpath":
                w(str2);
                break;
            default:
                this.v.put(str, str2);
                break;
        }
    }

    public void A(long j) {
        this.d = j;
    }

    public void B(String str) {
        this.m = str;
    }

    void C(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            r((String) entry.getKey(), (String) entry.getValue(), map);
        }
    }

    public boolean a(a aVar) {
        return aVar != null && f().equals(aVar.f());
    }

    void c(Map map) {
        this.s = true;
        this.r = Integer.parseInt((String) map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.a = (String) map.get("GNU.sparse.name");
        }
    }

    void d(Map map) {
        this.s = true;
        this.r = Integer.parseInt((String) map.get("GNU.sparse.realsize"));
        this.a = (String) map.get("GNU.sparse.name");
    }

    void e(Map map) {
        this.t = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.r = Long.parseLong((String) map.get("SCHILY.realsize"));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public String f() {
        return this.a;
    }

    public long g() {
        return this.f;
    }

    public boolean h() {
        File file = this.u;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.i == 53) {
            return true;
        }
        return (n() || l() || !f().endsWith("/")) ? false : true;
    }

    public int hashCode() {
        return f().hashCode();
    }

    public boolean i() {
        return this.q;
    }

    public boolean j() {
        return this.i == 75;
    }

    public boolean k() {
        return this.i == 76;
    }

    public boolean l() {
        return this.i == 103;
    }

    public boolean m() {
        return this.i == 83;
    }

    public boolean n() {
        byte b = this.i;
        return b == 120 || b == 88;
    }

    public void s(int i) {
        if (i >= 0) {
            this.o = i;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i);
    }

    public void t(int i) {
        if (i >= 0) {
            this.p = i;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i);
    }

    public void u(long j) {
        this.e = j;
    }

    public void v(String str) {
        this.n = str;
    }

    public void w(String str) {
        this.j = str;
    }

    public void x(long j) {
        this.g = j / 1000;
    }

    public void y(String str) {
        this.a = o(str, this.b);
    }

    public void z(long j) {
        if (j >= 0) {
            this.f = j;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j);
    }
}
