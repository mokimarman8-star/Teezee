package qi;

import android.os.SystemClock;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: qi.a$a, reason: collision with other inner class name */
    public static final class C0089a {
        public static b a(a aVar) {
            return null;
        }

        public static void b(a aVar) {
            b logViewConfig = aVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            h.a.x(logViewConfig);
        }

        public static void c(a aVar) {
            b logViewConfig = aVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.o(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    h.a.y(logViewConfig);
                }
            }
        }
    }

    b getLogViewConfig();
}
