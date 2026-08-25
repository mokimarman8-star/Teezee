package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class p extends u {
    private static p a;

    private p() {
    }

    public static synchronized p f() {
        p pVar;
        synchronized (p.class) {
            try {
                if (a == null) {
                    a = new p();
                }
                pVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    protected Long d() {
        return 100L;
    }

    protected Long e() {
        return Long.valueOf(d().longValue() * 3);
    }
}
