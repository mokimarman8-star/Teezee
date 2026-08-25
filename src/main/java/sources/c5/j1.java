package c5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class j1 extends Writer {
    private static final ThreadLocal s = new ThreadLocal();
    private static final ThreadLocal t = new ThreadLocal();
    private static final char[] u = ":true".toCharArray();
    private static final char[] v = ":false".toCharArray();
    private static int w;
    static final int x;
    protected char[] a;
    protected int b;
    protected int c;
    private final Writer d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected char o;
    protected int p;
    protected boolean q;
    protected long r;

    static {
        int parseInt;
        w = 131072;
        try {
            String j = com.alibaba.fastjson.util.f.j("fastjson.serializer_buffer_threshold");
            if (j != null && j.length() > 0 && (parseInt = Integer.parseInt(j)) >= 64 && parseInt <= 65536) {
                w = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
        x = SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public j1() {
        this(null);
    }

    public j1(Writer writer) {
        this(writer, com.alibaba.fastjson.a.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public j1(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.p = -1;
        this.d = writer;
        ThreadLocal threadLocal = s;
        char[] cArr = (char[]) threadLocal.get();
        this.a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.a = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.getMask();
        }
        this.c = i;
        h();
    }

    private void f0(String str) {
        byte[] bArr = com.alibaba.fastjson.util.f.g;
        int length = str.length();
        boolean z = true;
        int i = this.b + length + 1;
        int i2 = 0;
        if (i > this.a.length) {
            if (this.d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char charAt = str.charAt(i3);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(39);
                }
                while (i2 < length) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(com.alibaba.fastjson.util.f.j[charAt2]);
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            m(i);
        }
        if (length == 0) {
            int i4 = this.b;
            if (i4 + 3 > this.a.length) {
                m(i4 + 3);
            }
            char[] cArr = this.a;
            int i8 = this.b;
            int i9 = i8 + 1;
            this.b = i9;
            cArr[i8] = '\'';
            int i10 = i8 + 2;
            this.b = i10;
            cArr[i9] = '\'';
            this.b = i8 + 3;
            cArr[i10] = ':';
            return;
        }
        int i11 = this.b;
        int i12 = i11 + length;
        str.getChars(0, length, this.a, i11);
        this.b = i;
        int i13 = i11;
        boolean z2 = false;
        while (i13 < i12) {
            char[] cArr2 = this.a;
            char c = cArr2[i13];
            if (c < bArr.length && bArr[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        m(i);
                    }
                    this.b = i;
                    char[] cArr3 = this.a;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr3, i14, cArr3, i13 + 2, i12 - i13);
                    char[] cArr4 = this.a;
                    cArr4[i13] = '\\';
                    cArr4[i14] = com.alibaba.fastjson.util.f.j[c];
                    i12++;
                    i13 = i14;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        m(i);
                    }
                    this.b = i;
                    char[] cArr5 = this.a;
                    int i15 = i13 + 1;
                    System.arraycopy(cArr5, i15, cArr5, i13 + 3, (i12 - i13) - 1);
                    char[] cArr6 = this.a;
                    System.arraycopy(cArr6, i2, cArr6, 1, i13);
                    char[] cArr7 = this.a;
                    cArr7[i11] = '\'';
                    cArr7[i15] = '\\';
                    i13 += 2;
                    cArr7[i13] = com.alibaba.fastjson.util.f.j[c];
                    i12 += 2;
                    cArr7[this.b - 2] = '\'';
                    z2 = true;
                }
            }
            i13++;
            i2 = 0;
        }
        this.a[i - 1] = ':';
    }

    private int k(OutputStream outputStream) {
        int i = (int) (this.b * 3.0d);
        ThreadLocal threadLocal = t;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i ? new byte[i] : bArr;
        int f = com.alibaba.fastjson.util.f.f(this.a, 0, this.b, bArr2);
        outputStream.write(bArr2, 0, f);
        if (bArr2 != bArr && bArr2.length <= w) {
            threadLocal.set(bArr2);
        }
        return f;
    }

    private byte[] l() {
        int i = (int) (this.b * 3.0d);
        ThreadLocal threadLocal = t;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i ? new byte[i] : bArr;
        int f = com.alibaba.fastjson.util.f.f(this.a, 0, this.b, bArr2);
        byte[] bArr3 = new byte[f];
        System.arraycopy(bArr2, 0, bArr3, 0, f);
        if (bArr2 != bArr && bArr2.length <= w) {
            threadLocal.set(bArr2);
        }
        return bArr3;
    }

    public void S(char c, String str, String str2) {
        if (!this.f) {
            write(c);
            u(str);
            if (str2 == null) {
                h0();
                return;
            } else {
                o0(str2);
                return;
            }
        }
        if (this.e) {
            write(c);
            u(str);
            if (str2 == null) {
                h0();
                return;
            } else {
                o0(str2);
                return;
            }
        }
        if (!o(SerializerFeature.BrowserCompatible)) {
            W(c, str, str2);
            return;
        }
        write(c);
        r0(str, ':');
        r0(str2, (char) 0);
    }

    public void T(char c, String str, BigDecimal bigDecimal) {
        write(c);
        u(str);
        if (bigDecimal == null) {
            h0();
        } else {
            int scale = bigDecimal.scale();
            write((!o(SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        if (r1[r3] == 4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0220, code lost:
    
        if (r3 != '>') goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W(char c, String str, String str2) {
        int length;
        int i;
        int length2 = str.length();
        int i2 = this.b;
        if (str2 == null) {
            i = i2 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i = i2 + length2 + length + 6;
        }
        int i3 = 0;
        if (i > this.a.length) {
            if (this.d != null) {
                write(c);
                r0(str, ':');
                r0(str2, (char) 0);
                return;
            }
            m(i);
        }
        char[] cArr = this.a;
        int i4 = this.b;
        cArr[i4] = c;
        int i8 = i4 + 2;
        int i9 = i8 + length2;
        cArr[i4 + 1] = '\"';
        str.getChars(0, length2, cArr, i8);
        this.b = i;
        char[] cArr2 = this.a;
        cArr2[i9] = '\"';
        int i10 = i9 + 2;
        cArr2[i9 + 1] = ':';
        if (str2 == null) {
            cArr2[i10] = 'n';
            cArr2[i9 + 3] = 'u';
            cArr2[i9 + 4] = 'l';
            cArr2[i9 + 5] = 'l';
            return;
        }
        int i11 = i9 + 3;
        cArr2[i10] = '\"';
        int i12 = i11 + length;
        str2.getChars(0, length, cArr2, i11);
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        char c2 = 0;
        for (int i16 = i11; i16 < i12; i16++) {
            char c3 = this.a[i16];
            if (c3 >= ']') {
                if (c3 >= 127 && (c3 == 8232 || c3 == 8233 || c3 < 160)) {
                    if (i14 == i13) {
                        i14 = i16;
                    }
                    i3++;
                    i += 4;
                    c2 = c3;
                    i15 = i16;
                }
            } else if ((c3 >= '@' || (this.r & (1 << c3)) == 0) && c3 != '\\') {
                i13 = -1;
            } else {
                i3++;
                if (c3 != '(' && c3 != ')' && c3 != '<' && c3 != '>') {
                    byte[] bArr = com.alibaba.fastjson.util.f.f;
                    if (c3 < bArr.length) {
                    }
                    i13 = -1;
                    c2 = c3;
                    if (i14 == -1) {
                        i14 = i16;
                        i15 = i14;
                    }
                    i15 = i16;
                }
                i += 4;
                i13 = -1;
                c2 = c3;
                if (i14 == -1) {
                }
                i15 = i16;
            }
        }
        if (i3 > 0) {
            int i17 = i + i3;
            if (i17 > this.a.length) {
                m(i17);
            }
            this.b = i17;
            if (i3 == 1) {
                if (c2 == 8232) {
                    int i18 = i15 + 1;
                    char[] cArr3 = this.a;
                    System.arraycopy(cArr3, i18, cArr3, i15 + 6, (i12 - i15) - 1);
                    char[] cArr4 = this.a;
                    cArr4[i15] = '\\';
                    cArr4[i18] = 'u';
                    cArr4[i15 + 2] = '2';
                    cArr4[i15 + 3] = '0';
                    cArr4[i15 + 4] = '2';
                    cArr4[i15 + 5] = '8';
                } else if (c2 == 8233) {
                    int i19 = i15 + 1;
                    char[] cArr5 = this.a;
                    System.arraycopy(cArr5, i19, cArr5, i15 + 6, (i12 - i15) - 1);
                    char[] cArr6 = this.a;
                    cArr6[i15] = '\\';
                    cArr6[i19] = 'u';
                    cArr6[i15 + 2] = '2';
                    cArr6[i15 + 3] = '0';
                    cArr6[i15 + 4] = '2';
                    cArr6[i15 + 5] = '9';
                } else if (c2 == '(' || c2 == ')' || c2 == '<' || c2 == '>') {
                    int i20 = i15 + 1;
                    char[] cArr7 = this.a;
                    System.arraycopy(cArr7, i20, cArr7, i15 + 6, (i12 - i15) - 1);
                    char[] cArr8 = this.a;
                    cArr8[i15] = '\\';
                    cArr8[i20] = 'u';
                    char[] cArr9 = com.alibaba.fastjson.util.f.c;
                    cArr8[i15 + 2] = cArr9[(c2 >>> '\f') & 15];
                    cArr8[i15 + 3] = cArr9[(c2 >>> '\b') & 15];
                    cArr8[i15 + 4] = cArr9[(c2 >>> 4) & 15];
                    cArr8[i15 + 5] = cArr9[c2 & 15];
                } else {
                    byte[] bArr2 = com.alibaba.fastjson.util.f.f;
                    if (c2 >= bArr2.length || bArr2[c2] != 4) {
                        int i21 = i15 + 1;
                        char[] cArr10 = this.a;
                        System.arraycopy(cArr10, i21, cArr10, i15 + 2, (i12 - i15) - 1);
                        char[] cArr11 = this.a;
                        cArr11[i15] = '\\';
                        cArr11[i21] = com.alibaba.fastjson.util.f.j[c2];
                    } else {
                        int i22 = i15 + 1;
                        char[] cArr12 = this.a;
                        System.arraycopy(cArr12, i22, cArr12, i15 + 6, (i12 - i15) - 1);
                        char[] cArr13 = this.a;
                        cArr13[i15] = '\\';
                        cArr13[i22] = 'u';
                        char[] cArr14 = com.alibaba.fastjson.util.f.c;
                        cArr13[i15 + 2] = cArr14[(c2 >>> '\f') & 15];
                        cArr13[i15 + 3] = cArr14[(c2 >>> '\b') & 15];
                        cArr13[i15 + 4] = cArr14[(c2 >>> 4) & 15];
                        cArr13[i15 + 5] = cArr14[c2 & 15];
                    }
                }
            } else if (i3 > 1) {
                for (int i23 = i14 - i11; i23 < str2.length(); i23++) {
                    char charAt = str2.charAt(i23);
                    if (this.q) {
                        if (charAt != '(' && charAt != ')') {
                            if (charAt != '<') {
                            }
                        }
                        char[] cArr15 = this.a;
                        cArr15[i14] = '\\';
                        cArr15[i14 + 1] = 'u';
                        char[] cArr16 = com.alibaba.fastjson.util.f.c;
                        cArr15[i14 + 2] = cArr16[(charAt >>> '\f') & 15];
                        cArr15[i14 + 3] = cArr16[(charAt >>> '\b') & 15];
                        int i24 = i14 + 5;
                        cArr15[i14 + 4] = cArr16[(charAt >>> 4) & 15];
                        i14 += 6;
                        cArr15[i24] = cArr16[charAt & 15];
                    }
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f;
                    if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr17 = this.a;
                        int i25 = i14 + 1;
                        cArr17[i14] = '\\';
                        if (bArr3[charAt] == 4) {
                            cArr17[i25] = 'u';
                            char[] cArr18 = com.alibaba.fastjson.util.f.c;
                            cArr17[i14 + 2] = cArr18[(charAt >>> '\f') & 15];
                            cArr17[i14 + 3] = cArr18[(charAt >>> '\b') & 15];
                            int i26 = i14 + 5;
                            cArr17[i14 + 4] = cArr18[(charAt >>> 4) & 15];
                            i14 += 6;
                            cArr17[i26] = cArr18[charAt & 15];
                        } else {
                            i14 += 2;
                            cArr17[i25] = com.alibaba.fastjson.util.f.j[charAt];
                        }
                    } else if (charAt == 8232 || charAt == 8233) {
                        char[] cArr19 = this.a;
                        cArr19[i14] = '\\';
                        cArr19[i14 + 1] = 'u';
                        char[] cArr20 = com.alibaba.fastjson.util.f.c;
                        cArr19[i14 + 2] = cArr20[(charAt >>> '\f') & 15];
                        cArr19[i14 + 3] = cArr20[(charAt >>> '\b') & 15];
                        int i27 = i14 + 5;
                        cArr19[i14 + 4] = cArr20[(charAt >>> 4) & 15];
                        i14 += 6;
                        cArr19[i27] = cArr20[charAt & 15];
                    } else {
                        this.a[i14] = charAt;
                        i14++;
                    }
                }
            }
        }
        this.a[this.b - 1] = '\"';
    }

    public void X(float f, boolean z) {
        if (f != f || f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
            h0();
            return;
        }
        int i = this.b + 15;
        if (i > this.a.length) {
            if (this.d != null) {
                String b = com.alibaba.fastjson.util.k.b(f);
                write(b, 0, b.length());
                if (z && o(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            m(i);
        }
        this.b += com.alibaba.fastjson.util.k.a(f, this.a, this.b);
        if (z && o(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d != null && this.b > 0) {
            flush();
        }
        char[] cArr = this.a;
        if (cArr.length <= w) {
            s.set(cArr);
        }
        this.a = null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void d0(byte[] bArr) {
        int length = this.b + (bArr.length * 2) + 3;
        if (length > this.a.length) {
            m(length);
        }
        char[] cArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        cArr[i] = 'x';
        this.b = i + 2;
        cArr[i2] = '\'';
        for (byte b : bArr) {
            int i3 = (b & 255) >> 4;
            int i4 = b & 15;
            char[] cArr2 = this.a;
            int i8 = this.b;
            int i9 = i8 + 1;
            this.b = i9;
            int i10 = 55;
            cArr2[i8] = (char) (i3 + (i3 < 10 ? 48 : 55));
            this.b = i8 + 2;
            if (i4 < 10) {
                i10 = 48;
            }
            cArr2[i9] = (char) (i4 + i10);
        }
        char[] cArr3 = this.a;
        int i11 = this.b;
        this.b = i11 + 1;
        cArr3[i11] = '\'';
    }

    public void e0(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int n = i < 0 ? com.alibaba.fastjson.util.f.n(-i) + 1 : com.alibaba.fastjson.util.f.n(i);
        int i2 = this.b + n;
        if (i2 > this.a.length) {
            if (this.d != null) {
                char[] cArr = new char[n];
                com.alibaba.fastjson.util.f.h(i, n, cArr);
                write(cArr, 0, n);
                return;
            }
            m(i2);
        }
        com.alibaba.fastjson.util.f.h(i, i2, this.a);
        this.b = i2;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.a, 0, this.b);
            this.d.flush();
            this.b = 0;
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public void g0(long j) {
        boolean z = o(SerializerFeature.BrowserCompatible) && !o(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int o = j < 0 ? com.alibaba.fastjson.util.f.o(-j) + 1 : com.alibaba.fastjson.util.f.o(j);
        int i = this.b + o;
        if (z) {
            i += 2;
        }
        if (i > this.a.length) {
            if (this.d != null) {
                char[] cArr = new char[o];
                com.alibaba.fastjson.util.f.i(j, o, cArr);
                if (!z) {
                    write(cArr, 0, o);
                    return;
                }
                write(34);
                write(cArr, 0, o);
                write(34);
                return;
            }
            m(i);
        }
        if (z) {
            char[] cArr2 = this.a;
            cArr2[this.b] = '\"';
            int i2 = i - 1;
            com.alibaba.fastjson.util.f.i(j, i2, cArr2);
            this.a[i2] = '\"';
        } else {
            com.alibaba.fastjson.util.f.i(j, i, this.a);
        }
        this.b = i;
    }

    protected void h() {
        int i = this.c;
        boolean z = (SerializerFeature.QuoteFieldNames.mask & i) != 0;
        this.f = z;
        boolean z2 = (SerializerFeature.UseSingleQuotes.mask & i) != 0;
        this.e = z2;
        this.g = (SerializerFeature.SortField.mask & i) != 0;
        this.h = (SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0;
        boolean z3 = (SerializerFeature.BeanToArray.mask & i) != 0;
        this.i = z3;
        this.j = (SerializerFeature.WriteNonStringValueAsString.mask & i) != 0;
        this.k = (SerializerFeature.NotWriteDefaultValue.mask & i) != 0;
        boolean z4 = (SerializerFeature.WriteEnumUsingName.mask & i) != 0;
        this.l = z4;
        this.m = (SerializerFeature.WriteEnumUsingToString.mask & i) != 0;
        this.n = z && (x & i) == 0 && (z3 || z4);
        this.o = z2 ? '\'' : '\"';
        boolean z7 = (SerializerFeature.BrowserSecure.mask & i) != 0;
        this.q = z7;
        this.r = z7 ? 5764610843043954687L : (i & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
    }

    public void h0() {
        write("null");
    }

    public void j(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            int mask = this.c | serializerFeature.getMask();
            this.c = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.c = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.c = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.c = (~serializerFeature.getMask()) & this.c;
        }
        h();
    }

    public void j0(int i, int i2) {
        if ((i & i2) == 0 && (this.c & i2) == 0) {
            h0();
            return;
        }
        int i3 = SerializerFeature.WriteMapNullValue.mask;
        if ((i & i3) != 0 && (i & (~i3) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            h0();
            return;
        }
        if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            o0("");
            return;
        }
        if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            h0();
        }
    }

    public void l0(SerializerFeature serializerFeature) {
        j0(0, serializerFeature.mask);
    }

    public void m(int i) {
        int i2 = this.p;
        if (i2 != -1 && i >= i2) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.p + ", minimumCapacity=" + i);
        }
        char[] cArr = this.a;
        int length = cArr.length + (cArr.length >> 1) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.b);
        if (this.a.length < w) {
            ThreadLocal threadLocal = s;
            char[] cArr3 = (char[]) threadLocal.get();
            if (cArr3 == null || cArr3.length < this.a.length) {
                threadLocal.set(this.a);
            }
        }
        this.a = cArr2;
    }

    public boolean n(int i) {
        return (i & this.c) != 0;
    }

    public boolean o(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.c) != 0;
    }

    public void o0(String str) {
        if (this.e) {
            s0(str);
        } else {
            r0(str, (char) 0);
        }
    }

    public byte[] p(Charset charset) {
        if (this.d == null) {
            return charset == com.alibaba.fastjson.util.f.b ? l() : new String(this.a, 0, this.b).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void p0(char[] cArr) {
        if (this.e) {
            t0(cArr);
        } else {
            r0(new String(cArr), (char) 0);
        }
    }

    public void q(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    public void r(byte[] bArr) {
        if (n(SerializerFeature.WriteClassName.mask)) {
            d0(bArr);
            return;
        }
        int length = bArr.length;
        boolean z = this.e;
        char c = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.fastjson.util.f.p;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.b;
        int i4 = (((i2 / 3) + 1) << 2) + i3;
        int i8 = i4 + 2;
        if (i8 > this.a.length) {
            if (this.d != null) {
                write(c);
                int i9 = 0;
                while (i9 < i) {
                    int i10 = i9 + 2;
                    int i11 = ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9] & 255) << 16);
                    i9 += 3;
                    int i12 = i11 | (bArr[i10] & 255);
                    write(cArr[(i12 >>> 18) & 63]);
                    write(cArr[(i12 >>> 12) & 63]);
                    write(cArr[(i12 >>> 6) & 63]);
                    write(cArr[i12 & 63]);
                }
                int i13 = length - i;
                if (i13 > 0) {
                    int i14 = ((bArr[i] & 255) << 10) | (i13 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i14 >> 12]);
                    write(cArr[(i14 >>> 6) & 63]);
                    write(i13 == 2 ? cArr[i14 & 63] : '=');
                    write(61);
                }
                write(c);
                return;
            }
            m(i8);
        }
        this.b = i8;
        int i15 = i3 + 1;
        this.a[i3] = c;
        int i16 = 0;
        while (i16 < i) {
            int i17 = i16 + 2;
            int i18 = ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16] & 255) << 16);
            i16 += 3;
            int i19 = i18 | (bArr[i17] & 255);
            char[] cArr2 = this.a;
            cArr2[i15] = cArr[(i19 >>> 18) & 63];
            cArr2[i15 + 1] = cArr[(i19 >>> 12) & 63];
            int i20 = i15 + 3;
            cArr2[i15 + 2] = cArr[(i19 >>> 6) & 63];
            i15 += 4;
            cArr2[i20] = cArr[i19 & 63];
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.a;
            cArr3[i4 - 3] = cArr[i22 >> 12];
            cArr3[i4 - 2] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 1] = i21 == 2 ? cArr[i22 & 63] : '=';
            cArr3[i4] = '=';
        }
        this.a[i4 + 1] = c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x02e5, code lost:
    
        if (r4[r14] == 4) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0439, code lost:
    
        if (r4 != '>') goto L215;
     */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r0(String str, char c) {
        if (str == null) {
            h0();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i = this.b + length;
        int i2 = i + 2;
        if (c != 0) {
            i2 = i + 3;
        }
        char c2 = '>';
        if (i2 > this.a.length) {
            if (this.d != null) {
                write(34);
                int i3 = 0;
                while (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    if (o(SerializerFeature.BrowserSecure) && (charAt == '(' || charAt == ')' || charAt == '<' || charAt == c2)) {
                        write(92);
                        write(117);
                        char[] cArr = com.alibaba.fastjson.util.f.c;
                        write(cArr[(charAt >>> '\f') & 15]);
                        write(cArr[(charAt >>> '\b') & 15]);
                        write(cArr[(charAt >>> 4) & 15]);
                        write(cArr[charAt & 15]);
                    } else if (!o(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = com.alibaba.fastjson.util.f.f;
                        if ((charAt < bArr.length && bArr[charAt] != 0) || (charAt == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (bArr[charAt] == 4) {
                                write(117);
                                char[] cArr2 = com.alibaba.fastjson.util.f.c;
                                write(cArr2[(charAt >>> '\f') & 15]);
                                write(cArr2[(charAt >>> '\b') & 15]);
                                write(cArr2[(charAt >>> 4) & 15]);
                                write(cArr2[charAt & 15]);
                            } else {
                                write(com.alibaba.fastjson.util.f.j[charAt]);
                            }
                        }
                        write(charAt);
                    } else if (charAt == '\b' || charAt == '\f' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\"' || charAt == '/' || charAt == '\\') {
                        write(92);
                        write(com.alibaba.fastjson.util.f.j[charAt]);
                    } else if (charAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr3 = com.alibaba.fastjson.util.f.k;
                        int i4 = charAt * 2;
                        write(cArr3[i4]);
                        write(cArr3[i4 + 1]);
                    } else {
                        if (charAt >= 127) {
                            write(92);
                            write(117);
                            char[] cArr4 = com.alibaba.fastjson.util.f.c;
                            write(cArr4[(charAt >>> '\f') & 15]);
                            write(cArr4[(charAt >>> '\b') & 15]);
                            write(cArr4[(charAt >>> 4) & 15]);
                            write(cArr4[charAt & 15]);
                        }
                        write(charAt);
                    }
                    i3++;
                    c2 = '>';
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            m(i2);
        }
        int i8 = this.b;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr5 = this.a;
        cArr5[i8] = '\"';
        char c3 = 0;
        str.getChars(0, length, cArr5, i9);
        this.b = i2;
        int i11 = -1;
        if (o(SerializerFeature.BrowserCompatible)) {
            for (int i12 = i9; i12 < i10; i12++) {
                char c4 = this.a[i12];
                if (c4 == '\"' || c4 == '/' || c4 == '\\' || c4 == '\b' || c4 == '\f' || c4 == '\n' || c4 == '\r' || c4 == '\t') {
                    i2++;
                } else if (c4 < ' ' || c4 >= 127) {
                    i2 += 5;
                }
                i11 = i12;
            }
            if (i2 > this.a.length) {
                m(i2);
            }
            this.b = i2;
            while (i11 >= i9) {
                char[] cArr6 = this.a;
                char c8 = cArr6[i11];
                if (c8 == '\b' || c8 == '\f' || c8 == '\n' || c8 == '\r' || c8 == '\t') {
                    int i13 = i11 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i11 + 2, (i10 - i11) - 1);
                    char[] cArr7 = this.a;
                    cArr7[i11] = '\\';
                    cArr7[i13] = com.alibaba.fastjson.util.f.j[c8];
                } else if (c8 == '\"' || c8 == '/' || c8 == '\\') {
                    int i14 = i11 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i11 + 2, (i10 - i11) - 1);
                    char[] cArr8 = this.a;
                    cArr8[i11] = '\\';
                    cArr8[i14] = c8;
                } else {
                    if (c8 < ' ') {
                        int i15 = i11 + 1;
                        System.arraycopy(cArr6, i15, cArr6, i11 + 6, (i10 - i11) - 1);
                        char[] cArr9 = this.a;
                        cArr9[i11] = '\\';
                        cArr9[i15] = 'u';
                        cArr9[i11 + 2] = '0';
                        cArr9[i11 + 3] = '0';
                        char[] cArr10 = com.alibaba.fastjson.util.f.k;
                        int i16 = c8 * 2;
                        cArr9[i11 + 4] = cArr10[i16];
                        cArr9[i11 + 5] = cArr10[i16 + 1];
                    } else if (c8 >= 127) {
                        int i17 = i11 + 1;
                        System.arraycopy(cArr6, i17, cArr6, i11 + 6, (i10 - i11) - 1);
                        char[] cArr11 = this.a;
                        cArr11[i11] = '\\';
                        cArr11[i17] = 'u';
                        char[] cArr12 = com.alibaba.fastjson.util.f.c;
                        cArr11[i11 + 2] = cArr12[(c8 >>> '\f') & 15];
                        cArr11[i11 + 3] = cArr12[(c8 >>> '\b') & 15];
                        cArr11[i11 + 4] = cArr12[(c8 >>> 4) & 15];
                        cArr11[i11 + 5] = cArr12[c8 & 15];
                    } else {
                        i11--;
                    }
                    i10 += 5;
                    i11--;
                }
                i10++;
                i11--;
            }
            if (c == 0) {
                this.a[this.b - 1] = '\"';
                return;
            }
            char[] cArr13 = this.a;
            int i18 = this.b;
            cArr13[i18 - 2] = '\"';
            cArr13[i18 - 1] = c;
            return;
        }
        int i19 = 0;
        int i20 = -1;
        int i21 = -1;
        for (int i22 = i9; i22 < i10; i22++) {
            char c9 = this.a[i22];
            if (c9 >= ']') {
                if (c9 >= 127 && (c9 == 8232 || c9 == 8233 || c9 < 160)) {
                    if (i20 == i11) {
                        i20 = i22;
                    }
                    i19++;
                    i2 += 4;
                    i21 = i22;
                }
            } else if ((c9 >= '@' || (this.r & (1 << c9)) == 0) && c9 != '\\') {
                i11 = -1;
            } else {
                i19++;
                if (c9 != '(' && c9 != ')' && c9 != '<' && c9 != '>') {
                    byte[] bArr2 = com.alibaba.fastjson.util.f.f;
                    if (c9 < bArr2.length) {
                    }
                    i11 = -1;
                    if (i20 == -1) {
                        i20 = i22;
                        i21 = i20;
                    }
                    i21 = i22;
                }
                i2 += 4;
                i11 = -1;
                if (i20 == -1) {
                }
                i21 = i22;
            }
            c3 = c9;
        }
        if (i19 > 0) {
            int i23 = i2 + i19;
            if (i23 > this.a.length) {
                m(i23);
            }
            this.b = i23;
            if (i19 == 1) {
                if (c3 == 8232) {
                    int i24 = i21 + 1;
                    char[] cArr14 = this.a;
                    System.arraycopy(cArr14, i24, cArr14, i21 + 6, (i10 - i21) - 1);
                    char[] cArr15 = this.a;
                    cArr15[i21] = '\\';
                    cArr15[i24] = 'u';
                    cArr15[i21 + 2] = '2';
                    cArr15[i21 + 3] = '0';
                    cArr15[i21 + 4] = '2';
                    cArr15[i21 + 5] = '8';
                } else if (c3 == 8233) {
                    int i25 = i21 + 1;
                    char[] cArr16 = this.a;
                    System.arraycopy(cArr16, i25, cArr16, i21 + 6, (i10 - i21) - 1);
                    char[] cArr17 = this.a;
                    cArr17[i21] = '\\';
                    cArr17[i25] = 'u';
                    cArr17[i21 + 2] = '2';
                    cArr17[i21 + 3] = '0';
                    cArr17[i21 + 4] = '2';
                    cArr17[i21 + 5] = '9';
                } else if (c3 == '(' || c3 == ')' || c3 == '<' || c3 == '>') {
                    int i26 = i21 + 1;
                    char[] cArr18 = this.a;
                    System.arraycopy(cArr18, i26, cArr18, i21 + 6, (i10 - i21) - 1);
                    char[] cArr19 = this.a;
                    cArr19[i21] = '\\';
                    cArr19[i26] = 'u';
                    char[] cArr20 = com.alibaba.fastjson.util.f.c;
                    cArr19[i21 + 2] = cArr20[(c3 >>> '\f') & 15];
                    cArr19[i21 + 3] = cArr20[(c3 >>> '\b') & 15];
                    cArr19[i21 + 4] = cArr20[(c3 >>> 4) & 15];
                    cArr19[i21 + 5] = cArr20[c3 & 15];
                } else {
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f;
                    if (c3 >= bArr3.length || bArr3[c3] != 4) {
                        int i27 = i21 + 1;
                        char[] cArr21 = this.a;
                        System.arraycopy(cArr21, i27, cArr21, i21 + 2, (i10 - i21) - 1);
                        char[] cArr22 = this.a;
                        cArr22[i21] = '\\';
                        cArr22[i27] = com.alibaba.fastjson.util.f.j[c3];
                    } else {
                        int i28 = i21 + 1;
                        char[] cArr23 = this.a;
                        System.arraycopy(cArr23, i28, cArr23, i21 + 6, (i10 - i21) - 1);
                        char[] cArr24 = this.a;
                        cArr24[i21] = '\\';
                        cArr24[i28] = 'u';
                        char[] cArr25 = com.alibaba.fastjson.util.f.c;
                        cArr24[i21 + 2] = cArr25[(c3 >>> '\f') & 15];
                        cArr24[i21 + 3] = cArr25[(c3 >>> '\b') & 15];
                        cArr24[i21 + 4] = cArr25[(c3 >>> 4) & 15];
                        cArr24[i21 + 5] = cArr25[c3 & 15];
                    }
                }
            } else if (i19 > 1) {
                for (int i29 = i20 - i9; i29 < str.length(); i29++) {
                    char charAt2 = str.charAt(i29);
                    if (this.q) {
                        if (charAt2 != '(' && charAt2 != ')') {
                            if (charAt2 != '<') {
                            }
                        }
                        char[] cArr26 = this.a;
                        cArr26[i20] = '\\';
                        cArr26[i20 + 1] = 'u';
                        char[] cArr27 = com.alibaba.fastjson.util.f.c;
                        cArr26[i20 + 2] = cArr27[(charAt2 >>> '\f') & 15];
                        cArr26[i20 + 3] = cArr27[(charAt2 >>> '\b') & 15];
                        int i30 = i20 + 5;
                        cArr26[i20 + 4] = cArr27[(charAt2 >>> 4) & 15];
                        i20 += 6;
                        cArr26[i30] = cArr27[charAt2 & 15];
                    }
                    byte[] bArr4 = com.alibaba.fastjson.util.f.f;
                    if ((charAt2 >= bArr4.length || bArr4[charAt2] == 0) && (charAt2 != '/' || !o(SerializerFeature.WriteSlashAsSpecial))) {
                        if (charAt2 == 8232 || charAt2 == 8233) {
                            char[] cArr28 = this.a;
                            cArr28[i20] = '\\';
                            cArr28[i20 + 1] = 'u';
                            char[] cArr29 = com.alibaba.fastjson.util.f.c;
                            cArr28[i20 + 2] = cArr29[(charAt2 >>> '\f') & 15];
                            cArr28[i20 + 3] = cArr29[(charAt2 >>> '\b') & 15];
                            int i31 = i20 + 5;
                            cArr28[i20 + 4] = cArr29[(charAt2 >>> 4) & 15];
                            i20 += 6;
                            cArr28[i31] = cArr29[charAt2 & 15];
                        } else {
                            this.a[i20] = charAt2;
                            i20++;
                        }
                    }
                    char[] cArr30 = this.a;
                    int i32 = i20 + 1;
                    cArr30[i20] = '\\';
                    if (bArr4[charAt2] == 4) {
                        cArr30[i32] = 'u';
                        char[] cArr31 = com.alibaba.fastjson.util.f.c;
                        cArr30[i20 + 2] = cArr31[(charAt2 >>> '\f') & 15];
                        cArr30[i20 + 3] = cArr31[(charAt2 >>> '\b') & 15];
                        int i33 = i20 + 5;
                        cArr30[i20 + 4] = cArr31[(charAt2 >>> 4) & 15];
                        i20 += 6;
                        cArr30[i33] = cArr31[charAt2 & 15];
                    } else {
                        i20 += 2;
                        cArr30[i32] = com.alibaba.fastjson.util.f.j[charAt2];
                    }
                }
            }
        }
        if (c == 0) {
            this.a[this.b - 1] = '\"';
            return;
        }
        char[] cArr32 = this.a;
        int i34 = this.b;
        cArr32[i34 - 2] = '\"';
        cArr32[i34 - 1] = c;
    }

    public void s(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            h0();
            return;
        }
        int i = this.b + 24;
        if (i > this.a.length) {
            if (this.d != null) {
                String b = com.alibaba.fastjson.util.j.b(d);
                write(b, 0, b.length());
                if (z && o(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            m(i);
        }
        this.b += com.alibaba.fastjson.util.j.a(d, this.a, this.b);
        if (z && o(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    protected void s0(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.b + 4;
            if (i2 > this.a.length) {
                m(i2);
            }
            "null".getChars(0, 4, this.a, this.b);
            this.b = i2;
            return;
        }
        int length = str.length();
        int i3 = this.b + length + 2;
        if (i3 > this.a.length) {
            if (this.d != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.j[charAt]);
                    } else {
                        write(charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            m(i3);
        }
        int i4 = this.b;
        int i8 = i4 + 1;
        int i9 = i8 + length;
        char[] cArr = this.a;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i8);
        this.b = i3;
        int i10 = -1;
        char c = 0;
        for (int i11 = i8; i11 < i9; i11++) {
            char c2 = this.a[i11];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i10 = i11;
                c = c2;
            }
        }
        int i12 = i3 + i;
        if (i12 > this.a.length) {
            m(i12);
        }
        this.b = i12;
        if (i == 1) {
            char[] cArr2 = this.a;
            int i13 = i10 + 1;
            System.arraycopy(cArr2, i13, cArr2, i10 + 2, (i9 - i10) - 1);
            char[] cArr3 = this.a;
            cArr3[i10] = '\\';
            cArr3[i13] = com.alibaba.fastjson.util.f.j[c];
        } else if (i > 1) {
            char[] cArr4 = this.a;
            int i14 = i10 + 1;
            System.arraycopy(cArr4, i14, cArr4, i10 + 2, (i9 - i10) - 1);
            char[] cArr5 = this.a;
            cArr5[i10] = '\\';
            cArr5[i14] = com.alibaba.fastjson.util.f.j[c];
            int i15 = i9 + 1;
            for (int i16 = i10 - 1; i16 >= i8; i16--) {
                char c3 = this.a[i16];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.a;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr6, i17, cArr6, i16 + 2, (i15 - i16) - 1);
                    char[] cArr7 = this.a;
                    cArr7[i16] = '\\';
                    cArr7[i17] = com.alibaba.fastjson.util.f.j[c3];
                    i15++;
                }
            }
        }
        this.a[this.b - 1] = '\'';
    }

    public void t(Enum r2) {
        if (r2 == null) {
            h0();
            return;
        }
        String str = (!this.l || this.m) ? this.m ? r2.toString() : null : r2.name();
        if (str == null) {
            e0(r2.ordinal());
            return;
        }
        int i = o(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i);
        write(str);
        write(i);
    }

    protected void t0(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.b + 4;
            if (i2 > this.a.length) {
                m(i2);
            }
            "null".getChars(0, 4, this.a, this.b);
            this.b = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.b + length + 2;
        if (i3 > this.a.length) {
            if (this.d != null) {
                write(39);
                while (i < cArr.length) {
                    char c = cArr[i];
                    if (c <= '\r' || c == '\\' || c == '\'' || (c == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.j[c]);
                    } else {
                        write(c);
                    }
                    i++;
                }
                write(39);
                return;
            }
            m(i3);
        }
        int i4 = this.b;
        int i8 = i4 + 1;
        int i9 = length + i8;
        char[] cArr2 = this.a;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i8, cArr.length);
        this.b = i3;
        int i10 = -1;
        char c2 = 0;
        for (int i11 = i8; i11 < i9; i11++) {
            char c3 = this.a[i11];
            if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i10 = i11;
                c2 = c3;
            }
        }
        int i12 = i3 + i;
        if (i12 > this.a.length) {
            m(i12);
        }
        this.b = i12;
        if (i == 1) {
            char[] cArr3 = this.a;
            int i13 = i10 + 1;
            System.arraycopy(cArr3, i13, cArr3, i10 + 2, (i9 - i10) - 1);
            char[] cArr4 = this.a;
            cArr4[i10] = '\\';
            cArr4[i13] = com.alibaba.fastjson.util.f.j[c2];
        } else if (i > 1) {
            char[] cArr5 = this.a;
            int i14 = i10 + 1;
            System.arraycopy(cArr5, i14, cArr5, i10 + 2, (i9 - i10) - 1);
            char[] cArr6 = this.a;
            cArr6[i10] = '\\';
            cArr6[i14] = com.alibaba.fastjson.util.f.j[c2];
            int i15 = i9 + 1;
            for (int i16 = i10 - 1; i16 >= i8; i16--) {
                char c4 = this.a[i16];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && o(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.a;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr7, i17, cArr7, i16 + 2, (i15 - i16) - 1);
                    char[] cArr8 = this.a;
                    cArr8[i16] = '\\';
                    cArr8[i17] = com.alibaba.fastjson.util.f.j[c4];
                    i15++;
                }
            }
        }
        this.a[this.b - 1] = '\'';
    }

    public String toString() {
        return new String(this.a, 0, this.b);
    }

    public void u(String str) {
        v(str, false);
    }

    public int u0(OutputStream outputStream, Charset charset) {
        if (this.d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == com.alibaba.fastjson.util.f.b) {
            return k(outputStream);
        }
        byte[] bytes = new String(this.a, 0, this.b).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public void v(String str, boolean z) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.e) {
            if (!this.f) {
                f0(str);
                return;
            } else {
                s0(str);
                write(58);
                return;
            }
        }
        if (this.f) {
            r0(str, ':');
            return;
        }
        int i = 0;
        boolean z2 = true;
        boolean z3 = str.length() == 0;
        while (true) {
            if (i >= str.length()) {
                z2 = z3;
                break;
            }
            char charAt = str.charAt(i);
            if ((charAt < '@' && (this.r & (1 << charAt)) != 0) || charAt == '\\') {
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            r0(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    public void w(char c, String str, double d) {
        write(c);
        u(str);
        s(d, false);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.b + 1;
        if (i3 > this.a.length) {
            if (this.d != null) {
                flush();
                this.a[this.b] = (char) i;
                this.b = i2;
            }
            m(i3);
        }
        i2 = i3;
        this.a[this.b] = (char) i;
        this.b = i2;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            h0();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.b + i2;
        if (i4 > this.a.length) {
            if (this.d == null) {
                m(i4);
            } else {
                while (true) {
                    char[] cArr = this.a;
                    int length = cArr.length;
                    int i8 = this.b;
                    int i9 = length - i8;
                    i3 = i + i9;
                    str.getChars(i, i3, cArr, i8);
                    this.b = this.a.length;
                    flush();
                    i2 -= i9;
                    if (i2 <= this.a.length) {
                        break;
                    } else {
                        i = i3;
                    }
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.a, this.b);
        this.b = i4;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.b + i2;
        if (i4 > this.a.length) {
            if (this.d == null) {
                m(i4);
            } else {
                do {
                    char[] cArr2 = this.a;
                    int length = cArr2.length;
                    int i8 = this.b;
                    int i9 = length - i8;
                    System.arraycopy(cArr, i, cArr2, i8, i9);
                    this.b = this.a.length;
                    flush();
                    i2 -= i9;
                    i += i9;
                } while (i2 > this.a.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.a, this.b, i2);
        this.b = i4;
    }

    public void x(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.f) {
            write(c);
            u(str);
            e0(i);
            return;
        }
        int n = i < 0 ? com.alibaba.fastjson.util.f.n(-i) + 1 : com.alibaba.fastjson.util.f.n(i);
        int length = str.length();
        int i2 = this.b + length + 4 + n;
        if (i2 > this.a.length) {
            if (this.d != null) {
                write(c);
                u(str);
                e0(i);
                return;
            }
            m(i2);
        }
        int i3 = this.b;
        this.b = i2;
        char[] cArr = this.a;
        cArr[i3] = c;
        int i4 = i3 + length;
        cArr[i3 + 1] = this.o;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.a;
        cArr2[i4 + 2] = this.o;
        cArr2[i4 + 3] = ':';
        com.alibaba.fastjson.util.f.h(i, this.b, cArr2);
    }

    public void y(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.f || n(SerializerFeature.BrowserCompatible.mask)) {
            write(c);
            u(str);
            g0(j);
            return;
        }
        int o = j < 0 ? com.alibaba.fastjson.util.f.o(-j) + 1 : com.alibaba.fastjson.util.f.o(j);
        int length = str.length();
        int i = this.b + length + 4 + o;
        if (i > this.a.length) {
            if (this.d != null) {
                write(c);
                u(str);
                g0(j);
                return;
            }
            m(i);
        }
        int i2 = this.b;
        this.b = i;
        char[] cArr = this.a;
        cArr[i2] = c;
        int i3 = i2 + length;
        cArr[i2 + 1] = this.o;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.a;
        cArr2[i3 + 2] = this.o;
        cArr2[i3 + 3] = ':';
        com.alibaba.fastjson.util.f.i(j, this.b, cArr2);
    }
}
