package androidx.coroutines.impl.utils;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class r implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
