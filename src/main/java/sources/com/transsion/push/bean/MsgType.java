package com.transsion.push.bean;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/push/bean/MsgType;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LOCAL_PUSH", "DOWNLOAD_PUSH", "PERMANENT", "TOP10_PUSH", "SUBJECT_SEEKING", "ONLINE_JSON_PUSH", "FIREBASE_PUSH", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MsgType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MsgType[] $VALUES;
    private final String type;
    public static final MsgType LOCAL_PUSH = new MsgType("LOCAL_PUSH", 0, MsgStyle.CUSTOM_LEFT_PIC);
    public static final MsgType DOWNLOAD_PUSH = new MsgType("DOWNLOAD_PUSH", 1, MsgStyle.CUSTOM_BUTTON);
    public static final MsgType PERMANENT = new MsgType("PERMANENT", 2, MsgStyle.CUSTOM_LEFT_PIC_EMOJI);
    public static final MsgType TOP10_PUSH = new MsgType("TOP10_PUSH", 3, "6");
    public static final MsgType SUBJECT_SEEKING = new MsgType("SUBJECT_SEEKING", 4, "10");
    public static final MsgType ONLINE_JSON_PUSH = new MsgType("ONLINE_JSON_PUSH", 5, "11");
    public static final MsgType FIREBASE_PUSH = new MsgType("FIREBASE_PUSH", 6, MsgStyle.STYLE_HOR_TYPE);

    private static final /* synthetic */ MsgType[] $values() {
        return new MsgType[]{LOCAL_PUSH, DOWNLOAD_PUSH, PERMANENT, TOP10_PUSH, SUBJECT_SEEKING, ONLINE_JSON_PUSH, FIREBASE_PUSH};
    }

    static {
        MsgType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MsgType(String str, int i, String str2) {
        this.type = str2;
    }

    public static EnumEntries<MsgType> getEntries() {
        return $ENTRIES;
    }

    public static MsgType valueOf(String str) {
        return (MsgType) Enum.valueOf(MsgType.class, str);
    }

    public static MsgType[] values() {
        return (MsgType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
