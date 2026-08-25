package com.bytedance.adsdk.ugeno.Jcg;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA extends Handler {
    private final WeakReference<Sj> Sj;

    public interface Sj {
        void Sj(Message message);
    }

    public uA(Looper looper, Sj sj) {
        super(looper);
        this.Sj = new WeakReference<>(sj);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Sj sj = this.Sj.get();
        if (sj == null || message == null) {
            return;
        }
        sj.Sj(message);
    }
}
