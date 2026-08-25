package com.transsion.baselib.report;

import android.os.SystemClock;
import qi.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface g {

    public static final class a {
        public static b a(g gVar) {
            return null;
        }

        public static void b(g gVar) {
            b logViewConfig = gVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            qi.h.a.x(logViewConfig);
        }

        public static void c(g gVar) {
            b logViewConfig = gVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.o(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    qi.h.a.y(logViewConfig);
                }
            }
        }
    }

    b getLogViewConfig();
}
