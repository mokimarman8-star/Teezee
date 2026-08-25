package com.mbridge.msdk.thrid.okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f implements Serializable, Comparable<f> {
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f e = a(new byte[0]);
    final byte[] a;
    transient int b;
    transient String c;

    f(byte[] bArr) {
        this.a = bArr;
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.a));
        fVar.c = str;
        return fVar;
    }

    public byte a(int i) {
        return this.a[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int e2 = e();
        int e3 = fVar.e();
        int min = Math.min(e2, e3);
        for (int i = 0; i < min; i++) {
            int a = a(i) & 255;
            int a2 = fVar.a(i) & 255;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            }
        }
        if (e2 == e3) {
            return 0;
        }
        return e2 < e3 ? -1 : 1;
    }

    public f a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.a;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.a.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new f(bArr2);
    }

    public String a() {
        return b.a(this.a);
    }

    void a(c cVar) {
        byte[] bArr = this.a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.a, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && u.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        byte[] bArr = this.a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.e());
    }

    public f c() {
        return b("SHA-1");
    }

    public f d() {
        return b("SHA-256");
    }

    public int e() {
        return this.a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int e2 = fVar.e();
            byte[] bArr = this.a;
            if (e2 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public byte[] g() {
        return (byte[]) this.a.clone();
    }

    public String h() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.a, u.a);
        this.c = str2;
        return str2;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.a);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb2;
        if (this.a.length == 0) {
            return "[size=0]";
        }
        String h = h();
        int a = a(h, 64);
        if (a == -1) {
            if (this.a.length <= 64) {
                return "[hex=" + b() + "]";
            }
            return "[size=" + this.a.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = h.substring(0, a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a < h.length()) {
            sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(this.a.length);
            sb2.append(" text=");
            sb2.append(replace);
            sb2.append("…]");
        } else {
            sb2 = new StringBuilder();
            sb2.append("[text=");
            sb2.append(replace);
            sb2.append("]");
        }
        return sb2.toString();
    }
}
