package androidx.coroutines.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.impl.d0;
import androidx.work.impl.u;
import androidx.work.j;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class StopWorkRunnable implements Runnable {
    private static final String TAG = j.i("StopWorkRunnable");
    private final boolean mStopInForeground;
    private final u mToken;
    private final d0 mWorkManagerImpl;

    public StopWorkRunnable(@NonNull d0 d0Var, @NonNull u uVar, boolean z) {
        this.mWorkManagerImpl = d0Var;
        this.mToken = uVar;
        this.mStopInForeground = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean t = this.mStopInForeground ? this.mWorkManagerImpl.q().t(this.mToken) : this.mWorkManagerImpl.q().u(this.mToken);
        j.e().a(TAG, "StopWorkRunnable for " + this.mToken.a().b() + "; Processor.stopWork = " + t);
    }
}
