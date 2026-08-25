package com.google.firebase.perf.metrics;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.google.firebase.f;
import com.google.firebase.n;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.a;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks, t {
    private static volatile AppStartTrace A;
    private static ExecutorService B;
    private static final Timer y = new a().a();
    private static final long z = TimeUnit.MINUTES.toMicros(1);
    private final k b;
    private final a c;
    private final com.google.firebase.perf.config.a d;
    private final i.b e;
    private Context f;
    private WeakReference g;
    private WeakReference h;
    private final Timer j;
    private final Timer k;
    private PerfSession t;
    private boolean a = false;
    private boolean i = false;
    private Timer l = null;
    private Timer m = null;
    private Timer n = null;
    private Timer o = null;
    private Timer p = null;
    private Timer q = null;
    private Timer r = null;
    private Timer s = null;
    private boolean u = false;
    private int v = 0;
    private final b w = new b(this, (a) null);
    private boolean x = false;

    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.trace.l == null) {
                this.trace.u = true;
            }
        }
    }

    AppStartTrace(k kVar, a aVar, com.google.firebase.perf.config.a aVar2, ExecutorService executorService) {
        this.b = kVar;
        this.c = aVar;
        this.d = aVar2;
        B = executorService;
        this.e = i.M().r("_experiment_app_start_ttid");
        this.j = Build.VERSION.SDK_INT >= 24 ? Timer.ofElapsedRealtime(a.a()) : null;
        n nVar = (n) f.l().j(n.class);
        this.k = nVar != null ? Timer.ofElapsedRealtime(nVar.b()) : null;
    }

    static /* synthetic */ int h(AppStartTrace appStartTrace) {
        int i = appStartTrace.v;
        appStartTrace.v = i + 1;
        return i;
    }

    private Timer i() {
        Timer timer = this.k;
        return timer != null ? timer : y;
    }

    public static AppStartTrace j() {
        return A != null ? A : k(k.k(), new a());
    }

    static AppStartTrace k(k kVar, a aVar) {
        if (A == null) {
            synchronized (AppStartTrace.class) {
                try {
                    if (A == null) {
                        A = new AppStartTrace(kVar, aVar, com.google.firebase.perf.config.a.g(), new ThreadPoolExecutor(0, 1, z + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                    }
                } finally {
                }
            }
        }
        return A;
    }

    private Timer l() {
        Timer timer = this.j;
        return timer != null ? timer : i();
    }

    public static boolean m(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        String str = packageName + ":";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals(packageName) || runningAppProcessInfo.processName.startsWith(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(i.b bVar) {
        this.b.C(bVar.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        i.b q = i.M().r(Constants$TraceNames.APP_START_TRACE_NAME.toString()).p(i().getMicros()).q(i().getDurationMicros(this.n));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(i.M().r(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString()).p(i().getMicros()).q(i().getDurationMicros(this.l)).build());
        if (this.m != null) {
            i.b M = i.M();
            M.r(Constants$TraceNames.ON_START_TRACE_NAME.toString()).p(this.l.getMicros()).q(this.l.getDurationMicros(this.m));
            arrayList.add(M.build());
            i.b M2 = i.M();
            M2.r(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString()).p(this.m.getMicros()).q(this.m.getDurationMicros(this.n));
            arrayList.add(M2.build());
        }
        q.h(arrayList).j(this.t.build());
        this.b.C(q.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void p(i.b bVar) {
        if (this.q == null || this.r == null || this.s == null) {
            return;
        }
        B.execute(new f(this, bVar));
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.s != null) {
            return;
        }
        this.s = this.c.a();
        this.e.k(i.M().r("_experiment_onDrawFoQ").p(l().getMicros()).q(l().getDurationMicros(this.s)).build());
        if (this.j != null) {
            this.e.k(i.M().r("_experiment_procStart_to_classLoad").p(l().getMicros()).q(l().getDurationMicros(i())).build());
        }
        this.e.o("systemDeterminedForeground", this.x ? "true" : "false");
        this.e.n("onDrawCount", this.v);
        this.e.j(this.t.build());
        p(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.q != null) {
            return;
        }
        this.q = this.c.a();
        this.e.p(l().getMicros()).q(l().getDurationMicros(this.q));
        p(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.r != null) {
            return;
        }
        this.r = this.c.a();
        this.e.k(i.M().r("_experiment_preDrawFoQ").p(l().getMicros()).q(l().getDurationMicros(this.r)).build());
        p(this.e);
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000a, B:10:0x000f, B:14:0x001d, B:16:0x003e), top: B:2:0x0001 }] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.u     // Catch: java.lang.Throwable -> L1a
            if (r5 != 0) goto L42
            com.google.firebase.perf.util.Timer r5 = r3.l     // Catch: java.lang.Throwable -> L1a
            if (r5 == 0) goto La
            goto L42
        La:
            boolean r5 = r3.x     // Catch: java.lang.Throwable -> L1a
            r0 = 1
            if (r5 != 0) goto L1c
            android.content.Context r5 = r3.f     // Catch: java.lang.Throwable -> L1a
            boolean r5 = m(r5)     // Catch: java.lang.Throwable -> L1a
            if (r5 == 0) goto L18
            goto L1c
        L18:
            r5 = 0
            goto L1d
        L1a:
            r4 = move-exception
            goto L44
        L1c:
            r5 = r0
        L1d:
            r3.x = r5     // Catch: java.lang.Throwable -> L1a
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> L1a
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L1a
            r3.g = r5     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.a r4 = r3.c     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r4 = r4.a()     // Catch: java.lang.Throwable -> L1a
            r3.l = r4     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r4 = r3.l()     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r5 = r3.l     // Catch: java.lang.Throwable -> L1a
            long r4 = r4.getDurationMicros(r5)     // Catch: java.lang.Throwable -> L1a
            long r1 = com.google.firebase.perf.metrics.AppStartTrace.z     // Catch: java.lang.Throwable -> L1a
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L40
            r3.i = r0     // Catch: java.lang.Throwable -> L1a
        L40:
            monitor-exit(r3)
            return
        L42:
            monitor-exit(r3)
            return
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1a
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        View findViewById;
        if (this.u || this.i || !this.d.h() || (findViewById = activity.findViewById(R.id.content)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeOnDrawListener(this.w);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        View findViewById;
        try {
            if (!this.u && !this.i) {
                boolean h = this.d.h();
                if (h && (findViewById = activity.findViewById(R.id.content)) != null) {
                    findViewById.getViewTreeObserver().addOnDrawListener(this.w);
                    com.google.firebase.perf.util.c.e(findViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.q();
                        }
                    });
                    com.google.firebase.perf.util.f.a(findViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.r();
                        }
                    }, new Runnable() { // from class: com.google.firebase.perf.metrics.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.s();
                        }
                    });
                }
                if (this.n != null) {
                    return;
                }
                this.h = new WeakReference(activity);
                this.n = this.c.a();
                this.t = SessionManager.getInstance().perfSession();
                uc.a.e().a("onResume(): " + activity.getClass().getName() + ": " + i().getDurationMicros(this.n) + " microseconds");
                B.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppStartTrace.this.o();
                    }
                });
                if (!h) {
                    u();
                }
            }
        } finally {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.u && this.m == null && !this.i) {
            this.m = this.c.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Keep
    @d0(Lifecycle.Event.ON_STOP)
    public void onAppEnteredBackground() {
        if (this.u || this.i || this.p != null) {
            return;
        }
        this.p = this.c.a();
        this.e.k(i.M().r("_experiment_firstBackgrounding").p(l().getMicros()).q(l().getDurationMicros(this.p)).build());
    }

    @Keep
    @d0(Lifecycle.Event.ON_START)
    public void onAppEnteredForeground() {
        if (this.u || this.i || this.o != null) {
            return;
        }
        this.o = this.c.a();
        this.e.k(i.M().r("_experiment_firstForegrounding").p(l().getMicros()).q(l().getDurationMicros(this.o)).build());
    }

    public synchronized void t(Context context) {
        boolean z2;
        try {
            if (this.a) {
                return;
            }
            g0.l().getLifecycle().a(this);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                if (!this.x && !m(applicationContext)) {
                    z2 = false;
                    this.x = z2;
                    this.a = true;
                    this.f = applicationContext;
                }
                z2 = true;
                this.x = z2;
                this.a = true;
                this.f = applicationContext;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u() {
        if (this.a) {
            g0.l().getLifecycle().d(this);
            ((Application) this.f).unregisterActivityLifecycleCallbacks(this);
            this.a = false;
        }
    }
}
