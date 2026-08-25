package com.transsnet.flow.event;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();
    public static Application b;
    private static c c;

    private b() {
    }

    public final Application a() {
        Application application = b;
        if (application != null) {
            return application;
        }
        Intrinsics.y("application");
        return null;
    }

    public final c b() {
        return c;
    }

    public final void c(Application application) {
        Intrinsics.h(application, "application");
        a.d(application);
        c = new d();
    }

    public final void d(Application application) {
        Intrinsics.h(application, "<set-?>");
        b = application;
    }
}
