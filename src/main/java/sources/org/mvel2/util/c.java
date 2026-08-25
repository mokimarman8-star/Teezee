package org.mvel2.util;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c {
    private static final Object[] h = new Object[0];
    private char[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Class f;
    private ParserContext g;

    public c() {
    }

    public c(int i) {
        this.e = i;
    }

    private boolean b() {
        ParserContext parserContext = this.g;
        return parserContext != null && parserContext.isStrongTyping();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0156 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object c(boolean r22) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.c.c(boolean):java.lang.Object");
    }

    private void f(int i, int i2) {
        if (this.f == null) {
            m.I0(this.a, i, i2, this.g);
            return;
        }
        Class knownEgressType = ((ExecutableStatement) m.I0(this.a, i, i2, this.g)).getKnownEgressType();
        if (knownEgressType == null || p.f(this.f, knownEgressType)) {
            return;
        }
        if (b() || !org.mvel2.b.a(knownEgressType, this.f)) {
            throw new CompileException("expected type: " + this.f.getName() + "; but found: " + knownEgressType.getName(), this.a, this.b);
        }
    }

    public int a() {
        return this.b;
    }

    public Object d(char[] cArr, int i, int i2, boolean z, Class cls, ParserContext parserContext) {
        if (cls != null) {
            this.f = m.I(cls);
        }
        this.a = cArr;
        this.d = i2 + i;
        while (i < this.d && m.q0(cArr[i])) {
            i++;
        }
        this.b = i;
        this.c = i;
        this.g = parserContext;
        return c(z);
    }

    public Object e(char[] cArr, int i, int i2, boolean z, ParserContext parserContext) {
        this.a = cArr;
        this.g = parserContext;
        this.d = i2 + i;
        while (i < this.d && m.q0(cArr[i])) {
            i++;
        }
        this.b = i;
        this.c = i;
        return c(z);
    }
}
