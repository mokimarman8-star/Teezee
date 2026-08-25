package com.tn.tranpay.device;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.TranPay;
import java.util.UUID;
import kh.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TNDeviceHelper {
    public static final TNDeviceHelper a = new TNDeviceHelper();
    private static final Lazy b = LazyKt.b(new Function0<MMKV>() { // from class: com.tn.tranpay.device.TNDeviceHelper$tranMmkv$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MMKV m122invoke() {
            return MMKV.I("tran_v_show");
        }
    });
    private static String c;
    private static String d;
    private static String e;

    private TNDeviceHelper() {
    }

    private final MMKV e() {
        Object value = b.getValue();
        Intrinsics.g(value, "<get-tranMmkv>(...)");
        return (MMKV) value;
    }

    public final void a(Context context) {
        Intrinsics.h(context, "context");
        if (!(context instanceof Application)) {
            System.out.println((Object) "please pass in application to avoid Service not registered exception ");
            return;
        }
        String string = e().getString("sdk_ga_id", "");
        if (TextUtils.isEmpty(string)) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            b.c.a(context, intent);
        } else {
            System.out.println((Object) ("gid has get gid " + string));
        }
    }

    public final String b() {
        if (TextUtils.isEmpty(c)) {
            c = e().getString("sdk_android_id", "");
        }
        String str = c;
        if (TextUtils.isEmpty(str)) {
            try {
                str = Settings.System.getString(TranPay.a.d().getContentResolver(), "android_id");
            } catch (Exception e2) {
                lh.a.e(lh.a.a, "Failed to get Android ID: " + e2.getMessage(), null, 2, null);
                str = "";
            }
        }
        return str == null ? "" : str;
    }

    public final String c() {
        String str = "";
        if (TextUtils.isEmpty(e)) {
            e = e().getString("sdk_device_id", "");
        }
        String valueOf = String.valueOf(e);
        if (TextUtils.isEmpty(c)) {
            c = e().getString("sdk_android_id", "");
        }
        String valueOf2 = String.valueOf(c);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        if (!TextUtils.isEmpty(valueOf2)) {
            String a2 = a.a.a(valueOf2);
            g(a2);
            return a2;
        }
        try {
            String string = Settings.System.getString(TranPay.a.d().getContentResolver(), "android_id");
            Intrinsics.g(string, "{\n            // 使用 Tran…D\n            )\n        }");
            str = string;
        } catch (Exception e2) {
            lh.a.e(lh.a.a, "Failed to get Android ID: " + e2.getMessage(), null, 2, null);
        }
        if (!TextUtils.isEmpty(str) && !Intrinsics.c(str, "9774d56d682e549c")) {
            String a3 = a.a.a(str);
            g(a3);
            f(str);
            return a3;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "randomUUID().toString()");
        String a4 = a.a.a(uuid);
        g(a4);
        return a4;
    }

    public final String d() {
        if (TextUtils.isEmpty(d)) {
            d = e().getString("sdk_ga_id", "");
        }
        String valueOf = String.valueOf(d);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final void f(String str) {
        Intrinsics.h(str, "androidId");
        e().putString("sdk_android_id", str);
    }

    public final void g(String str) {
        Intrinsics.h(str, "deviceId");
        e().putString("sdk_device_id", str);
    }

    public final void h(String str) {
        Intrinsics.h(str, "gid");
        e().putString("sdk_ga_id", str);
    }
}
