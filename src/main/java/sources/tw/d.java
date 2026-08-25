package tw;

import android.os.Handler;
import android.os.Looper;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    private static AppChangeInfo b;
    private static a e;
    public static final d a = new d();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
    private static final Handler f = new Handler(Looper.getMainLooper());

    private d() {
    }

    private final void d(AppChangeInfo appChangeInfo) {
        if (appChangeInfo == null) {
            com.transsion.wrapperad.install.a.a.a(i() + " --> displayTask() --> info == null");
            b = null;
            c.set(false);
            return;
        }
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.get()) {
            com.transsion.wrapperad.install.a.a.a(i() + " --> displayTask() --> isTaskShowing == true");
            return;
        }
        atomicBoolean.set(true);
        b = appChangeInfo;
        final int l = mw.a.a.l();
        Handler handler = f;
        handler.post(new Runnable() { // from class: tw.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(l);
            }
        });
        handler.postDelayed(new Runnable() { // from class: tw.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f();
            }
        }, l * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i) {
        a aVar = e;
        if (aVar != null) {
            aVar.onAppInstalledTipStart();
        }
        com.transsion.wrapperad.install.a aVar2 = com.transsion.wrapperad.install.a.a;
        String i2 = a.i();
        a aVar3 = e;
        aVar2.a(i2 + " --> displayTask() --> listener = " + (aVar3 != null ? Integer.valueOf(aVar3.hashCode()) : null) + " --> items = " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        b = null;
        com.transsion.wrapperad.install.a aVar = com.transsion.wrapperad.install.a.a;
        d dVar = a;
        aVar.a(dVar.i() + " --> displayTask() --> 时间到自动关闭");
        a aVar2 = e;
        if (aVar2 != null) {
            aVar2.onAppInstalledTipEnd();
        }
        c.set(false);
        aVar.a(dVar.i() + " --> displayTask() --> isTaskShowing = false");
        dVar.g();
    }

    private final String i() {
        String simpleName = a.getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c(AppChangeInfo info) {
        Intrinsics.h(info, "info");
        d.add(info);
        com.transsion.wrapperad.install.a.a.a(i() + " --> addAppChangeInfo() --> " + info.getPackageName());
        g();
    }

    public final void g() {
        AppChangeInfo appChangeInfo = (AppChangeInfo) d.poll();
        f.removeCallbacksAndMessages(null);
        com.transsion.wrapperad.install.a.a.a(i() + " --> doNextTask() --> " + (appChangeInfo != null ? appChangeInfo.getPackageName() : null) + " --> 消息清空");
        d(appChangeInfo);
    }

    public final AppChangeInfo h() {
        AppChangeInfo appChangeInfo = b;
        if (appChangeInfo != null) {
            return appChangeInfo;
        }
        g();
        return b;
    }

    public final void j(a aVar) {
        e = aVar;
    }
}
