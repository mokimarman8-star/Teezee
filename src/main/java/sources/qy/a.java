package qy;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a implements Executor {
    public static final a a = new a();

    private a() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
