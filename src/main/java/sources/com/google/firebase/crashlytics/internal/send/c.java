package com.google.firebase.crashlytics.internal.send;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.a0;
import t8.j;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class c implements j {
    public final /* synthetic */ ReportQueue a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ a0 d;

    public /* synthetic */ c(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z, a0 a0Var) {
        this.a = reportQueue;
        this.b = taskCompletionSource;
        this.c = z;
        this.d = a0Var;
    }

    public final void a(Exception exc) {
        ReportQueue.a(this.a, this.b, this.c, this.d, exc);
    }
}
