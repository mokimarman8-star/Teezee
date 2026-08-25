package pg;

import java.lang.Thread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pg.f;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class f {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(og.b bVar, String str, Thread thread, Throwable th) {
            Intrinsics.e(th);
            bVar.b(str, th);
        }

        public final void b(Thread thread, final String str, final og.b bVar) {
            Intrinsics.h(thread, "thread");
            Intrinsics.h(str, "name");
            Intrinsics.h(bVar, "runnableCallback");
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: pg.e
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th) {
                    f.a.c(og.b.this, str, thread2, th);
                }
            });
            thread.setName(str);
        }
    }
}
