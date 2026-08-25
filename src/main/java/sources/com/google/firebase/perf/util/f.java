package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final AtomicReference b;
    private final Runnable c;
    private final Runnable d;

    private f(View view, Runnable runnable, Runnable runnable2) {
        this.b = new AtomicReference(view);
        this.c = runnable;
        this.d = runnable2;
    }

    public static void a(View view, Runnable runnable, Runnable runnable2) {
        view.getViewTreeObserver().addOnPreDrawListener(new f(view, runnable, runnable2));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view = (View) this.b.getAndSet(null);
        if (view == null) {
            return true;
        }
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.post(this.c);
        this.a.postAtFrontOfQueue(this.d);
        return true;
    }
}
