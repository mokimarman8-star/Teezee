package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class a implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    a() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
