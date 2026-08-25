package com.transsion.push.service;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class JobIntentService$g extends JobIntentService$h {
    private final JobInfo d;
    private final JobScheduler e;

    JobIntentService$g(Context context, ComponentName componentName, int i) {
        super(componentName);
        b(i);
        this.d = new JobInfo.Builder(i, this.a).setOverrideDeadline(0L).build();
        this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // com.transsion.push.service.JobIntentService$h
    void a(Intent intent) {
        this.e.enqueue(this.d, c.a(intent));
    }
}
