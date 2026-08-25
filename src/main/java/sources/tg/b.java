package tg;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: tg.a
        public final Object invoke() {
            MMKV p;
            p = b.p();
            return p;
        }
    });
    private static String c;
    private static String d;
    private static String e;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV p() {
        return MMKV.I("vshow");
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        if (context instanceof Application) {
            String string = m().getString("apkgaid", "");
            if (TextUtils.isEmpty(string)) {
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                ug.b.c.a(context, intent);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("gid has get gid ");
                sb.append(string);
            }
        }
    }

    public final String c() {
        if (TextUtils.isEmpty(c)) {
            c = m().getString("apkandroidid", "");
        }
        String str = c;
        if (TextUtils.isEmpty(str)) {
            try {
                Result.Companion companion = Result.Companion;
                Application a2 = Utils.a();
                str = Settings.System.getString(a2 != null ? a2.getContentResolver() : null, "android_id");
                Result.m34constructorimpl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
        return str == null ? "" : str;
    }

    public final String d() {
        String str = Build.BRAND;
        Intrinsics.g(str, "BRAND");
        return str;
    }

    public final String e() {
        return StringsKt.Q(StringsKt.Q(ArraysKt.c(Build.SUPPORTED_ABIS), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
    }

    public final String f() {
        String country = Locale.getDefault().getCountry();
        Intrinsics.g(country, "getCountry(...)");
        return country;
    }

    public final String g() {
        Application a2 = Utils.a();
        Object systemService = a2 != null ? a2.getSystemService("phone") : null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        if (simCountryIso == null || simCountryIso.length() == 0) {
            if (telephonyManager != null) {
                return telephonyManager.getNetworkCountryIso();
            }
            return null;
        }
        if (telephonyManager != null) {
            return telephonyManager.getSimCountryIso();
        }
        return null;
    }

    public final String h() {
        String str;
        if (TextUtils.isEmpty(e)) {
            e = m().getString("apkdeviceid", "");
        }
        String valueOf = String.valueOf(e);
        if (TextUtils.isEmpty(c)) {
            c = m().getString("apkandroidid", "");
        }
        String valueOf2 = String.valueOf(c);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        if (!TextUtils.isEmpty(valueOf2)) {
            String d2 = wg.a.a.d(valueOf2);
            r(d2);
            return d2;
        }
        try {
            Result.Companion companion = Result.Companion;
            Application a2 = Utils.a();
            str = Settings.System.getString(a2 != null ? a2.getContentResolver() : null, "android_id");
            Intrinsics.g(str, "getString(...)");
        } catch (Throwable th) {
            th = th;
        }
        try {
            Result.m34constructorimpl(Unit.a);
        } catch (Throwable th2) {
            valueOf2 = str;
            th = th2;
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
            str = valueOf2;
            if (TextUtils.isEmpty(str)) {
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            String d3 = wg.a.a.d(uuid);
            r(d3);
            return d3;
        }
        if (TextUtils.isEmpty(str) && !Intrinsics.c(str, "9774d56d682e549c")) {
            String d4 = wg.a.a.d(str);
            r(d4);
            q(str);
            return d4;
        }
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.g(uuid2, "toString(...)");
        String d32 = wg.a.a.d(uuid2);
        r(d32);
        return d32;
    }

    public final String i() {
        if (TextUtils.isEmpty(d)) {
            d = m().getString("apkgaid", "");
        }
        String valueOf = String.valueOf(d);
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        return uuid;
    }

    public final String j() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.e(language);
        return language;
    }

    public final ActivityManager.MemoryInfo k(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("activity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final String l() {
        String str = Build.MODEL;
        Intrinsics.g(str, "MODEL");
        return str;
    }

    public final MMKV m() {
        return (MMKV) b.getValue();
    }

    public final String n() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.g(str, "RELEASE");
        return str;
    }

    public final String o() {
        Object systemService = Utils.a().getSystemService("phone");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simOperator = ((TelephonyManager) systemService).getSimOperator();
        Intrinsics.g(simOperator, "getSimOperator(...)");
        return simOperator;
    }

    public final void q(String str) {
        Intrinsics.h(str, "androidId");
        m().putString("apkandroidid", str);
    }

    public final void r(String str) {
        Intrinsics.h(str, "deviceId");
        m().putString("apkdeviceid", str);
    }

    public final void s(String str) {
        Intrinsics.h(str, "gid");
        m().putString("apkgaid", str);
    }
}
