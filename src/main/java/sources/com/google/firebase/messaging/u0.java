package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class u0 {
    private final Executor a;
    private final Map b = new androidx.collection.a();

    interface a {
        Task start();
    }

    u0(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) {
        synchronized (this) {
            this.b.remove(str);
        }
        return task;
    }

    synchronized Task b(final String str, a aVar) {
        Task task = (Task) this.b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Joining ongoing request for: ");
                sb2.append(str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Making new request for: ");
            sb3.append(str);
        }
        Task continueWithTask = aVar.start().continueWithTask(this.a, new Continuation() { // from class: com.google.firebase.messaging.t0
            public final Object then(Task task2) {
                Task c;
                c = u0.this.c(str, task2);
                return c;
            }
        });
        this.b.put(str, continueWithTask);
        return continueWithTask;
    }
}
