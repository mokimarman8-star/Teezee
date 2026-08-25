package com.transsion.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class JobIntentService$c extends JobIntentService$h {
    private final Context d;
    private final PowerManager.WakeLock e;
    private final PowerManager.WakeLock f;
    boolean g;
    boolean h;

    JobIntentService$c(Context context, ComponentName componentName) {
        super(componentName);
        this.d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.e = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // com.transsion.push.service.JobIntentService$h
    void a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.a);
        if (this.d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(60000L);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.transsion.push.service.JobIntentService$h
    public void c() {
        synchronized (this) {
            try {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(60000L);
                    }
                    this.h = false;
                    this.f.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.push.service.JobIntentService$h
    public void d() {
        synchronized (this) {
            try {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(600000L);
                    this.e.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.push.service.JobIntentService$h
    public void e() {
        synchronized (this) {
            this.g = false;
        }
    }
}
