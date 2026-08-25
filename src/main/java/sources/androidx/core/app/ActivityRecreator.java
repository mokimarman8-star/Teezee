package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class ActivityRecreator {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class f6797a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f6798b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f6799c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f6800d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f6801e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f6802f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f6803g = new Handler(Looper.getMainLooper());

    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f6804a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f6805b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6806c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6807d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f6808e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6809f = false;

        a(Activity activity) {
            this.f6805b = activity;
            this.f6806c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f6805b == activity) {
                this.f6805b = null;
                this.f6808e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f6808e || this.f6809f || this.f6807d || !ActivityRecreator.h(this.f6804a, this.f6806c, activity)) {
                return;
            }
            this.f6809f = true;
            this.f6804a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f6805b == activity) {
                this.f6807d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class a5 = a();
        f6797a = a5;
        f6798b = b();
        f6799c = f();
        f6800d = d(a5);
        f6801e = c(a5);
        f6802f = e(a5);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i5 = Build.VERSION.SDK_INT;
        return i5 == 26 || i5 == 27;
    }

    protected static boolean h(Object obj, int i5, Activity activity) {
        try {
            final Object obj2 = f6799c.get(activity);
            if (obj2 == obj && activity.hashCode() == i5) {
                final Object obj3 = f6798b.get(activity);
                f6803g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Method method = ActivityRecreator.f6800d;
                            if (method != null) {
                                method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.f6801e.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e5) {
                            if (e5.getClass() == RuntimeException.class && e5.getMessage() != null && e5.getMessage().startsWith("Unable to stop")) {
                                throw e5;
                            }
                        } catch (Throwable th) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f6802f == null) {
            return false;
        }
        if (f6801e == null && f6800d == null) {
            return false;
        }
        try {
            final Object obj2 = f6799c.get(activity);
            if (obj2 == null || (obj = f6798b.get(activity)) == null) {
                return false;
            }
            final Application application = activity.getApplication();
            final a aVar = new a(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            Handler handler = f6803g;
            handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f6804a = obj2;
                }
            });
            try {
                if (g()) {
                    Method method = f6802f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable th) {
                f6803g.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
