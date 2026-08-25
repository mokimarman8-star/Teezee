package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static final Object f6810h = new Object();

    /* renamed from: i, reason: collision with root package name */
    static final HashMap f6811i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    b f6812a;

    /* renamed from: b, reason: collision with root package name */
    h f6813b;

    /* renamed from: c, reason: collision with root package name */
    a f6814c;

    /* renamed from: d, reason: collision with root package name */
    boolean f6815d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f6816e = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f6817f = false;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList f6818g;

    final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a5 = JobIntentService.this.a();
                if (a5 == null) {
                    return null;
                }
                JobIntentService.this.e(a5.getIntent());
                a5.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.g();
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f6820d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f6821e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f6822f;

        /* renamed from: g, reason: collision with root package name */
        boolean f6823g;

        /* renamed from: h, reason: collision with root package name */
        boolean f6824h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f6820d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f6821e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f6822f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                try {
                    if (this.f6824h) {
                        if (this.f6823g) {
                            this.f6821e.acquire(60000L);
                        }
                        this.f6824h = false;
                        this.f6822f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                try {
                    if (!this.f6824h) {
                        this.f6824h = true;
                        this.f6822f.acquire(600000L);
                        this.f6821e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f6823g = false;
            }
        }
    }

    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f6825a;

        /* renamed from: b, reason: collision with root package name */
        final int f6826b;

        d(Intent intent, int i5) {
            this.f6825a = intent;
            this.f6826b = i5;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f6826b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f6825a;
        }
    }

    interface e {
        void a();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f6828a;

        /* renamed from: b, reason: collision with root package name */
        final Object f6829b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f6830c;

        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f6831a;

            a(JobWorkItem jobWorkItem) {
                this.f6831a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f6829b) {
                    try {
                        JobParameters jobParameters = f.this.f6830c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f6831a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                Intent intent;
                intent = this.f6831a.getIntent();
                return intent;
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f6829b = new Object();
            this.f6828a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            IBinder binder;
            binder = getBinder();
            return binder;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            JobWorkItem dequeueWork;
            Intent intent;
            synchronized (this.f6829b) {
                try {
                    JobParameters jobParameters = this.f6830c;
                    if (jobParameters == null) {
                        return null;
                    }
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    intent = dequeueWork.getIntent();
                    intent.setExtrasClassLoader(this.f6828a.getClassLoader());
                    return new a(dequeueWork);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f6830c = jobParameters;
            this.f6828a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b5 = this.f6828a.b();
            synchronized (this.f6829b) {
                this.f6830c = null;
            }
            return b5;
        }
    }

    static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f6833d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f6834e;

        g(Context context, ComponentName componentName, int i5) {
            super(componentName);
            a(i5);
            this.f6833d = new JobInfo.Builder(i5, this.f6835a).setOverrideDeadline(0L).build();
            this.f6834e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f6835a;

        /* renamed from: b, reason: collision with root package name */
        boolean f6836b;

        /* renamed from: c, reason: collision with root package name */
        int f6837c;

        h(ComponentName componentName) {
            this.f6835a = componentName;
        }

        void a(int i5) {
            if (!this.f6836b) {
                this.f6836b = true;
                this.f6837c = i5;
            } else {
                if (this.f6837c == i5) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i5 + " is different than previous " + this.f6837c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6818g = null;
        } else {
            this.f6818g = new ArrayList();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z5, int i5) {
        h cVar;
        HashMap hashMap = f6811i;
        h hVar = (h) hashMap.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else {
                if (!z5) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                cVar = new g(context, componentName, i5);
            }
            hVar = cVar;
            hashMap.put(componentName, hVar);
        }
        return hVar;
    }

    e a() {
        b bVar = this.f6812a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f6818g) {
            try {
                if (this.f6818g.size() <= 0) {
                    return null;
                }
                return (e) this.f6818g.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        a aVar = this.f6814c;
        if (aVar != null) {
            aVar.cancel(this.f6815d);
        }
        this.f6816e = true;
        return f();
    }

    void c(boolean z5) {
        if (this.f6814c == null) {
            this.f6814c = new a();
            h hVar = this.f6813b;
            if (hVar != null && z5) {
                hVar.c();
            }
            this.f6814c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList arrayList = this.f6818g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f6814c = null;
                    ArrayList arrayList2 = this.f6818g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f6817f) {
                        this.f6813b.b();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f6812a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6812a = new f(this);
            this.f6813b = null;
        } else {
            this.f6812a = null;
            this.f6813b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f6818g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f6817f = true;
                this.f6813b.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i5, int i6) {
        if (this.f6818g == null) {
            return 2;
        }
        this.f6813b.d();
        synchronized (this.f6818g) {
            ArrayList arrayList = this.f6818g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i6));
            c(true);
        }
        return 3;
    }
}
