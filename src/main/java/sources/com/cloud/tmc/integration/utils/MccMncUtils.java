package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.utils.ext.SystemServiceExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0010"}, d2 = {"Lcom/cloud/tmc/integration/utils/MccMncUtils;", "", "()V", "getCountryCode", "", "context", "Landroid/content/Context;", "getCountryCodeByLang", "getCountryCodeBySim", "getCountryCodeBySimOrLang", "getLanguageStr", "getLocale", "Ljava/util/Locale;", "getMcc", "getMnc", "getSimOperator", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class MccMncUtils {
    public static final MccMncUtils INSTANCE = new MccMncUtils();

    private MccMncUtils() {
    }

    @JvmStatic
    public static final String getCountryCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = SystemServiceExtKt.getTelephonyManager(context);
            String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
            if (simCountryIso == null) {
                simCountryIso = "";
            }
            if (simCountryIso.length() == 0) {
                return getCountryCodeByLang(context);
            }
            Locale locale = Locale.US;
            Intrinsics.g(locale, "US");
            String upperCase = simCountryIso.toUpperCase(locale);
            Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String getCountryCodeByLang(Context context) {
        Intrinsics.h(context, "context");
        try {
            Locale locale = getLocale();
            String country = locale != null ? locale.getCountry() : null;
            if (country == null) {
                country = "";
            }
            Locale locale2 = Locale.US;
            Intrinsics.g(locale2, "US");
            String upperCase = country.toUpperCase(locale2);
            Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String getCountryCodeBySim(Context context) {
        Intrinsics.h(context, "context");
        try {
            TelephonyManager telephonyManager = SystemServiceExtKt.getTelephonyManager(context);
            String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
            if (simCountryIso == null) {
                simCountryIso = "";
            }
            Locale locale = Locale.US;
            Intrinsics.g(locale, "US");
            String upperCase = simCountryIso.toUpperCase(locale);
            Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final Locale getLocale() {
        try {
            androidx.core.os.i a = androidx.core.os.f.a(Resources.getSystem().getConfiguration());
            Intrinsics.g(a, "getLocales(Resources.getSystem().configuration)");
            return a.f() ? Locale.getDefault() : a.d(0);
        } catch (Throwable unused) {
            return Locale.getDefault();
        }
    }

    @JvmStatic
    public static final String getMcc(Context context) {
        Intrinsics.h(context, "context");
        String simOperator = getSimOperator(context);
        if (simOperator.length() < 3) {
            return "";
        }
        String substring = simOperator.substring(0, 3);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmStatic
    public static final String getMnc(Context context) {
        Intrinsics.h(context, "context");
        String simOperator = getSimOperator(context);
        if (simOperator.length() < 3) {
            return "";
        }
        String substring = simOperator.substring(3);
        Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @JvmStatic
    public static final String getSimOperator(Context context) {
        Intrinsics.h(context, "context");
        try {
            TelephonyManager telephonyManager = SystemServiceExtKt.getTelephonyManager(context);
            String simOperator = telephonyManager != null ? telephonyManager.getSimOperator() : null;
            return simOperator == null ? "" : simOperator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String getCountryCodeBySimOrLang(Context context) {
        Intrinsics.h(context, "context");
        String countryCodeBySim = getCountryCodeBySim(context);
        return countryCodeBySim.length() > 0 ? countryCodeBySim : getCountryCodeByLang(context);
    }

    public final String getLanguageStr() {
        try {
            String language = Locale.getDefault().getLanguage();
            Intrinsics.g(language, "{\n            Locale.get…ault().language\n        }");
            return language;
        } catch (Throwable th) {
            TmcLogger.e("getLanguage", th);
            return "";
        }
    }
}
