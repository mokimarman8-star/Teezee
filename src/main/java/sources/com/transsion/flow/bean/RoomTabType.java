package com.transsion.flow.bean;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/moviedetailapi/bean/RoomTabType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "POST", "H5", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomTabType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomTabType[] $VALUES;
    private final String value;
    public static final RoomTabType POST = new RoomTabType("POST", 0, "post");
    public static final RoomTabType H5 = new RoomTabType("H5", 1, "h5");

    private static final /* synthetic */ RoomTabType[] $values() {
        return new RoomTabType[]{POST, H5};
    }

    static {
        RoomTabType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomTabType(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<RoomTabType> getEntries() {
        return $ENTRIES;
    }

    public static RoomTabType valueOf(String str) {
        return (RoomTabType) Enum.valueOf(RoomTabType.class, str);
    }

    public static RoomTabType[] values() {
        return (RoomTabType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
