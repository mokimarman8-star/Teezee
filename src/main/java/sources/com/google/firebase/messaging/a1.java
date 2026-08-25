package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a1 {
    private static WeakReference d;
    private final SharedPreferences a;
    private x0 b;
    private final Executor c;

    private a1(SharedPreferences sharedPreferences, Executor executor) {
        this.c = executor;
        this.a = sharedPreferences;
    }

    public static synchronized a1 b(Context context, Executor executor) {
        a1 a1Var;
        synchronized (a1.class) {
            try {
                WeakReference weakReference = d;
                a1Var = weakReference != null ? (a1) weakReference.get() : null;
                if (a1Var == null) {
                    a1Var = new a1(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    a1Var.d();
                    d = new WeakReference(a1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a1Var;
    }

    private synchronized void d() {
        this.b = x0.d(this.a, "topic_operation_queue", ",", this.c);
    }

    synchronized boolean a(z0 z0Var) {
        return this.b.b(z0Var.e());
    }

    synchronized z0 c() {
        return z0.a(this.b.f());
    }

    synchronized boolean e(z0 z0Var) {
        return this.b.g(z0Var.e());
    }
}
