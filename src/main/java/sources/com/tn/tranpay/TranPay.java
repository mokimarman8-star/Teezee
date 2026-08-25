package com.tn.tranpay;

import android.app.Application;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPay {
    public static final TranPay a = new TranPay();
    private static Application b;

    private TranPay() {
    }

    public final void a(LoggerPlugin loggerPlugin) {
        Intrinsics.h(loggerPlugin, "plugin");
        lh.a.a.a(loggerPlugin);
    }

    public final void b(Application application, String str, String str2, String str3, LogLevel logLevel, boolean z, boolean z2, String str4, e eVar) {
        Intrinsics.h(application, "application");
        Intrinsics.h(str, "cpId");
        Intrinsics.h(str2, "appKey");
        Intrinsics.h(str3, "channel");
        Intrinsics.h(logLevel, "level");
        Intrinsics.h(eVar, "theme");
        b = application;
        MMKV.C(application);
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
        tranPayConfiguration.x(str);
        tranPayConfiguration.v(str2);
        tranPayConfiguration.w(str3);
        tranPayConfiguration.B(str4);
        tranPayConfiguration.y(z);
        tranPayConfiguration.A(z2);
        e.c.a(eVar);
        lh.a aVar = lh.a.a;
        aVar.h(logLevel, z);
        com.tn.tranpay.event.a.a.b(application);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new TranPay$configure$1(application, z, str4, null), 3, (Object) null);
        lh.a.g(aVar, "TranPay init succeed " + str + ", " + logLevel + ", " + z + ", " + str4, null, 2, null);
        tranPayConfiguration.z(true);
    }

    public final Application d() {
        Application application = b;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("TranPay SDK not initialized. Please call TranPay.configure() first.");
    }

    public final String e() {
        return "1.0.6.2";
    }
}
