package pq;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static vr.a f16990b;

    /* renamed from: a, reason: collision with root package name */
    public static final c f16989a = new c();

    /* renamed from: c, reason: collision with root package name */
    private static b f16991c = b.f16979e.a();

    private c() {
    }

    public final void a(Function0 function0) {
        Intrinsics.h(function0, "createFactory");
        if (f16990b == null) {
            wf.a.a.c("ShortTv", "checkCreateFactory, null create", true);
            f16990b = (vr.a) function0.invoke();
        }
    }

    public final b b() {
        return f16991c;
    }

    public final vr.a c() {
        return f16990b;
    }

    public final void d(Application application, vr.a aVar) {
        Intrinsics.h(application, "application");
        Intrinsics.h(aVar, "factory");
        f16990b = aVar;
        application.registerActivityLifecycleCallbacks(zq.b.a);
        jr.b.a.c(application);
        com.transsnet.flow.event.b bVar = com.transsnet.flow.event.b.a;
        if (bVar.b() == null) {
            bVar.c(application);
        }
        com.transsion.shorttv.subtitle.manager.b.a.b().init();
    }
}
