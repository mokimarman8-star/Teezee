package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.g1;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class EnhancedIntentService$a implements g1.a {
    final /* synthetic */ EnhancedIntentService a;

    EnhancedIntentService$a(EnhancedIntentService enhancedIntentService) {
        this.a = enhancedIntentService;
    }

    @Override // com.google.firebase.messaging.g1.a
    public Task a(Intent intent) {
        return EnhancedIntentService.c(this.a, intent);
    }
}
