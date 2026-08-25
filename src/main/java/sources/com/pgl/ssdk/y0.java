package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.b1;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class y0 extends b1 implements z0 {
    private final HandlerThread b;

    y0(HandlerThread handlerThread, b1.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.b = handlerThread;
    }

    public void a(b1.a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
