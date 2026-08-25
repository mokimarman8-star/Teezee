package b9;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b implements u {
    private final Context a;
    private final c9.d b;
    private final SchedulerConfig c;

    public b(Context context, c9.d dVar, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.b = dVar;
        this.c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    @Override // b9.u
    public void a(com.google.android.datatransport.runtime.o oVar, int i) {
        b(oVar, i, false);
    }

    @Override // b9.u
    public void b(com.google.android.datatransport.runtime.o oVar, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int c = c(oVar);
        if (!z && d(jobScheduler, c, i)) {
            y8.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
            return;
        }
        long O = this.b.O(oVar);
        JobInfo.Builder c2 = this.c.c(new JobInfo.Builder(c, componentName), oVar.d(), O, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", oVar.b());
        persistableBundle.putInt("priority", f9.a.a(oVar.d()));
        if (oVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.c(), 0));
        }
        c2.setExtras(persistableBundle);
        y8.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(c), Long.valueOf(this.c.g(oVar.d(), O, i)), Long.valueOf(O), Integer.valueOf(i));
        jobScheduler.schedule(c2.build());
    }

    int c(com.google.android.datatransport.runtime.o oVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName(TmcConstants.DEFAULT_ENCODING)));
        adler32.update(oVar.b().getBytes(Charset.forName(TmcConstants.DEFAULT_ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(f9.a.a(oVar.d())).array());
        if (oVar.c() != null) {
            adler32.update(oVar.c());
        }
        return (int) adler32.getValue();
    }
}
