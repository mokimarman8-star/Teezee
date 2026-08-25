package com.transsion.push.bean;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/push/bean/MsgStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNSHOW", "SHOWED", "CLICKED", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MsgStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MsgStatus[] $VALUES;
    public static final MsgStatus UNSHOW = new MsgStatus("UNSHOW", 0);
    public static final MsgStatus SHOWED = new MsgStatus("SHOWED", 1);
    public static final MsgStatus CLICKED = new MsgStatus("CLICKED", 2);

    private static final /* synthetic */ MsgStatus[] $values() {
        return new MsgStatus[]{UNSHOW, SHOWED, CLICKED};
    }

    static {
        MsgStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MsgStatus(String str, int i) {
    }

    public static EnumEntries<MsgStatus> getEntries() {
        return $ENTRIES;
    }

    public static MsgStatus valueOf(String str) {
        return (MsgStatus) Enum.valueOf(MsgStatus.class, str);
    }

    public static MsgStatus[] values() {
        return (MsgStatus[]) $VALUES.clone();
    }
}
