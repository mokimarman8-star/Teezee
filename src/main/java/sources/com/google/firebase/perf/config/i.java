package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class i extends u {
    private static i a;

    private i() {
    }

    public static synchronized i e() {
        i iVar;
        synchronized (i.class) {
            try {
                if (a == null) {
                    a = new i();
                }
                iVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_rl_time_limit_sec";
    }

    protected Long d() {
        return 600L;
    }
}
