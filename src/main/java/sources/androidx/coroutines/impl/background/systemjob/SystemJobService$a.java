package androidx.coroutines.impl.background.systemjob;

import android.app.job.JobParameters;
import android.net.Uri;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SystemJobService$a {
    static String[] a(JobParameters jobParameters) {
        return jobParameters.getTriggeredContentAuthorities();
    }

    static Uri[] b(JobParameters jobParameters) {
        return jobParameters.getTriggeredContentUris();
    }
}
