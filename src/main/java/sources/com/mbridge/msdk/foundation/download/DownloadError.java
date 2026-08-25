package com.mbridge.msdk.foundation.download;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class DownloadError {
    private Exception exception;

    public DownloadError(Exception exc) {
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }
}
