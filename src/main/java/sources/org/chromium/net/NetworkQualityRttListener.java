package org.chromium.net;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class NetworkQualityRttListener {
    private final Executor mExecutor;

    public NetworkQualityRttListener(Executor executor) {
        if (executor == null) {
            throw new IllegalStateException("Executor must not be null");
        }
        this.mExecutor = executor;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public abstract void onRttObservation(int i, long j, int i2);
}
