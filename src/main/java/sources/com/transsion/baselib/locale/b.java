package com.transsion.baselib.locale;

import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ Locale b;

    public /* synthetic */ b(d dVar, Locale locale) {
        this.a = dVar;
        this.b = locale;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b(this.a, this.b);
    }
}
