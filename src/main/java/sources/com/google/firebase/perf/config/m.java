package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m extends u {
    private static m a;

    private m() {
    }

    public static synchronized m f() {
        m mVar;
        synchronized (m.class) {
            try {
                if (a == null) {
                    a = new m();
                }
                mVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }

    protected Long d() {
        return 100L;
    }

    protected Long e() {
        return Long.valueOf(d().longValue() * 3);
    }
}
