package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f extends u {
    private static f a;

    private f() {
    }

    public static synchronized f e() {
        f fVar;
        synchronized (f.class) {
            try {
                if (a == null) {
                    a = new f();
                }
                fVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_rl_network_event_count_bg";
    }

    protected Long d() {
        return 70L;
    }
}
