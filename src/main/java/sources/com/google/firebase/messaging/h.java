package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ EnhancedIntentService a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ h(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.a = enhancedIntentService;
        this.b = intent;
        this.c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EnhancedIntentService.a(this.a, this.b, this.c);
    }
}
