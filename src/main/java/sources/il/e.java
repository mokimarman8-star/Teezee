package il;

import android.content.Context;
import com.transsion.http.d.h;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final int a;
    private final int b;
    private String c;
    private final String d;
    private final Object e;
    private final h f;
    private final boolean g;
    private final Map h;
    private final Context i;
    private final String j;
    private final com.transsion.http.d.a k;
    private final boolean l;
    private final SSLSocketFactory m;
    private final HostnameVerifier n;

    public static final class a {
        private boolean a;
        private int b;
        private int c;
        private boolean d;
        private String e;
        private String f;
        private Object g;
        private h h;
        private boolean i;
        private Context j;
        private String k;
        private com.transsion.http.d.a l;
        private Map m;
        private boolean n;
        private SSLSocketFactory o;
        private HostnameVerifier p;

        public a() {
            jl.a.a.a(this.a);
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a c(Context context) {
            this.j = context;
            return this;
        }

        public a d(h hVar) {
            this.h = hVar;
            return this;
        }

        public a e(Object obj) {
            this.g = obj;
            return this;
        }

        public a f(Map map) {
            this.m = map;
            return this;
        }

        public a g(HostnameVerifier hostnameVerifier) {
            this.p = hostnameVerifier;
            return this;
        }

        public a h(SSLSocketFactory sSLSocketFactory) {
            this.o = sSLSocketFactory;
            return this;
        }

        public a i(boolean z) {
            this.d = z;
            return this;
        }

        public e j() {
            if (this.e == null) {
                throw new IllegalStateException("url == null");
            }
            if (this.o == null) {
                this.o = new b().a();
            }
            if (this.p == null) {
                this.p = new il.a().a();
            }
            return new e(this);
        }

        public a l(int i) {
            this.c = i;
            return this;
        }

        public a m(boolean z) {
            this.i = z;
            return this;
        }

        public a n(String str) {
            this.e = str;
            return this;
        }

        public a o(boolean z) {
            this.a = z;
            jl.a.a.a(z);
            return this;
        }
    }

    public e(a aVar) {
        this.a = aVar.b;
        this.b = aVar.c;
        boolean unused = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g != null ? aVar.g : this;
        this.f = aVar.h;
        this.h = aVar.m;
        this.g = aVar.i;
        this.i = aVar.j;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.n;
        this.m = aVar.o;
        this.n = aVar.p;
    }

    public int a() {
        return this.a;
    }

    void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.d;
    }

    public com.transsion.http.d.a d() {
        return this.k;
    }

    public Context e() {
        return this.i;
    }

    public Map f() {
        return this.h;
    }

    public HostnameVerifier g() {
        return this.n;
    }

    public h h() {
        return this.f;
    }

    public String i() {
        return this.j;
    }

    public int j() {
        return this.b;
    }

    public boolean k() {
        return this.l;
    }

    public SSLSocketFactory l() {
        return this.m;
    }

    public Object m() {
        return this.e;
    }

    public String n() {
        return this.c;
    }

    public boolean o() {
        return this.g;
    }
}
