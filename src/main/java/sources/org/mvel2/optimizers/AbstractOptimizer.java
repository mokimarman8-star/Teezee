package org.mvel2.optimizers;

import java.lang.reflect.Method;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.d;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class AbstractOptimizer extends AbstractParser {
    protected static final int BEAN = 0;
    protected static final int COL = 2;
    protected static final int METH = 1;
    protected static final int WITH = 3;
    protected boolean collection;
    protected Class currType;
    protected boolean nullSafe;
    protected boolean staticAccess;
    protected int tkStart;

    protected AbstractOptimizer() {
        this.collection = false;
        this.nullSafe = false;
        this.currType = null;
        this.staticAccess = false;
    }

    protected AbstractOptimizer(ParserContext parserContext) {
        super(parserContext);
        this.collection = false;
        this.nullSafe = false;
        this.currType = null;
        this.staticAccess = false;
    }

    protected String capture() {
        char[] cArr = this.expr;
        int trimRight = trimRight(this.tkStart);
        this.tkStart = trimRight;
        return new String(cArr, trimRight, trimLeft(this.cursor) - this.tkStart);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r5 != '}') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
    
        if (r3 == 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[LOOP:0: B:2:0x000a->B:15:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[EDGE_INSN: B:16:0x003b->B:17:0x003b BREAK  A[LOOP:0: B:2:0x000a->B:15:0x0038], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findLastUnion() {
        /*
            r7 = this;
            int r0 = r7.start
            int r1 = r7.length
            int r0 = r0 + r1
            r1 = 1
            int r0 = r0 - r1
            r2 = -1
            r3 = 0
            r4 = r2
        La:
            int r5 = r7.start
            if (r0 == r5) goto L3b
            char[] r5 = r7.expr
            char r5 = r5[r0]
            r6 = 46
            if (r5 == r6) goto L32
            r6 = 91
            if (r5 == r6) goto L2a
            r6 = 93
            if (r5 == r6) goto L27
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 == r6) goto L2a
            r6 = 125(0x7d, float:1.75E-43)
            if (r5 == r6) goto L27
            goto L35
        L27:
            int r3 = r3 + 1
            goto L35
        L2a:
            int r3 = r3 + (-1)
            if (r3 != 0) goto L35
            r7.collection = r1
        L30:
            r4 = r0
            goto L35
        L32:
            if (r3 != 0) goto L35
            goto L30
        L35:
            if (r4 == r2) goto L38
            goto L3b
        L38:
            int r0 = r0 + (-1)
            goto La
        L3b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.AbstractOptimizer.findLastUnion():int");
    }

    protected int nextSubToken() {
        int i;
        skipWhitespace();
        this.nullSafe = false;
        char[] cArr = this.expr;
        int i2 = this.cursor;
        this.tkStart = i2;
        char c = cArr[i2];
        if (c != '.') {
            if (c != '?') {
                if (c == '[') {
                    return 2;
                }
                if (c == '{' && cArr[i2 - 1] == '.') {
                    return 3;
                }
            } else if (this.start == i2) {
                this.tkStart = i2 + 1;
                this.cursor = i2 + 1;
                this.nullSafe = true;
            }
        } else {
            if (this.start + 1 == this.end) {
                throw new CompileException("unexpected end of statement", this.expr, this.start);
            }
            int i3 = i2 + 1;
            this.tkStart = i3;
            this.cursor = i3;
            char c2 = cArr[i3];
            if (c2 == '?') {
                skipWhitespace();
                int i4 = this.tkStart + 1;
                this.tkStart = i4;
                this.cursor = i4;
                if (i4 == this.end) {
                    throw new CompileException("unexpected end of statement", this.expr, this.start);
                }
                this.nullSafe = true;
                this.fields = -1;
            } else {
                if (c2 == '{') {
                    return 3;
                }
                if (m.q0(c2)) {
                    skipWhitespace();
                    this.tkStart = this.cursor;
                }
            }
        }
        do {
            i = this.cursor + 1;
            this.cursor = i;
            if (i >= this.end) {
                break;
            }
        } while (m.c0(this.expr[i]));
        skipWhitespace();
        int i6 = this.cursor;
        if (i6 >= this.end) {
            return 0;
        }
        char c3 = this.expr[i6];
        if (c3 != '(') {
            return c3 != '[' ? 0 : 2;
        }
        return 1;
    }

    protected boolean scanTo(char c) {
        while (true) {
            int i = this.cursor;
            int i2 = this.end;
            if (i >= i2) {
                return true;
            }
            char[] cArr = this.expr;
            char c2 = cArr[i];
            if (c2 == '\"' || c2 == '\'') {
                this.cursor = m.h(c2, cArr, i, i2);
            }
            char[] cArr2 = this.expr;
            int i3 = this.cursor;
            if (cArr2[i3] == c) {
                return false;
            }
            this.cursor = i3 + 1;
        }
    }

    protected Object tryStaticAccess() {
        int i;
        int i2 = this.cursor;
        try {
            int i3 = this.end;
            int i4 = i3 - 1;
            boolean z = false;
            while (i4 > this.start) {
                char c = this.expr[i4];
                if (c == '\"') {
                    while (true) {
                        i = i4 - 1;
                        if (i > this.start) {
                            char[] cArr = this.expr;
                            if (cArr[i] != '\"' || cArr[i4 - 2] == '\\') {
                                i4 = i;
                            }
                        }
                    }
                } else if (c != '\'') {
                    int i6 = 1;
                    if (c == ')') {
                        int i7 = i4 - 1;
                        int i8 = 1;
                        while (i7 > this.start && i8 != 0) {
                            char c2 = this.expr[i7];
                            if (c2 != '\"') {
                                switch (c2) {
                                    case '(':
                                        i8--;
                                        break;
                                    case ')':
                                        i8++;
                                        break;
                                }
                                i7--;
                            }
                            while (i7 > this.start) {
                                char[] cArr2 = this.expr;
                                if (cArr2[i7] != c2 && cArr2[i7 - 1] != '\\') {
                                    i7--;
                                }
                                i7--;
                            }
                            i7--;
                        }
                        z = true;
                        int i9 = i7;
                        i4 = i7 + 1;
                        i3 = i9;
                    } else if (c == '.') {
                        if (!z) {
                            ParserContext parserContext = this.pCtx;
                            ClassLoader classLoader = parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
                            char[] cArr3 = this.expr;
                            int i10 = this.start;
                            this.cursor = i3;
                            String str = new String(cArr3, i10, i3 - i10);
                            try {
                                if (d.j && str.endsWith(".class")) {
                                    str = str.substring(0, str.length() - 6);
                                }
                                return Class.forName(str, true, classLoader);
                            } catch (ClassNotFoundException e) {
                                try {
                                    return m.F(str, classLoader, e);
                                } catch (ClassNotFoundException unused) {
                                    Class H = m.H(new String(this.expr, this.start, i4 - this.start), classLoader);
                                    String str2 = new String(this.expr, i4 + 1, (this.end - i4) - 1);
                                    try {
                                        return H.getField(str2);
                                    } catch (NoSuchFieldException unused2) {
                                        for (Method method : H.getMethods()) {
                                            if (str2.equals(method.getName())) {
                                                return method;
                                            }
                                        }
                                        return null;
                                    }
                                }
                            }
                        }
                        i3 = i4;
                        z = false;
                    } else if (c == '}') {
                        while (true) {
                            i4--;
                            if (i4 > this.start && i6 != 0) {
                                char c3 = this.expr[i4];
                                if (c3 == '\"' || c3 == '\'') {
                                    while (i4 > this.start) {
                                        char[] cArr4 = this.expr;
                                        if (cArr4[i4] != c3 && cArr4[i4 - 1] != '\\') {
                                            i4--;
                                        }
                                    }
                                } else if (c3 == '{') {
                                    i6--;
                                } else if (c3 == '}') {
                                    i6++;
                                }
                            }
                        }
                    }
                    i4--;
                } else {
                    while (true) {
                        i = i4 - 1;
                        if (i > this.start) {
                            char[] cArr5 = this.expr;
                            if (cArr5[i] != '\'' || cArr5[i4 - 2] == '\\') {
                                i4 = i;
                            }
                        }
                    }
                }
                i4 = i;
                i4--;
            }
        } catch (Exception unused3) {
            this.cursor = i2;
        }
        return null;
    }

    protected void whiteSpaceSkip() {
        if (this.cursor < this.length) {
            while (m.q0(this.expr[this.cursor])) {
                int i = this.cursor + 1;
                this.cursor = i;
                if (i == this.length) {
                    return;
                }
            }
        }
    }
}
