package com.tn.tranpay.report;

import android.os.SystemClock;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface b {

    public static final class a {
        public static c a(b bVar) {
            return null;
        }

        public static void b(b bVar) {
            c logViewConfig = bVar.getLogViewConfig();
            if (logViewConfig == null || !logViewConfig.d()) {
                return;
            }
            e.a.f(logViewConfig);
        }

        public static void c(b bVar) {
            c logViewConfig = bVar.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(SystemClock.elapsedRealtime());
                if (logViewConfig.c()) {
                    e.a.g(logViewConfig);
                }
            }
        }
    }

    c getLogViewConfig();
}
