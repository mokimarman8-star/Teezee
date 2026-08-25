package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import qb.l;
import rb.a;
import sb.b;
import tb.e;
import tb.o;
import xb.g;
import zb.c;
import zb.d;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class x {
    private final Context a;
    private final f b;
    private final d0 c;
    private y f;
    private y g;
    private boolean h;
    private n i;
    private final g0 j;
    private final g k;
    public final b l;
    private final a m;
    private final k n;
    private final qb.a o;
    private final l p;
    private final CrashlyticsWorkers q;
    private final long e = System.currentTimeMillis();
    private final l0 d = new l0();

    public x(f fVar, g0 g0Var, qb.a aVar, d0 d0Var, b bVar, a aVar2, g gVar, k kVar, l lVar, CrashlyticsWorkers crashlyticsWorkers) {
        this.b = fVar;
        this.c = d0Var;
        this.a = fVar.k();
        this.j = g0Var;
        this.o = aVar;
        this.l = bVar;
        this.m = aVar2;
        this.k = gVar;
        this.n = kVar;
        this.p = lVar;
        this.q = crashlyticsWorkers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        this.i.Y(str);
    }

    private void i() {
        try {
            this.h = Boolean.TRUE.equals((Boolean) this.q.a.c().submit((Callable) new s(this)).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void v(yb.b bVar) {
        CrashlyticsWorkers.c();
        E();
        try {
            try {
                this.l.a(new v(this));
                this.i.U();
            } catch (Exception e) {
                qb.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e);
            }
            if (!bVar.b().b.a) {
                qb.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
                throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
            }
            if (!this.i.A(bVar)) {
                qb.g.f().k("Previous sessions could not be finalized.");
            }
            this.i.Z(bVar.a());
            D();
        } catch (Throwable th) {
            D();
            throw th;
        }
    }

    private void p(yb.b bVar) {
        Future<?> submit = this.q.a.c().submit((Runnable) new u(this, bVar));
        qb.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            qb.g.f().e("Crashlytics was interrupted during initialization.", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e3) {
            qb.g.f().e("Crashlytics encountered a problem during initialization.", e3);
        } catch (TimeoutException e4) {
            qb.g.f().e("Crashlytics timed out during initialization.", e4);
        }
    }

    public static String q() {
        return "19.3.0";
    }

    static boolean r(String str, boolean z) {
        if (!z) {
            qb.g.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean t() {
        return Boolean.valueOf(this.i.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(long j, String str) {
        this.i.d0(j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(long j, String str) {
        this.q.b.f(new w(this, j, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Throwable th) {
        this.i.c0(Thread.currentThread(), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(String str, String str2) {
        this.i.W(str, str2);
    }

    public void B(String str) {
        this.q.a.f(new t(this, System.currentTimeMillis() - this.e, str));
    }

    public void C(Throwable th) {
        this.q.a.f(new p(this, th));
    }

    void D() {
        CrashlyticsWorkers.c();
        try {
            if (this.f.d()) {
                return;
            }
            qb.g.f().k("Initialization marker file was not properly removed.");
        } catch (Exception e) {
            qb.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e);
        }
    }

    void E() {
        CrashlyticsWorkers.c();
        this.f.a();
        qb.g.f().i("Initialization marker file was created.");
    }

    public boolean F(a aVar, yb.b bVar) {
        if (!r(aVar.b, CommonUtils.i(this.a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String c = new g().c();
        try {
            this.g = new y("crash_marker", this.k);
            this.f = new y("initialization_marker", this.k);
            o oVar = new o(c, this.k, this.q);
            e eVar = new e(this.k);
            zb.a aVar2 = new zb.a(1024, new d[]{new c(10)});
            this.p.c(oVar);
            this.i = new n(this.a, this.j, this.c, this.k, this.g, aVar, oVar, eVar, w0.i(this.a, this.j, this.k, aVar, eVar, oVar, aVar2, bVar, this.d, this.n, this.q), this.o, this.m, this.n, this.q);
            boolean m = m();
            i();
            this.i.y(c, Thread.getDefaultUncaughtExceptionHandler(), bVar);
            if (!m || !CommonUtils.d(this.a)) {
                qb.g.f().b("Successfully configured exception handler.");
                return true;
            }
            qb.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            p(bVar);
            return false;
        } catch (Exception e) {
            qb.g.f().e("Crashlytics was not started due to an exception during initialization", e);
            this.i = null;
            return false;
        }
    }

    public Task G() {
        return this.i.V();
    }

    public void H(Boolean bool) {
        this.c.h(bool);
    }

    public void I(String str, String str2) {
        this.q.a.f(new r(this, str, str2));
    }

    public void J(String str) {
        this.q.a.f(new q(this, str));
    }

    public Task j() {
        return this.i.n();
    }

    public Task k() {
        return this.i.s();
    }

    public boolean l() {
        return this.h;
    }

    boolean m() {
        return this.f.c();
    }

    public Task o(yb.b bVar) {
        return this.q.a.f(new o(this, bVar));
    }

    public boolean s() {
        return this.c.d();
    }
}
