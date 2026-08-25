package com.google.firebase.perf.config;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b extends u {
    private static b a;

    private b() {
    }

    protected static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            try {
                if (a == null) {
                    a = new b();
                }
                bVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String b() {
        return "firebase_performance_collection_deactivated";
    }

    protected Boolean d() {
        return Boolean.FALSE;
    }
}
