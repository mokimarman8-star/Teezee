package com.mbridge.msdk.mbnative.service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.d;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private NativeController a;
    private Handler b = new Handler(Looper.getMainLooper());
    private com.mbridge.msdk.mbnative.listener.a c;
    private NativeListener.NativeTrackingListener d;

    /* renamed from: com.mbridge.msdk.mbnative.service.a$a, reason: collision with other inner class name */
    class RunnableC0107a implements Runnable {
        RunnableC0107a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    public a() {
    }

    public a(com.mbridge.msdk.mbnative.listener.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.c = aVar;
        this.d = nativeTrackingListener;
    }

    private void a(int i, String str) {
        if (this.a != null) {
            com.mbridge.msdk.mbnative.listener.a aVar = this.c;
            if (aVar == null || !aVar.a()) {
                com.mbridge.msdk.mbnative.listener.a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.b();
                }
                this.a.a(i, str);
                return;
            }
            if (t0.h()) {
                f();
            } else {
                this.b.post(new RunnableC0107a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.onAdLoadError("current request is loading");
        this.c.b();
    }

    public static void preload(Map<String, Object> map, int i) {
        o0.c("NativeProvider", "native provider preload");
        new d().a(map, i);
    }

    public void a() {
        try {
            this.a.d();
        } catch (Exception unused) {
            o0.b("NativeProvider", "clear cache failed");
        }
    }

    public void a(Context context, Resources resources, Map<String, Object> map) {
        this.a = new NativeController(this.c, this.d, map, context);
    }

    public void a(View view, Campaign campaign) {
        o0.c("NativeProvider", "native provider registerView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view);
    }

    public void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view, list);
    }

    public void a(com.mbridge.msdk.mbnative.listener.a aVar) {
        this.c = aVar;
    }

    public void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.d = nativeTrackingListener;
    }

    public void a(String str) {
        a(0, str);
    }

    public String b() {
        NativeController nativeController = this.a;
        return nativeController != null ? nativeController.e() : TtmlNode.ANONYMOUS_REGION_ID;
    }

    public void b(View view, Campaign campaign) {
        o0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view);
    }

    public void b(View view, List<View> list, Campaign campaign) {
        o0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view, list);
    }

    public String c() {
        NativeController nativeController = this.a;
        return nativeController != null ? nativeController.g() : TtmlNode.ANONYMOUS_REGION_ID;
    }

    public void d() {
        a(0, TtmlNode.ANONYMOUS_REGION_ID);
    }

    public void e() {
        a(1, TtmlNode.ANONYMOUS_REGION_ID);
    }

    public void g() {
        try {
            this.a.i();
        } catch (Exception unused) {
            o0.b("NativeProvider", "release failed");
        }
    }
}
