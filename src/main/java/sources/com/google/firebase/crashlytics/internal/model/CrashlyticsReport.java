package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.b;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CrashlyticsReport {
    private static final Charset a = Charset.forName("UTF-8");

    public static b b() {
        return new b.b();
    }

    public abstract a c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract String j();

    public abstract d k();

    public abstract int l();

    public abstract String m();

    public abstract e n();

    protected abstract b o();

    public CrashlyticsReport p(String str) {
        b c = o().c(str);
        if (n() != null) {
            c.m(n().p(str));
        }
        return c.a();
    }

    public CrashlyticsReport q(a aVar) {
        return aVar == null ? this : o().b(aVar).a();
    }

    public CrashlyticsReport r(List list) {
        if (n() != null) {
            return o().m(n().q(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public CrashlyticsReport s(String str) {
        return o().f(str).a();
    }

    public CrashlyticsReport t(String str) {
        return o().g(str).a();
    }

    public CrashlyticsReport u(d dVar) {
        return o().m((e) null).j(dVar).a();
    }

    public CrashlyticsReport v(long j, boolean z, String str) {
        b o = o();
        if (n() != null) {
            o.m(n().r(j, z, str));
        }
        return o.a();
    }
}
