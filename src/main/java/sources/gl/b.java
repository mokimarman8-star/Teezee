package gl;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    protected String a;
    protected Object b;
    protected Map c = new LinkedHashMap();
    protected boolean d = true;
    protected int e = 10000;
    protected int f = 10000;
    protected boolean g = false;
    protected SSLSocketFactory h;
    protected HostnameVerifier i;

    public b a(int i) {
        this.e = i;
        return this;
    }

    public b b(boolean z) {
        this.d = z;
        return this;
    }

    public b c(int i) {
        this.f = i;
        return this;
    }

    public b d(String str) {
        this.a = str;
        return this;
    }
}
