package com.transsion.push.bean;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/transsion/push/bean/PushType;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LOCAL_PUSH", "LIKE_POST", "LIKE_COMMENT", "PERMANENT", "COMMENT", "JOIN_ROOM", "ROOM_POST", "CUSTOMIZE", "ROOM_TOP", "ROOM_PUSH", "T_PUSH", "SUBJECT_SEEKING", "PERMANENT_PUSH", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PushType[] $VALUES;
    private final String type;
    public static final PushType LOCAL_PUSH = new PushType("LOCAL_PUSH", 0, "LocalPush");
    public static final PushType LIKE_POST = new PushType("LIKE_POST", 1, "0");
    public static final PushType LIKE_COMMENT = new PushType("LIKE_COMMENT", 2, MsgStyle.CUSTOM_LEFT_PIC);
    public static final PushType PERMANENT = new PushType("PERMANENT", 3, "2");
    public static final PushType COMMENT = new PushType("COMMENT", 4, MsgStyle.NATIVE_STANDARD);
    public static final PushType JOIN_ROOM = new PushType("JOIN_ROOM", 5, MsgStyle.CUSTOM_BUTTON);
    public static final PushType ROOM_POST = new PushType("ROOM_POST", 6, MsgStyle.CUSTOM_LEFT_PIC_EMOJI);
    public static final PushType CUSTOMIZE = new PushType("CUSTOMIZE", 7, "6");
    public static final PushType ROOM_TOP = new PushType("ROOM_TOP", 8, "7");
    public static final PushType ROOM_PUSH = new PushType("ROOM_PUSH", 9, "8");
    public static final PushType T_PUSH = new PushType("T_PUSH", 10, "9");
    public static final PushType SUBJECT_SEEKING = new PushType("SUBJECT_SEEKING", 11, "10");
    public static final PushType PERMANENT_PUSH = new PushType("PERMANENT_PUSH", 12, "11");

    private static final /* synthetic */ PushType[] $values() {
        return new PushType[]{LOCAL_PUSH, LIKE_POST, LIKE_COMMENT, PERMANENT, COMMENT, JOIN_ROOM, ROOM_POST, CUSTOMIZE, ROOM_TOP, ROOM_PUSH, T_PUSH, SUBJECT_SEEKING, PERMANENT_PUSH};
    }

    static {
        PushType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PushType(String str, int i, String str2) {
        this.type = str2;
    }

    public static EnumEntries<PushType> getEntries() {
        return $ENTRIES;
    }

    public static PushType valueOf(String str) {
        return (PushType) Enum.valueOf(PushType.class, str);
    }

    public static PushType[] values() {
        return (PushType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
