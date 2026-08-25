package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class g {

    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f7020a;

        a(Handler handler) {
            this.f7020a = (Handler) androidx.core.util.i.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f7020a.post((Runnable) androidx.core.util.i.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f7020a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
