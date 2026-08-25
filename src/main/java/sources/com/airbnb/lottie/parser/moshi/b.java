package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b extends JsonReader {

    /* renamed from: n, reason: collision with root package name */
    private static final ByteString f14518n = ByteString.encodeUtf8("'\\");

    /* renamed from: o, reason: collision with root package name */
    private static final ByteString f14519o = ByteString.encodeUtf8("\"\\");

    /* renamed from: p, reason: collision with root package name */
    private static final ByteString f14520p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    private static final ByteString f14521q = ByteString.encodeUtf8("\n\r");

    /* renamed from: r, reason: collision with root package name */
    private static final ByteString f14522r = ByteString.encodeUtf8("*/");

    /* renamed from: h, reason: collision with root package name */
    private final BufferedSource f14523h;

    /* renamed from: i, reason: collision with root package name */
    private final Buffer f14524i;

    /* renamed from: j, reason: collision with root package name */
    private int f14525j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f14526k;

    /* renamed from: l, reason: collision with root package name */
    private int f14527l;

    /* renamed from: m, reason: collision with root package name */
    private String f14528m;

    b(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f14523h = bufferedSource;
        this.f14524i = bufferedSource.buffer();
        u(6);
    }

    private void T() {
        if (!((JsonReader) this).e) {
            throw S("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int W() {
        int[] iArr = ((JsonReader) this).b;
        int i5 = ((JsonReader) this).a;
        int i6 = iArr[i5 - 1];
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
        } else if (i6 == 2) {
            int e02 = e0(true);
            this.f14524i.readByte();
            if (e02 != 44) {
                if (e02 != 59) {
                    if (e02 != 93) {
                        throw S("Unterminated array");
                    }
                    this.f14525j = 4;
                    return 4;
                }
                T();
            }
        } else {
            if (i6 == 3 || i6 == 5) {
                iArr[i5 - 1] = 4;
                if (i6 == 5) {
                    int e03 = e0(true);
                    this.f14524i.readByte();
                    if (e03 != 44) {
                        if (e03 != 59) {
                            if (e03 != 125) {
                                throw S("Unterminated object");
                            }
                            this.f14525j = 2;
                            return 2;
                        }
                        T();
                    }
                }
                int e04 = e0(true);
                if (e04 == 34) {
                    this.f14524i.readByte();
                    this.f14525j = 13;
                    return 13;
                }
                if (e04 == 39) {
                    this.f14524i.readByte();
                    T();
                    this.f14525j = 12;
                    return 12;
                }
                if (e04 != 125) {
                    T();
                    if (!d0((char) e04)) {
                        throw S("Expected name");
                    }
                    this.f14525j = 14;
                    return 14;
                }
                if (i6 == 5) {
                    throw S("Expected name");
                }
                this.f14524i.readByte();
                this.f14525j = 2;
                return 2;
            }
            if (i6 == 4) {
                iArr[i5 - 1] = 5;
                int e05 = e0(true);
                this.f14524i.readByte();
                if (e05 != 58) {
                    if (e05 != 61) {
                        throw S("Expected ':'");
                    }
                    T();
                    if (this.f14523h.request(1L) && this.f14524i.getByte(0L) == 62) {
                        this.f14524i.readByte();
                    }
                }
            } else if (i6 == 6) {
                iArr[i5 - 1] = 7;
            } else if (i6 == 7) {
                if (e0(false) == -1) {
                    this.f14525j = 18;
                    return 18;
                }
                T();
            } else if (i6 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int e06 = e0(true);
        if (e06 == 34) {
            this.f14524i.readByte();
            this.f14525j = 9;
            return 9;
        }
        if (e06 == 39) {
            T();
            this.f14524i.readByte();
            this.f14525j = 8;
            return 8;
        }
        if (e06 != 44 && e06 != 59) {
            if (e06 == 91) {
                this.f14524i.readByte();
                this.f14525j = 3;
                return 3;
            }
            if (e06 != 93) {
                if (e06 == 123) {
                    this.f14524i.readByte();
                    this.f14525j = 1;
                    return 1;
                }
                int h02 = h0();
                if (h02 != 0) {
                    return h02;
                }
                int j02 = j0();
                if (j02 != 0) {
                    return j02;
                }
                if (!d0(this.f14524i.getByte(0L))) {
                    throw S("Expected value");
                }
                T();
                this.f14525j = 10;
                return 10;
            }
            if (i6 == 1) {
                this.f14524i.readByte();
                this.f14525j = 4;
                return 4;
            }
        }
        if (i6 != 1 && i6 != 2) {
            throw S("Unexpected value");
        }
        T();
        this.f14525j = 7;
        return 7;
    }

    private int X(String str, JsonReader$a jsonReader$a) {
        int length = jsonReader$a.f14516a.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (str.equals(jsonReader$a.f14516a[i5])) {
                this.f14525j = 0;
                ((JsonReader) this).c[((JsonReader) this).a - 1] = str;
                return i5;
            }
        }
        return -1;
    }

    private boolean d0(int i5) {
        if (i5 == 9 || i5 == 10 || i5 == 12 || i5 == 13 || i5 == 32) {
            return false;
        }
        if (i5 != 35) {
            if (i5 == 44) {
                return false;
            }
            if (i5 != 47 && i5 != 61) {
                if (i5 == 123 || i5 == 125 || i5 == 58) {
                    return false;
                }
                if (i5 != 59) {
                    switch (i5) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        T();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f14524i.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        T();
        r0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f14523h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        T();
        r3 = r6.f14524i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f14524i.readByte();
        r6.f14524i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (p0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw S("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f14524i.readByte();
        r6.f14524i.readByte();
        r0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int e0(boolean z5) {
        while (true) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (!this.f14523h.request(i6)) {
                    if (z5) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b5 = this.f14524i.getByte(i5);
                if (b5 != 10 && b5 != 32 && b5 != 13 && b5 != 9) {
                    break;
                }
                i5 = i6;
            }
        }
    }

    private String f0(ByteString byteString) {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f14523h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw S("Unterminated string");
            }
            if (this.f14524i.getByte(indexOfElement) != 92) {
                if (sb == null) {
                    String readUtf8 = this.f14524i.readUtf8(indexOfElement);
                    this.f14524i.readByte();
                    return readUtf8;
                }
                sb.append(this.f14524i.readUtf8(indexOfElement));
                this.f14524i.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f14524i.readUtf8(indexOfElement));
            this.f14524i.readByte();
            sb.append(l0());
        }
    }

    private String g0() {
        long indexOfElement = this.f14523h.indexOfElement(f14520p);
        return indexOfElement != -1 ? this.f14524i.readUtf8(indexOfElement) : this.f14524i.readUtf8();
    }

    private int h0() {
        String str;
        String str2;
        int i5;
        byte b5 = this.f14524i.getByte(0L);
        if (b5 == 116 || b5 == 84) {
            str = "true";
            str2 = "TRUE";
            i5 = 5;
        } else if (b5 == 102 || b5 == 70) {
            str = "false";
            str2 = "FALSE";
            i5 = 6;
        } else {
            if (b5 != 110 && b5 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i5 = 7;
        }
        int length = str.length();
        int i6 = 1;
        while (i6 < length) {
            int i7 = i6 + 1;
            if (!this.f14523h.request(i7)) {
                return 0;
            }
            char c5 = this.f14524i.getByte(i6);
            if (c5 != str.charAt(i6) && c5 != str2.charAt(i6)) {
                return 0;
            }
            i6 = i7;
        }
        if (this.f14523h.request(length + 1) && d0(this.f14524i.getByte(length))) {
            return 0;
        }
        this.f14524i.skip(length);
        this.f14525j = i5;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (d0(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f14526k = r8;
        r16.f14524i.skip(r5);
        r16.f14525j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f14527l = r5;
        r16.f14525j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int j0() {
        char c5;
        boolean z5 = true;
        long j5 = 0;
        int i5 = 0;
        char c6 = 0;
        boolean z6 = false;
        boolean z7 = true;
        while (true) {
            int i6 = i5 + 1;
            if (!this.f14523h.request(i6)) {
                break;
            }
            byte b5 = this.f14524i.getByte(i5);
            if (b5 != 43) {
                if (b5 == 69 || b5 == 101) {
                    if (c6 != 2 && c6 != 4) {
                        return 0;
                    }
                    c6 = 5;
                } else if (b5 == 45) {
                    c5 = 6;
                    if (c6 == 0) {
                        c6 = 1;
                        z6 = true;
                    } else if (c6 != 5) {
                        return 0;
                    }
                } else if (b5 != 46) {
                    if (b5 < 48 || b5 > 57) {
                        break;
                    }
                    if (c6 == z5 || c6 == 0) {
                        j5 = -(b5 - 48);
                        c6 = 2;
                    } else if (c6 == 2) {
                        if (j5 == 0) {
                            return 0;
                        }
                        long j6 = (10 * j5) - (b5 - 48);
                        z7 &= j5 > -922337203685477580L || (j5 == -922337203685477580L && j6 < j5);
                        j5 = j6;
                    } else if (c6 == 3) {
                        c6 = 4;
                    } else if (c6 == 5 || c6 == 6) {
                        c6 = 7;
                    }
                } else {
                    if (c6 != 2) {
                        return 0;
                    }
                    c6 = 3;
                }
                i5 = i6;
                z5 = true;
            } else {
                c5 = 6;
                if (c6 != 5) {
                    return 0;
                }
            }
            c6 = c5;
            i5 = i6;
            z5 = true;
        }
    }

    private char l0() {
        int i5;
        if (!this.f14523h.request(1L)) {
            throw S("Unterminated escape sequence");
        }
        byte readByte = this.f14524i.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (((JsonReader) this).e) {
                return (char) readByte;
            }
            throw S("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.f14523h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            byte b5 = this.f14524i.getByte(i6);
            char c6 = (char) (c5 << 4);
            if (b5 >= 48 && b5 <= 57) {
                i5 = b5 - 48;
            } else if (b5 >= 97 && b5 <= 102) {
                i5 = b5 - 87;
            } else {
                if (b5 < 65 || b5 > 70) {
                    throw S("\\u" + this.f14524i.readUtf8(4L));
                }
                i5 = b5 - 55;
            }
            c5 = (char) (c6 + i5);
        }
        this.f14524i.skip(4L);
        return c5;
    }

    private void o0(ByteString byteString) {
        while (true) {
            long indexOfElement = this.f14523h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw S("Unterminated string");
            }
            if (this.f14524i.getByte(indexOfElement) != 92) {
                this.f14524i.skip(indexOfElement + 1);
                return;
            } else {
                this.f14524i.skip(indexOfElement + 1);
                l0();
            }
        }
    }

    private boolean p0() {
        long indexOf = this.f14523h.indexOf(f14522r);
        boolean z5 = indexOf != -1;
        Buffer buffer = this.f14524i;
        buffer.skip(z5 ? indexOf + r1.size() : buffer.size());
        return z5;
    }

    private void r0() {
        long indexOfElement = this.f14523h.indexOfElement(f14521q);
        Buffer buffer = this.f14524i;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private void s0() {
        long indexOfElement = this.f14523h.indexOfElement(f14520p);
        Buffer buffer = this.f14524i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public void close() {
        this.f14525j = 0;
        ((JsonReader) this).b[0] = 8;
        ((JsonReader) this).a = 1;
        this.f14524i.clear();
        this.f14523h.close();
    }

    public void d() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 3) {
            u(1);
            ((JsonReader) this).d[((JsonReader) this).a - 1] = 0;
            this.f14525j = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + t() + " at path " + getPath());
        }
    }

    public void h() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 1) {
            u(3);
            this.f14525j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + t() + " at path " + getPath());
    }

    public void k() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + t() + " at path " + getPath());
        }
        int i6 = ((JsonReader) this).a;
        ((JsonReader) this).a = i6 - 1;
        int[] iArr = ((JsonReader) this).d;
        int i7 = i6 - 2;
        iArr[i7] = iArr[i7] + 1;
        this.f14525j = 0;
    }

    public void l() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + t() + " at path " + getPath());
        }
        int i6 = ((JsonReader) this).a;
        int i7 = i6 - 1;
        ((JsonReader) this).a = i7;
        ((JsonReader) this).c[i7] = null;
        int[] iArr = ((JsonReader) this).d;
        int i8 = i6 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.f14525j = 0;
    }

    public boolean m() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        return (i5 == 2 || i5 == 4 || i5 == 18) ? false : true;
    }

    public boolean n() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 5) {
            this.f14525j = 0;
            int[] iArr = ((JsonReader) this).d;
            int i6 = ((JsonReader) this).a - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        }
        if (i5 == 6) {
            this.f14525j = 0;
            int[] iArr2 = ((JsonReader) this).d;
            int i7 = ((JsonReader) this).a - 1;
            iArr2[i7] = iArr2[i7] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + t() + " at path " + getPath());
    }

    public double o() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 16) {
            this.f14525j = 0;
            int[] iArr = ((JsonReader) this).d;
            int i6 = ((JsonReader) this).a - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f14526k;
        }
        if (i5 == 17) {
            this.f14528m = this.f14524i.readUtf8(this.f14527l);
        } else if (i5 == 9) {
            this.f14528m = f0(f14519o);
        } else if (i5 == 8) {
            this.f14528m = f0(f14518n);
        } else if (i5 == 10) {
            this.f14528m = g0();
        } else if (i5 != 11) {
            throw new JsonDataException("Expected a double but was " + t() + " at path " + getPath());
        }
        this.f14525j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f14528m);
            if (((JsonReader) this).e || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.f14528m = null;
                this.f14525j = 0;
                int[] iArr2 = ((JsonReader) this).d;
                int i7 = ((JsonReader) this).a - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f14528m + " at path " + getPath());
        }
    }

    public int p() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 16) {
            long j5 = this.f14526k;
            int i6 = (int) j5;
            if (j5 == i6) {
                this.f14525j = 0;
                int[] iArr = ((JsonReader) this).d;
                int i7 = ((JsonReader) this).a - 1;
                iArr[i7] = iArr[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.f14526k + " at path " + getPath());
        }
        if (i5 == 17) {
            this.f14528m = this.f14524i.readUtf8(this.f14527l);
        } else if (i5 == 9 || i5 == 8) {
            String f02 = i5 == 9 ? f0(f14519o) : f0(f14518n);
            this.f14528m = f02;
            try {
                int parseInt = Integer.parseInt(f02);
                this.f14525j = 0;
                int[] iArr2 = ((JsonReader) this).d;
                int i8 = ((JsonReader) this).a - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i5 != 11) {
            throw new JsonDataException("Expected an int but was " + t() + " at path " + getPath());
        }
        this.f14525j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f14528m);
            int i9 = (int) parseDouble;
            if (i9 == parseDouble) {
                this.f14528m = null;
                this.f14525j = 0;
                int[] iArr3 = ((JsonReader) this).d;
                int i10 = ((JsonReader) this).a - 1;
                iArr3[i10] = iArr3[i10] + 1;
                return i9;
            }
            throw new JsonDataException("Expected an int but was " + this.f14528m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f14528m + " at path " + getPath());
        }
    }

    public String q() {
        String str;
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 14) {
            str = g0();
        } else if (i5 == 13) {
            str = f0(f14519o);
        } else if (i5 == 12) {
            str = f0(f14518n);
        } else {
            if (i5 != 15) {
                throw new JsonDataException("Expected a name but was " + t() + " at path " + getPath());
            }
            str = this.f14528m;
        }
        this.f14525j = 0;
        ((JsonReader) this).c[((JsonReader) this).a - 1] = str;
        return str;
    }

    public String r() {
        String readUtf8;
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 10) {
            readUtf8 = g0();
        } else if (i5 == 9) {
            readUtf8 = f0(f14519o);
        } else if (i5 == 8) {
            readUtf8 = f0(f14518n);
        } else if (i5 == 11) {
            readUtf8 = this.f14528m;
            this.f14528m = null;
        } else if (i5 == 16) {
            readUtf8 = Long.toString(this.f14526k);
        } else {
            if (i5 != 17) {
                throw new JsonDataException("Expected a string but was " + t() + " at path " + getPath());
            }
            readUtf8 = this.f14524i.readUtf8(this.f14527l);
        }
        this.f14525j = 0;
        int[] iArr = ((JsonReader) this).d;
        int i6 = ((JsonReader) this).a - 1;
        iArr[i6] = iArr[i6] + 1;
        return readUtf8;
    }

    public JsonReader.Token t() {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        switch (i5) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.f14523h + ")";
    }

    public int v(JsonReader$a jsonReader$a) {
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 < 12 || i5 > 15) {
            return -1;
        }
        if (i5 == 15) {
            return X(this.f14528m, jsonReader$a);
        }
        int select = this.f14523h.select(jsonReader$a.f14517b);
        if (select != -1) {
            this.f14525j = 0;
            ((JsonReader) this).c[((JsonReader) this).a - 1] = jsonReader$a.f14516a[select];
            return select;
        }
        String str = ((JsonReader) this).c[((JsonReader) this).a - 1];
        String q5 = q();
        int X = X(q5, jsonReader$a);
        if (X == -1) {
            this.f14525j = 15;
            this.f14528m = q5;
            ((JsonReader) this).c[((JsonReader) this).a - 1] = str;
        }
        return X;
    }

    public void w() {
        if (((JsonReader) this).f) {
            throw new JsonDataException("Cannot skip unexpected " + t() + " at " + getPath());
        }
        int i5 = this.f14525j;
        if (i5 == 0) {
            i5 = W();
        }
        if (i5 == 14) {
            s0();
        } else if (i5 == 13) {
            o0(f14519o);
        } else if (i5 == 12) {
            o0(f14518n);
        } else if (i5 != 15) {
            throw new JsonDataException("Expected a name but was " + t() + " at path " + getPath());
        }
        this.f14525j = 0;
        ((JsonReader) this).c[((JsonReader) this).a - 1] = "null";
    }

    public void x() {
        if (((JsonReader) this).f) {
            throw new JsonDataException("Cannot skip unexpected " + t() + " at " + getPath());
        }
        int i5 = 0;
        do {
            int i6 = this.f14525j;
            if (i6 == 0) {
                i6 = W();
            }
            if (i6 == 3) {
                u(1);
            } else if (i6 == 1) {
                u(3);
            } else {
                if (i6 == 4) {
                    i5--;
                    if (i5 < 0) {
                        throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                    }
                    ((JsonReader) this).a--;
                } else if (i6 == 2) {
                    i5--;
                    if (i5 < 0) {
                        throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                    }
                    ((JsonReader) this).a--;
                } else if (i6 == 14 || i6 == 10) {
                    s0();
                } else if (i6 == 9 || i6 == 13) {
                    o0(f14519o);
                } else if (i6 == 8 || i6 == 12) {
                    o0(f14518n);
                } else if (i6 == 17) {
                    this.f14524i.skip(this.f14527l);
                } else if (i6 == 18) {
                    throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                }
                this.f14525j = 0;
            }
            i5++;
            this.f14525j = 0;
        } while (i5 != 0);
        int[] iArr = ((JsonReader) this).d;
        int i7 = ((JsonReader) this).a;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        ((JsonReader) this).c[i7 - 1] = "null";
    }
}
