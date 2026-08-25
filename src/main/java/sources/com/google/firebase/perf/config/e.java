package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e extends u {
    private static e a;

    private e() {
    }

    protected static synchronized e e() {
        e eVar;
        synchronized (e.class) {
            try {
                if (a == null) {
                    a = new e();
                }
                eVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.FragmentSamplingRate";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "fragment_sampling_percentage";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_vc_fragment_sampling_rate";
    }

    protected Double d() {
        return Double.valueOf(0.0d);
    }
}
