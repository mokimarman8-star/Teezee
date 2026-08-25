package androidx.coroutines.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.f;
import androidx.work.i;
import androidx.work.impl.utils.futures.a;
import androidx.work.j;
import com.google.common.util.concurrent.r;
import j4.u;
import k4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = j.i("WorkForegroundRunnable");
    final Context mContext;
    final f mForegroundUpdater;
    final a mFuture = a.x();
    final c mTaskExecutor;
    final u mWorkSpec;
    final i mWorker;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context context, @NonNull u uVar, @NonNull i iVar, @NonNull f fVar, @NonNull c cVar) {
        this.mContext = context;
        this.mWorkSpec = uVar;
        this.mWorker = iVar;
        this.mForegroundUpdater = fVar;
        this.mTaskExecutor = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0(a aVar) {
        if (this.mFuture.isCancelled()) {
            aVar.cancel(true);
        } else {
            aVar.v(this.mWorker.d());
        }
    }

    @NonNull
    public r getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.mWorkSpec.q || Build.VERSION.SDK_INT >= 31) {
            this.mFuture.t((Object) null);
            return;
        }
        final a x = a.x();
        this.mTaskExecutor.a().execute(new Runnable() { // from class: androidx.work.impl.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                WorkForegroundRunnable.this.lambda$run$0(x);
            }
        });
        x.addListener(new 1(this, x), this.mTaskExecutor.a());
    }
}
