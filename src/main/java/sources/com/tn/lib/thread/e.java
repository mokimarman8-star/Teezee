package com.tn.lib.thread;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e implements a {
    private final Runnable b;

    public e(Runnable runnable) {
        Intrinsics.h(runnable, "mRunnable");
        this.b = runnable;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        this.b.run();
        a.a.a().remove(this);
        return false;
    }
}
