package com.cloud.sdk.commonutil.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class m {
    private static WeakReference a = new WeakReference(null);
    private static boolean b = false;
    private static b c = null;

    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m.a.clear();
            WeakReference unused = m.a = new WeakReference(activity);
            try {
                if (m.c == null || activity == null) {
                    return;
                }
                m.c.a(activity.getClass().getSimpleName());
            } catch (Throwable unused2) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public interface b {
        void a(String str);
    }

    private static List d() {
        Object e;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            e = e();
        } catch (Exception e2) {
            c.Log().e("LifecycleUtil", "getActivitiesByReflect: " + e2.getMessage());
        }
        if (e == null) {
            return linkedList;
        }
        Field declaredField = e.getClass().getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(e);
        if (!(obj instanceof Map)) {
            return linkedList;
        }
        for (Object obj2 : ((Map) obj).values()) {
            Class<?> cls = obj2.getClass();
            Field declaredField2 = cls.getDeclaredField("activity");
            declaredField2.setAccessible(true);
            Activity activity2 = (Activity) declaredField2.get(obj2);
            if (activity == null) {
                Field declaredField3 = cls.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (declaredField3.getBoolean(obj2)) {
                    linkedList.add(activity2);
                } else {
                    activity = activity2;
                }
            } else {
                linkedList.add(activity2);
            }
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    private static Object e() {
        Object f = f();
        return f != null ? f : g();
    }

    private static Object f() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            c.Log().e("LifecycleUtil", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private static Object g() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e) {
            c.Log().e("LifecycleUtil", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    public static Activity h() {
        WeakReference weakReference = a;
        Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
        if (i(activity)) {
            c.Log().i("LifecycleUtil", "topActivity = " + activity.getClass().getSimpleName());
            return activity;
        }
        c.Log().i("LifecycleUtil", "getActivitiesByReflect");
        for (Activity activity2 : d()) {
            if (i(activity2)) {
                c.Log().i("LifecycleUtil", "getActivitiesByReflect topActivity = " + activity2.getClass().getSimpleName());
                return activity2;
            }
        }
        c.Log().i("LifecycleUtil", "Did not get topActivity");
        return null;
    }

    private static boolean i(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static void j(Application application) {
        if (application == null || b) {
            return;
        }
        b = true;
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void k(b bVar) {
        c = bVar;
    }
}
