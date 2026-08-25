package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.p;
import java.io.Closeable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class y implements Closeable {
    final w a;
    final u b;
    final int c;
    final String d;
    final o e;
    final p f;
    final z g;
    final y h;
    final y i;
    final y j;
    final long k;
    final long l;
    private volatile c m;

    public static class a {
        w a;
        u b;
        int c;
        String d;
        o e;
        p.a f;
        z g;
        y h;
        y i;
        y j;
        long k;
        long l;

        public a() {
            this.c = -1;
            this.f = new p.a();
        }

        a(y yVar) {
            this.c = -1;
            this.a = yVar.a;
            this.b = yVar.b;
            this.c = yVar.c;
            this.d = yVar.d;
            this.e = yVar.e;
            this.f = yVar.f.a();
            this.g = yVar.g;
            this.h = yVar.h;
            this.i = yVar.i;
            this.j = yVar.j;
            this.k = yVar.k;
            this.l = yVar.l;
        }

        private void a(String str, y yVar) {
            if (yVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (yVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (yVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (yVar.j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        private void b(y yVar) {
            if (yVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public a a(o oVar) {
            this.e = oVar;
            return this;
        }

        public a a(p pVar) {
            this.f = pVar.a();
            return this;
        }

        public a a(u uVar) {
            this.b = uVar;
            return this;
        }

        public a a(w wVar) {
            this.a = wVar;
            return this;
        }

        public a a(y yVar) {
            if (yVar != null) {
                a("cacheResponse", yVar);
            }
            this.i = yVar;
            return this;
        }

        public a a(z zVar) {
            this.g = zVar;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public y a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c >= 0) {
                if (this.d != null) {
                    return new y(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.c);
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a b(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a c(y yVar) {
            if (yVar != null) {
                a("networkResponse", yVar);
            }
            this.h = yVar;
            return this;
        }

        public a d(y yVar) {
            if (yVar != null) {
                b(yVar);
            }
            this.j = yVar;
            return this;
        }
    }

    y(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public String a(String str, String str2) {
        String b = this.f.b(str);
        return b != null ? b : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.g;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public z d() {
        return this.g;
    }

    public c h() {
        c cVar = this.m;
        if (cVar != null) {
            return cVar;
        }
        c a2 = c.a(this.f);
        this.m = a2;
        return a2;
    }

    public int k() {
        return this.c;
    }

    public o l() {
        return this.e;
    }

    public p m() {
        return this.f;
    }

    public boolean n() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public a o() {
        return new a(this);
    }

    public y p() {
        return this.j;
    }

    public long q() {
        return this.l;
    }

    public w r() {
        return this.a;
    }

    public long s() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.g() + '}';
    }
}
