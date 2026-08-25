package s7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a {
    public final int a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final int f;
    public final boolean g;
    public final w7.b h;
    public final z7.b i;
    public final y7.b j;
    public final b8.b k;
    public final a8.b l;
    public final v7.a m;
    private final Map n;
    public final List o;

    /* renamed from: s7.a$a, reason: collision with other inner class name */
    public static class C0065a {
        private int a;
        private String b;
        private boolean c;
        private boolean d;
        private String e;
        private int f;
        private boolean g;
        private w7.b h;
        private z7.b i;
        private y7.b j;
        private b8.b k;
        private a8.b l;
        private v7.a m;
        private Map n;
        private List o;

        public C0065a() {
            this.a = Integer.MIN_VALUE;
            this.b = "X-LOG";
        }

        public C0065a(a aVar) {
            this.a = Integer.MIN_VALUE;
            this.b = "X-LOG";
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            if (aVar.n != null) {
                this.n = new HashMap(aVar.n);
            }
            if (aVar.o != null) {
                this.o = new ArrayList(aVar.o);
            }
        }

        private void y() {
            if (this.h == null) {
                this.h = d8.a.h();
            }
            if (this.i == null) {
                this.i = d8.a.n();
            }
            if (this.j == null) {
                this.j = d8.a.l();
            }
            if (this.k == null) {
                this.k = d8.a.k();
            }
            if (this.l == null) {
                this.l = d8.a.j();
            }
            if (this.m == null) {
                this.m = d8.a.c();
            }
            if (this.n == null) {
                this.n = new HashMap(d8.a.a());
            }
        }

        public C0065a A(w7.b bVar) {
            this.h = bVar;
            return this;
        }

        public C0065a B(int i) {
            this.a = i;
            return this;
        }

        C0065a C(Map map) {
            this.n = map;
            return this;
        }

        public C0065a D(a8.b bVar) {
            this.l = bVar;
            return this;
        }

        public C0065a E(String str) {
            this.b = str;
            return this;
        }

        public C0065a F(b8.b bVar) {
            this.k = bVar;
            return this;
        }

        public C0065a G(y7.b bVar) {
            this.j = bVar;
            return this;
        }

        public C0065a H(z7.b bVar) {
            this.i = bVar;
            return this;
        }

        public C0065a p(c8.a aVar) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.add(aVar);
            return this;
        }

        public C0065a q(v7.a aVar) {
            this.m = aVar;
            return this;
        }

        public a r() {
            y();
            return new a(this);
        }

        public C0065a s() {
            this.g = false;
            return this;
        }

        public C0065a t() {
            this.d = false;
            this.e = null;
            this.f = 0;
            return this;
        }

        public C0065a u() {
            this.c = false;
            return this;
        }

        public C0065a v() {
            this.g = true;
            return this;
        }

        public C0065a w(String str, int i) {
            this.d = true;
            this.e = str;
            this.f = i;
            return this;
        }

        public C0065a x() {
            this.c = true;
            return this;
        }

        C0065a z(List list) {
            this.o = list;
            return this;
        }
    }

    a(C0065a c0065a) {
        this.a = c0065a.a;
        this.b = c0065a.b;
        this.c = c0065a.c;
        this.d = c0065a.d;
        this.e = c0065a.e;
        this.f = c0065a.f;
        this.g = c0065a.g;
        this.h = c0065a.h;
        this.i = c0065a.i;
        this.j = c0065a.j;
        this.k = c0065a.k;
        this.l = c0065a.l;
        this.m = c0065a.m;
        this.n = c0065a.n;
        this.o = c0065a.o;
    }
}
