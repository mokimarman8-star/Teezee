package il;

import com.transsion.http.d.h;
import il.e;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    protected final String a;
    protected final Object b;
    protected final h c;
    protected final boolean d;
    protected final Map e;
    protected int f;
    protected int g;
    protected boolean h;
    protected SSLSocketFactory i;
    protected HostnameVerifier j;
    protected e.a k;

    public c(String str, Object obj, h hVar, Map map, boolean z, int i, int i2, boolean z2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        e.a aVar = new e.a();
        this.k = aVar;
        this.a = str;
        this.b = obj;
        this.c = hVar;
        this.e = map;
        this.d = z;
        this.f = i;
        this.g = i2;
        this.h = z2;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        aVar.n(str).e(obj).d(hVar).f(map).o(z).b(this.f).l(this.g).i(this.h).h(this.i).g(this.j);
    }

    public el.b a() {
        return new el.b(this);
    }

    protected abstract e b();

    public e c() {
        return b();
    }
}
