package hr;

import android.os.SystemClock;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface e {

    public static final class a {
        public static qi.b a(e eVar) {
            return null;
        }

        public static void b(e eVar) {
            qi.b logViewConfig = eVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            h.a.x(logViewConfig);
        }

        public static void c(e eVar) {
            qi.b logViewConfig = eVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.o(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    h.a.y(logViewConfig);
                }
            }
        }
    }

    qi.b getLogViewConfig();
}
