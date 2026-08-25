package org.jsoup.parser;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Arrays;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class h {
    private static final char[] r;
    static final int[] s = {8364, Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
    private final a a;
    private final ParseErrorList b;
    private Token d;
    Token.i i;
    private String o;
    private TokeniserState c = TokeniserState.Data;
    private boolean e = false;
    private String f = null;
    private StringBuilder g = new StringBuilder(1024);
    StringBuilder h = new StringBuilder(1024);
    Token.h j = new Token.h();
    Token.g k = new Token.g();
    Token.c l = new Token.c();
    Token.e m = new Token.e();
    Token.d n = new Token.d();
    private final int[] p = new int[1];
    private final int[] q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        r = cArr;
        Arrays.sort(cArr);
    }

    h(a aVar, ParseErrorList parseErrorList) {
        this.a = aVar;
        this.b = parseErrorList;
    }

    private void c(String str) {
        if (this.b.canAddError()) {
            this.b.add(new c(this.a.F(), "Invalid character reference: %s", str));
        }
    }

    void a(TokeniserState tokeniserState) {
        this.a.a();
        this.c = tokeniserState;
    }

    String b() {
        return this.o;
    }

    int[] d(Character ch, boolean z) {
        int i;
        if (this.a.r()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.a.q()) || this.a.z(r)) {
            return null;
        }
        int[] iArr = this.p;
        this.a.t();
        if (this.a.u("#")) {
            boolean v = this.a.v("X");
            a aVar = this.a;
            String g = v ? aVar.g() : aVar.f();
            if (g.length() == 0) {
                c("numeric reference with no numerals");
                this.a.H();
                return null;
            }
            if (!this.a.u(";")) {
                c("missing semicolon");
            }
            try {
                i = Integer.valueOf(g, v ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (i >= 128) {
                int[] iArr2 = s;
                if (i < iArr2.length + 128) {
                    c("character is not a valid unicode code point");
                    i = iArr2[i - 128];
                }
            }
            iArr[0] = i;
            return iArr;
        }
        String i2 = this.a.i();
        boolean w = this.a.w(';');
        if (!Entities.f(i2) && (!Entities.g(i2) || !w)) {
            this.a.H();
            if (w) {
                c(String.format("invalid named referenece '%s'", i2));
            }
            return null;
        }
        if (z && (this.a.C() || this.a.A() || this.a.y('=', '-', '_'))) {
            this.a.H();
            return null;
        }
        if (!this.a.u(";")) {
            c("missing semicolon");
        }
        int d = Entities.d(i2, this.q);
        if (d == 1) {
            iArr[0] = this.q[0];
            return iArr;
        }
        if (d == 2) {
            return this.q;
        }
        org.jsoup.helper.d.a("Unexpected characters returned for " + i2);
        return this.q;
    }

    void e() {
        this.n.m();
    }

    void f() {
        this.m.m();
    }

    Token.i g(boolean z) {
        Token.i m = z ? this.j.m() : this.k.m();
        this.i = m;
        return m;
    }

    void h() {
        Token.n(this.h);
    }

    void i(char c) {
        j(String.valueOf(c));
    }

    void j(String str) {
        if (this.f == null) {
            this.f = str;
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(str);
    }

    void k(Token token) {
        org.jsoup.helper.d.c(this.e, "There is an unread token pending!");
        this.d = token;
        this.e = true;
        Token.TokenType tokenType = token.a;
        if (tokenType == Token.TokenType.StartTag) {
            this.o = ((Token.h) token).b;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.g) token).j == null) {
                return;
            }
            q("Attributes incorrectly present on end tag");
        }
    }

    void l(int[] iArr) {
        j(new String(iArr, 0, iArr.length));
    }

    void m() {
        k(this.n);
    }

    void n() {
        k(this.m);
    }

    void o() {
        this.i.x();
        k(this.i);
    }

    void p(TokeniserState tokeniserState) {
        if (this.b.canAddError()) {
            this.b.add(new c(this.a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    void q(String str) {
        if (this.b.canAddError()) {
            this.b.add(new c(this.a.F(), str));
        }
    }

    void r(TokeniserState tokeniserState) {
        if (this.b.canAddError()) {
            this.b.add(new c(this.a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.a.q()), tokeniserState));
        }
    }

    boolean s() {
        return this.o != null && this.i.A().equalsIgnoreCase(this.o);
    }

    Token t() {
        while (!this.e) {
            this.c.read(this, this.a);
        }
        if (this.g.length() > 0) {
            String sb = this.g.toString();
            StringBuilder sb2 = this.g;
            sb2.delete(0, sb2.length());
            this.f = null;
            return this.l.p(sb);
        }
        String str = this.f;
        if (str == null) {
            this.e = false;
            return this.d;
        }
        Token.c p = this.l.p(str);
        this.f = null;
        return p;
    }

    void u(TokeniserState tokeniserState) {
        this.c = tokeniserState;
    }
}
