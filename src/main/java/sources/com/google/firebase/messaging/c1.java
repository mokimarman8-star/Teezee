package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class c1 {
    private static final long i = TimeUnit.HOURS.toSeconds(8);
    private final Context a;
    private final j0 b;
    private final e0 c;
    private final FirebaseMessaging d;
    private final ScheduledExecutorService f;
    private final a1 h;
    private final Map e = new androidx.collection.a();
    private boolean g = false;

    private c1(FirebaseMessaging firebaseMessaging, j0 j0Var, a1 a1Var, e0 e0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.d = firebaseMessaging;
        this.b = j0Var;
        this.h = a1Var;
        this.c = e0Var;
        this.a = context;
        this.f = scheduledExecutorService;
    }

    private void b(z0 z0Var, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.e) {
            try {
                String e = z0Var.e();
                if (this.e.containsKey(e)) {
                    arrayDeque = (ArrayDeque) this.e.get(e);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.e.put(e, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void c(Task task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e2);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void d(String str) {
        c(this.c.m(this.d.m(), str));
    }

    private void e(String str) {
        c(this.c.n(this.d.m(), str));
    }

    static Task f(final FirebaseMessaging firebaseMessaging, final j0 j0Var, final e0 e0Var, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.b1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                c1 j;
                j = c1.j(context, scheduledExecutorService, firebaseMessaging, j0Var, e0Var);
                return j;
            }
        });
    }

    static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, j0 j0Var, e0 e0Var) {
        return new c1(firebaseMessaging, j0Var, a1.b(context, scheduledExecutorService), e0Var, context, scheduledExecutorService);
    }

    private void k(z0 z0Var) {
        synchronized (this.e) {
            try {
                String e = z0Var.e();
                if (this.e.containsKey(e)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.e.get(e);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult((Object) null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.e.remove(e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void p() {
        if (i()) {
            return;
        }
        t(0L);
    }

    boolean g() {
        return this.h.c() != null;
    }

    synchronized boolean i() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: IOException -> 0x001d, TryCatch #0 {IOException -> 0x001d, blocks: (B:3:0x0001, B:12:0x0030, B:14:0x0036, B:17:0x0049, B:19:0x0056, B:20:0x006b, B:22:0x0078, B:23:0x0013, B:26:0x001f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean l(z0 z0Var) {
        char c;
        try {
            String b = z0Var.b();
            int hashCode = b.hashCode();
            if (hashCode == 83) {
                if (b.equals("S")) {
                    c = 0;
                    if (c != 0) {
                    }
                    return true;
                }
                c = 65535;
                if (c != 0) {
                }
                return true;
            }
            if (hashCode == 85 && b.equals("U")) {
                c = 1;
                if (c != 0) {
                    d(z0Var.c());
                    if (h()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Subscribe to topic: ");
                        sb2.append(z0Var.c());
                        sb2.append(" succeeded.");
                    }
                } else if (c == 1) {
                    e(z0Var.c());
                    if (h()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Unsubscribe from topic: ");
                        sb3.append(z0Var.c());
                        sb3.append(" succeeded.");
                    }
                } else if (h()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Unknown topic operation");
                    sb4.append(z0Var);
                    sb4.append(".");
                }
                return true;
            }
            c = 65535;
            if (c != 0) {
            }
            return true;
        } catch (IOException e) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e.getMessage()) && !"TOO_MANY_SUBSCRIBERS".equals(e.getMessage())) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            Log.e("FirebaseMessaging", "Topic operation failed: " + e.getMessage() + ". Will retry Topic operation.");
            return false;
        }
    }

    void m(Runnable runnable, long j) {
        this.f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    Task n(z0 z0Var) {
        this.h.a(z0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(z0Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    synchronized void o(boolean z) {
        this.g = z;
    }

    void q() {
        if (g()) {
            p();
        }
    }

    Task r(String str) {
        Task n = n(z0.f(str));
        q();
        return n;
    }

    boolean s() {
        while (true) {
            synchronized (this) {
                try {
                    z0 c = this.h.c();
                    if (c == null) {
                        h();
                        return true;
                    }
                    if (!l(c)) {
                        return false;
                    }
                    this.h.e(c);
                    k(c);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    void t(long j) {
        m(new TopicsSyncTask(this, this.a, this.b, Math.min(Math.max(30L, 2 * j), i)), j);
        o(true);
    }

    Task u(String str) {
        Task n = n(z0.g(str));
        q();
        return n;
    }
}
