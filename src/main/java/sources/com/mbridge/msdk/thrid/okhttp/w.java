package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.p;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class w {
    final q a;
    final String b;
    final p c;
    final x d;
    final Map<Class<?>, Object> e;
    private volatile c f;

    public static class a {
        q a;
        String b;
        p.a c;
        x d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new p.a();
        }

        a(w wVar) {
            this.e = Collections.emptyMap();
            this.a = wVar.a;
            this.b = wVar.b;
            this.d = wVar.d;
            this.e = wVar.e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(wVar.e);
            this.c = wVar.c.a();
        }

        public a a(c cVar) {
            String cVar2 = cVar.toString();
            return cVar2.isEmpty() ? a("Cache-Control") : b("Cache-Control", cVar2);
        }

        public a a(p pVar) {
            this.c = pVar.a();
            return this;
        }

        public a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("url == null");
            }
            this.a = qVar;
            return this;
        }

        public a a(x xVar) {
            return a("DELETE", xVar);
        }

        public a a(String str) {
            this.c.b(str);
            return this;
        }

        public a a(String str, x xVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (xVar != null && !com.mbridge.msdk.thrid.okhttp.internal.http.f.a(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (xVar != null || !com.mbridge.msdk.thrid.okhttp.internal.http.f.d(str)) {
                this.b = str;
                this.d = xVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public w a() {
            if (this.a != null) {
                return new w(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b() {
            return a(com.mbridge.msdk.thrid.okhttp.internal.c.d);
        }

        public a b(x xVar) {
            return a("PATCH", xVar);
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(q.b(str));
        }

        public a b(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a c() {
            return a("GET", (x) null);
        }

        public a c(x xVar) {
            return a("POST", xVar);
        }

        public a d() {
            return a("HEAD", (x) null);
        }

        public a d(x xVar) {
            return a("PUT", xVar);
        }
    }

    w(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = com.mbridge.msdk.thrid.okhttp.internal.c.a(aVar.e);
    }

    public x a() {
        return this.d;
    }

    public String a(String str) {
        return this.c.b(str);
    }

    public c b() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar;
        }
        c a2 = c.a(this.c);
        this.f = a2;
        return a2;
    }

    public p c() {
        return this.c;
    }

    public boolean d() {
        return this.a.h();
    }

    public String e() {
        return this.b;
    }

    public a f() {
        return new a(this);
    }

    public q g() {
        return this.a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }
}
