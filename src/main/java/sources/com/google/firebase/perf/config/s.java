package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class s extends u {
    private static s a;

    private s() {
    }

    public static synchronized s e() {
        s sVar;
        synchronized (s.class) {
            try {
                if (a == null) {
                    a = new s();
                }
                sVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_rl_trace_event_count_fg";
    }

    protected Long d() {
        return 300L;
    }
}
