package androidx.coroutines.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.coroutines.WorkInfo$State;
import androidx.coroutines.impl.WorkDatabase;
import androidx.work.a;
import androidx.work.impl.background.systemjob.k;
import androidx.work.impl.d0;
import androidx.work.impl.t;
import androidx.work.impl.z;
import androidx.work.j;
import j4.r;
import j4.u;
import j4.v;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ForceStopRunnable implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = j.i("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private final o mPreferenceUtils;
    private int mRetryCount = 0;
    private final d0 mWorkManager;

    public ForceStopRunnable(@NonNull Context context, @NonNull d0 d0Var) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = d0Var;
        this.mPreferenceUtils = d0Var.p();
    }

    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntent = getPendingIntent(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : ASTNode.NOJIT);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    public boolean cleanUp() {
        boolean i = k.i(this.mContext, this.mWorkManager);
        WorkDatabase t = this.mWorkManager.t();
        v n0 = t.n0();
        r m0 = t.m0();
        t.k();
        try {
            List<u> w = n0.w();
            boolean z = (w == null || w.isEmpty()) ? false : true;
            if (z) {
                for (u uVar : w) {
                    n0.u(WorkInfo$State.ENQUEUED, uVar.a);
                    n0.r(uVar.a, -1L);
                }
            }
            m0.c();
            t.e0();
            t.t();
            return z || i;
        } catch (Throwable th) {
            t.t();
            throw th;
        }
    }

    public void forceStopRunnable() {
        boolean cleanUp = cleanUp();
        if (shouldRescheduleWorkers()) {
            j.e().a(TAG, "Rescheduling Workers.");
            this.mWorkManager.x();
            this.mWorkManager.p().g(false);
        } else if (isForceStopped()) {
            j.e().a(TAG, "Application was force-stopped, rescheduling.");
            this.mWorkManager.x();
            this.mPreferenceUtils.f(System.currentTimeMillis());
        } else if (cleanUp) {
            j.e().a(TAG, "Found unfinished work, scheduling it.");
            t.b(this.mWorkManager.m(), this.mWorkManager.t(), this.mWorkManager.r());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        List historicalProcessExitReasons;
        int reason;
        long timestamp;
        try {
            int i = Build.VERSION.SDK_INT;
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i >= 31 ? 570425344 : ASTNode.DISCARD);
            if (i >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long b = this.mPreferenceUtils.b();
                    for (int i2 = 0; i2 < historicalProcessExitReasons.size(); i2++) {
                        ApplicationExitInfo a = d.a(historicalProcessExitReasons.get(i2));
                        reason = a.getReason();
                        if (reason == 10) {
                            timestamp = a.getTimestamp();
                            if (timestamp >= b) {
                                return true;
                            }
                        }
                    }
                }
            } else if (pendingIntent == null) {
                setAlarm(this.mContext);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            e = e;
            j.e().l(TAG, "Ignoring exception", e);
            return true;
        } catch (SecurityException e3) {
            e = e3;
            j.e().l(TAG, "Ignoring exception", e);
            return true;
        }
    }

    public boolean multiProcessChecks() {
        a m = this.mWorkManager.m();
        if (TextUtils.isEmpty(m.c())) {
            j.e().a(TAG, "The default process name was not specified.");
            return true;
        }
        boolean b = p.b(this.mContext, m);
        j.e().a(TAG, "Is default app process = " + b);
        return b;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        try {
            if (multiProcessChecks()) {
                while (true) {
                    try {
                        z.d(this.mContext);
                        j.e().a(TAG, "Performing cleanup operations.");
                        try {
                            forceStopRunnable();
                            break;
                        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e) {
                            i = this.mRetryCount + 1;
                            this.mRetryCount = i;
                            if (i >= 3) {
                                j e3 = j.e();
                                String str = TAG;
                                e3.d(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                                androidx.core.util.a e4 = this.mWorkManager.m().e();
                                if (e4 == null) {
                                    throw illegalStateException;
                                }
                                j.e().b(str, "Routing exception to the specified exception handler", illegalStateException);
                                e4.accept(illegalStateException);
                            } else {
                                long j = i * BACKOFF_DURATION_MS;
                                j.e().b(TAG, "Retrying after " + j, e);
                                sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                            }
                        }
                        long j2 = i * BACKOFF_DURATION_MS;
                        j.e().b(TAG, "Retrying after " + j2, e);
                        sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                    } catch (SQLiteException e5) {
                        j.e().c(TAG, "Unexpected SQLite exception during migrations");
                        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e5);
                        androidx.core.util.a e6 = this.mWorkManager.m().e();
                        if (e6 == null) {
                            throw illegalStateException2;
                        }
                        e6.accept(illegalStateException2);
                    }
                }
            }
        } finally {
            this.mWorkManager.w();
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.p().c();
    }

    public void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
