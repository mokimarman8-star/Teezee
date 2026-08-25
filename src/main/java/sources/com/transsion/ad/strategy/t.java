package com.transsion.ad.strategy;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import com.transsion.ad.strategy.t;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t {
    public static final t a = new t();
    private static final Rect b = new Rect();
    private static final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private static final Lazy d = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.ad.strategy.k
        public final Object invoke() {
            HandlerThread u;
            u = t.u();
            return u;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.ad.strategy.l
        public final Object invoke() {
            Handler t;
            t = t.t();
            return t;
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.ad.strategy.m
        public final Object invoke() {
            Handler p;
            p = t.p();
            return p;
        }
    });
    private static final Runnable g = new Runnable() { // from class: com.transsion.ad.strategy.n
        @Override // java.lang.Runnable
        public final void run() {
            t.s();
        }
    };

    public interface a {

        /* renamed from: com.transsion.ad.strategy.t$a$a, reason: collision with other inner class name */
        public static final class C0005a {
            public static double a(a aVar) {
                return 10.0d;
            }
        }

        double getVisibilityThreshold();

        View getVisibilityView();

        void onVisibilityChanged(boolean z);
    }

    private t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        a.m().removeCallbacks(g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(a aVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        if (!copyOnWriteArrayList.contains(aVar)) {
            copyOnWriteArrayList.add(aVar);
        }
        if (copyOnWriteArrayList.size() == 1) {
            a.x();
        }
    }

    private final void l(View view, Function1 function1) {
        if (view != null) {
            if (view.getWindowVisibility() != 0) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            if (!view.getGlobalVisibleRect(b) || !view.isShown()) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            double height = r0.height() * r0.width();
            double height2 = view.getHeight() * view.getWidth();
            if (height2 <= 0.0d) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                }
            } else {
                double d2 = (height * 100) / height2;
                if (function1 != null) {
                    function1.invoke(Double.valueOf(d2));
                }
            }
        }
    }

    private final Handler m() {
        return (Handler) e.getValue();
    }

    private final HandlerThread n() {
        return (HandlerThread) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler p() {
        return new Handler(Looper.getMainLooper());
    }

    private final void q() {
        m().removeCallbacks(g);
        for (final a aVar : c) {
            a.l(aVar.getVisibilityView(), new Function1() { // from class: com.transsion.ad.strategy.o
                public final Object invoke(Object obj) {
                    Unit r;
                    r = t.r(t.a.this, ((Double) obj).doubleValue());
                    return r;
                }
            });
        }
        if (c.isEmpty()) {
            return;
        }
        m().postDelayed(g, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(a aVar, double d2) {
        if (d2 >= aVar.getVisibilityThreshold()) {
            aVar.onVisibilityChanged(true);
        } else {
            aVar.onVisibilityChanged(false);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        a.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler t() {
        return new Handler(a.n().getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HandlerThread u() {
        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        return handlerThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(a aVar) {
        c.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
        a.q();
    }

    public final void j(final a aVar) {
        Intrinsics.h(aVar, "listener");
        m().post(new Runnable() { // from class: com.transsion.ad.strategy.p
            @Override // java.lang.Runnable
            public final void run() {
                t.k(t.a.this);
            }
        });
    }

    public final boolean o(View view) {
        if (view == null || view.getWindowVisibility() != 0) {
            return false;
        }
        if (!view.getGlobalVisibleRect(b) || !view.isShown()) {
            return false;
        }
        double height = view.getHeight() * view.getWidth();
        return height > 0.0d && ((r1.height() * r1.width()) * ((double) 100)) / height > 0.0d;
    }

    public final void v(final a aVar) {
        Intrinsics.h(aVar, "listener");
        m().post(new Runnable() { // from class: com.transsion.ad.strategy.q
            @Override // java.lang.Runnable
            public final void run() {
                t.w(t.a.this);
            }
        });
    }

    public final void x() {
        m().post(new Runnable() { // from class: com.transsion.ad.strategy.r
            @Override // java.lang.Runnable
            public final void run() {
                t.y();
            }
        });
    }

    public final void z() {
        m().post(new Runnable() { // from class: com.transsion.ad.strategy.s
            @Override // java.lang.Runnable
            public final void run() {
                t.A();
            }
        });
        q();
    }
}
