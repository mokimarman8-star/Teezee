package org.mvel2.util;

import org.mvel2.ScriptRuntimeException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class g {
    private StackElement a;
    private int b = 0;

    public void a(Object obj) {
        this.b++;
        StackElement stackElement = this.a;
        if (stackElement == null) {
            this.a = new StackElement(null, obj);
            return;
        }
        while (true) {
            StackElement stackElement2 = stackElement.next;
            if (stackElement2 == null) {
                stackElement.next = new StackElement(null, obj);
                return;
            }
            stackElement = stackElement2;
        }
    }

    public void b() {
        this.b = 0;
        this.a = null;
    }

    public void c(g gVar) {
        this.a = new StackElement(new StackElement(this.a, gVar.a.value), gVar.a.next.value);
        gVar.a = gVar.a.next.next;
        this.b += 2;
        gVar.b -= 2;
    }

    public void d(g gVar) {
        this.a = new StackElement(new StackElement(this.a, gVar.a.next.value), gVar.a.value);
        gVar.a = gVar.a.next.next;
        this.b += 2;
        gVar.b -= 2;
    }

    public void e() {
        int i = this.b;
        if (i != 0) {
            this.b = i - 1;
            this.a = this.a.next;
        }
    }

    public void f() {
        this.b++;
        StackElement stackElement = this.a;
        this.a = new StackElement(stackElement, stackElement.value);
    }

    public boolean g() {
        return this.b == 0;
    }

    public boolean h() {
        return this.b > 1;
    }

    public void i() {
        StackElement stackElement = this.a;
        StackElement stackElement2 = stackElement.next.next;
        this.a = new StackElement(stackElement2.next, a00.a.g(stackElement2.value, ((Integer) stackElement.value).intValue(), this.a.next.value));
        this.b -= 2;
    }

    public void j(int i) {
        StackElement stackElement = this.a;
        StackElement stackElement2 = stackElement.next;
        this.a = new StackElement(stackElement2.next, a00.a.g(stackElement2.value, i, stackElement.value));
        this.b--;
    }

    public Object k() {
        if (this.b == 0) {
            return null;
        }
        return this.a.value;
    }

    public Object l() {
        return this.a.next.value;
    }

    public Boolean m() {
        if (this.b == 0) {
            return null;
        }
        Object obj = this.a.value;
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected Boolean; but found: ");
        Object obj2 = this.a.value;
        sb.append(obj2 == null ? "null" : obj2.getClass().getName());
        throw new ScriptRuntimeException(sb.toString());
    }

    public Object n() {
        int i = this.b;
        if (i == 0) {
            return null;
        }
        try {
            this.b = i - 1;
            StackElement stackElement = this.a;
            Object obj = stackElement.value;
            this.a = stackElement.next;
            return obj;
        } catch (Throwable th) {
            this.a = this.a.next;
            throw th;
        }
    }

    public Object o() {
        try {
            this.b -= 2;
            StackElement stackElement = this.a;
            Object obj = stackElement.value;
            this.a = stackElement.next.next;
            return obj;
        } catch (Throwable th) {
            this.a = this.a.next.next;
            throw th;
        }
    }

    public Boolean p() {
        int i = this.b;
        this.b = i - 1;
        if (i == 0) {
            return null;
        }
        try {
            StackElement stackElement = this.a;
            Object obj = stackElement.value;
            if (obj instanceof Boolean) {
                Boolean bool = (Boolean) obj;
                this.a = stackElement.next;
                return bool;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected Boolean; but found: ");
            Object obj2 = this.a.value;
            sb.append(obj2 == null ? "null" : obj2.getClass().getName());
            throw new ScriptRuntimeException(sb.toString());
        } catch (Throwable th) {
            this.a = this.a.next;
            throw th;
        }
    }

    public void q(Object obj) {
        this.b++;
        this.a = new StackElement(this.a, obj);
    }

    public void r(Object obj, Object obj2) {
        this.b += 2;
        this.a = new StackElement(new StackElement(this.a, obj), obj2);
    }

    public void s(Object obj, Object obj2, Object obj3) {
        this.b += 3;
        this.a = new StackElement(new StackElement(new StackElement(this.a, obj), obj2), obj3);
    }

    public int t() {
        return this.b;
    }

    public String toString() {
        StackElement stackElement = this.a;
        if (stackElement == null) {
            return "<EMPTY>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        do {
            sb.append(String.valueOf(stackElement.value));
            if (stackElement.next != null) {
                sb.append(", ");
            }
            stackElement = stackElement.next;
        } while (stackElement != null);
        sb.append("]");
        return sb.toString();
    }

    public void u() {
        StackElement stackElement = this.a;
        StackElement stackElement2 = stackElement.next;
        StackElement stackElement3 = stackElement2.next;
        stackElement2.next = stackElement;
        this.a = stackElement2;
        stackElement.next = stackElement3;
    }

    public void v() {
        StackElement stackElement = this.a;
        StackElement stackElement2 = stackElement.next;
        StackElement stackElement3 = stackElement2.next;
        stackElement2.next = stackElement;
        stackElement.next = stackElement3.next;
        this.a = stackElement3;
        stackElement3.next = stackElement2;
    }

    public void w() {
        StackElement stackElement = this.a.next;
        StackElement stackElement2 = stackElement.next;
        this.a = new StackElement(stackElement2.next, a00.a.g(stackElement2.value, ((Integer) stackElement.value).intValue(), this.a.value));
        this.b -= 2;
    }
}
