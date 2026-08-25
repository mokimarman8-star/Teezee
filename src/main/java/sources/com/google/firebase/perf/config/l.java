package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class l extends u {
    private static l a;

    private l() {
    }

    public static synchronized l e() {
        l lVar;
        synchronized (l.class) {
            try {
                if (a == null) {
                    a = new l();
                }
                lVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    protected Long d() {
        return 0L;
    }
}
