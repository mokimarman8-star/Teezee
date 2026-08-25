package com.vungle.ads.internal.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.persistence.b;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class PrivacyManager {
    private static PrivacyConsent ccpaConsent;
    private static b filePreferences;
    private static String gdprConsent;
    private static String gdprConsentMessageVersion;
    private static String gdprConsentSource;
    private static Long gdprConsentTimestamp;
    private static SharedPreferences sharedPreferences;
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/privacy/PrivacyManager$DeviceIdAllowed;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "ALLOW_ID", "DISABLE_ID", "FALLBACK", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public enum DeviceIdAllowed {
        ALLOW_ID,
        DISABLE_ID,
        FALLBACK
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DeviceIdAllowed.values().length];
            iArr[DeviceIdAllowed.DISABLE_ID.ordinal()] = 1;
            iArr[DeviceIdAllowed.FALLBACK.ordinal()] = 2;
            iArr[DeviceIdAllowed.ALLOW_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConfigPayload.IABSettings.TcfStatus.values().length];
            iArr2[ConfigPayload.IABSettings.TcfStatus.DISABLE_ID.ordinal()] = 1;
            iArr2[ConfigPayload.IABSettings.TcfStatus.ALLOW_ID.ordinal()] = 2;
            iArr2[ConfigPayload.IABSettings.TcfStatus.LEGACY.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private PrivacyManager() {
    }

    private final void saveCcpaConsent(PrivacyConsent privacyConsent) {
        b put;
        b bVar = filePreferences;
        if (bVar == null || (put = bVar.put("ccpa_status", privacyConsent.getValue())) == null) {
            return;
        }
        put.apply();
    }

    private final void saveCoppaConsent(boolean z) {
        b put;
        b bVar = filePreferences;
        if (bVar == null || (put = bVar.put("is_coppa", z)) == null) {
            return;
        }
        put.apply();
    }

    private final void saveGdprConsent(String str, String str2, String str3, long j) {
        b put;
        b put2;
        b put3;
        b put4;
        b bVar = filePreferences;
        if (bVar == null || (put = bVar.put("gdpr_status", str)) == null || (put2 = put.put("gdpr_source", str2)) == null || (put3 = put2.put("gdpr_message_version", str3)) == null || (put4 = put3.put("gdpr_timestamp", j)) == null) {
            return;
        }
        put4.apply();
    }

    public final DeviceIdAllowed allowDeviceIDFromTCF() {
        Boolean gdprAppliesFromPreferences = getGdprAppliesFromPreferences();
        if (!Intrinsics.c(gdprAppliesFromPreferences, Boolean.TRUE)) {
            return gdprAppliesFromPreferences == null ? DeviceIdAllowed.FALLBACK : DeviceIdAllowed.ALLOW_ID;
        }
        ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
        int i = tcfStatus == null ? -1 : a.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return DeviceIdAllowed.DISABLE_ID;
            }
            if (i == 2) {
                return DeviceIdAllowed.ALLOW_ID;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return DeviceIdAllowed.FALLBACK;
    }

    public final String getCcpaStatus() {
        String value;
        PrivacyConsent privacyConsent = ccpaConsent;
        return (privacyConsent == null || (value = privacyConsent.getValue()) == null) ? PrivacyConsent.OPT_IN.getValue() : value;
    }

    public final String getConsentMessageVersion() {
        String str = gdprConsentMessageVersion;
        return str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
    }

    public final String getConsentSource() {
        String str = gdprConsentSource;
        return str == null ? "no_interaction" : str;
    }

    public final String getConsentStatus() {
        String str = gdprConsent;
        return str == null ? "unknown" : str;
    }

    public final long getConsentTimestamp() {
        Long l = gdprConsentTimestamp;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final COPPA getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        return atomicReference.get() == null ? COPPA.COPPA_NOTSET : Intrinsics.c(atomicReference.get(), Boolean.TRUE) ? COPPA.COPPA_ENABLED : Intrinsics.c(atomicReference.get(), Boolean.FALSE) ? COPPA.COPPA_DISABLED : COPPA.COPPA_NOTSET;
    }

    public final Boolean getDisableAdId$vungle_ads_release() {
        return disableAdId.get();
    }

    public final Boolean getGdprAppliesFromPreferences() {
        Object obj;
        Object obj2;
        Integer num;
        String string;
        try {
            Result$Companion result$Companion = Result.Companion;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            obj = Result.constructor-impl(sharedPreferences2 != null ? Integer.valueOf(sharedPreferences2.getInt("IABTCF_gdprApplies", -1)) : null);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 == null || (string = sharedPreferences3.getString("IABTCF_gdprApplies", "-1")) == null) {
                    num = null;
                } else {
                    Intrinsics.g(string, "getString(IABTCF_GDPR_APPLIES, \"-1\")");
                    num = Integer.valueOf(Integer.parseInt(string));
                }
                obj2 = Result.constructor-impl(num);
            } catch (Throwable th2) {
                Result$Companion result$Companion3 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.a(th2));
            }
            obj = obj2;
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num2 = (Integer) obj;
        if (num2 != null && num2.intValue() == 1) {
            return Boolean.TRUE;
        }
        if (num2 != null && num2.intValue() == 0) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final String getIABTCFString() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString("IABTCF_TCString", HttpUrl.FRAGMENT_ENCODE_SET) : null;
        return string == null ? HttpUrl.FRAGMENT_ENCODE_SET : string;
    }

    public final String getPreviousTcfToken() {
        b bVar = filePreferences;
        if (bVar != null) {
            return bVar.getString("previous_tcf_token", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        return null;
    }

    public final SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public final synchronized void init(Context context) {
        Intrinsics.h(context, "context");
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.get()) {
            o.Companion.w("PrivacyManager", "PrivacyManager already initialized");
            return;
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        b bVar = (b) ServiceLocator.Companion.getInstance(context).getService(b.class);
        filePreferences = bVar;
        AtomicReference<Boolean> atomicReference = disableAdId;
        Boolean bool = atomicReference.get();
        if (bool != null) {
            saveDisableAdId(bool.booleanValue());
        } else {
            Boolean bool2 = bVar.getBoolean("disable_ad_id");
            if (bool2 != null) {
                atomicReference.set(bool2);
            }
        }
        String str = gdprConsent;
        if (str != null) {
            String str2 = gdprConsentSource;
            if (str2 == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String str3 = str2;
            String str4 = gdprConsentMessageVersion;
            if (str4 == null) {
                str4 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String str5 = str4;
            Long l = gdprConsentTimestamp;
            saveGdprConsent(str, str3, str5, l != null ? l.longValue() : 0L);
        } else {
            String string = bVar.getString("gdpr_status");
            PrivacyConsent privacyConsent = PrivacyConsent.OPT_IN;
            if (Intrinsics.c(string, privacyConsent.getValue())) {
                string = privacyConsent.getValue();
            } else {
                PrivacyConsent privacyConsent2 = PrivacyConsent.OPT_OUT;
                if (Intrinsics.c(string, privacyConsent2.getValue())) {
                    string = privacyConsent2.getValue();
                }
            }
            gdprConsent = string;
            gdprConsentSource = bVar.getString("gdpr_source");
            gdprConsentMessageVersion = bVar.getString("gdpr_message_version");
            gdprConsentTimestamp = Long.valueOf(bVar.getLong("gdpr_timestamp", 0L));
        }
        PrivacyConsent privacyConsent3 = ccpaConsent;
        if (privacyConsent3 != null) {
            saveCcpaConsent(privacyConsent3);
        } else {
            String string2 = bVar.getString("ccpa_status");
            PrivacyConsent privacyConsent4 = PrivacyConsent.OPT_OUT;
            if (!Intrinsics.c(privacyConsent4.getValue(), string2)) {
                privacyConsent4 = PrivacyConsent.OPT_IN;
            }
            ccpaConsent = privacyConsent4;
        }
        AtomicReference<Boolean> atomicReference2 = coppaStatus;
        Boolean bool3 = atomicReference2.get();
        if (bool3 != null) {
            saveCoppaConsent(bool3.booleanValue());
        } else {
            Boolean bool4 = bVar.getBoolean("is_coppa");
            if (bool4 != null) {
                atomicReference2.set(bool4);
            }
        }
        atomicBoolean.set(true);
    }

    public final void saveDisableAdId(boolean z) {
        b put;
        b bVar = filePreferences;
        if (bVar == null || (put = bVar.put("disable_ad_id", z)) == null) {
            return;
        }
        put.apply();
    }

    public final void setPreviousTcfToken(String str) {
        b bVar;
        b put;
        if (str == null || str.length() == 0 || (bVar = filePreferences) == null || (put = bVar.put("previous_tcf_token", str)) == null) {
            return;
        }
        put.apply();
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences2) {
        sharedPreferences = sharedPreferences2;
    }

    public final boolean shouldReturnTrueForLegacy$vungle_ads_release() {
        String iABTCFString = getIABTCFString();
        if (Intrinsics.c(getPreviousTcfToken(), iABTCFString)) {
            return false;
        }
        setPreviousTcfToken(iABTCFString);
        return true;
    }

    public final boolean shouldSendAdIds() {
        int i = a.$EnumSwitchMapping$0[allowDeviceIDFromTCF().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Boolean disableAdId$vungle_ads_release = getDisableAdId$vungle_ads_release();
        return (disableAdId$vungle_ads_release == null || disableAdId$vungle_ads_release.booleanValue()) ? false : true;
    }

    public final boolean shouldSendTCFString() {
        if (!Intrinsics.c(getGdprAppliesFromPreferences(), Boolean.TRUE)) {
            return false;
        }
        ConfigPayload.IABSettings.TcfStatus tcfStatus = ConfigManager.INSTANCE.getTcfStatus();
        int i = tcfStatus == null ? -1 : a.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i != -1) {
            if (i == 1 || i == 2) {
                return true;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return shouldReturnTrueForLegacy$vungle_ads_release();
    }

    public final void updateCcpaConsent(PrivacyConsent consent) {
        Intrinsics.h(consent, "consent");
        ccpaConsent = consent;
        saveCcpaConsent(consent);
    }

    public final void updateCoppaConsent(boolean z) {
        coppaStatus.set(Boolean.valueOf(z));
        saveCoppaConsent(z);
    }

    public final void updateDisableAdId(boolean z) {
        disableAdId.set(Boolean.valueOf(z));
        saveDisableAdId(z);
    }

    public final void updateGdprConsent(String consent, String source, String str) {
        Intrinsics.h(consent, "consent");
        Intrinsics.h(source, "source");
        gdprConsent = consent;
        gdprConsentSource = source;
        gdprConsentMessageVersion = str;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        gdprConsentTimestamp = Long.valueOf(currentTimeMillis);
        String str2 = gdprConsentMessageVersion;
        if (str2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        saveGdprConsent(consent, source, str2, currentTimeMillis);
    }
}
