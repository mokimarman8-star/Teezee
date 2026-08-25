package androidx.coroutines.impl.utils.futures;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
