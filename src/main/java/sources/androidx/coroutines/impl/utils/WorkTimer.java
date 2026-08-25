package androidx.coroutines.impl.utils;

import androidx.annotation.NonNull;
import androidx.coroutines.AbstractC0216j;
import androidx.coroutines.InterfaceC0218o;
import j4.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class WorkTimer {

    /* renamed from: e, reason: collision with root package name */
    private static final String f14087e = AbstractC0216j.i("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0218o f14088a;

    /* renamed from: b, reason: collision with root package name */
    final Map f14089b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map f14090c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    final Object f14091d = new Object();

    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final m mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull m mVar) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.f14091d) {
                try {
                    if (((WorkTimerRunnable) this.mWorkTimer.f14089b.remove(this.mWorkGenerationalId)) != null) {
                        a aVar = (a) this.mWorkTimer.f14090c.remove(this.mWorkGenerationalId);
                        if (aVar != null) {
                            aVar.b(this.mWorkGenerationalId);
                        }
                    } else {
                        AbstractC0216j.e().a(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface a {
        void b(m mVar);
    }

    public WorkTimer(InterfaceC0218o interfaceC0218o) {
        this.f14088a = interfaceC0218o;
    }

    public void a(m mVar, long j5, a aVar) {
        synchronized (this.f14091d) {
            AbstractC0216j.e().a(f14087e, "Starting timer for " + mVar);
            b(mVar);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, mVar);
            this.f14089b.put(mVar, workTimerRunnable);
            this.f14090c.put(mVar, aVar);
            this.f14088a.b(j5, workTimerRunnable);
        }
    }

    public void b(m mVar) {
        synchronized (this.f14091d) {
            try {
                if (((WorkTimerRunnable) this.f14089b.remove(mVar)) != null) {
                    AbstractC0216j.e().a(f14087e, "Stopping timer for " + mVar);
                    this.f14090c.remove(mVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
