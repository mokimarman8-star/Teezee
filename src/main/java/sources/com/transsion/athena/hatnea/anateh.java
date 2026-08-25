package com.transsion.athena.hatnea;

import android.os.Handler;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class anateh implements Runnable {
    protected Handler a;
    protected Thread b;

    protected anateh() {
    }

    protected anateh(@NonNull Handler handler) {
        this.a = handler;
    }

    protected abstract void a();

    public String b() {
        return "Task-Athena-" + c();
    }

    protected abstract String c();

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.b = currentThread;
        String name = currentThread.getName();
        this.b.setName(b());
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            athena.a().b(this);
            this.b.setName(name);
        }
    }
}
