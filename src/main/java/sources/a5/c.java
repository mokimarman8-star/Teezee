package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.aliyun.subtitle.LocationStyle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class c implements b, Closeable {
    private static final ThreadLocal q = new ThreadLocal();
    protected static final char[] r = ("\"" + com.alibaba.fastjson.a.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] s = new int[103];
    protected int a;
    protected int b;
    protected int c;
    protected char d;
    protected int e;
    protected int f;
    protected char[] g;
    protected int h;
    protected int i;
    protected boolean j;
    protected String o;
    protected Calendar k = null;
    protected TimeZone l = com.alibaba.fastjson.a.defaultTimeZone;
    protected Locale m = com.alibaba.fastjson.a.defaultLocale;
    public int n = 0;
    protected int p = 0;

    static {
        for (int i = 48; i <= 57; i++) {
            s[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            s[i2] = i2 - 87;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            s[i3] = i3 - 55;
        }
    }

    public c(int i) {
        this.o = null;
        this.c = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.o = "";
        }
        char[] cArr = (char[]) q.get();
        this.g = cArr;
        if (cArr == null) {
            this.g = new char[512];
        }
    }

    public static boolean M0(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public static String S0(char[] cArr, int i) {
        int i2;
        int i3;
        int i4;
        int i8 = 5;
        char[] cArr2 = new char[i];
        int i9 = 0;
        int i10 = 0;
        while (i9 < i) {
            char c = cArr[i9];
            if (c != '\\') {
                cArr2[i10] = c;
                i2 = i8;
                i10++;
            } else {
                int i11 = i9 + 1;
                char c2 = cArr[i11];
                if (c2 == '\"') {
                    i2 = i8;
                    i3 = i10 + 1;
                    cArr2[i10] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i8;
                            i3 = i10 + 1;
                            cArr2[i10] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i8;
                            i3 = i10 + 1;
                            cArr2[i10] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i8;
                                i3 = i10 + 1;
                                cArr2[i10] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i8;
                                i3 = i10 + 1;
                                cArr2[i10] = '\r';
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = '/';
                                        break;
                                    case '0':
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = 0;
                                        break;
                                    case '1':
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = 1;
                                        break;
                                    case TTAdConstant.IMAGE_MODE_VIDEO_SQUARE /* 50 */:
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = 2;
                                        break;
                                    case '3':
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = 3;
                                        break;
                                    case '4':
                                        i2 = i8;
                                        i3 = i10 + 1;
                                        cArr2[i10] = 4;
                                        break;
                                    case '5':
                                        i3 = i10 + 1;
                                        i2 = 5;
                                        cArr2[i10] = 5;
                                        break;
                                    case '6':
                                        i4 = i10 + 1;
                                        cArr2[i10] = 6;
                                        i10 = i4;
                                        i9 = i11;
                                        i2 = 5;
                                        break;
                                    case '7':
                                        i4 = i10 + 1;
                                        cArr2[i10] = 7;
                                        i10 = i4;
                                        i9 = i11;
                                        i2 = 5;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i4 = i10 + 1;
                                                cArr2[i10] = '\t';
                                                i10 = i4;
                                                i9 = i11;
                                                i2 = 5;
                                                break;
                                            case 'u':
                                                char c3 = cArr[i9 + 2];
                                                char c4 = cArr[i9 + 3];
                                                char c8 = cArr[i9 + 4];
                                                i9 += i8;
                                                cArr2[i10] = (char) Integer.parseInt(new String(new char[]{c3, c4, c8, cArr[i9]}), 16);
                                                i10++;
                                                i2 = 5;
                                                break;
                                            case 'v':
                                                cArr2[i10] = 11;
                                                i2 = i8;
                                                i10++;
                                                i9 = i11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i8;
                                int[] iArr = s;
                                int i12 = iArr[cArr[i9 + 2]] * 16;
                                i9 += 3;
                                cArr2[i10] = (char) (i12 + iArr[cArr[i9]]);
                                i10++;
                            }
                        }
                    }
                    i2 = i8;
                    i3 = i10 + 1;
                    cArr2[i10] = '\f';
                } else {
                    i2 = i8;
                    i3 = i10 + 1;
                    cArr2[i10] = '\'';
                }
                i10 = i3;
                i9 = i11;
            }
            i9++;
            i8 = i2;
        }
        return new String(cArr2, 0, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0149, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l1() {
        this.i = this.e;
        this.j = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.a = 4;
                next();
                return;
            }
            if (next == 26) {
                if (L0()) {
                    throw new JSONException("unclosed single-quote string");
                }
                R0((char) 26);
            } else if (next == '\\') {
                if (!this.j) {
                    this.j = true;
                    int i = this.h;
                    char[] cArr = this.g;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[i * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.g = cArr2;
                    }
                    H0(this.i + 1, this.h, this.g);
                }
                char next2 = next();
                if (next2 == '\"') {
                    R0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            R0('\\');
                        } else if (next2 == 'b') {
                            R0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                R0('\n');
                            } else if (next2 == 'r') {
                                R0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        R0('/');
                                        break;
                                    case '0':
                                        R0((char) 0);
                                        break;
                                    case '1':
                                        R0((char) 1);
                                        break;
                                    case TTAdConstant.IMAGE_MODE_VIDEO_SQUARE /* 50 */:
                                        R0((char) 2);
                                        break;
                                    case '3':
                                        R0((char) 3);
                                        break;
                                    case '4':
                                        R0((char) 4);
                                        break;
                                    case '5':
                                        R0((char) 5);
                                        break;
                                    case '6':
                                        R0((char) 6);
                                        break;
                                    case '7':
                                        R0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                R0('\t');
                                                break;
                                            case 'u':
                                                R0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                R0((char) 11);
                                                break;
                                            default:
                                                this.d = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z2 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (z && z2) {
                                    int[] iArr = s;
                                    R0((char) ((iArr[next3] * 16) + iArr[next4]));
                                }
                            }
                        }
                    }
                    R0('\f');
                } else {
                    R0('\'');
                }
            } else if (this.j) {
                int i2 = this.h;
                char[] cArr3 = this.g;
                if (i2 == cArr3.length) {
                    R0(next);
                } else {
                    this.h = i2 + 1;
                    cArr3[i2] = next;
                }
            } else {
                this.h++;
            }
        }
    }

    @Override // a5.b
    public final Number B0(boolean z) {
        char G0 = G0((this.i + this.h) - 1);
        try {
            return G0 == 'F' ? Float.valueOf(Float.parseFloat(E0())) : G0 == 'D' ? Double.valueOf(Double.parseDouble(E0())) : z ? g0() : Double.valueOf(I0());
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + k());
        }
    }

    @Override // a5.b
    public Locale D0() {
        return this.m;
    }

    @Override // a5.b
    public abstract String E0();

    public abstract char G0(int i);

    protected abstract void H0(int i, int i2, char[] cArr);

    public double I0() {
        return Double.parseDouble(E0());
    }

    public Calendar J0() {
        return this.k;
    }

    public abstract int K0(char c, int i);

    public abstract boolean L0();

    protected void N0(String str, Object... objArr) {
        this.a = 1;
    }

    public final boolean O0(char[] cArr) {
        while (!j(cArr)) {
            if (!M0(this.d)) {
                return false;
            }
            next();
        }
        int length = this.e + cArr.length;
        this.e = length;
        char G0 = G0(length);
        this.d = G0;
        if (G0 == '{') {
            next();
            this.a = 12;
        } else if (G0 == '[') {
            next();
            this.a = 14;
        } else if (G0 == 'S' && G0(this.e + 1) == 'e' && G0(this.e + 2) == 't' && G0(this.e + 3) == '[') {
            int i = this.e + 3;
            this.e = i;
            this.d = G0(i);
            this.a = 21;
        } else {
            d0();
        }
        return true;
    }

    public final void P0() {
        while (M0(this.d)) {
            next();
        }
        char c = this.d;
        if (c == '_' || c == '$' || Character.isLetter(c)) {
            i1();
        } else {
            d0();
        }
    }

    public final void Q0(char c) {
        this.h = 0;
        while (true) {
            char c2 = this.d;
            if (c2 == c) {
                next();
                d0();
                return;
            }
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.d + ", info : " + k());
            }
            next();
        }
    }

    protected final void R0(char c) {
        int i = this.h;
        char[] cArr = this.g;
        if (i >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i) {
                length = i + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.g = cArr2;
        }
        char[] cArr3 = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        cArr3[i2] = c;
    }

    @Override // a5.b
    public Enum S(Class cls, i iVar, char c) {
        String m1 = m1(iVar, c);
        if (m1 == null) {
            return null;
        }
        return Enum.valueOf(cls, m1);
    }

    @Override // a5.b
    public final String T(i iVar) {
        if (this.a == 1 && this.b == 0 && this.e == 1) {
            this.e = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.f.d;
        int i = this.d;
        if (i < zArr.length && !zArr[i]) {
            throw new JSONException("illegal identifier : " + this.d + k());
        }
        boolean[] zArr2 = com.alibaba.fastjson.util.f.e;
        this.i = this.e;
        this.h = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i = (i * 31) + next;
            this.h++;
        }
        this.d = G0(this.e);
        this.a = 18;
        if (this.h == 4 && i == 3392903 && G0(this.i) == 'n' && G0(this.i + 1) == 'u' && G0(this.i + 2) == 'l' && G0(this.i + 3) == 'l') {
            return null;
        }
        return iVar == null ? r1(this.i, this.h) : b(this.i, this.h, i, iVar);
    }

    public long T0(char[] cArr) {
        this.n = 0;
        if (!j(cArr)) {
            this.n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (G0(this.e + length) != '\"') {
            this.n = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char G0 = G0(this.e + i);
            if (G0 == '\"') {
                int i3 = i + 2;
                char G02 = G0(this.e + i2);
                if (G02 == ',') {
                    int i4 = this.e + i3;
                    this.e = i4;
                    this.d = G0(i4);
                    this.n = 3;
                    return j;
                }
                if (G02 != '}') {
                    this.n = -1;
                    return 0L;
                }
                int i8 = i + 3;
                char G03 = G0(this.e + i3);
                if (G03 == ',') {
                    this.a = 16;
                    int i9 = this.e + i8;
                    this.e = i9;
                    this.d = G0(i9);
                } else if (G03 == ']') {
                    this.a = 15;
                    int i10 = this.e + i8;
                    this.e = i10;
                    this.d = G0(i10);
                } else if (G03 == '}') {
                    this.a = 13;
                    int i11 = this.e + i8;
                    this.e = i11;
                    this.d = G0(i11);
                } else {
                    if (G03 != 26) {
                        this.n = -1;
                        return 0L;
                    }
                    this.a = 20;
                    this.e += i + 2;
                    this.d = (char) 26;
                }
                this.n = 4;
                return j;
            }
            j = (j ^ ((G0 < 'A' || G0 > 'Z') ? G0 : G0 + ' ')) * 1099511628211L;
            if (G0 == '\\') {
                this.n = -1;
                return 0L;
            }
            i = i2;
        }
    }

    public final void U0() {
        if (this.d != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.d != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.d != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.d != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.d != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c = this.d;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
            throw new JSONException("scan false error");
        }
        this.a = 7;
    }

    public BigInteger V0(char[] cArr) {
        int i;
        char G0;
        boolean z;
        int length;
        int i2;
        BigInteger bigInteger;
        this.n = 0;
        if (!j(cArr)) {
            this.n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char G02 = G0(this.e + length2);
        boolean z2 = G02 == '\"';
        if (z2) {
            G02 = G0(this.e + i3);
            i3 = length2 + 2;
        }
        boolean z3 = G02 == '-';
        if (z3) {
            G02 = G0(this.e + i3);
            i3++;
        }
        if (G02 >= '0') {
            char c = '9';
            if (G02 <= '9') {
                long j = G02 - '0';
                while (true) {
                    i = i3 + 1;
                    G0 = G0(this.e + i3);
                    if (G0 < '0' || G0 > c) {
                        break;
                    }
                    long j2 = (10 * j) + (G0 - '0');
                    if (j2 < j) {
                        z = true;
                        break;
                    }
                    j = j2;
                    i3 = i;
                    c = '9';
                }
                z = false;
                if (!z2) {
                    int i4 = this.e;
                    length = cArr.length + i4;
                    i2 = ((i4 + i) - length) - 1;
                } else {
                    if (G0 != '\"') {
                        this.n = -1;
                        return null;
                    }
                    int i8 = i3 + 2;
                    G0 = G0(this.e + i);
                    int i9 = this.e;
                    length = cArr.length + i9 + 1;
                    i2 = ((i9 + i8) - length) - 2;
                    i = i8;
                }
                if (!z && (i2 < 20 || (z3 && i2 < 21))) {
                    if (z3) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                } else {
                    if (i2 > 65535) {
                        throw new JSONException("scanInteger overflow");
                    }
                    bigInteger = new BigInteger(r1(length, i2), 10);
                }
                if (G0 == ',') {
                    int i10 = this.e + i;
                    this.e = i10;
                    this.d = G0(i10);
                    this.n = 3;
                    this.a = 16;
                    return bigInteger;
                }
                if (G0 != '}') {
                    this.n = -1;
                    return null;
                }
                int i11 = i + 1;
                char G03 = G0(this.e + i);
                if (G03 == ',') {
                    this.a = 16;
                    int i12 = this.e + i11;
                    this.e = i12;
                    this.d = G0(i12);
                } else if (G03 == ']') {
                    this.a = 15;
                    int i13 = this.e + i11;
                    this.e = i13;
                    this.d = G0(i13);
                } else if (G03 == '}') {
                    this.a = 13;
                    int i14 = this.e + i11;
                    this.e = i14;
                    this.d = G0(i14);
                } else {
                    if (G03 != 26) {
                        this.n = -1;
                        return null;
                    }
                    this.a = 20;
                    this.e += i;
                    this.d = (char) 26;
                }
                this.n = 4;
                return bigInteger;
            }
        }
        if (G02 != 'n' || G0(this.e + i3) != 'u' || G0(this.e + i3 + 1) != 'l' || G0(this.e + i3 + 2) != 'l') {
            this.n = -1;
            return null;
        }
        this.n = 5;
        int i15 = i3 + 4;
        char G04 = G0(this.e + i3 + 3);
        if (z2 && G04 == '\"') {
            G04 = G0(this.e + i15);
            i15 = i3 + 5;
        }
        while (G04 != ',') {
            if (G04 == '}') {
                int i16 = this.e + i15;
                this.e = i16;
                this.d = G0(i16);
                this.n = 5;
                this.a = 13;
                return null;
            }
            if (!M0(G04)) {
                this.n = -1;
                return null;
            }
            G04 = G0(this.e + i15);
            i15++;
        }
        int i17 = this.e + i15;
        this.e = i17;
        this.d = G0(i17);
        this.n = 5;
        this.a = 16;
        return null;
    }

    @Override // a5.b
    public boolean W() {
        int i = 0;
        while (true) {
            char G0 = G0(i);
            if (G0 == 26) {
                this.a = 20;
                return true;
            }
            if (!M0(G0)) {
                return false;
            }
            i++;
        }
    }

    public abstract boolean W0(char[] cArr);

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean X(char c) {
        boolean z = false;
        this.n = 0;
        char G0 = G0(this.e);
        int i = 5;
        if (G0 != 't') {
            if (G0 == 'f') {
                if (G0(this.e + 1) != 'a' || G0(this.e + 2) != 'l' || G0(this.e + 3) != 's' || G0(this.e + 4) != 'e') {
                    this.n = -1;
                    return false;
                }
                G0 = G0(this.e + 5);
                i = 6;
            } else if (G0 == '1') {
                G0 = G0(this.e + 1);
                i = 2;
            } else if (G0 == '0') {
                G0 = G0(this.e + 1);
                i = 2;
            } else {
                i = 1;
            }
            while (G0 != c) {
                if (!M0(G0)) {
                    this.n = -1;
                    return z;
                }
                G0 = G0(this.e + i);
                i++;
            }
            int i2 = this.e + i;
            this.e = i2;
            this.d = G0(i2);
            this.n = 3;
            return z;
        }
        if (G0(this.e + 1) != 'r' || G0(this.e + 2) != 'u' || G0(this.e + 3) != 'e') {
            this.n = -1;
            return false;
        }
        G0 = G0(this.e + 4);
        z = true;
        while (G0 != c) {
        }
        int i22 = this.e + i;
        this.e = i22;
        this.d = G0(i22);
        this.n = 3;
        return z;
    }

    public abstract Date X0(char[] cArr);

    public BigDecimal Y0(char[] cArr) {
        int i;
        char G0;
        int length;
        int i2;
        this.n = 0;
        if (!j(cArr)) {
            this.n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char G02 = G0(this.e + length2);
        boolean z = G02 == '\"';
        if (z) {
            G02 = G0(this.e + i3);
            i3 = length2 + 2;
        }
        if (G02 == '-') {
            G02 = G0(this.e + i3);
            i3++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.e + i3) != 'u' || G0(this.e + i3 + 1) != 'l' || G0(this.e + i3 + 2) != 'l') {
                this.n = -1;
                return null;
            }
            this.n = 5;
            int i4 = i3 + 4;
            char G03 = G0(this.e + i3 + 3);
            if (z && G03 == '\"') {
                G03 = G0(this.e + i4);
                i4 = i3 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i8 = this.e + i4;
                    this.e = i8;
                    this.d = G0(i8);
                    this.n = 5;
                    this.a = 13;
                    return null;
                }
                if (!M0(G03)) {
                    this.n = -1;
                    return null;
                }
                G03 = G0(this.e + i4);
                i4++;
            }
            int i9 = this.e + i4;
            this.e = i9;
            this.d = G0(i9);
            this.n = 5;
            this.a = 16;
            return null;
        }
        while (true) {
            i = i3 + 1;
            G0 = G0(this.e + i3);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            i3 = i;
        }
        if (G0 == '.') {
            int i10 = i3 + 2;
            char G04 = G0(this.e + i);
            if (G04 >= '0' && G04 <= '9') {
                while (true) {
                    i = i10 + 1;
                    G0 = G0(this.e + i10);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i10 = i;
                }
            } else {
                this.n = -1;
                return null;
            }
        }
        if (G0 == 'e' || G0 == 'E') {
            int i11 = i + 1;
            G0 = G0(this.e + i);
            if (G0 == '+' || G0 == '-') {
                i += 2;
                G0 = G0(this.e + i11);
            } else {
                i = i11;
            }
            while (G0 >= '0' && G0 <= '9') {
                char G05 = G0(this.e + i);
                i++;
                G0 = G05;
            }
        }
        if (!z) {
            int i12 = this.e;
            length = cArr.length + i12;
            i2 = ((i12 + i) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.n = -1;
                return null;
            }
            int i13 = i + 1;
            char G06 = G0(this.e + i);
            int i14 = this.e;
            length = cArr.length + i14 + 1;
            i2 = ((i14 + i13) - length) - 2;
            i = i13;
            G0 = G06;
        }
        if (i2 > 65535) {
            throw new JSONException("scan decimal overflow");
        }
        char[] s1 = s1(length, i2);
        BigDecimal bigDecimal = new BigDecimal(s1, 0, s1.length, MathContext.UNLIMITED);
        if (G0 == ',') {
            int i15 = this.e + i;
            this.e = i15;
            this.d = G0(i15);
            this.n = 3;
            this.a = 16;
            return bigDecimal;
        }
        if (G0 != '}') {
            this.n = -1;
            return null;
        }
        int i16 = i + 1;
        char G07 = G0(this.e + i);
        if (G07 == ',') {
            this.a = 16;
            int i17 = this.e + i16;
            this.e = i17;
            this.d = G0(i17);
        } else if (G07 == ']') {
            this.a = 15;
            int i18 = this.e + i16;
            this.e = i18;
            this.d = G0(i18);
        } else if (G07 == '}') {
            this.a = 13;
            int i19 = this.e + i16;
            this.e = i19;
            this.d = G0(i19);
        } else {
            if (G07 != 26) {
                this.n = -1;
                return null;
            }
            this.a = 20;
            this.e += i;
            this.d = (char) 26;
        }
        this.n = 4;
        return bigDecimal;
    }

    public final double Z0(char[] cArr) {
        int i;
        char G0;
        long j;
        int length;
        int i2;
        double parseDouble;
        this.n = 0;
        if (!j(cArr)) {
            this.n = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char G02 = G0(this.e + length2);
        boolean z = G02 == '\"';
        if (z) {
            G02 = G0(this.e + i3);
            i3 = length2 + 2;
        }
        boolean z2 = G02 == '-';
        if (z2) {
            G02 = G0(this.e + i3);
            i3++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.e + i3) != 'u' || G0(this.e + i3 + 1) != 'l' || G0(this.e + i3 + 2) != 'l') {
                this.n = -1;
                return 0.0d;
            }
            this.n = 5;
            int i4 = i3 + 4;
            char G03 = G0(this.e + i3 + 3);
            if (z && G03 == '\"') {
                G03 = G0(this.e + i4);
                i4 = i3 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i8 = this.e + i4;
                    this.e = i8;
                    this.d = G0(i8);
                    this.n = 5;
                    this.a = 13;
                    return 0.0d;
                }
                if (!M0(G03)) {
                    this.n = -1;
                    return 0.0d;
                }
                G03 = G0(this.e + i4);
                i4++;
            }
            int i9 = this.e + i4;
            this.e = i9;
            this.d = G0(i9);
            this.n = 5;
            this.a = 16;
            return 0.0d;
        }
        long j2 = G02 - '0';
        while (true) {
            i = i3 + 1;
            G0 = G0(this.e + i3);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j2 = (j2 * 10) + (G0 - '0');
            i3 = i;
        }
        if (G0 == '.') {
            int i10 = i3 + 2;
            char G04 = G0(this.e + i);
            if (G04 >= '0' && G04 <= '9') {
                j2 = (j2 * 10) + (G04 - '0');
                j = 10;
                while (true) {
                    i = i10 + 1;
                    G0 = G0(this.e + i10);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (G0 - '0');
                    j *= 10;
                    i10 = i;
                }
            } else {
                this.n = -1;
                return 0.0d;
            }
        } else {
            j = 1;
        }
        boolean z3 = G0 == 'e' || G0 == 'E';
        if (z3) {
            int i11 = i + 1;
            G0 = G0(this.e + i);
            if (G0 == '+' || G0 == '-') {
                i += 2;
                G0 = G0(this.e + i11);
            } else {
                i = i11;
            }
            while (G0 >= '0' && G0 <= '9') {
                G0 = G0(this.e + i);
                i++;
            }
        }
        if (!z) {
            int i12 = this.e;
            length = cArr.length + i12;
            i2 = ((i12 + i) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.n = -1;
                return 0.0d;
            }
            int i13 = i + 1;
            G0 = G0(this.e + i);
            int i14 = this.e;
            length = cArr.length + i14 + 1;
            i2 = ((i14 + i13) - length) - 2;
            i = i13;
        }
        if (z3 || i2 >= 17) {
            parseDouble = Double.parseDouble(r1(length, i2));
        } else {
            parseDouble = j2 / j;
            if (z2) {
                parseDouble = -parseDouble;
            }
        }
        if (G0 == ',') {
            int i15 = this.e + i;
            this.e = i15;
            this.d = G0(i15);
            this.n = 3;
            this.a = 16;
            return parseDouble;
        }
        if (G0 != '}') {
            this.n = -1;
            return 0.0d;
        }
        int i16 = i + 1;
        char G05 = G0(this.e + i);
        if (G05 == ',') {
            this.a = 16;
            int i17 = this.e + i16;
            this.e = i17;
            this.d = G0(i17);
        } else if (G05 == ']') {
            this.a = 15;
            int i18 = this.e + i16;
            this.e = i18;
            this.d = G0(i18);
        } else if (G05 == '}') {
            this.a = 13;
            int i19 = this.e + i16;
            this.e = i19;
            this.d = G0(i19);
        } else {
            if (G05 != 26) {
                this.n = -1;
                return 0.0d;
            }
            this.a = 20;
            this.e += i;
            this.d = (char) 26;
        }
        this.n = 4;
        return parseDouble;
    }

    public final float a1(char[] cArr) {
        int i;
        char G0;
        long j;
        int length;
        int i2;
        float parseFloat;
        this.n = 0;
        if (!j(cArr)) {
            this.n = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char G02 = G0(this.e + length2);
        boolean z = G02 == '\"';
        if (z) {
            G02 = G0(this.e + i3);
            i3 = length2 + 2;
        }
        boolean z2 = G02 == '-';
        if (z2) {
            G02 = G0(this.e + i3);
            i3++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.e + i3) != 'u' || G0(this.e + i3 + 1) != 'l' || G0(this.e + i3 + 2) != 'l') {
                this.n = -1;
                return 0.0f;
            }
            this.n = 5;
            int i4 = i3 + 4;
            char G03 = G0(this.e + i3 + 3);
            if (z && G03 == '\"') {
                G03 = G0(this.e + i4);
                i4 = i3 + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i8 = this.e + i4;
                    this.e = i8;
                    this.d = G0(i8);
                    this.n = 5;
                    this.a = 13;
                    return 0.0f;
                }
                if (!M0(G03)) {
                    this.n = -1;
                    return 0.0f;
                }
                G03 = G0(this.e + i4);
                i4++;
            }
            int i9 = this.e + i4;
            this.e = i9;
            this.d = G0(i9);
            this.n = 5;
            this.a = 16;
            return 0.0f;
        }
        long j2 = G02 - '0';
        while (true) {
            i = i3 + 1;
            G0 = G0(this.e + i3);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j2 = (j2 * 10) + (G0 - '0');
            i3 = i;
        }
        if (G0 == '.') {
            int i10 = i3 + 2;
            char G04 = G0(this.e + i);
            if (G04 >= '0' && G04 <= '9') {
                j2 = (j2 * 10) + (G04 - '0');
                j = 10;
                while (true) {
                    i = i10 + 1;
                    G0 = G0(this.e + i10);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (G0 - '0');
                    j *= 10;
                    i10 = i;
                }
            } else {
                this.n = -1;
                return 0.0f;
            }
        } else {
            j = 1;
        }
        boolean z3 = G0 == 'e' || G0 == 'E';
        if (z3) {
            int i11 = i + 1;
            G0 = G0(this.e + i);
            if (G0 == '+' || G0 == '-') {
                i += 2;
                G0 = G0(this.e + i11);
            } else {
                i = i11;
            }
            while (G0 >= '0' && G0 <= '9') {
                char G05 = G0(this.e + i);
                i++;
                G0 = G05;
            }
        }
        if (!z) {
            int i12 = this.e;
            length = cArr.length + i12;
            i2 = ((i12 + i) - length) - 1;
        } else {
            if (G0 != '\"') {
                this.n = -1;
                return 0.0f;
            }
            int i13 = i + 1;
            G0 = G0(this.e + i);
            int i14 = this.e;
            length = cArr.length + i14 + 1;
            i2 = ((i14 + i13) - length) - 2;
            i = i13;
        }
        if (z3 || i2 >= 17) {
            parseFloat = Float.parseFloat(r1(length, i2));
        } else {
            parseFloat = (float) (j2 / j);
            if (z2) {
                parseFloat = -parseFloat;
            }
        }
        if (G0 == ',') {
            int i15 = this.e + i;
            this.e = i15;
            this.d = G0(i15);
            this.n = 3;
            this.a = 16;
            return parseFloat;
        }
        if (G0 != '}') {
            this.n = -1;
            return 0.0f;
        }
        int i16 = i + 1;
        char G06 = G0(this.e + i);
        if (G06 == ',') {
            this.a = 16;
            int i17 = this.e + i16;
            this.e = i17;
            this.d = G0(i17);
        } else if (G06 == ']') {
            this.a = 15;
            int i18 = this.e + i16;
            this.e = i18;
            this.d = G0(i18);
        } else if (G06 == '}') {
            this.a = 13;
            int i19 = this.e + i16;
            this.e = i19;
            this.d = G0(i19);
        } else {
            if (G06 != 26) {
                this.n = -1;
                return 0.0f;
            }
            this.e += i;
            this.a = 20;
            this.d = (char) 26;
        }
        this.n = 4;
        return parseFloat;
    }

    public abstract String b(int i, int i2, int i3, i iVar);

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b6, code lost:
    
        r1 = r4;
        r19.n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b9, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] b1(char[] cArr) {
        int i;
        char G0;
        int i2;
        float parseFloat;
        float[] fArr;
        char c;
        boolean z;
        boolean z2 = false;
        this.n = 0;
        float[] fArr2 = null;
        if (!j(cArr)) {
            this.n = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        if (G0(this.e + length) != '[') {
            this.n = -2;
            return null;
        }
        int i4 = length + 2;
        char G02 = G0(this.e + i3);
        float[] fArr3 = new float[16];
        int i8 = 0;
        while (true) {
            int i9 = this.e;
            int i10 = (i9 + i4) - 1;
            boolean z3 = G02 == '-' ? true : z2;
            if (z3) {
                G02 = G0(i9 + i4);
                i4++;
            }
            if (G02 < '0' || G02 > '9') {
                break;
            }
            int i11 = G02 - '0';
            while (true) {
                i = i4 + 1;
                G0 = G0(this.e + i4);
                if (G0 < '0' || G0 > '9') {
                    break;
                }
                i11 = (i11 * 10) + (G0 - '0');
                i4 = i;
            }
            if (G0 == '.') {
                int i12 = i4 + 2;
                char G03 = G0(this.e + i);
                if (G03 >= '0' && G03 <= '9') {
                    i11 = (i11 * 10) + (G03 - '0');
                    i2 = 10;
                    while (true) {
                        i = i12 + 1;
                        G0 = G0(this.e + i12);
                        if (G0 < '0' || G0 > '9') {
                            break;
                        }
                        i11 = (i11 * 10) + (G0 - '0');
                        i2 *= 10;
                        i12 = i;
                    }
                } else {
                    break;
                }
            } else {
                i2 = 1;
            }
            boolean z4 = G0 == 'e' || G0 == 'E';
            if (z4) {
                int i13 = i + 1;
                G0 = G0(this.e + i);
                if (G0 == '+' || G0 == '-') {
                    i += 2;
                    G0 = G0(this.e + i13);
                } else {
                    i = i13;
                }
                while (G0 >= '0' && G0 <= '9') {
                    G0 = G0(this.e + i);
                    i++;
                }
            }
            int i14 = ((this.e + i) - i10) - 1;
            if (z4 || i14 >= 10) {
                parseFloat = Float.parseFloat(r1(i10, i14));
            } else {
                parseFloat = i11 / i2;
                if (z3) {
                    parseFloat = -parseFloat;
                }
            }
            if (i8 >= fArr3.length) {
                float[] fArr4 = new float[(fArr3.length * 3) / 2];
                System.arraycopy(fArr3, 0, fArr4, 0, i8);
                fArr3 = fArr4;
            }
            int i15 = i8 + 1;
            fArr3[i8] = parseFloat;
            if (G0 == ',') {
                i4 = i + 1;
                G0 = G0(this.e + i);
                fArr = null;
                c = 16;
                z = false;
            } else {
                if (G0 == ']') {
                    int i16 = i + 1;
                    char G04 = G0(this.e + i);
                    if (i15 != fArr3.length) {
                        float[] fArr5 = new float[i15];
                        System.arraycopy(fArr3, 0, fArr5, 0, i15);
                        fArr3 = fArr5;
                    }
                    if (G04 == ',') {
                        this.e += i;
                        next();
                        this.n = 3;
                        this.a = 16;
                        return fArr3;
                    }
                    if (G04 != '}') {
                        this.n = -1;
                        return null;
                    }
                    char G05 = G0(this.e + i16);
                    if (G05 == ',') {
                        this.a = 16;
                        this.e += i + 1;
                        next();
                    } else if (G05 == ']') {
                        this.a = 15;
                        this.e += i + 1;
                        next();
                    } else if (G05 == '}') {
                        this.a = 13;
                        this.e += i + 1;
                        next();
                    } else {
                        if (G05 != 26) {
                            this.n = -1;
                            return null;
                        }
                        this.e += i + 1;
                        this.a = 20;
                        this.d = (char) 26;
                    }
                    this.n = 4;
                    return fArr3;
                }
                fArr = null;
                c = 16;
                z = false;
                i4 = i;
            }
            i8 = i15;
            G02 = G0;
            fArr2 = fArr;
            z2 = z;
        }
        this.n = -1;
        return fArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x014a, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b2, code lost:
    
        r21.n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b4, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0193, code lost:
    
        r21.n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0196, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0135, code lost:
    
        r4 = r18 + 1;
        r1 = G0(r21.e + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0140, code lost:
    
        if (r2 == r3.length) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0142, code lost:
    
        r5 = new float[r2];
        r7 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014c, code lost:
    
        if (r8 < r6.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014e, code lost:
    
        r5 = new float[(r6.length * 3) / 2][];
        java.lang.System.arraycopy(r3, r7, r5, r7, r2);
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0159, code lost:
    
        r5 = r8 + 1;
        r6[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015f, code lost:
    
        if (r1 != ',') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0161, code lost:
    
        r3 = G0(r21.e + r4);
        r2 = r18 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0170, code lost:
    
        if (r1 != ']') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017d, code lost:
    
        r3 = r1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0172, code lost:
    
        r2 = r18 + 2;
        r3 = G0(r21.e + r4);
        r8 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] c1(char[] cArr) {
        int i;
        char G0;
        int i2;
        int i3;
        float parseFloat;
        int i4;
        char G02;
        int i8 = 0;
        this.n = 0;
        float[][] fArr = null;
        if (!j(cArr)) {
            this.n = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        char c = '[';
        if (G0(this.e + length) != '[') {
            this.n = -2;
            return null;
        }
        int i10 = length + 2;
        char G03 = G0(this.e + i9);
        int i11 = 16;
        float[][] fArr2 = new float[16][];
        int i12 = 0;
        loop0: while (true) {
            int i13 = 1;
            if (G03 != c) {
                break;
            }
            int i14 = i10 + 1;
            char G04 = G0(this.e + i10);
            float[] fArr3 = new float[i11];
            int i15 = i8;
            while (true) {
                int i16 = this.e;
                int i17 = (i16 + i14) - 1;
                int i18 = G04 == '-' ? i13 : i8;
                if (i18 != 0) {
                    char G05 = G0(i16 + i14);
                    i14++;
                    G04 = G05;
                }
                if (G04 < '0' || G04 > '9') {
                    break loop0;
                }
                int i19 = G04 - '0';
                while (true) {
                    i = i14 + 1;
                    G0 = G0(this.e + i14);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i19 = (i19 * 10) + (G0 - '0');
                    i14 = i;
                }
                if (G0 == '.') {
                    int i20 = i14 + 2;
                    char G06 = G0(this.e + i);
                    if (G06 < '0' || G06 > '9') {
                        break loop0;
                    }
                    int i21 = (i19 * 10) + (G06 - '0');
                    int i22 = 10;
                    while (true) {
                        i = i20 + 1;
                        G02 = G0(this.e + i20);
                        if (G02 < '0' || G02 > '9') {
                            break;
                        }
                        i21 = (i21 * 10) + (G02 - '0');
                        i22 *= 10;
                        i20 = i;
                    }
                    int i23 = i21;
                    i3 = i22;
                    G0 = G02;
                    i2 = i23;
                } else {
                    i2 = i19;
                    i3 = 1;
                }
                boolean z = G0 == 'e' || G0 == 'E';
                if (z) {
                    int i24 = i + 1;
                    G0 = G0(this.e + i);
                    if (G0 == '+' || G0 == '-') {
                        i += 2;
                        G0 = G0(this.e + i24);
                    } else {
                        i = i24;
                    }
                    while (G0 >= '0' && G0 <= '9') {
                        G0 = G0(this.e + i);
                        i++;
                    }
                }
                int i25 = ((this.e + i) - i17) - 1;
                if (z || i25 >= 10) {
                    parseFloat = Float.parseFloat(r1(i17, i25));
                } else {
                    parseFloat = i2 / i3;
                    if (i18 != 0) {
                        parseFloat = -parseFloat;
                    }
                }
                if (i15 >= fArr3.length) {
                    float[] fArr4 = new float[(fArr3.length * 3) / 2];
                    System.arraycopy(fArr3, 0, fArr4, 0, i15);
                    fArr3 = fArr4;
                }
                int i26 = i15 + 1;
                fArr3[i15] = parseFloat;
                if (G0 == ',') {
                    G0 = G0(this.e + i);
                    i14 = i + 1;
                } else {
                    if (G0 == ']') {
                        break;
                    }
                    i14 = i;
                }
                i15 = i26;
                fArr = null;
                i13 = 1;
                G04 = G0;
                i8 = 0;
            }
            i12 = i4;
            i8 = 0;
            fArr = null;
            i11 = 16;
            c = '[';
        }
        if (i12 != fArr2.length) {
            float[][] fArr5 = new float[i12][];
            System.arraycopy(fArr2, 0, fArr5, 0, i12);
            fArr2 = fArr5;
        }
        if (G03 == ',') {
            this.e += i10 - 1;
            next();
            this.n = 3;
            this.a = 16;
            return fArr2;
        }
        if (G03 != '}') {
            this.n = -1;
            return null;
        }
        char G07 = G0(this.e + i10);
        if (G07 == ',') {
            this.a = 16;
            this.e += i10;
            next();
        } else if (G07 == ']') {
            this.a = 15;
            this.e += i10;
            next();
        } else if (G07 == '}') {
            this.a = 13;
            this.e += i10;
            next();
        } else {
            if (G07 != 26) {
                this.n = -1;
                return null;
            }
            this.e += i10;
            this.a = 20;
            this.d = (char) 26;
        }
        this.n = 4;
        return fArr2;
    }

    @Override // a5.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.g;
        if (cArr.length <= 8192) {
            q.set(cArr);
        }
        this.g = null;
    }

    @Override // a5.b
    public final char d() {
        return this.d;
    }

    @Override // a5.b
    public final void d0() {
        this.h = 0;
        while (true) {
            this.b = this.e;
            char c = this.d;
            if (c == '/') {
                p1();
            } else {
                if (c == '\"') {
                    e0();
                    return;
                }
                if (c == ',') {
                    next();
                    this.a = 16;
                    return;
                }
                if (c >= '0' && c <= '9') {
                    q();
                    return;
                }
                if (c == '-') {
                    q();
                    return;
                }
                switch (c) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case LocationStyle.Location_CenterV /* 32 */:
                        next();
                        break;
                    case TTAdConstant.CONVERSION_LINK_ONE_SLOT_MULTIPLE_ADS_NEW /* 39 */:
                        if (!o(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        l1();
                        return;
                    case '(':
                        next();
                        this.a = 10;
                        return;
                    case ')':
                        next();
                        this.a = 11;
                        return;
                    case '+':
                        next();
                        q();
                        return;
                    case '.':
                        next();
                        this.a = 25;
                        return;
                    case ':':
                        next();
                        this.a = 17;
                        return;
                    case ';':
                        next();
                        this.a = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        i1();
                        return;
                    case '[':
                        next();
                        this.a = 14;
                        return;
                    case ']':
                        next();
                        this.a = 15;
                        return;
                    case 'f':
                        U0();
                        return;
                    case 'n':
                        j1();
                        return;
                    case 't':
                        n1();
                        return;
                    case 'x':
                        h1();
                        return;
                    case '{':
                        next();
                        this.a = 12;
                        return;
                    case '}':
                        next();
                        this.a = 13;
                        return;
                    default:
                        if (L0()) {
                            if (this.a == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.a = 20;
                            int i = this.e;
                            this.b = i;
                            this.f = i;
                            return;
                        }
                        char c2 = this.d;
                        if (c2 > 31 && c2 != 127) {
                            N0("illegal.char", String.valueOf((int) c2));
                            next();
                            return;
                        } else {
                            next();
                            break;
                        }
                }
            }
        }
    }

    public abstract int d1(char[] cArr);

    /* JADX WARN: Code restructure failed: missing block: B:94:0x016f, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r5 + r7);
     */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e0() {
        this.i = this.e;
        this.j = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.a = 4;
                this.d = next();
                return;
            }
            if (next == 26) {
                if (L0()) {
                    throw new JSONException("unclosed string : " + next);
                }
                R0((char) 26);
            } else if (next == '\\') {
                if (!this.j) {
                    this.j = true;
                    int i = this.h;
                    char[] cArr = this.g;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.g = cArr2;
                    }
                    H0(this.i + 1, this.h, this.g);
                }
                char next2 = next();
                if (next2 == '\"') {
                    R0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            R0('\\');
                        } else if (next2 == 'b') {
                            R0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                R0('\n');
                            } else if (next2 == 'r') {
                                R0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        R0('/');
                                        break;
                                    case '0':
                                        R0((char) 0);
                                        break;
                                    case '1':
                                        R0((char) 1);
                                        break;
                                    case TTAdConstant.IMAGE_MODE_VIDEO_SQUARE /* 50 */:
                                        R0((char) 2);
                                        break;
                                    case '3':
                                        R0((char) 3);
                                        break;
                                    case '4':
                                        R0((char) 4);
                                        break;
                                    case '5':
                                        R0((char) 5);
                                        break;
                                    case '6':
                                        R0((char) 6);
                                        break;
                                    case '7':
                                        R0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                R0('\t');
                                                break;
                                            case 'u':
                                                R0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                R0((char) 11);
                                                break;
                                            default:
                                                this.d = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z2 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (z && z2) {
                                    int[] iArr = s;
                                    R0((char) ((iArr[next3] * 16) + iArr[next4]));
                                }
                            }
                        }
                    }
                    R0('\f');
                } else {
                    R0('\'');
                }
            } else if (this.j) {
                int i2 = this.h;
                char[] cArr3 = this.g;
                if (i2 == cArr3.length) {
                    R0(next);
                } else {
                    this.h = i2 + 1;
                    cArr3[i2] = next;
                }
            } else {
                this.h++;
            }
        }
    }

    public final int[] e1(char[] cArr) {
        boolean z;
        int i;
        char G0;
        int i2;
        char G02;
        int i3;
        int[] iArr;
        this.n = 0;
        int[] iArr2 = null;
        if (!j(cArr)) {
            this.n = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (G0(this.e + length) != '[') {
            this.n = -2;
            return null;
        }
        int i8 = length + 2;
        char G03 = G0(this.e + i4);
        int[] iArr3 = new int[16];
        if (G03 != ']') {
            int i9 = 0;
            while (true) {
                if (G03 == '-') {
                    G03 = G0(this.e + i8);
                    i8++;
                    z = true;
                } else {
                    z = false;
                }
                if (G03 < '0' || G03 > '9') {
                    break;
                }
                int i10 = G03 - '0';
                while (true) {
                    i = i8 + 1;
                    G0 = G0(this.e + i8);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i10 = (i10 * 10) + (G0 - '0');
                    i8 = i;
                }
                if (i9 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr4, 0, i9);
                    iArr3 = iArr4;
                }
                i2 = i9 + 1;
                if (z) {
                    i10 = -i10;
                }
                iArr3[i9] = i10;
                if (G0 == ',') {
                    i8 += 2;
                    G03 = G0(this.e + i);
                    iArr = null;
                } else {
                    if (G0 == ']') {
                        G02 = G0(this.e + i);
                        i3 = i8 + 2;
                        break;
                    }
                    iArr = null;
                    G03 = G0;
                    i8 = i;
                }
                iArr2 = iArr;
                i9 = i2;
            }
            int[] iArr5 = iArr2;
            this.n = -1;
            return iArr5;
        }
        i3 = length + 3;
        G02 = G0(this.e + i8);
        i2 = 0;
        if (i2 != iArr3.length) {
            int[] iArr6 = new int[i2];
            System.arraycopy(iArr3, 0, iArr6, 0, i2);
            iArr3 = iArr6;
        }
        if (G02 == ',') {
            this.e += i3 - 1;
            next();
            this.n = 3;
            this.a = 16;
            return iArr3;
        }
        if (G02 != '}') {
            this.n = -1;
            return null;
        }
        char G04 = G0(this.e + i3);
        if (G04 == ',') {
            this.a = 16;
            this.e += i3;
            next();
        } else if (G04 == ']') {
            this.a = 15;
            this.e += i3;
            next();
        } else if (G04 == '}') {
            this.a = 13;
            this.e += i3;
            next();
        } else {
            if (G04 != 26) {
                this.n = -1;
                return null;
            }
            this.e += i3;
            this.a = 20;
            this.d = (char) 26;
        }
        this.n = 4;
        return iArr3;
    }

    protected abstract void f(int i, char[] cArr, int i2, int i3);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // a5.b
    public final void f0(int i) {
        this.h = 0;
        while (true) {
            if (i == 2) {
                char c = this.d;
                if (c >= '0' && c <= '9') {
                    this.b = this.e;
                    q();
                    return;
                }
                if (c == '\"') {
                    this.b = this.e;
                    e0();
                    return;
                } else if (c == '[') {
                    this.a = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.a = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.d;
                if (c2 == '\"') {
                    this.b = this.e;
                    e0();
                    return;
                }
                if (c2 >= '0' && c2 <= '9') {
                    this.b = this.e;
                    q();
                    return;
                } else if (c2 == '[') {
                    this.a = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.a = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.d;
                if (c3 == '{') {
                    this.a = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.a = 14;
                    next();
                    return;
                }
            } else {
                if (i == 18) {
                    P0();
                    return;
                }
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.d;
                            if (c4 != '[') {
                                if (c4 == '{') {
                                    this.a = 12;
                                    next();
                                    break;
                                }
                            } else {
                                this.a = 14;
                                next();
                                break;
                            }
                            break;
                        case TTAdConstant.IMAGE_MODE_VIDEO_VERTICAL /* 15 */:
                            if (this.d == ']') {
                                this.a = 15;
                                next();
                                break;
                            }
                            break;
                        case 16:
                            char c8 = this.d;
                            if (c8 != ',') {
                                if (c8 != '}') {
                                    if (c8 != ']') {
                                        if (c8 != 26) {
                                            if (c8 == 'n') {
                                                k1(false);
                                                break;
                                            }
                                        } else {
                                            this.a = 20;
                                            break;
                                        }
                                    } else {
                                        this.a = 15;
                                        next();
                                        break;
                                    }
                                } else {
                                    this.a = 13;
                                    next();
                                    break;
                                }
                            } else {
                                this.a = 16;
                                next();
                                break;
                            }
                            break;
                    }
                    return;
                }
                if (this.d == 26) {
                    this.a = 20;
                    return;
                }
            }
            char c9 = this.d;
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                d0();
                return;
            }
            next();
        }
    }

    public abstract long f1(char[] cArr);

    @Override // a5.b
    public abstract BigDecimal g0();

    public abstract String g1(char[] cArr);

    @Override // a5.b
    public final int h() {
        return this.b;
    }

    @Override // a5.b
    public final String h0(i iVar) {
        x0();
        char c = this.d;
        if (c == '\"') {
            return w(iVar, '\"');
        }
        if (c == '\'') {
            if (o(Feature.AllowSingleQuotes)) {
                return w(iVar, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c == '}') {
            next();
            this.a = 13;
            return null;
        }
        if (c == ',') {
            next();
            this.a = 16;
            return null;
        }
        if (c == 26) {
            this.a = 20;
            return null;
        }
        if (o(Feature.AllowUnQuotedFieldNames)) {
            return T(iVar);
        }
        throw new JSONException("syntax error");
    }

    public final void h1() {
        char next;
        if (this.d != 'x') {
            throw new JSONException("illegal state. " + this.d);
        }
        next();
        if (this.d != '\'') {
            throw new JSONException("illegal state. " + this.d);
        }
        this.i = this.e;
        next();
        if (this.d == '\'') {
            next();
            this.a = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.h++;
            }
        }
        if (next == '\'') {
            this.h++;
            next();
            this.a = 26;
        } else {
            throw new JSONException("illegal state. " + next);
        }
    }

    public final void i1() {
        this.i = this.e - 1;
        this.j = false;
        do {
            this.h++;
            next();
        } while (Character.isLetterOrDigit(this.d));
        String o0 = o0();
        if ("null".equalsIgnoreCase(o0)) {
            this.a = 8;
            return;
        }
        if ("new".equals(o0)) {
            this.a = 9;
            return;
        }
        if ("true".equals(o0)) {
            this.a = 6;
            return;
        }
        if ("false".equals(o0)) {
            this.a = 7;
            return;
        }
        if ("undefined".equals(o0)) {
            this.a = 23;
            return;
        }
        if ("Set".equals(o0)) {
            this.a = 21;
        } else if ("TreeSet".equals(o0)) {
            this.a = 22;
        } else {
            this.a = 18;
        }
    }

    @Override // a5.b
    public final boolean isEnabled(int i) {
        return (i & this.c) != 0;
    }

    protected abstract boolean j(char[] cArr);

    public final void j1() {
        k1(true);
    }

    @Override // a5.b
    public abstract String k();

    public final void k1(boolean z) {
        if (this.d != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c = this.d;
        if (c != 'u') {
            if (c != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.d != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c2 = this.d;
            if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
                throw new JSONException("scan new error");
            }
            this.a = 9;
            return;
        }
        next();
        if (this.d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c3 = this.d;
        if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && ((c3 != ':' || !z) && c3 != '\f' && c3 != '\b')) {
            throw new JSONException("scan null error");
        }
        this.a = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005c -> B:9:0x002e). Please report as a decompilation issue!!! */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long l() {
        long j;
        long j2;
        boolean z = false;
        if (this.i == -1) {
            this.i = 0;
        }
        int i = this.i;
        int i2 = this.h + i;
        if (G0(i) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i < i2) {
            int i3 = i + 1;
            j2 = -(G0(i) - '0');
            i = i3;
            if (i < i2) {
                i3 = i + 1;
                char G0 = G0(i);
                if (G0 == 'L' || G0 == 'S' || G0 == 'B') {
                    i = i3;
                } else {
                    int i4 = G0 - '0';
                    if (j2 < -922337203685477580L) {
                        throw new NumberFormatException(E0());
                    }
                    long j3 = j2 * 10;
                    long j4 = i4;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(E0());
                    }
                    j2 = j3 - j4;
                    i = i3;
                    if (i < i2) {
                    }
                }
            }
            if (z) {
                return -j2;
            }
            if (i > this.i + 1) {
                return j2;
            }
            throw new NumberFormatException(E0());
        }
        j2 = 0;
        if (i < i2) {
        }
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c5 -> B:41:0x00b4). Please report as a decompilation issue!!! */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float m(char c) {
        int i;
        int i2;
        char G0;
        long j;
        int i3;
        int i4;
        float parseFloat;
        this.n = 0;
        char G02 = G0(this.e);
        boolean z = G02 == '\"';
        if (z) {
            G02 = G0(this.e + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = G02 == '-';
        if (z2) {
            G02 = G0(this.e + i);
            i++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.e + i) != 'u' || G0(this.e + i + 1) != 'l' || G0(this.e + i + 2) != 'l') {
                this.n = -1;
                return 0.0f;
            }
            this.n = 5;
            int i8 = i + 4;
            char G03 = G0(this.e + i + 3);
            if (z && G03 == '\"') {
                G03 = G0(this.e + i8);
                i8 = i + 5;
            }
            while (G03 != ',') {
                if (G03 == ']') {
                    int i9 = this.e + i8;
                    this.e = i9;
                    this.d = G0(i9);
                    this.n = 5;
                    this.a = 15;
                    return 0.0f;
                }
                if (!M0(G03)) {
                    this.n = -1;
                    return 0.0f;
                }
                G03 = G0(this.e + i8);
                i8++;
            }
            int i10 = this.e + i8;
            this.e = i10;
            this.d = G0(i10);
            this.n = 5;
            this.a = 16;
            return 0.0f;
        }
        long j2 = G02 - '0';
        while (true) {
            i2 = i + 1;
            G0 = G0(this.e + i);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            j2 = (j2 * 10) + (G0 - '0');
            i = i2;
        }
        if (G0 == '.') {
            int i11 = i + 2;
            char G04 = G0(this.e + i2);
            if (G04 >= '0' && G04 <= '9') {
                j2 = (j2 * 10) + (G04 - '0');
                j = 10;
                while (true) {
                    i2 = i11 + 1;
                    G0 = G0(this.e + i11);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (G0 - '0');
                    j *= 10;
                    i11 = i2;
                }
            } else {
                this.n = -1;
                return 0.0f;
            }
        } else {
            j = 1;
        }
        boolean z3 = G0 == 'e' || G0 == 'E';
        if (z3) {
            int i12 = i2 + 1;
            char G05 = G0(this.e + i2);
            if (G05 == '+' || G05 == '-') {
                i2 += 2;
                G0 = G0(this.e + i12);
                if (G0 >= '0' && G0 <= '9') {
                    i12 = i2 + 1;
                    G0 = G0(this.e + i2);
                    i2 = i12;
                    if (G0 >= '0') {
                        i12 = i2 + 1;
                        G0 = G0(this.e + i2);
                        i2 = i12;
                        if (G0 >= '0') {
                        }
                    }
                }
            } else {
                G0 = G05;
                i2 = i12;
                if (G0 >= '0') {
                }
            }
        }
        if (!z) {
            i3 = this.e;
            i4 = ((i3 + i2) - i3) - 1;
        } else {
            if (G0 != '\"') {
                this.n = -1;
                return 0.0f;
            }
            int i13 = i2 + 1;
            G0 = G0(this.e + i2);
            int i14 = this.e;
            i3 = i14 + 1;
            i4 = ((i14 + i13) - i3) - 2;
            i2 = i13;
        }
        if (z3 || i4 >= 17) {
            parseFloat = Float.parseFloat(r1(i3, i4));
        } else {
            parseFloat = (float) (j2 / j);
            if (z2) {
                parseFloat = -parseFloat;
            }
        }
        if (G0 != c) {
            this.n = -1;
            return parseFloat;
        }
        int i15 = this.e + i2;
        this.e = i15;
        this.d = G0(i15);
        this.n = 3;
        this.a = 16;
        return parseFloat;
    }

    public String m1(i iVar, char c) {
        int i = 0;
        this.n = 0;
        char G0 = G0(this.e);
        if (G0 == 'n') {
            if (G0(this.e + 1) != 'u' || G0(this.e + 2) != 'l' || G0(this.e + 3) != 'l') {
                this.n = -1;
                return null;
            }
            if (G0(this.e + 4) != c) {
                this.n = -1;
                return null;
            }
            int i2 = this.e + 5;
            this.e = i2;
            this.d = G0(i2);
            this.n = 3;
            return null;
        }
        if (G0 != '\"') {
            this.n = -1;
            return null;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char G02 = G0(this.e + i3);
            if (G02 == '\"') {
                int i8 = this.e;
                int i9 = i8 + 1;
                String b = b(i9, ((i8 + i4) - i9) - 1, i, iVar);
                int i10 = i3 + 2;
                char G03 = G0(this.e + i4);
                while (G03 != c) {
                    if (!M0(G03)) {
                        this.n = -1;
                        return b;
                    }
                    G03 = G0(this.e + i10);
                    i10++;
                }
                int i11 = this.e + i10;
                this.e = i11;
                this.d = G0(i11);
                this.n = 3;
                return b;
            }
            i = (i * 31) + G02;
            if (G02 == '\\') {
                this.n = -1;
                return null;
            }
            i3 = i4;
        }
    }

    public final void n1() {
        if (this.d != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.d != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.d != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.d != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c = this.d;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
            throw new JSONException("scan true error");
        }
        this.a = 6;
    }

    @Override // a5.b
    public abstract char next();

    @Override // a5.b
    public final boolean o(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // a5.b
    public abstract String o0();

    public void o1(TimeZone timeZone) {
        this.l = timeZone;
    }

    @Override // a5.b
    public final int p() {
        int i;
        boolean z;
        int i2 = 0;
        if (this.i == -1) {
            this.i = 0;
        }
        int i3 = this.i;
        int i4 = this.h + i3;
        if (G0(i3) == '-') {
            i3++;
            i = Integer.MIN_VALUE;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i3 < i4) {
            i2 = -(G0(i3) - '0');
            i3++;
        }
        while (i3 < i4) {
            int i8 = i3 + 1;
            char G0 = G0(i3);
            if (G0 == 'L' || G0 == 'S' || G0 == 'B') {
                i3 = i8;
                break;
            }
            int i9 = G0 - '0';
            if (i2 < -214748364) {
                throw new NumberFormatException(E0());
            }
            int i10 = i2 * 10;
            if (i10 < i + i9) {
                throw new NumberFormatException(E0());
            }
            i2 = i10 - i9;
            i3 = i8;
        }
        if (!z) {
            return -i2;
        }
        if (i3 > this.i + 1) {
            return i2;
        }
        throw new NumberFormatException(E0());
    }

    @Override // a5.b
    public TimeZone p0() {
        return this.l;
    }

    protected void p1() {
        char c;
        next();
        char c2 = this.d;
        if (c2 == '/') {
            do {
                next();
                c = this.d;
                if (c == '\n') {
                    next();
                    return;
                }
            } while (c != 26);
            return;
        }
        if (c2 != '*') {
            throw new JSONException("invalid comment");
        }
        next();
        while (true) {
            char c3 = this.d;
            if (c3 == 26) {
                return;
            }
            if (c3 == '*') {
                next();
                if (this.d == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        char c;
        boolean z;
        char c2;
        this.i = this.e;
        boolean z2 = true;
        if (this.d == '-') {
            this.h++;
            next();
        }
        while (true) {
            c = this.d;
            if (c < '0' || c > '9') {
                break;
            }
            this.h++;
            next();
        }
        if (c == '.') {
            this.h++;
            next();
            while (true) {
                char c3 = this.d;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.h++;
                next();
            }
            z = true;
        } else {
            z = false;
        }
        int i = this.h;
        if (i > 65535) {
            throw new JSONException("scanNumber overflow");
        }
        char c4 = this.d;
        if (c4 == 'L') {
            this.h = i + 1;
            next();
        } else if (c4 == 'S') {
            this.h = i + 1;
            next();
        } else {
            if (c4 != 'B') {
                if (c4 == 'F') {
                    this.h = i + 1;
                    next();
                } else if (c4 == 'D') {
                    this.h = i + 1;
                    next();
                } else if (c4 == 'e' || c4 == 'E') {
                    this.h = i + 1;
                    next();
                    char c8 = this.d;
                    if (c8 == '+' || c8 == '-') {
                        this.h++;
                        next();
                    }
                    while (true) {
                        c2 = this.d;
                        if (c2 < '0' || c2 > '9') {
                            break;
                        }
                        this.h++;
                        next();
                    }
                    if (c2 == 'D' || c2 == 'F') {
                        this.h++;
                        next();
                    }
                }
                if (z2) {
                    this.a = 2;
                    return;
                } else {
                    this.a = 3;
                    return;
                }
            }
            this.h = i + 1;
            next();
        }
        z2 = z;
        if (z2) {
        }
    }

    public final String q1() {
        return this.o;
    }

    @Override // a5.b
    public final void r(int i) {
        Q0(':');
    }

    @Override // a5.b
    public final Number r0() {
        char c;
        long j;
        long j2;
        boolean z = false;
        if (this.i == -1) {
            this.i = 0;
        }
        int i = this.i;
        int i2 = this.h + i;
        char G0 = G0(i2 - 1);
        if (G0 == 'B') {
            i2--;
            c = 'B';
        } else if (G0 == 'L') {
            i2--;
            c = 'L';
        } else if (G0 != 'S') {
            c = ' ';
        } else {
            i2--;
            c = 'S';
        }
        if (G0(this.i) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i < i2) {
            j2 = -(G0(i) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int G02 = G0(i) - '0';
            if (j2 < -922337203685477580L) {
                return new BigInteger(E0(), 10);
            }
            long j3 = j2 * 10;
            long j4 = G02;
            if (j3 < j + j4) {
                return new BigInteger(E0(), 10);
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            long j8 = -j2;
            return (j8 > 2147483647L || c == 'L') ? Long.valueOf(j8) : c == 'S' ? Short.valueOf((short) j8) : c == 'B' ? Byte.valueOf((byte) j8) : Integer.valueOf((int) j8);
        }
        if (i > this.i + 1) {
            return (j2 < -2147483648L || c == 'L') ? Long.valueOf(j2) : c == 'S' ? Short.valueOf((short) j2) : c == 'B' ? Byte.valueOf((byte) j2) : Integer.valueOf((int) j2);
        }
        throw new JSONException("illegal number format : " + E0());
    }

    public abstract String r1(int i, int i2);

    @Override // a5.b
    public int s() {
        return this.c;
    }

    @Override // a5.b
    public float s0() {
        char charAt;
        String E0 = E0();
        float parseFloat = Float.parseFloat(E0);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = E0.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + E0);
    }

    protected abstract char[] s1(int i, int i2);

    @Override // a5.b
    public final int t0() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0099 -> B:70:0x0089). Please report as a decompilation issue!!! */
    @Override // a5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal u(char c) {
        int i;
        int i2;
        char G0;
        int i3;
        int i4;
        this.n = 0;
        char G02 = G0(this.e);
        boolean z = G02 == '\"';
        if (z) {
            G02 = G0(this.e + 1);
            i = 2;
        } else {
            i = 1;
        }
        if (G02 == '-') {
            G02 = G0(this.e + i);
            i++;
        }
        if (G02 < '0' || G02 > '9') {
            if (G02 != 'n' || G0(this.e + i) != 'u' || G0(this.e + i + 1) != 'l' || G0(this.e + i + 2) != 'l') {
                this.n = -1;
                return null;
            }
            this.n = 5;
            int i8 = i + 4;
            char G03 = G0(this.e + i + 3);
            if (z && G03 == '\"') {
                G03 = G0(this.e + i8);
                i8 = i + 5;
            }
            while (G03 != ',') {
                if (G03 == '}') {
                    int i9 = this.e + i8;
                    this.e = i9;
                    this.d = G0(i9);
                    this.n = 5;
                    this.a = 13;
                    return null;
                }
                if (!M0(G03)) {
                    this.n = -1;
                    return null;
                }
                G03 = G0(this.e + i8);
                i8++;
            }
            int i10 = this.e + i8;
            this.e = i10;
            this.d = G0(i10);
            this.n = 5;
            this.a = 16;
            return null;
        }
        while (true) {
            i2 = i + 1;
            G0 = G0(this.e + i);
            if (G0 < '0' || G0 > '9') {
                break;
            }
            i = i2;
        }
        if (G0 == '.') {
            int i11 = i + 2;
            char G04 = G0(this.e + i2);
            if (G04 >= '0' && G04 <= '9') {
                while (true) {
                    i2 = i11 + 1;
                    G0 = G0(this.e + i11);
                    if (G0 < '0' || G0 > '9') {
                        break;
                    }
                    i11 = i2;
                }
            } else {
                this.n = -1;
                return null;
            }
        }
        if (G0 == 'e' || G0 == 'E') {
            int i12 = i2 + 1;
            G0 = G0(this.e + i2);
            if (G0 == '+' || G0 == '-') {
                i2 += 2;
                G0 = G0(this.e + i12);
                if (G0 >= '0' && G0 <= '9') {
                    i12 = i2 + 1;
                    G0 = G0(this.e + i2);
                }
            }
            i2 = i12;
            if (G0 >= '0') {
                i12 = i2 + 1;
                G0 = G0(this.e + i2);
                i2 = i12;
                if (G0 >= '0') {
                }
            }
        }
        if (!z) {
            i3 = this.e;
            i4 = ((i3 + i2) - i3) - 1;
        } else {
            if (G0 != '\"') {
                this.n = -1;
                return null;
            }
            int i13 = i2 + 1;
            G0 = G0(this.e + i2);
            int i14 = this.e;
            i3 = i14 + 1;
            i4 = ((i14 + i13) - i3) - 2;
            i2 = i13;
        }
        if (i4 > 65535) {
            throw new JSONException("decimal overflow");
        }
        char[] s1 = s1(i3, i4);
        BigDecimal bigDecimal = new BigDecimal(s1, 0, s1.length, MathContext.UNLIMITED);
        if (G0 == ',') {
            int i15 = this.e + i2;
            this.e = i15;
            this.d = G0(i15);
            this.n = 3;
            this.a = 16;
            return bigDecimal;
        }
        if (G0 != ']') {
            this.n = -1;
            return null;
        }
        int i16 = i2 + 1;
        char G05 = G0(this.e + i2);
        if (G05 == ',') {
            this.a = 16;
            int i17 = this.e + i16;
            this.e = i17;
            this.d = G0(i17);
        } else if (G05 == ']') {
            this.a = 15;
            int i18 = this.e + i16;
            this.e = i18;
            this.d = G0(i18);
        } else if (G05 == '}') {
            this.a = 13;
            int i19 = this.e + i16;
            this.e = i19;
            this.d = G0(i19);
        } else {
            if (G05 != 26) {
                this.n = -1;
                return null;
            }
            this.a = 20;
            this.e += i2;
            this.d = (char) 26;
        }
        this.n = 4;
        return bigDecimal;
    }

    @Override // a5.b
    public String u0(char c) {
        this.n = 0;
        char G0 = G0(this.e);
        if (G0 == 'n') {
            if (G0(this.e + 1) != 'u' || G0(this.e + 2) != 'l' || G0(this.e + 3) != 'l') {
                this.n = -1;
                return null;
            }
            if (G0(this.e + 4) != c) {
                this.n = -1;
                return null;
            }
            int i = this.e + 5;
            this.e = i;
            this.d = G0(i);
            this.n = 3;
            return null;
        }
        int i2 = 1;
        while (G0 != '\"') {
            if (!M0(G0)) {
                this.n = -1;
                return q1();
            }
            G0 = G0(this.e + i2);
            i2++;
        }
        int i3 = this.e + i2;
        int K0 = K0('\"', i3);
        if (K0 == -1) {
            throw new JSONException("unclosed str");
        }
        String r1 = r1(this.e + i2, K0 - i3);
        if (r1.indexOf(92) != -1) {
            while (true) {
                int i4 = 0;
                for (int i8 = K0 - 1; i8 >= 0 && G0(i8) == '\\'; i8--) {
                    i4++;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                K0 = K0('\"', K0 + 1);
            }
            int i9 = K0 - i3;
            r1 = S0(s1(this.e + 1, i9), i9);
        }
        int i10 = i2 + (K0 - i3) + 1;
        int i11 = i10 + 1;
        char G02 = G0(this.e + i10);
        while (G02 != c) {
            if (!M0(G02)) {
                if (G02 == ']') {
                    int i12 = this.e + i11;
                    this.e = i12;
                    this.d = G0(i12);
                    this.n = -1;
                }
                return r1;
            }
            G02 = G0(this.e + i11);
            i11++;
        }
        int i13 = this.e + i11;
        this.e = i13;
        this.d = G0(i13);
        this.n = 3;
        this.a = 16;
        return r1;
    }

    @Override // a5.b
    public final void v() {
        Q0(':');
    }

    @Override // a5.b
    public final String w(i iVar, char c) {
        String c2;
        this.i = this.e;
        this.h = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.a = 4;
                if (z) {
                    c2 = iVar.c(this.g, 0, this.h, i);
                } else {
                    int i2 = this.i;
                    c2 = b(i2 == -1 ? 0 : i2 + 1, this.h, i, iVar);
                }
                this.h = 0;
                next();
                return c2;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z) {
                    int i3 = this.h;
                    char[] cArr = this.g;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.g = cArr2;
                    }
                    f(this.i + 1, this.g, 0, this.h);
                    z = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i = (i * 31) + 34;
                    R0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i = (i * 31) + 92;
                            R0('\\');
                        } else if (next2 == 'b') {
                            i = (i * 31) + 8;
                            R0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                R0('\n');
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                R0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        R0('/');
                                        break;
                                    case '0':
                                        i = (i * 31) + next2;
                                        R0((char) 0);
                                        break;
                                    case '1':
                                        i = (i * 31) + next2;
                                        R0((char) 1);
                                        break;
                                    case TTAdConstant.IMAGE_MODE_VIDEO_SQUARE /* 50 */:
                                        i = (i * 31) + next2;
                                        R0((char) 2);
                                        break;
                                    case '3':
                                        i = (i * 31) + next2;
                                        R0((char) 3);
                                        break;
                                    case '4':
                                        i = (i * 31) + next2;
                                        R0((char) 4);
                                        break;
                                    case '5':
                                        i = (i * 31) + next2;
                                        R0((char) 5);
                                        break;
                                    case '6':
                                        i = (i * 31) + next2;
                                        R0((char) 6);
                                        break;
                                    case '7':
                                        i = (i * 31) + next2;
                                        R0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                R0('\t');
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + parseInt;
                                                R0((char) parseInt);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                R0((char) 11);
                                                break;
                                            default:
                                                this.d = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.d = next3;
                                char next4 = next();
                                this.d = next4;
                                int[] iArr = s;
                                char c3 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i = (i * 31) + c3;
                                R0(c3);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    R0('\f');
                } else {
                    i = (i * 31) + 39;
                    R0('\'');
                }
            } else {
                i = (i * 31) + next;
                if (z) {
                    int i4 = this.h;
                    char[] cArr3 = this.g;
                    if (i4 == cArr3.length) {
                        R0(next);
                    } else {
                        this.h = i4 + 1;
                        cArr3[i4] = next;
                    }
                } else {
                    this.h++;
                }
            }
        }
    }

    @Override // a5.b
    public final String x() {
        return f.a(this.a);
    }

    @Override // a5.b
    public final void x0() {
        while (true) {
            char c = this.d;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
                return;
            } else {
                p1();
            }
        }
    }

    @Override // a5.b
    public final boolean y() {
        return this.h == 4 && G0(this.i + 1) == '$' && G0(this.i + 2) == 'r' && G0(this.i + 3) == 'e' && G0(this.i + 4) == 'f';
    }

    @Override // a5.b
    public final void y0() {
        this.h = 0;
    }
}
