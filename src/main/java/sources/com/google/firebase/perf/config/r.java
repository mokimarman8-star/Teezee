package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class r extends u {
    private static r a;

    private r() {
    }

    public static synchronized r e() {
        r rVar;
        synchronized (r.class) {
            try {
                if (a == null) {
                    a = new r();
                }
                rVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_rl_trace_event_count_bg";
    }

    protected Long d() {
        return 30L;
    }
}
