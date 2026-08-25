package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class t extends u {
    private static t a;

    private t() {
    }

    protected static synchronized t f() {
        t tVar;
        synchronized (t.class) {
            try {
                if (a == null) {
                    a = new t();
                }
                tVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_vc_trace_sampling_rate";
    }

    protected Double d() {
        return Double.valueOf(1.0d);
    }

    protected Double e() {
        return Double.valueOf(d().doubleValue() / 1000.0d);
    }
}
