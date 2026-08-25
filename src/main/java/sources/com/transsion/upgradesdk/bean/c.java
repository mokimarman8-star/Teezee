package com.transsion.upgradesdk.bean;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c b;
    public static final c c;
    public static final c d;
    public static final /* synthetic */ c[] e;
    public final int a;

    static {
        c cVar = new c("STATUS_DEFAULT", 0, 0);
        b = cVar;
        c cVar2 = new c("DEFAULT", 1, 1);
        c = cVar2;
        c cVar3 = new c("CUSTOM", 2, 2);
        d = cVar3;
        c[] cVarArr = {cVar, cVar2, cVar3};
        e = cVarArr;
        EnumEntriesKt.a(cVarArr);
    }

    public c(String str, int i, int i2) {
        this.a = i2;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) e.clone();
    }
}
