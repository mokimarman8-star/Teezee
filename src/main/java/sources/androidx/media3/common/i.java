package androidx.media3.common;

import androidx.media3.common.util.a1;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    public static final i f8739h = new b().d(1).c(2).e(3).a();

    /* renamed from: i, reason: collision with root package name */
    public static final i f8740i = new b().d(1).c(1).e(2).a();

    /* renamed from: j, reason: collision with root package name */
    private static final String f8741j = a1.C0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f8742k = a1.C0(1);

    /* renamed from: l, reason: collision with root package name */
    private static final String f8743l = a1.C0(2);

    /* renamed from: m, reason: collision with root package name */
    private static final String f8744m = a1.C0(3);

    /* renamed from: n, reason: collision with root package name */
    private static final String f8745n = a1.C0(4);

    /* renamed from: o, reason: collision with root package name */
    private static final String f8746o = a1.C0(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f8747a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8748b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8749c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f8750d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8751e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8752f;

    /* renamed from: g, reason: collision with root package name */
    private int f8753g;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f8754a;

        /* renamed from: b, reason: collision with root package name */
        private int f8755b;

        /* renamed from: c, reason: collision with root package name */
        private int f8756c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f8757d;

        /* renamed from: e, reason: collision with root package name */
        private int f8758e;

        /* renamed from: f, reason: collision with root package name */
        private int f8759f;

        public b() {
            this.f8754a = -1;
            this.f8755b = -1;
            this.f8756c = -1;
            this.f8758e = -1;
            this.f8759f = -1;
        }

        private b(i iVar) {
            this.f8754a = iVar.f8747a;
            this.f8755b = iVar.f8748b;
            this.f8756c = iVar.f8749c;
            this.f8757d = iVar.f8750d;
            this.f8758e = iVar.f8751e;
            this.f8759f = iVar.f8752f;
        }

        public i a() {
            return new i(this.f8754a, this.f8755b, this.f8756c, this.f8757d, this.f8758e, this.f8759f);
        }

        public b b(int i5) {
            this.f8759f = i5;
            return this;
        }

        public b c(int i5) {
            this.f8755b = i5;
            return this;
        }

        public b d(int i5) {
            this.f8754a = i5;
            return this;
        }

        public b e(int i5) {
            this.f8756c = i5;
            return this;
        }

        public b f(byte[] bArr) {
            this.f8757d = bArr;
            return this;
        }

        public b g(int i5) {
            this.f8758e = i5;
            return this;
        }
    }

    private i(int i5, int i6, int i7, byte[] bArr, int i8, int i9) {
        this.f8747a = i5;
        this.f8748b = i6;
        this.f8749c = i7;
        this.f8750d = bArr;
        this.f8751e = i8;
        this.f8752f = i9;
    }

    private static String b(int i5) {
        if (i5 == -1) {
            return "NA";
        }
        return i5 + "bit Chroma";
    }

    private static String c(int i5) {
        if (i5 == -1) {
            return "Unset color range";
        }
        if (i5 == 1) {
            return "Full range";
        }
        if (i5 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i5;
    }

    private static String d(int i5) {
        if (i5 == -1) {
            return "Unset color space";
        }
        if (i5 == 6) {
            return "BT2020";
        }
        if (i5 == 1) {
            return "BT709";
        }
        if (i5 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i5;
    }

    private static String e(int i5) {
        if (i5 == -1) {
            return "Unset color transfer";
        }
        if (i5 == 10) {
            return "Gamma 2.2";
        }
        if (i5 == 1) {
            return "Linear";
        }
        if (i5 == 2) {
            return "sRGB";
        }
        if (i5 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i5 == 6) {
            return "ST2084 PQ";
        }
        if (i5 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i5;
    }

    public static boolean h(i iVar) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (iVar == null) {
            return true;
        }
        int i9 = iVar.f8747a;
        return (i9 == -1 || i9 == 1 || i9 == 2) && ((i5 = iVar.f8748b) == -1 || i5 == 2) && (((i6 = iVar.f8749c) == -1 || i6 == 3) && iVar.f8750d == null && (((i7 = iVar.f8752f) == -1 || i7 == 8) && ((i8 = iVar.f8751e) == -1 || i8 == 8)));
    }

    public static int j(int i5) {
        if (i5 == 1) {
            return 1;
        }
        if (i5 != 9) {
            return (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int k(int i5) {
        if (i5 == 1) {
            return 3;
        }
        if (i5 == 4) {
            return 10;
        }
        if (i5 == 13) {
            return 2;
        }
        if (i5 == 16) {
            return 6;
        }
        if (i5 != 18) {
            return (i5 == 6 || i5 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String l(int i5) {
        if (i5 == -1) {
            return "NA";
        }
        return i5 + "bit Luma";
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8747a == iVar.f8747a && this.f8748b == iVar.f8748b && this.f8749c == iVar.f8749c && Arrays.equals(this.f8750d, iVar.f8750d) && this.f8751e == iVar.f8751e && this.f8752f == iVar.f8752f;
    }

    public boolean f() {
        return (this.f8751e == -1 || this.f8752f == -1) ? false : true;
    }

    public boolean g() {
        return (this.f8747a == -1 || this.f8748b == -1 || this.f8749c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.f8753g == 0) {
            this.f8753g = ((((((((((527 + this.f8747a) * 31) + this.f8748b) * 31) + this.f8749c) * 31) + Arrays.hashCode(this.f8750d)) * 31) + this.f8751e) * 31) + this.f8752f;
        }
        return this.f8753g;
    }

    public boolean i() {
        return f() || g();
    }

    public String m() {
        String str;
        String G = g() ? a1.G("%s/%s/%s", d(this.f8747a), c(this.f8748b), e(this.f8749c)) : "NA/NA/NA";
        if (f()) {
            str = this.f8751e + "/" + this.f8752f;
        } else {
            str = "NA/NA";
        }
        return G + "/" + str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(d(this.f8747a));
        sb.append(", ");
        sb.append(c(this.f8748b));
        sb.append(", ");
        sb.append(e(this.f8749c));
        sb.append(", ");
        sb.append(this.f8750d != null);
        sb.append(", ");
        sb.append(l(this.f8751e));
        sb.append(", ");
        sb.append(b(this.f8752f));
        sb.append(")");
        return sb.toString();
    }
}
