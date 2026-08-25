package org.chromium.net;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class UploadDataSink {
    public abstract void onReadError(Exception exc);

    public abstract void onReadSucceeded(boolean z);

    public abstract void onRewindError(Exception exc);

    public abstract void onRewindSucceeded();
}
