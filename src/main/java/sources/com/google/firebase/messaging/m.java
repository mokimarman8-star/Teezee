package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class m {
    private static final Object c = new Object();
    private static j1 d;
    private final Context a;
    private final Executor b = new v3.m();

    public m(Context context) {
        this.a = context;
    }

    private static Task e(Context context, Intent intent, boolean z) {
        Log.isLoggable("FirebaseMessaging", 3);
        j1 f = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z) {
            return f.d(intent).continueWith(new v3.m(), new Continuation() { // from class: com.google.firebase.messaging.l
                public final Object then(Task task) {
                    Integer g;
                    g = m.g(task);
                    return g;
                }
            });
        }
        if (v0.b().e(context)) {
            e1.f(context, f, intent);
        } else {
            f.d(intent);
        }
        return Tasks.forResult(-1);
    }

    private static j1 f(Context context, String str) {
        j1 j1Var;
        synchronized (c) {
            try {
                if (d == null) {
                    d = new j1(context, str);
                }
                j1Var = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer g(Task task) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer h(Context context, Intent intent) {
        return Integer.valueOf(v0.b().g(context, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer i(Task task) {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task j(Context context, Intent intent, boolean z, Task task) {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z).continueWith(new v3.m(), new Continuation() { // from class: com.google.firebase.messaging.k
            public final Object then(Task task2) {
                Integer i;
                i = m.i(task2);
                return i;
            }
        }) : task;
    }

    public Task k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.a, intent);
    }

    public Task l(final Context context, final Intent intent) {
        boolean z = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z2 = (intent.getFlags() & 268435456) != 0;
        return (!z || z2) ? Tasks.call(this.b, new Callable() { // from class: com.google.firebase.messaging.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer h;
                h = m.h(context, intent);
                return h;
            }
        }).continueWithTask(this.b, new Continuation() { // from class: com.google.firebase.messaging.j
            public final Object then(Task task) {
                Task j;
                j = m.j(context, intent, z2, task);
                return j;
            }
        }) : e(context, intent, z2);
    }
}
