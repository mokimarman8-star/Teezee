package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class LqL extends Handler {
    protected WeakReference<Sj> Sj;

    public interface Sj {
        void Sj(Message message);
    }

    public LqL(Looper looper, Sj sj) {
        super(looper);
        if (sj != null) {
            this.Sj = new WeakReference<>(sj);
        }
    }

    public LqL(Sj sj) {
        if (sj != null) {
            this.Sj = new WeakReference<>(sj);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Sj sj;
        WeakReference<Sj> weakReference = this.Sj;
        if (weakReference == null || (sj = weakReference.get()) == null || message == null) {
            return;
        }
        sj.Sj(message);
    }
}
