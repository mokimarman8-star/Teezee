package androidx.media3.common.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j0 {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f9071d = {'\r', '\n'};

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f9072e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f9073f = ImmutableSet.of(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f9074a;

    /* renamed from: b, reason: collision with root package name */
    private int f9075b;

    /* renamed from: c, reason: collision with root package name */
    private int f9076c;

    public j0() {
        this.f9074a = a1.f9031f;
    }

    public j0(int i5) {
        this.f9074a = new byte[i5];
        this.f9076c = i5;
    }

    public j0(byte[] bArr) {
        this.f9074a = bArr;
        this.f9076c = bArr.length;
    }

    public j0(byte[] bArr, int i5) {
        this.f9074a = bArr;
        this.f9076c = i5;
    }

    private void Y(Charset charset) {
        if (m(charset, f9071d) == '\r') {
            m(charset, f9072e);
        }
    }

    private int d(Charset charset) {
        int i5;
        if (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) {
            i5 = 1;
        } else {
            if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i5 = 2;
        }
        int i6 = this.f9075b;
        while (true) {
            int i7 = this.f9076c;
            if (i6 >= i7 - (i5 - 1)) {
                return i7;
            }
            if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && a1.I0(this.f9074a[i6])) {
                return i6;
            }
            if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                byte[] bArr = this.f9074a;
                if (bArr[i6] == 0 && a1.I0(bArr[i6 + 1])) {
                    return i6;
                }
            }
            if (charset.equals(StandardCharsets.UTF_16LE)) {
                byte[] bArr2 = this.f9074a;
                if (bArr2[i6 + 1] == 0 && a1.I0(bArr2[i6])) {
                    return i6;
                }
            }
            i6 += i5;
        }
    }

    private int i(Charset charset) {
        byte b5;
        byte b6;
        byte b7 = 1;
        if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && a() >= 1) {
            b5 = this.f9074a[this.f9075b];
            b6 = 0;
        } else {
            if ((charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) && a() >= 2) {
                byte[] bArr = this.f9074a;
                int i5 = this.f9075b;
                b6 = bArr[i5];
                b5 = bArr[i5 + 1];
            } else {
                if (!charset.equals(StandardCharsets.UTF_16LE) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f9074a;
                int i6 = this.f9075b;
                b6 = bArr2[i6 + 1];
                b5 = bArr2[i6];
            }
            b7 = 2;
        }
        return Ints.h(b6, b5, (byte) 0, b7);
    }

    private char m(Charset charset, char[] cArr) {
        int i5 = i(charset);
        if (i5 == 0) {
            return (char) 0;
        }
        char c5 = (char) (i5 >> 16);
        if (!Chars.a(cArr, c5)) {
            return (char) 0;
        }
        this.f9075b += i5 & 65535;
        return c5;
    }

    public long A() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        this.f9075b = i5 + 1;
        this.f9075b = i5 + 2;
        this.f9075b = i5 + 3;
        long j5 = ((bArr[i5] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.f9075b = i5 + 4;
        long j6 = j5 | ((bArr[r4] & 255) << 32);
        this.f9075b = i5 + 5;
        long j7 = j6 | ((bArr[r7] & 255) << 24);
        this.f9075b = i5 + 6;
        long j8 = j7 | ((bArr[r4] & 255) << 16);
        this.f9075b = i5 + 7;
        long j9 = j8 | ((bArr[r7] & 255) << 8);
        this.f9075b = i5 + 8;
        return (bArr[r4] & 255) | j9;
    }

    public String B() {
        return n((char) 0);
    }

    public String C(int i5) {
        if (i5 == 0) {
            return "";
        }
        int i6 = this.f9075b;
        int i7 = (i6 + i5) - 1;
        String I = a1.I(this.f9074a, i6, (i7 >= this.f9076c || this.f9074a[i7] != 0) ? i5 : i5 - 1);
        this.f9075b += i5;
        return I;
    }

    public short D() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.f9075b = i5 + 2;
        return (short) ((bArr[i6] & 255) | i7);
    }

    public String E(int i5) {
        return F(i5, StandardCharsets.UTF_8);
    }

    public String F(int i5, Charset charset) {
        String str = new String(this.f9074a, this.f9075b, i5, charset);
        this.f9075b += i5;
        return str;
    }

    public int G() {
        return (H() << 21) | (H() << 14) | (H() << 7) | H();
    }

    public int H() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        this.f9075b = i5 + 1;
        return bArr[i5] & 255;
    }

    public int I() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.f9075b = i5 + 2;
        int i8 = (bArr[i6] & 255) | i7;
        this.f9075b = i5 + 4;
        return i8;
    }

    public long J() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        this.f9075b = i5 + 1;
        this.f9075b = i5 + 2;
        this.f9075b = i5 + 3;
        long j5 = ((bArr[i5] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.f9075b = i5 + 4;
        return (bArr[r4] & 255) | j5;
    }

    public int K() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = (bArr[i5] & 255) << 16;
        int i8 = i5 + 2;
        this.f9075b = i8;
        int i9 = ((bArr[i6] & 255) << 8) | i7;
        this.f9075b = i5 + 3;
        return (bArr[i8] & 255) | i9;
    }

    public int L() {
        int q5 = q();
        if (q5 >= 0) {
            return q5;
        }
        throw new IllegalStateException("Top bit not zero: " + q5);
    }

    public int M() {
        return Ints.d(N());
    }

    public long N() {
        long j5 = 0;
        for (int i5 = 0; i5 < 9; i5++) {
            if (this.f9075b == this.f9076c) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long H = H();
            j5 |= (127 & H) << (i5 * 7);
            if ((H & 128) == 0) {
                break;
            }
        }
        return j5;
    }

    public long O() {
        long A = A();
        if (A >= 0) {
            return A;
        }
        throw new IllegalStateException("Top bit not zero: " + A);
    }

    public int P() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.f9075b = i5 + 2;
        return (bArr[i6] & 255) | i7;
    }

    public long Q() {
        int i5;
        int i6;
        long j5 = this.f9074a[this.f9075b];
        int i7 = 7;
        while (true) {
            if (i7 < 0) {
                break;
            }
            if (((1 << i7) & j5) != 0) {
                i7--;
            } else if (i7 < 6) {
                j5 &= r6 - 1;
                i6 = 7 - i7;
            } else if (i7 == 7) {
                i6 = 1;
            }
        }
        i6 = 0;
        if (i6 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j5);
        }
        for (i5 = 1; i5 < i6; i5++) {
            if ((this.f9074a[this.f9075b + i5] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j5);
            }
            j5 = (j5 << 6) | (r3 & 63);
        }
        this.f9075b += i6;
        return j5;
    }

    public Charset R() {
        if (a() >= 3) {
            byte[] bArr = this.f9074a;
            int i5 = this.f9075b;
            if (bArr[i5] == -17 && bArr[i5 + 1] == -69 && bArr[i5 + 2] == -65) {
                this.f9075b = i5 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f9074a;
        int i6 = this.f9075b;
        byte b5 = bArr2[i6];
        if (b5 == -2 && bArr2[i6 + 1] == -1) {
            this.f9075b = i6 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b5 != -1 || bArr2[i6 + 1] != -2) {
            return null;
        }
        this.f9075b = i6 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public void S(int i5) {
        U(b() < i5 ? new byte[i5] : this.f9074a, i5);
    }

    public void T(byte[] bArr) {
        U(bArr, bArr.length);
    }

    public void U(byte[] bArr, int i5) {
        this.f9074a = bArr;
        this.f9076c = i5;
        this.f9075b = 0;
    }

    public void V(int i5) {
        a.a(i5 >= 0 && i5 <= this.f9074a.length);
        this.f9076c = i5;
    }

    public void W(int i5) {
        a.a(i5 >= 0 && i5 <= this.f9076c);
        this.f9075b = i5;
    }

    public void X(int i5) {
        W(this.f9075b + i5);
    }

    public int a() {
        return this.f9076c - this.f9075b;
    }

    public int b() {
        return this.f9074a.length;
    }

    public void c(int i5) {
        if (i5 > b()) {
            this.f9074a = Arrays.copyOf(this.f9074a, i5);
        }
    }

    public byte[] e() {
        return this.f9074a;
    }

    public int f() {
        return this.f9075b;
    }

    public int g() {
        return this.f9076c;
    }

    public char h(Charset charset) {
        a.b(f9073f.contains(charset), "Unsupported charset: " + charset);
        return (char) (i(charset) >> 16);
    }

    public int j() {
        return this.f9074a[this.f9075b] & 255;
    }

    public void k(i0 i0Var, int i5) {
        l(i0Var.f9064a, 0, i5);
        i0Var.p(0);
    }

    public void l(byte[] bArr, int i5, int i6) {
        System.arraycopy(this.f9074a, this.f9075b, bArr, i5, i6);
        this.f9075b += i6;
    }

    public String n(char c5) {
        if (a() == 0) {
            return null;
        }
        int i5 = this.f9075b;
        while (i5 < this.f9076c && this.f9074a[i5] != c5) {
            i5++;
        }
        byte[] bArr = this.f9074a;
        int i6 = this.f9075b;
        String I = a1.I(bArr, i6, i5 - i6);
        this.f9075b = i5;
        if (i5 < this.f9076c) {
            this.f9075b = i5 + 1;
        }
        return I;
    }

    public double o() {
        return Double.longBitsToDouble(A());
    }

    public float p() {
        return Float.intBitsToFloat(q());
    }

    public int q() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = (bArr[i5] & 255) << 24;
        int i8 = i5 + 2;
        this.f9075b = i8;
        int i9 = ((bArr[i6] & 255) << 16) | i7;
        int i10 = i5 + 3;
        this.f9075b = i10;
        int i11 = i9 | ((bArr[i8] & 255) << 8);
        this.f9075b = i5 + 4;
        return (bArr[i10] & 255) | i11;
    }

    public int r() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = ((bArr[i5] & 255) << 24) >> 8;
        int i8 = i5 + 2;
        this.f9075b = i8;
        int i9 = ((bArr[i6] & 255) << 8) | i7;
        this.f9075b = i5 + 3;
        return (bArr[i8] & 255) | i9;
    }

    public String s() {
        return t(StandardCharsets.UTF_8);
    }

    public String t(Charset charset) {
        a.b(f9073f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            R();
        }
        String F = F(d(charset) - this.f9075b, charset);
        if (this.f9075b == this.f9076c) {
            return F;
        }
        Y(charset);
        return F;
    }

    public int u() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = bArr[i5] & 255;
        int i8 = i5 + 2;
        this.f9075b = i8;
        int i9 = ((bArr[i6] & 255) << 8) | i7;
        int i10 = i5 + 3;
        this.f9075b = i10;
        int i11 = i9 | ((bArr[i8] & 255) << 16);
        this.f9075b = i5 + 4;
        return ((bArr[i10] & 255) << 24) | i11;
    }

    public long v() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        this.f9075b = i5 + 1;
        this.f9075b = i5 + 2;
        this.f9075b = i5 + 3;
        long j5 = (bArr[i5] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f9075b = i5 + 4;
        long j6 = j5 | ((bArr[r8] & 255) << 24);
        this.f9075b = i5 + 5;
        long j7 = j6 | ((bArr[r7] & 255) << 32);
        this.f9075b = i5 + 6;
        long j8 = j7 | ((bArr[r8] & 255) << 40);
        this.f9075b = i5 + 7;
        long j9 = j8 | ((bArr[r7] & 255) << 48);
        this.f9075b = i5 + 8;
        return ((bArr[r8] & 255) << 56) | j9;
    }

    public short w() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = bArr[i5] & 255;
        this.f9075b = i5 + 2;
        return (short) (((bArr[i6] & 255) << 8) | i7);
    }

    public long x() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        this.f9075b = i5 + 1;
        this.f9075b = i5 + 2;
        this.f9075b = i5 + 3;
        long j5 = (bArr[i5] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f9075b = i5 + 4;
        return ((bArr[r4] & 255) << 24) | j5;
    }

    public int y() {
        int u5 = u();
        if (u5 >= 0) {
            return u5;
        }
        throw new IllegalStateException("Top bit not zero: " + u5);
    }

    public int z() {
        byte[] bArr = this.f9074a;
        int i5 = this.f9075b;
        int i6 = i5 + 1;
        this.f9075b = i6;
        int i7 = bArr[i5] & 255;
        this.f9075b = i5 + 2;
        return ((bArr[i6] & 255) << 8) | i7;
    }
}
