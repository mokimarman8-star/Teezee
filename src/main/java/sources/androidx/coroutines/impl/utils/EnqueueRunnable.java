package androidx.coroutines.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.coroutines.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.d0;
import androidx.work.impl.o;
import androidx.work.impl.t;
import androidx.work.impl.w;
import androidx.work.j;
import androidx.work.l;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class EnqueueRunnable implements Runnable {
    private static final String TAG = j.i("EnqueueRunnable");
    private final o mOperation;
    private final w mWorkContinuation;

    public EnqueueRunnable(@NonNull w wVar) {
        this(wVar, new o());
    }

    public EnqueueRunnable(@NonNull w wVar, @NonNull o oVar) {
        this.mWorkContinuation = wVar;
        this.mOperation = oVar;
    }

    private static boolean enqueueContinuation(@NonNull w wVar) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(wVar.g(), wVar.f(), (String[]) w.l(wVar).toArray(new String[0]), wVar.d(), wVar.b());
        wVar.k();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.d0 r18, @androidx.annotation.NonNull java.util.List<? extends androidx.work.r> r19, java.lang.String[] r20, java.lang.String r21, androidx.coroutines.ExistingWorkPolicy r22) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coroutines.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.d0, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean processContinuation(@NonNull w wVar) {
        List<w> e = wVar.e();
        boolean z = false;
        if (e != null) {
            for (w wVar2 : e) {
                if (wVar2.j()) {
                    j.e().k(TAG, "Already enqueued work ids (" + TextUtils.join(", ", wVar2.c()) + ")");
                } else {
                    z |= processContinuation(wVar2);
                }
            }
        }
        return enqueueContinuation(wVar) | z;
    }

    public boolean addToDatabase() {
        WorkDatabase t = this.mWorkContinuation.g().t();
        t.k();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            t.e0();
            return processContinuation;
        } finally {
            t.t();
        }
    }

    @NonNull
    public l getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mWorkContinuation.h()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
            }
            if (addToDatabase()) {
                n.a(this.mWorkContinuation.g().l(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            this.mOperation.a(l.a);
        } catch (Throwable th) {
            this.mOperation.a(new l.b.a(th));
        }
    }

    public void scheduleWorkInBackground() {
        d0 g = this.mWorkContinuation.g();
        t.b(g.m(), g.t(), g.r());
    }
}
