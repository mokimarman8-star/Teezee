package com.transsion.baselib.report;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import cm.f;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class k implements Application.ActivityLifecycleCallbacks {
    public static final k a = new k();
    private static final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.j
        public final Object invoke() {
            CopyOnWriteArrayList i;
            i = k.i();
            return i;
        }
    });
    private static int d;
    private static long e;
    private static int f;
    private static Boolean g;

    private k() {
    }

    private final void c(Activity activity) {
        int i = d + 1;
        d = i;
        if (i == 1) {
            j(false, activity);
        }
        Log.e("yy", "onActivityStarted  activity:" + activity + "  resumedActivityCount " + d);
    }

    static /* synthetic */ void d(k kVar, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = null;
        }
        kVar.c(activity);
    }

    private final void e(Activity activity) {
        int i = d - 1;
        d = i;
        if (i == 0) {
            j(true, activity);
            e = System.currentTimeMillis();
        }
        Log.e("yy", "onActivityStopped  activity:" + activity + " resumedActivityCount " + d);
    }

    static /* synthetic */ void f(k kVar, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = null;
        }
        kVar.e(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList i() {
        return new CopyOnWriteArrayList();
    }

    private final void j(boolean z, Activity activity) {
        h.a.e(z);
        jg.b.a.j(Boolean.valueOf(z));
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((a) it.next()).onBackgroundStatusChange(z);
        }
    }

    private final void k() {
        try {
            Iterator it = b.iterator();
            Intrinsics.g(it, "iterator(...)");
            int i = 0;
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                try {
                } catch (Exception e3) {
                    a.a.w("RoomActivityLifecycleCallbacks", "check activity state failed, remove it: " + e3.getMessage(), true);
                    it.remove();
                }
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                }
                a.a.c("RoomActivityLifecycleCallbacks", "cleanup destroyed activity: " + activity.getClass().getSimpleName(), true);
                it.remove();
                i++;
            }
            if (i > 0) {
                a.a.c("RoomActivityLifecycleCallbacks", "cleaned " + i + " destroyed activities", true);
            }
        } catch (Exception e4) {
            a.a.i("RoomActivityLifecycleCallbacks", "cleanupDestroyedActivities failed: " + e4.getMessage(), true);
        }
    }

    private final List n() {
        return (List) c.getValue();
    }

    public final int b() {
        return b.size();
    }

    public final boolean g(a aVar) {
        Intrinsics.h(aVar, "listener");
        if (n().contains(aVar)) {
            return false;
        }
        return n().add(aVar);
    }

    public final void h() {
        d(this, null, 1, null);
    }

    public final void l() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        Intrinsics.g(it, "iterator(...)");
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    activity.finish();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        b.clear();
    }

    public final List m() {
        return b;
    }

    public final Activity o() {
        return p(0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityCreated  activity:" + activity);
        if (activity instanceof f) {
            return;
        }
        b.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityDestroyed  activity:" + activity);
        if (activity instanceof f) {
            return;
        }
        try {
            b.remove(activity);
        } catch (Exception e3) {
            a.a.i("RoomActivityLifecycleCallbacks", "remove activity from stack failed: " + e3.getMessage(), true);
            Iterator it = b.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() == activity) {
                    it.remove();
                    break;
                }
            }
        }
        k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityPaused  activity:" + activity);
        if (b.size() > 10) {
            k();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityResumed  activity:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (activity instanceof f) {
            return;
        }
        c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (activity instanceof f) {
            return;
        }
        e(activity);
    }

    public final Activity p(int i) {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList.isEmpty()) {
            return null;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = (size - 1) - i;
        if (i2 < 0 || i2 >= size) {
            return null;
        }
        return (Activity) copyOnWriteArrayList.get(i2);
    }

    public final boolean q() {
        return d == 0;
    }

    public final boolean r() {
        return com.transsion.baselib.report.launch.b.a.b().getLong("record_latest_foreground_time", 0L) == 0;
    }

    public final void s(String str) {
        if (Intrinsics.c(str, "android.intent.action.SCREEN_OFF")) {
            if (f == 0) {
                f = System.currentTimeMillis() - e >= 1000 ? q() : false ? 1 : 2;
            }
        } else if (Intrinsics.c(str, "android.intent.action.USER_PRESENT")) {
            f = 0;
        }
    }

    public final boolean t(a aVar) {
        Intrinsics.h(aVar, "listener");
        return n().remove(aVar);
    }

    public final void u() {
        f(this, null, 1, null);
    }

    public final boolean v() {
        String value;
        Long x;
        Boolean bool = g;
        if (bool != null) {
            return Intrinsics.c(bool, Boolean.TRUE);
        }
        long j = com.transsion.baselib.report.launch.b.a.b().getLong("record_latest_foreground_time", 0L);
        ConfigBean c2 = f.c.a().c("pull_notification_deadline", true);
        long longValue = (c2 == null || (value = c2.getValue()) == null || (x = StringsKt.x(value)) == null) ? 0L : x.longValue();
        long currentTimeMillis = (System.currentTimeMillis() - j) / 86400000;
        a.a.f(a.a, "Report", "latestForegroundTime=" + j + " sleepDays=" + currentTimeMillis + " notificationDeadlineDays=" + longValue, false, 4, (Object) null);
        Boolean valueOf = Boolean.valueOf(j > 0 && currentTimeMillis > longValue);
        g = valueOf;
        return Intrinsics.c(valueOf, Boolean.TRUE);
    }

    public final void w(int i, Activity activity) {
        Intrinsics.h(activity, "activity");
        try {
            CopyOnWriteArrayList copyOnWriteArrayList = b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.c(((Activity) obj).getClass(), activity.getClass())) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size() - i;
            if (size <= 0) {
                return;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ((Activity) arrayList.get(i2)).finish();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
