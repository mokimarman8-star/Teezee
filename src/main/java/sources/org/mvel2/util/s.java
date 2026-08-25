package org.mvel2.util;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class s implements CharSequence {
    private char[] a;
    private int b;
    private int c;
    private byte[] d;
    private String e;

    public s() {
        this.c = 0;
        this.b = 15;
        this.a = new char[15];
    }

    public s(String str) {
        this.c = 0;
        char[] charArray = str.toCharArray();
        this.a = charArray;
        int length = charArray.length;
        this.c = length;
        this.b = length;
    }

    private void f(int i) {
        if (this.b == 0) {
            this.b = 15;
        }
        int i2 = this.b + (i * 2);
        this.b = i2;
        char[] cArr = new char[i2];
        System.arraycopy(this.a, 0, cArr, 0, this.c);
        this.a = cArr;
    }

    public s a(char c) {
        int i = this.c;
        if (i >= this.b) {
            f(i);
        }
        char[] cArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        cArr[i2] = c;
        return this;
    }

    public s b(CharSequence charSequence) {
        if (charSequence.length() > this.b - this.c) {
            f(charSequence.length());
        }
        for (int i = 0; i < charSequence.length(); i++) {
            this.a[this.c] = charSequence.charAt(i);
            this.c++;
        }
        return this;
    }

    public s c(Object obj) {
        return d(String.valueOf(obj));
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.a[i];
    }

    public s d(String str) {
        if (str == null) {
            return this;
        }
        int length = str.length();
        if (length > this.b - this.c) {
            f(length);
        }
        str.getChars(0, length, this.a, this.c);
        this.c += length;
        return this;
    }

    public s e(char[] cArr, int i, int i2) {
        if (i2 > this.b - this.c) {
            f(i2);
        }
        int i3 = i2 + i;
        while (i < i3) {
            char[] cArr2 = this.a;
            int i4 = this.c;
            this.c = i4 + 1;
            cArr2[i4] = cArr[i];
            i++;
        }
        return this;
    }

    public CharSequence g(int i, int i2) {
        return new String(this.a, i, i2 - i);
    }

    public char[] h() {
        String str;
        if (this.d == null) {
            int i = this.c;
            char[] cArr = new char[i];
            System.arraycopy(this.a, 0, cArr, 0, i);
            return cArr;
        }
        if (this.e == null) {
            this.e = System.getProperty("file.encoding");
        }
        try {
            str = new String(this.d, this.e);
        } catch (UnsupportedEncodingException unused) {
            str = new String(this.d);
        }
        return str.toCharArray();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return g(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.d == null) {
            int i = this.c;
            return i == this.b ? new String(this.a) : new String(this.a, 0, i);
        }
        if (this.e == null) {
            this.e = System.getProperty("file.encoding");
        }
        try {
            return new String(this.d, 0, this.c, this.e);
        } catch (UnsupportedEncodingException unused) {
            return new String(this.d, 0, this.c);
        }
    }
}
