package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class e1 {
    static final long a = TimeUnit.MINUTES.toMillis(1);
    private static final Object b = new Object();
    private static WakeLock c;

    private static void b(Context context) {
        if (c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (b) {
            try {
                if (c != null && d(intent)) {
                    g(intent, false);
                    c.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void f(Context context, j1 j1Var, final Intent intent) {
        synchronized (b) {
            try {
                b(context);
                boolean d = d(intent);
                g(intent, true);
                if (!d) {
                    c.acquire(a);
                }
                j1Var.d(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.d1
                    public final void onComplete(Task task) {
                        e1.c(intent);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    static ComponentName h(Context context, Intent intent) {
        synchronized (b) {
            try {
                b(context);
                boolean d = d(intent);
                g(intent, true);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                if (!d) {
                    c.acquire(a);
                }
                return startService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
