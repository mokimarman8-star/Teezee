package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.apache.tools.zip.UnixStat;
import org.jsoup.UncheckedIOException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final char[] a;
    private final Reader b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final String[] h;

    public a(Reader reader) {
        this(reader, UnixStat.FILE_FLAG);
    }

    public a(Reader reader, int i) {
        this.h = new String[512];
        org.jsoup.helper.d.j(reader);
        org.jsoup.helper.d.d(reader.markSupported());
        this.b = reader;
        this.a = new char[i > 32768 ? 32768 : i];
        b();
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }

    static boolean G(char[] cArr, int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i5;
            i2 = i4;
            i3 = i6;
        }
    }

    private void b() {
        int i = this.e;
        if (i < this.d) {
            return;
        }
        try {
            this.b.skip(i);
            this.b.mark(UnixStat.FILE_FLAG);
            int read = this.b.read(this.a);
            this.b.reset();
            if (read != -1) {
                this.c = read;
                this.f += this.e;
                this.e = 0;
                this.g = 0;
                if (read > 24576) {
                    read = 24576;
                }
                this.d = read;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static String c(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            i5 = (i5 * 31) + cArr[i4];
            i3++;
            i4++;
        }
        int length = i5 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i, i2);
            strArr[length] = str2;
            return str2;
        }
        if (G(cArr, i, i2, str)) {
            return str;
        }
        String str3 = new String(cArr, i, i2);
        strArr[length] = str3;
        return str3;
    }

    private boolean s() {
        return this.e >= this.c;
    }

    boolean A() {
        char c;
        return !r() && (c = this.a[this.e]) >= '0' && c <= '9';
    }

    boolean B(String str) {
        b();
        int length = str.length();
        if (length > this.c - this.e) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.a[this.e + i])) {
                return false;
            }
        }
        return true;
    }

    boolean C() {
        if (r()) {
            return false;
        }
        char c = this.a[this.e];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    int D(char c) {
        b();
        for (int i = this.e; i < this.c; i++) {
            if (c == this.a[i]) {
                return i - this.e;
            }
        }
        return -1;
    }

    int E(CharSequence charSequence) {
        b();
        char charAt = charSequence.charAt(0);
        int i = this.e;
        while (i < this.c) {
            if (charAt != this.a[i]) {
                do {
                    i++;
                    if (i >= this.c) {
                        break;
                    }
                } while (charAt != this.a[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i3 = this.c;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && charSequence.charAt(i5) == this.a[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.e;
                }
            }
            i = i2;
        }
        return -1;
    }

    public int F() {
        return this.f + this.e;
    }

    void H() {
        this.e = this.g;
    }

    void I() {
        this.e--;
    }

    public void a() {
        this.e++;
    }

    char d() {
        b();
        char c = s() ? (char) 65535 : this.a[this.e];
        this.e++;
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return c(r6.a, r6.h, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String e() {
        char c;
        b();
        int i = this.e;
        int i2 = this.c;
        char[] cArr = this.a;
        while (true) {
            int i3 = this.e;
            if (i3 >= i2 || (c = cArr[i3]) == '&' || c == '<' || c == 0) {
                break;
            }
            this.e = i3 + 1;
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    String f() {
        int i;
        char c;
        b();
        int i2 = this.e;
        while (true) {
            i = this.e;
            if (i >= this.c || (c = this.a[i]) < '0' || c > '9') {
                break;
            }
            this.e = i + 1;
        }
        return c(this.a, this.h, i2, i - i2);
    }

    String g() {
        int i;
        char c;
        b();
        int i2 = this.e;
        while (true) {
            i = this.e;
            if (i >= this.c || (((c = this.a[i]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.e = i + 1;
        }
        return c(this.a, this.h, i2, i - i2);
    }

    String h() {
        char c;
        b();
        int i = this.e;
        while (true) {
            int i2 = this.e;
            if (i2 >= this.c || (((c = this.a[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.e++;
        }
        return c(this.a, this.h, i, this.e - i);
    }

    String i() {
        char c;
        b();
        int i = this.e;
        while (true) {
            int i2 = this.e;
            if (i2 >= this.c || (((c = this.a[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.e++;
        }
        while (!s()) {
            char[] cArr = this.a;
            int i3 = this.e;
            char c2 = cArr[i3];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.e = i3 + 1;
        }
        return c(this.a, this.h, i, this.e - i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return c(r6.a, r6.h, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String j() {
        char c;
        b();
        int i = this.e;
        int i2 = this.c;
        char[] cArr = this.a;
        while (true) {
            int i3 = this.e;
            if (i3 >= i2 || (c = cArr[i3]) == '\t' || c == '\n' || c == '\r' || c == '\f' || c == ' ' || c == '/' || c == '>' || c == 0) {
                break;
            }
            this.e = i3 + 1;
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public String k(char c) {
        int D = D(c);
        if (D == -1) {
            return o();
        }
        String c2 = c(this.a, this.h, this.e, D);
        this.e += D;
        return c2;
    }

    String l(String str) {
        int E = E(str);
        if (E == -1) {
            return o();
        }
        String c = c(this.a, this.h, this.e, E);
        this.e += E;
        return c;
    }

    public String m(char... cArr) {
        b();
        int i = this.e;
        int i2 = this.c;
        char[] cArr2 = this.a;
        loop0: while (this.e < i2) {
            for (char c : cArr) {
                if (cArr2[this.e] == c) {
                    break loop0;
                }
            }
            this.e++;
        }
        int i3 = this.e;
        return i3 > i ? c(this.a, this.h, i, i3 - i) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    String n(char... cArr) {
        b();
        int i = this.e;
        int i2 = this.c;
        char[] cArr2 = this.a;
        while (true) {
            int i3 = this.e;
            if (i3 >= i2 || Arrays.binarySearch(cArr, cArr2[i3]) >= 0) {
                break;
            }
            this.e++;
        }
        int i4 = this.e;
        return i4 > i ? c(this.a, this.h, i, i4 - i) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    String o() {
        b();
        char[] cArr = this.a;
        String[] strArr = this.h;
        int i = this.e;
        String c = c(cArr, strArr, i, this.c - i);
        this.e = this.c;
        return c;
    }

    boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        b();
        if (s()) {
            return (char) 65535;
        }
        return this.a[this.e];
    }

    public boolean r() {
        b();
        return this.e >= this.c;
    }

    void t() {
        this.g = this.e;
    }

    public String toString() {
        char[] cArr = this.a;
        int i = this.e;
        return new String(cArr, i, this.c - i);
    }

    boolean u(String str) {
        b();
        if (!x(str)) {
            return false;
        }
        this.e += str.length();
        return true;
    }

    boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.e += str.length();
        return true;
    }

    boolean w(char c) {
        return !r() && this.a[this.e] == c;
    }

    boolean x(String str) {
        b();
        int length = str.length();
        if (length > this.c - this.e) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.a[this.e + i]) {
                return false;
            }
        }
        return true;
    }

    boolean y(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c = this.a[this.e];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    boolean z(char[] cArr) {
        b();
        return !r() && Arrays.binarySearch(cArr, this.a[this.e]) >= 0;
    }
}
