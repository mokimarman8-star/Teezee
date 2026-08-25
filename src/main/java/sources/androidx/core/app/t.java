package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class t {
    private static String d;
    private static d g;
    private final Context a;
    private final NotificationManager b;
    private static final Object c = new Object();
    private static Set e = new HashSet();
    private static final Object f = new Object();

    private t(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public static t b(Context context) {
        return new t(context);
    }

    public static Set c(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (c) {
            if (string != null) {
                try {
                    if (!string.equals(d)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        e = hashSet;
                        d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = e;
        }
        return set;
    }

    private void f(e eVar) {
        synchronized (f) {
            try {
                if (g == null) {
                    g = new d(this.a.getApplicationContext());
                }
                g.h(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean g(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.a.getApplicationInfo();
        String packageName = this.a.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void d(int i, Notification notification) {
        e(null, i, notification);
    }

    public void e(String str, int i, Notification notification) {
        if (!g(notification)) {
            this.b.notify(str, i, notification);
        } else {
            f(new b(this.a.getPackageName(), i, str, notification));
            this.b.cancel(str, i);
        }
    }
}
