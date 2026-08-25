package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c extends u {
    private static c a;

    private c() {
    }

    protected static synchronized c d() {
        c cVar;
        synchronized (c.class) {
            try {
                if (a == null) {
                    a = new c();
                }
                cVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "isEnabled";
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "firebase_performance_collection_enabled";
    }
}
