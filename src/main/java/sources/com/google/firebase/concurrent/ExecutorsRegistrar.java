package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kc.b;
import nb.a;
import nb.d;
import ob.b0;
import ob.c;
import ob.e;
import ob.h;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final ob.u a = new ob.u(new b() { // from class: com.google.firebase.concurrent.r
        public final Object get() {
            ScheduledExecutorService p;
            p = ExecutorsRegistrar.p();
            return p;
        }
    });
    static final ob.u b = new ob.u(new b() { // from class: com.google.firebase.concurrent.s
        public final Object get() {
            ScheduledExecutorService q;
            q = ExecutorsRegistrar.q();
            return q;
        }
    });
    static final ob.u c = new ob.u(new b() { // from class: com.google.firebase.concurrent.t
        public final Object get() {
            ScheduledExecutorService r;
            r = ExecutorsRegistrar.r();
            return r;
        }
    });
    static final ob.u d = new ob.u(new b() { // from class: com.google.firebase.concurrent.u
        public final Object get() {
            ScheduledExecutorService s;
            s = ExecutorsRegistrar.s();
            return s;
        }
    });

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i = Build.VERSION.SDK_INT;
        detectNetwork.detectResourceMismatches();
        if (i >= 26) {
            q.a(detectNetwork);
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i) {
        return new b(str, i, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory k(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i, threadPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService l(e eVar) {
        return (ScheduledExecutorService) a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService m(e eVar) {
        return (ScheduledExecutorService) c.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService n(e eVar) {
        return (ScheduledExecutorService) b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor o(e eVar) {
        return UiExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.f(b0.a(a.class, ScheduledExecutorService.class), new b0[]{b0.a(a.class, ExecutorService.class), b0.a(a.class, Executor.class)}).f(new h() { // from class: com.google.firebase.concurrent.v
            public final Object a(e eVar) {
                ScheduledExecutorService l;
                l = ExecutorsRegistrar.l(eVar);
                return l;
            }
        }).d(), c.f(b0.a(nb.b.class, ScheduledExecutorService.class), new b0[]{b0.a(nb.b.class, ExecutorService.class), b0.a(nb.b.class, Executor.class)}).f(new h() { // from class: com.google.firebase.concurrent.w
            public final Object a(e eVar) {
                ScheduledExecutorService m;
                m = ExecutorsRegistrar.m(eVar);
                return m;
            }
        }).d(), c.f(b0.a(nb.c.class, ScheduledExecutorService.class), new b0[]{b0.a(nb.c.class, ExecutorService.class), b0.a(nb.c.class, Executor.class)}).f(new h() { // from class: com.google.firebase.concurrent.x
            public final Object a(e eVar) {
                ScheduledExecutorService n;
                n = ExecutorsRegistrar.n(eVar);
                return n;
            }
        }).d(), c.e(b0.a(d.class, Executor.class)).f(new h() { // from class: com.google.firebase.concurrent.y
            public final Object a(e eVar) {
                Executor o;
                o = ExecutorsRegistrar.o(eVar);
                return o;
            }
        }).d());
    }
}
