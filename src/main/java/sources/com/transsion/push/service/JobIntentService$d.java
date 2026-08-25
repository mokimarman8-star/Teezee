package com.transsion.push.service;

import android.content.Intent;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class JobIntentService$d implements JobIntentService$e {
    final Intent a;
    final int b;
    final /* synthetic */ JobIntentService c;

    JobIntentService$d(JobIntentService jobIntentService, Intent intent, int i) {
        this.c = jobIntentService;
        this.a = intent;
        this.b = i;
    }

    @Override // com.transsion.push.service.JobIntentService$e
    public void a() {
        this.c.stopSelf(this.b);
    }

    @Override // com.transsion.push.service.JobIntentService$e
    public Intent getIntent() {
        return this.a;
    }
}
