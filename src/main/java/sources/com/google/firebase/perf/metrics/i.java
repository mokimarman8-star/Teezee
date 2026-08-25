package com.google.firebase.perf.metrics;

import com.google.firebase.perf.application.b;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class i extends b implements com.google.firebase.perf.session.a {
    private static final uc.a i = uc.a.e();
    private final List a;
    private final GaugeManager b;
    private final k c;
    private final NetworkRequestMetric$b d;
    private final WeakReference e;
    private String f;
    private boolean g;
    private boolean h;

    private i(k kVar) {
        this(kVar, com.google.firebase.perf.application.a.b(), GaugeManager.getInstance());
    }

    public i(k kVar, com.google.firebase.perf.application.a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.d = NetworkRequestMetric.R();
        this.e = new WeakReference(this);
        this.c = kVar;
        this.b = gaugeManager;
        this.a = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }

    public static i b(k kVar) {
        return new i(kVar);
    }

    private static boolean e(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStarted() {
        return this.d.l();
    }

    private boolean isStopped() {
        return this.d.n();
    }

    public NetworkRequestMetric a() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.e);
        unregisterForAppState();
        com.google.firebase.perf.v1.h[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.d.d(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric mo53build = this.d.mo53build();
        if (!wc.f.c(this.f)) {
            i.a("Dropping network request from a 'User-Agent' that is not allowed");
            return mo53build;
        }
        if (this.g) {
            if (this.h) {
                i.a("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return mo53build;
        }
        this.c.B(mo53build, getAppState());
        this.g = true;
        return mo53build;
    }

    public long c() {
        return this.d.k();
    }

    public boolean d() {
        return this.d.m();
    }

    public i f(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            switch (upperCase) {
                case "OPTIONS":
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case "GET":
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case "PUT":
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case "HEAD":
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case "POST":
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case "PATCH":
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case "TRACE":
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case "CONNECT":
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case "DELETE":
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.d.p(httpMethod);
        }
        return this;
    }

    public i g(int i2) {
        this.d.q(i2);
        return this;
    }

    List getSessions() {
        List unmodifiableList;
        synchronized (this.a) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PerfSession perfSession : this.a) {
                    if (perfSession != null) {
                        arrayList.add(perfSession);
                    }
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
        return unmodifiableList;
    }

    public void h() {
        this.h = true;
    }

    public i i() {
        this.d.r(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public i j(long j) {
        this.d.s(j);
        return this;
    }

    public i k(long j) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.e);
        this.d.o(j);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.b.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public i l(String str) {
        if (str == null) {
            this.d.j();
            return this;
        }
        if (e(str)) {
            this.d.t(str);
        } else {
            i.j("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public i m(long j) {
        this.d.u(j);
        return this;
    }

    public i n(long j) {
        this.d.v(j);
        return this;
    }

    public i o(long j) {
        this.d.w(j);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.b.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public i p(long j) {
        this.d.x(j);
        return this;
    }

    public i q(String str) {
        if (str != null) {
            this.d.y(com.google.firebase.perf.util.k.e(com.google.firebase.perf.util.k.d(str), 2000));
        }
        return this;
    }

    public i r(String str) {
        this.f = str;
        return this;
    }

    @Override // com.google.firebase.perf.session.a
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            i.j("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else {
            if (!hasStarted() || isStopped()) {
                return;
            }
            this.a.add(perfSession);
        }
    }
}
