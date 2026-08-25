package com.transsion.baselib.locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class LocaleChangedHelper {
    public static final LocaleChangedHelper a = new LocaleChangedHelper();

    private LocaleChangedHelper() {
    }

    public final void a(Context context, String str) {
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context.getPackageName() + "_LOCALE_CHANGED_ACTION");
        intent.putExtra("key.string.language", str);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        IntentFilter intentFilter = new IntentFilter(context.getPackageName() + "_LOCALE_CHANGED_ACTION");
        if (Build.VERSION.SDK_INT >= 33) {
            com.bytedance.sdk.openadsdk.core.settings.a.a(context.getApplicationContext(), new BroadcastReceiver() { // from class: com.transsion.baselib.locale.LocaleChangedHelper$registerLocalChangeReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Intrinsics.h(context2, "context");
                    Intrinsics.h(intent, "intent");
                    d.f.e().n(intent.getStringExtra("key.string.language"));
                }
            }, intentFilter, 2);
        } else {
            context.getApplicationContext().registerReceiver(new registerLocalChangeReceiver.2(), intentFilter);
        }
    }
}
