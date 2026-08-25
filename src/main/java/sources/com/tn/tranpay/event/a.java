package com.tn.tranpay.event;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public static final a a = new a();
    private static Application b;

    private a() {
    }

    public final Application a() {
        Application application = b;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("TranPay SDK must be initialized by calling TranPay.configure() first! Please ensure TranPay.configure() is called in Application.onCreate() for each process that uses the SDK.");
    }

    public final void b(Application application) {
        Intrinsics.h(application, "application");
        b = application;
    }

    public final boolean c() {
        return b != null;
    }
}
