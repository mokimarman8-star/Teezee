package com.transsion.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class JobIntentService extends Service {
    static final Object h = new Object();
    static final HashMap i = new HashMap();
    b a;
    h b;
    a c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    final ArrayList g;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.g = null;
        } else {
            this.g = new ArrayList();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z, int i2) {
        g cVar;
        HashMap hashMap = i;
        g gVar = (h) hashMap.get(componentName);
        if (gVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else {
                if (!z) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                cVar = new g(context, componentName, i2);
            }
            gVar = cVar;
            hashMap.put(componentName, gVar);
        }
        return gVar;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (h) {
            h d = d(context, componentName, true, i2);
            d.b(i2);
            try {
                d.a(intent);
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class cls, int i2, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i2, intent);
    }

    e a() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.g) {
            try {
                if (this.g.size() <= 0) {
                    return null;
                }
                return (e) this.g.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cancel(this.d);
        }
        this.e = true;
        return onStopCurrentWork();
    }

    void c(boolean z) {
        if (this.c == null) {
            this.c = new a(this);
            h hVar = this.b;
            if (hVar != null && z) {
                hVar.d();
            }
            try {
                this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                Log.e("JobIntentService", "RejectedExecutionException: rejected from java.util.concurrent.ThreadPoolExecutor", e);
            }
        }
    }

    protected abstract void e(Intent intent);

    void f() {
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.c = null;
                    ArrayList arrayList2 = this.g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f) {
                        this.b.c();
                    }
                } finally {
                }
            }
        }
    }

    public boolean isStopped() {
        return this.e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new f(this);
            this.b = null;
        } else {
            this.a = null;
            this.b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.g == null) {
            return 2;
        }
        this.b.e();
        synchronized (this.g) {
            ArrayList arrayList = this.g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(this, intent, i3));
            c(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.d = z;
    }
}
