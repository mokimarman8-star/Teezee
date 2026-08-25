package zq;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.media.session.c;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public static final b a = new b();
    private static final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private static final Lazy c = LazyKt.b(new Function0() { // from class: zq.a
        public final Object invoke() {
            CopyOnWriteArrayList b2;
            b2 = b.b();
            return b2;
        }
    });
    private static int d;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList b() {
        return new CopyOnWriteArrayList();
    }

    private final void c(boolean z, Activity activity) {
        jg.b.a.j(Boolean.valueOf(z));
        Iterator it = f().iterator();
        if (it.hasNext()) {
            c.a(it.next());
            throw null;
        }
    }

    private final void d() {
        try {
            Iterator it = b.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                Activity activity = (Activity) it.next();
                try {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        it.remove();
                    }
                } catch (Exception unused) {
                    it.remove();
                }
            }
        } catch (Exception unused2) {
        }
    }

    private final List f() {
        return (List) c.getValue();
    }

    public final List e() {
        return b;
    }

    public final Activity g() {
        return h(0);
    }

    public final Activity h(int i) {
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

    public final void i(int i, Activity activity) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityCreated  activity:" + activity);
        b.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityDestroyed  activity:" + activity);
        try {
            b.remove(activity);
        } catch (Exception unused) {
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
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityPaused  activity:" + activity);
        if (b.size() > 5) {
            d();
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
        Log.e("yy", "onActivityStarted  activity:" + activity);
        int i = d + 1;
        d = i;
        if (i == 1) {
            c(false, activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
        Log.e("yy", "onActivityStopped  activity:" + activity);
        int i = d + (-1);
        d = i;
        if (i == 0) {
            c(true, activity);
        }
    }
}
