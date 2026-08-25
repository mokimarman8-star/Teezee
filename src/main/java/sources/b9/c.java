package b9;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ JobInfoSchedulerService a;
    public final /* synthetic */ JobParameters b;

    public /* synthetic */ c(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.a = jobInfoSchedulerService;
        this.b = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JobInfoSchedulerService.a(this.a, this.b);
    }
}
