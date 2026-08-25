package com.transsion.baselib.locale;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.appcompat.app.h;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import n0.d;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d$a implements ComponentCallbacks2 {
    final /* synthetic */ d a;
    final /* synthetic */ Context b;

    d$a(d dVar, Context context) {
        this.a = dVar;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d dVar, Locale locale, Locale locale2, Context context) {
        if (dVar.j() == locale) {
            String country = locale2.getCountry();
            Intrinsics.g(country, "getCountry(...)");
            d.g(dVar, (String) null, country, true);
        } else {
            Intrinsics.e(context);
            d.i(dVar, context, dVar.j());
        }
        a.a.f(a.a, "LocaleManager", "onConfigurationChanged()-> locale = " + locale2, false, 4, (Object) null);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.h(configuration, "newConfig");
        final Locale a = Build.VERSION.SDK_INT >= 24 ? d.a(h.a(configuration), 0) : configuration.locale;
        final Locale f = d.f(this.a);
        if (Intrinsics.c(a, f)) {
            return;
        }
        d dVar = this.a;
        Intrinsics.e(a);
        d.h(dVar, a);
        final d dVar2 = this.a;
        final Context context = this.b;
        ThreadUtils.j(new Runnable() { // from class: com.transsion.baselib.locale.c
            @Override // java.lang.Runnable
            public final void run() {
                d$a.b(dVar2, f, a, context);
            }
        });
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }
}
