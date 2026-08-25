package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class y0 implements Continuation {
    public final /* synthetic */ CountDownLatch a;

    public final Object then(Task task) {
        return z0.a(this.a, task);
    }
}
