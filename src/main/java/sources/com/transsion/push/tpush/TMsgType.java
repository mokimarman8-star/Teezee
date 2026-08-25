package com.transsion.push.tpush;

import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.search.bean.HotRankItem;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/transsion/push/tpush/TMsgType;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LikePost", "Follow", "LikeComment", "JoinGroup", "GroupPost", "Customize", "GroupPostTop", HotRankItem.CATE_GROUP, "Manual", "SubjectSeeking", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TMsgType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TMsgType[] $VALUES;
    private final String type;
    public static final TMsgType LikePost = new TMsgType("LikePost", 0, MsgStyle.CUSTOM_LEFT_PIC);
    public static final TMsgType Follow = new TMsgType("Follow", 1, "2");
    public static final TMsgType LikeComment = new TMsgType("LikeComment", 2, MsgStyle.NATIVE_STANDARD);
    public static final TMsgType JoinGroup = new TMsgType("JoinGroup", 3, MsgStyle.CUSTOM_BUTTON);
    public static final TMsgType GroupPost = new TMsgType("GroupPost", 4, MsgStyle.CUSTOM_LEFT_PIC_EMOJI);
    public static final TMsgType Customize = new TMsgType("Customize", 5, "6");
    public static final TMsgType GroupPostTop = new TMsgType("GroupPostTop", 6, "7");
    public static final TMsgType Group = new TMsgType(HotRankItem.CATE_GROUP, 7, "8");
    public static final TMsgType Manual = new TMsgType("Manual", 8, "9");
    public static final TMsgType SubjectSeeking = new TMsgType("SubjectSeeking", 9, "10");

    private static final /* synthetic */ TMsgType[] $values() {
        return new TMsgType[]{LikePost, Follow, LikeComment, JoinGroup, GroupPost, Customize, GroupPostTop, Group, Manual, SubjectSeeking};
    }

    static {
        TMsgType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private TMsgType(String str, int i, String str2) {
        this.type = str2;
    }

    public static EnumEntries<TMsgType> getEntries() {
        return $ENTRIES;
    }

    public static TMsgType valueOf(String str) {
        return (TMsgType) Enum.valueOf(TMsgType.class, str);
    }

    public static TMsgType[] values() {
        return (TMsgType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
