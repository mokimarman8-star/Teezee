package androidx.coroutines.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkerParameters;
import androidx.work.impl.d0;
import androidx.work.impl.u;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class StartWorkRunnable implements Runnable {
    private WorkerParameters.a mRuntimeExtras;
    private d0 mWorkManagerImpl;
    private u mWorkSpecId;

    public StartWorkRunnable(@NonNull d0 d0Var, @NonNull u uVar, @Nullable WorkerParameters.a aVar) {
        this.mWorkManagerImpl = d0Var;
        this.mWorkSpecId = uVar;
        this.mRuntimeExtras = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkManagerImpl.q().q(this.mWorkSpecId, this.mRuntimeExtras);
    }
}
