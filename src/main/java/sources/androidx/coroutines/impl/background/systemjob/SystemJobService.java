package androidx.coroutines.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.WorkerParameters;
import androidx.work.impl.d0;
import androidx.work.impl.e;
import androidx.work.impl.u;
import androidx.work.impl.v;
import androidx.work.j;
import j4.m;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SystemJobService extends JobService implements e {
    private static final String d = j.i("SystemJobService");
    private d0 a;
    private final Map b = new HashMap();
    private final v c = new v();

    private static m a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void d(m mVar, boolean z) {
        JobParameters jobParameters;
        j.e().a(d, mVar.b() + " executed on JobScheduler");
        synchronized (this.b) {
            jobParameters = (JobParameters) this.b.remove(mVar);
        }
        this.c.b(mVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            d0 o = d0.o(getApplicationContext());
            this.a = o;
            o.q().g(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            j.e().k(d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.q().n(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        if (this.a == null) {
            j.e().a(d, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        m a = a(jobParameters);
        if (a == null) {
            j.e().c(d, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.b) {
            try {
                if (this.b.containsKey(a)) {
                    j.e().a(d, "Job is already being executed by SystemJobService: " + a);
                    return false;
                }
                j.e().a(d, "onStartJob for " + a);
                this.b.put(a, jobParameters);
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    aVar = new WorkerParameters.a();
                    if (a.b(jobParameters) != null) {
                        aVar.b = Arrays.asList(a.b(jobParameters));
                    }
                    if (a.a(jobParameters) != null) {
                        aVar.a = Arrays.asList(a.a(jobParameters));
                    }
                    if (i >= 28) {
                        aVar.c = b.a(jobParameters);
                    }
                } else {
                    aVar = null;
                }
                this.a.A(this.c.d(a), aVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.a == null) {
            j.e().a(d, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        m a = a(jobParameters);
        if (a == null) {
            j.e().c(d, "WorkSpec id not found!");
            return false;
        }
        j.e().a(d, "onStopJob for " + a);
        synchronized (this.b) {
            this.b.remove(a);
        }
        u b = this.c.b(a);
        if (b != null) {
            this.a.C(b);
        }
        return !this.a.q().j(a.b());
    }
}
