package com.transsion.wrapperad.install;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.g0;
import androidx.lifecycle.u;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f {
    public static final b a = new b();
    private static Context b;
    private static AppChangeReceiver c;
    private static boolean d;

    private b() {
    }

    private final String a() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void c() {
        if (d) {
            return;
        }
        c = new AppChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        Context context = null;
        if (Build.VERSION.SDK_INT >= 33) {
            Context context2 = b;
            if (context2 == null) {
                Intrinsics.y("appContext");
            } else {
                context = context2;
            }
            com.bytedance.sdk.openadsdk.core.settings.a.a(context, c, intentFilter, 4);
        } else {
            Context context3 = b;
            if (context3 == null) {
                Intrinsics.y("appContext");
            } else {
                context = context3;
            }
            context.registerReceiver(c, intentFilter);
        }
        d = true;
    }

    private final void d() {
        if (d) {
            AppChangeReceiver appChangeReceiver = c;
            if (appChangeReceiver != null) {
                try {
                    Context context = b;
                    if (context == null) {
                        Intrinsics.y("appContext");
                        context = null;
                    }
                    context.unregisterReceiver(appChangeReceiver);
                } catch (IllegalArgumentException unused) {
                }
            }
            c = null;
            d = false;
        }
    }

    public final void b(Application application) {
        Intrinsics.h(application, "application");
        b = application.getApplicationContext();
        g0.i.a().getLifecycle().a(this);
        a.a.a(a() + " --> init() --> 初始化成功");
    }

    public /* synthetic */ void onCreate(u uVar) {
        e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(u uVar) {
        e.b(this, uVar);
    }

    public /* synthetic */ void onPause(u uVar) {
        e.c(this, uVar);
    }

    public /* synthetic */ void onResume(u uVar) {
        e.d(this, uVar);
    }

    public void onStart(u owner) {
        Intrinsics.h(owner, "owner");
        d();
        c();
    }

    public void onStop(u owner) {
        Intrinsics.h(owner, "owner");
        d();
    }
}
