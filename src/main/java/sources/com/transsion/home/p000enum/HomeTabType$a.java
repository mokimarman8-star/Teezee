package com.transsion.home.p000enum;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomeTabType$a {
    private HomeTabType$a() {
    }

    public /* synthetic */ HomeTabType$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final HomeTabType a(String str) {
        Object obj;
        Iterator it = HomeTabType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((HomeTabType) obj).getValue(), str)) {
                break;
            }
        }
        return (HomeTabType) obj;
    }
}
