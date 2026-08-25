package com.transsion.push.service;

import android.content.ComponentName;
import android.content.Intent;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
abstract class JobIntentService$h {
    final ComponentName a;
    boolean b;
    int c;

    JobIntentService$h(ComponentName componentName) {
        this.a = componentName;
    }

    abstract void a(Intent intent);

    void b(int i) {
        if (!this.b) {
            this.b = true;
            this.c = i;
        } else {
            if (this.c == i) {
                return;
            }
            throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.c);
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
