package androidx.coroutines.impl.background.systemjob;

import android.app.job.JobParameters;
import android.net.Network;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SystemJobService$b {
    static Network a(JobParameters jobParameters) {
        return jobParameters.getNetwork();
    }
}
