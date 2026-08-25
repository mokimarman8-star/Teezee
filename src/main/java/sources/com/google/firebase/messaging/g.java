package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class g implements OnCompleteListener {
    public final /* synthetic */ EnhancedIntentService a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ g(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.a = enhancedIntentService;
        this.b = intent;
    }

    public final void onComplete(Task task) {
        EnhancedIntentService.b(this.a, this.b, task);
    }
}
