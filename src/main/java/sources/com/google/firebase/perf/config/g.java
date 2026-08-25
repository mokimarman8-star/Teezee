package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g extends u {
    private static g a;

    private g() {
    }

    public static synchronized g e() {
        g gVar;
        synchronized (g.class) {
            try {
                if (a == null) {
                    a = new g();
                }
                gVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_rl_network_event_count_fg";
    }

    protected Long d() {
        return 700L;
    }
}
