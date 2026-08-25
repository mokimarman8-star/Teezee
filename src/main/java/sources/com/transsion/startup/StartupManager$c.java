package com.transsion.startup;

import android.app.Application;
import com.transsion.baselib.report.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$c implements k.a {
    final /* synthetic */ StartupManager a;

    StartupManager$c(StartupManager startupManager) {
        this.a = startupManager;
    }

    public void onBackgroundStatusChange(boolean z) {
        if (z) {
            bt.a h = StartupManager.h(this.a);
            Application f = StartupManager.f(this.a);
            if (f == null) {
                Intrinsics.y("app");
                f = null;
            }
            h.b(f);
        }
    }
}
