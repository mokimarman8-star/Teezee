package com.transsion.subtitle_download.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import okhttp3.HttpUrl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/subtitle_download/bean/SubtitleAppType;", HttpUrl.FRAGMENT_ENCODE_SET, "value", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MB", "NOVEL", "SubtitleDownload_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SubtitleAppType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubtitleAppType[] $VALUES;
    public static final SubtitleAppType MB = new SubtitleAppType("MB", 0, "mb");
    public static final SubtitleAppType NOVEL = new SubtitleAppType("NOVEL", 1, "novel");
    private final String value;

    private static final /* synthetic */ SubtitleAppType[] $values() {
        return new SubtitleAppType[]{MB, NOVEL};
    }

    static {
        SubtitleAppType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private SubtitleAppType(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<SubtitleAppType> getEntries() {
        return $ENTRIES;
    }

    public static SubtitleAppType valueOf(String str) {
        return (SubtitleAppType) Enum.valueOf(SubtitleAppType.class, str);
    }

    public static SubtitleAppType[] values() {
        return (SubtitleAppType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
