package com.bumptech.glide.load.engine;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DecodeJob$ReleaseManager {
    private boolean isEncodeComplete;
    private boolean isFailed;
    private boolean isReleased;

    DecodeJob$ReleaseManager() {
    }

    private boolean isComplete(boolean z) {
        return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
    }

    synchronized boolean onEncodeComplete() {
        this.isEncodeComplete = true;
        return isComplete(false);
    }

    synchronized boolean onFailed() {
        this.isFailed = true;
        return isComplete(false);
    }

    synchronized boolean release(boolean z) {
        this.isReleased = true;
        return isComplete(z);
    }

    synchronized void reset() {
        this.isEncodeComplete = false;
        this.isReleased = false;
        this.isFailed = false;
    }
}
