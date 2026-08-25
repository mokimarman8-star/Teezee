package com.transsion.ad.strategy;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdUrlParameterManager {
    public static final AdUrlParameterManager a = new AdUrlParameterManager();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/strategy/AdUrlParameterManager$UrlParameterReplaceEnum;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GAID", "CUSTOM_USER_ID", "TIME_STAMP", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UrlParameterReplaceEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UrlParameterReplaceEnum[] $VALUES;
        private final String value;
        public static final UrlParameterReplaceEnum GAID = new UrlParameterReplaceEnum("GAID", 0, "GAID");
        public static final UrlParameterReplaceEnum CUSTOM_USER_ID = new UrlParameterReplaceEnum("CUSTOM_USER_ID", 1, "CUSTOM_USER_ID");
        public static final UrlParameterReplaceEnum TIME_STAMP = new UrlParameterReplaceEnum("TIME_STAMP", 2, "TIME_STAMP");

        private static final /* synthetic */ UrlParameterReplaceEnum[] $values() {
            return new UrlParameterReplaceEnum[]{GAID, CUSTOM_USER_ID, TIME_STAMP};
        }

        static {
            UrlParameterReplaceEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private UrlParameterReplaceEnum(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<UrlParameterReplaceEnum> getEntries() {
            return $ENTRIES;
        }

        public static UrlParameterReplaceEnum valueOf(String str) {
            return (UrlParameterReplaceEnum) Enum.valueOf(UrlParameterReplaceEnum.class, str);
        }

        public static UrlParameterReplaceEnum[] values() {
            return (UrlParameterReplaceEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static final class a {
        private final String a;
        private final String b;
        private final String c;

        public a(String str, String str2, String str3) {
            Intrinsics.h(str, "key");
            Intrinsics.h(str2, "value");
            Intrinsics.h(str3, "type");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "UrlParameterReplaceEntity(key=" + this.a + ", value=" + this.b + ", type=" + this.c + ")";
        }
    }

    private AdUrlParameterManager() {
    }

    public final boolean a(String str) {
        Object obj;
        boolean z;
        try {
            Result.Companion companion = Result.Companion;
            z = false;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (str != null && str.length() != 0) {
            String queryParameter = Uri.parse(str).getQueryParameter("mb_system_browser");
            if (queryParameter != null && StringsKt.H(queryParameter, "true", true)) {
                z = true;
            }
            obj = Result.constructor-impl(Boolean.valueOf(z));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(String str, String str2) {
        Intrinsics.h(str, "url");
        try {
            Result.Companion companion = Result.Companion;
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            List<a> f = com.transsion.ad.scene.b.a.f();
            if (f.isEmpty()) {
                return str;
            }
            Uri parse = Uri.parse(str);
            Intrinsics.g(parse, "parse(...)");
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            String str3 = str;
            for (a aVar : f) {
                if (queryParameterNames.contains(aVar.a()) && Intrinsics.c(parse.getQueryParameter(aVar.a()), aVar.c())) {
                    String b = aVar.b();
                    if (Intrinsics.c(b, UrlParameterReplaceEnum.GAID.getValue())) {
                        String c = aVar.c();
                        String e = DeviceUtil.e();
                        Intrinsics.g(e, "getGAId(...)");
                        str3 = StringsKt.Q(str3, c, e, false, 4, (Object) null);
                    } else if (Intrinsics.c(b, UrlParameterReplaceEnum.CUSTOM_USER_ID.getValue())) {
                        str3 = StringsKt.Q(str3, aVar.c(), "custom_use_id_ashdjhv1234dhb", false, 4, (Object) null);
                    } else if (Intrinsics.c(b, UrlParameterReplaceEnum.TIME_STAMP.getValue())) {
                        str3 = StringsKt.Q(str3, aVar.c(), String.valueOf(System.currentTimeMillis()), false, 4, (Object) null);
                    }
                }
            }
            xh.a aVar2 = xh.a.a;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            xh.a.m(aVar2, str2, "AdUrlParameterReplaceManager --> replaceParameter() --> url = " + str + " --> replaceList = " + f + " --> newUrl = " + ((Object) str3), 0, false, 12, null);
            return str3;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.a(th2));
            if (Result.exceptionOrNull-impl(obj) == null) {
                str = obj;
            }
            return str;
        }
    }
}
