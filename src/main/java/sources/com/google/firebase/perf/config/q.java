package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class q extends u {
    private static q a;

    private q() {
    }

    public static synchronized q f() {
        q qVar;
        synchronized (q.class) {
            try {
                if (a == null) {
                    a = new q();
                }
                qVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_sampling_percentage";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_vc_session_sampling_rate";
    }

    protected Double d() {
        return Double.valueOf(0.01d);
    }

    protected Double e() {
        return Double.valueOf(d().doubleValue() / 1000.0d);
    }
}
