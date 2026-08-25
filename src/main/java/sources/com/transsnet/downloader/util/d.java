package com.transsnet.downloader.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PowerManager;
import cm.f;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.dialog.RequestAuthorizationDialog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    public static final d a = new d();
    private static boolean b;

    private d() {
    }

    public static /* synthetic */ void f(d dVar, Context context, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        dVar.e(context, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Ref.BooleanRef booleanRef, Context context, String str, Function0 function0) {
        booleanRef.element = true;
        a.l(context, str, function0);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.BooleanRef booleanRef, Context context, DialogInterface dialogInterface) {
        if (booleanRef.element) {
            return;
        }
        ff.c.a.c(context);
    }

    public static /* synthetic */ void m(d dVar, Context context, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        dVar.l(context, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.a;
    }

    public final void d() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        bVar.b().putLong("key_showed_times", bVar.b().getLong("key_showed_times", 0L) + 1);
        bVar.b().putLong("key_show_last_time", System.currentTimeMillis());
    }

    public final void e(final Context context, final String pageFrom, final Function0 function0) {
        String value;
        Integer v;
        String value2;
        Long x;
        Intrinsics.h(context, "context");
        Intrinsics.h(pageFrom, "pageFrom");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        long j = 0;
        long j2 = bVar.b().getLong("key_show_last_time", 0L);
        long j3 = bVar.b().getLong("key_showed_times", 0L);
        f.a aVar = cm.f.c;
        ConfigBean c = aVar.a().c("key_total_show_times", false);
        long longValue = (c == null || (value2 = c.getValue()) == null || (x = StringsKt.x(value2)) == null) ? 3L : x.longValue();
        long j4 = longValue > 0 ? longValue : 3L;
        ConfigBean c2 = aVar.a().c("sb_battery_interval_day", false);
        int intValue = (c2 == null || (value = c2.getValue()) == null || (v = StringsKt.v(value)) == null) ? 10 : v.intValue();
        int i = intValue > 0 ? intValue : 10;
        boolean f = com.blankj.utilcode.util.c0.f(j2);
        if (TimeUtilKt.c() - TimeUtilKt.d(j2) > i) {
            bVar.b().putLong("key_showed_times", 0L);
        } else {
            j = j3;
        }
        if (f || j4 <= j) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (j(context)) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        RequestAuthorizationDialog a2 = RequestAuthorizationDialog.INSTANCE.a();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        a2.t0(new Function0() { // from class: com.transsnet.downloader.util.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g;
                g = d.g(booleanRef, context, pageFrom, function0);
                return g;
            }
        });
        Dialog dialog = a2.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        a2.j0(new DialogInterface.OnDismissListener() { // from class: com.transsnet.downloader.util.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                d.h(booleanRef, context, dialogInterface);
            }
        });
        if (ff.c.a.b(a2, "authorization_dialog")) {
            a2.k0(context, "authorization_dialog");
        }
    }

    public final void i(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        Activity b2 = com.blankj.utilcode.util.a.b();
        if (b2 == null || b2.isFinishing() || b2.isDestroyed()) {
            return;
        }
        f(a, b2, pageFrom, null, 4, null);
    }

    public final boolean j(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(Utils.a().getPackageName());
        if (!b) {
            HashMap hashMap = new HashMap();
            hashMap.put("battery_opt", String.valueOf(isIgnoringBatteryOptimizations));
            qi.h.a.q("battery_opt", "app_perf", hashMap);
            b = true;
        }
        return isIgnoringBatteryOptimizations;
    }

    public final void k(Context context) {
        Intrinsics.h(context, "context");
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            context.startActivity(intent);
            HashMap hashMap = new HashMap();
            hashMap.put("action", "system_battery_page_show");
            qi.h.a.z("download_authorization", hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void l(Context context, String pageFrom, final Function0 function0) {
        Intrinsics.h(context, "context");
        Intrinsics.h(pageFrom, "pageFrom");
        try {
            ActivityPermissionUtil.a.d("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "android.settings.APPLICATION_DETAILS_SETTINGS", 11101, new Function0() { // from class: com.transsnet.downloader.util.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit n;
                    n = d.n(Function0.this);
                    return n;
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("action", "system_dialog_show");
            hashMap.put(WebConstants.PAGE_FROM, pageFrom);
            qi.h.a.z("download_authorization", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
