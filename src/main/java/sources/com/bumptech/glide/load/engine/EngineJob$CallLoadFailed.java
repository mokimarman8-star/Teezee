package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EngineJob$CallLoadFailed implements Runnable {
    private final ResourceCallback cb;
    final /* synthetic */ EngineJob this$0;

    EngineJob$CallLoadFailed(EngineJob engineJob, ResourceCallback resourceCallback) {
        this.this$0 = engineJob;
        this.cb = resourceCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.cb.getLock()) {
            synchronized (this.this$0) {
                try {
                    if (this.this$0.cbs.contains(this.cb)) {
                        this.this$0.callCallbackOnLoadFailed(this.cb);
                    }
                    this.this$0.decrementPendingCallbacks();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
