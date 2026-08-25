package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ReportQueue a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ d(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.a = reportQueue;
        this.b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReportQueue.b(this.a, this.b);
    }
}
