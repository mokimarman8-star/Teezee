package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class f {
    private final String a;
    private SymbolShapeHint b;
    private final StringBuilder c;
    int d;
    private int e;
    private pd.d f;
    private int g;

    f(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c);
        }
        this.a = sb2.toString();
        this.b = SymbolShapeHint.FORCE_NONE;
        this.c = new StringBuilder(str.length());
        this.e = -1;
    }

    private int h() {
        return this.a.length() - this.g;
    }

    public int a() {
        return this.c.length();
    }

    public StringBuilder b() {
        return this.c;
    }

    public char c() {
        return this.a.charAt(this.d);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return h() - this.d;
    }

    public pd.d g() {
        return this.f;
    }

    public boolean i() {
        return this.d < h();
    }

    public void j() {
        this.e = -1;
    }

    public void k() {
        this.f = null;
    }

    public void l(com.google.zxing.c cVar, com.google.zxing.c cVar2) {
    }

    public void m(int i) {
        this.g = i;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.b = symbolShapeHint;
    }

    public void o(int i) {
        this.e = i;
    }

    public void p() {
        q(a());
    }

    public void q(int i) {
        pd.d dVar = this.f;
        if (dVar == null || i > dVar.a()) {
            this.f = pd.d.l(i, this.b, null, null, true);
        }
    }

    public void r(char c) {
        this.c.append(c);
    }

    public void s(String str) {
        this.c.append(str);
    }
}
