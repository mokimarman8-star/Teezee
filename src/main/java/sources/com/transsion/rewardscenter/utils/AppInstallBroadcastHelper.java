package com.transsion.rewardscenter.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppInstallBroadcastHelper {
    private static BroadcastReceiver b;
    public static final AppInstallBroadcastHelper a = new AppInstallBroadcastHelper();
    public static final int c = 8;

    private AppInstallBroadcastHelper() {
    }

    public final void a(Context context, final Function1 function1) {
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(function1, "callback");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        BroadcastReceiver broadcastReceiver = b;
        if (broadcastReceiver != null) {
            try {
                Result.Companion companion = Result.Companion;
                context.unregisterReceiver(broadcastReceiver);
                obj = Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.box-impl(obj);
        }
        b = null;
        try {
            Result.Companion companion3 = Result.Companion;
            BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.transsion.rewardscenter.utils.AppInstallBroadcastHelper$registerAppInstallReceiver$2$receiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Intrinsics.h(context2, "context");
                    Intrinsics.h(intent, "intent");
                    if (Intrinsics.c(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || Intrinsics.c(intent.getAction(), "android.intent.action.PACKAGE_REPLACED")) {
                        Uri data = intent.getData();
                        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
                        if (schemeSpecificPart != null) {
                            function1.invoke(schemeSpecificPart);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(broadcastReceiver2, intentFilter);
            b = broadcastReceiver2;
            Result.constructor-impl(Unit.a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th3));
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        BroadcastReceiver broadcastReceiver = b;
        if (broadcastReceiver != null) {
            try {
                Result.Companion companion = Result.Companion;
                context.unregisterReceiver(broadcastReceiver);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
            b = null;
        }
    }
}
