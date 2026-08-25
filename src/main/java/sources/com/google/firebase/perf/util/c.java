package com.google.firebase.perf.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements ViewTreeObserver.OnDrawListener {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final AtomicReference b;
    private final Runnable c;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(c.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private c(View view, Runnable runnable) {
        this.b = new AtomicReference(view);
        this.c = runnable;
    }

    private static boolean b(View view) {
        return view.getViewTreeObserver().isAlive() && c(view);
    }

    private static boolean c(View view) {
        return view.isAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    public static void e(View view, Runnable runnable) {
        c cVar = new c(view, runnable);
        if (Build.VERSION.SDK_INT >= 26 || b(view)) {
            view.getViewTreeObserver().addOnDrawListener(cVar);
        } else {
            view.addOnAttachStateChangeListener(cVar.new a());
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View view = (View) this.b.getAndSet(null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.firebase.perf.util.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                c.this.d(view);
            }
        });
        this.a.postAtFrontOfQueue(this.c);
    }
}
