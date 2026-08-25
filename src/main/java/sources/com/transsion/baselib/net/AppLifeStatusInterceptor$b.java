package com.transsion.baselib.net;

import com.transsion.baselib.report.k$a;
import com.transsion.baselib.report.launch.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppLifeStatusInterceptor$b implements k$a {
    final /* synthetic */ AppLifeStatusInterceptor a;

    AppLifeStatusInterceptor$b(AppLifeStatusInterceptor appLifeStatusInterceptor) {
        this.a = appLifeStatusInterceptor;
    }

    @Override // com.transsion.baselib.report.k$a
    public void onBackgroundStatusChange(boolean z) {
        if (z) {
            return;
        }
        b.a.b().putLong("record_latest_foreground_time", System.currentTimeMillis());
        d.a.b().set(true);
        AppLifeStatusInterceptor.c(this.a);
    }
}
