package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.g;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.e;
import com.google.firebase.perf.util.h;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private static final uc.a r = uc.a.e();
    private static volatile a s;
    private final WeakHashMap a;
    private final WeakHashMap b;
    private final WeakHashMap c;
    private final WeakHashMap d;
    private final Map e;
    private final Set f;
    private Set g;
    private final AtomicInteger h;
    private final k i;
    private final com.google.firebase.perf.config.a j;
    private final com.google.firebase.perf.util.a k;
    private final boolean l;
    private Timer m;
    private Timer n;
    private ApplicationProcessState o;
    private boolean p;
    private boolean q;

    /* renamed from: com.google.firebase.perf.application.a$a, reason: collision with other inner class name */
    public interface InterfaceC0042a {
        void a();
    }

    public interface b {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    a(k kVar, com.google.firebase.perf.util.a aVar) {
        this(kVar, aVar, com.google.firebase.perf.config.a.g(), g());
    }

    a(k kVar, com.google.firebase.perf.util.a aVar, com.google.firebase.perf.config.a aVar2, boolean z) {
        this.a = new WeakHashMap();
        this.b = new WeakHashMap();
        this.c = new WeakHashMap();
        this.d = new WeakHashMap();
        this.e = new HashMap();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new AtomicInteger(0);
        this.o = ApplicationProcessState.BACKGROUND;
        this.p = false;
        this.q = true;
        this.i = kVar;
        this.k = aVar;
        this.j = aVar2;
        this.l = z;
    }

    public static a b() {
        if (s == null) {
            synchronized (a.class) {
                try {
                    if (s == null) {
                        s = new a(k.k(), new com.google.firebase.perf.util.a());
                    }
                } finally {
                }
            }
        }
        return s;
    }

    public static String c(Activity activity) {
        return "_st_" + activity.getClass().getSimpleName();
    }

    private static boolean g() {
        return d.a();
    }

    private void l() {
        synchronized (this.g) {
            try {
                for (InterfaceC0042a interfaceC0042a : this.g) {
                    if (interfaceC0042a != null) {
                        interfaceC0042a.a();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m(Activity activity) {
        Trace trace = (Trace) this.d.get(activity);
        if (trace == null) {
            return;
        }
        this.d.remove(activity);
        e e = ((d) this.b.get(activity)).e();
        if (!e.d()) {
            r.k("Failed to record frame data for %s.", activity.getClass().getSimpleName());
        } else {
            h.a(trace, (g.a) e.c());
            trace.stop();
        }
    }

    private void n(String str, Timer timer, Timer timer2) {
        if (this.j.K()) {
            i.b j = i.M().r(str).p(timer.getMicros()).q(timer.getDurationMicros(timer2)).j(SessionManager.getInstance().perfSession().build());
            int andSet = this.h.getAndSet(0);
            synchronized (this.e) {
                try {
                    j.l(this.e);
                    if (andSet != 0) {
                        j.n(Constants.CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
                    }
                    this.e.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.i.C((i) j.mo53build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    private void o(Activity activity) {
        if (h() && this.j.K()) {
            d dVar = new d(activity);
            this.b.put(activity, dVar);
            if (activity instanceof FragmentActivity) {
                c cVar = new c(this.k, this.i, this, dVar);
                this.c.put(activity, cVar);
                ((FragmentActivity) activity).getSupportFragmentManager().p1(cVar, true);
            }
        }
    }

    private void q(ApplicationProcessState applicationProcessState) {
        this.o = applicationProcessState;
        synchronized (this.f) {
            try {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.onUpdateAppState(this.o);
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ApplicationProcessState a() {
        return this.o;
    }

    public void d(String str, long j) {
        synchronized (this.e) {
            try {
                Long l = (Long) this.e.get(str);
                if (l == null) {
                    this.e.put(str, Long.valueOf(j));
                } else {
                    this.e.put(str, Long.valueOf(l.longValue() + j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(int i) {
        this.h.addAndGet(i);
    }

    public boolean f() {
        return this.q;
    }

    protected boolean h() {
        return this.l;
    }

    public synchronized void i(Context context) {
        if (this.p) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.p = true;
        }
    }

    public void j(InterfaceC0042a interfaceC0042a) {
        synchronized (this.g) {
            this.g.add(interfaceC0042a);
        }
    }

    public void k(WeakReference weakReference) {
        synchronized (this.f) {
            this.f.add(weakReference);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        o(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.b.remove(activity);
        if (this.c.containsKey(activity)) {
            ((FragmentActivity) activity).getSupportFragmentManager().N1((FragmentManager.k) this.c.remove(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        try {
            if (this.a.isEmpty()) {
                this.m = this.k.a();
                this.a.put(activity, Boolean.TRUE);
                if (this.q) {
                    q(ApplicationProcessState.FOREGROUND);
                    l();
                    this.q = false;
                } else {
                    n(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString(), this.n, this.m);
                    q(ApplicationProcessState.FOREGROUND);
                }
            } else {
                this.a.put(activity, Boolean.TRUE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        try {
            if (h() && this.j.K()) {
                if (!this.b.containsKey(activity)) {
                    o(activity);
                }
                ((d) this.b.get(activity)).c();
                Trace trace = new Trace(c(activity), this.i, this.k, this);
                trace.start();
                this.d.put(activity, trace);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        try {
            if (h()) {
                m(activity);
            }
            if (this.a.containsKey(activity)) {
                this.a.remove(activity);
                if (this.a.isEmpty()) {
                    this.n = this.k.a();
                    n(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString(), this.m, this.n);
                    q(ApplicationProcessState.BACKGROUND);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void p(WeakReference weakReference) {
        synchronized (this.f) {
            this.f.remove(weakReference);
        }
    }
}
