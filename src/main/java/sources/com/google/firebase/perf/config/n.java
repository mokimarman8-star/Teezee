package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class n extends u {
    private static n a;

    private n() {
    }

    public static synchronized n e() {
        n nVar;
        synchronized (n.class) {
            try {
                if (a == null) {
                    a = new n();
                }
                nVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "sessions_max_length_minutes";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_session_max_duration_min";
    }

    protected Long d() {
        return 240L;
    }
}
