package org.jsoup.parser;

import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class g {
    private String a;
    private int b = 0;

    public g(String str) {
        org.jsoup.helper.d.j(str);
        this.a = str;
    }

    private int r() {
        return this.a.length() - this.b;
    }

    public static String s(String str) {
        StringBuilder o = org.jsoup.helper.c.o();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                o.append(c2);
            } else if (c != 0 && c == '\\') {
                o.append(c2);
            }
            i++;
            c = c2;
        }
        return o.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[EDGE_INSN: B:14:0x006c->B:15:0x006c BREAK  A[LOOP:0: B:2:0x0007->B:22:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:2:0x0007->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(char c, char c2) {
        char c3 = 0;
        int i = -1;
        int i2 = -1;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        while (!j()) {
            char c4 = c();
            Character valueOf = Character.valueOf(c4);
            if (c3 == 0 || c3 != '\\') {
                if (valueOf.equals('\'') && c4 != c && !z) {
                    z2 = !z2;
                } else if (valueOf.equals('\"') && c4 != c && !z2) {
                    z = !z;
                }
                if (!z2 && !z) {
                    if (valueOf.equals(Character.valueOf(c))) {
                        i3++;
                        if (i == -1) {
                            i = this.b;
                        }
                    } else if (valueOf.equals(Character.valueOf(c2))) {
                        i3--;
                    }
                }
                if (i3 > 0) {
                    break;
                }
            }
            if (i3 > 0 && c3 != 0) {
                i2 = this.b;
            }
            c3 = c4;
            if (i3 > 0) {
            }
        }
        String substring = i2 >= 0 ? this.a.substring(i, i2) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (i3 > 0) {
            org.jsoup.helper.d.a("Did not find balanced marker at '" + substring + "'");
        }
        return substring;
    }

    public String b(String str) {
        String g = g(str);
        k(str);
        return g;
    }

    public char c() {
        String str = this.a;
        int i = this.b;
        this.b = i + 1;
        return str.charAt(i);
    }

    public void d(String str) {
        if (!l(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > r()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.b += length;
    }

    public String e() {
        int i = this.b;
        while (!j() && (p() || m('-', '_'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String f() {
        int i = this.b;
        while (!j() && (p() || n("*|", "|", "_", "-"))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String g(String str) {
        int indexOf = this.a.indexOf(str, this.b);
        if (indexOf == -1) {
            return q();
        }
        String substring = this.a.substring(this.b, indexOf);
        this.b += substring.length();
        return substring;
    }

    public String h(String... strArr) {
        int i = this.b;
        while (!j() && !n(strArr)) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public boolean i() {
        boolean z = false;
        while (o()) {
            this.b++;
            z = true;
        }
        return z;
    }

    public boolean j() {
        return r() == 0;
    }

    public boolean k(String str) {
        if (!l(str)) {
            return false;
        }
        this.b += str.length();
        return true;
    }

    public boolean l(String str) {
        return this.a.regionMatches(true, this.b, str, 0, str.length());
    }

    public boolean m(char... cArr) {
        if (j()) {
            return false;
        }
        for (char c : cArr) {
            if (this.a.charAt(this.b) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean n(String... strArr) {
        for (String str : strArr) {
            if (l(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return !j() && org.jsoup.helper.c.h(this.a.charAt(this.b));
    }

    public boolean p() {
        return !j() && Character.isLetterOrDigit(this.a.charAt(this.b));
    }

    public String q() {
        String str = this.a;
        String substring = str.substring(this.b, str.length());
        this.b = this.a.length();
        return substring;
    }

    public String toString() {
        return this.a.substring(this.b);
    }
}
