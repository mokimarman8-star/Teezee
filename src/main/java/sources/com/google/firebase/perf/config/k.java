package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class k extends u {
    private static k a;

    protected k() {
    }

    protected static synchronized k e() {
        k kVar;
        synchronized (k.class) {
            try {
                if (a == null) {
                    a = new k();
                }
                kVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_enabled";
    }

    protected Boolean d() {
        return Boolean.TRUE;
    }
}
