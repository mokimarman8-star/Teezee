package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.b1;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class x0 {
    private final a1<y0> a;
    private b1 b;

    private static class b {
        private static final x0 a = new x0();
    }

    private x0() {
        this.a = a1.a(2);
    }

    public static x0 a() {
        return b.a;
    }

    private y0 a(b1.a aVar, String str) {
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new y0(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public b1 a(String str) {
        return b(null, str);
    }

    public b1 b() {
        if (this.b == null) {
            synchronized (x0.class) {
                try {
                    if (this.b == null) {
                        this.b = a("ssdk_net_handler");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    public b1 b(b1.a aVar, String str) {
        y0 a2 = this.a.a();
        if (a2 == null) {
            return a(aVar, str);
        }
        a2.a(aVar);
        a2.a(str);
        return a2;
    }

    public b1 c() {
        if (this.b == null) {
            synchronized (x0.class) {
                try {
                    if (this.b == null) {
                        this.b = a("ssdk_handler");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }
}
