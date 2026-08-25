package mh;

import okhttp3.Call;
import okhttp3.EventListener;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class g implements EventListener.Factory {
    private EventListener.Factory a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private String h;

    public g() {
        this.b = 0;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = "All";
    }

    public g(EventListener.Factory factory, int i, boolean z) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = "All";
        this.a = factory;
        this.b = i;
        this.c = z;
    }

    public void a(String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public EventListener create(Call call) {
        EventListener.Factory factory = this.a;
        EventListener create = factory != null ? factory.create(call) : null;
        String host = call.request().url().host();
        if (d.d() || d.a(host)) {
            o.a.h("NetworkMonitor", new Object[]{"==== MonitorFactory host : ${host} matches ===="});
            return new f(create, this.b, this.c, this.h, this.f, this.g, this.d, this.e);
        }
        o.a.h("NetworkMonitor", new Object[]{"==== MonitorFactory host : ${host} does not matche ===="});
        return create == null ? EventListener.NONE : create;
    }
}
