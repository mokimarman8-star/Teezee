package androidx.coroutines.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.coroutines.WorkInfo$State;
import androidx.coroutines.impl.utils.WorkForegroundRunnable;
import androidx.coroutines.impl.utils.WorkForegroundUpdater;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.d;
import androidx.work.g;
import androidx.work.i;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.n;
import androidx.work.j;
import com.google.common.util.concurrent.r;
import j4.b;
import j4.m;
import j4.u;
import j4.v;
import j4.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import k4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WorkerWrapper implements Runnable {
    static final String TAG = j.i("WorkerWrapper");
    Context mAppContext;
    private a mConfiguration;
    private b mDependencyDao;
    private androidx.work.impl.foreground.a mForegroundProcessor;
    private volatile boolean mInterrupted;
    private WorkerParameters.a mRuntimeExtras;
    private List<s> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    u mWorkSpec;
    private v mWorkSpecDao;
    private final String mWorkSpecId;
    c mWorkTaskExecutor;
    i mWorker;

    @NonNull
    i.a mResult = i.a.a();

    @NonNull
    androidx.work.impl.utils.futures.a mFuture = androidx.work.impl.utils.futures.a.x();

    @NonNull
    final androidx.work.impl.utils.futures.a mWorkerResultFuture = androidx.work.impl.utils.futures.a.x();

    WorkerWrapper(@NonNull a aVar) {
        this.mAppContext = aVar.a;
        this.mWorkTaskExecutor = aVar.d;
        this.mForegroundProcessor = aVar.c;
        u uVar = aVar.g;
        this.mWorkSpec = uVar;
        this.mWorkSpecId = uVar.a;
        this.mSchedulers = aVar.h;
        this.mRuntimeExtras = aVar.j;
        this.mWorker = aVar.b;
        this.mConfiguration = aVar.e;
        WorkDatabase workDatabase = aVar.f;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.n0();
        this.mDependencyDao = this.mWorkDatabase.h0();
        this.mTags = a.a(aVar);
    }

    private String createWorkDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.mWorkSpecId);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void handleResult(i.a aVar) {
        if (aVar instanceof i.a.c) {
            j.e().f(TAG, "Worker result SUCCESS for " + this.mWorkDescription);
            if (this.mWorkSpec.j()) {
                resetPeriodicAndResolve();
                return;
            } else {
                setSucceededAndResolve();
                return;
            }
        }
        if (aVar instanceof i.a.b) {
            j.e().f(TAG, "Worker result RETRY for " + this.mWorkDescription);
            rescheduleAndResolve();
            return;
        }
        j.e().f(TAG, "Worker result FAILURE for " + this.mWorkDescription);
        if (this.mWorkSpec.j()) {
            resetPeriodicAndResolve();
        } else {
            setFailedAndResolve();
        }
    }

    private void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.mWorkSpecDao.i(str2) != WorkInfo$State.CANCELLED) {
                this.mWorkSpecDao.u(WorkInfo$State.FAILED, str2);
            }
            linkedList.addAll(this.mDependencyDao.a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runWorker$0(r rVar) {
        if (this.mWorkerResultFuture.isCancelled()) {
            rVar.cancel(true);
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.k();
        try {
            this.mWorkSpecDao.u(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.k(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            this.mWorkDatabase.e0();
        } finally {
            this.mWorkDatabase.t();
            resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.k();
        try {
            this.mWorkSpecDao.k(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.u(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.z(this.mWorkSpecId);
            this.mWorkSpecDao.c(this.mWorkSpecId);
            this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            this.mWorkDatabase.e0();
        } finally {
            this.mWorkDatabase.t();
            resolve(false);
        }
    }

    private void resolve(boolean z) {
        this.mWorkDatabase.k();
        try {
            if (!this.mWorkDatabase.n0().y()) {
                n.a(this.mAppContext, RescheduleReceiver.class, false);
            }
            if (z) {
                this.mWorkSpecDao.u(WorkInfo$State.ENQUEUED, this.mWorkSpecId);
                this.mWorkSpecDao.r(this.mWorkSpecId, -1L);
            }
            if (this.mWorkSpec != null && this.mWorker != null && this.mForegroundProcessor.b(this.mWorkSpecId)) {
                this.mForegroundProcessor.a(this.mWorkSpecId);
            }
            this.mWorkDatabase.e0();
            this.mWorkDatabase.t();
            this.mFuture.t(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.mWorkDatabase.t();
            throw th;
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo$State i = this.mWorkSpecDao.i(this.mWorkSpecId);
        if (i == WorkInfo$State.RUNNING) {
            j.e().a(TAG, "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
            resolve(true);
            return;
        }
        j.e().a(TAG, "Status for " + this.mWorkSpecId + " is " + i + " ; not doing any work");
        resolve(false);
    }

    private void runWorker() {
        d b;
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        this.mWorkDatabase.k();
        try {
            u uVar = this.mWorkSpec;
            if (uVar.b != WorkInfo$State.ENQUEUED) {
                resolveIncorrectStatus();
                this.mWorkDatabase.e0();
                j.e().a(TAG, this.mWorkSpec.c + " is not in ENQUEUED state. Nothing more to do");
                return;
            }
            if ((uVar.j() || this.mWorkSpec.i()) && System.currentTimeMillis() < this.mWorkSpec.c()) {
                j.e().a(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.c));
                resolve(true);
                this.mWorkDatabase.e0();
                return;
            }
            this.mWorkDatabase.e0();
            this.mWorkDatabase.t();
            if (this.mWorkSpec.j()) {
                b = this.mWorkSpec.e;
            } else {
                g b2 = this.mConfiguration.f().b(this.mWorkSpec.d);
                if (b2 == null) {
                    j.e().c(TAG, "Could not create Input Merger " + this.mWorkSpec.d);
                    setFailedAndResolve();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mWorkSpec.e);
                arrayList.addAll(this.mWorkSpecDao.m(this.mWorkSpecId));
                b = b2.b(arrayList);
            }
            d dVar = b;
            UUID fromString = UUID.fromString(this.mWorkSpecId);
            List<String> list = this.mTags;
            WorkerParameters.a aVar = this.mRuntimeExtras;
            u uVar2 = this.mWorkSpec;
            WorkerParameters workerParameters = new WorkerParameters(fromString, dVar, list, aVar, uVar2.k, uVar2.f(), this.mConfiguration.d(), this.mWorkTaskExecutor, this.mConfiguration.n(), new androidx.coroutines.impl.utils.v(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
            if (this.mWorker == null) {
                this.mWorker = this.mConfiguration.n().b(this.mAppContext, this.mWorkSpec.c, workerParameters);
            }
            i iVar = this.mWorker;
            if (iVar == null) {
                j.e().c(TAG, "Could not create Worker " + this.mWorkSpec.c);
                setFailedAndResolve();
                return;
            }
            if (iVar.k()) {
                j.e().c(TAG, "Received an already-used Worker " + this.mWorkSpec.c + "; Worker Factory should return new instances");
                setFailedAndResolve();
                return;
            }
            this.mWorker.m();
            if (!trySetRunning()) {
                resolveIncorrectStatus();
                return;
            }
            if (tryCheckForInterruptionAndResolve()) {
                return;
            }
            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workerParameters.b(), this.mWorkTaskExecutor);
            this.mWorkTaskExecutor.a().execute(workForegroundRunnable);
            final r future = workForegroundRunnable.getFuture();
            this.mWorkerResultFuture.addListener(new Runnable() { // from class: androidx.work.impl.i0
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerWrapper.this.lambda$runWorker$0(future);
                }
            }, new androidx.work.impl.utils.r());
            future.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WorkerWrapper.this.mWorkerResultFuture.isCancelled()) {
                        return;
                    }
                    try {
                        future.get();
                        j.e().a(WorkerWrapper.TAG, "Starting work for " + WorkerWrapper.this.mWorkSpec.c);
                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                        workerWrapper.mWorkerResultFuture.v(workerWrapper.mWorker.n());
                    } catch (Throwable th) {
                        WorkerWrapper.this.mWorkerResultFuture.u(th);
                    }
                }
            }, this.mWorkTaskExecutor.a());
            final String str = this.mWorkDescription;
            this.mWorkerResultFuture.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.2
                @Override // java.lang.Runnable
                @SuppressLint({"SyntheticAccessor"})
                public void run() {
                    try {
                        try {
                            i.a aVar2 = (i.a) WorkerWrapper.this.mWorkerResultFuture.get();
                            if (aVar2 == null) {
                                j.e().c(WorkerWrapper.TAG, WorkerWrapper.this.mWorkSpec.c + " returned a null result. Treating it as a failure.");
                            } else {
                                j.e().a(WorkerWrapper.TAG, WorkerWrapper.this.mWorkSpec.c + " returned a " + aVar2 + ".");
                                WorkerWrapper.this.mResult = aVar2;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            j.e().d(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        } catch (CancellationException e3) {
                            j.e().g(WorkerWrapper.TAG, str + " was cancelled", e3);
                        } catch (ExecutionException e4) {
                            e = e4;
                            j.e().d(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        }
                        WorkerWrapper.this.onWorkFinished();
                    } catch (Throwable th) {
                        WorkerWrapper.this.onWorkFinished();
                        throw th;
                    }
                }
            }, this.mWorkTaskExecutor.b());
        } finally {
            this.mWorkDatabase.t();
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.k();
        try {
            this.mWorkSpecDao.u(WorkInfo$State.SUCCEEDED, this.mWorkSpecId);
            this.mWorkSpecDao.v(this.mWorkSpecId, this.mResult.e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.mDependencyDao.a(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.i(str) == WorkInfo$State.BLOCKED && this.mDependencyDao.b(str)) {
                    j.e().f(TAG, "Setting status to enqueued for " + str);
                    this.mWorkSpecDao.u(WorkInfo$State.ENQUEUED, str);
                    this.mWorkSpecDao.k(str, currentTimeMillis);
                }
            }
            this.mWorkDatabase.e0();
            this.mWorkDatabase.t();
            resolve(false);
        } catch (Throwable th) {
            this.mWorkDatabase.t();
            resolve(false);
            throw th;
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        j.e().a(TAG, "Work interrupted for " + this.mWorkDescription);
        if (this.mWorkSpecDao.i(this.mWorkSpecId) == null) {
            resolve(false);
        } else {
            resolve(!r0.isFinished());
        }
        return true;
    }

    private boolean trySetRunning() {
        boolean z;
        this.mWorkDatabase.k();
        try {
            if (this.mWorkSpecDao.i(this.mWorkSpecId) == WorkInfo$State.ENQUEUED) {
                this.mWorkSpecDao.u(WorkInfo$State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.C(this.mWorkSpecId);
                z = true;
            } else {
                z = false;
            }
            this.mWorkDatabase.e0();
            this.mWorkDatabase.t();
            return z;
        } catch (Throwable th) {
            this.mWorkDatabase.t();
            throw th;
        }
    }

    @NonNull
    public r getFuture() {
        return this.mFuture;
    }

    @NonNull
    public m getWorkGenerationalId() {
        return x.a(this.mWorkSpec);
    }

    @NonNull
    public u getWorkSpec() {
        return this.mWorkSpec;
    }

    public void interrupt() {
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if (this.mWorker != null && this.mWorkerResultFuture.isCancelled()) {
            this.mWorker.o();
            return;
        }
        j.e().a(TAG, "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.");
    }

    void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.k();
            try {
                WorkInfo$State i = this.mWorkSpecDao.i(this.mWorkSpecId);
                this.mWorkDatabase.m0().a(this.mWorkSpecId);
                if (i == null) {
                    resolve(false);
                } else if (i == WorkInfo$State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!i.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.e0();
                this.mWorkDatabase.t();
            } catch (Throwable th) {
                this.mWorkDatabase.t();
                throw th;
            }
        }
        List<s> list = this.mSchedulers;
        if (list != null) {
            Iterator<s> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(this.mWorkSpecId);
            }
            t.b(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkDescription = createWorkDescription(this.mTags);
        runWorker();
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.k();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            this.mWorkSpecDao.v(this.mWorkSpecId, this.mResult.e());
            this.mWorkDatabase.e0();
        } finally {
            this.mWorkDatabase.t();
            resolve(false);
        }
    }
}
