package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d extends u {
    private static d a;

    private d() {
    }

    protected static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            try {
                if (a == null) {
                    a = new d();
                }
                dVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.ExperimentTTID";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "experiment_app_start_ttid";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_experiment_app_start_ttid";
    }

    protected Boolean d() {
        return Boolean.FALSE;
    }
}
