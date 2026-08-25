package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class o extends u {
    private static o a;

    private o() {
    }

    public static synchronized o e() {
        o oVar;
        synchronized (o.class) {
            try {
                if (a == null) {
                    a = new o();
                }
                oVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    protected Long d() {
        return 0L;
    }
}
