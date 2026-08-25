package com.transsion.push.service;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.i;
import androidx.core.app.j;
import androidx.core.app.k;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class JobIntentService$f extends JobServiceEngine implements JobIntentService$b {
    final JobIntentService a;
    final Object b;
    JobParameters c;

    final class a implements JobIntentService$e {
        final JobWorkItem a;

        a(JobWorkItem jobWorkItem) {
            this.a = jobWorkItem;
        }

        @Override // com.transsion.push.service.JobIntentService$e
        public void a() {
            synchronized (JobIntentService$f.this.b) {
                JobParameters jobParameters = JobIntentService$f.this.c;
                if (jobParameters != null) {
                    try {
                        k.a(jobParameters, this.a);
                    } catch (IllegalArgumentException e) {
                        Log.e("JobServiceEngineImpl", "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e);
                    } catch (SecurityException e2) {
                        Log.e("JobServiceEngineImpl", "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e2);
                    }
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService$e
        public Intent getIntent() {
            return j.a(this.a);
        }
    }

    JobIntentService$f(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.b = new Object();
        this.a = jobIntentService;
    }

    @Override // com.transsion.push.service.JobIntentService$b
    public IBinder a() {
        IBinder binder;
        binder = getBinder();
        return binder;
    }

    @Override // com.transsion.push.service.JobIntentService$b
    public JobIntentService$e b() {
        synchronized (this.b) {
            JobParameters jobParameters = this.c;
            if (jobParameters == null) {
                return null;
            }
            try {
                JobWorkItem a2 = i.a(jobParameters);
                if (a2 == null) {
                    return null;
                }
                j.a(a2).setExtrasClassLoader(this.a.getClassLoader());
                return new a(a2);
            } catch (SecurityException e) {
                Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e);
                return null;
            }
        }
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStartJob(JobParameters jobParameters) {
        this.c = jobParameters;
        this.a.c(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStopJob(JobParameters jobParameters) {
        boolean b = this.a.b();
        synchronized (this.b) {
            this.c = null;
        }
        return b;
    }
}
