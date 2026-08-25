package uc;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class c {
    private static c a;

    private c() {
    }

    public static synchronized c c() {
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

    void a(String str) {
    }

    void b(String str) {
        Log.e("FirebasePerformance", str);
    }

    void d(String str) {
    }

    void e(String str) {
        Log.w("FirebasePerformance", str);
    }
}
