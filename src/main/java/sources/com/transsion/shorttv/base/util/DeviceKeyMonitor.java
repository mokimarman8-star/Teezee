package com.transsion.shorttv.base.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.transsion.gslb.BuildConfig;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class DeviceKeyMonitor {
    public static final a e = new a(null);
    private final Context a;
    private final b b;
    private final String c;
    private BroadcastReceiver d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void onHomeClick();

        void onRecentClick();
    }

    public DeviceKeyMonitor(Context context, b bVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(bVar, "listener");
        this.a = context;
        this.b = bVar;
        this.c = "DeviceKeyMonitor";
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.transsion.shorttv.base.util.DeviceKeyMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.h(context2, "context");
                Intrinsics.h(intent, "intent");
                if (Intrinsics.c(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    String stringExtra = intent.getStringExtra("reason");
                    if (stringExtra == null) {
                        stringExtra = BuildConfig.FLAVOR;
                    }
                    int hashCode = stringExtra.hashCode();
                    if (hashCode != -1408204183) {
                        if (hashCode != 350448461) {
                            if (hashCode == 1092716832 && stringExtra.equals("homekey")) {
                                DeviceKeyMonitor.this.b.onHomeClick();
                                return;
                            }
                            return;
                        }
                        if (!stringExtra.equals("recentapps")) {
                            return;
                        }
                    } else if (!stringExtra.equals("assist")) {
                        return;
                    }
                    DeviceKeyMonitor.this.b.onRecentClick();
                }
            }
        };
        this.d = broadcastReceiver;
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(Build.VERSION.SDK_INT >= 33 ? com.bytedance.sdk.openadsdk.core.settings.a.a(context, broadcastReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2) : context.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS")));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final void b() {
        try {
            Result.Companion companion = Result.Companion;
            BroadcastReceiver broadcastReceiver = this.d;
            if (broadcastReceiver != null) {
                this.a.unregisterReceiver(broadcastReceiver);
                this.d = null;
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }
}
