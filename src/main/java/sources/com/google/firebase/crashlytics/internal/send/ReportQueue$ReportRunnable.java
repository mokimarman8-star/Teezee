package com.google.firebase.crashlytics.internal.send;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.a0;
import java.util.Locale;
import qb.g;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class ReportQueue$ReportRunnable implements Runnable {
    private final a0 reportWithSessionId;
    private final TaskCompletionSource<a0> tcs;
    final /* synthetic */ ReportQueue this$0;

    private ReportQueue$ReportRunnable(ReportQueue reportQueue, a0 a0Var, TaskCompletionSource<a0> taskCompletionSource) {
        this.this$0 = reportQueue;
        this.reportWithSessionId = a0Var;
        this.tcs = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReportQueue.c(this.this$0, this.reportWithSessionId, this.tcs);
        ReportQueue.d(this.this$0).c();
        double e = ReportQueue.e(this.this$0);
        g.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(e / 1000.0d)) + " s for report: " + this.reportWithSessionId.d());
        ReportQueue.f(e);
    }
}
