package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.d0;
import com.google.firebase.crashlytics.internal.common.g0;
import com.google.firebase.crashlytics.internal.common.k;
import com.google.firebase.crashlytics.internal.common.x;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.f;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kc.a;
import lc.e;
import pb.h;
import qb.d;
import qb.g;
import qb.l;
import wb.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseCrashlytics {
    final x a;

    private FirebaseCrashlytics(x xVar) {
        this.a = xVar;
    }

    static FirebaseCrashlytics b(f fVar, e eVar, a aVar, a aVar2, a aVar3, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3) {
        Context k = fVar.k();
        String packageName = k.getPackageName();
        g.f().g("Initializing Firebase Crashlytics " + x.q() + " for " + packageName);
        CrashlyticsWorkers crashlyticsWorkers = new CrashlyticsWorkers(executorService, executorService2);
        xb.g gVar = new xb.g(k);
        d0 d0Var = new d0(fVar);
        g0 g0Var = new g0(k, packageName, eVar, d0Var);
        d dVar = new d(aVar);
        pb.d dVar2 = new pb.d(aVar2);
        k kVar = new k(d0Var, gVar);
        FirebaseSessionsDependencies.e(kVar);
        x xVar = new x(fVar, g0Var, dVar, d0Var, dVar2.e(), dVar2.d(), gVar, kVar, new l(aVar3), crashlyticsWorkers);
        String c = fVar.n().c();
        String m = CommonUtils.m(k);
        List<com.google.firebase.crashlytics.internal.common.e> j = CommonUtils.j(k);
        g.f().b("Mapping file ID is: " + m);
        for (com.google.firebase.crashlytics.internal.common.e eVar2 : j) {
            g.f().b(String.format("Build id for %s on %s: %s", eVar2.c(), eVar2.a(), eVar2.b()));
        }
        try {
            com.google.firebase.crashlytics.internal.common.a a = com.google.firebase.crashlytics.internal.common.a.a(k, g0Var, c, m, j, new qb.f(k));
            g.f().i("Installer package name is: " + a.d);
            com.google.firebase.crashlytics.internal.settings.e l = com.google.firebase.crashlytics.internal.settings.e.l(k, c, g0Var, new b(), a.f, a.g, gVar, d0Var);
            l.o(crashlyticsWorkers).addOnFailureListener(executorService3, new h());
            if (xVar.F(a, l)) {
                xVar.o(l);
            }
            return new FirebaseCrashlytics(xVar);
        } catch (PackageManager.NameNotFoundException e) {
            g.f().e("Error retrieving app package info.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
        g.f().e("Error fetching settings.", exc);
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) f.l().j(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.a.j();
    }

    public void deleteUnsentReports() {
        this.a.k();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.a.l();
    }

    public boolean isCrashlyticsCollectionEnabled() {
        return this.a.s();
    }

    public void log(@NonNull String str) {
        this.a.B(str);
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            g.f().k("A null value was passed to recordException. Ignoring.");
        } else {
            this.a.C(th);
        }
    }

    public void sendUnsentReports() {
        this.a.G();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.a.H(bool);
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.a.H(Boolean.valueOf(z));
    }

    public void setCustomKey(@NonNull String str, double d) {
        this.a.I(str, Double.toString(d));
    }

    public void setCustomKey(@NonNull String str, float f) {
        this.a.I(str, Float.toString(f));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.a.I(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j) {
        this.a.I(str, Long.toString(j));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.a.I(str, str2);
    }

    public void setCustomKey(@NonNull String str, boolean z) {
        this.a.I(str, Boolean.toString(z));
    }

    public void setCustomKeys(@NonNull pb.g gVar) {
        throw null;
    }

    public void setUserId(@NonNull String str) {
        this.a.J(str);
    }
}
