package com.wecloud.load.lib;

import android.util.Log;
import com.google.gson.Gson;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l {
    public static final l a = new l();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.wecloud.load.lib.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Gson c2;
            c2 = l.c();
            return c2;
        }
    });
    private static volatile Boolean c;

    private l() {
    }

    private final Gson b() {
        return (Gson) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson c() {
        return new Gson();
    }

    private final String e() {
        try {
            ConfigBean d = cm.f.d(cm.f.c.a(), "network_probe", false, 2, (Object) null);
            String value = d != null ? d.getValue() : null;
            if (value != null && value.length() != 0) {
                int length = value.length();
                StringBuilder sb = new StringBuilder();
                sb.append("got network_probe remote config JSON from ConfigManager, key=network_probe, length=");
                sb.append(length);
                sb.append(", value=");
                sb.append(value);
                return value;
            }
            return null;
        } catch (Exception e) {
            Log.w("NativeProbeCfgLoader", "load network_probe config from ConfigManager failed: " + e.getMessage(), e);
            return null;
        }
    }

    public final boolean d() {
        Object obj;
        NativeProbeRemoteConfig nativeProbeRemoteConfig;
        Boolean enableOnlineProbe;
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Result$Companion result$Companion = Result.Companion;
            String e = e();
            boolean z = false;
            if (e != null) {
                String obj2 = StringsKt.n1(e).toString();
                if (StringsKt.W(obj2, "\"", false, 2, null) && StringsKt.G(obj2, "\"", false, 2, null)) {
                    try {
                        String str = (String) b().fromJson(obj2, String.class);
                        String obj3 = str != null ? StringsKt.n1(str).toString() : null;
                        obj2 = obj3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : obj3;
                    } catch (Exception unused) {
                    }
                }
                String lowerCase = obj2.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                if (Intrinsics.c(lowerCase, "true")) {
                    z = true;
                } else if (!Intrinsics.c(lowerCase, "false") && (nativeProbeRemoteConfig = (NativeProbeRemoteConfig) b().fromJson(obj2, NativeProbeRemoteConfig.class)) != null && (enableOnlineProbe = nativeProbeRemoteConfig.getEnableOnlineProbe()) != null) {
                    z = enableOnlineProbe.booleanValue();
                }
            }
            obj = Result.constructor-impl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Log.w("NativeProbeCfgLoader", "parse network_probe remote config failed: " + th2.getMessage(), th2);
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.isFailure-impl(obj)) {
            obj = bool2;
        }
        Boolean bool3 = (Boolean) obj;
        boolean booleanValue = bool3.booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append("network_probe remote config parsed successfully: enabled=");
        sb.append(booleanValue);
        c = bool3;
        return booleanValue;
    }
}
