package pg;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c implements Executor {
    public static final a b = new a(null);
    private static final c c = new c();
    private final Handler a = new Handler(Looper.getMainLooper());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: pg.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c(runnable);
                    }
                });
            }
        }
    }
}
