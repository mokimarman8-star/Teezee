package com.mbridge.msdk.preload.listenter;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a implements PreloadListener {
    WeakReference<PreloadListener> a;
    private int b = 0;
    private boolean c = false;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.a = new WeakReference<>(preloadListener);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    public void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().onPreloadFaild(str);
    }

    public void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().onPreloadSucceed();
    }
}
