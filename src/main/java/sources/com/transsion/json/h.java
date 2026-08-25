package com.transsion.json;

import com.transsion.json.b.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class h {
    private static final ThreadLocal n = new a();
    private String a;
    private p b;
    private p f;
    private Map g;
    private List h;
    private boolean m;
    private boolean c = false;
    private final Stack d = new Stack();
    private int e = 0;
    private t i = t.SHALLOW;
    private f j = new f(Collections.EMPTY_SET);
    private final LinkedList k = new LinkedList();
    private final q l = new q();

    static class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h initialValue() {
            return new h();
        }
    }

    private void I() {
        if (this.m) {
            this.b.a(",");
            if (this.c) {
                this.b.a("\n");
            }
            this.m = false;
        }
    }

    private void J() {
        this.m = false;
    }

    private com.transsion.json.b.n K() {
        return (com.transsion.json.b.n) this.g.get(this.l);
    }

    public static void c() {
        n.remove();
    }

    private void d(char c) {
        this.b.a("\\u");
        int i = 0;
        int i2 = c;
        while (i < 4) {
            this.b.a(String.valueOf(j.f[(61440 & i2) >> 12]));
            i++;
            i2 <<= 4;
        }
    }

    private com.transsion.json.b.n p(Object obj) {
        return this.f.a(obj);
    }

    public static h q() {
        return (h) n.get();
    }

    public u A() {
        if (this.d.isEmpty()) {
            return null;
        }
        return (u) this.d.peek();
    }

    public void B() {
        this.d.pop();
    }

    public void C() {
        J();
        if (this.c) {
            this.b.a("\n");
            this.e -= 4;
            F();
        }
        this.b.a("]");
        B();
    }

    public void D() {
        J();
        if (this.c) {
            this.b.a("\n");
            this.e -= 4;
            F();
        }
        this.b.a("}");
        B();
    }

    public void E() {
        this.m = true;
    }

    public void F() {
        for (int i = 0; i < this.e; i++) {
            this.b.a(" ");
        }
    }

    public u G() {
        u A;
        I();
        if (this.c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        u uVar = new u(com.transsion.json.a.ARRAY);
        i(uVar);
        this.b.a("[");
        if (this.c) {
            this.e += 4;
            this.b.a("\n");
        }
        return uVar;
    }

    public u H() {
        u A;
        I();
        if (this.c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        u uVar = new u(com.transsion.json.a.OBJECT);
        i(uVar);
        this.b.a("{");
        if (this.c) {
            this.e += 4;
            this.b.a("\n");
        }
        return uVar;
    }

    public com.transsion.json.b.n a(d dVar, Object obj) {
        com.transsion.json.b.n K = K();
        if (K != null) {
            return K;
        }
        if (dVar != null) {
            K = dVar.j();
        }
        return K == null ? p(obj) : K;
    }

    protected r b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.b(this.l)) {
                return rVar;
            }
        }
        return null;
    }

    public void e(p pVar) {
        this.f = pVar;
    }

    public void f(f fVar) {
        this.j = fVar;
    }

    public void g(p pVar) {
        this.b = pVar;
    }

    public void h(t tVar) {
        this.i = tVar;
    }

    public void i(u uVar) {
        this.d.push(uVar);
    }

    public void j(Object obj) {
        com.transsion.json.b.n K = K();
        if (K == null) {
            K = p(obj);
        }
        K.a(obj);
    }

    public void k(String str) {
        this.a = str;
    }

    public void l(Map map) {
        this.g = map;
    }

    public void m(boolean z) {
        this.c = z;
    }

    public boolean n(d dVar) {
        r b = b(this.h);
        if (b != null) {
            return b.a();
        }
        Boolean l = dVar.l();
        if (l != null) {
            return l.booleanValue();
        }
        if (dVar.o().booleanValue()) {
            return false;
        }
        if (this.i != t.SHALLOW) {
            return true;
        }
        Class h = dVar.h();
        return (h.isArray() || Iterable.class.isAssignableFrom(h) || Map.class.isAssignableFrom(h)) ? false : true;
    }

    public boolean o(String str, Object obj) {
        r b = b(this.h);
        if (b != null) {
            return b.a();
        }
        String y = ((h) n.get()).y();
        if (obj == null) {
            return true;
        }
        t tVar = this.i;
        t tVar2 = t.SHALLOW;
        if ((tVar != tVar2 || y == null || this.l.c() <= 1) && !(this.i == tVar2 && y == null)) {
            return true;
        }
        Class<?> cls = obj.getClass();
        return (cls.isArray() || Iterable.class.isAssignableFrom(cls)) ? false : true;
    }

    public void r(String str) {
        I();
        u A = A();
        if (A != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.b.a(str);
    }

    public void s(List list) {
        this.h = list;
    }

    public LinkedList t() {
        return this.k;
    }

    public void u(String str) {
        I();
        if (this.c) {
            F();
        }
        if (str != null) {
            w(str);
        } else {
            r("null");
        }
        this.b.a(":");
        if (this.c) {
            this.b.a(" ");
        }
    }

    public p v() {
        return this.b;
    }

    public void w(String str) {
        u A;
        I();
        if (this.c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.b.a("\"");
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\"') {
                i = this.b.b(str, i, i2, "\\u0022");
            } else if (charAt == '&') {
                i = this.b.b(str, i, i2, "\\u0026");
            } else if (charAt == '\'') {
                i = this.b.b(str, i, i2, "\\u0027");
            } else if (charAt == '<') {
                i = this.b.b(str, i, i2, "\\u003c");
            } else if (charAt == '>') {
                i = this.b.b(str, i, i2, "\\u003e");
            } else if (charAt == '\\') {
                i = this.b.b(str, i, i2, "\\\\");
            } else if (charAt == '\b') {
                i = this.b.b(str, i, i2, "\\b");
            } else if (charAt == '\f') {
                i = this.b.b(str, i, i2, "\\f");
            } else if (charAt == '\n') {
                i = this.b.b(str, i, i2, "\\n");
            } else if (charAt == '\r') {
                i = this.b.b(str, i, i2, "\\r");
            } else if (charAt == '\t') {
                i = this.b.b(str, i, i2, "\\t");
            } else if (Character.isISOControl(charAt)) {
                i = this.b.a(str, i, i2) + 1;
                d(charAt);
            }
        }
        if (i < str.length()) {
            this.b.a(str, i, str.length());
        }
        this.b.a("\"");
    }

    public q x() {
        return this.l;
    }

    public String y() {
        return this.a;
    }

    public f z() {
        return this.j;
    }
}
