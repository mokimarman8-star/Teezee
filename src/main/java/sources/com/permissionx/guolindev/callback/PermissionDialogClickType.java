package com.permissionx.guolindev.callback;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/permissionx/guolindev/callback/PermissionDialogClickType;", TtmlNode.ANONYMOUS_REGION_ID, "<init>", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "PermissionX_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class PermissionDialogClickType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionDialogClickType[] $VALUES;
    public static final PermissionDialogClickType POSITIVE = new PermissionDialogClickType("POSITIVE", 0);
    public static final PermissionDialogClickType NEGATIVE = new PermissionDialogClickType("NEGATIVE", 1);

    private static final /* synthetic */ PermissionDialogClickType[] $values() {
        return new PermissionDialogClickType[]{POSITIVE, NEGATIVE};
    }

    static {
        PermissionDialogClickType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PermissionDialogClickType(String str, int i) {
    }

    public static EnumEntries<PermissionDialogClickType> getEntries() {
        return $ENTRIES;
    }

    public static PermissionDialogClickType valueOf(String str) {
        return (PermissionDialogClickType) Enum.valueOf(PermissionDialogClickType.class, str);
    }

    public static PermissionDialogClickType[] values() {
        return (PermissionDialogClickType[]) $VALUES.clone();
    }
}
