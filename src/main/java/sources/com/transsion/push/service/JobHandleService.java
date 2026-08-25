package com.transsion.push.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;
import com.transsion.push.PushManager;
import com.transsion.push.utils.PushLogUtils;
import com.transsion.push.utils.ServiceUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class JobHandleService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PushLogUtils.LOG.g("onStartJob JobHandleService");
        PushManager.getInstance().init(getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString("service_type", "sync_config");
        ServiceUtils.startTargetIntentService(getApplicationContext(), bundle);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
