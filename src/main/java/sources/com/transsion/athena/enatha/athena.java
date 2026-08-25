package com.transsion.athena.enatha;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.transsion.athena.data.TrackData;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class athena {
    protected Context a;
    protected Handler b;

    public athena(Context context) {
        this.a = context;
    }

    public void a() {
    }

    public void a(int i) {
    }

    public abstract void a(Message message, long j);

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j);

    public abstract void a(String str, TrackData trackData, long j);

    public Handler b() {
        return this.b;
    }

    public boolean c() {
        return true;
    }

    public void d() {
    }

    public void e() {
    }
}
