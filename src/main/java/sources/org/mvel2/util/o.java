package org.mvel2.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Proto;
import org.mvel2.compiler.ExecutableStatement;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class o {
    private static ThreadLocal m = new ThreadLocal();
    private char[] a;
    private ParserContext b;
    private int c;
    private int d;
    private String e;
    String f = null;
    String g = null;
    private Class h;
    private String i;
    private String j;
    private boolean k;
    private g l;

    class a implements b {
        final /* synthetic */ String a;
        final /* synthetic */ Proto.c b;
        final /* synthetic */ String c;

        a(String str, Proto.c cVar, String str2) {
            this.a = str;
            this.b = cVar;
            this.c = str2;
        }

        @Override // org.mvel2.util.o.b
        public boolean a(Proto proto) {
            if (!this.a.equals(proto.getName())) {
                return false;
            }
            this.b.f(Proto.ReceiverType.PROPERTY);
            this.b.e((ExecutableStatement) m.G0(this.c, o.this.b));
            return true;
        }

        @Override // org.mvel2.util.o.b
        public String getName() {
            return this.a;
        }
    }

    private interface b {
        boolean a(Proto proto);

        String getName();
    }

    public o(char[] cArr, int i, int i2, String str, ParserContext parserContext, int i3, g gVar) {
        this.k = false;
        this.a = cArr;
        this.d = i;
        this.c = i2;
        this.e = str;
        this.b = parserContext;
        this.k = (i3 & 16) == 0;
        this.l = gVar;
    }

    private void b() {
        if (this.g != null) {
            try {
                if (this.b.hasProtoImport(this.f)) {
                    this.h = Proto.class;
                } else {
                    this.h = m.D(null, this.f, this.b);
                }
                this.i = this.g;
            } catch (ClassNotFoundException e) {
                if (!this.k) {
                    throw new CompileException("could not resolve class: " + this.f, this.a, this.d, e);
                }
                this.h = b.class;
                this.j = this.f;
                this.i = this.g;
            }
        } else {
            this.h = Object.class;
            this.i = this.f;
        }
        this.f = null;
        this.g = null;
    }

    public static void c(char[] cArr, int i, ParserContext parserContext) {
        if (g()) {
            Object obj = ((LinkedHashMap) parserContext.getParserConfiguration().getImports()).values().toArray()[r5.size() - 1];
            if (obj instanceof Proto) {
                Proto proto = (Proto) obj;
                int cursorEnd = proto.getCursorEnd();
                do {
                    i--;
                    if (i <= cursorEnd) {
                        break;
                    }
                } while (m.q0(cArr[i]));
                while (i > cursorEnd && m.c0(cArr[i])) {
                    i--;
                }
                while (i > cursorEnd && (m.q0(cArr[i]) || cArr[i] == ';')) {
                    i--;
                }
                if (i == cursorEnd) {
                    return;
                }
                throw new CompileException("unresolved reference (possible illegal forward-reference?): " + f(), cArr, proto.getCursorStart());
            }
        }
    }

    private void d(String str, Proto.c cVar, String str2) {
        Queue queue = (Queue) m.get();
        if (queue == null) {
            ThreadLocal threadLocal = m;
            LinkedList linkedList = new LinkedList();
            threadLocal.set(linkedList);
            queue = linkedList;
        }
        queue.add(new a(str, cVar, str2));
    }

    public static String f() {
        if (m.get() == null || ((Queue) m.get()).isEmpty()) {
            return null;
        }
        return ((b) ((Queue) m.get()).poll()).getName();
    }

    public static boolean g() {
        return (m.get() == null || ((Queue) m.get()).isEmpty()) ? false : true;
    }

    public static void h(Proto proto) {
        if (m.get() != null) {
            Queue<b> queue = (Queue) m.get();
            HashSet hashSet = new HashSet();
            for (b bVar : queue) {
                if (bVar.a(proto)) {
                    hashSet.add(bVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                queue.remove((b) it.next());
            }
        }
    }

    public int e() {
        return this.d;
    }

    public Proto i() {
        Proto proto = new Proto(this.e, this.b);
        while (true) {
            int i = this.d;
            if (i >= this.c) {
                int i2 = i + 1;
                this.d = i2;
                if (this.l != null && m.p0(this.a, i2)) {
                    this.l.a(new EndOfStatement(this.b));
                }
                return proto;
            }
            int E0 = m.E0(this.a, i);
            this.d = E0;
            if (this.g == null) {
                while (true) {
                    int i3 = this.d;
                    if (i3 >= this.c || !m.c0(this.a[i3])) {
                        break;
                    }
                    this.d++;
                }
                int i4 = this.d;
                if (i4 > E0) {
                    String str = new String(this.a, E0, i4 - E0);
                    this.f = str;
                    if ("def".equals(str) || "function".equals(this.f)) {
                        int i6 = this.d + 1;
                        this.d = i6;
                        int E02 = m.E0(this.a, i6);
                        this.d = E02;
                        while (true) {
                            int i7 = this.d;
                            if (i7 >= this.c || !m.c0(this.a[i7])) {
                                break;
                            }
                            this.d++;
                        }
                        int i8 = this.d;
                        if (E02 == i8) {
                            throw new CompileException("attempt to declare an anonymous function as a prototype member", this.a, E02);
                        }
                        h hVar = new h(new String(this.a, E02, i8 - E02), this.d, this.c, this.a, 0, this.b, null);
                        proto.declareReceiver(hVar.b(), hVar.c());
                        this.d = hVar.a() + 1;
                        this.f = null;
                    }
                }
                this.d = m.E0(this.a, this.d);
            }
            int i9 = this.d;
            if (i9 > this.c) {
                throw new CompileException("unexpected end of statement in proto declaration: " + this.e, this.a, E0);
            }
            char[] cArr = this.a;
            char c = cArr[i9];
            if (c == ';') {
                this.d = i9 + 1;
                b();
                if (this.k && this.h == b.class) {
                    d(this.j, proto.declareReceiver(this.i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), null);
                } else {
                    proto.declareReceiver(this.i, this.h, (ExecutableStatement) null);
                }
            } else if (c != '=') {
                while (true) {
                    int i10 = this.d;
                    if (i10 >= this.c || !m.c0(this.a[i10])) {
                        break;
                    }
                    this.d++;
                }
                int i11 = this.d;
                if (i11 > i9) {
                    this.g = new String(this.a, i9, i11 - i9);
                }
            } else {
                int i12 = i9 + 1;
                this.d = i12;
                int E03 = m.E0(cArr, i12);
                this.d = E03;
                while (true) {
                    int i13 = this.d;
                    int i14 = this.c;
                    if (i13 >= i14) {
                        break;
                    }
                    char[] cArr2 = this.a;
                    char c2 = cArr2[i13];
                    if (c2 != '\"') {
                        if (c2 == ';') {
                            break;
                        }
                        if (c2 != '[' && c2 != '{' && c2 != '\'' && c2 != '(') {
                            this.d++;
                        }
                    }
                    this.d = m.e(cArr2, i13, i14, c2, this.b);
                    this.d++;
                }
                b();
                char[] cArr3 = this.a;
                int i15 = this.d;
                this.d = i15 + 1;
                String str2 = new String(cArr3, E03, i15 - E03);
                if (this.k && this.h == b.class) {
                    d(this.j, proto.declareReceiver(this.i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), str2);
                } else {
                    proto.declareReceiver(this.i, this.h, (ExecutableStatement) m.G0(str2, this.b));
                }
            }
        }
    }
}
