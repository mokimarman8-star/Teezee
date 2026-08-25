package com.transsion.transfer.androidasync;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class AsyncSSLException extends Exception {
    private boolean mIgnore;

    public AsyncSSLException(Throwable th) {
        super("Peer not trusted by any of the system trust managers.", th);
        this.mIgnore = false;
    }

    public boolean getIgnore() {
        return this.mIgnore;
    }

    public void setIgnore(boolean z) {
        this.mIgnore = z;
    }
}
