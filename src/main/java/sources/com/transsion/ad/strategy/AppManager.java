package com.transsion.ad.strategy;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppManager {
    public static final AppManager a = new AppManager();
    private static AppEnum b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/ad/strategy/AppManager$AppEnum;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_MOVIE_BOX", "APP_NOVEL_HUB", "APP_WOW_FM", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AppEnum[] $VALUES;
        public static final AppEnum APP_MOVIE_BOX = new AppEnum("APP_MOVIE_BOX", 0, "movie_box");
        public static final AppEnum APP_NOVEL_HUB = new AppEnum("APP_NOVEL_HUB", 1, "novel_hub");
        public static final AppEnum APP_WOW_FM = new AppEnum("APP_WOW_FM", 2, "wow_fm");
        private final String value;

        private static final /* synthetic */ AppEnum[] $values() {
            return new AppEnum[]{APP_MOVIE_BOX, APP_NOVEL_HUB, APP_WOW_FM};
        }

        static {
            AppEnum[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private AppEnum(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AppEnum> getEntries() {
            return $ENTRIES;
        }

        public static AppEnum valueOf(String str) {
            return (AppEnum) Enum.valueOf(AppEnum.class, str);
        }

        public static AppEnum[] values() {
            return (AppEnum[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private AppManager() {
    }

    public final String a() {
        String value;
        AppEnum appEnum = b;
        if (appEnum != null && (value = appEnum.getValue()) != null) {
            return value;
        }
        String string = e.a.c().getString("mmkv_key_app_name", "none");
        return string == null ? "default_null" : string;
    }

    public final void b(AppEnum appEnum) {
        Intrinsics.h(appEnum, "app");
        b = appEnum;
        e.a.c().putString("mmkv_key_app_name", appEnum.getValue());
    }
}
