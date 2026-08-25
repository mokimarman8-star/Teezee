package com.pgl.ssdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b1 extends Handler {
    protected WeakReference<a> a;

    public interface a {
        void a(Message message);
    }

    public b1(Looper looper, a aVar) {
        super(looper);
        if (aVar != null) {
            this.a = new WeakReference<>(aVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || (aVar = weakReference.get()) == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
