package org.mvel2.util;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Function;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class h {
    private String a;
    private int b;
    private int c;
    private int d;
    private char[] e;
    private ParserContext f;
    private g g;

    public h(String str, int i, int i2, char[] cArr, int i3, ParserContext parserContext, g gVar) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.e = cArr;
        this.d = i3;
        this.f = parserContext;
        this.g = gVar;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public Function c() {
        int i;
        int i2;
        int i3;
        int i4 = this.b;
        int i6 = this.c + i4;
        int j = m.j(this.e, i4, i6, this.f);
        this.b = j;
        char[] cArr = this.e;
        int s0 = m.s0(cArr, j);
        this.b = s0;
        if (cArr[s0] == '(') {
            i3 = m.e(this.e, s0, i6, '(', this.f);
            int i7 = s0 + 1;
            int i8 = i3 + 1;
            this.b = i8;
            int E0 = m.E0(this.e, i8);
            this.b = E0;
            if (E0 >= i6) {
                throw new CompileException("incomplete statement", this.e, this.b);
            }
            char[] cArr2 = this.e;
            if (cArr2[E0] == '{') {
                i2 = m.e(cArr2, E0, i6, '{', this.f);
                this.b = i2;
                i = i7;
                s0 = E0;
            } else {
                i2 = m.i(cArr2, E0, i6, this.f);
                this.b = i2;
                i = i7;
                s0 = E0 - 1;
            }
        } else {
            char[] cArr3 = this.e;
            i = 0;
            if (cArr3[s0] == '{') {
                i2 = m.e(cArr3, s0, i6, '{', this.f);
                this.b = i2;
            } else {
                i2 = m.i(cArr3, s0, i6, this.f);
                this.b = i2;
                s0--;
            }
            i3 = 0;
        }
        int N0 = m.N0(this.e, s0 + 1);
        int M0 = m.M0(this.e, i4, i2);
        int i9 = this.b + 1;
        this.b = i9;
        if (this.g != null && m.p0(this.e, i9)) {
            this.g.a(new EndOfStatement(this.f));
        }
        return new Function(this.a, this.e, i, i3 - i, N0, M0 - N0, this.d, this.f);
    }
}
