package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import v3.m;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class EnhancedIntentService extends Service {
    private Binder b;
    private int d;
    final ExecutorService a = n.d();
    private final Object c = new Object();
    private int e = 0;

    private void d(Intent intent) {
        if (intent != null) {
            e1.c(intent);
        }
        synchronized (this.c) {
            try {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    k(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.setResult((Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task j(Intent intent) {
        if (g(intent)) {
            return Tasks.forResult((Object) null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.execute(new h(this, intent, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    protected Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    boolean k(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.b == null) {
                this.b = new g1(new a(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.c) {
            this.d = i2;
            this.e++;
        }
        Intent e = e(intent);
        if (e == null) {
            d(intent);
            return 2;
        }
        Task j = j(e);
        if (j.isComplete()) {
            d(intent);
            return 2;
        }
        j.addOnCompleteListener(new m(), new g(this, intent));
        return 3;
    }
}
