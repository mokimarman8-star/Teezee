package com.apm.insight.j;

import android.os.Handler;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a implements Runnable {
    private Handler a;
    private final long b = 0;
    private final long c;

    a(Handler handler, long j) {
        this.a = handler;
        this.c = j;
    }

    final void a() {
        this.a.post(this);
    }

    final void a(long j) {
        if (j > 0) {
            this.a.postDelayed(this, j);
        } else {
            this.a.post(this);
        }
    }

    final long b() {
        return this.c;
    }
}
