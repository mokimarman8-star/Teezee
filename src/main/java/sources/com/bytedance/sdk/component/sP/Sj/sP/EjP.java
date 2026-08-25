package com.bytedance.sdk.component.sP.Sj.sP;

import com.bumptech.glide.load.Key;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP implements Serializable, Comparable<EjP> {
    final byte[] EjP;
    transient int HiB;
    transient String vS;
    static final char[] Sj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset sP = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final EjP TKC = Sj(new byte[0]);

    EjP(byte[] bArr) {
        this.EjP = bArr;
    }

    static int Sj(String str, int i) {
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

    public static EjP Sj(byte... bArr) {
        if (bArr != null) {
            return new EjP((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public byte[] EjP() {
        return (byte[]) this.EjP.clone();
    }

    public byte Sj(int i) {
        return this.EjP[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public int compareTo(EjP ejP) {
        int TKC2 = TKC();
        int TKC3 = ejP.TKC();
        int min = Math.min(TKC2, TKC3);
        for (int i = 0; i < min; i++) {
            int Sj2 = Sj(i) & 255;
            int Sj3 = ejP.Sj(i) & 255;
            if (Sj2 != Sj3) {
                return Sj2 < Sj3 ? -1 : 1;
            }
        }
        if (TKC2 == TKC3) {
            return 0;
        }
        return TKC2 < TKC3 ? -1 : 1;
    }

    public EjP Sj(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.EjP;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.EjP.length + ")");
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
        return new EjP(bArr2);
    }

    public String Sj() {
        String str = this.vS;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.EjP, sP);
        this.vS = str2;
        return str2;
    }

    public boolean Sj(int i, EjP ejP, int i2, int i3) {
        return ejP.Sj(i2, this.EjP, i, i3);
    }

    public boolean Sj(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.EjP;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && uA.Sj(bArr2, i, bArr, i2, i3);
    }

    public int TKC() {
        return this.EjP.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EjP) {
            EjP ejP = (EjP) obj;
            int TKC2 = ejP.TKC();
            byte[] bArr = this.EjP;
            if (TKC2 == bArr.length && ejP.Sj(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.HiB;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.EjP);
        this.HiB = hashCode;
        return hashCode;
    }

    public String sP() {
        byte[] bArr = this.EjP;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = Sj;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public String toString() {
        if (this.EjP.length == 0) {
            return "[size=0]";
        }
        String Sj2 = Sj();
        int Sj3 = Sj(Sj2, 64);
        if (Sj3 == -1) {
            if (this.EjP.length <= 64) {
                return "[hex=" + sP() + "]";
            }
            return "[size=" + this.EjP.length + " hex=" + Sj(0, 64).sP() + "…]";
        }
        String replace = Sj2.substring(0, Sj3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (Sj3 >= Sj2.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.EjP.length + " text=" + replace + "…]";
    }
}
