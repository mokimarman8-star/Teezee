package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.f;
import com.google.firebase.messaging.y0;
import hc.d;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import jc.a;
import kc.b;
import lc.e;
import t8.i;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseMessaging {
    private static y0 m;
    static ScheduledExecutorService o;
    private final f a;
    private final Context b;
    private final e0 c;
    private final u0 d;
    private final a e;
    private final Executor f;
    private final Executor g;
    private final Task h;
    private final j0 i;
    private boolean j;
    private final Application.ActivityLifecycleCallbacks k;
    private static final long l = TimeUnit.HOURS.toSeconds(8);
    static b n = new b() { // from class: com.google.firebase.messaging.q
        public final Object get() {
            i H;
            H = FirebaseMessaging.H();
            return H;
        }
    };

    FirebaseMessaging(f fVar, a aVar, b bVar, d dVar, j0 j0Var, e0 e0Var, Executor executor, Executor executor2, Executor executor3) {
        this.j = false;
        n = bVar;
        this.a = fVar;
        this.e = new a(this, dVar);
        Context k = fVar.k();
        this.b = k;
        Application.ActivityLifecycleCallbacks pVar = new p();
        this.k = pVar;
        this.i = j0Var;
        this.c = e0Var;
        this.d = new u0(executor);
        this.f = executor2;
        this.g = executor3;
        Context k2 = fVar.k();
        if (k2 instanceof Application) {
            ((Application) k2).registerActivityLifecycleCallbacks(pVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + k2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new u(this));
        }
        executor2.execute(new v(this));
        Task f = c1.f(this, j0Var, e0Var, k, n.g());
        this.h = f;
        f.addOnSuccessListener(executor2, new w(this));
        executor2.execute(new x(this));
    }

    FirebaseMessaging(f fVar, a aVar, b bVar, b bVar2, e eVar, b bVar3, d dVar) {
        this(fVar, aVar, bVar, bVar2, eVar, bVar3, dVar, new j0(fVar.k()));
    }

    FirebaseMessaging(f fVar, a aVar, b bVar, b bVar2, e eVar, b bVar3, d dVar, j0 j0Var) {
        this(fVar, aVar, bVar3, dVar, j0Var, new e0(fVar, j0Var, bVar, bVar2, eVar), n.f(), n.c(), n.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task A(String str, y0.a aVar, String str2) {
        q(this.b).f(r(), str, str2, this.i.a());
        if (aVar == null || !str2.equals(aVar.a)) {
            x(str2);
        }
        return Tasks.forResult(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task B(String str, y0.a aVar) {
        return this.c.f().onSuccessTask(this.g, new z(this, str, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(m());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(CloudMessage cloudMessage) {
        if (cloudMessage != null) {
            i0.y(cloudMessage.getIntent());
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (y()) {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(c1 c1Var) {
        if (y()) {
            c1Var.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i H() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task I(String str, c1 c1Var) {
        return c1Var.r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task J(String str, c1 c1Var) {
        return c1Var.u(str);
    }

    private boolean L() {
        p0.c(this.b);
        if (!p0.d(this.b)) {
            return false;
        }
        if (this.a.j(mb.a.class) != null) {
            return true;
        }
        return i0.a() && n != null;
    }

    private synchronized void M() {
        if (!this.j) {
            P(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (Q(t())) {
            M();
        }
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.j(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static synchronized FirebaseMessaging p() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(f.l());
        }
        return firebaseMessaging;
    }

    private static synchronized y0 q(Context context) {
        y0 y0Var;
        synchronized (FirebaseMessaging.class) {
            try {
                if (m == null) {
                    m = new y0(context);
                }
                y0Var = m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return y0Var;
    }

    private String r() {
        return "[DEFAULT]".equals(this.a.m()) ? "" : this.a.o();
    }

    public static i u() {
        return (i) n.get();
    }

    private void v() {
        this.c.e().addOnSuccessListener(this.f, new y(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void G() {
        p0.c(this.b);
        r0.g(this.b, this.c, L());
        if (L()) {
            v();
        }
    }

    private void x(String str) {
        if ("[DEFAULT]".equals(this.a.m())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invoking onNewToken for app: ");
                sb.append(this.a.m());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new m(this.b).k(intent);
        }
    }

    synchronized void K(boolean z) {
        this.j = z;
    }

    public Task O(String str) {
        return this.h.onSuccessTask(new a0(str));
    }

    synchronized void P(long j) {
        n(new SyncTask(this, Math.min(Math.max(30L, 2 * j), l)), j);
        this.j = true;
    }

    boolean Q(y0.a aVar) {
        return aVar == null || aVar.b(this.i.a());
    }

    public Task R(String str) {
        return this.h.onSuccessTask(new r(str));
    }

    String m() {
        y0.a t = t();
        if (!Q(t)) {
            return t.a;
        }
        String c = j0.c(this.a);
        try {
            return (String) Tasks.await(this.d.b(c, new t(this, c, t)));
        } catch (InterruptedException | ExecutionException e) {
            throw new IOException(e);
        }
    }

    void n(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (o == null) {
                    o = new ScheduledThreadPoolExecutor(1, (ThreadFactory) new NamedThreadFactory("TAG"));
                }
                o.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    Context o() {
        return this.b;
    }

    public Task s() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f.execute(new s(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    y0.a t() {
        return q(this.b).d(r(), j0.c(this.a));
    }

    public boolean y() {
        return this.e.c();
    }

    boolean z() {
        return this.i.g();
    }
}
