package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h extends u {
    private static h a;

    private h() {
    }

    protected static synchronized h f() {
        h hVar;
        synchronized (h.class) {
            try {
                if (a == null) {
                    a = new h();
                }
                hVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_vc_network_request_sampling_rate";
    }

    protected Double d() {
        return Double.valueOf(1.0d);
    }

    protected Double e() {
        return Double.valueOf(d().doubleValue() / 1000.0d);
    }
}
