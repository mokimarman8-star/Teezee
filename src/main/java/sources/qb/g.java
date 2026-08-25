package qb;

import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    static final g c = new g("FirebaseCrashlytics");
    private final String a;
    private int b = 4;

    public g(String str) {
        this.a = str;
    }

    private boolean a(int i) {
        return this.b <= i || Log.isLoggable(this.a, i);
    }

    public static g f() {
        return c;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        a(3);
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        a(4);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.a, str, th);
        }
    }
}
