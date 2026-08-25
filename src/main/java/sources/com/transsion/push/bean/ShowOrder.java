package com.transsion.push.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/push/bean/ShowOrder;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT", "LAST", "NEXT", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ShowOrder {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShowOrder[] $VALUES;
    public static final ShowOrder CURRENT = new ShowOrder("CURRENT", 0);
    public static final ShowOrder LAST = new ShowOrder("LAST", 1);
    public static final ShowOrder NEXT = new ShowOrder("NEXT", 2);

    private static final /* synthetic */ ShowOrder[] $values() {
        return new ShowOrder[]{CURRENT, LAST, NEXT};
    }

    static {
        ShowOrder[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ShowOrder(String str, int i) {
    }

    public static EnumEntries<ShowOrder> getEntries() {
        return $ENTRIES;
    }

    public static ShowOrder valueOf(String str) {
        return (ShowOrder) Enum.valueOf(ShowOrder.class, str);
    }

    public static ShowOrder[] values() {
        return (ShowOrder[]) $VALUES.clone();
    }
}
